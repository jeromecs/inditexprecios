package com.inditex.service.impl;

import com.inditex.infrastructure.db.model.Price;
import com.inditex.infrastructure.db.model.PricePK;
import com.inditex.infrastructure.db.repository.PriceRepository;
import com.inditex.rest.dto.request.SearchPriceRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.OffsetDateTime;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {

    public static final String PRODUCT_ID = "productId";
    public static final String BRAND_ID = "brandId";
    public static final OffsetDateTime ACTUAL_DATE = OffsetDateTime.now();
    public static final int PRIORITY = 1;
    public static final OffsetDateTime END_DATE = ACTUAL_DATE.plusDays(PRIORITY);
    public static final OffsetDateTime START_DATE = ACTUAL_DATE.minusDays(PRIORITY);
    public static final String PRICE_LIST = "priceList";
    public static final double PRICE_AMOUNT = 5.0;
    public static final String CURR = "EUR";

    @Mock
    private PriceRepository priceRepository;

    private Price price;

    private SearchPriceRequestDTO searchPriceRequestDTO;

    @InjectMocks
    private PriceServiceImpl service;

    @BeforeEach
    void init() {
        setPrice();
        setSearchPriceRequestDTO();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchPriceBy() {
        when(priceRepository.findByPkProductIdAndPkBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(PRODUCT_ID, BRAND_ID, ACTUAL_DATE, ACTUAL_DATE))
                .thenReturn(Arrays.asList(price));

        assertThat(service.searchPriceBy(searchPriceRequestDTO), is(price));
    }

    private void setPrice() {
        price = Price.builder()
                .pk(PricePK.builder()
                        .brandId(BRAND_ID)
                        .priceList(PRICE_LIST)
                        .productId(PRODUCT_ID)
                        .build())
                .startDate(START_DATE)
                .endDate(END_DATE)
                .priority(PRIORITY)
                .priceAmount(PRICE_AMOUNT)
                .curr(CURR)
                .build();
    }

    private void setSearchPriceRequestDTO() {
        searchPriceRequestDTO = SearchPriceRequestDTO.builder()
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .actualDate(ACTUAL_DATE)
                .build();
    }
}
