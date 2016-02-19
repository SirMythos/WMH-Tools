package org.sirmythos.examples;

import org.sirmythos.examples.VO_User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			// Create configuration for use
			Configuration configuration = new Configuration();
			configuration.addPackage("org.sirmythos.examples");
			configuration.addAnnotatedClass(VO_User.class);
			configuration.configure();
			System.out.println("Configuration erstellt");

			// Create the SessionFactory from hibernate.cfg.xml
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();
			System.out.println("Standard Registry erstellt");

			// Metadata metadata = new
			// MetadataSources(standardRegistry).getMetadataBuilder().build();
			// sessionFactory = metadata.getSessionFactoryBuilder().build();

			sessionFactory = configuration.buildSessionFactory(standardRegistry);
			// configuration.buildSessionFactory(serviceRegistry);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}