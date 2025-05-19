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


**Q1** C'est quoi clean code ?

**R1**

🔹 Définition simple :
Le clean code est un code qui communique clairement ce qu’il fait, sans besoin d’interprétation, et qui évite les complexités inutiles.

✅ Principes du Clean Code :
Noms significatifs :

❌ int a; → ✅ int age;

Le nom des variables, méthodes et classes doit refléter leur rôle.

Méthodes courtes et lisibles :

Une méthode = une seule responsabilité.

Longueur idéale : 5 à 20 lignes maximum.

Pas de duplication :

Le code ne doit pas se répéter. Si tu répètes du code → extrait une méthode.

Fonctions pures et prévisibles :

Une fonction doit faire ce qu’elle dit, sans effet de bord caché.

Code auto-documenté :

Le code doit être suffisamment clair pour ne pas dépendre trop des commentaires.

Les commentaires sont utiles uniquement si quelque chose n'est pas évident.

Formatage cohérent :

Indentation, espaces, sauts de lignes réguliers → pour faciliter la lecture.

Gestion claire des exceptions :

Pas de catch (Exception e) générique.

Utiliser des types d’exceptions explicites.

**Q1.** quel est le process à suivre pour corriger un BUG?

**R1**

Reproduire → Analyser → Isoler (Utiliser des points d’arrêt (debugger)) → Corriger → Tester → Documenter