package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Professor;

public interface ProfesorRepo extends JpaRepository<Professor, Long> {
}
