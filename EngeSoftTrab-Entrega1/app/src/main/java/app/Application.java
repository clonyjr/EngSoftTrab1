@EnableJpaRepositories("org.baeldung.persistence.repo") 
@EntityScan("org.baeldung.persistence.model")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}