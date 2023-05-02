package io.github.AugustoMello09.producerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static io.github.AugustoMello09.producerservice.config.RabbitmqConfig.EXG_NAME_MARKETPLACE;
import static io.github.AugustoMello09.producerservice.config.RabbitmqConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {
	
    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

}
