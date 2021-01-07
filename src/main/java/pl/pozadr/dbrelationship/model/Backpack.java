package pl.pozadr.dbrelationship.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "backpacks")
public class Backpack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;

    @OneToMany(mappedBy = "backpack")
    private Set<Notepad> notepadSet;

    public Backpack() {
    }

    public Backpack(String mark) {
        this.mark = mark;
    }

    public Set<Notepad> getNotepadSet() {
        return notepadSet;
    }

    public void setNotepadSet(Set<Notepad> notepadSet) {
        this.notepadSet = notepadSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
