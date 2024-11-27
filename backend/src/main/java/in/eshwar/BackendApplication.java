package in.eshwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.eshwar.details.Employee;
import in.eshwar.details.User;
import in.eshwar.repository.EmployeeRepository;
import in.eshwar.repository.UserRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BackendApplication.class, args);
		
		
		
	}

}
