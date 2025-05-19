# CI / CD

**Q1.** C'est quoi Devops ?

**R1.**

DevOps est une culture, une méthodologie et un ensemble de pratiques qui visent à unifier le développement (Dev) et les opérations (Ops) pour livrer des logiciels plus rapidement, plus souvent, et avec une meilleure qualité.

**Q2.** C'est quoi les 8 étapes du cycle DevOps ?

**R2.**

Plan → Develop → Build → Test → Release → Deploy → Operate → Monitor

| Étape             | Description                                                                        |
|-------------------|------------------------------------------------------------------------------------|
| 🔹 **1. Plan**    | Planification des nouvelles fonctionnalités ou corrections (Agile, backlog, Jira…) |
| 🔹 **2. Develop** | Écriture du code source par les développeurs (Git, IDE, etc.)                      |
| 🔹 **3. Build**   | Compilation, packaging, création d’artefacts (Maven, Gradle, Docker…)              |
| 🔹 **4. Test**    | Tests unitaires, d’intégration, de performance (JUnit, Selenium, Postman…)         |
| 🔹 **5. Release** | Validation finale avant déploiement (approbation manuelle ou auto)                 |
| 🔹 **6. Deploy**  | Déploiement sur les environnements (Ansible, Kubernetes, Jenkins, Terraform…)      |
| 🔹 **7. Operate** | Mise en production, gestion des systèmes et ressources                             |
| 🔹 **8. Monitor** | Surveillance des performances et des erreurs (Grafana, Prometheus, ELK…)           |


**Q1.** c'est quoi CI CD ?

**R1.**
🔹 1. CI = Continuous Integration (Intégration Continue)
- Chaque fois qu’un développeur pousse du code :
  - Le code est compilé/buildé
  - Les tests s’exécutent automatiquement
  - On   vérifie la qualité du code
- Objectif : détecter les bugs le plus tôt possible

Exemple : Un commit déclenche Jenkins/GitLab CI, qui lance les tests JUnit et génère un JAR.

🔹 2. CD = Continuous Delivery / Deployment
- Continuous Delivery : le code est prêt à être déployé manuellement (approbation). 
- Continuous Deployment : le déploiement est fait automatiquement après les tests.

Exemple : Après que le code soit validé, il est automatiquement déployé sur un serveur staging ou production (EC2, Kubernetes, etc.).


**Q1.** C'est quoi pipeline ?

**R1.**

Un pipeline est une suite d'étapes automatisées qui permettent de construire, tester, et déployer une application de manière continue.



**Q1** Les tests sélénium et cucumber, comment tu les appelleras ces tests-là ? ils portent un nom.

**R1** Tests End-to-End (E2E) : Ces tests simulent le comportement réel d’un utilisateur : clics, navigation, remplissage de formulaires…

**Q1** On a parlé de test d’intégration, des tests end to end et tests unitaires, généralement tous les tests qui existent on les place dans une pyramide de test, si je te demande là de me donner la pyramide avec les tests unitaires, d’intégration et end to end, lesquels tu mets en bas, en haut et pourquoi? (Il y a un schéma sur internet qui explique ça: question très importante)

**R1** 

        🔺 Haut : Tests End-to-End (E2E)
        ▯▯    Peu nombreux, lents, coûteux à maintenir

        🔲 Milieu : Tests d’intégration
        ▯▯▯   Moyen en quantité, testent l’interaction entre composants

        🔻 Base : Tests unitaires
        ▯▯▯▯▯ Nombreux, rapides, isolés

🟢 Base – Tests unitaires
- But : Tester une classe ou une méthode isolée. 
- Pourquoi en bas ? Parce qu’ils sont :
  - Très rapides à exécuter
  - Faciles à écrire et à maintenir 
  - Exécutés très souvent (CI/CD, à chaque push)
- Exemple : Tester une méthode calculateTotal() dans un service.

🟡 Milieu – Tests d’intégration
- But : Tester l’interaction entre plusieurs composants (services + DB, contrôleurs + services…)
- Pourquoi au milieu ? 
  - Plus lents que les tests unitaires 
  - Peuvent échouer pour des raisons d’environnement (DB, configuration…)
  - Nécessaires pour vérifier que les composants fonctionnent ensemble

🔴 Sommet – Tests End-to-End (E2E)
- But : Vérifier des parcours complets (comme un utilisateur final). 
- Pourquoi en haut ? 
  - Très lents 
  - Fragiles (peuvent casser pour un changement mineur dans l’UI)
  - Difficiles à maintenir 
  - Mais essentiels pour valider que tout fonctionne de bout en bout

💡 Pourquoi cette forme pyramidale ?
- Car les tests plus on monte, plus ils sont coûteux (temps, complexité). 
- On cherche donc à avoir beaucoup de tests unitaires, quelques tests d’intégration et très peu de tests E2E. 
- Cela garantit un retour rapide, une bonne couverture et une bonne qualité logicielle.

📌 À dire en entretien :
La pyramide des tests est structurée pour optimiser le rapport coût/bénéfice des tests.
Je mets les tests unitaires à la base car ils sont rapides et isolés.
Les tests d’intégration au milieu, car ils testent les interactions entre composants.
Et les tests E2E tout en haut, car ils testent l’application dans son ensemble mais sont coûteux à exécuter et à maintenir.