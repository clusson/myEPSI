ReseauSocial

JEE Application

Spécifications

Vous devez créer une application « myEpsi » reposant sur un projet JEE permettant de gérer des messages stockés dans une base de données HsqlDB.

Un message sera défini par un identifiant unique numérique (compteur initialisé à 1) incrémenté automatiquement, un titre (texte de 140 caractères), une description (memo), un statut (public, privé ou archivé), un nombre de vue, une date de création et de modification.

Un message public pourra être vu par tous les utilisateurs contrairement à un message privé.

En arrivant sur la page d’accueil, un utilisateur pourra créer un compte avec un email (qui doit être l’identifiant unique), un mot de passe et une confirmation du mot de passe (pour vérifier qu’il est bien identique.

Un administrateur, créé au préalable pourra gérer les utilisateurs (création, modification, suppression) et les messages (suppression). Il pourra également créer un message qui sera automatiquement public.

La page d’accueil (une fois connecté) présentera la liste des messages (titre + auteur + date de modification) disponibles en affichant ses messages ainsi que les messages publics ou les messages de l’administrateur en excluant les messages archivés des autres utilisateurs.

Des icones devant le titre permettra de reconnaitre les messages des autres utilisateurs, de l’administrateur et les messages archivés.

Il aura également accès à un bouton « créer ».

Le bouton créer permettra d’afficher le formulaire vide avec un bouton ajouter et un bouton annuler. En cliquant sur un ligne d’un message qu’il a écrit, l’utilisateur pourra afficher le détail, la modifier, la supprimer ou revenir à la page d’accueil.

Les pages devront être responsives.

Une url permettra défficher directement un message en consultation avec l’id en paramètre. Par exemple : http://localhost:8080/myEpsi/message?ID=1.

La réponse sera une page HTML de consultation.

Les actions seront implémentées en Servlet et les pages en JSP.

Les logs devront être mis en place avec log4J et afficher une trace de niveau INFO à chaque début d’exécution d’une servlet. Chaque requête devra être logée en niveau DEBUG. Lors d’un test de connexion en erreur, le login testé sera affiché en niveau ERROR.

Au démarrage de l’application 2 logs afficheront en niveau ERROR le nombre de messages présents en base et le nombre d’utilisateurs.

Un composant JMX permettra d’afficher dans la Jconsole le niveau en cours des logs, et permettra de le changer en cliquant sur un bouton debug, info ou error.

Un autre composant JMX permettra d’afficher le nombre de messages dans la base et de poster un message pour l’administrateur.

Des tests d’intégration devront être mis en place avec Junit dans le projets :

Il n’est pas possible de créer 2 comptes avec le même email
Un utilisateur ne peut pas supprimer un message qui ne lui appartient pas
Un utilisateur ne peut pas voir les messages archivés et privés des autres utilisateurs
On ne peut pas supprimer le compte administrateur
Environnement

Eclipse Luna Tomcat 8.0.18 JDK 8.0.131 HsqlDB Livrables Le war de déploiement Les sources sur Git La base de données Les tests unitaires
