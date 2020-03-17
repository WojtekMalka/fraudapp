package pl.wojtekmalka.fraudapp.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.fraudapp.dictionaries.FRAUD_STATUS;
import pl.wojtekmalka.fraudapp.entities.Company;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.repository.CompanyRepository;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;

@Service
public class CreateServiceImpl implements CreateService {
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    public CreateServiceImpl(PersonRepository personRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void addPerson(PersonForm form) {
        personRepository.save(new Person(form.getPESEL(),form.getFirstName(),form.getLastName(),form.getFraudStatus(),form.getPersonAddress()));
    }

    @Override
    public void addCompany(CompanyForm form) {
        companyRepository.save(new Company());
    }
}
