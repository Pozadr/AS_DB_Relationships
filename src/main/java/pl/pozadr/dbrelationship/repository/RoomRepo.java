package pl.pozadr.dbrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pozadr.dbrelationship.model.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
}
