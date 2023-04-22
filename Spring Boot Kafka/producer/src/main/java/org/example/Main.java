package org.example;

import org.example.common.Starship;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, Starship> kafka)
    {
        return args -> {
            kafka.send("test", new Starship("aaa", "bbb"));
        };
    }
}