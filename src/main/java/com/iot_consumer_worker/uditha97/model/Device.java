package com.iot_consumer_worker.uditha97.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

/**
 * Entity class representing IoT devices in the system.
 * Stores device metadata and registration information.
 */
@Entity
@Data
@Table(name = "device")
@Schema(description = "Device entity")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Unique device identifier", example = "device-abc-123")
    @Column(nullable = false, unique = true)
    private String deviceId;

    @Schema(description = "Human friendly name", example = "Warehouse sensor #1")
    private String name;

    private String model;

    private Instant createdAt = Instant.now();


}
