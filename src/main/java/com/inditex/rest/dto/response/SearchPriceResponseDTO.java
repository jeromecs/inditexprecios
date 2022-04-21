package com.inditex.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Builder
@Setter
@Getter
public class SearchPriceResponseDTO {

    private String productId;
    private String brandId;
    private String priceList;
    private OffsetDateTime actualDate;
    private Double priceAmount;
    private String curr;
}
