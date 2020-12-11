package br.com.intelipost.ipquoteservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteAdditionalInformation {
    private Double extraCostAbsolute;
    private Integer leadTimeBusinessDays;
    private Boolean freeShipping;
    private Collection<Integer> deliveryMethodIds;
    private Double extraCostPercentage;
    private String taxId;
    private String clientType;

    private String salesChannel;
    private String paymentType;
    private Boolean isStateTaxPayer;
    private LocalDate shippedDate;
    private Boolean calculateEstimatedDateExact;
    private List<Integer> logisticContractIds;

    public Integer getLeadTimeBusinessDays() {
        if (leadTimeBusinessDays == null)
            return null;

        return Math.max(leadTimeBusinessDays, 0);
    }

    public Collection<Integer> getDeliveryMethodIds() {
        if (deliveryMethodIds == null)
            deliveryMethodIds = new HashSet<>();
        return deliveryMethodIds;
    }

    public Double getExtraCostPercentage() {
        if (extraCostPercentage == null)
            return null;

        return Math.max(extraCostPercentage, -100);
    }
}
