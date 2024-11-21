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



## Question/Réponse

**Q1.** Quelle est le nom de l'interface Spring implémentée ci-dessous, utilisée pour valider un business Model depuis plusieurs modules Spring ?


    public class UserValidator implements XXXXXX {
    
        public boolean supports(Class clazz) {
            return User.class.equals(clazz);
        }
        
        public void validate(Object obj, Errors e) {
            ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
            User p = (User) obj;
            if (p.getAge() < 0) {
                e.rejectValue("age", "negativevalue");
            } else if (p.getAge() > 110) {
                e.rejectValue("age", "too.darn.old");
            }
        }
    }

Réponse : **Validator**


**Q2.** Comment appelle-t-on les objets qui sont instancées, managés et détruits par un containeur IoC Spring ?

Réponse : **beans**

**Q3.** Quelle méthode de java.lang.String utiliseriez-vous pour découper la chaîne ci-dessous
en tableau ou collection des chaînes de caractère, le découpage étant fait vis-à-vis du caractère de saut de ligne ?

String str = "This is a string\n This is the next line.\nHello world."

Réponse : **split**

    String str = "This is a string\nThis is the next line.\nHello world.";
    String[] lines = str.split("\n");

**Q4.** La difference entre un client bloquant (comme Feign) et un client non bloquant (comme WebClient) ?

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