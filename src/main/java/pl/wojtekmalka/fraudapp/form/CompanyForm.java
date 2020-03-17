package pl.wojtekmalka.fraudapp.form;

import lombok.Getter;
import lombok.Setter;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;
import pl.wojtekmalka.fraudapp.entities.Address;

@Getter
@Setter
public class CompanyForm {
    private int NIP;
    private String companyName;
    private FRAUD_STATUS fraudStatus;
    private Address companyAddress;
}
