package aoizora.repository;

import aoizora.domain.User;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UserRepository {

    private final MongoCollection<Document> users;

    public UserRepository(MongoCollection<Document> users) {
        this.users = users;
    }

    private User user(Document doc) {
        if (doc == null) {

        }
    }
}
