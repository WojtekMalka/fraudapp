package pl.wojtekmalka.fraudapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Person")
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    private LocalDate createDate = LocalDate.now();
    private int PESEL;
    private String firstName;
    private String lastName;
    private String fraudStatus;
    private String address;

    public Person(int PESEL, String firstName, String lastName, String fraudStatus, String address) {
        this.PESEL = PESEL;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fraudStatus = fraudStatus;
        this.address = address;
    }
}
