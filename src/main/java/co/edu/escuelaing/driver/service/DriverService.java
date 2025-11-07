package co.edu.escuelaing.driver.service;

import co.edu.escuelaing.driver.client.UserClient;
import co.edu.escuelaing.driver.entity.DriverEntity;
import co.edu.escuelaing.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    private final DriverRepository repo;
    private final UserClient userClient;

    public DriverService(DriverRepository repo,  UserClient userClient) {
        this.repo = repo;
        this.userClient = userClient;
    }

    public List<DriverEntity> findAll() {
        return repo.findAll();
    }

    public DriverEntity findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public DriverEntity save(DriverEntity entity) {
        try {
            userClient.getUserById(entity.getUserId());
        } catch (Exception e) {
            throw new RuntimeException("User not found in user-service");
        }

        return repo.save(entity);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}