package com.iot_consumer_worker.uditha97.repository;

import com.iot_consumer_worker.uditha97.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Template interface for device repository operations.
 * Defines contract for device data access operations.
 */
@Repository
public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
}
