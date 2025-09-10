package com.iot_consumer_worker.uditha97.repository;

import com.iot_consumer_worker.uditha97.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
}
