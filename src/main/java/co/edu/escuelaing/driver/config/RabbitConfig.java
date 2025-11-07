package co.edu.escuelaing.driver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String RIDE_REQUESTED_QUEUE = "ride.requested";

    @Bean
    public Queue rideRequestedQueue() {
        return new Queue(RIDE_REQUESTED_QUEUE, true);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}