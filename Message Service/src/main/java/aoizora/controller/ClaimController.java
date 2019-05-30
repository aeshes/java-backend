package aoizora.controller;

import aoizora.activemq.Producer;
import aoizora.entity.ClaimNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {

    @Autowired
    private final Producer producer;

    public ClaimController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/api/test")
    public void accept(@RequestBody ClaimNotification data) {
        System.out.println(data);
        producer.send(data);
    }
}
