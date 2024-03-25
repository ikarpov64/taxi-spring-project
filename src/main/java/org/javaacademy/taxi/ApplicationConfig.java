package org.javaacademy.taxi;

import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
//@PropertySource("classpath:application.yaml")
public class ApplicationConfig {

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
