package org.sirmythos.examples;

import org.sirmythos.examples.VO_User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

 
public class Test_Hibernate
{
    public static void main(String[] args)
    {
        VO_User newUser = new VO_User();
        newUser.setFeld("Lutz");

        SessionFactory sf       = HibernateUtil.getSessionFactory();
        Session session         = null;
        Transaction transaction = null;
 
        // Neuen Benutzer in Datenbank speichern:
        try
        {
            session             = sf.getCurrentSession();
            transaction         = session.beginTransaction();
            session.save(newUser);
            transaction.commit();
        }
        catch (Exception e)
        {
            // rollback(transaction);
            System.out.println(e.getMessage());
        }
    }
}