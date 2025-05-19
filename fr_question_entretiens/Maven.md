# Maven

**Q1** C'est quoi les phases Maven 

**R1**

| Phase        | Description                                                                 |
|--------------|-----------------------------------------------------------------------------|
| **validate** | Vérifie que le projet est correct (structure, dépendances).                 |
| **compile**  | Compile le code source Java (`src/main/java`).                              |
| **test**     | Compile et exécute les tests unitaires (`src/test/java`) avec JUnit/TestNG. |
| **package**  | Emballe le code compilé (JAR, WAR, etc.).                                   |
| **verify**   | Vérifie que tout est conforme (tests d’intégration, qualité, etc.).         |
| **install**  | Installe le package dans le repository local (`~/.m2`).                     |
| **deploy**   | Déploie le package dans un repository distant (pour partage).               |


**Q1** C'est quoi les scopes de dépendences ?

**R1**

✅ Les scopes de dépendance dans Maven
Le scope détermine dans quel contexte une dépendance est disponible (compilation, test, runtime,etc.).

| Scope                      | Description                                                                                                    |
|----------------------------|----------------------------------------------------------------------------------------------------------------|
| **compile** *(par défaut)* | Disponible à la compilation, à l'exécution, et pour les dépendances transitives.                               |
| **provided**               | Disponible à la compilation, mais **pas incluse** dans le package (ex. : Servlet API, fournie par le serveur). |
| **runtime**                | **Pas disponible à la compilation**, mais **nécessaire à l'exécution** (ex. : drivers JDBC).                   |
| **test**                   | Disponible **uniquement pour les tests** (JUnit, Mockito, etc.).                                               |
| **system**                 | Comme `provided`, mais nécessite un chemin absolu vers un `.jar`. Rarement utilisé.                            |
| **import** *(pour BOM)*    | Utilisé avec `<dependencyManagement>` pour importer des dépendances d'un BOM (Bill of Materials).              |

