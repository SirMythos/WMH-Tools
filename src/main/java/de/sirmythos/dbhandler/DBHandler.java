package de.sirmythos.dbhandler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionManager.
 *
 * @author Lutz Kramer
 */
public class DBHandler {

	/** The Constant persistenzDescriptor. */
	private final static String persistenzDescriptor = "de.sirmythos.database.staticdb";

	/** The emf. */
	private static EntityManagerFactory emf;

	/** The manager. */
	private static EntityManager manager;

	/**
	 * Instantiates a new connection manager.
	 */
	private static void startManager() {
		// Erzeugen einer EntityManagerFactory mit Hilfe des symbolischen
		// Namens aus dem Persistenz Descriptor (persistence.xml)
		emf = Persistence.createEntityManagerFactory(persistenzDescriptor);
		// Erzeugen eines EntityManagers für den Zugriff auf
		// die Datenbank
		manager = emf.createEntityManager();
	}
	
	/**
	 * Instantiates a new connection manager.
	 */
	@SuppressWarnings("unused")
	private static void startManager(final String localPersistenzDescriptor) {
		// Erzeugen einer EntityManagerFactory mit Hilfe des symbolischen
		// Namens aus dem Persistenz Descriptor (persistence.xml)
		emf = Persistence.createEntityManagerFactory(localPersistenzDescriptor);
		// Erzeugen eines EntityManagers für den Zugriff auf
		// die Datenbank
		manager = emf.createEntityManager();
	}

	/**
	 * Close.
	 */
	private static void closeManager() {
		// Freigabe der Ressourcen des EntityManagers
		manager.close();
		// Schließen der EntityManagerFactory und Freigeben der
		// belegten Ressourcen
		emf.close();
	}

	/**
	 * Insert a new object to the database.
	 *
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param object
	 *            The object that sould be insert into the database.
	 */
	public static <T> void insertObject(T object) {
		startManager();
		manager.getTransaction().begin();
		manager.merge(object);
		manager.getTransaction().commit();
		closeManager();
	}

	/**
	 * Gets a specific object from the database.
	 * 
	 * Example: Object o = DBHandler.getObject(Object.class, id);
	 *
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param entityClass
	 *            The classtype of the entity to identify the database.
	 * @param id
	 *            The id of the object in the database.
	 * @return The object from the Database or NULL, if an object with the given
	 *         id is not found.
	 */
	public static <T> T getObject(Class<T> entityClass, int id) {
		startManager();
		T result = manager.find(entityClass, id);
		closeManager();
		return result;

	}

	/**
	 * Gets a list of objects from the database.
	 * 
	 * Example: List<Object> list = DBHandler.getObjects(Object.class);
	 * 
	 * @param <T>
	 *            The class of the entities to identify the classtype.
	 * @param entityClass
	 *            The classtype of the entities to identify the database.
	 * @return The objects from the Database or NULL, if no such object is not
	 *         found.
	 */
	public static <T> List<T> getObjects(Class<T> entityClass) {
		startManager();
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> rootEntry = cq.from(entityClass);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = manager.createQuery(all);
		List<T> result = allQuery.getResultList();
		closeManager();
		return result;

	}

	/**
	 * Update a given object in the database.
	 *
	 * Example: DBHandler.updateObject(object);
	 * 
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param object
	 *            The object to update in the database.
	 */
	public static <T> void updateObject(T object) {
		startManager();
		manager.getTransaction().begin();
		manager.merge(object);
		manager.getTransaction().commit();
		closeManager();
	}

	/**
	 * Removes the given object from the database.
	 * 
	 * Example: DBHandler.remove(object);
	 *
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param object
	 *            The object to remove from the database.
	 */
	public static <T> void removeObject(T object) {
		startManager();
		if (!manager.contains(object)) {
			manager.getTransaction().begin();
			object = manager.merge(object);
			manager.getTransaction().commit();
		}
		manager.getTransaction().begin();
		manager.remove(object);
		manager.getTransaction().commit();
		closeManager();
	}

}