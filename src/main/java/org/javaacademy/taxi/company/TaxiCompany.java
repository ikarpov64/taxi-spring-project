package org.javaacademy.taxi.company;

import jakarta.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.javaacademy.taxi.Client;
import org.springframework.beans.factory.annotation.Value;

@Getter
@RequiredArgsConstructor
public class TaxiCompany {
    @Value("${name}")
    private String name;
    private BigDecimal amountMoney = BigDecimal.ZERO;
    private final List<Car> cars;
    private int availableCar = 0;

    @PreDestroy
    private void preDestroy() {
        report();
        System.out.println("Таксопарк закрыт.");
    }

    public void acceptOrder(Client client, TimeOfDay timeOfDay) {
        System.out.printf("Клиент заказал машину по адресу: %s\n", client.getAddress());
        try {
            amountMoney = amountMoney.add(cars.get(availableCar).acceptOrder(client, timeOfDay));
            System.out.println("Мы приехали.");
            availableCar++;
            if (availableCar >= cars.size()) {
                availableCar = 0;
            }
        } catch (RuntimeException e) {
            System.out.printf("Поездки не будет. %s\n", e.getMessage());
        }
    }

    private void report() {
        System.out.printf("""
                Итог.
                Таксопарк: %s.
                Заработано: %s
                """, name, amountMoney);
        cars.forEach(car -> System.out.printf("Водитель машины %s заработал: %s\n",
                car.getNumber(), car.getMoneyEarning()));
    }
}
