package co.edu.escuelaing.driver.events;

import java.util.UUID;
import lombok.Data;

@Data
public class RideRequestedEvent {
    private UUID rideId;
    private Location pickup;
    private Location dropoff;

    @Data
    public static class Location {
        private double lat;
        private double lng;
    }
}