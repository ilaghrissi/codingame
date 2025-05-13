# Kafka

## QCM

**Q1.** Soit un cluster Kafka avec 30 noeuds qui contient 50 topics avec pour chaque topic  un facteur de réplication de 5, et 10 partitions.<br/>
Combien de processus de broker s'exécutents sur ce cluster ?
- [x] **25000, un pour chaque partition et leurs réplicats.**
- [ ] 250, un pour chaque partition et topic.
- [ ] 50, un pour chaque topic.
- [ ] 30, un par noeud.
- [ ] 50, un pour chaque partition.

**Q2.** Comment le cluster Kafka sait à quel cluster Zookeeper doit-il se connecter ?
- [ ] Dans zookeeper.url une propriété du fichier server.properties.
- [ ] Le cluster Zookeeper doit être installé sur le même cluster que les brokers Kafka.
- [x] **Dans zookeeper.connect une propriété du fichier server.properties**
- [ ] Kafka n'a pas besoin de Zookeeper pour s'exécuter.

**Q3.** Quelle est la valeur par défaut du "subject name strategy" dans le registre des schémas (Schema registry) ?
- [x] **DefaultSubjectNameStrategy**
- [ ] TopicRecordNameStrategy
- [ ] TopicNameStrategy
- [ ] AvroSerDeNameStrategy
- [ ] RecordNameStrategy

**Q4.** Dans un cluster Kafka avec le compactage des logs activée, peut-on supprimer un message en particuler d'un Topic ?
- [ ] Oui, en utilisant l'API delete.
- [ ] Oui, en affectant la valeur à null pour une clé en particulier.
- [x] **Non, une fois publiés, les enregistrements("records") ne peuvent pas être effacés.**

**Q5.** Quel est le nombre de noeuds Zookeeper recommandé dans un cluster ?
- [ ] 1
- [ ] 3
- [x] **Un nombre impair**
- [ ] Un nombre pair

**Q6.** Où est-ce que kafka Connect stocke les offsets validés (commited) de chaque connecteur connecté au cluster ?
- [ ] FileSystem
- [ ] Zookeeper
- [x] **Topic**
- [ ] En mémoire

**Q7.** Quels sont les cas d'utilisation possibles de Kafka ?
- [x] **Kafka est utilisé pour concevoir des applications qui utilisent des pipelines de données et "stream" des données en temps réel**
- [ ] Kafka peut être utilisé comme base de données transactionnelle
- [ ] Kafka peut être utilisé comme base de données pour OLAP
- [ ] Kafka peut être utilisé comme base de données en mémoire

**Q8.** Dans Kafka, la communication entre les serveurs et les clients est faite à l'aide du
- [ ] Protocole DCCP
- [x] **Protocole TCP**
- [ ] Protocole STCP
- [ ] Protocole UDP
- [ ] Protocole RUDP


**Q9.** Dans un cluster Kafka avec le compactage des logs activée, peut-on supprimer un message en particulier d'un Topic ?
- [x] **Non, une fois publiés, les enregistrements ("records") ne peuvent pas être effacés.**
- [ ] Oui, en effectant la valeur à null pour une clé en particulier
- [ ] Oui, en utilisant l'API delete


**Q10.** Est-ce que plusieurs enregistrements ("records") peuevnt avoir la même clé dans kafka ?
- [ ] Oui, les clé n'ont pas besoin d'être uniques
- [x] **Non, les clés doivent être uniques**

**Q11.** Soit l'enregistrement ("record") suivant :

    {
        "STUDENT_ACAD_CRED_ID": "6733548",
        "SYSU_ID":"0623349",
        "SUBJECT":"PHIL",
        "COURSE":"305",
        "SECTION":"01"
    }

Ici, la base de donnée source est un système RDBMS et nous utilisons Kafka Connect pour en extraire les données.
<br/>
Il nous est demandé, pour des raisons de confidentialité et de sécurité, de supprimer SVSU_ID. Quel est le moyen le plus simple pour ce faire ?
- [ ] Laisser le message aller dans le Topic Kafka et supprimer le champs indésirable au niveau du consommateurs.
- [ ] Ceci n'est pas réalisable avec Kafka Connect, il faut utiliser l'API de Kafka Producer API
- [x] **Utiliser une transformation de type "Single Message Transformation"**
- [ ] Créer un connecteur source kafka spécifique


## Question/Réponse
**Q1.** Quel est le nom du topic où Kafka enregistre les offsets validés("committed") de l'ensemble des consommateurs ?

Réponse : **_ _consumer_offsets**
