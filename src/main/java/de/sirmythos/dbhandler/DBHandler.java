/*
 * Project: WMH-Tools
 * Package: de.sirmythos.dbhandler
 * File:	DBHandler.java
 *
 * Date:	21.09.2016
 * Time:	10:33:27
 * 
 * @author 	SirMythos
 */
package de.sirmythos.dbhandler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionManager.
 */
public class DBHandler {

	/** The Constant persistenzDescriptors. */
	private final static String persistenzDescriptorDynamicDB = "de.sirmythos.database.dynamicDB";

	/** The Constant persistenzDescriptorStaticDB. */
	private final static String persistenzDescriptorStaticDB = "de.sirmythos.database.staticDB";

	/** The emf. */
	private static EntityManagerFactory emf;

	/** The manager. */
	private static EntityManager manager;

	/**
	 * Instantiates a new connection manager.
	 *
	 * @param database
	 *            the database
	 */
	private static void startManager(final Database database) {
		switch (database) {
		case DynamicDB:
			startManagerDynamicDB();
			break;
		case StaticDB:
			startManagerStaticDB();
			break;
		}

	}

	/**
	 * Instantiates a new connection manager for the dynamicDB.
	 */
	private static void startManagerDynamicDB() {
		// Erzeugen einer EntityManagerFactory mit Hilfe des symbolischen
		// Namens aus dem Persistenz Descriptor (persistence.xml)
		emf = Persistence.createEntityManagerFactory(persistenzDescriptorDynamicDB);
		// Erzeugen eines EntityManagers für den Zugriff auf
		// die Datenbank
		manager = emf.createEntityManager();
	}

	/**
	 * Instantiates a new connection manager for the staticDB.
	 */
	private static void startManagerStaticDB() {
		// Erzeugen einer EntityManagerFactory mit Hilfe des symbolischen
		// Namens aus dem Persistenz Descriptor (persistence.xml)
		emf = Persistence.createEntityManagerFactory(persistenzDescriptorStaticDB);
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
	 * Creates a new object for the Database.
	 *
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param entityClass
	 *            The classtype of the entity to identify the database.
	 * @param db
	 *            the db
	 * @return The newly createt object.
	 */
	@SuppressWarnings("finally")
	public static <T> T createObject(Class<T> entityClass, Database db) {
		T result = null;
		startManager(db);
		manager.getTransaction().begin();
		try {
			result = entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = null;
		} finally {
			manager.flush();
			manager.getTransaction().commit();
			closeManager();
			return result;
		}

	}

	/**
	 * Insert a new object to the database.
	 *
	 * @param <T>
	 *            The class of the entity to identify the classtype.
	 * @param object
	 *            The object that sould be insert into the database.
	 * @param db
	 *            the db
	 * @return the t
	 */
	public static <T> T insertObject(T object, Database db) {
		startManager(db);
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
		closeManager();
		return object;

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
	 * @param db
	 *            the db
	 * @return The object from the Database or NULL, if an object with the given
	 *         id is not found.
	 */
	public static <T> T getObject(Class<T> entityClass, int id, Database db) {
		startManager(db);
		EntityTransaction trans = manager.getTransaction();
		T result = manager.find(entityClass, id);
		trans.begin();
		manager.flush();
		trans.commit();
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
	 * @param db
	 *            the db
	 * @return The objects from the Database or NULL, if no such object is not
	 *         found.
	 */
	public static <T> List<T> getObjects(Class<T> entityClass, Database db) {
		startManager(db);
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
	 * @param db
	 *            the db
	 */
	public static <T> void updateObject(T object, Database db) {
		startManager(db);
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
	 * @param db
	 *            the db
	 */
	public static <T> void removeObject(T object, Database db) {
		startManager(db);
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