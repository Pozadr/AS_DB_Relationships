package pl.pozadr.dbrelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.pozadr.dbrelationship.model.Backpack;
import pl.pozadr.dbrelationship.model.Notepad;
import pl.pozadr.dbrelationship.model.Student;
import pl.pozadr.dbrelationship.repository.BackpackRepo;
import pl.pozadr.dbrelationship.repository.NotepadRepo;
import pl.pozadr.dbrelationship.repository.StudentRepo;

import java.util.HashSet;
import java.util.Set;

@Component
public class Main {
    BackpackRepo backpackRepo;
    StudentRepo studentRepo;
    NotepadRepo notepadRepo;

    @Autowired
    public Main(BackpackRepo backpackRepo, StudentRepo studentRepo, NotepadRepo notepadRepo) {
        this.backpackRepo = backpackRepo;
        this.studentRepo = studentRepo;
        this.notepadRepo = notepadRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        // backpacks
        Backpack adidasBackpack = new Backpack("Adidas");
        backpackRepo.save(adidasBackpack);
        Backpack nikeBackpack = new Backpack("Nike");
        backpackRepo.save(nikeBackpack);

        // notepads
        Notepad histNotepad = new Notepad("History");
        histNotepad.setBackpack(adidasBackpack);
        notepadRepo.save(histNotepad);
        Notepad mathNotepad = new Notepad("Mathematics");
        mathNotepad.setBackpack(nikeBackpack);
        notepadRepo.save(mathNotepad);
        Notepad physNotepad = new Notepad("Physics");
        physNotepad.setBackpack(nikeBackpack);
        notepadRepo.save(physNotepad);
        Notepad itNotepad = new Notepad("It");
        physNotepad.setBackpack(nikeBackpack);
        notepadRepo.save(itNotepad);

        // students
        Student adam = new Student("Adam", "Kowalski", "150");
        adam.setBackpack(adidasBackpack);
        studentRepo.save(adam);

        Student adrian = new Student("Adrian", "Nowak", "185");
        adrian.setBackpack(nikeBackpack);
        studentRepo.save(adrian);




    }
}
