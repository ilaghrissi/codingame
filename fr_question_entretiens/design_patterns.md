### Design patterns

**Q1.** Qu’est-ce que le Singleton ? Comment l’implémenter en Java ?

**R1.**
- Le singleton garantit qu’une seule instance d'une classe existe.
- Exemple :


        public class Singleton {
          private static Singleton instance;
        
          private Singleton() {}

              public static Singleton getInstance() {
                  if (instance == null) {
                  instance = new Singleton();
                  }
                return instance;
              }
          }


**Q1.** Donne un exemple de Factory Pattern.

**R1.**
- Fournit une méthode pour créer des objets sans exposer la logique de création.


        public interface Shape { void draw(); }

        public class Circle implements Shape {
        public void draw() { System.out.println("Circle"); }
        }
        
        public class ShapeFactory {
            public Shape getShape(String type) {
                if ("circle".equals(type)) return new Circle();
                return null;
            }
        }

**Q1.** À quoi sert le Builder Pattern ?

**R1.**
- Créer un objet complexe étape par étape sans constructeur avec 50 arguments.

        public class User {
          private String name;
          private int age;
        
          public static class Builder {
              private String name;
              private int age;
    
              public Builder setName(String n) { this.name = n; return this; }
              public Builder setAge(int a) { this.age = a; return this; }

            public User build() {
                return new User(this);
            }
          }
        
              private User(Builder b) {
              this.name = b.name;
              this.age = b.age;
              }
          }


**Q1.** Qu’est-ce que le principe SOLID ?

**R1.**

S – Single Responsibility Principle
➤ Une classe = une seule responsabilité.

O – Open/Closed Principle
➤ Ouvert à l’extension, fermé à la modification.

L – Liskov Substitution Principle
➤ Une sous-classe doit pouvoir remplacer la classe mère.

I – Interface Segregation Principle
➤ Pas d’interfaces trop grosses, mieux vaut les découper.

D – Dependency Inversion Principle
➤ Dépendre d’abstractions, pas d’implémentations concrètes.

**Q1.** Pourquoi préférer les interfaces aux classes concrètes ?

**R1.**
- Permet la flexibilité (facile de changer l’implémentation).
- Facilite les tests unitaires (mock).
- Encourage le développement orienté contrat.
- Respecte le principe d’inversion de dépendance (D de SOLID).