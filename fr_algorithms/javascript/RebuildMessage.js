/*
On vous demande de reconstituer un message qui a été coupé en morceaux.

Implémenter la fonction rebuildMessage(parts) qui reçoit en paramètre un tableau
de chaînes de caractères.

Chaque élément de parts a été découpé à partir d'un seul et même message. Vous
devez reconstituer le message original, à partir des règles suivantes :
	* le message original commence toujours par le caractère A et finit par le caractère z
	* deux parties peuvent être rattachées lorsque le dernier caractère de la
	  première partie est égal au premier caractère de la deuxième partie.
	* lors de la combinaison de deux parties, on se concerve qu'un exemplaire du
	  caractère de liaison(par exemple "A---b" + "b---Z" donne "A---b---Z" et non
      "A---bb---Z")

rebuildMessage doit retourner le message reconstitué.

Contraintes :
	* chaque premier caractère est unique parmi parts
	* chaque partie contient au moins 2 caractères et au plus 1000 caractères
	* la solution existe forcément et est unique
	* parts n'est jamais null, contient au moins un élément et au plus 1000 éléments

function rebuildMessage(parts){
	return '';
}
*/


function rebuildMessage(parts) {
  // Crée un dictionnaire pour stocker les parties en fonction de leur premier caractère
  const partDict = {};
  for (const part of parts) {
    const firstChar = part[0];
    if (!partDict[firstChar]) {
      partDict[firstChar] = [];
    }
    partDict[firstChar].push(part);
  }

  let currentPart = partDict['A'][0]; // Le message commence par 'A'
  let result = currentPart;

  while (true) {
    const lastChar = currentPart[currentPart.length - 1];
    const nextPart = partDict[lastChar] && partDict[lastChar].shift();

    if (nextPart) {
      // Supprime le caractère de liaison s'il y en a un à la fin de la première partie
      const linkChar = nextPart[0];
      if (linkChar === lastChar) {
        result += nextPart.slice(1);
      } else {
        result += nextPart;
      }
      currentPart = nextPart;
    } else {
      // Aucune partie ne peut être ajoutée, on a terminé
      if (lastChar === 'z') {
        return result;
      } else {
        // Il manque une partie pour compléter le message
        return '';
      }
    }
  }
}

// Exemple d'utilisation :
const parts = ['A---b', 'b---Z', 'Z---x', 'x---y', 'y---z'];
const message = rebuildMessage(parts);
console.log(message); // Affiche "A---b---Z---x---y---z"
