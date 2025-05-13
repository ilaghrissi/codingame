/*
On vous demande de créer un composant Angular simple nommé CounterComponent ayant
counter-component pour sélecteur.
L'objectif de ce composant est de :
Prendre un message en "input" Lire une valeur d'intervalle saisie par l'utilisateur (entier, en
millisecondes) Envoyer le message en tant qu'événements de manière périodique vers son "output"
Au niveau HTML, le composant est composé d'un champ <input> avec id="intervalInput" et d'un
bouton <button> avec id="intervalSetButton" . L'utilisateur peut modifier l'intervalle en
saisissant une valeur dans le champ puis en cliquant sur le bouton.
Le composant doit avoir un @Input nommé message et un @Output nommé tick . Il doit générer
des événements de type "string" vers tick à intervalle régulier correspondant à la valeur saisie par
l'utilisateur. La chaîne de caractère utilisée pour générer les événements provient de l"input" message .
Le composant doit être capable de gérer les changements du message et les changements de la valeur
de l'intervalle. Notes : Vous devez modifier le template ainsi que la classe du composant. Un bloc de
"Preview" est disponible pour vous permettre de débugguer votre code. Il affiche votre composant cidessous.
Vous pouvez l'ouvrir et le modifier à votre guise. Pour vous aider, ce bloc contient un
composant parent qui manipule le composant que vous devez créer (affichage d'un compteur à côté du
message) Ce bloc de "Preview" n'est pas pris en compte dans le calcul du score de votre code.

*/

import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'counter-component',
  template: `
    <input id="intervalInput" [(ngModel)]="interval" />
    <button id="intervalSetButton" (click)="setInterval()">Set interval</button>
  `,
})
export class CounterComponent {
  @Input() message: string;
  @Output() tick: EventEmitter<string> = new EventEmitter<string>();

  interval: number = 1000;
  intervalId: any;

  constructor() {}

  ngOnInit() {
    this.startTimer();
  }

  ngOnChanges(changes: any) {
    if (changes.interval) {
      this.restartTimer();
    }
  }

  setInterval() {
    this.restartTimer();
  }

  private startTimer() {
    this.intervalId = setInterval(() => {
      this.tick.emit(this.message);
    }, this.interval);
  }

  private restartTimer() {
    clearInterval(this.intervalId);
    this.startTimer();
  }
}