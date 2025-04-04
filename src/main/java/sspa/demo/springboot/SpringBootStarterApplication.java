package sspa.demo.springboot;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarterApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}

}
