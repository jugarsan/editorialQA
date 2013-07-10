package repositories.test;

import testsuites.categories.IntegrationTest;
import components.java.Publisher;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import repositories.java.PublisherRepository;

import java.util.List;

@Category(IntegrationTest.class)
public class PublisherRepositoryTest {
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository = new PublisherRepository();
    }

    @After
    public void tearDown() throws Exception {
        int affectedRows = publisherRepository.deleteAllObjects();
        publisherRepository.closeAll();
        Assert.assertTrue(affectedRows > 0);
    }

    @Test
    public void persistPublisherTest(){
        Publisher publisher = new Publisher("Wired","Magazine");

        publisherRepository.persistObject(publisher);
        List results = publisherRepository.getObjectList();
        Publisher publisherFound = (Publisher) results.get(0);

        Assert.assertTrue(publisherFound.equals(publisher));
    }

    @Test
    public void deletePublisherTest(){
        Publisher firstPublisher = new Publisher("Esquire Magazine", "magazine");
        Publisher secondPublisher = new Publisher("The New Yorker", "magazine");

        publisherRepository.persistObject(firstPublisher);
        publisherRepository.persistObject(secondPublisher);

        publisherRepository.deleteSpecificObject(firstPublisher.getPublisherId());

        List results = publisherRepository.getObjectList();
        Assert.assertEquals(secondPublisher, results.get(0));
    }

    @Test
    public void getSpecificPublisherTest(){
        Publisher newspaperPublisher = new Publisher("The Herald","newspaper");
        Publisher magazinePublisher = new Publisher("National Geographic","magazine");

        publisherRepository.persistObject(newspaperPublisher);
        publisherRepository.persistObject(magazinePublisher);

        Publisher result = publisherRepository.getSpecificPublisher(newspaperPublisher.getPublisherId());

        Assert.assertEquals(newspaperPublisher, result);
    }


}
