
Objectifs: 

- intro aux différents concepts JEE : JPA, DAO, Hibernate, Maven, Jersey
- implémenter les patterns DAO avec le pattern Factory
- implémenter la couche JPA
- relier la base de données MYSQL avec les classes (POJO) à l'aide de DAO (DATA Access Object): objets
  d'accès à la base de données
- Faire de la classe abstraite DAO une classe générique.
- se familiariser avec la lib JERSEY pour exposer des services REST


Notes et ramarques:

- pattern factory= fabrique d'objets; délègue l'instanciation d'obejts à une classe
- avantage = instance concrètes(avec new) se font à une seul endroit => s'il y a des changements à faire, se feront
	à un seul endroit
- Le pattern Factory dans DAO sert à créer les instances d'accès aux données
- Le DAO Factory crée une instance De genericDAO.java pour retourner l'objet DAO souhaité.
- Plus d'infos sur l'imp de DAO : http://openclassrooms.com/courses/apprenez-a-programmer-en-java/lier-ses-tables-avec-des-objets-java-le-pattern-dao


Parties REST :  


- fichier applicationContext.xml 

	= config de l'app = déclare le package à scanner(<component-scan>)
	= y délcarer la config jpa(JAPTRANSACTIONMANAGER)
	= y déclarer les beans utilisé dans l'app
	
	EX: 
		<bean id="bookMarkDAO" class="fr.tp....BookMarkDAO">  --> déclare un bean que l'on pourra injecter 
			à un attribut/property dans une classe quelconque; comme par ex:
		<bean id="bookMarkRestService" class="fr.tp....BookMarkRestService">
			<property name="bookMarkDAO" ref="bookMarkDAO"/>
		</bean>
		
	....ETC
	
- le gestionnaire de transaction utilisé est : JpaTransactionManager.
- on utilise une entityManagerFactory
- FactoryBean crée les JPA EntityManagerFactory
- EntityManagerFactory peuvent être passés à JPA-Based DAO via les injection de dépendance:
- la proprieté "persistentXmlLocation" spécifie la localisation du fichier configurant la couche de 
  persistence JPA(persistence.xml)
- jpaVendorAdapter (HibernateJpaVendorAdapter) spécifie le type de connecteur de base de données utilisé.


	 			

- La couche de persistence JPA 


	- le contrat entre la couche des services et la couche des de persistence se
	  fait via l'interface DAO; en l'occurence : FactoryDAO.java :)
	  
	- Dans le fichier BookMarkDAO.java, on utilise un objet EntityManger, chargé de : API EntityManager 
		est utilisé pour accéder à une base de données dans une unité de travail particulière . 
		Il est utilisé pour créer et supprimer des instances d'entités persistantes , 
		de trouver entités par leur identité de clé primaire
		et d'interroger sur toutes les entités . Cette interface est similaire à la session 
		dans Hibernate.
		
	 - Le context de peristence :
	 	Un contexte de persistance est un ensemble d'instances dans lequel, pour ne importe 
	 	quelle identité d'une entité persistante il ya une instance d'entité unique. Dans le 
	 	contexte de persistance , les instances d'entités et de leur cycle de vie est géré par 
	 	un gestionnaire d'entités particulier. La portée de ce contexte peut être la transsaction
	 - pour insérer une entité dans une BD; on peut soit utiliser la méthode persist() ou merge().
	 


-------------------------------------
- Les Services REST avec JERSEY  ----
-------------------------------------
	- Au sein des objets REST, i-e les objets exposants les données comme web services;
	  on aura seulement besoin d'un FactoryDAO, sur lequel on appelera la méthode voulues, 
	  par ex: create(), delete() ...Etc;
	  
	 - l'opération créant un bookmark: 
	 	@POST
	 	@Consumes({MediaType.APPLICATION_JSON})
	 	@Produces({MediaType.TEXT_HTML})
	 	@Transactional
	 	public Response createBookMark(BookMark bookmark){
	 		BookMarkDAO.<operation_X>
	 	}
	  			
	 			
	 			
		
		