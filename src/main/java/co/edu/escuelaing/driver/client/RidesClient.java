package co.edu.escuelaing.driver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ridesClient", url = "http://localhost:8083")
public interface RidesClient {

    @PutMapping("/rides/assign")
    void assignRide(@RequestParam("rideId") String rideId, @RequestParam("driverId") String driverId);
}