package org.sirmythos.examples;

import org.sirmythos.examples.VO_User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test_Hibernate {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		VO_User newUser = new VO_User();
		newUser.setFeld("Lutz");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;

		try {
			// Neuen Benutzer in Datenbank speichern:
			System.out.println("Session fürs einfügen");
			session = sf.openSession();
			session.beginTransaction();
			session.save(newUser);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// rollback(transaction);
			System.out.println("Fehler bei der Einfüge-Sesseion");
			System.out.println(e.getMessage());
			return;
		}

		try {
			// Nutzer auslesen
			System.out.println("session fürs auslesen");
			session = sf.openSession();
			session.beginTransaction();
			List result = session.createQuery("from VO_User").list();
			for (VO_User user : (List<VO_User>) result) {
				System.out.println("User: " + user.getFeld() + " (" + user.getIntTestID() +")");
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// rollback(transaction);
			System.out.println("Fehler bei der Auslese-Sesseion");
			System.out.println(e.getMessage());
			return;
		}
		
		sf.close();
	}
}