package com.inditex.infrastructure.db.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PRICE", schema = "\"inditexprecios\"")
public class Price {

    @EmbeddedId
    private PricePK pk;
    @Column(name = "start_date")
    private OffsetDateTime startDate;
    @Column(name = "end_date")
    private OffsetDateTime endDate;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private Double priceAmount;
    @Column(name = "curr")
    private String curr;
}
