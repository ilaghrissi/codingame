# Kafka

✅ Questions de base

**Q1.** Qu’est-ce que Kafka ?

**R1.**
Apache Kafka est une plateforme distribuée de streaming utilisée pour construire des pipelines de données temps réel.
Il fonctionne comme un système de messagerie basé sur le publish-subscribe, ultra rapide et scalable.

**Q1.** Qu’est-ce qu’un topic dans Kafka ?

**R1.**
Un topic est une catégorie ou un nom de flux dans Kafka.
Les producteurs envoient des messages à un topic, et les consommateurs s’abonnent à ce topic pour les lire.

**Q1.** Quelle est la différence entre un producteur et un consommateur ?

**R1.**
- Producteur (Producer) : envoie les messages dans un topic. 
- Consommateur (Consumer) : lit les messages depuis un topic.

**Q1.** Qu’est-ce qu’une partition ?

**R1.**
Chaque topic peut être divisé en partitions, permettant le traitement parallèle des messages et leur répartition sur plusieurs brokers.

**Q1.** À quoi sert un broker Kafka ?

**R1.**
Un broker est un nœud Kafka qui stocke les messages des topics et répond aux requêtes des producteurs et consommateurs.
Un cluster Kafka contient plusieurs brokers.

**Q1.** Qu’est-ce qu’un offset ?

**R1.**
L’offset est un identifiant unique d’un message dans une partition.
Kafka utilise l’offset pour savoir où le consommateur s’est arrêté.

**Q1.** Quelle est la différence entre Kafka et un système de message traditionnel comme JMS ou RabbitMQ ?

**R1.**
🔁 Kafka vs JMS / RabbitMQ :

Critère	Kafka	JMS / RabbitMQ

| **Critère**                       | **Kafka**                                                     | **JMS / RabbitMQ**                                          |
|-----------------------------------|---------------------------------------------------------------|-------------------------------------------------------------|
| **Modèle**                        | Log distribué (publish/subscribe + stockage durable)          | Queue ou Topic (publish/subscribe ou point-à-point)         |
| **Persistance**                   | Messages stockés **durablement sur disque** pendant des jours | Messages souvent supprimés après lecture                    |
| **Débit (Throughput)**            | Très **haut débit** (idéal pour big data, logs, analytics)    | Moins performant sur très gros volumes                      |
| **Stockage des messages**         | **Long terme** (avec offset, permet la relecture)             | **Court terme**, une fois lu, supprimé                      |
| **Traitement de messages**        | **Pull** (le consommateur demande les messages)               | **Push** (le broker pousse les messages)                    |
| **Ordonnancement**                | Ordre **garanti dans une partition**                          | Pas toujours garanti                                        |
| **Scalabilité**                   | Très **scalable horizontalement**                             | Scalabilité limitée                                         |
| **Réplication / Tolérance panne** | Réplication native entre brokers                              | RabbitMQ a la réplication, mais plus complexe à gérer       |
| **Cas d’usage typiques**          | Streaming de données, logs, intégration temps réel            | Messagerie classique, file d’attente, commandes asynchrones |


| Kafka                | RabbitMQ                  |
|----------------------|---------------------------|
| Haute performance    | Basé sur AMQP             |
| Pull                 | Push                      |
| Persistant (log)     | Volatile (queue)          |
| Scalable             | Moins scalable            |
| Ideal pour streaming | Ideal pour transactionnel |

**Q1.** Kafka est-il basé sur push ou pull ?

**R1.**
Kafka utilise un modèle Pull :
Les consommateurs tirent (pull) les messages quand ils sont prêts, ce qui permet un meilleur contrôle du débit.

**Q1.** Qu’est-ce que Zookeeper ? Kafka en a-t-il besoin ?

**R1.**
Kafka utilise Zookeeper pour :
- gérer les métadonnées du cluster 
- suivre les brokers actifs 
- élire le leader des partitions

👉 Kafka 2.8+ peut fonctionner sans Zookeeper grâce à KRaft mode.

**Q1.** Comment Kafka garantit-il l’ordre des messages ?

**R1.**
✅ En une phrase claire :
Kafka garantit que les messages produits dans une même partition sont consommés dans le même ordre, mais l’ordre n’est pas garanti entre différentes partitions d’un même topic.
📌 Détail :
- Un topic peut avoir plusieurs partitions. 
- Chaque partition est un log ordonné : les messages y sont ajoutés séquentiellement (avec un offset croissant). 
- Si un producteur envoie des messages vers une même partition, l’ordre est préservé. 
- Si les messages sont répartis sur plusieurs partitions (ex : par clé ou round-robin), l’ordre global du topic n’est pas garanti.


✅ Questions intermédiaires

**Q1.** Quelle est la différence entre at-most-once, at-least-once, et exactly-once delivery ?

**R1.**
- At most once : pas de duplication, mais risque de perte. 
- At least once : jamais de perte, mais risque de duplication. 
- Exactly once : ni perte ni duplication (plus complexe à mettre en place).

**Q1.** Comment gérer la consommation parallèle dans Kafka ?

**R1.**
✅ En une phrase claire :
Kafka permet la consommation parallèle des messages en répartissant les partitions d’un topic entre les membres d’un consumer group, chacun consommant les messages de ses partitions en parallèle

🧩 Détail étape par étape :
1. Partitions = parallélisme
   Un topic Kafka peut être divisé en plusieurs partitions.

Chaque partition est consommée par un seul consommateur à la fois (dans un consumer group).

Cela permet à plusieurs consommateurs de traiter différentes partitions en parallèle.

2. Consumer Group
   Un consumer group est un groupe de consommateurs qui partagent une tâche.

Kafka répartit automatiquement les partitions entre les consommateurs du groupe.

➤ Exemple :

6 partitions, 3 consommateurs ➝ chaque consommateur lit 2 partitions en parallèle.

3. Multithreading possible côté application
   Un consommateur Kafka peut aussi gérer plusieurs threads internes (par exemple via un @KafkaListener avec concurrency = n en Spring Boot).

4. Auto-rebalancing
   Si un nouveau consommateur rejoint ou quitte le group, Kafka fait un rebalancing automatique pour redistribuer les partitions.

        @KafkaListener(topics = "my-topic", groupId = "group1", concurrency = "3")
        public void listen(String message) {
          // chaque thread traitera en parallèle les messages des partitions assignées
          System.out.println(Thread.currentThread().getName() + " received: " + message);
        }


**Q1.** Qu’est-ce qu’un Consumer Group ?

**R1.**
Un groupe de consommateurs où chaque message est consommé par un seul membre du groupe.
Permet le traitement parallèle avec répartition automatique des partitions.

**Q1.** Comment fonctionne la réplication dans Kafka ?

**R1.**

**Q1.** Qu’est-ce qu’un leader et un follower dans une partition Kafka ?

**R1.**
Chaque partition a un leader (écriture + lecture) et des followers qui répliquent les données.
Si le leader tombe, un follower est élu leader.

**Q1.** Que se passe-t-il lorsqu’un broker tombe ?

**R1.**

**Q1.** Comment Kafka assure-t-il la tolérance aux pannes ?

**R1.**

**Q1.** Comment Kafka stocke-t-il les messages ?

**R1.**
Kafka stocke les messages dans des logs segmentés sur disque, persistants, organisés par partitions, avec des offsets séquentiels.

**Q1.** Qu’est-ce que le log compacting ?

**R1.**
Le log compacting est une fonctionnalité de Kafka qui permet de conserver uniquement la dernière valeur pour chaque clé dans un topic, au lieu de garder tous les messages.
✅ En une phrase claire :
Le log compacting permet à Kafka de supprimer les anciens messages obsolètes avec la même clé, et de conserver uniquement le plus récent, afin de reconstruire facilement l’état actuel d’un système.


🧩 Exemple concret :
Tu as un topic avec les messages suivants (clé = id utilisateur, valeur = nom):

        (id=1, "Ali")
        (id=2, "Sara")
        (id=1, "Ali Ben Ali")  ← mise à jour
        (id=2, null)           ← suppression

Après compacting, Kafka conserve uniquement :

        (id=1, "Ali Ben Ali")  ✅ dernière version
        (id=2, null)           ✅ car null = suppression (optionnel)



**Q1.** Quelle est la différence entre retention et compaction ?

**R1.**
Retention supprime les messages selon leur âge ou leur taille, tandis que compaction conserve uniquement le dernier message pour chaque clé, peu importe son âge.

📊 Tableau comparatif :

| Critère                      | **Retention**                           | **Compaction**                           |
|------------------------------|-----------------------------------------|------------------------------------------|
| **But**                      | Libérer de l’espace                     | Garder **l’état actuel** de chaque clé   |
| **Critère de suppression**   | Âge ou taille des messages              | Doublons de clés (supprime les anciens)  |
| **Durée de conservation**    | Messages supprimés après X heures/jours | Dernier message pour chaque clé conservé |
| **Typique pour**             | Journaux, logs, événements              | Caches, état, base de données clé/valeur |
| **Config Kafka**             | `cleanup.policy=delete`                 | `cleanup.policy=compact`                 |
| **Peut-on avoir les deux ?** | ❌ Pas ensemble dans le même topic       | ✅ Oui : `cleanup.policy=compact,delete`  |

📌 Exemple concret :
🔹 Retention (delete) :
Topic : logs_app

Retention : 7 jours

Kafka supprime tous les messages plus vieux que 7 jours, même s’ils ont des clés uniques.

🔹 Compaction :
Topic : user-status

Kafka garde la dernière valeur pour chaque userId :

(user1, "Online")

(user2, "Offline")

Nouvelle mise à jour : (user1, "Away") → Kafka remplacera l'ancien user1.

🧠 Résumé :
Utilise retention pour gérer des logs temporaires, et compaction pour maintenir un état clé/valeur à jour.

✅ Questions avancées / DevOps

**Q1.** Comment sécuriser Kafka (authentification, ACL) ?

**R1.**

**Q1.** Comment monitorer Kafka ?

**R1.**

**Q1.** Comment configurer la rétention des messages ?

**R1.**

**Q1.** Qu’est-ce que Kafka Streams ?

**R1.**

**Q1.** Quelle est la différence entre Kafka Streams et Kafka Connect ?

**R1.**

**Q1.** Comment connecter Kafka à une base de données ou un système externe ?

**R1.**

**Q1.** Comment effectuer un rebalancing des partitions ?

**R1.**

**Q1.** Peut-on garantir le traitement exactement une fois ?

**R1.**

**Q1.** Comment Kafka assure-t-il la scalabilité horizontale ?

**R1.**

**Q1.** Comment faire des tests unitaires et d’intégration avec Kafka ?

**R1.**


🔁 Bonus : Questions "piège" ou concrètes

**Q1.** Que se passe-t-il si deux consommateurs sont dans le même consumer group ?

**R1.**
✅ En une phrase simple :
Si deux consommateurs sont dans le même consumer group, Kafka répartit automatiquement les partitions du topic entre eux pour qu’ils consomment les messages en parallèle, sans doublon.

📌 Détail clair :
🔸 Comportement dans un consumer group :
Chaque partition d’un topic est assignée à un seul consommateur dans le group.

Donc, les consommateurs ne lisent pas les mêmes messages (pas de duplication).

C’est Kafka qui gère automatiquement cette répartition.

🔹 Exemple :
Supposons un topic commande-topic avec 4 partitions et 2 consommateurs (C1 et C2) dans le même consumer group group-commande.

Kafka fera quelque chose comme :

        C1 lit : partition 0 et 1
        C2 lit : partition 2 et 3

🔄 Et si un consommateur quitte ?
Kafka effectue un rebalancing automatique : les partitions sont redistribuées aux consommateurs restants.

Cela peut provoquer un court arrêt dans la consommation pendant la redistribution.

❗ À retenir :
Même group = consommation répartie (scalabilité).

Groupes différents = chaque groupe reçoit tous les messages (utile pour du broadcast).

Nombre de consommateurs ne doit pas dépasser le nombre de partitions, sinon certains consommateurs seront inactifs (sans partition).

**Q1.** Kafka est-il adapté pour les systèmes transactionnels ?

**R1.**
✅ Réponse courte :
Kafka n’est pas conçu comme un système transactionnel pur (ACID), mais il propose des garanties fortes et des transactions au niveau de la production et consommation de messages, ce qui le rend adapté à certains cas transactionnels distribués.


**Q1.** Que se passe-t-il si un message est mal formé ou non consommable ?

**R1.**

**Q1.** Peut-on supprimer un message dans Kafka ?

**R1.**
✅ Réponse courte :
En temps normal, on ne peut pas supprimer un message précis dans Kafka une fois qu’il a été écrit. Kafka est conçu pour être immuable : les messages sont stockés de manière append-only (on ajoute toujours à la fin).
🧩 Mais il y a des exceptions :
🔹 1. Expiration (Retention-based deletion)
Kafka supprime automatiquement les anciens messages selon les règles de rétention :
- Par durée (retention.ms) → ex. : supprimer les messages après 7 jours.
- Par taille (retention.bytes) → ex. : conserver seulement les 2 Go les plus récents.

➡️ Ce n’est pas manuel, Kafka le gère automatiquement.

🔹 2. Suppression via Log Compaction
Si le topic est configuré en cleanup.policy=compact, tu peux marquer une clé comme supprimée en envoyant un message avec valeur = null.

➡️ Kafka finira par supprimer l'ancien message de cette clé (au moment du compaction).

        producer.send(new ProducerRecord<>("mon-topic", "clé1", null));

🔹 3. Suppression de tout un topic
Tu peux supprimer tout le topic (donc tous ses messages) :

        kafka-topics.sh --delete --topic mon-topic --bootstrap-server localhost:9092

⚠️ Cela supprime tout. Pas recommandé en production.

🔹 4. Modifier les messages ?
❌ Non. Kafka n’autorise pas la modification d’un message une fois écrit. Il est immuable par design.

🧠 Résumé :

| Action                                       | Possible ? | Remarques                  |
|----------------------------------------------|------------|----------------------------|
| Supprimer un **message spécifique**          | ❌          | Pas supporté               |
| Supprimer les messages **après un délai**    | ✅          | Avec `retention.ms`        |
| Supprimer un message **avec log compaction** | ✅          | En envoyant `valeur=null`  |
| Supprimer **tout un topic**                  | ✅          | Supprime tout, attention ! |
| Modifier un message                          | ❌          | Kafka est immuable         |

**Q1.** Kafka est-il un système de messagerie ou un système de log distribué ?

**R1.**

✅ Réponse claire en une phrase :
Kafka est à la fois un système de messagerie et un système de log distribué, mais son design principal est celui d’un log distribué immuable, ce qui le rend bien plus puissant que les systèmes de messagerie traditionnels.

📌 Explication détaillée :
🔹 Kafka comme système de messagerie :
- Permet d’envoyer des messages entre producteurs et consommateurs.
- Gère la diffusion, la scalabilité et la tolérance aux pannes.
- Supporte les consumer groups, le publish/subscribe, etc.

✅ Ce fonctionnement ressemble à RabbitMQ ou ActiveMQ → donc oui, Kafka peut jouer le rôle d’une file de messages.

🔹 Kafka comme système de log distribué :
- Les messages sont stockés durablement dans un log ordonné et immuable.
- Les consommateurs lisent à leur rythme, en gardant un offset (position).
- Kafka ne supprime pas les messages dès qu’ils sont consommés, contrairement aux systèmes de queue classiques.
- Kafka permet de relire l’historique, de faire du replay d’événements, ce qui est essentiel pour les architectures event sourcing, CDC, etc.

| Fonctionnalité            | Système de messagerie | Kafka                            |
|---------------------------|-----------------------|----------------------------------|
| Envoi de messages         | ✅                     | ✅                                |
| Suppression après lecture | ✅                     | ❌ (messages restent disponibles) |
| Historique consultable    | ❌                     | ✅                                |
| Traitement asynchrone     | ✅                     | ✅                                |
| Relecture possible        | ❌                     | ✅                                |
| Persistance durable       | Variable              | ✅                                |

### Mon résumé
- un noeud kafka s'appelle broker
- un ensemble de broker construit un cluster kafka
- un topic est une catégorie de flux dans kafka
- chaque topic est divisé en plusieurs partitions
- les partitions peuvent être sur plusieurs brokers
- offset est un identifiant unique de message dans une partition pour savoir ou le consomateurs s'est arrêté
- Chaque partition a un leader (écriture + lecture) et des followers qui répliquent les données.
  Si le leader tombe, un follower est élu leader.