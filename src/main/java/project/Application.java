package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import project.EnvConfig;

/**
 * The main class of the project.
 * By running the main class of {@link Application} then you start the Spring Boot system
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(Application.class);
	}

    public static void main(String[] args) {
		setFakeEnv();
        SpringApplication.run(Application.class,args);
    }

	private static void setFakeEnv() {
		try {
			EnvConfig.setTmpEnvironment();
		} catch (Exception e) {
			System.out.println("Failed to set up temporary environment");
		}
	}

}
