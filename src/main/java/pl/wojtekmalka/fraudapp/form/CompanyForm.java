package pl.wojtekmalka.fraudapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyForm {
    private int NIP;
    private String companyName;
    private String fraudStatus;
    private String address;
}
