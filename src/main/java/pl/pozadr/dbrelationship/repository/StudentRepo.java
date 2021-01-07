package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
