package components.java;

import java.util.ArrayList;

public class Publisher implements Subject {
    private ArrayList subscribers;
    private String publisherName;
    private int publisherId;
    private Issue issue;
    private String publisherType;
    private boolean issueReady;


    public Publisher(String publisherName, String publisherType){
        this.publisherName = publisherName;
        this.publisherType = publisherType;
        subscribers = new ArrayList();
    }

    public Publisher(){

    }

    @Override
    public void registerSubscriber(Observer subscriber) {
        subscribers.add(subscriber);
    }


    @Override
    public void deregisterSubscriber(Observer subscriber) throws NullPointerException {
        int index = subscribers.indexOf(subscriber);
        if(index >= 0){
            subscribers.remove(index);
        }
        else{
            throw new NullPointerException("Subscriber was not found");
        }
    }

    @Override
    public void notifySubscribers() throws NullPointerException {
        if(subscribers != null){
            for(int i = 0; i < subscribers.size(); i++){
                    Observer subscriber = (Observer) subscribers.get(i);
                    subscriber.update(getPublisherName(), getIssue());
                }
                setIssueReady(false);
            }
        else{
            throw new NullPointerException("There are no subscribers registered for this publisher");
        }
    }

    public void setPublisherName(String name){
        this.publisherName = name;
    }

    public void setPublisherType(String type) {
        this.publisherType = type;
    }

    public String getPublisherName(){
        return this.publisherName;
    }

    public String getPublisherType(){
        return this.publisherType;
    }

    public void setPublisherId(int id){
        this.publisherId = id;
    }

    public int getPublisherId(){
        return publisherId;
    }

    public void setIssue(Issue issue){
        this.issue = issue;
    }

    public Issue getIssue(){
        return issue;
    }

    public boolean isIssueReady() {
        return issueReady;
    }

    public void setIssueReady(boolean issueReady) {
        this.issueReady = issueReady;
    }

    public int getNumberOfSubscribers(){
        return subscribers.size();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher that = (Publisher) o;

        if (publisherId != that.publisherId) return false;
        if (publisherName != null ? !publisherName.equals(that.publisherName) : that.publisherName != null)
            return false;
        if (publisherType != null ? !publisherType.equals(that.publisherType) : that.publisherType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publisherId;
        result = 31 * result + (publisherName != null ? publisherName.hashCode() : 0);
        result = 31 * result + (publisherType != null ? publisherType.hashCode() : 0);
        return result;
    }
}
