package com.iot_consumer_worker.uditha97.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class KafkaConfigDebug {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @PostConstruct
    public void debugConfig() {
        System.out.println("=== KAFKA CONFIGURATION DEBUG ===");
        System.out.println("Bootstrap servers from @Value: " + bootstrapServers);
        System.out.println("================================");
    }
}