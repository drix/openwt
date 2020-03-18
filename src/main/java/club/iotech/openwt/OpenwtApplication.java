package club.iotech.openwt;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenwtApplication {

	public static void main(String[] args) throws BeansException, InterruptedException {
		SpringApplication.run(OpenwtApplication.class, args);
	}
}
