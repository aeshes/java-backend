package org.example;

import org.apache.kafka.clients.admin.NewTopic;
import org.example.common.Starship;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder.name("test")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id = "myId", topics = "test")
    public void listen(Starship in)
    {
        System.out.println(in);
    }
}