package repositories.java;

import components.java.Publisher;
import org.hibernate.Session;

import java.util.List;


public class PublisherRepository extends BaseHibernateRepository implements BaseRepository{

    public void persistObject(Object publisher){
        try{
            persistObject(startSession(), publisher);
        }catch (Exception e){
            System.out.println(e.getMessage() + " stacktrace: " + e.getStackTrace());
            closeSession();
        }
    }

    public List getObjectList(){
        List baseSubject = startSession().createQuery("from Publisher").list();
        closeSession();
        return baseSubject;
    }

    public Publisher getSpecificPublisher(int id){

        List<Publisher> publisher = (List<Publisher>)startSession().createQuery("from Publisher where publisherId = :publisherid")
                .setParameter("publisherid", id).list();
        closeSession();
        return publisher.get(0);
    }

    public int deleteAllObjects(){
        Session session = startSession();
        session.beginTransaction();
        int deletedRows = session.createQuery("delete from Publisher").executeUpdate();
        session.getTransaction().commit();
        closeSession();
        return deletedRows;
    }

    public int deleteSpecificObject(int publisherId){
        Session session = startSession();
        session.beginTransaction();
        int deletedRows = session.createQuery("delete from Publisher where publisherId = :publisherId").
                setParameter("publisherId", publisherId).
                executeUpdate();
        session.getTransaction().commit();
        closeSession();
        return deletedRows;
    }

}
