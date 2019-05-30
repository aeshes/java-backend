package aoizora.activemq;

import aoizora.entity.ClaimNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static aoizora.config.JmsConfig.DEFAULT_QUEUE;


@Component
public class Consumer {

    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = DEFAULT_QUEUE)
    public void receive(@Payload ClaimNotification text) {
        log.info("Received: " + text);
    }
}
