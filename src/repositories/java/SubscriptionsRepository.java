package repositories.java;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@javax.persistence.Table(name = "subscriptions", schema = "public", catalog = "editorial")
@Entity
public class SubscriptionsRepository {
    private int subscriptionid;

    @javax.persistence.Column(name = "subscriptionid")
    @Id
    public int getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(int subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    private Integer subscriptorid;

    @javax.persistence.Column(name = "subscriptorid")
    @Basic
    public Integer getSubscriptorid() {
        return subscriptorid;
    }

    public void setSubscriptorid(Integer subscriptorid) {
        this.subscriptorid = subscriptorid;
    }

    private Integer publisherid;

    @javax.persistence.Column(name = "publisherid")
    @Basic
    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    private Date startdate;

    @javax.persistence.Column(name = "startdate")
    @Basic
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionsRepository that = (SubscriptionsRepository) o;

        if (subscriptionid != that.subscriptionid) return false;
        if (publisherid != null ? !publisherid.equals(that.publisherid) : that.publisherid != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (subscriptorid != null ? !subscriptorid.equals(that.subscriptorid) : that.subscriptorid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subscriptionid;
        result = 31 * result + (subscriptorid != null ? subscriptorid.hashCode() : 0);
        result = 31 * result + (publisherid != null ? publisherid.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        return result;
    }
}
