# Kubernetes

## QCM

**Q1.** Parmi les propositions suivantes, quelle est celle qui ne désigne pas un champ obligatoire à la création d'un objet Kubernetes ?
- [ ] kind
- [ ] apiVersion
- [x] **status**
- [ ] spec

**Q2.** Quel objet Kubernetes peut aider à positionner la valeur maximum de mémoire utilisée par les conteneurs s'éxécutant dans un namespace donné ?
- [ ] SecurityContext
- [ ] PodSecurityPolicy
- [ ] PodSecurityContext
- [x] **LimitRange**

**Q3.** On souhaite créer un cluster Kubernetes de test avec un seul master et plusieurs noeuds.
Pour créer le master, on utilise la commande kubeadm init.
<br/>
Quelle commande utilise-t-on pour ajouter des noeuds au cluster ?
- [ ] kubeadm node join
- [ ] kubeadm add
- [x] **kubeadm join**
- [ ] kubeadm node create

**Q4.** Dans Kubernetes, une probe est un diagnostic réalisé de manière périodique par le
kubelet sur un conteneur. Pour réaliser son diagnostic, le kubelet appelle un
"handler" implémenté par le conteneur.
<br/>
Parmi les propositions suivantes, quel type de handler n'est pas supporté par kubernetes ?
- [ ] TCPSocketAction
- [ ] ExecAction
- [ ] HTTPGetAction
- [x] UDPSocketAction

**Q5.** Quelles stratégies de mise à jour sont valides pour un Daemonset kubernetes ?
- [ ] Canary
- [x] **OnDelete**
- [x] **RollingUpdate**
- [ ] Parallel

**Q6.** Dans Kubernetes, le "Horizontal Pod Autoscaler* ajoute ou enlève des pods d'un
Deployment, Replication Controller ou Replica Set en se basant sur des métriques.
<br/>
Par défaut, le controlleur associé à lfrorizontairoärutoscaler] récolte ces métriques
<br/>
depuis des APIs fournies par Kubernetes.
<br/>
Une équipe de développeurs front souhaitent baser l'autoscaling sur le nombre de
requêtes HTTP entrantes. En supposant que l'application expose la métrique
nécessaire, quelle API doit être utilisée pour réaliser cet autoscaling ?

** R6.**

- [ ] internal.metrics.k8s.io
- [ ] metrics.k8s.io
- [x] **custom.metrics.k8s.io**
- [ ] external.metrics.k8s.io


** Q7.** Lequel des mots-clés suivants n'est pas commun à tous les objets Kubernetes ?

** R7.**
- [ ] apiVersion
- [ ] kind
- [x] **data**
- [ ] metadata

** Q8.** Quelle ressource Kubernetes permet d'effectuer un routage, basé sur le host , vers plusieurs
applications s'exécutant dans le cluster ?

** R8.** 
- [x] **Ingress**
- [ ] IngressController
- [ ] Service de type LoadBalancer
- [ ] Ce n'est pas possible, seul le routing basé sur le "path" est possible



** Q9.** Quelle terme n'est pas une Restart Policy valide pour un pod ?

** R9.**
- [ ] Always 
- [ ] OnFailure
- [ ] Never
- [x] **OnUpdate**



** Q7.**

** R7.**
- [ ] 
- [ ] 
- [x] 
- [ ] 



## Question/Réponse
**Q1.** Dans quel namespace Kubernetes crée-t-il ses objets internes ? <br/>
**R1.**: 
**kube-system**

**Q2.** Quelle sous-commande de kubectl permet de lister l'ensemble des contextes disponibles dans le fichier de configuration de kubernetes (kubeconfig)? <br/>
**R2.**: 
config get-contexts

**Q3.** Quelle sous-commande kubectl permet de voir rapidement l'utilisation de mémoire et de CPU en
cours d'un noeud Kubernetes ?

**R3.**:
.*top.*


### POD
**Q1.** C'est quoi un pod ?
**R1.**:
Un Pod est l’unité de base déployable dans Kubernetes. C'est l'entité qui contient et exécute un ou plusieurs conteneurs (généralement un seul). Les conteneurs dans un pod partagent des ressources comme :

1. Le réseau : Tous les conteneurs d’un pod partagent la même adresse IP et les mêmes ports. 
2. Le stockage : Les conteneurs peuvent partager des volumes montés. 
3. Le cycle de vie : Les conteneurs démarrent, s'arrêtent et redémarrent ensemble.

**Q2.** C'est quoi le cycle de vie d'un pod ?
**R2.**:
- Pending : Le pod est créé mais n’a pas encore de node assigné.
- Running : Au moins un conteneur fonctionne.
- Succeeded : Tous les conteneurs ont terminé avec succès.
- Failed : Un ou plusieurs conteneurs ont échoué.
- Unknown : Kubernetes ne peut pas déterminer l'état.

**Q3.** Quelles sont les types de probes dans Kubernetes ?
**R3.**:
Les probes sont des vérifications périodiques que Kubernetes effectue pour évaluer l'état d'un conteneur. Il existe trois types principaux :

1. Liveness Probe : Vérifie si le conteneur est en vie (fonctionne toujours). 
2. Readiness Probe : Vérifie si le conteneur est prêt à gérer des requêtes. 
3. Startup Probe : Vérifie que l'application a bien démarré avant que les autres probes s’activent.


**Q4.** Quelles sont les modes de vérification d'une Liveness Probe ?
**R4.**:
1. HTTP GET :
   - Kubernetes envoie une requête HTTP à une URL spécifique du conteneur. 
   - Exemple : Si l'URL /health retourne un code HTTP 200, le conteneur est vivant.
2. Command Probe :
   - Kubernetes exécute une commande à l'intérieur du conteneur.
   - Si la commande retourne 0, le conteneur est vivant ; sinon, il est considéré comme mort.
3. TCP Socket :
  - Kubernetes tente d'ouvrir une connexion TCP à un port du conteneur.
  - Si la connexion réussit, le conteneur est vivant.

**Q5.** Quelles sont les stratégies de déploiement des pod ? 
**R5.**:
Ces stratégies définissent comment Kubernetes met à jour les Pods lorsqu'il y a des modifications dans le déploiement (par exemple, après une mise à jour de l'image Docker).
1. Rolling Update (mise à jour progressive)
   - Description : Les Pods sont mis à jour progressivement, un ou plusieurs à la fois. Cela garantit une disponibilité continue. 
   - Utilisation par défaut : Rolling Update est la stratégie par défaut pour les Deployments.
   - Exemple :
     Supposons que tu as 5 Pods et que tu veux les mettre à jour avec une nouvelle version de ton application (par exemple, v1 → v2). 
     - Kubernetes remplace un ou plusieurs Pods (configurable avec maxUnavailable et maxSurge) tout en maintenant une partie des Pods disponibles. 
     - Les Pods sont détruits et recréés un par un (ou en petits groupes).
     

        apiVersion: apps/v1
        kind: Deployment
        metadata:
            name: rolling-update-example
        spec:
            replicas: 5
            strategy:
                type: RollingUpdate
                 rollingUpdate:
                    maxSurge: 2          # Ajoute jusqu'à 2 Pods supplémentaires pendant la mise à jour.
                    maxUnavailable: 1    # Permet qu'un seul Pod soit indisponible.
            template:
                spec:
                 containers:
                 - name: my-app
        image: my-app:v2

2. Recreate (recréation complète)
   - Description : Tous les Pods existants sont détruits avant de recréer de nouveaux Pods avec la nouvelle version. 
   - Inconvénient : Il y a une interruption de service, car aucun Pod n'est disponible pendant la mise à jour. 
   - Utilisation : Utile lorsque les Pods ont des problèmes d'état (stateful) ou qu'ils ne peuvent pas coexister avec d'autres versions.
   - Exemple :
     Supposons que ton application nécessite que tous les Pods soient arrêtés avant de démarrer une nouvelle version.


        apiVersion: apps/v1
        kind: Deployment
        metadata:
            name: recreate-example
        spec:
            replicas: 5
            strategy:
                type: Recreate
            template:
                spec:
                 containers:
                - name: my-app
                image: my-app:v2


**Q6.** Quelles sont les tratégies de redémarrage des Pods ? 
**R6.**:
Ces stratégies définissent comment les Pods sont redémarrés en cas de panne ou d'échec.
1. Always (Toujours)
2. OnFailure (En cas d'échec)
3. Never (Jamais)

**Q3.** Quelles sont les stratégies d'affinité des Pods ?
**R3.**:
1. Affinity (affinité)
2. Anti-Affinity


**Q3.** Quelles sont les stratégies de mise à l'échelle (Scaling Strategies) des Pods ?
**R3.**:
Ces stratégies définissent comment les Pods sont ajoutés ou supprimés en fonction de la charge.
1. Horizontal Pod Autoscaler (HPA)
   - Permet d'ajouter ou de supprimer des Pods en fonction de l'utilisation des ressources (CPU, mémoire, etc.).
   - Exemple :
     Si ton application consomme plus de 70 % de CPU, Kubernetes ajoute des Pods.

    
        apiVersion: autoscaling/v2
        kind: HorizontalPodAutoscaler
        metadata:
            name: my-app-hpa
        spec:
            scaleTargetRef:
                apiVersion: apps/v1
                kind: Deployment
                name: my-app
        minReplicas: 2
        maxReplicas: 10
        metrics:
        - type: Resource
          resource:
            name: cpu
            target:
             type: Utilization
             averageUtilization: 70
2. Vertical Pod Autoscaler (VPA)
- Permet d'ajuster automatiquement les ressources (CPU/mémoire) allouées aux Pods.
### Service

**Q1.** Pourquoi utiliser un service dans kubernetes ?
**R1.**:
- Accès stable aux pods : Les pods dans Kubernetes peuvent être créés et supprimés dynamiquement. Cependant, l'adresse IP d'un pod peut changer à chaque redémarrage. Un Service donne une adresse IP stable pour accéder aux pods.
- Équilibrage de charge : Le Service peut diriger le trafic entrant vers plusieurs pods, assurant ainsi une distribution uniforme de la charge.
- Abstraction réseau : Un Service masque la complexité du réseau, facilitant l'accès aux applications sans se soucier de l'adresse IP des pods sous-jacents.

**Q2.** Quelles sont les types de Services Kubernetes ?
**R2.**:
1. ClusterIP (par défaut) :
   - Fournit une adresse IP interne qui permet aux autres ressources dans le même cluster de communiquer avec le Service. 
   - Utilisation typique : Service interne entre les applications dans le cluster (ex. bases de données, API internes).
2. NodePort :
   - Expose le Service sur un port spécifique de chaque nœud du cluster. Cela permet d'accéder au Service à partir de l'extérieur du cluster en utilisant l'adresse IP du nœud et le port. 
   - Utilisation typique : Accès direct aux services internes du cluster depuis l'extérieur, mais avec un port fixe.
3. LoadBalancer :
   - Crée un équilibreur de charge externe (souvent en utilisant des services cloud comme AWS ou Google Cloud) qui redirige le trafic entrant vers le Service. 
   - Utilisation typique : Exposer un service à Internet avec une gestion automatique de la distribution du trafic.
4. ExternalName  :
   - Permet d'exposer un Service en utilisant un nom DNS externe au cluster. Cela permet aux applications de faire référence à des services externes sans avoir à connaître l'adresse IP. 
   - Utilisation typique : Intégration avec des services externes, comme des API tierces.


**Q3.** Qu'est-ce qu'un sélecteur ?
**R3.**:
Le sélecteur dans un Service détermine quels pods ce Service va cibler. Il se base généralement sur des labels attachés aux pods. Quand un Service est créé, Kubernetes crée automatiquement un ensemble d'endpoints qui représente les pods cibles du Service.
Exemple :

        apiVersion: v1
        kind: Service
        metadata:
            name: my-service
        spec:
            selector:
                app: my-app   # Cibler les pods avec ce label
            ports:
             - protocol: TCP
               port: 80
               targetPort: 8080

Si un pod avec le label app=my-app est disponible, il sera inclus dans les endpoints du Service et recevra du trafic.


**Q3.** Comment les Services fonctionnent avec les Pods ?
**R3.**:
Un Service agit comme un proxy pour accéder aux Pods. Lorsque tu définis un Service, tu spécifies un ou plusieurs ports et Kubernetes utilise un **iptables** ou **ipvs** pour router les demandes entrantes vers les bons pods.

Par exemple, si tu as plusieurs pods en arrière-plan, un Service peut rediriger les requêtes vers ces pods de manière équilibrée, en distribuant le trafic selon la configuration de ton équilibreur de charge interne (Round Robin par défaut).

**Q3.**
**R3.**: