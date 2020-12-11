package br.com.intelipost.ipquoteservices.model.constants;

import java.util.HashMap;
import java.util.Map;

public enum VolumeType {
	BOX (1, "BOX" ),
	BAG( 2, "BAG" ),
	TUBE( 3, "TUBE" ),
	ENVELOPE( 4, "ENVELOPE" ),
	PALLET( 5, "PALLET" );
	
	private final Integer id;
	private final String code;
	
    private static final Map<Integer, VolumeType> ID_MAP = new HashMap<>();
    private static final Map<String, VolumeType> CODE_MAP = new HashMap<>();

    static {
    	for (VolumeType type : values()) {
    		ID_MAP.put(type.getId(), type);
    		CODE_MAP.put(type.getCode(), type);
    	}
    }
    
	VolumeType(Integer id, String code) {
		this.id = id;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
	
	public static VolumeType getById(Integer id) {
		return ID_MAP.get(id);
	}
	
	public static VolumeType getByCode(String code) {
		if (code == null) {
			return null;
		}
		return CODE_MAP.get(code.toUpperCase());
	}
}
