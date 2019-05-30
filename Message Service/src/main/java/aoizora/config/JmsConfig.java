package aoizora.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import javax.jms.Queue;
import java.util.Arrays;

@EnableJms
@Configuration
public class JmsConfig {

    private final String BROKER_URL = "tcp://localhost:61616";
    private final String BROKER_USERNAME = "admin";
    private final String BROKER_PASSWORD = "admin";
    public final static String DEFAULT_QUEUE = "sample.queue";

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        var connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setUserName(BROKER_USERNAME);
        connectionFactory.setPassword(BROKER_PASSWORD);
        connectionFactory.setTrustedPackages(Arrays.asList("aoizora.entity"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        var template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(DEFAULT_QUEUE);
        return template;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(DEFAULT_QUEUE);
    }

    @Bean
    public MessageConverter messageConverter() {
        var converter = new MappingJackson2MessageConverter();
        return converter;
    }
}
