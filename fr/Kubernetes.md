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

**Q5.** Quelle stratégies de mise à jour sont valides pour un Daemonset kubernetes ?
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
- [ ] internal.metrics.k8s.io
- [ ] metrics.k8s.io
- [x] **custom.metrics.k8s.io**
- [ ] external.metrics.k8s.io

## Question/Réponse
**Q1.** Dans quel namespace Kubernetes crée-t-il ses objets internes ? <br/>
Réponse : **kube-system**

**Q2.** Quelle sous-commande de kubectl permet de lister l'ensemble des contextes disponibles dans le fichier de configuration de kubernetes (kubeconfig)? <br/>
Réponse : config get-contexts