package com.iot_consumer_worker.uditha97.repository;

import com.iot_consumer_worker.uditha97.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    boolean existsByDeviceId(String deviceId);

}
