
**Q1.** c'est quoi le principe ACID ?

**R1.**

| **Lettre** | **Nom**        | **Définition**                                                                                       |
|------------|----------------|------------------------------------------------------------------------------------------------------|
| **A**      | **Atomicité**  | Une transaction est **tout ou rien** : soit elle réussit entièrement, soit rien n’est appliqué.      |
| **C**      | **Cohérence**  | Une transaction amène la base de données d’un **état valide à un autre état valide**.                |
| **I**      | **Isolation**  | Les transactions s’exécutent **comme si elles étaient seules**, sans interférer entre elles.         |
| **D**      | **Durabilité** | Une fois une transaction validée (**commit**), ses effets sont **permanents**, même en cas de panne. |

✅ Exemple concret :
Supposons une transaction bancaire :
- Débiter 100€ du compte A
- Créditer 100€ sur le compte B

Grâce à ACID :

- Si une étape échoue, rien n’est enregistré (Atomicité)
- Les comptes restent cohérents (pas de perte ou création d'argent)
- Si deux virements ont lieu en même temps, les données ne seront pas corrompues (Isolation)
- Une fois terminé, même si la base crashe, le virement reste enregistré (Durabilité)


🔹 Imagine une transaction bancaire :
Tu veux envoyer 100 € de ton compte A vers le compte B. C’est une transaction.

Pour que tout se passe bien, la base de données suit le principe ACID :

🔸 A = Atomicité (tout ou rien)
💡 Soit les 100 € sont retirés de A et ajoutés à B, soit rien ne se passe du tout.

🔁 Si un problème survient entre les deux (ex: serveur coupé), la transaction est annulée et la base revient à l’état initial.

🔸 C = Cohérence
💡 Avant et après la transaction, les règles de la base sont toujours respectées.

Ex : Si la règle dit qu’un compte ne peut pas être en négatif, la base refusera la transaction si le compte A n’a pas 100 €.

🔸 I = Isolation
💡 Si plusieurs personnes envoient ou reçoivent de l’argent en même temps, les transactions ne doivent pas se mélanger.

Tu dois voir ta transaction comme si tu étais seul à l’exécuter. C’est la base qui gère ça en interne.

🔸 D = Durabilité
💡 Une fois la transaction validée (committed), même si le serveur crash après, les données sont sauvegardées définitivement.

Pas de perte d’argent ! La base garde une trace durable de ce qui s’est passé.

