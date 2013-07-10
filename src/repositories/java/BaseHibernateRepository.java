package repositories.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BaseHibernateRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public BaseHibernateRepository(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public void persistObject(Session session, Object o){
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        closeSession();
    }


    public Session startSession(){
        session = sessionFactory.openSession();
        return session;
    }

    public Session getSession(){
        return session;
    }


    public void closeSession(){
        if(session != null){
            session.close();
        }
    }

    public void closeAll(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
