package project1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project1.model.Item;
import project1.model.Person;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration= new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person=session.get(Person.class,10);
            Item item=session.get(Item.class,6);
            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);



            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
