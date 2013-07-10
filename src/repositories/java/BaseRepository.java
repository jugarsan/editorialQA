package repositories.java;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jugarsan
 * Date: 6/29/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseRepository {
    void persistObject(Object object);

    List getObjectList();

    int deleteAllObjects();

    int deleteSpecificObject(int subscriberId);
}
