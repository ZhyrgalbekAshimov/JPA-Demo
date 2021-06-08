package kg.megacom.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", LocalDate.of(1990, 5, 2), true));
			repository.save(new Customer("Chloe", "O'Brian", LocalDate.of(1985, 1, 22), true));
			repository.save(new Customer("Kim", "Bauer", LocalDate.of(1980, 6, 15), false));
			repository.save(new Customer("David", "Palmer", LocalDate.of(1970, 1, 30), false));
			repository.save(new Customer("Michelle", "Dessler", LocalDate.of(1999, 5, 2), true));
			repository.save(new Customer("Mike", "Lebowski", LocalDate.of(1988, 2, 5), false));
			repository.save(new Customer("Lora", "Connor", LocalDate.of(1966, 9, 19), false));
			repository.save(new Customer("Nelly", "Furtado", LocalDate.of(1977, 10, 27), true));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// 0
			log.info("findByLastNameAndFirstName:");
			for (Customer customer : repository.findByLastNameAndFirstName("Connor", "Lora")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 1
			log.info("findByLastNameOrFirstName:");
			for (Customer customer : repository.findByLastNameOrFirstName("Connor", "Kim")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 2
			log.info("findByFirstName:");
			for (Customer customer : repository.findByFirstName("Kim")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 3
			log.info("findByFirstNameIs:");
			for (Customer customer : repository.findByFirstNameIs("David")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 4
			log.info("findByFirstNameEquals:");
			for (Customer customer : repository.findByFirstNameEquals("Nelly")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 5
			log.info("findByBirthdayBetween:");
			for (Customer customer : repository.findByBirthdayBetween(LocalDate.of(1990, 1, 1), LocalDate.of(2000, 1, 1))) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 6
			log.info("findByAgeLessThan:");
			for (Customer customer : repository.findByAgeLessThan(30)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 7
			log.info("findByAgeLessThanEqual:");
			for (Customer customer : repository.findByAgeLessThanEqual(25)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 8
			log.info("findByAgeGreaterThan:");
			for (Customer customer : repository.findByAgeGreaterThan(26)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 9
			log.info("findByAgeGreaterThanEqual:");
			for (Customer customer : repository.findByAgeGreaterThanEqual(35)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 10
			log.info("findByBirthdayAfter:");
			for (Customer customer : repository.findByBirthdayAfter(LocalDate.of(1985, 1, 1))) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 11
			log.info("findByBirthdayBefore:");
			for (Customer customer : repository.findByBirthdayBefore(LocalDate.of(1980, 1, 1))) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 12
			log.info("findByAgeIsNull:");
			for (Customer customer : repository.findByAgeIsNull()) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 13
			log.info("findByAgeIsNotNull:");
			for (Customer customer : repository.findByAgeIsNotNull()) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 14
			log.info("findByFirstNameLike:");
			for (Customer customer : repository.findByFirstNameLike("Michelle")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 15
			log.info("findByFirstNameNotLike:");
			for (Customer customer : repository.findByFirstNameNotLike("Mike")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 16
			log.info("findByFirstNameStartingWith:");
			for (Customer customer : repository.findByFirstNameStartingWith("Dav")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 17
			log.info("findByFirstNameEndingWith:");
			for (Customer customer : repository.findByFirstNameEndingWith("oe")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 18
			log.info("findByFirstNameContaining:");
			for (Customer customer : repository.findByFirstNameContaining("ichell")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 19
			log.info("findByAgeOrderByLastNameDesc:");
			for (Customer customer : repository.findByAgeOrderByLastNameDesc(30)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 20
			log.info("findByLastNameNot:");
			for (Customer customer : repository.findByLastNameNot("Lebowski")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 21
			ArrayList<Integer> ages = new ArrayList<>();
			ages.add(10);
			ages.add(25);
			ages.add(30);
			ages.add(35);
			log.info("findByAgeIn:");
			for (Customer customer : repository.findByAgeIn(ages)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 22
			log.info("findByAgeNotIn:");
			for (Customer customer : repository.findByAgeNotIn(ages)) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 23
			log.info("findByIsSingleTrue:");
			for (Customer customer : repository.findByIsSingleTrue()) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 24
			log.info("findByIsSingleFalse:");
			for (Customer customer : repository.findByIsSingleFalse()) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

			// 25
			log.info("findByFirstNameIgnoreCase:");
			for (Customer customer : repository.findByFirstNameIgnoreCase("Lora")) {
				log.info(customer.toString());
			}
			log.info("--------------------------------");
			log.info("");

		};
	}
}
