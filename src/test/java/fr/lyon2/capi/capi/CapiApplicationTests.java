package fr.lyon2.capi.capi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void messageRenvoieHelloWorld() {
		assertEquals("Hello world", CapiApplication.message());
	}
}