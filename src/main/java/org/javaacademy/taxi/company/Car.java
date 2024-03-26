package org.javaacademy.taxi.company;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javaacademy.taxi.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@ToString
@Setter
@Getter
public class Car {
    @Value("${dayRate}")
    private double dayRate;
    @Value("${nightRate}")
    private double nightRate;
    @Autowired
    private DistanceTariffs distanceTariffs;
    private String number;
    private BigDecimal moneyEarning = BigDecimal.ZERO;

    @PostConstruct
    private void init() {
        String licensePlateTemplate2 = "к%03dсе178";
        number = String.format(licensePlateTemplate2, (int) (Math.random() * 100));
    }

    public BigDecimal acceptOrder(Client client, TimeOfDay timeOfDay) {
        int distance = distanceTariffs.getDistance(client.getAddress());
        BigDecimal rate = (TimeOfDay.DAY.equals(timeOfDay)) ? BigDecimal.valueOf(dayRate)
                : BigDecimal.valueOf(nightRate);

        BigDecimal sum = BigDecimal.valueOf(distance).multiply(rate);
        BigDecimal earning = sum.divide(BigDecimal.valueOf(2), RoundingMode.CEILING);
        moneyEarning = moneyEarning.add(earning);
        return earning;
    }
}
