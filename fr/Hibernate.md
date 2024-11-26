# Hibernate / Data access

## Question/Réponse

**Q1.** Comment s'appelle l'API hibernate qui permet de sauvegarder historique des opérations(ajout, modification, suppression) sur les entités
**R1.**:
l'API Envers

**Q2.** Quelle est la différence entre JPA et Hibernate ?
**R2.**:
- JPA (Java Persistence API) est une spécification standard pour le mapping objet-relationnel. Elle définit des interfaces et annotations pour gérer la persistance.
- Hibernate est une implémentation de JPA. Il fournit des fonctionnalités supplémentaires comme le cache de second niveau, les critères dynamiques, et des outils pour migrer les schémas de base de données.

**Q3.** c'est quoi les problèmes avec les ORM ?
- Object-Relational Impedance Mismatch : Ce problème se produit parce qu'il existe une différence fondamentale entre la manière dont les données sont représentées dans les bases de données relationnelles (tables, colonnes, lignes) et la manière dont elles sont représentées dans les objets orientés objet (objets, classes, attributs).Voici quelques exemples
  - Types de données : 
  - Relations entre les entités :
  - Héritage :
  - Modèle de données complexe :
  - Gestion des identifiants :
  - Performances et requêtes complexes :
- N+1 Query Problem : Cela se produit lorsque l'ORM génère une requête SQL pour récupérer une entité, puis une requête supplémentaire pour chaque élément associé, entraînant un grand nombre de requêtes inutiles et donc des problèmes de performance.
