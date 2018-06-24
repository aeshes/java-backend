package mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import models.User;

public class UserDAO extends BasicDAO<User, ObjectId> {

    public UserDAO(Datastore store) {
        super(store);
    }
}
