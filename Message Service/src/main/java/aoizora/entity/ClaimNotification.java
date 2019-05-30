package aoizora.entity;

import java.io.Serializable;

public class ClaimNotification implements Serializable {

    private String template;
    private ClaimData data;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public ClaimData getData() {
        return data;
    }

    public void setData(ClaimData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClaimNotification{" +
                "template='" + template + '\'' +
                ", data=" + data +
                '}';
    }
}
