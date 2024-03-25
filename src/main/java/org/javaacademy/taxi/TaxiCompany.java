package org.javaacademy.taxi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
//@Component
public class TaxiCompany {

    @Value("${cars}")
    private int numberOfCars;
    @Value("${name}")
    private String name;
    private double amountMoney;
    private List<Car> cars = new ArrayList<>();
    private int availableCar = 0;

    public TaxiCompany(List<Car> cars) {
        this.cars = cars;
    }

    @PostConstruct
    private void init() {
//        for (int i = 0; i < numberOfCars; i++) {
//            cars.add(new Car());
//        }
        System.out.println(name);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Таксопарк закрыт.");
    }

    public void acceptOrder(Client client, TimeOfDay timeOfDay) {
//        cars.get(availableCar).acceptOrder(client, timeOfDay);
//        availableCar++;
//        if (availableCar >= cars.size()) {
//            availableCar = 0;
//        }
    }
}
