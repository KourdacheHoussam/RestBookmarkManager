
#Objectifs: 

	- intro aux différents concepts JEE : JPA, DAO, Hibernate, Maven, Jersey
	- implémenter les patterns DAO avec le pattern Factory
	- implémenter la couche JPA
	- relier la base de données MYSQL avec les classes (POJO) à l'aide de DAO (DATA Access Object): objets
	  d'accès à la base de données
	- Faire de la classe abstraite DAO une classe générique.
	- se familiariser avec la lib JERSEY pour exposer des services REST

##### Notes et ramarques:
	- pattern factory= fabrique d'objets; délègue l'instanciation d'obejts à une classe
	- avantage = instance concrètes(avec new) se font à une seul endroit => s'il y a des changements à faire, se feront
		à un seul endroit
	- Le pattern Factory dans DAO sert à créer les instances d'accès aux données
	- Le DAO Factory crée une instance De genericDAO.java pour retourner l'objet DAO souhaité.
	- Plus d'infos sur l'imp de DAO : http://openclassrooms.com/courses/apprenez-a-programmer-en-java/lier-ses-tables-avec-des-objets-java-le-pattern-dao


##Parties REST 


	- fichier applicationContext.xml :
	
		- config de l'app = déclare le package à scanner(<component-scan>)
		- y délcarer la config jpa(JAPTRANSACTIONMANAGER)
		- y déclarer les beans utilisé dans l'app
		
		Exemple: 
			<bean id="bookMarkDAO" class="fr.tp....BookMarkDAO">  --> déclare un bean que l'on pourra injecter 
				à un attribut/property dans une classe quelconque; comme par ex:
			<bean id="bookMarkRestService" class="fr.tp....BookMarkRestService">
				<property name="bookMarkDAO" ref="bookMarkDAO"/>
			</bean>
			
		...etc.
		
	- le gestionnaire de transaction utilisé est : JpaTransactionManager.
	- on utilise une entityManagerFactory
	- FactoryBean crée les JPA EntityManagerFactory
	- EntityManagerFactory peuvent être passés à JPA-Based DAO via les injection de dépendance:
	- la proprieté "persistentXmlLocation" spécifie la localisation du fichier configurant la couche de 
	  persistence JPA(persistence.xml)
	- jpaVendorAdapter (HibernateJpaVendorAdapter) spécifie le type de connecteur de base de données utilisé.


	 			

## La couche de persistence JPA 


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
	 
# Création de la base de données et génération des entities:
	- Démarrer glassfish database avec la commande: asadmin start-database
	- Ajout le perspective "database developpement" à la fenêtre d'eclipse 
		-> OpenPerspective > Other > Database Developement
	- Création d'une connection à la base de données: clique droit sur Database connections > New
	- Créer une BD en choisissant le "profile" Derby, donner un nom à la base de données et choisir le mot
		de mot de passe, nom utilisateur et le port.
	- Une fois la connection et la DB créée, démarrer là en y cliquant droit > connect.

####### Configuration le projet de sorte à ce qu'il se connecte sur la bonne database:
	- Dans le fichier persistence.xml, ajoutez l'url suivante :
			<property name="javax.persistence.jdbc.url" 					value="jdbc:derby://localhost:1527/derbyDataBase;create=true"/>
	
	- Et dans le fichier hibernate.cfg.xml, ajouter la ligne définissant la propriété connection 		d'hibernate:	 
		  	<property name="hibernate.connection.url" > 				jdbc:derby://localhost:1527/derbyDataBase;create=true</property>
	

####### Changer les propriétés du projet, i-e les propriétés jpa et hiberante et Ajout de la facet JPA au projet afin que l'on puisse distinguer les entités et le mappage effectué.
	- Clique droit sur le projet > propriétés > facets : sélectionner JPA et choisissez la bonne version.
	 
	 - Cela ajoute un nouvelle "facet" à votre projet : "JPA Content".
	 - Dérouler ce projet vous listera les différentes entités scannées que le moteur jpa a trouvé 
	 	dans le projet.

####### Déclarer les entités dans le fichier persistence.xml: 
	- Clique droit sur JPA Content > persistence, puis clique sur "Synchronise Class List": cela
		rajoute automatiquement les différentes classes Entity dans le fichier persistence.xml.
		
		
**Remarques :**  

	- Sur des grands projets la déclaration de toutes les classes peut surcharger le fichier 	persistence.xml; pour remédier à cela on peut envisager l'utilisation d'un fichier orm.xml où 	l'on	déclarera toutes les entités. Ce fichier sera par la suite importé dans le fichier 	persistence.xml.
	- ERROR: L'ajout des annotations @Transaction et @PersistentContext aux opérations des 	services(@Service) 	suppose l'utilisation	des transaction de type "JTA" au lieu de "RESOURCE_LOCAL" ( 	à déclarer dans 	persistence.xml :  	transaction-type="JTA".
	
	-ERROR :  Constraints 'X' and 'Y' have the same set of columns, which is not allowed. Cette vient du   fait que la clé primary spécifiée dans Pojo contient des déclarations de contraintes qu'il ne faut pas utilisé: voici un exemple illustrant cette situation:
	@Id
	@GeneratedValue
	@Column(name="bm_id", unique=true, nullable=false)
	private Integer id;
	
	Doit être remplacé par:
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bm_id")
	private Integer id;

	* @GeneratedValue & @Id suffisent pour faire comprendre à hibernate qu'il s'agit d'une clé primaire.
 Les Services REST avec JERSEY  
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
	  			
###Remarques et erreurs:
		- 	dans le fichier web.xml: l'erreur "java.lang.ClassNotFoundException: 		org.glassfish.jersey.servlet.ServletContainer" vient du fait que la version de jersey que 
		vous utilisez n'est pas celle qu'il faut déclarer dans dans web.xml:
		faut remplacer : " org.glassfish.jersey.servlet.ServletContainer " de la version 2 PAR :
		la version 1 : " com.sun.jersey.spi.container.servlet.ServletContainer" .
	
###Difficultés rencontrées:
	- Problème d'injection : l'utilisaiton de l'annotation @InjectParam n'a pas réussi à injecter 
	l'interface dans le bean Rest HelloWorld.java. L'objet helloService est vide car il n'a pas été instancié
	lors de l'injection. La déclaration des beans dans le fichier applicationContext.xml n'a pas résolu le problème.
	C'est pourquoi j'ai décidé de déployer mes composants sur GlassFish au lieu de Tomcat/Jboss.
	
	- Cela dit, sur glassFish l'injection de dépendance marche trés bien avec les deux méthodes: par ajout de 	@Autowired sur la proprité ou par déclaration des beans dans le applicationContext.xml + ajout du setter 	(setHelloservice) dans le 	bean HelloWorld.java.	
	
	