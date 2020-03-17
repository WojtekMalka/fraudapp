package pl.wojtekmalka.fraudapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;
    private LocalDate createDate = LocalDate.now();
    private int NIP;
    private String companyName;
    @Enumerated(EnumType.STRING)
    private FRAUD_STATUS fraudStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Company(int NIP, String companyName, FRAUD_STATUS fraudStatus, Address address) {
        this.NIP = NIP;
        this.companyName = companyName;
        this.fraudStatus = fraudStatus;
        this.address = address;
    }
}
