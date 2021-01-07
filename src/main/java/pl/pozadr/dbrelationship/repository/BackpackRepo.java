package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Backpack;

public interface BackpackRepo extends JpaRepository<Backpack, Long> {
}
