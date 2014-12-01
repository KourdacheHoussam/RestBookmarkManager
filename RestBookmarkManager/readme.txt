********************
Objectifs: *********
********************


- intro aux différents concepts JEE : JPA, DAO, Hibernate, Maven, Jersey
- implémenter les patterns DAO avec le pattern Factory
- implémenter la couche JPA
- relier la base de données MYSQL avec les classes (POJO) à l'aide de DAO (DATA Access Object): objets
  d'accès à la base de données
- Faire de la classe abstraite DAO une classe générique.
- se familiariser avec la lib JERSEY pour exposer des services REST


***********************
Notes et ramarques: ***
***********************

- pattern factory= fabrique d'objets; délègue l'instanciation d'obejts à une classe
- avantage = instance concrètes(avec new) se font à une seul endroit => s'il y a des changements à faire, se feront
	à un seul endroit
- Le pattern Factory dans DAO sert à créer les instances d'accès aux données
- Le DAO Factory crée une instance De genericDAO.java pour retourner l'objet DAO souhaité.


