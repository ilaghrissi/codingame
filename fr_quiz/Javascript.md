# Javascript

## QCM

** Q1.** en javascript
    
    var a = "5"
    var b = "5"
    var sum = a+b;

Quelle est la valeur de sum ?

** R1.**
- [ ] 10
- [x] **"55"**
- [ ] "a+b"

** Q2.**L'énouncé suivant est-il vrai ou faux ?

"Utiliser 'use strict' dans les modules ES6 est inutile car
les modules ES6 ont une exécution en mode strict par défaut."

** R2.**
- [ ] Vrai
- [x] **Faux**

** Q3.** Qu'affiche ce code Javascript ?

    a['b'] = 'hello world';
    alert(a->b);

** R3.**
- [ ] a->helloworld
- [x] **Une erreur de syntaxe**
- [ ] hello world
- [ ] 0

** Q4.**Considérer le code suivant :

    //File: event.js
    const defaultEvent = "JS Meetup";
    const eventDay = "Wednesday";

    function getEventDay(){
    return `${defaultEvent} occurs every ${eventDay}`;
    }

    export {defaultEvent as eventName};

Quelles options représentent des imports valides ?
Sélectionner toutes les bonnes réponses.

** R4.**
- [x] **import {eventName} from "event.js"**
- [x] **import {eventDay} from "event.js"**
- [ ] import {defaultEvent, eventName} from "event.js"
- [ ] import * as Event from "event.js"

** Q5.**Considérer le code suivant :

    const obj = {
    x: 10,
    y: 12,
    sum: () => this.x + this.y,
    multiply: function() {
    return this.x * this.y;
    }
    };
    
    function execute (){
    console.log(obj.sum());
    console.log(obj.multiply());
    }
    
    execute();

** R5.**
- [ ] obj.sum() retourne 22,
  obj.multiply() retourne NaN
- obj.sum() retourne 22,
  obj.multiply() retourne 120
- [ ] obj.sum() retourne NaN,
  obj.multiply() retourne NaN
- [x] obj.sum() retourne NaN,
  obj.multiply() retourne 120

** Q6.** Laquelle des options suivantes n'est pas un type valide en Javascript ?

** R6.**
- [ ] object
- [ ] number
- [ ] symbol
- [x] array
- [ ] string

** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 
## Question/Réponse

## Algorithms