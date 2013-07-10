package components.java;

/**
 * Created with IntelliJ IDEA.
 * User: jugarsan
 * Date: 6/27/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Subject {

    void registerSubscriber(Observer subscriber);

    void deregisterSubscriber(Observer subscriber);

    void notifySubscribers();
}
