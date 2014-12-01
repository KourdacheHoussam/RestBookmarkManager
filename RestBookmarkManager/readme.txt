********************
Objectifs: *********
********************


- intro aux diff�rents concepts JEE : JPA, DAO, Hibernate, Maven, Jersey
- impl�menter les patterns DAO avec le pattern Factory
- impl�menter la couche JPA
- relier la base de donn�es MYSQL avec les classes (POJO) � l'aide de DAO (DATA Access Object): objets
  d'acc�s � la base de donn�es
- Faire de la classe abstraite DAO une classe g�n�rique.
- se familiariser avec la lib JERSEY pour exposer des services REST


***********************
Notes et ramarques: ***
***********************

- pattern factory= fabrique d'objets; d�l�gue l'instanciation d'obejts � une classe
- avantage = instance concr�tes(avec new) se font � une seul endroit => s'il y a des changements � faire, se feront
	� un seul endroit
- Le pattern Factory dans DAO sert � cr�er les instances d'acc�s aux donn�es
- Le DAO Factory cr�e une instance De genericDAO.java pour retourner l'objet DAO souhait�.
- Plus d'infos sur l'imp de DAO : http://openclassrooms.com/courses/apprenez-a-programmer-en-java/lier-ses-tables-avec-des-objets-java-le-pattern-dao

*******************
Parties REST :  ***
*******************
------------------------------------
- fichier applicationContext.xml ---
------------------------------------
	= config de l'app = d�clare le package � scanner(<component-scan>)
	= y d�lcarer la config jpa(JAPTRANSACTIONMANAGER)
	= y d�clarer les beans utilis� dans l'app
	
	EX: 
		<bean id="bookMarkDAO" class="fr.tp....BookMarkDAO">  --> d�clare un bean que l'on pourra injecter 
			� un attribut/property dans une classe quelconque; comme par ex:
		<bean id="bookMarkRestService" class="fr.tp....BookMarkRestService">
			<property name="bookMarkDAO" ref="bookMarkDAO"/>
		</bean>
		
	....ETC
	
- 			
		
		