package com.iot_consumer_worker.uditha97.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object (DTO) for bulk telemetry data.
 * Represents telemetry payloads containing multiple readings from a single device.
 * Used for receiving and processing telemetry data in bulk format.
 */
@Data
public class TelemetryBulkDTO {
    /**
     * Unique identifier of the device sending the telemetry data.
     * Used to associate readings with the correct device in the system.
     */
    private String deviceId;

    /**
     * List of telemetry readings, each represented as a key-value map.
     * Each map contains measurement data such as temperature, humidity, etc.
     * with corresponding timestamps and values.
     */
    private List<Map<String, Object>> readings;
}
