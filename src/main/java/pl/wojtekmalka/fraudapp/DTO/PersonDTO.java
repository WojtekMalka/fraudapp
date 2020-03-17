package pl.wojtekmalka.fraudapp.DTO;

import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;
import pl.wojtekmalka.fraudapp.entities.Addresses;

import java.time.LocalDateTime;
import java.util.List;

public class PersonDTO {
    private LocalDateTime createDate ;
    private int PESEL;
    private String firstName;
    private String lastName;
    private FRAUD_STATUS fraudStatus;
    private List<Addresses> personAddress;
}
