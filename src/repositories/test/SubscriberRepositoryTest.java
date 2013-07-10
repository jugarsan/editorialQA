package repositories.test;

import testsuites.categories.IntegrationTest;
import components.java.Subscriber;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import repositories.java.SubscriberRepository;

import java.util.List;

@Category(IntegrationTest.class)
public class SubscriberRepositoryTest {
    SubscriberRepository subscriberRepository;

    @Before
    public void setup() throws Exception {
        subscriberRepository = new SubscriberRepository();

    }

    @After
    public void tearDown() throws Exception {
        int affectedRows = subscriberRepository.deleteAllObjects();
        subscriberRepository.closeAll();
        Assert.assertTrue(affectedRows > 0);
    }

    @Test
    public void persistSubscriberTest(){
        Subscriber subscriber = new Subscriber("Danny","Ocean","123 Street","55555","Las Vegas","Nevada","United States");

        subscriberRepository.persistObject(subscriber);
        List results =  subscriberRepository.getObjectList();

        Subscriber subscriberFound = (Subscriber) results.get(0);
        Assert.assertEquals(subscriber, subscriberFound);
    }

    @Test
    public void deleteSubscriberTest(){
        Subscriber firstSubscriber = new Subscriber("Rusty", "Ryan","123 Street","55555","Las Vegas","Nevada","United States");
        Subscriber secondSubscriber = new Subscriber("Jack", "Sparrow","Hanged Man Street","22222","Turtle Island","Somewhere","Earth");

        subscriberRepository.persistObject(firstSubscriber);
        subscriberRepository.persistObject(secondSubscriber);

        subscriberRepository.deleteSpecificObject(firstSubscriber.getSubscriberid());

        List<Subscriber> results = subscriberRepository.getObjectList();
        Assert.assertEquals(secondSubscriber, results.get(0));
    }




}
