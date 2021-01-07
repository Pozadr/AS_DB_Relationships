package pl.pozadr.dbrelationship.model;

import javax.persistence.*;

@Entity
@Table(name = "backpacks")
public class Backpack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;

    public Backpack() {
    }

    public Backpack(String mark) {
        this.mark = mark;
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
