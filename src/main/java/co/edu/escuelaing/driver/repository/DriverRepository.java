package co.edu.escuelaing.driver.repository;

import co.edu.escuelaing.driver.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<DriverEntity, UUID> {

    Optional<DriverEntity> findFirstByStatus(String status);
}
