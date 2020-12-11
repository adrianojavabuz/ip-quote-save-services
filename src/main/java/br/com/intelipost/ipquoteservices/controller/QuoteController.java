package br.com.intelipost.ipquoteservices.controller;

import br.com.intelipost.ipquoteservices.model.Quote;
import br.com.intelipost.ipquoteservices.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/v2/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Quote createAsyncQuote(@RequestBody Quote quote) {
        return quoteService.createAsyncQuote(quote);
    }

    @GetMapping(value = "/{quoteId}")
    public Quote getQuoteById(@PathVariable("quoteId") String quoteId) {
        return quoteService.findQuoteById(quoteId);
    }
}
