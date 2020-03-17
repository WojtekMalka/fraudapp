package pl.wojtekmalka.fraudapp.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonForm {
    private int PESEL;
    private String firstName;
    private String lastName;
    private String fraudStatus;
    private String personAddress;
}
