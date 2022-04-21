package com.inditex.service.impl;

import com.inditex.rest.dto.request.SearchPriceRequestDTO;
import com.inditex.infrastructure.db.model.Price;
import com.inditex.infrastructure.db.repository.PriceRepository;
import com.inditex.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Price searchPriceBy(SearchPriceRequestDTO dto) {
        List<Price> prices = priceRepository.findByPkProductIdAndPkBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                dto.getProductId(), dto.getBrandId(), dto.getActualDate(), dto.getActualDate());
        return prices.stream().max(Comparator.comparing(Price::getPriority)).orElseThrow(() -> new RuntimeException("No prices found"));
    }
}
