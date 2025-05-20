### Java question de base

**Q1.** Quelle est la différence entre == et .equals() ?

**R1.**
- == compare les références mémoire (adresse).
- .equals() compare les valeurs (contenu de l’objet).

**Q1.** Quelle est la différence entre HashMap, TreeMap et LinkedHashMap ?

**R1.**
- HashMap : non ordonnée, très rapide (O(1) en général). 
- TreeMap : triée par clé (ordre naturel ou via Comparator), plus lente. 
- LinkedHashMap : ordre d’insertion conservé.

**Q1.** Qu’est-ce qu’un objet immuable ? Donne un exemple.

**R1.**
Un objet dont l’état ne peut pas changer après sa création.
Exemple : String.

**Q1.** Quelle est la différence entre final, finally et finalize() ?

**R1.**
- final : mot-clé pour empêcher la modification (variable, méthode, classe). 
- finally : bloc exécuté toujours après try/catch. 
- finalize() : méthode appelée avant le ramassage de l'objet par le GC (dépréciée depuis Java 9).

**Q1.** Quelle est la différence entre une interface et une classe abstraite ?

**R1.**
- Interface : 100% abstraite (jusqu’à Java 7). Depuis Java 8, permet default et static methods. 
- Classe abstraite : peut avoir des méthodes concrètes, variables, constructeur.

**Q1.** Quand utiliser une interface ? et Quand utiliser une classe abstraite ?

**R1.**

- Quand utiliser une interface ?
  - Utilise une interface quand tu veux définir un contrat que plusieurs classes peuvent implémenter indépendamment, même si elles n'ont aucun lien entre elles.
  - Si tu veux permettre à une classe de gérer plusieurs rôles (héritage multiple).
  - Si tu veux injecter des comportements via l'inversion de dépendance (DI / IoC).
  
- Quand utiliser une classe abstraite ?
  - Factoriser du code commun.
  - Fournir une base partielle avec des attributs et des méthodes déjà prêtes
  - Imposer une structure commune + une logique partielle.
  - si tu veux éviter de dupliquer du code entre plusieurs classes similaires.
  - si tu as besoin de constructeurs, de variables d’instance ou de méthodes non abstraites.
  - 
**Q1.** Quelle est la différence entre ArrayList et LinkedList ?

**R1.**
- ArrayList : accès rapide (O(1)), ajout/suppression lente (O(n)). 
- LinkedList : accès lent (O(n)), insertion/suppression rapide au début/fin (O(1)).

**Q1.** Qu’est-ce que le autoboxing et unboxing ?

**R1.** 
- Autoboxing : conversion automatique de int → Integer. 
- Unboxing : Integer → int.

**Q1.** Quelle est la différence entre String, StringBuilder et StringBuffer ?

**R1.** 
- String : immuable. 
- StringBuilder : mutable, non thread-safe (plus rapide). 
- StringBuffer : mutable, thread-safe.

**Q1.** Comment fonctionne le Garbage Collector ?

**R1.** 
- Gère automatiquement la libération de la mémoire. 
- Les objets non référencés sont collectés. 
- Tu peux utiliser System.gc(), mais ce n’est pas garanti.

**Q1.**

**R1.** 

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


### Programmation Orientée Objet (POO)

**Q1.** Quelles sont les 4 piliers de la POO ?

**R1.**
4 piliers :
- Encapsulation 
- Abstraction 
- Héritage 
- Polymorphisme

**Q1.** Quelle est la différence entre l’héritage et la composition ?

**R1.**
- Héritage : "est un" (extends). 
- Composition : "a un" (utilise un objet).

**Q1.** Explique le polymorphisme en Java.

**R1.**
- Permet de traiter des objets de différentes classes via une même interface. 
- Exemple : une méthode afficher() qui se comporte différemment selon la classe.

**Q1.** Peut-on hériter de plusieurs classes en Java ?

**R1.**
Pas possible avec les classes, possible avec interfaces.

**Q1.** Qu’est-ce que l’encapsulation ? Pourquoi l’utiliser ?

**R1.**
- Masquer les détails internes. 
- Utiliser private + getters/setters.

**Q1.**
**R1.**

### Exceptions
**Q1.** Quelle est la différence entre les exceptions checked et unchecked ?

**R1.**
- Checked : 
  - Contrôlées à la compilation
  - Héritent de la classe Exception (mais pas de RuntimeException)
  - obligées d’être capturées (ex : IOException). 
  - Exemple : Lire un fichier 


        import java.io.*;
        public class Fichier {
            public void lireFichier(String chemin) throws IOException {
            FileReader fr = new FileReader(chemin);  // IOException est checked
            }
        }
- Unchecked : 
  - héritent de RuntimeException (ex : NullPointerException).
  - Pas obligatoires à capturer
  - Exemple : divison par 0


        public class Division {
            public int diviser(int a, int b) {
            return a / b;  // peut lancer ArithmeticException si b == 0
            }
        }


**Q1.** Quand utiliser try-with-resources ?

**R1.**
- Utilisé pour fermer automatiquement les ressources (InputStream, Connection).


**Q1.** Peut-on écrire un catch sans un try ?

**R1.**
❌ Non, pas possible. catch doit suivre un try.

**Q1.** Quelle est la bonne pratique pour gérer les exceptions ?

**R1.**
- Capturer uniquement ce que tu peux gérer. 
- Utiliser des exceptions personnalisées si nécessaire.

**Q1.**
**R1.**

### Gestion de la mémoire
**Q1.** Quelle sont les bonnes pratiques pour optimiser la mémoire ?

**R1.**
- Éviter de créer trop d'objets inutiles.
- Libérer les références inutilisées.
- Utiliser des outils : Outils comme VisualVM, JProfiler pour analyser la consommation mémoire.

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

### Multithreading & Concurrency


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


**Q1.** Qu’est-ce que synchronized ?

**R1.**
synchronized : Empêche l’accès concurrent à une méthode/bloc.

**Q1.** Quelle est la différence entre wait(), sleep() et notify() ?

**R1.**
- sleep() : met le thread en pause (Thread). 
- wait() : relâche le verrou et attend (Object). 
- notify() : réveille un thread en attente.

**Q1.** Qu’est-ce que le thread safety ?

**R1.**
Lorsqu’un objet peut être utilisé par plusieurs threads sans erreur.

**Q1.** Qu’est-ce que ExecutorService ?

**R1.**
Framework pour gérer un pool de threads.

      ExecutorService executor = Executors.newFixedThreadPool(5);
      executor.submit(() -> System.out.println("Thread exécuté"));

**Q1.** Qu’est-ce qu’un deadlock ? Comment l’éviter ?

**R1.**
Blocage mutuel entre deux threads qui attendent l’un l’autre.

➡️ Éviter les ressources croisées.

**Q1.** Quelle est la différence entre Runnable et Callable ?

**R1.**
- Runnable : ne retourne rien, pas d’exception. 
- Callable : retourne une valeur, peut lancer une exception.

**Q1.**
**R1.**

### Veille technique

**Q1.** Quelles sont les nouveautés de Java 8 ?

**R1.**
1. Expressions lambda
    - C’est une fonction anonyme (sans nom, sans mot-clé class ou new)
2. Interface fonctionnelle et annotation @FunctionalInterface:
    - Une interface fonctionnelle est une interface qui ne contient qu’une seule méthode abstraite(non default, non static).
    - Elle peut contenir plusieurs méthodes, mais une seule doit être abstraite.
    - L'annotaion @FunctionalInterface est facultative
        - signale que l’interface est conçue pour être fonctionnelle.
        - provoque une erreur de compilation si quelqu’un ajoute accidentellement une deuxième méthode abstraite.
        - Interfaces fonctionnelles prêtes à l’emploi dans Java
            - Predicate<T>
            - Function<T, R>
            - Consumer<T>
            - Supplier<T>
            - BinaryOperator<T>
        - Exemple :


       @FunctionalInterface
       public interface Calculateur {
            int calculer(int a, int b); // une seule méthode abstraite
       }


        public class Test {
            public static void main(String[] args) {
                Calculateur addition = (a, b) -> a + b;
                System.out.println(addition.calculer(5, 3)); // Affiche 8
            }
        }

3. Stream API
4. Optional : Classe pour éviter les NullPointerException,
5. Méthodes par défaut dans les interfaces :
    - Avant java 8 :
      Si tu voulais ajouter une méthode à une interface,
      tu devais la redéfinir dans toutes les classes qui l’implémentaient → casse de compatibilité.
    - Avec Java 8 :
      Tu peux ajouter une méthode avec une implémentation par défaut dans une interface sans casser le code existant.
6. Méthodes statiques dans les interfaces  :
    - elles peuvent être appelées sans créer une instance de l'interface.
7. Références de méthode (Method references) :
    - Raccourci pour appeler une méthode.
    - Exemple : names.forEach(System.out::println);
8. API java.time
9. Nashorn : Moteur JavaScript : Un moteur pour exécuter du code JavaScript directement dans une application Java.

**Q1.** Quelles sont les nouveautés de Java 9 ?
1. Jigsaw – Modularité du JDK : 
   - Java devient modulaire grâce à la notion de modules (module-info.java), pour mieux organiser les projets et réduire le temps de chargement.
   - Exemple :


         module com.monapp {
            requires java.base;
            exports com.monapp.services;
         }

2. JShell – REPL (Read-Eval-Print Loop)
   - Un outil en ligne de commande pour tester du code Java rapidement sans créer de classe ni méthode main.
   - Exemple


        jshell
        jshell> int x = 5;
        jshell> System.out.println(x * 2); // 10

3. Méthodes de fabrique pour les collections (List.of, Set.of, Map.of)  
   - Création rapide et immuable de collections.
   - Exemple :


         List<String> noms = List.of("Ali", "Sara", "Mina");
         Set<Integer> chiffres = Set.of(1, 2, 3);
         Map<String, Integer> notes = Map.of("Math", 18, "Physique", 17);

4. Ajout de méthodes privées
   - Ajout de méthodes privées dans les interfaces pour factoriser le code utilisé dans les méthodes default.
   - Exemple :


        interface Calculatrice {
            default int calcul(int a, int b) {
                return addition(a, b);
            }
        
            private int addition(int a, int b) {
                return a + b;
            }
         }

5. API Stream améliorée
   - Ajout de nouvelles méthodes : takeWhile(), dropWhile(), ofNullable()
   - Exemple :
   
    
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream()
        .takeWhile(i -> i < 4)
        .forEach(System.out::println); // 1, 2, 3

**Q1.** Quelles sont les nouveautés de Java 17 ?

1. Sealed Classes
  - Permettent de restreindre les sous-classes possibles d’une classe ou interface.
  - Exemple :

        public sealed class Animal permits Chat, Chien {}

        final class Chat extends Animal {}
        final class Chien extends Animal {}

2. Pattern Matching pour instanceof
  - plus besoin de caster après un instanceof.
  - Exemple : 

        if (obj instanceof String s) {
          System.out.println(s.length());
        }

3. Records
  - Permet de créer facilement des classes immuables avec des champs, getters, equals, hashCode, toString.
  - Exemple :
  
        public record Person(String name, int age) {}

        Person p = new Person("Ali", 30);
        System.out.println(p.name()); // Ali

4. Switch Expressions
   - Écriture plus claire et expressionnelle des switch
   - Exemple :
   

         String result = switch (day) {
             case MONDAY, FRIDAY -> "Weekend soon";
             case SATURDAY, SUNDAY -> "Weekend!";
             default -> "Workday";
         };

5. Text Blocks
   - Permettent d’écrire des chaînes multilignes sans concaténation ni échappement.
   - Exemple :


         String json = """
         {
         "name": "Java",
         "version": 17
         }
         """;



**Q1.** Quelles sont les nouveautés de Java 21 ?

**R1.**
1. Virtual Threads : 
   - les threads virtuels créez des threads légers (virtually unlimited) gérés par le runtime JVM
   - Avant Java 21, chaque thread Java correspondait à un thread natif du système d'exploitation,
   ce qui limitait la scalabilité (gros coût mémoire par thread, et limite OS).
     Inconvénients :
     - Lent à démarrer.
     - Consomme beaucoup de mémoire (stack ~1 Mo).
     - Peut saturer rapidement à partir de quelques milliers de threads.
   - Après Java 21 :
     - Les threads virtuels sont allégés, gérés par la JVM et non liés à un thread système.
     Cela permet de lancer des millions de threads sans surcharge majeure.
2. Scoped value : Permet de partager des données immuables de manière efficace entre les threads. Alternative aux variables ThreadLocal.
3. String Templates : interpoler les chaînes
4. Pattern Matching for switch : 
  - Objectif : Simplifier les conditions avec instanceof dans switch.


        static String process(Object obj) {
          return switch (obj) {
              case Integer i -> "Int: " + i;
              case String s -> "String: " + s.toUpperCase();
              case null -> "Null";
              default -> "Other";
          };
       }

5. Record Patterns
  - Objectif : Déstructuration de record dans un switch.

          record Point(int x, int y) {}
          static void printPoint(Object obj) {
              if (obj instanceof Point(int x, int y)) {
              System.out.println("X: " + x + ", Y: " + y);
              }
          }

Ou dans un switch :

        static String describe(Object o) {
        return switch (o) {
            case Point(int x, int y) -> "Point x=" + x + ", y=" + y;
            default -> "Unknown";
        };
        }


6. Structured Concurrency : 
- Simplifie la gestion des tâches parallèles, en groupant les tâches exécutées de manière structurée

        

**Q1.** Qu’est-ce qu’un stream ? Exemples
**R1.**

**Q1.** Qu’est-ce qu’une lambda expression ?
**R1.**

**Q1.** Qu’est-ce qu’un Optional ?
**R1.**

**Q1.** Qu’est-ce que FunctionalInterface ?

**R1.**
Une interface avec une seule méthode abstraite.

**Q1.** Différence entre map() et flatMap() ?

**R1.**
- map() : transforme chaque élément.
- flatMap() : aplatit les structures imbriquées.



**Q1.**

**R1.**

### Collections
   
**Q1.** Comment fonctionne HashMap en interne ?

**R1.**

**Q1.** Quelle est la complexité d’accès dans une HashMap ?

**R1.**

**Q1.** Qu’est-ce que ConcurrentHashMap ?

**R1.**

**Q1.** Quelle est la différence entre Set, List et Map ?

**R1.**

**Q1.** Qu’est-ce que le fail-fast dans les collections Java ?

**R1.**
Exception (ConcurrentModificationException) si tu modifies une collection pendant l’itération.

**Q1.** Différences entre les boucles volatiles et synchronize ?

**R1.**
🔹 1. volatile
- But : garantir la visibilité d’une variable entre threads.
- Quand une variable est volatile, chaque thread lit directement sa dernière valeur en mémoire principale (et non dans un cache local).
- Ne garantit pas l'exclusion mutuelle (pas de verrou).

✅ Exemple :

      volatile boolean running = true;

      while (running) {
      // boucle qui tourne tant que running est true
      }

➡️ Si un autre thread fait running = false, le thread courant le verra immédiatement grâce au volatile.

🔹 2. synchronized
- But : garantir à la fois visibilité et atomicité (exclusion mutuelle).
- Empêche plusieurs threads d'accéder en même temps à une section critique.
- Implique un verrou (lock) sur un objet ou une méthode.

      synchronized(this) {
      // section critique protégée
      }

➡️ Un seul thread à la fois peut entrer ici.

⚠️ En résumé :

| Aspect              | `volatile`               | `synchronized`                           |
|---------------------|--------------------------|------------------------------------------|
| Visibilité          | ✅                        | ✅                                        |
| Atomicité           | ❌                        | ✅                                        |
| Utilise un verrou   | ❌                        | ✅                                        |
| Coût en performance | Faible                   | Plus élevé (lock)                        |
| Utilisation typique | Indicateur d’arrêt, flag | Opérations critiques, accès à des objets |

🧠 À retenir pour l'entretien :
Utilise volatile si un seul thread modifie la variable, et les autres ne font que la lire.

Utilise synchronized si plusieurs threads modifient ou lisent en même temps et que tu veux protéger une section critique.

**Q1.** Peut-on synchroniser un constructeur en Java ?

**R1.**
Non, on ne peut pas synchroniser un constructeur directement avec le mot-clé synchronized.

Pourquoi ?
- Le mot-clé synchronized sert à verrouiller un objet ou une classe pour empêcher l'accès concurrent à une section critique. 
- Lorsqu’un constructeur est appelé, l'objet n'est pas encore complètement construit, donc il n’y a pas d’objet sur lequel appliquer un verrou. 
- De plus, la syntaxe Java ne permet pas de déclarer un constructeur synchronized.

Comment gérer la synchronisation lors de la création d’objets ?
- Synchroniser la méthode qui crée l’objet (exemple : une méthode getInstance() dans un Singleton). 
- Utiliser des blocs synchronisés à l’intérieur du constructeur, mais c’est rarement nécessaire. 
- Gérer la synchronisation en dehors du constructeur.

Exemple classique : Singleton thread-safe


         public class Singleton {
            private static Singleton instance;
         
             private Singleton() {
                 // constructeur privé
             }
         
             public static synchronized Singleton getInstance() {
                 if (instance == null) {
                     instance = new Singleton();
                 }
                 return instance;
             }
         }

**Q1.** Quelles différences entre sleep et wait dans la classe abstraite ?

**R1.**

| Critère                         | `sleep()`                                | `wait()`                                                  |
|---------------------------------|------------------------------------------|-----------------------------------------------------------|
| Appartient à                    | `Thread` class                           | `Object` class                                            |
| Nécessite un `synchronized` ?   | ❌ Non                                    | ✅ Oui (doit être appelé dans un bloc synchronisé)         |
| Relâche le verrou (`monitor`) ? | ❌ Non                                    | ✅ Oui                                                     |
| Peut être utilisé pour          | Mettre le thread en pause temporairement | Attendre une notification d’un autre thread               |
| Réveil automatique ?            | ✅ Oui (après le temps spécifié)          | ❌ Non (doit être réveillé par `notify()` / `notifyAll()`) |
| Lève une exception ?            | `InterruptedException`                   | `InterruptedException`                                    |

🔹 sleep() : pause passive
- Fait dormir le thread courant pendant un certain temps. 
- N'a rien à voir avec la synchronisation ou les verrous. 
- N’a aucun effet sur les locks.
   
         Thread.sleep(1000); // Le thread dort 1 seconde

🔹 wait() : mécanisme de synchronisation
- Utilisé pour suspendre l’exécution jusqu’à ce qu’un autre thread appelle notify() ou notifyAll(). 
- Doit être appelé à l’intérieur d’un bloc synchronized. 
- Relâche le verrou sur l’objet courant.

         synchronized(obj) {
         obj.wait();  // Le thread attend une notification sur obj
         }

🧠 À retenir pour l'entretien :
sleep() est utilisé pour temporiser un thread.
wait() est utilisé pour synchroniser des threads, en attendant une condition et en relâchant le verrou.


**Q1.** Qu’est-ce que le wildcard (?) en Java générique ?

**R2**

Le wildcard est un symbole spécial ? utilisé dans les génériques pour représenter un type inconnu.
Cela permet d’écrire du code plus flexible en autorisant différents types, mais avec certaines limites.

🔹 Différents types de wildcards
1. <?> — wildcard non borné (unbounded wildcard)
Représente n’importe quel type.
Exemple : List<?> = liste de n’importe quel type.

2. <? extends T> — wildcard borné par le haut (upper bounded wildcard)
Représente un type qui est T ou un sous-type de T.
Exemple : List<? extends Number> accepte List<Integer>, List<Double>, etc.

3. <? super T> — wildcard borné par le bas (lower bounded wildcard)
Représente un type qui est T ou un super-type de T.
Exemple : List<? super Integer> accepte List<Integer>, List<Number>, List<Object>.