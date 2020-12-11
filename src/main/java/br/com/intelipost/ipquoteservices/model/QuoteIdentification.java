package br.com.intelipost.ipquoteservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteIdentification {
    private String session;
    private String ip;
    private String pageName;
    private String url;
}
