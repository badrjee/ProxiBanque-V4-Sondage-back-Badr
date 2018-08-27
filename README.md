# ===================================================

# Bienvenue sur ProxiBanqueV4
* Date : 29/07/2018
* Créateurs : Badr Azeri, Quentin Ussunet, Arnaud Vallette

Proxibaqnue V4 est une application Web permettant la création et le suivi des sondages réaliser auprés des clients de Proxibanque, la partie back-end permet de gérer les sondages, et la partie Front-end, est dédiée aux client qui participent aux sondages


# Lancement de l'application

## Pré-requis :
Concernant le back :
* Avoir installé TomCat 8.5.31
* Avoir installé Maven
* Avoir télécharger le fichier **proxybankV4-azeri-ussunet-vallette.war**



## Procédure d'installation :

Pour le back-end :

* Récupérer **pbv4.sql** à la racine du dossier du projet
* créer une BDD **pbv4** MySQL en encodage UTF8 moteur InnoDB
* user :"root", mot de passe :""
* déployer une première fois l'application sur TomCat, le schéma de BDD sera créé automatiquement.
* importer le fichier pbv4.sql dans la BDD
* Consulter le navigateur: localhost:8080/proxibanquev4/

Si vous voulez utilisez les WebServices vous pouvez déployer le projet Angular correspondant
[ProxyFront](https://github.com/AV-DV-87/proxyfront)


# Exemple d'utilisation

### 1- Crée un sondage
Création d'un sondage avec une date d'ouverture et une date de Fin.

### 2- Ouvrir un sondage

### 3- Consulter les détails d'un sondage :
Possibilité de voir le nombre de répondant (reponse négative et positive), le nombre de nouveau client.

### 4- Fermeture d'un sondage :
Possibilité de fermer un sondage en cours.

# ===================================================
