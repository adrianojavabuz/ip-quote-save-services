package br.com.intelipost.ipquoteservices.consumer;

import br.com.intelipost.ipquoteservices.model.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuoteConsumer {

    @KafkaListener(topics = "${kafka.queue.quote.save}", groupId = "quote", concurrency = "${kafka.listener.concurrency}")
    public void consume(ConsumerRecord<String, Quote> quote){
        log.info("key: " + quote.key());
        log.info("Partion: " + quote.partition());
        log.info("Order: " + quote.value().getId());
    }
}
