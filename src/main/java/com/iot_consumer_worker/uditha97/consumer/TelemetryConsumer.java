package com.iot_consumer_worker.uditha97.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_consumer_worker.uditha97.model.Telemetry;
import com.iot_consumer_worker.uditha97.repository.TelemetryRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class TelemetryConsumer {
    private final TelemetryRepository telemetryRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public TelemetryConsumer(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    @KafkaListener(topics = "telemetry", containerFactory = "kafkaListenerContainerFactory")
    @Transactional
    public void consume(String message) throws Exception {
        JsonNode root = mapper.readTree(message);
        String deviceId = root.path("deviceId").asText();
        JsonNode readings = root.path("readings");

        List<Telemetry> batch = new ArrayList<>();
        for (JsonNode r : readings) {
            Telemetry t = new Telemetry();
            t.setDeviceId(deviceId);

            long epoch = Instant.now().toEpochMilli();
            if (r.has("timestamp")) {
                epoch = Instant.parse(r.get("timestamp").asText()).toEpochMilli();
            }
            t.setTimestamp(Instant.ofEpochMilli(epoch));

            t.setPayload(r.toString());
            batch.add(t);
        }

        telemetryRepository.saveAll(batch);
    }
}
