
#Objectifs: 

* Concepts JEE abord�s: JPA, DAO Factory, Hibernate, Maven, Jersey, Glassfish
* Impl�menter les patterns DAO avec le pattern Factory	
* Impl�menter la couche JPA (persistance des donn�es)
* Relier la base de donn�es MYSQL avec les classes (POJO) � l'aide de DAO (DATA Access Object):  Objets	 d'acc�s � la base de donn�es
* Familiarisation avec la librairie JERSEY pour exposer des services RESTful.

###Architecture g�n�rale (processus) de persistance:
* JPA REST ARCHITECTURE:
![altText](src/main/resources/JPA-REST-Architecture.PNG "title") 
* PERSISTENCE SERVICES REST DATABASE CLIENT ARCHITECTURE
![altText](src/main/resources/Persistence-services-rest-db-client-architecture.PNG "title")


##### NOTES & REMARQUES:
* Pattern factory= fabrique d'objets; d�l�gue l'instanciation d'obejts � une classe
* Avantages = instance concr�tes(avec new) se font � une seul endroit => s'il y a des changements � faire, se feront
		� un seul endroit
* Le pattern Factory dans DAO sert � cr�er les instances d'acc�s aux donn�es
* Le DAO Factory cr�e une instance De genericDAO.java pour retourner l'objet DAO souhait�.
* Plus d'infos sur l'imp de DAO : http://openclassrooms.com/courses/apprenez-a-programmer-en-java/lier-ses-tables-avec-des-objets-java-le-pattern-dao
```sh
/**
 *
 * @author Housssam
 * @version 1 d�c. 2014
 * DAO objects factory
 */
public class DAOFactory {	
	protected static EntityManagerFactory emf=Persistence.createEntityManagerFactory("bookmarkpersistence");
	protected static EntityManager em=emf.createEntityManager();	
	/**
	 * CONSTRUCTOR
	 */
	public DAOFactory() {}
	/**
	 * MANUFACTORING BOOKMARK DAO
	 * @return
	 */
	public static InterfaceDAO<Bookmark> getBookMarkDAO(){
		return new BookmarkDAO(em);
	}
	/**
	 * MANUFACTORING TAG DAO
	 * @return
	 */	
	public static InterfaceDAO<Tag> getTagDAO(){
		return new TagDAO(em);
	}	
```


##COUCHE REST 


* fichier applicationContext.xml :
```sh
<!-- Directory scanning for controllers -->
<context:annotation-config />
<context:component-scan base-package="fr.tp.bookmarkmanager" />
<tx:annotation-driven transaction-manager="transactionManager" />

<!-- Inject helloService to HelloWorldRWS -->
<bean id="helloService" class="fr.tp.bookmarkmanager.services.imp.HelloWorldServiceImp">
</bean>
<bean name="helloworld" class="fr.tp.bookmarkmanager.rest.HelloWorldRWS">
		<property name="helloservice" ref="helloService" />
</bean>
<!-- Inject BookmarkService to BookmarkRWS -->
<bean id="bookmarkService" class="fr.tp.bookmarkmanager.services.imp.BookmarkServiceImp">
</bean>
<bean name="bookmarkRWS" class="fr.tp.bookmarkmanager.rest.BookmarkRWS">
		<property name="bookmarkservice" ref="bookmarkService"></property>
</bean>
<!-- Inject TagService to TagRWS -->
<bean id="tagService" class="fr.tp.bookmarkmanager.services.imp.TagServiceImp"></bean>
	<bean name="tagRWS" class="fr.tp.bookmarkmanager.rest.TagRWS">
		<property name="tagServiceInt" ref="tagService"></property>
</bean>
```	
		
* FactoryBean cr�e les JPA EntityManagerFactory
* EntityManagerFactory peuvent �tre pass�s � JPA-Based DAO via les injection de d�pendance:
* La propriet� "persistentXmlLocation" sp�cifie la localisation du fichier configurant la couche de  persistence JPA(persistence.xml)
* jpaVendorAdapter (HibernateJpaVendorAdapter) sp�cifie le type de connecteur de base de donn�es utilis�.

```sh

protected static EntityManagerFactory 	emf=Persistence.createEntityManagerFactory("bookmarkpersistence");
protected static EntityManager em=emf.createEntityManager();	

```
	 			

## La couche de persistence JPA 
* Le contrat entre la couche des services et la couche des de persistence se
	  fait via l'interface DAO; en l'occurence : FactoryDAO.java :)
* Dans le fichier BookMarkDAO.java, on utilise un objet EntityManger, charg� de : API EntityManager  est utilis� pour acc�der � une base de donn�es dans une unit� de travail particuli�re . 
		Il est utilis� pour cr�er et supprimer des instances d'entit�s persistantes , 
		de trouver entit�s par leur identit� de cl� primaire
		et d'interroger sur toutes les entit�s . Cette interface est similaire � la session dans Hibernate.

####CONFIGURATION DE LA COUCHE PERSISTANCE : persistence.xml

```sh
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd"
	version="1.0">
	<persistence-unit name="bookmarkpersistence" transaction-type="RESOURCE_LOCAL">		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>fr.tp.bookmarkmanager.entities.Bookmark</class>
		<class>fr.tp.bookmarkmanager.entities.PinnedBookmark</class>
		<class>fr.tp.bookmarkmanager.entities.Tag</class>
		<!-- <mapping-file>META-INF/orm.xml</mapping-file> -->
		<exclude-unlisted-classes>false</exclude-unlisted-classes>
		<properties>
			<property name="javax.persistence.jdbc.url"
				value="jdbc:derby://localhost:1527/derbyDataBase;create=true" />
			<property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver" />
			<property name="javax.persistence.jdbc.user" value="user" />
			<property name="javax.persistence.jdbc.password" value="user" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			<property name="hibernate.dialect" value="org.hibernate.dialect.DerbyDialect" />
			<property name="hibernate.transaction.manager_lookup_class"
				value="org.hibernate.transaction.SunONETransactionManagerLookup" />
			<property name="hibernate.archive.autodetection" value="class, hbm" />
		</properties>
	</persistence-unit>
</persistence>
```
**Le context de peristence** :
	 	Un contexte de persistance est un ensemble d'instances dans lequel, pour ne importe  	quelle identit� d'une entit� persistante il ya une instance d'entit� unique. Dans le  	contexte de persistance , les instances d'entit�s et de leur cycle de vie est g�r� par 	un gestionnaire d'entit�s particulier. La port�e de ce contexte peut �tre la transsaction
* Pour ins�rer une entit� dans une BD; on peut soit utiliser la m�thode persist() ou merge().
	 
# Cr�ation de la base de donn�es et g�n�ration des entities:
* D�marrer glassfish database avec la commande: asadmin start-database
* Ajout le perspective "database developpement" � la fen�tre d'eclipse 
		-> OpenPerspective > Other > Database Developement
* Cr�ation d'une connection � la base de donn�es: clique droit sur Database connections > New
![altText](src/main/resources/tables-db.PNG "title") 
* Cr�er une BD en choisissant le "profile" Derby, donner un nom � la base de donn�es et choisir le mot
		de mot de passe, nom utilisateur et le port.
![altText](src/main/resources/database-config.PNG "title") 
* Une fois la connection et la DB cr��e, d�marrer l� en y cliquant droit > connect.
* Dans le fichier hibernate.cfg.xml, ajouter la ligne d�finissant la propri�t� connection 	d'hibernate:	
 
```sh
<hibernate-configuration>  
  <session-factory>  
    <property name="hibernate.connection.driver_class">org.apache.derby.jdbc.ClientDriver</property>     
    <property name="hibernate.dialect">org.hibernate.dialect.DerbyDialect</property>    
    <property name="hibernate.connection.url"> jdbc:derby://localhost:1527/derbyDataBase;create=true</property>
    <property name="hibernate.connection.username">user</property>
    <property name="hibernate.connection.password">user</property>
    <property name="hibernate.hbm2ddl.auto">create</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>      
  </session-factory>  
</hibernate-configuration> 
```		  	
	

##### Changer les propri�t�s du projet, i-e les propri�t�s jpa et hiberante et Ajout de la facet JPA au projet afin que l'on puisse distinguer les entit�s et le mappage effectu�.
* Clique droit sur le projet > propri�t�s > facets : s�lectionner JPA et choisissez la bonne version.	 
* Cela ajoute un nouvelle "facet" � votre projet : "JPA Content".
* D�rouler ce projet vous listera les diff�rentes entit�s scann�es que le moteur JPA a trouv� dans le projet.
 ![altText](src/main/resources/project-jpa-config.PNG "title") 
 
###### D�clarer les entit�s dans le fichier persistence.xml: 
	
* Clique droit sur JPA Content > persistence, puis clique sur "Synchronise Class List": cela rajoute automatiquement les diff�rentes classes Entity dans le fichier "persistence.xml".
```sh
		<class>fr.tp.bookmarkmanager.entities.Bookmark</class>
		<class>fr.tp.bookmarkmanager.entities.PinnedBookmark</class>
		<class>fr.tp.bookmarkmanager.entities.Tag</class>
```		
		
**Remarques :**  

* Sur des grands projets la d�claration de toutes les classes peut surcharger le fichier 	persistence.xml; pour rem�dier � cela on peut envisager l'utilisation d'un fichier orm.xml o� 	l'on	d�clarera toutes les entit�s. Ce fichier sera par la suite import� dans le fichier 	persistence.xml.
* ERROR: L'ajout des annotations @Transaction et @PersistentContext aux op�rations des 	services(@Service) 	suppose l'utilisation	des transaction de type "JTA" au lieu de "RESOURCE_LOCAL" ( 	� d�clarer dans 	persistence.xml :  	transaction-type="JTA".
	
* ERROR :  Constraints 'X' and 'Y' have the same set of columns, which is not allowed. Cette vient du   fait que la cl� primary sp�cifi�e dans Pojo contient des d�clarations de contraintes qu'il ne faut pas utilis�: voici un exemple illustrant cette situation:
```sh
@Entity
@Table(name="BOOKMARKS")
public class Bookmark implements Serializable{	
	private static final long serialVersionUID = -1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bm_id")
	private Integer id;	
	@Column(name="bm_name", nullable = false)
	@Size(max = 40)
	private String name;
	@Column(name="bm_type",nullable = false)
	@Size(max = 60)
	private String type;
	@Column(name="bm_description", nullable=true, length=66)
	private String description;	
	@OneToMany
	private Collection<Tag> tags;
```	
* @GeneratedValue & @Id suffisent pour faire comprendre � hibernate qu'il s'agit d'une cl� primaire.

Les Services REST avec JERSEY  
-------------------------------------
* Au sein des objets REST, i-e les objets exposants les donn�es comme web services;
  on aura seulement besoin d'une interface @Service sur laquelle on appelera les m�thodes voulues, 
  par ex: create(), delete() ...Etc;

* Exemple d'interfaces:
```sh
  public interface BookmarkServiceInt {	
		Integer createBookmark(final Bookmark instance);
		List<Bookmark> getAllBookmarks();
		Integer deleteAllBookmarks();
		Bookmark getBookmarkByID(Integer id);
		void deleteByID(Integer id);	
  }  
```

```sh
@Service
public class BookmarkServiceImp implements BookmarkServiceInt{
	InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
	/**
	 * CREATE BOOKMARK
	 * {@inheritDoc}
	 */	
	public Integer createBookmark(Bookmark instance) {		
		return bm_dao.create(instance);		
	}
	/**
	 * GET ALL BOOKMARKS
	 * {@inheritDoc}
	 */	
	public List<Bookmark> getAllBookmarks() {
		return bm_dao.getAll();
	}
	/**
	 * DELETE ALL BOOKMARKS
	 * {@inheritDoc}
	 * @return 
	 */	
	public Integer deleteAllBookmarks() {
		return bm_dao.deleteAll();
	}
	....
}
```
	  
* Combiner les services � la couche REST : cr�ant ici nos web services : exemple BookmarkRWS.java.
```sh
@Path("/bookmarks")
public class BookmarkRWS {
	private BookmarkServiceInt bookmarkservice;	
	public BookmarkRWS() {}
	/**
	 * add bookmark
	 * @return
	 */
	@GET
	@Path("/add")
	public Response addBookmark(){
		Collection<Tag> tags=null;
		Bookmark bm=new Bookmark("Added_BM", "A", "Favorite A",tags);
		bookmarkservice.createBookmark(bm);			
		return Response.ok(bm, MediaType.APPLICATION_JSON).build();
	}
	/**
	 * Creation bookmark
	 * @param bookmark
	 * @return
	 */
	@POST
	@Path("/add")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createBookMark(
			@QueryParam("name")String name,
			@QueryParam("type")String type,	
			@QueryParam("description")String description){
		Bookmark bm=new Bookmark(name, type, description);
		int id=bookmarkservice.createBookmark(bm);
		return Response.status(200).entity("Un nouveau BookMark vient d'�tre cr�� dont le id ="+id)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, DELETE, GET, PUT").build();
	}	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAllBookmarks() throws IOException, ApplicationException{
		List<Bookmark> bms = bookmarkservice.getAllBookmarks();
		return Response.ok(bms)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}	
		/**
	 * Delete BOOKMARK BY ID
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteBookMarkByID(@PathParam("id") Integer id){
		try{
			bookmarkservice.deleteByID(id);		
		}catch(Exception e){
			e.printStackTrace();			
		}
		return Response.status(200).entity("Bookmark deleted.")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", " DELETE, PUT").build();
	}	
	/**
	 * DELETE ALL BOOKMARKS
	 * @return
	 */
	@DELETE
	@Path("/delete/all")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteAllBookMarks(){
		int nb_deleted=bookmarkservice.deleteAllBookmarks();
		System.out.println("nb :"+nb_deleted);
		return Response.ok(nb_deleted + " bookmarks deleted. ")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Content-Type")
				.header("Access-Control-Allow-Methods", "DELETE, GET, POST,  PUT").build();
	}	
```
- Faut pas oublier de cr�er un setter pour le bean inject� (fichier applicationContext.xml de spring):
```sh
	/** ---------------------------------- Beans Setters ------------------------------- */
	/**
	 * @param bookmarkservice the bookmarkservice to set
	 */
	@Autowired
	public void setBookmarkservice(BookmarkServiceInt bookmarkservice) {
		this.bookmarkservice = bookmarkservice;
	}
```  			
###Remarques et erreurs: 

* Dans le fichier web.xml: l'erreur "java.lang.ClassNotFoundException: 		org.glassfish.jersey.servlet.ServletContainer" vient du fait   que la version de jersey que vous utilisez n'est pas celle qu'il faut d�clarer dans dans web.xml:
faut remplacer : " org.glassfish.jersey.servlet.ServletContainer " de la version 2 PAR :
la version 1 : " com.sun.jersey.spi.container.servlet.ServletContainer" .
		
* Si glassfish ne d�marre pas ou qu'il est bloqu� sur "65%", je recommande la suppression du r�pertoire	osgi-cache du domaine glassfish utilis�.
	
	

Copyright : Houssam KOURDACHE [Cybercratos]
[Cybercratos]:http://cybercratos.com
