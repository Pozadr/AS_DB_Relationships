package pl.pozadr.dbrelationship.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomNumber;

    @OneToOne(mappedBy = "room")
    private Professor professor;

    @ManyToMany
    private Set<Cleaner> cleanerSet;

    public Room() {
    }

    public Room(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Set<Cleaner> getCleanerSet() {
        return cleanerSet;
    }

    public void setCleanerSet(Set<Cleaner> cleanerSet) {
        this.cleanerSet = cleanerSet;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
}
