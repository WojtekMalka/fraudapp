package pl.wojtekmalka.fraudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wojtekmalka.fraudapp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
