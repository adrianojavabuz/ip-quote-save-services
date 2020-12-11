package br.com.intelipost.ipquoteservices.model.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DeliveryMethodShippingType implements Serializable {

    ROAD(1, "ROAD"),
    RAIL(2, "RAIL"),
    AIRLIFT(3, "AIRLIFT"),
    MARITIME(4, "MARITIME"),
    FLUVIAL(5, "FLUVIAL"),
    PIPELINE(6, "PIPELINE");

    private static final Map<Integer, DeliveryMethodShippingType> ID_MAP = new HashMap<>();
    private static final Map<String, DeliveryMethodShippingType> CODE_MAP = new HashMap<>();

    static {
        for (DeliveryMethodShippingType type: values()) {
        	ID_MAP.put(type.getId(), type);
        	CODE_MAP.put(type.getCode(), type);
        }
    }
    private final Integer id;
    private final String code;

    DeliveryMethodShippingType(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
    	return code;
    }

	public static DeliveryMethodShippingType getById(Integer id) {
		return ID_MAP.get(id);
	}

	public static DeliveryMethodShippingType getByCode(String code) {
		if (code == null) {
			return null;
		}
		return CODE_MAP.get(code.toUpperCase());
	}
}
