package pl.wojtekmalka.fraudapp.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;

@Service
public class ExportDataServiceImpl implements ExportDataService {
    PersonRepository personRepository;

    public ExportDataServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void createExportFile() {
        personRepository.findAll();
    }
}
