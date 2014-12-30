
#Objectifs: 

	- intro aux diff�rents concepts JEE : JPA, DAO, Hibernate, Maven, Jersey
	- impl�menter les patterns DAO avec le pattern Factory
	- impl�menter la couche JPA
	- relier la base de donn�es MYSQL avec les classes (POJO) � l'aide de DAO (DATA Access Object): objets
	  d'acc�s � la base de donn�es
	- Faire de la classe abstraite DAO une classe g�n�rique.
	- se familiariser avec la lib JERSEY pour exposer des services REST

##### Notes et ramarques:
	- pattern factory= fabrique d'objets; d�l�gue l'instanciation d'obejts � une classe
	- avantage = instance concr�tes(avec new) se font � une seul endroit => s'il y a des changements � faire, se feront
		� un seul endroit
	- Le pattern Factory dans DAO sert � cr�er les instances d'acc�s aux donn�es
	- Le DAO Factory cr�e une instance De genericDAO.java pour retourner l'objet DAO souhait�.
	- Plus d'infos sur l'imp de DAO : http://openclassrooms.com/courses/apprenez-a-programmer-en-java/lier-ses-tables-avec-des-objets-java-le-pattern-dao


##Parties REST 


	- fichier applicationContext.xml :
	
		- config de l'app = d�clare le package � scanner(<component-scan>)
		- y d�lcarer la config jpa(JAPTRANSACTIONMANAGER)
		- y d�clarer les beans utilis� dans l'app
		
		Exemple: 
			<bean id="bookMarkDAO" class="fr.tp....BookMarkDAO">  --> d�clare un bean que l'on pourra injecter 
				� un attribut/property dans une classe quelconque; comme par ex:
			<bean id="bookMarkRestService" class="fr.tp....BookMarkRestService">
				<property name="bookMarkDAO" ref="bookMarkDAO"/>
			</bean>
			
		...etc.
		
	- le gestionnaire de transaction utilis� est : JpaTransactionManager.
	- on utilise une entityManagerFactory
	- FactoryBean cr�e les JPA EntityManagerFactory
	- EntityManagerFactory peuvent �tre pass�s � JPA-Based DAO via les injection de d�pendance:
	- la propriet� "persistentXmlLocation" sp�cifie la localisation du fichier configurant la couche de 
	  persistence JPA(persistence.xml)
	- jpaVendorAdapter (HibernateJpaVendorAdapter) sp�cifie le type de connecteur de base de donn�es utilis�.


	 			

## La couche de persistence JPA 


	- le contrat entre la couche des services et la couche des de persistence se
	  fait via l'interface DAO; en l'occurence : FactoryDAO.java :)
	  
	- Dans le fichier BookMarkDAO.java, on utilise un objet EntityManger, charg� de : API EntityManager 
		est utilis� pour acc�der � une base de donn�es dans une unit� de travail particuli�re . 
		Il est utilis� pour cr�er et supprimer des instances d'entit�s persistantes , 
		de trouver entit�s par leur identit� de cl� primaire
		et d'interroger sur toutes les entit�s . Cette interface est similaire � la session 
		dans Hibernate.
		
	 - Le context de peristence :
	 	Un contexte de persistance est un ensemble d'instances dans lequel, pour ne importe 
	 	quelle identit� d'une entit� persistante il ya une instance d'entit� unique. Dans le 
	 	contexte de persistance , les instances d'entit�s et de leur cycle de vie est g�r� par 
	 	un gestionnaire d'entit�s particulier. La port�e de ce contexte peut �tre la transsaction
	 - pour ins�rer une entit� dans une BD; on peut soit utiliser la m�thode persist() ou merge().
	 
# Cr�ation de la base de donn�es et g�n�ration des entities:
	- D�marrer glassfish database avec la commande: asadmin start-database
	- Ajout le perspective "database developpement" � la fen�tre d'eclipse 
		-> OpenPerspective > Other > Database Developement
	- Cr�ation d'une connection � la base de donn�es: clique droit sur Database connections > New
	- Cr�er une BD en choisissant le "profile" Derby, donner un nom � la base de donn�es et choisir le mot
		de mot de passe, nom utilisateur et le port.
	- Une fois la connection et la DB cr��e, d�marrer l� en y cliquant droit > connect.

####### Configuration le projet de sorte � ce qu'il se connecte sur la bonne database:
	- Dans le fichier persistence.xml, ajoutez l'url suivante :
			<property name="javax.persistence.jdbc.url" 					value="jdbc:derby://localhost:1527/derbyDataBase;create=true"/>
	
	- Et dans le fichier hibernate.cfg.xml, ajouter la ligne d�finissant la propri�t� connection 		d'hibernate:	 
		  	<property name="hibernate.connection.url" > 				jdbc:derby://localhost:1527/derbyDataBase;create=true</property>
	

####### Changer les propri�t�s du projet, i-e les propri�t�s jpa et hiberante et Ajout de la facet JPA au projet afin que l'on puisse distinguer les entit�s et le mappage effectu�.
	- Clique droit sur le projet > propri�t�s > facets : s�lectionner JPA et choisissez la bonne version.
	 
	 - Cela ajoute un nouvelle "facet" � votre projet : "JPA Content".
	 - D�rouler ce projet vous listera les diff�rentes entit�s scann�es que le moteur jpa a trouv� 
	 	dans le projet.

####### D�clarer les entit�s dans le fichier persistence.xml: 
	- Clique droit sur JPA Content > persistence, puis clique sur "Synchronise Class List": cela
		rajoute automatiquement les diff�rentes classes Entity dans le fichier persistence.xml.
		
		
**Remarques :**  

	- Sur des grands projets la d�claration de toutes les classes peut surcharger le fichier 	persistence.xml; pour rem�dier � cela on peut envisager l'utilisation d'un fichier orm.xml o� 	l'on	d�clarera toutes les entit�s. Ce fichier sera par la suite import� dans le fichier 	persistence.xml.
	- ERROR: L'ajout des annotations @Transaction et @PersistentContext aux op�rations des 	services(@Service) 	suppose l'utilisation	des transaction de type "JTA" au lieu de "RESOURCE_LOCAL" ( 	� d�clarer dans 	persistence.xml :  	transaction-type="JTA".
	
	-ERROR :  Constraints 'X' and 'Y' have the same set of columns, which is not allowed. Cette vient du   fait que la cl� primary sp�cifi�e dans Pojo contient des d�clarations de contraintes qu'il ne faut pas utilis�: voici un exemple illustrant cette situation:
	@Id
	@GeneratedValue
	@Column(name="bm_id", unique=true, nullable=false)
	private Integer id;
	
	Doit �tre remplac� par:
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bm_id")
	private Integer id;

	* @GeneratedValue & @Id suffisent pour faire comprendre � hibernate qu'il s'agit d'une cl� primaire.
 Les Services REST avec JERSEY  
-------------------------------------
	- Au sein des objets REST, i-e les objets exposants les donn�es comme web services;
	  on aura seulement besoin d'un FactoryDAO, sur lequel on appelera la m�thode voulues, 
	  par ex: create(), delete() ...Etc;
	  
	 - l'op�ration cr�ant un bookmark: 
	 	@POST
	 	@Consumes({MediaType.APPLICATION_JSON})
	 	@Produces({MediaType.TEXT_HTML})
	 	@Transactional
	 	public Response createBookMark(BookMark bookmark){
	 		BookMarkDAO.<operation_X>
	 	}
	  			
###Remarques et erreurs:
		- 	dans le fichier web.xml: l'erreur "java.lang.ClassNotFoundException: 		org.glassfish.jersey.servlet.ServletContainer" vient du fait que la version de jersey que 
		vous utilisez n'est pas celle qu'il faut d�clarer dans dans web.xml:
		faut remplacer : " org.glassfish.jersey.servlet.ServletContainer " de la version 2 PAR :
		la version 1 : " com.sun.jersey.spi.container.servlet.ServletContainer" .
	
###Difficult�s rencontr�es:
	- Probl�me d'injection : l'utilisaiton de l'annotation @InjectParam n'a pas r�ussi � injecter 
	l'interface dans le bean Rest HelloWorld.java. L'objet helloService est vide car il n'a pas �t� instanci�
	lors de l'injection. La d�claration des beans dans le fichier applicationContext.xml n'a pas r�solu le probl�me.
	C'est pourquoi j'ai d�cid� de d�ployer mes composants sur GlassFish au lieu de Tomcat/Jboss.
	
	- Cela dit, sur glassFish l'injection de d�pendance marche tr�s bien avec les deux m�thodes: par ajout de 	@Autowired sur la proprit� ou par d�claration des beans dans le applicationContext.xml + ajout du setter 	(setHelloservice) dans le 	bean HelloWorld.java.	
	
	