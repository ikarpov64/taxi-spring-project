package org.javaacademy.taxi.company;

import java.util.List;
import org.springframework.context.annotation.*;

@Configuration
public class CompanyConfig {

    @Bean
    @Scope("prototype")
    public Car car() {
        return new Car();
    }

    @Profile("bluz")
    @Bean
    public TaxiCompany taxiCompanyBluz() {
        return new TaxiCompany(List.of(car(), car()));
    }

    @Profile("luna")
    @Bean
    public TaxiCompany taxiCompanyLuna() {
        return new TaxiCompany(List.of(car(), car(), car()));
    }
}
