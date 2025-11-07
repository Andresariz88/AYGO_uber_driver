package co.edu.escuelaing.driver.messaging;

import co.edu.escuelaing.driver.client.RidesClient;
import co.edu.escuelaing.driver.config.RabbitConfig;
import co.edu.escuelaing.driver.events.RideRequestedEvent;
import co.edu.escuelaing.driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestedListener {

    private final DriverRepository driverRepo;
    private final RidesClient ridesClient;

    @RabbitListener(queues = RabbitConfig.RIDE_REQUESTED_QUEUE)
    public void onRideRequested(RideRequestedEvent event) {
        System.out.println("🚕 Driver micro recibió un ride request: " + event.getRideId());

        var optDriver = driverRepo.findFirstByStatus("AVAILABLE");

        if (optDriver.isEmpty()) {
            System.out.println("no hay drivers disponibles 😭");
            return;
        }

        var driver = optDriver.get();

        System.out.println("🚕 driver seleccionado: " + driver.getId());

        driver.setStatus("BUSY");
        driverRepo.save(driver);

        // notificar a rides micro
        ridesClient.assignRide(event.getRideId().toString(), driver.getId().toString());
    }
}