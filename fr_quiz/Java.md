# Java

## QCM

**Q1.** Examinez la relation entre deux entités ci-dessous : 

    @Entity
    public class User {
    @XXX
    private Address address;
    
    // getters and setters ...
    }
    
    @Entity
    public class Address {
    @ManyToOne
    private User user;
    
    // getters and setters ...
    }

Quelle annotation devrait remplacer @XXX pour que la relation soit bidirectionnelle ?
- [x] **@OneToMany(mappedBy = "user")**
- [ ] @OneToMany(mappingRelationShipOwner = Address.class)
- [ ] @OneToMany(mappedBy = useParentId = true)
- [ ] @OneToMany(mappingRelationShipOwner = User.class)


**Q2.** Quel code de configuration Spring Boot remplacerait la ligne de commentaire //XXX
pour permettre aux utilisateurs non authentifiés d'accéder à la racine des ressources (/)

    public class WebSecurityConfig extends WebSecurityConfiguerAdapter {
    
        @Override
        protectec void configure(HttpSecurity http) throws Exception {
        http.authorizeRequest(a -> a
        // XXX
        .anyRequest().authenicated()
        )
        }
    }
- [ ] .allowRoot()
- [x] **.antMatchers("/").permitAll()**
- [ ] .allowRessource("/")
- [ ] .anyRequest("/").unauthenticated()

**Q3.** Quels sont les moyens possibles de réaliser l'injection de dépendances (dependency injection) à l'aide de Spring ?
Sélectionner toutes les bonnes réponses.
- [x] **Injection de constructeur**
- [x] **Injection de setter**
- [ ] Injection d'interface
- [ ] injection de bean

**Q4.** Une classe abstraite peut contenir des méthodes concrètes.
- [x] **Vrai**
- [ ] Faux

**Q5.** public interface A extends B,C,D {} 
<br/>
Cette interface est correcte si B, C, D sont également des interfaces.
- [x] **Vrai**
- [ ] Faux

**Q6.** Que devez-vous utiliser pour exécuter un code une seule fois, au moment où la classe est chargée ?
- [ ] Une méthode
- [ ] Un constructeur
- [x] **Un bloc statique**
- [ ] Un bloc d'instance

**Q7.**

    ArrayList l = new ArrayList(2);
    l.add(1);
    l.add(1);
    l.add(1);
- [ ] Ce code lève un exception
- [x] **3**
- [ ] 2
- [ ] 1
- [ ] 5

**Q8.** Dans une HashMap, une classe variable(mutable) est utilisée comme clef.
<br/>
Quelle proposition est vraie ?
- [x] **Une HashMap peut être peu fiable lorsque l'on utilise des clefs variables car leurs valeurs hash peut dépendre de l'état de l'objet clef**
- [ ] Utiliser des clefs variables peut poser in problème de performance : la HashMap recalcule les valeurs hash des clefs à chaque fois qu'une entrée est recherchée
- [ ] Peu import que la clef soit variable ou immuable (immutable), la HashMap se comporte de la même manière.

**Q9.** Quelles déclarations lambda sont correctes ?
- [x] **Consumer<Integer> print = (Integer x) -> { System.out.println(x); };**
- [ ] Consumer<Integer> print = (int x) -> { System.out.println(x); };
- [x] **Consumer<Integer> print = (x) -> { System.out.println(x); };**
- [ ] Consumer<int> print = (int x) -> { System.out.println(x); };

**Q10.** Au sein d'une relation @OneToOne, @OneToMany, @ManyToOne, @ManyToMany, quelle est la valeur par défaut si la propriété cascade n'est pas définie ?
- [ ] CascadeType.MERGE
- [ ] CascadeType.REMOVE
- [x] **Aucun CascadeType n'est défini**
- [ ] CascadeType.PERSIST
- [ ] CascadeType.ALL

**Q11.** Comment implémenter un schéma d'entité qui permet de gérer une table de joiture avec une colonne supplémentaire ?
- [ ] La relation @ManyToMany permet de le gérer grâce à la propriété ExtraColumn
- [x] **Il faut créer une nouvelle entité qui représentera la table de jointure et utiliser des relations @ManyToOne et @OneToMany**
- [ ] Il faut ajouter de nouvelles méthodes dans les entités qui définissent l'annotation @ManyToMany
- [ ] Il faut utiliser l'annotation @ElementCollection

**Q12.** Quand Hibernate invoque-t-il une méthode d'entité annotée avec @PreUpdate ?
- [ ] Seulement lorsqu'un champ id (annoté avec @Id) a été modifié
- [ ] Seulement quand un champ timestamp a été modifié
- [ ] Seulement avant la premère fois qu'une entité est sauvegardée
- [x] **Seulement lors de sauvegardes ultérieures d'une entité est sauvegardée au moins une fois**

**Q13.** La mise en cache des données est un enjeu majeur pour améliorer les performances d'accès aux données.
<br/>
Parmi les choix suivants, lequel est vrai concernant la mise en cache avec Hibernate
- [ ] Hibernate définit la spécification du "second-level caching" et fournit une implémentation par défaut
- [ ] Hibernate permet uniquement la mise en cache au niveau de l'application et non au niveau de la couche d'accès aux données
- [x] **Hibernate définit la spécification du "second-level caching" et une librairie tierce doit être utilisée pour l'implémenter**
- [ ] Hibernate n'intègre pas de "second-level caching", il faut ajouter une librairie tierce et modifier le code de la couche d'accès aux données

**Q14.** Quel énoucé est correct concernant l'annotation @Autowired(required=true) sur les constructeurs d'une classe ?
- [ ] @Autowired n'est utilisable que sur les champs et les méthodes setter
- [x] **@Autowired peut être ajouté sur un constructeur mais ce n'est pas nécessaire**
- [ ] @Autowired peut être ajouté sur autant de constructeurs que souhaité.

**Q15.** Quelle annotation java est équivalente à @Component de spring et permet à un bean d'être détecté et rendu éligible à l'injection par le scan composants de spring ?
- [ ] @Validateable
- [ ] @Injectable
- [ ] @Candidate
- [x] **@Named**

**Q16.** 
- [ ] Plugins
- [ ] Build
- [ ] Properties
- [x] **Parent**

** Q17.** En base 2 (binaire), quel est le résultat final de l'opération (0101 | 0100) & 1100 ?

** R17.**
- [x] **0100**
- [ ] 1000
- [ ] 10000 
- [ ] 0101

** Q18.** Pourquoi le code suivant ne se compile pas ?

    public void readFile(String fileName) {
        try {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        lines.stream()
        .forEach(System.out::println);
        }
        catch (Exception e) {
        System.out.println("Exception occurred.");
        }
        catch (IOException e) {
        System.out.println("IOException occurred.");
        }
    }

** R18.**
- [ ] La méthode n'a pas fermé le fichier après lecture
- [ ] La méthode cherche à lire un fichier qui n'existe pas
- [x] **La gestion de Exception doit venir après celle de IOException**
- [ ] lines doit être de type ArrayList<String> et non de type
  List<String>

** Q19.** Vous avez développé un petit script pour vous et vos collègues, afin de vérifier la disponibilité d'un
serveur de sauvegarde.
Ce script doit être lancé dans la console et possède 3 arguments :
mode verbeux (-v) nom du serveur (-s) nombre de tentatives (-n) (une tentative par défaut)
Voici un extrait de votre script :

    import org.apache.commons.cli.*;
    public class Main {
        public static void main(String[] args) throws ParseException {
        Options options = new Options();
        Option verbose = new Option("v", "verbose", false, "verbose mode");
        options.addOption(verbose);
        Option server = new Option("s", "server", true, "server name");
        server.setRequired(true);
        options.addOption(server);
        Option nbTries = Option.builder("n")
        .longOpt("nbtries")
        .hasArg()
        .type(Number.class)
        .build();
        options.addOption(nbTries);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        }
    }


Quelle(t) ligne(s) de commande fonctionnera sans déclencher une ParseException ?
Sélectionnez toutes les réponses valables.

** R19.**
- [x] **java Main -s serv_potato**
- [x] **java Main --verbose --server serv_potato --nbtries 12**
- [ ] java Main --verbose -n 12 
- [ ] java Main -v -s serv_potato -n
- [ ] java Main -v --server serv_potato -n 12 -z



** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 

## Question/Réponse
### Notion de base

**Q1.** Quelle méthode de java.lang.String utiliseriez-vous pour découper la chaîne ci-dessous
en tableau ou collection des chaînes de caractère, le découpage étant fait vis-à-vis du caractère de saut de ligne ?

String str = "This is a string\n This is the next line.\nHello world."

**R1.**: **split**

    String str = "This is a string\nThis is the next line.\nHello world.";
    String[] lines = str.split("\n");

**Q2.** Quelle sont les types d'interface fonctionnelle ?

**R2.**:

**1. Predicate**:
- est une interface fonctionnelle qui prend un argument et renvoie une valeur booléenne
- son rôle est de tester une condition.
- exemple :


    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Predicate qui teste si un nombre est pair
    Predicate<Integer> isPair = number -> number % 2 == 0;

**2. Function**:
- est une interface fonctionnelle qui prend un argument et retourne un résultat.
- Utilisée pour appliquer une transformation sur des éléments.
- exemple :


    List<String> words = List.of("apple", "banana", "cherry");
        
    // Function qui ajoute un préfixe à chaque mot
    Function<String, String> addPrefix = word -> "Fruit: " + word;
    // Utilisation de map avec Function
    List<String> prefixedWords = words.stream()
                                      .map(addPrefix)  // applique la transformation à chaque élément
                                      .collect(Collectors.toList());
        
    System.out.println(prefixedWords);  // Sortie : [Fruit: apple, Fruit: banana, Fruit: cherry

**3. Consumer**:
- est une interface fonctionnelle qui représente une fonction qui prend un argument, mais ne renvoie pas de résultat (c'est-à-dire qu'il retourne void).
- Utilisé pour consommer des éléments sans les modifier, généralement pour effectuer des actions comme afficher des résultats, enregistrer des données
- exemple :


    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    // Consumer qui affiche chaque nombre
    Consumer<Integer> printNumber = number -> System.out.println(number);
    // Utilisation de forEach avec Consumer
    numbers.forEach(printNumber);  // Affiche chaque nombre

**4. Supplier**:
- Est une interface fonctionnelle qui ne prend pas d'argument et renvoie une valeur.
- son rôle est de fournir des valeurs à la demande via l'appel de la méthode get.
- exemple :


    Supplier<Double> randomValues = ()-> Math.random();  
    System.out.println(randomDouble.get());  // générerdes valeur aléatoire.


**Q3.** C'est quoi la difference en Set et List ?

**R3.**:
- Set : 
  - est une collection qui ne contient aucune duplication 
  - basé sur equals et hashcode (pour ne pas avoir de duplication)
  - Ne garanti pas l'ordre des éléments (dans HashSet) car ils sont distribués dans des buckets en fonction de leur hashCode() (sauf LinkedHashSet ou (TreeSet selon comparator)), 
  - Optimise les performances, Très efficaces pour les opérations d'ajout, de recherche et de suppression.
  - pas d'accès par index car les éléments ne sont pas indexés
  - exemple d'utilisation : Gestion d'emails uniques, tags, calcul d'intersection entre ensembles

- List : 
  - Permet les doublons 
  - basé sur un index
  - assurent un ordre explicite des éléments.
  - exemple d'utilisation : Historique des actions, gestion des tâches ordonnées, playlists.


**Q4.** Comment Set assure la non-duplication des éléments ?

**R4.** Grâce à l’utilisation d’un mécanisme interne basé sur les méthodes equals() et hashCode(), qui permettent de vérifier si deux objets sont égaux avant de les insérer dans la collection

### Veille technique
**Q1.** Quelles sont les nouveautés de Java 21 ?

**R1.**
- Virtual Threads : les threads virtuels créez des threads légers (virtually unlimited) gérés par le runtime JVM
- Scoped value : Permet de partager des données immuables de manière efficace entre les threads. Alternative aux variables ThreadLocal.
- String Templates : interpoler les chaînes
- Pattern Matching for switch
- Record Patterns
 - Structured Concurrency : Simplifie la gestion des tâches parallèles, en groupant les tâches exécutées de manière structurée

### Gestion de la mémoire 

**Q1.** Quelle sonts les régions principales de la mémoire dans la JVM ?

**R1.**
La mémoire dans la JVM est divisée en plusieurs régions principales :

- Stack : 
  - utilisée pour stocker les variables locales, les appels de méthode et les références.
  - Elle fonctionne selon un mécanisme LIFO (Last In, First Out).
  - La mémoire est allouée lorsqu’une méthode est appelée et libérée automatiquement à la fin de cette méthode.
  - La gestion est rapide, car elle n'implique pas de collecte de déchets (Garbage Collection).
  - Données stockées : Variables primitives (int, double, etc.) définies dans une méthode, Références d’objets (mais les objets eux-mêmes sont dans le Heap).
  - Taille limitée : La mémoire de la pile est généralement beaucoup plus petite que celle du Heap (entre 1Mo, 2Mo)
  - Une pile trop remplie provoque une StackOverflowError.
  
- Heap :
  - Le Heap est utilisé pour stocker tous les objets et les données globales.
  - Partagé entre tous les threads d’un programme.
  - Les objets sont créés dans le Heap avec l'opérateur new
  - La mémoire est gérée par le Garbage Collector, qui libère les objets inutilisés.
  - Données stockées : Tous les objets créés dans le programme, Les données de classe statiques (variables et méthodes).
  - la mémoire Heap est beaucoup plus grande que la mémoire Stack.
  - Peut provoquer une OutOfMemoryError si elle est saturée.

**Q2.** Comment modifier la taille du heap et de stack ?

**R2.**
- Stack : Xss
- Heap : Xms (pour la taille initiale), Xmx (pour la taille maximale)


**Q3.** Donner moi un exemple pour provoquer StackOverflowError et OutOfMemoryError ?

**R3.**
- Exemple StackOverflowError : appel récursif d'une méthode.


    public class Main {
    public static void recursiveMethod() {
    recursiveMethod(); // Récursion infinie
    }
    
        public static void main(String[] args) {
            recursiveMethod();
        }
    }

- Exemple OutOfMemoryError : boucle infini d'ajout des gros objets dans une liste


    import java.util.ArrayList;
    
    public class Main {
        public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
          while (true) {
             list.add(new int[1_000_000]); // Allocation excessive d'objets
          }
      }
    }

**Q4.** Quelle sont les bonnes pratiques pour optimiser la mémoire ?

**R4.**
- Éviter de créer trop d'objets inutiles.
- Libérer les références inutilisées.
- Utiliser des outils : Outils comme VisualVM, JProfiler pour analyser la consommation mémoire.


### Thread et api concurrent

**Q1.** La difference entre un client bloquant (comme Feign) et un client non bloquant (comme WebClient) ?

Réponse :

**Client bloquant (exemple : Feign):**
- Caractéristiques principales :
1. Approche synchrone :
Le thread qui exécute l'appel attend la réponse du serveur avant de continuer.
Pendant ce temps, il reste bloqué et ne peut pas être utilisé pour d'autres tâches.

2. Facilité d'utilisation :
Simplicité dans le code. Les développeurs n'ont pas à gérer les threads ou les callbacks.
L'écriture du code ressemble à des appels de méthode locaux.

3. Adapté aux petites charges :
Idéal pour les applications où le nombre d'appels réseau est faible ou modéré.
Fonctionne bien dans des environnements où le blocage n'entraîne pas de surcharge (par exemple, appels sporadiques).

- Limitation :
1. Le blocage des threads peut être problématique dans les applications hautement concurrentes ou en cas de nombreuses requêtes simultanées. 
2. Consommation de ressources élevée si de nombreux threads attendent des réponses.

**Client non bloquant (exemple : WebClient):**
- Caractéristiques principales :
1. Approche asynchrone :
Les opérations réseau s'effectuent de manière non bloquante.
Un thread initie l'appel, puis est libéré pour effectuer d'autres tâches pendant que la réponse est en attente.
Les résultats sont gérés via des callbacks, des Promises ou des outils réactifs (ex. Mono, Flux).
2. Scalabilité :
Idéal pour des applications nécessitant une haute concurrence (par exemple, microservices).
Permet une meilleure utilisation des ressources en minimisant le nombre de threads nécessaires.
4. Complexité accrue :
Le code asynchrone peut être plus difficile à écrire, comprendre et déboguer.
Nécessite une compréhension des concepts réactifs si combiné avec des frameworks comme Project Reactor.

- Avantages :
1. Excellente gestion des ressources pour les applications avec un grand nombre d'appels réseau. 
2. Fonctionne bien dans des environnements réactifs ou pour des APIs avec beaucoup de latence

**Q5.**
**Q6.**
**Q7.**
**Q8.**
**Q9.**
**Q10.**

## Algorithms