package aoizora.entities;

public class Link {

    private String id;
    private String url;
    private String description;

    public Link(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public Link(String id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
