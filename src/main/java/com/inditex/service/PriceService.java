package com.inditex.service;

import com.inditex.infrastructure.db.model.Price;
import com.inditex.rest.dto.request.SearchPriceRequestDTO;

public interface PriceService {

    Price searchPriceBy(SearchPriceRequestDTO dto);
}
