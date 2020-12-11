package br.com.intelipost.ipquoteservices.repository;

import br.com.intelipost.ipquoteservices.model.Quote;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface QuoteRepository extends ElasticsearchRepository<Quote, String> {

    Optional<Quote> findOneById(String id);
}
