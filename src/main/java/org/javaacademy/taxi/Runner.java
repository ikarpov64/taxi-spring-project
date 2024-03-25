package org.javaacademy.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Runner.class, args);
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		Client client4 = new Client();

		TaxiCompany taxiCompanyBean = applicationContext.getBean(TaxiCompany.class);
//		System.out.println(applicationContext.getBean(Car.class));
//		System.out.println(applicationContext.getBean(Car.class));
//		System.out.println(applicationContext.getBean(Car.class));
//		taxiCompanyBean.acceptOrder(client1, TimeOfDay.DAY);
//		taxiCompanyBean.acceptOrder(client2, TimeOfDay.DAY);
//		taxiCompanyBean.acceptOrder(client3, TimeOfDay.NIGHT);
//		taxiCompanyBean.acceptOrder(client4, TimeOfDay.NIGHT);
		taxiCompanyBean.getCars().forEach(System.out::println);
		applicationContext.close();
	}

}
