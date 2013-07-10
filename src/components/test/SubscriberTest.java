package components.test;

import testsuites.categories.UnitTest;
import components.java.Issue;
import components.java.Subscriber;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(UnitTest.class)
public class SubscriberTest {

    @Test
    public void updateTest(){
        String publisherName = "Wired";
        Issue firstIssue = new Issue();
        Issue secondIssue = new Issue();

        Subscriber subscriber = new Subscriber();
        subscriber.update(publisherName, firstIssue);
        subscriber.update(publisherName, secondIssue);

        Assert.assertTrue(subscriber.getNewIssuesQueue().size() == 2);
    }

}
