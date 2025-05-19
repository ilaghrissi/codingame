# Docker

**Q1.** C'est quoi la différence entre RUN et CMD ?

**R1.**

🔹 RUN
- Quoi ? : Exécute une commande au moment de la construction de l’image Docker. 
- À quoi ça sert ? : Pour installer des packages, copier des fichiers, configurer l’image, etc. 
Chaque RUN crée une nouvelle couche dans l’image.
- Exemple : 
    
        RUN apt-get update && apt-get install -y curl

🔹 CMD
- Quoi ? : Spécifie la commande par défaut à exécuter quand un conteneur démarre à partir de cette image.
- À quoi ça sert ? : Pour indiquer le programme principal ou le script qui sera lancé dans le conteneur. 
- Important :
Si tu passes une commande lors du lancement du conteneur (docker run image commande), elle remplace le CMD.
- Exemple :
    
        CMD ["java", "-jar", "app.jar"]


**Q1.** C'est quoila différence entre ENTRYPOINT et CMD ?

**R**

| Instruction  | But principal                           | Peut être remplacée au `docker run` ? | Exemple                                  |
|--------------|-----------------------------------------|---------------------------------------|------------------------------------------|
| `CMD`        | Fournit une **commande par défaut**     | ✅ Oui, facilement                     | `CMD ["nginx", "-g", "daemon off;"]`     |
| `ENTRYPOINT` | Définit la **commande fixe à exécuter** | 🔸 Non (sauf avec `--entrypoint`)     | `ENTRYPOINT ["java", "-jar", "app.jar"]` |
