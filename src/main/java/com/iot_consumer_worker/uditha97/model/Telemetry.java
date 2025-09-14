package com.iot_consumer_worker.uditha97.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

/**
 * Entity class representing telemetry data from IoT devices.
 * Maps to database table with indexing for performance.
 */
@Entity
@Data
@Table(name = "telemetry", indexes = {
        @Index(name = "idx_device_ts", columnList = "deviceId,timestamp")
})

public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private Instant timestamp;

    @Column(columnDefinition = "json")
    private String payload;
}