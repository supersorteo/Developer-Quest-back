package developer_quest_back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeveloperQuestBackApplicationTests {

	@LocalServerPort
	private int port;

	@DynamicPropertySource
	static void configureTestDatabase(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url",
				() -> "jdbc:h2:mem:developer_quest_test;MODE=PostgreSQL;DB_CLOSE_DELAY=-1");
		registry.add("spring.datasource.username", () -> "sa");
		registry.add("spring.datasource.password", () -> "");
		registry.add("spring.datasource.driver-class-name", () -> "org.h2.Driver");
		registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
		registry.add("spring.flyway.enabled", () -> false);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void listsWorldsInCurriculumOrder() throws Exception {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:" + port + "/api/v1/worlds"))
				.GET()
				.build();
		var response = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());

		assertThat(response.statusCode()).isEqualTo(200);
		assertThat(response.body())
				.contains("\"worldNumber\":1")
				.contains("\"name\":\"Fundamentos\"")
				.contains("\"worldNumber\":8")
				.contains("\"name\":\"Mundo profesional\"");
		assertThat(response.body().indexOf("\"worldNumber\":1"))
				.isLessThan(response.body().indexOf("\"worldNumber\":2"));
		assertThat(response.body().indexOf("\"worldNumber\":2"))
				.isLessThan(response.body().indexOf("\"worldNumber\":8"));
	}
}
