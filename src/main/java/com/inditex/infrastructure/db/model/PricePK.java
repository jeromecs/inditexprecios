package com.inditex.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class PricePK implements Serializable {

    @Column(name = "brand_id")
    private String brandId;
    @Column(name = "price_list")
    private String priceList;
    @Column(name = "product_id")
    private String productId;
}
