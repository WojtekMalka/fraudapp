package pl.wojtekmalka.fraudapp.service;

import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;

public interface CreateService {
    void addPerson(PersonForm form);

    void addCompany(CompanyForm form);
}
