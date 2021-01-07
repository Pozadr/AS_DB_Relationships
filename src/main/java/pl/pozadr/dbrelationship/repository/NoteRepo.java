package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Note;

public interface NoteRepo extends JpaRepository<Note, Long> {
}
