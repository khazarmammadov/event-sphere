package az.edu.coders.eventsphere;

import az.edu.coders.eventsphere.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.security.manager.AccessTokenManager;
import az.edu.coders.eventsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
@RequiredArgsConstructor
public class EventSphereApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EventSphereApplication.class, args);


	}

	private final AccessTokenManager accessTokenManager;
	private final UserService userService;



	@Override
	public void run(String... args) throws Exception {

		CreatedUserRequest request = new CreatedUserRequest();
		request.setMail("kh@gm.com");

		CreatedUserRequest request2 = new CreatedUserRequest();
		request2.setMail("op23@gm.er");

		CreatedUserRequest request3 = new CreatedUserRequest();
		request3.setMail("qwer12@agm.kl");


		System.out.println(accessTokenManager.generate(userService.saveUser(request)));
		System.out.println(accessTokenManager.generate(userService.saveUser(request2)));
		System.out.println(accessTokenManager.generate(userService.saveUser(request3)));

	}
}
