package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Notepad;

public interface NotepadRepo extends JpaRepository<Notepad, Long> {
}
