package br.com.intelipost.ipquoteservices.model.base;

import com.google.common.base.Enums;
import lombok.*;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data
@EqualsAndHashCode(exclude = "deliveryMethods")
@ToString(exclude = "deliveryMethods")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogisticProvider {

    public enum LogisticProviderCodes implements Serializable {
        CORREIOS, TOTAL, LOGGI, LOGGIEXP, LOGGIPRESTO, DIRECTLOG, MANUAL, VIALOG, JADLOG, TNT, GRUPOLIG, GOLLOG, SPEEDBOYS, SEQUOIALOG, ALFA, TAM_CARGO, LOGGIXD, LOGGIXD1, LOGGIP2P, UPS, RODONAVES, DHL, UES
    }

    private Integer id;
    private String name;
    private String description;
    private List<DeliveryMethod> deliveryMethods;

    private Boolean isCsvDownloadEnabled;
    private Boolean isQuotingEnabled;
    private DateTime created;
    private DateTime modified;
    private String taxId;
    private String companyName;
    private Map<String, String> configData;
    private String code;
    private boolean deliveryUntilMidnight;
    private String licenseCode;
    private String lpRootApiKey;


    public List<DeliveryMethod> getDeliveryMethods() {
        return deliveryMethods == null ? deliveryMethods = new ArrayList<>() : deliveryMethods;
    }
    
    public List<DeliveryMethod> getReturnDeliveryMethods() {
        return getDeliveryMethods().stream().filter(DeliveryMethod::isReturn).collect(toList());
    }

    public Map<String, String> getConfigData() {
        return configData == null ? configData = new HashMap<>() : configData;
    }

    public LogisticProviderCodes getEnumCode() {
        return Enums.getIfPresent(LogisticProviderCodes.class, getCode()).orNull();
    }

    public List<Integer> getDeliveryMethodIds() {
        return getDeliveryMethods()
                .stream()
                .map(DeliveryMethod::getId)
                .collect(Collectors.toList());
    }
}
