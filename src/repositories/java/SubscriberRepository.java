package repositories.java;

import components.java.Subscriber;
import org.hibernate.Session;

import java.util.List;

public class SubscriberRepository extends BaseHibernateRepository implements BaseRepository {


    public void persistObject(Object subscriber){
        try{
            persistObject(startSession(), subscriber);
        }catch (Exception e){
            System.out.println(e.getMessage() + ", stacktrace: "+ e.getStackTrace());
            closeSession();
        }
    }

    @Override
    public List getObjectList(){
        List<Subscriber> subscriberList = (List<Subscriber>) startSession().createQuery("from Subscriber").list();
        closeSession();
        return subscriberList;
    }

    @Override
    public int deleteAllObjects(){
        Session session = startSession();
        session.beginTransaction();
        int deletedRows = session.createQuery("delete from Subscriber").executeUpdate();
        session.getTransaction().commit();
        closeSession();
        return deletedRows;
    }

    @Override
    public int deleteSpecificObject(int subscriberId){
        Session session = startSession();
        session.beginTransaction();
        int deletedRows = session.createQuery("delete from Subscriber where subscriberid = :subscriberId").
                setParameter("subscriberId", subscriberId).
                executeUpdate();
        session.getTransaction().commit();
        closeSession();
        return deletedRows;
    }
}
