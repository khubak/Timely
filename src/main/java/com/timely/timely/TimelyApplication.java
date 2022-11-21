

import com.timely.timely.model.Project;
import com.timely.timely.repo.TimelyRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class TimelyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimelyApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TimelyRepo timelyRepo) {
		return args -> {
			timelyRepo.save(new Project(1L, "TestProject",
					new Timestamp(System.currentTimeMillis()),
					new Timestamp(System.currentTimeMillis()),
					10L));
		};
	}
}