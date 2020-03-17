package pl.wojtekmalka.fraudapp.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;

@Service
public class CreateServiceImpl implements CreateService {
    private final PersonRepository personRepository;

    public CreateServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(PersonForm form) {
        personRepository.save(new Person(form.getPESEL(), form.getFirstName(), form.getLastName(), form.getFraudStatus(), form.getPersonAddress()));
    }
}
