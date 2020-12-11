package br.com.intelipost.ipquoteservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "quotes-#{T(java.time.LocalDate).now().toString()}")
public class Quote {

    @Id
    private String id;
    private Integer clientId;
    private String originZipCode;
    private String destinationZipCode;
    private String calculationLog;

    @JsonIgnore
//    private DateTime created = DateTime.now();

    private QuoteAdditionalInformation additionalInformation;
    private String platform;
    private QuoteIdentification identification;

    private List<QuoteDeliveryOption> deliveryOptions;
    private List<QuoteVolume> volumes;

    @JsonIgnore
    private List<QuoteDeliveryOption> originalDeliveryOptions;

    public List<QuoteDeliveryOption> getOriginalDeliveryOptions() {
        return originalDeliveryOptions == null ? getDeliveryOptions() : originalDeliveryOptions;
    }
}
