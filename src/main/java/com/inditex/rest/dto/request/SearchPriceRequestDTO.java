package com.inditex.rest.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Builder
@Setter
@Getter
public class SearchPriceRequestDTO {

    private OffsetDateTime actualDate;
    private String productId;
    private String brandId;
}
