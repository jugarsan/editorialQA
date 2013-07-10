package components.test;

import testsuites.categories.UnitTest;
import components.java.Issue;
import components.java.Observer;
import components.java.Publisher;
import components.java.Subscriber;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PublisherTest {

    @Test
    public void registerSubscriberTest(){
        Observer observerMock = EasyMock.createMock(Observer.class);
        Publisher publisher = new Publisher("Wired", "magazine");
        publisher.registerSubscriber(observerMock);

        Assert.assertTrue(publisher.getNumberOfSubscribers() == 1);
    }

    @Category(UnitTest.class)
    @Test
    public void notifySubscribersTest() throws Exception{
        Observer observerMock = EasyMock.createMock(Observer.class);
        Issue testIssue = new Issue();
        observerMock.update("Wired", testIssue);
        EasyMock.replay(observerMock);

        Publisher publisher = new Publisher("Wired","magazine");
        publisher.setIssue(testIssue);
        publisher.registerSubscriber(observerMock);
        publisher.notifySubscribers();

        EasyMock.verify(observerMock);
    }

    @Category(UnitTest.class)
    @Test
    public void deregisterSubscriberTest() {
        Observer observerMock = EasyMock.createMock(Observer.class);
        Issue testIssue = new Issue();
        EasyMock.replay(observerMock);

        Publisher publisher = new Publisher("The New Yorker", "magazine");
        publisher.setIssue(testIssue);
        publisher.registerSubscriber(observerMock);
        publisher.deregisterSubscriber(observerMock);
        publisher.notifySubscribers();

        EasyMock.verify(observerMock);
    }

    @Test
    public void notifySubscribers_verify_issueStatus_false(){
        Observer observerMock = EasyMock.createMock(Observer.class);
        Issue testIssue = new Issue();
        observerMock.update("The New Yorker", testIssue);

        Publisher publisher = new Publisher("The New Yorker","magazine");
        publisher.setIssue(testIssue);
        publisher.setIssueReady(true);
        publisher.registerSubscriber(observerMock);
        publisher.notifySubscribers();

        Assert.assertFalse(publisher.isIssueReady());
    }

    @Test(expected = NullPointerException.class)
    public void deregisterSubscriber_verify_ExceptionHandleingTest(){
        Publisher publisher = new Publisher("Wired","magazine");
        publisher.deregisterSubscriber(new Subscriber());
    }

}
