package com.iot_consumer_worker.uditha97.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class TelemetryBulkDTO {
    private String deviceId;
    private List<Map<String, Object>> readings;
}
