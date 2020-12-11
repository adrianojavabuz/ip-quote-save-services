package br.com.intelipost.ipquoteservices.model;


import br.com.intelipost.ipquoteservices.model.base.DeliveryMethod;
import br.com.intelipost.ipquoteservices.model.base.DeliveryMethodType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuoteDeliveryOption implements Serializable {

//    @JsonIgnore
//    private Long id;

    private Integer deliveryMethodId;
    private Integer deliveryEstimateBusinessDays;
    @JsonInclude(Include.NON_NULL) private Integer collectTime;
//    @DecimalMax(value = "99999999.99", message = "quote.providerShippingCost.exceeded")
    private Double providerShippingCost;
//    @DecimalMax(value = "99999999.99", message = "quote.finalShippingCost.exceeded")
    private Double finalShippingCost;
    @JsonIgnore private Integer logisticProviderId;
    private String description;
    @JsonIgnore private DeliveryMethodType deliveryMethodType;
    @JsonIgnore private String deliveryMethodName;
    private String deliveryNote;
    private boolean removedByReturnModes = false;
    private boolean removedByQuoteRules = false;
    private DeliveryMethod deliveryMethod;

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
