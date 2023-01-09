import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class house {
    public static void main(String[] args){
        Paintings starry = new Paintings(2,
                "Hall",
                "Van Gogh",
                "Starry Night Over the Rhone",
                1888);
        Paintings bloss = new Paintings(1,
                "Corridor",
                "Van Gogh",
                "Almond Blossoms",
                1890);

        Artists van = new Artists("Van Gogh", 2);
        //van.setPainting("Almond Blossoms");


        Configuration con = new Configuration().configure().addAnnotatedClass(Paintings.class).addAnnotatedClass(Artists.class); //hibernate.cfg.xml
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        //session.save(starry);
        session.save(bloss);
        //session.save(van); //creating/updating table

        //starry = (Paintings) session.get(Paintings.class,1);

        tx.commit();
        //System.out.println(starry);
    }
}
