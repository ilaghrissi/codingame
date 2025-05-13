# Angular

## QCM


** Q1.** Parmi les propositions suivantes, laquelle n'est pas un directive structurelle d'Angular ?

** R1.**
- [ ] ngIf
- [ ] ngFor
- [ ] ngSwitch
- [x] **ngUnless**


** Q2.** Quel outil Angular utilise-t-il par défaut pour effectuer le linting du code TypeScript ?

** R2.**
- [ ] ESLint
- [x] **TSLint**
- [ ] Prettier
- [ ] JSHint

** Q3.** Quel module doit-on importer pour pouvoir utiliser [(ngModel)] ?

** R3.**
- [ ] NgModule
- [ ] BrowserModule
- [x] **InputModule**
- [ ] InputModule


** Q4.** Quel est l'objectif principal du "tree-shaking" dans les applications Angular ?

** R4.**
- [ ] Charger dynamiquement les modules uniquement lorsque cela est
  nécessaire.
- [x] **Supprimer le code JavaScript inutile pendant le processus de build.**
- [ ] Optimiser le chargement de ressources telles que les images et les feuilles de
  style.
- [ ] Convertir le code TypeScript en JavaScript.

** Q5.** Où peut-on généralement trouver les licences de toutes les librairies tierces installées dans un projet
Angular ?

** R5.**
- [ ] Elles ne sont pas stockées dans le projet, afin d'économiser de l'espace
  disque. Elles doivent être récupérées dans le repository de chaque librairie.
- [ ] Toutes les librairies Angular doivent avoir la licence spécifique appelée
  "manifeste Angular". Son texte est publié sur le site officiel d'Angular.
- [ ] Les noms des licences et les liens vers les textes complets sont définis dans le
  fichier package-lock.json . 
- [x] **Le texte complet de chaque licence est stocké dans les fichiers LICENSE.
  txt à l'intérieur de chaque dossier de librairie, dans le répertoire
  node_modules .**


** Q6.** Quelle ligne de commande permet de créer une nouvelle application Angular ?

** R6.**
- [ ] npm create appName
- [ ] ng start appName
- [x] **ng new appName**
- [ ] npm start appName

** Q7.** Quelle Class est ajoutée au niveau d'un formulaire quand celui-ci passe tous les
contrôles de validation ?

** R7.**
- [ ] .ng-dirty
- [x] **.ng-valid** 
- [ ] .ng-pristine
- [ ] .ng-invalid

** Q8.** Parmi les propositions suivantes, laquelle n'est pas une méthode du cycle de vie Angular ?

** R8.**
- [ ] ngOnChanges
- [ ] ngOnDestroy
- [ ] ngAfterViewInit
- [x] **ngContentChange**

** Q9.** Quelle propriété de l'objet Routes permet de définir des routes chargées à la volée (lazy loading) ?

** R7.**
- [ ] route
- [x] **loadChildren**
- [ ] children
- [ ] lazyRoutes


** Q8.**Quelle syntaxe peut-on utiliser pour matcher et traiter les routes non-trouvées ?

** R8.**
- [ ] /
- [ ] '*'
- [ ] &&
- [x] ** 


** Q9.** Qu'arrivera-t-il si on clique plusieurs fois sur le bouton tel que défini à la ligne 6 ?

    import { Component } from '@angular/core';
    
    @Component({
    selector: 'my-app',
    template: `
        <button type="button" (click)="onclick()">Click Me</button>
        <h1 *ngIf="show">
        {{name}}
        </h1>
      `
    })
    export class AppComponent {
    name = 'John Doe';
    show = true;
    
        onClick(){
            this.show = !this.show;
        }
    }       

** R9.**
- [ ] La propriété name est cachée
- [ ] La propriété name est affichée
- [x] **La propriété name est affichée une fois sur deux**
- [ ] La propriété name est effacée

** Q10.**Quelle commande ne fait pas partie de la CLI Angular ?

** R10.**
- [ ] ng deploy
- [x] **ng exit**
- [ ] ng test
- [ ] g lint

** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 


## Question/Réponse

**Q1.**
On considère le composant <app-user> qui a une propriété de sortie appelée updated.

Ligne 7, par quoi doint-on remplacer ???? pour obtenir la donnée à jour de la
propriété updated ?

import { Component } from '@angular/core';

    @Component({
    selector: 'my-app',
    template: `
        <app-user [user]="user"
                ????="onUpdated($event)">
        </app-user>		
      `
    })
    export class AppComponent {
    user = {
    name: 'John Doe',
    mail: 'johndoe@gmail.com',
    age: 35
    }
    
    onUpdated($e) {}
    
    }

**R1.**

(updated)

**R2.** Quelle directive built-in Angular peut-on utiliser pour remplacer ???? à la ligne 6 pour
d'appliquer la classe blue de manière conditionnelle ?

    import { Component } from '@angular/core';

    @Component({
    selector: 'my-app',
    template: `
        <h1 ????="{blue: highlight}">
            {{name}}
        </h1>
      `,
    styles: [`
       .blue {
         color: blue
       }
      `
    })
    export class AppComponent {
    name = 'John Doe';
    highlight = true;
    }

**Q2**

[ngClass]

## Algorithms