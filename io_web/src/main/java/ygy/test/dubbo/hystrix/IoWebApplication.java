package ygy.test.dubbo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo-*.xml"})
public class IoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoWebApplication.class, args);
	}
}
