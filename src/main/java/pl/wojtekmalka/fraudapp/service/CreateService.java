package pl.wojtekmalka.fraudapp.service;

import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;

import java.util.List;

public interface CreateService {
    void addPerson(PersonForm form);

    void addCompany(CompanyForm form);

    void deleteAllPersonsByPESEL(int PESEL);

    void deleteAllCompanyByNIP(int NIP);

    List<Person> findAllPersonsByPESEL(int PESEL);
}