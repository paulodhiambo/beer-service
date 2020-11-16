package com.odhiambopaul.beerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
  @Null private UUID id;
  @Null private Integer version;
  @Null private OffsetDateTime createdDate;
  @Null private OffsetDateTime lastModifiedDate;
  @NotNull private String beerName;
  private BeerStyleEnum beerStyle;
  @Positive @NotNull private Long upc;
  @Positive @NotNull private BigDecimal price;
  private Integer quantityOrdered;
}
