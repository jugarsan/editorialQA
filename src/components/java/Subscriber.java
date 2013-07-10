package components.java;

import java.util.LinkedHashMap;

public class Subscriber implements Observer{
    private int subscriberid;
    private String subscriberFirstName;
    private String subscriberLastName;
    private String address;
    private String postalcode;
    private String city;
    private String state;
    private String country;
    private LinkedHashMap<Issue, String> newIssuesQueue;

    public Subscriber(){
        newIssuesQueue = new LinkedHashMap<Issue, String>();
    }

    public Subscriber(String firstName, String lastName, String address, String postalcode, String city, String state, String country){
        this.subscriberFirstName = firstName;
        this.subscriberLastName = lastName;
        this.address = address;
        this.postalcode = postalcode;
        this.city = city;
        this.state = state;
        newIssuesQueue = new LinkedHashMap<Issue, String>();
    }

    public int getSubscriberid() {
        return subscriberid;
    }

    public void setSubscriberid(int subscriberid) {
        this.subscriberid = subscriberid;
    }

    public String getSubscriberFirstName() {
        return subscriberFirstName;
    }

    public void setSubscriberFirstName(String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    public String getSubscriberLastName() {
        return subscriberLastName;
    }

    public void setSubscriberLastName(String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap getNewIssuesQueue(){
        return newIssuesQueue;
    }

    @Override
    public void update(String publisherName, Issue issue){
        newIssuesQueue.put(issue, publisherName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        if (subscriberid != that.subscriberid) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (subscriberFirstName != null ? !subscriberFirstName.equals(that.subscriberFirstName) : that.subscriberFirstName != null)
            return false;
        if (subscriberLastName != null ? !subscriberLastName.equals(that.subscriberLastName) : that.subscriberLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subscriberid;
        result = 31 * result + (subscriberFirstName != null ? subscriberFirstName.hashCode() : 0);
        result = 31 * result + (subscriberLastName != null ? subscriberLastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }


}
