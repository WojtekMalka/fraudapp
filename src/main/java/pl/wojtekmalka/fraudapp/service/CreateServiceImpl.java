package pl.wojtekmalka.fraudapp.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.fraudapp.entities.Company;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.repository.CompanyRepository;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CreateServiceImpl implements CreateService {
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    public CreateServiceImpl(PersonRepository personRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void addPerson(PersonForm form) {
        personRepository.save(new Person(form.getPESEL(), form.getFirstName(), form.getLastName(), form.getFraudStatus(), form.getPersonAddress()));
    }

    @Override
    public void addCompany(CompanyForm form) {
        companyRepository.save(new Company(form.getNIP(), form.getCompanyName(), form.getFraudStatus(), form.getCompanyAddress()));
    }

    @Override
    public void deleteAllPersonsByPESEL(int PESEL) {
        personRepository.deleteAllByPESEL(PESEL);
    }

    @Override
    public void deleteAllCompanyByNIP(int NIP) {
        companyRepository.deleteAllByNIP(NIP);
    }

    @Override
    public List<Person> findAllPersonsByPESEL(int PESEL) {
        return personRepository.findAllByPESEL(PESEL);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void deleteAllPersonsByPersonId(long personId) {
        personRepository.deleteAllByPersonId(personId);
    }

    @Override
    public Person findPersonByPersonId(long personId) {
        return personRepository.findPersonByPersonId(personId);
    }

    @Override
    public void updatePersonEntity(long personId, PersonForm form) {
        Person personByPersonId = findPersonByPersonId(personId);
        personByPersonId.setFirstName(form.getFirstName());
        personByPersonId.setLastName(form.getLastName());
        personByPersonId.setAddress(form.getPersonAddress());
        personByPersonId.setFraudStatus(form.getFraudStatus());
        personByPersonId.setPESEL(form.getPESEL());
        personRepository.save(personByPersonId);
    }
}