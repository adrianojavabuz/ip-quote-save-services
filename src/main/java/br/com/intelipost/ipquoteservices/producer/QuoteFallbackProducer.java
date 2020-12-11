package br.com.intelipost.ipquoteservices.producer;

import br.com.intelipost.ipquoteservices.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuoteFallbackProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queueRetry;

    public void send(Quote quote) {
        try {
            log.info("Sending quote: {} to queue: {}", quote.getId(), this.queueRetry.getName());
            rabbitTemplate.convertAndSend(this.queueRetry.getName(), quote);
        } catch (Exception exception) {
            log.error("Erro to send quote: {} to queue: {}", quote.getId(), this.queueRetry.getName());
        }
    }
}
