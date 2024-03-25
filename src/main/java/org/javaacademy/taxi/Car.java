package org.javaacademy.taxi;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@ToString
//@Scope("prototype")
public class Car {
    @Autowired
    @Value("${dayRate}")
    private double dayRate;
    @Autowired
    @Value("${nightRate}")
    private double nightRate;
    private String number;
    private double moneyEarning;

    @PostConstruct
    private void init() {
        String licensePlateTemplate2 = "к%03dсе178";
        number = String.format(licensePlateTemplate2, (int) (Math.random() * 100));
    }

    public void acceptOrder(Client client, TimeOfDay timeOfDay) {
        String address = client.getAddress();
    }
}
