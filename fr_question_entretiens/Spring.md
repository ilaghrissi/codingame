### Spring / Spring Boot 

**Q1.** Qu’est-ce qu’un Bean Spring ?

**R1.** 
- Un bean Spring est un objet géré par le conteneur Spring (IOC container). 
- Il est instancié, configuré et injecté automatiquement.

**Q1.** Quelle est la différence entre @Component, @Service, @Repository ?

**R1.** 
- @Component	Générique, pour n’importe quel bean
- @Service	Pour la couche métier (logique)
- @Repository	Pour la couche DAO (accès BDD), ajoute gestion d’exceptions Spring Data
✅ Ces trois annotations permettent une détection automatique grâce à component scanning.


**Q1.** Qu’est-ce que l’injection de dépendance ?

**R1.**
- c’est quand une classe ne crée pas elle-même les objets dont elle a besoin, mais les reçoit de l’extérieur (par Spring, par exemple).

📦 Exemple dans la vraie vie :
  Imagine une voiture qui a besoin d’un moteur pour fonctionner.

❌ Sans injection :
La voiture fabrique elle-même son moteur :

        public class Car {
            private Engine engine = new Engine(); // Couplage fort
        }

⚠️ → Problème : si tu veux changer de moteur (ex: moteur électrique), tu dois modifier la classe Car.

✅ Avec injection de dépendance :
On donne un moteur à la voiture depuis l’extérieur :

        public class Car {
            private final Engine engine;
        
            public Car(Engine engine) { // Injection par constructeur
                this.engine = engine;
            }
        }

Et Spring peut injecter :

        @Bean
        public Car car(Engine engine) {
        return new Car(engine); // Engine est injecté automatiquement
        }

En résumé :
Ça permet :
- une architecture souple 
- un code testable 
- un respect des principes SOLID


**Q1.** Qu’est-ce que Spring Boot ? Pourquoi l’utiliser ?

**R1.**
- Framework basé sur Spring, qui simplifie la configuration et le déploiement. 
- Avantages :
  - Autoconfiguration (@SpringBootApplication)
  - Serveur embarqué (Tomcat/Jetty)
  - Moins de code XML 
  - Démarrage rapide (main())

**Q1.** Qu’est-ce qu’un @RestController ?

**R1.**
- Combinaison de @Controller + @ResponseBody. 
- Permet d’exposer des endpoints REST retournant JSON/XML.

**Q1.** Comment gérer les erreurs dans une API REST ?

**R1.**
- @ExceptionHandler

        @ControllerAdvice
        public class GlobalExceptionHandler {
            @ExceptionHandler(NotFoundException.class)
            public ResponseEntity<?> handleNotFound(NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }


**Q1.** Qu’est-ce que Spring Data JPA ?

**R1.**
- Module de Spring pour simplifier l’accès à la base de données avec JPA/Hibernate. 
- Fournit un JpaRepository avec des méthodes toutes prêtes (findById, save, etc.)

**Q1.** Qu’est-ce qu’un Transaction dans Spring ?

**R1.** 
- Une opération ou un ensemble d’opérations qui doivent être exécutées ensemble ou pas du tout.
    
        @Transactional
        public void transferMoney(...) {
        // toutes les opérations sont dans une même transaction
        }

- Si une exception se produit, tout est rollbacké automatiquement.

**Q1.**
**R1.** 