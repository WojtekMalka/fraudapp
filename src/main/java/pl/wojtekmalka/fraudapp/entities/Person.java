package pl.wojtekmalka.fraudapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    private LocalDate createDate = LocalDate.now();
    @Column(unique = true, nullable = false)
    @NotNull
    @Digits(integer = 11, fraction = 0)
    private int PESEL;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private FRAUD_STATUS fraudStatus;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    public Person(int PESEL, String firstName, String lastName, FRAUD_STATUS fraudStatus, Address address) {
        this.PESEL = PESEL;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fraudStatus = fraudStatus;
        this.address = address;
    }
}
