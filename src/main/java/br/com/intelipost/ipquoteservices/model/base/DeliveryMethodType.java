package br.com.intelipost.ipquoteservices.model.base;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DeliveryMethodType {

    STANDARD(1, "STANDARD"),
    EXPRESS(2, "EXPRESS"),
    PRIORITY(3, "PRIORITY"),
    PICKUP(4, "PICKUP"),
    PICKUP_LOCKER(5, "PICKUP_LOCKER"),
    PICKUP_POINT(6, "PICKUP_POINT"),
    SAME_DAY(7, "SAME_DAY"),
    SCHEDULED(8, "SCHEDULED"),
    RETURN(9, "RETURN");

    private static final Map<Integer, DeliveryMethodType> ID_MAP = new HashMap<>();
    private static final Map<String, DeliveryMethodType> CODE_MAP = new HashMap<>();

    public static final List<DeliveryMethodType> PICKUP_TYPES = ImmutableList.of(PICKUP, PICKUP_LOCKER, PICKUP_POINT);

    static {
        for (DeliveryMethodType type : values()) {
            ID_MAP.put(type.getId(), type);
            CODE_MAP.put(type.getCode(), type);
        }
    }

    private final Integer id;
    private final String code;

    DeliveryMethodType(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public static DeliveryMethodType getById(Integer id) {
        return ID_MAP.get(id);
    }

    public static DeliveryMethodType getByCode(String code) {
        return code == null ? null : CODE_MAP.get(code.toUpperCase());
    }
}
