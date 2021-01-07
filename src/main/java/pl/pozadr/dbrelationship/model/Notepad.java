package pl.pozadr.dbrelationship.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "notepads")
public class Notepad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Backpack backpack;

    @OneToMany(mappedBy = "notepad")
    private Set<Note> noteSet;

    public Notepad() {
    }

    public Notepad(String title) {
        this.title = title;
    }


    public Backpack getBackpack() {
        return backpack;
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
