package br.com.intelipost.ipquoteservices.service;

import br.com.intelipost.ipquoteservices.exception.QuoteNotFoundException;
import br.com.intelipost.ipquoteservices.model.Quote;
import br.com.intelipost.ipquoteservices.producer.QuoteProducer;
import br.com.intelipost.ipquoteservices.producer.QuoteFallbackProducer;
import br.com.intelipost.ipquoteservices.repository.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class QuoteService {

    @Autowired
    private QuoteProducer quoteProducer;

    @Autowired
    private QuoteFallbackProducer quoteFallbackProducer;

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote createAsyncQuote(Quote quote){

        try {
            quote.setId(UUID.randomUUID().toString());
            quoteProducer.send(quote);
        } catch (Exception exception) {
            log.info("Sending quote {} to retry fallback queue {}", quote.getId());
            quoteFallbackProducer.send(quote);
        }

        return quote;
    }

    public Quote findQuoteById(String quoteId){
        log.info("Finding quote by id {}", quoteId);

        Optional<Quote> quote = quoteRepository.findOneById(quoteId);

        if (!quote.isPresent()){
            throw new QuoteNotFoundException();
        }
        return quote.get();
    }
}
