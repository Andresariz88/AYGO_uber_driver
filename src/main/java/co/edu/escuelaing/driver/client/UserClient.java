package co.edu.escuelaing.driver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/users/{id}")
    Object getUserById(@PathVariable UUID id);
}
