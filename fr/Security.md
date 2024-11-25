# Security

## Question/Réponse

### JWT
**Q1.** C'est quoi JWT ? et expliquez-moi sa structure ?

**R1.**: 
- JSON Web Token est un standard ouvert utilisé pour transmettre des informations de manière sécurisée entre deux parties (généralement un client et un serveur)
- Utile pour des architectures RESTful où le serveur ne stocke pas l'état des utilisateurs.
- Un JWT est constitué de trois parties, séparées par des points (.) :
  - Header (En-tête) : Contient des informations sur le type de token et l'algorithme de signature utilisé.
    - exemple : 
    `{
      "alg": "HS256",
      "typ": "JWT"
      }`
    - Payload (Charge utile) : Contient les données ou claims à transmettre.
      1. Réservés (standards) : Prédéfinis par le standard JWT, comme :
        - iss (issuer) : Émetteur du token.
        - sub (subject) : Sujet du token (exemple : l'utilisateur).
        - exp (expiration) : Date d’expiration du token.
      2. Personnalisés : Définis selon les besoins spécifiques de l'application (par exemple, un identifiant d'utilisateur ou des rôles)

      `{
      "sub": "1234567890",
      "name": "Jane Doe",
      "iat": 1516239022
      }`

   - Signature : Garantit l’intégrité et l’authenticité du token.
    ` HMACSHA256(
     base64UrlEncode(header) + "." +
     base64UrlEncode(payload),
     secret
     )`


**Q2.** Quelles sont les limitations de JWT ?
**R2.** :
- Par défaut, les JWT ne sont pas chiffrés. Toute personne ayant accès au token peut lire son contenu. Utilisez JWE (JSON Web Encryption) si nécessaire.
- Un JWT révoqué ou expiré ne peut pas être invalidé facilement sans une liste noire côté serveur.

### OIDC

**Q1.** C'est quoi OIDC ?
**R1.** :
- (OpenID Connect) est une couche d'identité construite sur le protocole OAuth 2.0
- permet à une application (le client) de vérifier l'identité d'un utilisateur et d'obtenir des informations sur lui de manière sécurisée
- utilisé pour l'authentification des utilisateurs
- permet aux développeurs d'intégrer facilement l'authentification sans gérer eux-mêmes les mots de passe.
- Interopérabilité : Les utilisateurs peuvent s'authentifier via des fournisseurs d'identité (IDP) tiers comme Google, Microsoft, ou Okta.

**Q2.** Comment fonctionne OIDC ?
**R2.**
- Redirection vers l’IDP : L'utilisateur tente d'accéder à une application protégée. L'application redirige l'utilisateur vers le fournisseur d'identité (IDP) pour s'authentifier.
- Authentification auprès de l’IDP : L'utilisateur entre ses identifiants (par exemple, via une page de connexion Google).
- Emission des tokens : Une fois authentifié, l’IDP génère des tokens (notamment un ID Token) et les retourne à l’application via un mécanisme sécurisé (redirection HTTP ou API).
- Vérification et autorisation : L'application vérifie le ID Token pour confirmer l'identité de l'utilisateur et peut utiliser l'Access Token pour accéder à des ressources API en son nom


**Q3.** Principaux concepts d'OIDC ?
**R3.** :
1. Identity Provider (IDP) : Un service tiers qui gère l'identité de l'utilisateur (ex. Google, Facebook, Keycloak), Il émet des tokens pour permettre l'authentification
2. Tokens OIDC : OIDC utilise principalement trois types de tokens :
   - ID Token : Fournit des informations sur l'utilisateur (nom, email, etc.). C'est la clé pour l'authentification. 
   - Access Token : Permet d'accéder aux ressources protégées (API). 
   - Refresh Token : Permet de demander de nouveaux tokens sans authentifier à nouveau l'utilisateur.
3. Relying Party (RP) : L'application ou service qui utilise OIDC pour authentifier les utilisateurs via un IDP.

**Q4.** Quelles sont les limitations d'OIDC ?

### OAUTH 2
**Q1.** C'est quoi OAuth 2.0 ?
**R1.** Est un protocole standard d'autorisation qui permet à une application (appelée le client) d'obtenir un accès limité aux ressources d'un utilisateur sur un autre service,

**Q2.** Principaux concepts d'OAuth 2.0 ?
**R2.** :
- Resource Owner (propriétaire des ressources) : L'utilisateur qui possède les données ou les ressources que le client souhaite accéder (ex. : vous, en tant qu'utilisateur Google).
- Client (application) : L'application qui demande l'accès aux ressources au nom de l'utilisateur (ex. : une application qui veut accéder à vos emails Google).
- Resource Server (serveur de ressources) : Le serveur qui contient les données ou les ressources protégées (ex. : API de Google).
- Authorization Server (serveur d'autorisation) : Le service qui gère l'authentification de l'utilisateur et émet les tokens d'accès.
  Souvent combiné avec le serveur de ressources.
- Tokens (Jetons) 
  - Access Token : Permet d'accéder aux ressources protégées.
  - Refresh Token : Permet de renouveler un access token expiré.

**Q3.** Comment fonctionne OAuth 2.0 ?
**R3.** :
Un scénario typique implique les étapes suivantes :

1. L'utilisateur demande une action :
Par exemple, une application (le client) souhaite accéder à vos contacts Google.

2. Redirection vers le serveur d'autorisation :
L'application redirige l'utilisateur vers un formulaire de connexion du fournisseur (ex. : Google).

3. Consentement utilisateur :
L'utilisateur s'authentifie (avec ses identifiants Google) et consent à accorder l'accès à l'application.

4. Retour au client avec un code :
Une fois que l'utilisateur accorde l'accès, le serveur d'autorisation retourne un code d'autorisation au client.

5. Échange du code contre un token :
Le client envoie le code d'autorisation au serveur d'autorisation et reçoit un access token.

6. Utilisation du token pour accéder aux ressources :
Le client utilise l'access token pour appeler les API du serveur de ressources et accéder aux données de l'utilisateur


**Q4.** Quelles sont les limitations d'OAuth 2.0 ?
**R4.**
- Dépend entièrement de HTTPS pour la sécurité.

### SAML 2
**Q1.** C'est quoi SAML 2.0 ?
**R1.**

**Q2.** C'est quoi Principaux concepts de SAML 2.0 ?
**R2.**

**Q3.** Comment fonctionne SAML 2.0
**R3.**

**Q4.** Quelles sont les limitations d'OIDC ?
**R4.**
- Complexité : Configuration initiale et gestion des métadonnées XML.
- Limitations pour les API modernes : Moins adapté que OAuth 2.0 pour l'accès aux API REST.
- Support limité dans certaines applications : Moins courant dans les écosystèmes modernes par rapport à OAuth 2.0.
