
#Angular

**Q1.** Donne moi exemples de communication Parent <--> Enfant

- Communication Parent -> Enfant ?

1. Composant enfant (child.component.ts)


        import { Component, Input } from '@angular/core';

        @Component({
        selector: 'app-child',
        template: `
            <p>Message reçu du parent : {{ message }}</p>
          `
        })
        export class ChildComponent {
        @Input() message!: string;
        }

2. Composant parent (parent.component.ts)


        import { Component } from '@angular/core';

        @Component({
        selector: 'app-parent',
        template: `
            <h2>Composant Parent</h2>
            <app-child [message]="parentMessage"></app-child>
          `
        })
        export class ParentComponent {
        parentMessage = 'Bonjour de la part du parent !';
        }

- Communication Enfant -> Parent ?

1. Composant enfant (child.component.ts)


        import { Component, Output, EventEmitter } from '@angular/core';

        @Component({
        selector: 'app-child',
        template: `
            <button (click)="sendMessage()">Envoyer un message au parent</button>
          `
        })
        export class ChildComponent {
        @Output() messageToParent = new EventEmitter<string>();
        
        sendMessage() {
            this.messageToParent.emit('Bonjour parent, message de l’enfant !');
        }
        }

2. Composant parent (parent.component.ts)


        import { Component } from '@angular/core';

        @Component({
        selector: 'app-parent',
        template: `
            <h2>Composant Parent</h2>
            <app-child (messageToParent)="receiveMessage($event)"></app-child>
            <p>Message reçu de l’enfant : {{ childMessage }}</p>
          `
        })
        export class ParentComponent {
        childMessage = '';
        
        receiveMessage(message: string) {
            this.childMessage = message;
        }
        }

- Communication frère-frère (via un service partagé) ?


        @Injectable({ providedIn: 'root' })
        export class CommunicationService {
        private messageSource = new Subject<string>();
        message$ = this.messageSource.asObservable();
        
        sendMessage(message: string) {
        this.messageSource.next(message);
        }
        }

1. Dans le composant A (émetteur) :


        constructor(private commService: CommunicationService) {}
        
        someMethod() {
        this.commService.sendMessage('Message du composant A');
        }

2. Dans le composant B (récepteur) :


        constructor(private commService: CommunicationService) {}

        ngOnInit() {
        this.commService.message$.subscribe(message => {
        console.log('Message reçu:', message);
        });
        }
