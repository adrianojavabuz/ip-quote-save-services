package br.com.intelipost.ipquoteservices.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ShipmentSubType {
    PICKUP(1, "PICKUP"),
    DROPOFF(2, "DROPOFF");

    private final Integer id;
    private final String code;

    private static final Map<Integer, ShipmentSubType> BY_ID_MAP = Arrays.stream(ShipmentSubType.values()).collect(Collectors.toMap(ShipmentSubType::getId, Function.identity()));
    private static final Map<String, ShipmentSubType> BY_CODE_MAP = Arrays.stream(ShipmentSubType.values()).collect(Collectors.toMap(ShipmentSubType::getCode, Function.identity()));

    public static ShipmentSubType getById(Integer shipmentSubTypeId) {
        return Optional.ofNullable(shipmentSubTypeId).map((id) -> BY_ID_MAP.get(id)).orElse(null);
    }

    public static ShipmentSubType getByCode(String shipmentSubTypeCode) {
        return Optional.ofNullable(shipmentSubTypeCode).map(code -> BY_CODE_MAP.get(code)).orElse(null);
    }
}
