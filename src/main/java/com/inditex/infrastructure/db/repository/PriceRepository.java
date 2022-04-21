package com.inditex.infrastructure.db.repository;

import com.inditex.infrastructure.db.model.Price;
import com.inditex.infrastructure.db.model.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, PricePK> {

    List<Price> findByPkProductIdAndPkBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String productId, String brandId, OffsetDateTime actualDate1, OffsetDateTime actualDate2);
}
