package com.odhiambopaul.beerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPageList extends PageImpl<BeerDTO> {
  public BeerPageList(List<BeerDTO> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }

  public BeerPageList(List<BeerDTO> content) {
    super(content);
  }
}
