
### Gestion de la mémoire
**Q1.** Quelle sont les bonnes pratiques pour optimiser la mémoire ?

**R1.**
- Éviter de créer trop d'objets inutiles.
- Libérer les références inutilisées.
- Utiliser des outils : Outils comme VisualVM, JProfiler pour analyser la consommation mémoire.

### Thread et api concurrent



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