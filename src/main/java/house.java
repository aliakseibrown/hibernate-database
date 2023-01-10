import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Collection;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class house {
    public static void main(String[] args){
        Paintings a = null;
        Paintings b = null;
//        Paintings starry = new Paintings(2,
//                "Hall",
//                "Van Gogh",
//                "Starry Night Over the Rhone",
//                1888);//72 cm x 92 cm
//        Paintings bloss = new Paintings(1,
//                "Corridor",
//                "Van Gogh",
//                "Almond Blossoms",
//                1890);//74 cm x 92 cm
//        Paintings birth = new Paintings(3,
//                "Hall",
//                "William-Adolphe Bouguereau",
//                "The Birth of Venus",
//                1879); // 3 m x 2.18 m
//
//
//        Artists van = new Artists("Van Gogh", 2);
//        Artists boug = new Artists("William-Adolphe Bouguereau", 1);
//        van.getPaintings().add(starry);
//        van.getPaintings().add(bloss);
//        boug.getPaintings().add(birth);

        //van.setPainting("Almond Blossoms");


        Configuration con = new Configuration().configure().addAnnotatedClass(Paintings.class).addAnnotatedClass(Artists.class); //hibernate.cfg.xml
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        session.save(starry);
//        session.save(bloss);
//        session.save(birth);
//        session.save(van); //creating/updating table
        a = (Paintings) session.get(Paintings.class,1);
        System.out.println(a);
        session.getTransaction().commit();
        session.close();

        Session sessionB = sf.openSession();
        sessionB.beginTransaction();
        b = (Paintings) sessionB.get(Paintings.class,3);
        System.out.println(b);
        sessionB.getTransaction().commit();
        sessionB.close() ;

        //Artists ar = (Artists) session.get(Artists.class,"Van Gogh");
//        List<Paintings> paint = ar.getPaintings();
//
//        for(Paintings p: paint){
//            System.out.println(p);
//        }
        //starry = (Paintings) session.get(Paintings.class,1);

        //tx.commit();
        //System.out.println(starry);
    }
}
