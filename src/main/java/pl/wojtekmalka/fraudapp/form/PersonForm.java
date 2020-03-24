package pl.wojtekmalka.fraudapp.form;

import lombok.Getter;
import lombok.Setter;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;
import pl.wojtekmalka.fraudapp.entities.Address;

@Getter
@Setter
public class PersonForm {
    private long personID;
    private int PESEL;
    private String firstName;
    private String lastName;
    private FRAUD_STATUS fraudStatus;
    private Address personAddress;
}
