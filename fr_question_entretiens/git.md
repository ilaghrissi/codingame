
## Merge request
**Q1.** Si demain je te propose une merge request avec du code dedans, qu’est-ce que tu vas regarder, comment tu t’organises? quels sont les étapes que tu vas faire pour valider ou pas cette merge request?

**R1.**

1. 🔍 Comprendre le contexte de la MR
   Lire la description de la MR (ticket Jira, user story…).

Vérifier ce que la MR est censée faire : correction de bug ? nouvelle fonctionnalité ?

Vérifier si les fichiers impactés correspondent bien au besoin.

2. 👀 Revue du code (code review)
   Je vérifie plusieurs points :

✅ Lisibilité & clarté du code (nom de variables, méthodes, commentaires…)

♻️ Respect des conventions du projet (Java style, indentation, noms…)

🔒 Sécurité (ex: pas de faille injection, bonne gestion des accès…)

⚠️ Gestion des erreurs & exceptions

🧼 Code inutile ou dupliqué ? à factoriser ?

🚨 Side effects ? Est-ce que ce code casse autre chose ?

3. 🧪 Vérification des tests
   Est-ce qu’il y a des tests unitaires et d’intégration associés ?

Est-ce qu’ils testent les cas normaux + cas limites + erreurs ?

Est-ce que tous les tests passent dans le pipeline CI ?

4. 🧪 Test manuel (si nécessaire)
   Si la fonctionnalité est sensible ou visible par l’utilisateur, je fais un test local ou sur l’environnement de dev pour m’assurer que ça fonctionne comme attendu.

5. ✅ Feedback clair et constructif
   Si tout est bon : ✅ J’approuve la MR.

Si des points sont à corriger : j’ajoute des commentaires constructifs, je propose parfois des snippets ou solutions alternatives.

## Git

**Q1.** C’est quoi la différence entre un merge et un rebease?

**R1.**
✅ Merge
- But : Fusionner deux branches (ex : feature → main)
- Conserve l’historique des commits de chaque branche 
- Ajoute un commit de merge (automatique ou manuel)

    
        git checkout main
        git merge feature


🔄 Rebase
- But : Rejouer les commits de ta branche au-dessus d’une autre 
- Réécrit l’historique 
- Pas de commit de merge


        git checkout feature
        git rebase main

**Q1.** Tu connais GIT fetch? c’est quoi la différence avec le pull ?

**R1.**
✅ git fetch :

        git fetch origin

- Récupère les commits du dépôt distant 
- NE change pas ta branche locale 
- Tu peux ensuite comparer ou faire un merge manuel :

✅ git pull : 

        git pull origin main

- Fait d'abord un fetch
- Puis fusionne les changements dans ta branche locale (avec un merge ou un rebase, selon ta config)

**Q1** Ça fait quoi un cherrypick ?

**R1**

git cherry-pick permet de copier un ou plusieurs commits spécifiques d'une branche vers une autre, sans fusionner toutes les branches.

