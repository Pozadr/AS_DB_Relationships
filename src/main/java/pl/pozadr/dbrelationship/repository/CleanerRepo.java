package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Cleaner;

public interface CleanerRepo extends JpaRepository<Cleaner, Long> {
}
