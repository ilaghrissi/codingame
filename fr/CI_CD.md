# CI/CD

## QCM
**Q1.** Les Pipelines Jenkins sont écrtis dans un DSL, À partir de quel language de programmation ce DSL a été construit ?
- [ ] Java
- [ ] Bash
- [ ] Python
- [ ] Javascript
- [x] **Groovy**

**Q2.** Les artéfacts Maven sont référencés par des coordonnées.
<br/>
Parmi les propositions suivantes, laquelle n'est pas une coordonnées valide ?
- [ ] version
- [ ] groupId
- [x] **groupName**
- [ ] artifactId

**Q3.** Quelle est la structure de dossier correcte pour une Shared Libray Jenkins ?
- [x]  **A -**

        (root)
        +- src                     # Groovy source files
        |   +- com
        |       +- example
        |           +- Automaton.groovy  # for com.example.Automaton class
        +- vars
        |   +- sequence.groovy          # for global 'sequence' variable
        |   +- sequence.txt             # help for 'sequence' variable
        +- resources               # resource files (external libraries only)
        |   +- com
        |       +- example
        |           +- descriptor.json    # static helper data for com.example.Descriptor

- [ ] B -

        (root)
        +- src                     # Groovy source files
        |   +- groovy
        |           +- Automaton.groovy  # for Automaton class
        |   +- resources               # resource files (external libraries only)
        |           +- descriptor.json    # static helper data for Automaton.groovy
        |           +- sequence.groovy    # for global 'sequence' variable
        |           +- sequence.txt    # help for 'sequence' variable

- [ ] C - 

        (root)
        +- src                     # Groovy source files
        |           +- Automaton.groovy  # for Automaton class
        |           +- descriptor.json    # static helper data for Automaton.groovy
        |   +- resources               # resource files (external libraries only)
        |           +- sequence.groovy    # for global 'sequence' variable
        |           +- sequence.txt    # help for 'sequence' variable
        

**Q4.** Qu'est-ce qu'un "Downstream Project" dans Jenkins ?
- [x] **Un projet déclenché comme sous-partie de l'exécution d'un autre Projet.**
- [ ] Le dernier Projet dans un Pipeline mutli-étapes
- [ ] Dans un Projet Multi-branche, le "Downstream Project" est celui connecté à la branche master
- [ ] Un projet dans la file d'attente d'exécution

**Q5.** Un projet Jenkins a l'option "Build periodically" activée avec l'expression
"H H 5,15 2-12 *".
<br/>
Comment est-ce que ce Projet va être planifié ?
- [ ] Une fois par jour, tous les jours entre le 5 et le 15 du mois, tous les mois à part Janvier
- [ ] Une fois par heure les 5 et 15 du mois, tous les mois à part Janvier
- [ ] Une fois par heure, tous les jours entre le 5 et le 15 du mois, tous les mois à part Janvier
- [x] **Une fois par jours les 5 et 15 du mois, tous les mois à part Janvier**

**Q6.** Jenkins est un framework open source les plus populaire pour l'intégration Continue (CI) et le Déploiement Continu (CD).
<br/>
Quelles sont les définitions de ces termes ?
- [ ] CD: la pratique en ingénieurie logicielle qui assure que le code soit bien propagé à toutes les cibles SCM (telles que Git)
- [x] **CD: une extension de la CI où l'on déploie automatiquement les artefacts compilés et testés par la CI**
- [x] **CI: la pratique en ingénieurie logicielle où les équipes compilent et intègrent automatiquement leur travail**
- [ ] CI: la pratique en ingénieurie logicielle où les APIs externes intégrées par le produit sont testées continuellement pour s'assurer qu'elles sont en bonne santé

**Q7.** Examinez les deux extraits de code suivants et sélectionnez la proposition correcte :
       
     // Code A:
        node("master") {
        echo "Hello world"
        }
        
        // Code B:
        pipeline {
        agent any
        
            stages {
                stage("run") {
                    steps {
                        echo "Hello world"
                    }
                }
            }
        }

- [ ] Le code A et le code B sont déclaratifs
- [x] **Le code A est scripté, le code B est déclaratif**
- [ ] Le code A et le code B sont scriptés
- [ ] Le code A est déclaratif, le code B est scripté

**Q8.** Qu'est-ce qu'une "View" dans Jenkins ?
- [x] **Une façon d'organiser et regrouper des projets Jenkins**
- [ ] Un affichage configurable pour un projet qui s'exécute
- [ ] Une page qui affiche tous les Builds pour un projet en particulier
- [ ] La principale page de l'interface pour afficher tous les projets
- [ ] Un type de pipeline spécial qui permet d'enregistrer une vidéo de l'exécution

**Q9.** La configuration de Jenkins contient une console de script:
Script Console (Executes arbitry script for administration/trouble-shooting/diagnostics.)
<br/>
A quoi sert cette console ?
- [ ] Exécuter du code Javascript
- [ ] Ouvrir un terminal bash de l'instance Master de Jenkins
- [x] **Exécuter du code groovy**
- [ ] Excécutez du code Java



** Q10.** Qu'arrive-t-il lorsque le nombre maximum d'executors est atteint par un Agent Jenkins ?

** R10.**
- [x] **Le build sera placé dans la queue, en attente du prochain executor
  disponible**
- [ ] Le build sera perdu
- [ ] Le Projet sera exécuté dans un workspace vide
- [ ] Jenkins va émettre un avertissement pour indiquer que le nombre maximum
  d'exécutors a été atteint


** Q11.** Qu'est-ce qu'un « Upstream Project » dans Jenkins ?

** R11.**
- [x] **Un projet qui déclenche d'exécution d'un autre projet pendant son
  exécution**
- [ ] Un projet dans la file d'attente d'exécution
- [ ] Dans un projet multi-branche, le « Upstream Project » est celui connecté à la
  branche master
- [ ] Le premier projet dans un Pipeline multi-étapes

** Q12.** Parmi les propositions suivantes, quelle ligne de commande permet de publier des artéfacts maven sur
Nexus ?

** R12.**
- [x] **mvn clean package deploy**
- [ ] mvn clean package install
- [ ] mvn clean package compile --Ddeploy=nexus
- [ ] mvn clean package install --Ddeploy=nexus
- [ ] mvn clean package push

** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 
## Question/Réponse

**Q1.** Les Pipelines Jenkins peuvent être décrits directement depuis l'interface web, mais
ils peuvent aussi être décrits dans des fichiers.
<br/>
Quel est le nom du fichier qui permet de décrire un Pipeline ?

**R1.**
Jenkinsfile

**Q2.** Quelle est la variable d'envrionnement qui contient le chemin du dossier principal de Jenkins ?
**R2.**
JENKINS_HOME
