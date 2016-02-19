package org.sirmythos.examples;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {

			// A SessionFactory is set up once for an application!
			// configures settings from hibernate.cfg.xml
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			;
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			} catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we
				// had trouble building the SessionFactory
				// so destroy it manually.
				System.out.println("ERROR bei Erstellung der Session Factory");
				System.out.println(e.getMessage());
				StandardServiceRegistryBuilder.destroy(registry);
			}
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}