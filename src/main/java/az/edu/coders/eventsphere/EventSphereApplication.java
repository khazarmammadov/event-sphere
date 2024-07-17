package az.edu.coders.eventsphere;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
public class EventSphereApplication  {
	public static void main(String[] args) {
		SpringApplication.run(EventSphereApplication.class, args);


	}


	}

