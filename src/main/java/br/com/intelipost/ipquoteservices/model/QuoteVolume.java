package br.com.intelipost.ipquoteservices.model;

import br.com.intelipost.ipquoteservices.model.constants.VolumeType;
import lombok.Data;

import java.util.Set;

@Data
public class QuoteVolume {
    private Long id;
    private String volumeTypeString;
    private Set<Integer> skuGroupsIds;
    private VolumeType volumeType;
    private Double weight;
    private Double costOfGoods;
    private Double width;
    private Double height;
    private Double length;
    private String description;
    private String productCategory;
    private Integer quantityOfItems;
}
