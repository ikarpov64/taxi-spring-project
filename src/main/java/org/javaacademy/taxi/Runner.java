package org.javaacademy.taxi;

import org.javaacademy.taxi.company.TaxiCompany;
import org.javaacademy.taxi.company.TimeOfDay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Runner.class, args);
        Client client1 = new Client("Кандикюля");
        Client client2 = new Client("Строитель");
        Client client3 = new Client("Березовая роща");
        Client client4 = new Client("Ломоносов");

        TaxiCompany taxiCompanyBean = applicationContext.getBean(TaxiCompany.class);
        taxiCompanyBean.acceptOrder(client1, TimeOfDay.DAY);
        taxiCompanyBean.acceptOrder(client2, TimeOfDay.DAY);
        taxiCompanyBean.acceptOrder(client3, TimeOfDay.NIGHT);
        taxiCompanyBean.acceptOrder(client4, TimeOfDay.NIGHT);
        applicationContext.close();
    }
}
