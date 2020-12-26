package com.odhiambopaul.beerservice.bootstrap;

import com.odhiambopaul.beerservice.domain.Beer;
import com.odhiambopaul.beerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository repository;
    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    public BeerLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if (repository.count() == 0) {
            repository.save(
                    Beer.builder()
                            .beerName("Pilsnar")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOrder(10)
                            .upc(BEER_1_UPC)
                            .price(new BigDecimal("1200"))
                            .build());
            repository.save(
                    Beer.builder()
                            .beerName("Tusker")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOrder(10)
                            .upc(BEER_2_UPC)
                            .price(new BigDecimal("1200"))
                            .build());
            repository.save(
                    Beer.builder()
                            .beerName("Guiness")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOrder(10)
                            .upc(BEER_3_UPC)
                            .price(new BigDecimal("1200"))
                            .build());
            System.out.println("Beers Available " + repository.count());
        }
    }
}
