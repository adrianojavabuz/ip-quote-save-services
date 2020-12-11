package br.com.intelipost.ipquoteservices.model.base;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Map;

@Data
public class DeliveryMethod {

    @JsonProperty("delivery_method_id")
    private Integer id;
    private Integer logisticProviderId;
    private DeliveryMethodType deliveryMethodType;
    private String name;
    private String description;
    private boolean isActive;
    private DateTime created;
    private DateTime modified;
    private String imageUrl;
    private DeliveryMethodShippingType deliveryMethodShippingType;
    private boolean isReturn;
    private boolean hasReimbursement;
    private boolean hasPreShipmentList;
    private ShipmentType shipmentType;
    private ShipmentSubType shipmentSubType;

    @JsonIgnore private LogisticProvider logisticProvider;
    private Map<String, String> configData;
    private Integer pendingContractsCount;

}
