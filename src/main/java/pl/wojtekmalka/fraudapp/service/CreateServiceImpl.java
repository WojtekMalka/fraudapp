package pl.wojtekmalka.fraudapp.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.fraudapp.entities.Address;
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

//    @Override
//    public void deleteAllPersonsByPESEL(int PESEL) {
//        personRepository.deleteAllByPESEL(PESEL);
//    }
//
//    @Override
//    public void deleteAllCompanyByNIP(int NIP) {
//        companyRepository.deleteAllByNIP(NIP);
//    }
//
//    @Override
//    public List<Person> findAllPersonsByPESEL(int PESEL) {
//        return personRepository.findAllByPESEL(PESEL);
//    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void deleteAllPersonsByPersonId(long personId) {
        personRepository.deleteAllByPersonId(personId);
    }

    @Override
    public void deleteAllCompaniesByCompanyId(long companyId) {
        companyRepository.deleteAllByCompanyId(companyId);
    }

    @Override
    public Person findPersonByPersonId(long personId) {
        return personRepository.findPersonByPersonId(personId);
    }

    @Override
    public Company findCompanyByCompanyId(long companyId) {
        return companyRepository.findCompanyByCompanyId(companyId);
    }

    @Override
    public void updatePersonEntity(long personId, PersonForm form) {
        Person personByPersonId = findPersonByPersonId(personId);
        personByPersonId.setFirstName(form.getFirstName());
        personByPersonId.setLastName(form.getLastName());
        personByPersonId.setFraudStatus(form.getFraudStatus());
        personByPersonId.setPESEL(form.getPESEL());
        personByPersonId.setAddress(
                new Address(personByPersonId.getAddress().getAddressId(),
                        form.getPersonAddress().getCity(),
                        form.getPersonAddress().getStreet(),
                        form.getPersonAddress().getStreetNumber(),
                        form.getPersonAddress().getHouseNumber(),
                        form.getPersonAddress().getPostCode()));
        personRepository.save(personByPersonId);
    }

    @Override
    public void updateCompanyEntity(long companyId, CompanyForm form) {
        Company companyByCompanyId = findCompanyByCompanyId(companyId);
        companyByCompanyId.setNIP(form.getNIP());
        companyByCompanyId.setCompanyName(form.getCompanyName());
        companyByCompanyId.setFraudStatus(form.getFraudStatus());
        companyByCompanyId.setAddress(
                new Address(companyByCompanyId.getAddress().getAddressId(),
                        form.getCompanyAddress().getCity(),
                        form.getCompanyAddress().getStreet(),
                        form.getCompanyAddress().getStreetNumber(),
                        form.getCompanyAddress().getHouseNumber(),
                        form.getCompanyAddress().getPostCode()));
        companyRepository.save(companyByCompanyId);
    }
}