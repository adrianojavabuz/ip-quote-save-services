package br.com.intelipost.ipquoteservices.model.base;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;


public enum TimeZones {

	NORONHA_BRAZIL(1, "America/Noronha"),
	RIO_BRANCO_BRAZIL(2, "America/Porto_Acre"),
	SAO_PAULO_BRAZIL(3, "America/Sao_Paulo"),
	MANAUS_BRAZIL(4, "America/Manaus"),
    AMERICA_MONTEVIDEO(5, "America/Montevideo");

	private final Integer id;
	private String code;

	TimeZones(Integer id, String code) {
		this.id = id;
		this.code = code;
	}

    private static final Map<Integer, TimeZones> ID_MAP = new HashMap<>();
    private static final Map<String, TimeZones> CODE_MAP = new HashMap<>();

    static {
        for (TimeZones timeZones : values()) {
            ID_MAP.put(timeZones.getId(), timeZones);
            CODE_MAP.put(timeZones.getCode(), timeZones);
        }
    }

    TimeZones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
		return code;
	}

    public static TimeZones getById(Integer id) {
        return ID_MAP.get(id);
    }

    public static TimeZones getByCode(String code) {
		if (isBlank(code)) return null;
		return CODE_MAP.get(code);
	}
    
}