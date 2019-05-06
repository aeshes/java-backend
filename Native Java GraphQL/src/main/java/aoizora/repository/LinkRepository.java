package aoizora.repository;

import aoizora.domain.Link;

import java.util.ArrayList;
import java.util.List;

public class LinkRepository {

    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        links.add(new Link("http://howtographql.com", "How to GraphQL"));
        links.add(new Link("http://graphql.org", "The official docks"));
    }

    public List<Link> getAllLinks() {
        return links;
    }

    public void saveLink(Link link) {
        links.add(link);
    }
}
