/**
QUESTION :
On vous demande de créer un composant Angular nommé DisplayComponent et ayant display-
component pour sélecteur.

Il doit utiliser le composant VoterComponent (sélecteur = voter-component ) dont le code est fourni.
DisplayComponent a 3 champs public nommés question , yesAnswer et noAnswer . Ils
représentent une question posée à l'utilisateur et les choix de réponse possibles affichés dans
VoterComponent .
DisplayComponent doit utiliser VoterComponent en tant qu'enfant et doit lui passer question ,
yesAnswer et noAnswer en entrée.
Quand l'utilisateur vote, VoterComponent créé un événement de type boolean vers un @Output
nommé output .
Vous devez afficher le résultat du vote dans DisplayComponent dans un <div> avec id=lastVote :
si output est vrai, alors on affiche la valeur de yesAnswer , sinon on affiche la valeur de noAnswer .
Notes : Un bloc de "Preview" est disponible pour vous permettre de débugguer votre code. Il affiche
votre composant ci-dessous. Vous pouvez l'ouvrir et le modifier à votre guise. Ce bloc de "Preview" n'est
pas pris en compte dans le calcul du score de votre code.
*/

// Angular 15.x code
import { Component, Input, NgModule, Output, EventEmitter } from '@angular/core';

@Component({
  selector:'display-component',
  template: `
  <voter-component
    [question]="question"
    [yesAnswer]="yesAnswer"
    [noAnswer]="noAnswer"
    (output)="handleVote($event)">
  </voter-component>
  <div id="lastVote">{{ voteResult === true ? 'Yes' : voteResult === false ? 'No' : '' }}</div>
  `
})
export class DisplayComponent {
  public question = "Too easy?"
  public yesAnswer = "Yes";
  public noAnswer = "No";
  public voteResult: boolean | null = null;

  public handleVote(vote: boolean): void {
    this.voteResult = vote;
  }
}

// VoterComponent: do not change
@Component({
  selector:'voter-component',
  template: `
  {{question}}
  <button (click)="vote(true)">{{yesAnswer}}</button>
  <button (click)="vote(false)">{{noAnswer}}</button>
  `
})
export class VoterComponent {
  @Input()
  public question: string;

  @Input()
  public yesAnswer: string;

  @Input()
  public noAnswer: string;

  @Output()
  public output = new EventEmitter<boolean>();

  public vote(vote: boolean): void {
    this.output.emit(vote);
  }
}

// #region Preview

@Component({
  template: `<display-component></display-component>`
})
export class PreviewComponent { }
// #endregion Preview

// #region Module declaration - Do not Change
@NgModule({
  declarations: [PreviewComponent, DisplayComponent, VoterComponent],
  entryComponents: [PreviewComponent]
})
export class PreviewModule { }
// #endregion Module declaration

