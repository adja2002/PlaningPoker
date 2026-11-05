package fr.lyon2.capi.capi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapiApplication {

	public static String message() {
		return "Hello world";
	}

	public static void main(String[] args) {
		System.out.println(message());
		SpringApplication.run(CapiApplication.class, args);
	}
}