package pl.szkolenie;

import org.springframework.boot.SpringApplication;

public class TestSzkolenieApplication {

	public static void main(String[] args) {
		SpringApplication.from(SzkolenieApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
