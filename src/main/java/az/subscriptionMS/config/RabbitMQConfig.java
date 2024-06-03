package az.subscriptionMS.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue subscriptionQueue() {
        return new Queue("SubscriptionQueueMSG", false);
    }
}
