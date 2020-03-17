package pl.wojtekmalka.fraudapp.DTO;

import pl.wojtekmalka.fraudapp.entities.Address;

import java.time.LocalDateTime;
import java.util.List;

public class PersonDTO {
    private LocalDateTime createDate ;
    private int PESEL;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private String fraudStatus;
    private List<Address> personAddress;
}
