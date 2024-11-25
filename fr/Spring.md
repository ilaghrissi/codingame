# Spring

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