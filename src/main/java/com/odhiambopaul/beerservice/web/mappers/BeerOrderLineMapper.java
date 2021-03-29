package com.odhiambopaul.beerservice.web.mappers;

import com.odhiambopaul.beerservice.domain.BeerOrderLine;
import com.odhiambopaul.beerservice.web.model.BeerOrderLineDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
