package pl.wojtekmalka.fraudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wojtekmalka.fraudapp.entities.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    long deleteAllByPESEL(int PESEL);

    List<Person> findAllByPESEL(int PESEL);
}
