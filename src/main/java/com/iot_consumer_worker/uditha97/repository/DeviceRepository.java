package com.iot_consumer_worker.uditha97.repository;

import com.iot_consumer_worker.uditha97.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository interface for Device entities.
 * Provides custom query methods for device operations.
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    boolean existsByDeviceId(String deviceId);

}
