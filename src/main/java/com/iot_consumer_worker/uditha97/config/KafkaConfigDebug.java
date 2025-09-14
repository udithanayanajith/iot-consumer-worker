package com.iot_consumer_worker.uditha97.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Configuration class for debugging Kafka connection settings.
 * Prints bootstrap server configuration during application startup.
 */
@Configuration
public class KafkaConfigDebug {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * Debug method that prints Kafka bootstrap server configuration.
     * Executes automatically after bean construction.
     */
    @PostConstruct
    public void debugConfig() {
        System.out.println("=== KAFKA CONFIGURATION DEBUG ===");
        System.out.println("Bootstrap servers from @Value: " + bootstrapServers);
        System.out.println("================================");
    }
}