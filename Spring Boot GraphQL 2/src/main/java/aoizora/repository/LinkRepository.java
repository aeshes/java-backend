package aoizora.repository;

import aoizora.entities.Link;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

@Repository
public class LinkRepository {

    private final MongoCollection<Document> links;

    public LinkRepository() {
        this.links = new MongoClient()
                .getDatabase("test")
                .getCollection("links");
    }


    public Link findById(String id) {
        Document doc = links.find(eq("_id", new ObjectId(id))).first();
        return link(doc);
    }

    public List<Link> getAllLinks() {
        List<Link> allLinks = new ArrayList<>();
        for (Document doc: links.find()) {
            allLinks.add(link(doc));
        }
        return allLinks;
    }

    public void saveLink(Link link) {
        links.insertOne(new Document()
            .append("url", link.getUrl())
            .append("description", link.getDescription()));
    }

    private Link link(Document doc) {
        return new Link(doc.get("_id").toString(),
                doc.getString("url"),
                doc.getString("description"));
    }
}