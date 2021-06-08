package kg.megacom.jpa;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    List<Customer> findByLastNameOrFirstName(String lastName, String firstName);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameIs(String firstName);
    List<Customer> findByFirstNameEquals(String firstName);
    List<Customer> findByBirthdayBetween(LocalDate firstDate, LocalDate secondDate);
    List<Customer> findByAgeLessThan(int age);
    List<Customer> findByAgeLessThanEqual(int age);
    List<Customer> findByAgeGreaterThan(int age);
    List<Customer> findByAgeGreaterThanEqual(int age);
    List<Customer> findByBirthdayAfter(LocalDate birthday);
    List<Customer> findByBirthdayBefore(LocalDate birthday);
    List<Customer> findByAgeIsNull();
    List<Customer> findByAgeIsNotNull();
    List<Customer> findByFirstNameLike(String firstName);
    List<Customer> findByFirstNameNotLike(String firstName);
    List<Customer> findByFirstNameStartingWith(String firstNameStartingWith);
    List<Customer> findByFirstNameEndingWith(String firstNameEndingWith);
    List<Customer> findByFirstNameContaining(String firstNameContaining);
    List<Customer> findByAgeOrderByLastNameDesc(int age);
    List<Customer> findByLastNameNot(String lastName);
    List<Customer> findByAgeIn(Collection<Integer> ages);
    List<Customer> findByAgeNotIn(Collection<Integer> ages);
    List<Customer> findByIsSingleTrue();
    List<Customer> findByIsSingleFalse();
    List<Customer> findByFirstNameIgnoreCase(String firstName);


}