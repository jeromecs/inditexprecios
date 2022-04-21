package com.inditex.rest.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.inditex.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:test-application.yml")
class PriceControllerTest {

    public static final String URL_BASE = "/productPrice/?";
    public static final String EQUALS = "=";
    public static final String AMPERSAND = "&";
    public static final String PRODUCT_ID_PARAM = "productId";
    public static final String PRODUCT_ID_VALUE = "35455";
    public static final String BRAND_ID_PARAM = "brandId";
    public static final String BRAND_ID_VALUE = "1";
    public static final String ACTUAL_DATE_PARAM = "actualDate";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceController controller;

    @Test
    void testSearchPriceByParamsTest1() throws Exception {
        final String actualDateValue = "2020-06-14T10:00:00.000z";
        final String expectedPriceList = "1";
        final Double expectedPriceAmount = 35.5;
        mockMvc.perform(get(URL_BASE +
                        PRODUCT_ID_PARAM + EQUALS + PRODUCT_ID_VALUE +
                        AMPERSAND + BRAND_ID_PARAM + EQUALS + BRAND_ID_VALUE +
                        AMPERSAND + ACTUAL_DATE_PARAM + EQUALS + actualDateValue)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.priceAmount").value(expectedPriceAmount))
                .andExpect(jsonPath("$.priceList").value(expectedPriceList));
    }

    @Test
    void testSearchPriceByParamsTest2() throws Exception {
        final String actualDateValue = "2020-06-14T16:00:00.000z";
        final String expectedPriceList = "2";
        final Double expectedPriceAmount = 25.45;
        mockMvc.perform(get(URL_BASE +
                        PRODUCT_ID_PARAM + EQUALS + PRODUCT_ID_VALUE +
                        AMPERSAND + BRAND_ID_PARAM + EQUALS + BRAND_ID_VALUE +
                        AMPERSAND + ACTUAL_DATE_PARAM + EQUALS + actualDateValue)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.priceAmount").value(expectedPriceAmount))
                .andExpect(jsonPath("$.priceList").value(expectedPriceList));
    }

    @Test
    void testSearchPriceByParamsTest3() throws Exception {
        final String actualDateValue = "2020-06-14T21:00:00.000z";
        final String expectedPriceList = "1";
        final Double expectedPriceAmount = 35.5;
        mockMvc.perform(get(URL_BASE +
                        PRODUCT_ID_PARAM + EQUALS + PRODUCT_ID_VALUE +
                        AMPERSAND + BRAND_ID_PARAM + EQUALS + BRAND_ID_VALUE +
                        AMPERSAND + ACTUAL_DATE_PARAM + EQUALS + actualDateValue)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.priceAmount").value(expectedPriceAmount))
                .andExpect(jsonPath("$.priceList").value(expectedPriceList));
    }

    @Test
    void testSearchPriceByParamsTest4() throws Exception {
        final String actualDateValue = "2020-06-15T10:00:00.000z";
        final String expectedPriceList = "1";
        final Double expectedPriceAmount = 35.5;
        mockMvc.perform(get(URL_BASE +
                        PRODUCT_ID_PARAM + EQUALS + PRODUCT_ID_VALUE +
                        AMPERSAND + BRAND_ID_PARAM + EQUALS + BRAND_ID_VALUE +
                        AMPERSAND + ACTUAL_DATE_PARAM + EQUALS + actualDateValue)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.priceAmount").value(expectedPriceAmount))
                .andExpect(jsonPath("$.priceList").value(expectedPriceList));
    }

    @Test
    void testSearchPriceByParamsTest5() throws Exception {
        final String actualDateValue = "2020-06-16T21:00:00.000z";
        final String expectedPriceList = "4";
        final Double expectedPriceAmount = 38.95;
        mockMvc.perform(get(URL_BASE +
                        PRODUCT_ID_PARAM + EQUALS + PRODUCT_ID_VALUE +
                        AMPERSAND + BRAND_ID_PARAM + EQUALS + BRAND_ID_VALUE +
                        AMPERSAND + ACTUAL_DATE_PARAM + EQUALS + actualDateValue)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.priceAmount").value(expectedPriceAmount))
                .andExpect(jsonPath("$.priceList").value(expectedPriceList));
    }
}
