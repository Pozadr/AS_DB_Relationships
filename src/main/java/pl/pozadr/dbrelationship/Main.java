package pl.pozadr.dbrelationship;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.pozadr.dbrelationship.model.Backpack;
import pl.pozadr.dbrelationship.model.Notepad;
import pl.pozadr.dbrelationship.model.Professor;
import pl.pozadr.dbrelationship.model.Student;
import pl.pozadr.dbrelationship.repository.BackpackRepo;
import pl.pozadr.dbrelationship.repository.NotepadRepo;
import pl.pozadr.dbrelationship.repository.ProfesorRepo;
import pl.pozadr.dbrelationship.repository.StudentRepo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class Main {
    BackpackRepo backpackRepo;
    StudentRepo studentRepo;
    NotepadRepo notepadRepo;
    ProfesorRepo professorRepo;

    public Main(BackpackRepo backpackRepo, StudentRepo studentRepo, NotepadRepo notepadRepo, ProfesorRepo professorRepo) {
        this.backpackRepo = backpackRepo;
        this.studentRepo = studentRepo;
        this.notepadRepo = notepadRepo;
        this.professorRepo = professorRepo;
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
        Student student1 = new Student("Adam", "Kowalski", "150");
        student1.setBackpack(adidasBackpack);
        Student student2 = new Student("Adrian", "Nowak", "185");
        student2.setBackpack(nikeBackpack);
        Set<Student> studentSet = Stream.of(student1, student2).collect(Collectors.toSet());

        //professors
        Professor prof1 = new Professor("Antoni", "Znamsie", "dr hab.");
        Professor prof2 = new Professor("Janusz", "Wiem", "dr");
        Set<Professor> professorSet = Stream.of(prof1, prof2).collect(Collectors.toSet());

        prof1.setStudentSet(studentSet);
        prof2.setStudentSet(studentSet);

        student1.setProfessorSet(professorSet);
        student2.setProfessorSet(professorSet);

        studentRepo.save(student1);
        studentRepo.save(student2);

        professorRepo.save(prof1);
        professorRepo.save(prof2);
    }
}
