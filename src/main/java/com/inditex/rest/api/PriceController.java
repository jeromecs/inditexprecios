package com.inditex.rest.api;

import com.inditex.rest.dto.request.SearchPriceRequestDTO;
import com.inditex.rest.dto.response.SearchPriceResponseDTO;
import com.inditex.infrastructure.db.model.Price;
import com.inditex.rest.error.ApiError;
import com.inditex.service.PriceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
public class PriceController {

    private final PriceService priceService;

    @ApiOperation(value = "Search a Price", notes = "Getting a Price based parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SearchPriceResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)})
    @GetMapping("/productPrice")
    public ResponseEntity<SearchPriceResponseDTO> searchPriceBy(
            @ApiParam(name = "productId", required = true, example = "35455") @RequestParam(name = "productId", required = true) String productId,
            @ApiParam(name = "brandId", required = true, example = "1") @RequestParam(name = "brandId", required = true) String brandId,
            @ApiParam(name = "actualDate", required = true, example = "2020-06-14T10:00:00.000+00:00") @RequestParam(name = "actualDate", required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime actualDate) {
        Price price = priceService.searchPriceBy(SearchPriceRequestDTO
                .builder()
                .productId(productId)
                .brandId(brandId)
                .actualDate(actualDate)
                .build());
        return ok(SearchPriceResponseDTO
                .builder()
                .productId(price.getPk().getProductId())
                .brandId(price.getPk().getBrandId())
                .priceList(price.getPk().getPriceList())
                .actualDate(actualDate)
                .priceAmount(price.getPriceAmount())
                .curr(price.getCurr())
                .build());
    }
}
