package services;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"services", "persistenceLayer"})
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);  

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("The Test-Manager appstarted"); 
	}
}




