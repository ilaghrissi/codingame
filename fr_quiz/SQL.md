# SQL


## QCM

**Q1.**
Pourquoi la requête suivante déclencherait-t-elle une erreur ?

    SELECT
    product_id
    ,product_category_id
    ,order_id
    ,order_id
    FROM
    product p
    JOIN order_product op ON p.product_id = op.product_id

** R2.**
- [ ] Les , ne sont pas au bon endroit
- [ ] order_id apparaît deux fois
- [x] **Les noms de colonnes dans la clause SELECT ne sont pas préfixés par les
  alias des tables correspondantes**
- [ ] INNER JOIN doit être utilisé à la place de JOIN
- [ ] Il n'y a rien d'anormal dans cette requête.

** Q3.** Vous êtes sur le point de concevoir une base de données susceptible d'évoluer dans le futur de manière
significative, avec un nombre important d'utilisateurs.
La base de données sera utilisée par de nombreux départements et services, qui sont très souvent
réorganisés, avec des responsabilités qui passent de l'un à l'autre.
Dans ces conditions, vous savez que vous aurez besoin de transférer des droits d'un utilisateur de la
base de données vers un autre.
Quelle est la meilleure façon de gérer cette situation ?

** R3.**
- [ ] Créez plusieurs utilisateurs pour chaque département, chacun d'entre eux
  disposant d'un droit "atomique". Lorsque ce sera nécessaire, vous
  transférerez les identifiants des utilisateurs appropriés d'un département à
  l'autre.
- [ ] Il existe des scripts shell ou des procédures stockées qui peuvent répertorier
  tous les droits d'un utilisateur et les transférer à un autre.
- [x] **Ne donnez des droits qu'aux rôles et non aux utilisateurs. Lorsque ce sera
  nécessaire, vous transférerez les rôles requis d'un utilisateur à un autre.**
- [ ] La plupart des moteurs de base de données intègrent des fonctions toutes
  faites, permettant de transférer des droits entre utilisateurs.



** Q4.** Vous devez importer un fichier CSV dans une table contenant deux champs entiers et deux champs
texte ( VARCHAR ).
Les champs textes sont délimités par des guillemets doubles, car ils peuvent contenir des sauts de ligne.
Ces guillemets doubles permettent de différencier les sauts de ligne à l'intérieur d'un champ et les sauts
de ligne terminant un enregistrement CSV.
Voici un exemple de fichier :

    0,95,"Jill","This article is great.
    I loved it.
    Cheers"
    1,23,"Bob","A bad article"

Comment pourriez-vous importer ces données dans la table, y compris les sauts de ligne à l'intérieur
des champs?

** R4.**
- [ ] Ce n'est pas un fichier CSV valide. Il doit être prétraité avec un script
  spécifique, pour remplacer les sauts de ligne entre guillemets par des
  caractères \n .
- [ ] C'est un fichier CSV valide, mais il ne peut pas être importé, car il n'est pas
  possible de mettre des sauts de ligne dans les champs VARCHAR .
- [ ] Ajoutez des crochets [] et des virgules , aux endroits appropriés pour
  obtenir un fichier json valide. Ensuite, importez-le en utilisant les commandes
  d'importation json, qui sont disponibles dans tous les moteurs de base de
  données courants.
- [x] **Ce fichier peut être importé à l'aide d'une commande intégrée au moteur
  de base de données. Certains paramètres indiquant comment gérer les
  doubles guillemets devront être spécifiés.**


** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 
## Question/Réponse