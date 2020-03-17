package pl.wojtekmalka.fraudapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Addresses")
@Getter
@NoArgsConstructor
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    private String city;
    private String street;
    private int streetNumber;
    private int houseNumber;
    private int postCode;


}
