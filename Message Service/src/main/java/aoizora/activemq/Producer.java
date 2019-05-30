package aoizora.activemq;

import aoizora.entity.ClaimNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

import static aoizora.config.JmsConfig.DEFAULT_QUEUE;

@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void send(ClaimNotification notification) {
        jmsTemplate.convertAndSend(DEFAULT_QUEUE, notification);
        System.out.println("Message sent to the Queue");
    }
}
