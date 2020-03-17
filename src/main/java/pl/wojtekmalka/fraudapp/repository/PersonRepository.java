package pl.wojtekmalka.fraudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wojtekmalka.fraudapp.entities.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByPESEL(int PESEL);
}
