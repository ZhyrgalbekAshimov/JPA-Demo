package kg.megacom.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private Boolean isSingle;

    protected Customer() {}

    Customer(String firstName, String lastName, LocalDate birthday, Boolean isSingle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = (LocalDate.now().getYear() - birthday.getYear()) / 365;
        this.isSingle = isSingle;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", isSingle=" + isSingle +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public Boolean getSingle() {
        return isSingle;
    }
}