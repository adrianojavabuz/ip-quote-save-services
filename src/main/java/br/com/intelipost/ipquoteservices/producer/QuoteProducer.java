package br.com.intelipost.ipquoteservices.producer;

import br.com.intelipost.ipquoteservices.model.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuoteProducer {

    @Value("${kafka.queue.quote.save}")
    private String topicName;

    private final KafkaTemplate<String, Quote> kafkaTemplate;

    public void send(Quote quote){
        try {
            log.info("Sending quote: {} to topic: {}", quote.getId(), topicName);
            kafkaTemplate.send(topicName, quote);
        } catch (Exception exception) {
            log.error("Erro to send quote: {} to topic: {}", quote.getId(), topicName);
        }
    }
}
