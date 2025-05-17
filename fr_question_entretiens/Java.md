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
- Checked : obligées d’être capturées (ex : IOException). 
- Unchecked : héritent de RuntimeException (ex : NullPointerException).

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
**Q1.** Quelles sont les nouveautés de Java 21 ?

**R1.**
- Virtual Threads : les threads virtuels créez des threads légers (virtually unlimited) gérés par le runtime JVM
- Scoped value : Permet de partager des données immuables de manière efficace entre les threads. Alternative aux variables ThreadLocal.
- String Templates : interpoler les chaînes
- Pattern Matching for switch
- Record Patterns
- Structured Concurrency : Simplifie la gestion des tâches parallèles, en groupant les tâches exécutées de manière structurée

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

**Q1.** Quelles sont les nouveautés de Java 8 / 11 / 17 ? (selon ce que l'entreprise utilise)

**R1.**

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
**Q1.**
**R1.**
