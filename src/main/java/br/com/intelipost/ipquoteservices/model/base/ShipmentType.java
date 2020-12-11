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
public enum ShipmentType {
    NORMAL(1, "NORMAL"),
    RETURN(2, "RETURN");

    private final Integer id;
    private final String code;

    private static final Map<Integer, ShipmentType> BY_ID_MAP = Arrays.stream(ShipmentType.values()).collect(Collectors.toMap(ShipmentType::getId, Function.identity()));
    private static final Map<String, ShipmentType> BY_CODE_MAP = Arrays.stream(ShipmentType.values()).collect(Collectors.toMap(ShipmentType::getCode, Function.identity()));

    public static ShipmentType getById(Integer shipmentTypeId) {
        return Optional.ofNullable(shipmentTypeId).map((id) -> BY_ID_MAP.get(id)).orElse(null);
    }

    public static ShipmentType getByCode(String shipmentTypeCode) {
        return Optional.ofNullable(shipmentTypeCode).map(code -> BY_CODE_MAP.get(code)).orElse(null);
    }
}
