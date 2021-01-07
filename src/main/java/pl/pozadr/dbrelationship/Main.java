package pl.pozadr.dbrelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.pozadr.dbrelationship.model.*;
import pl.pozadr.dbrelationship.repository.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class Main {
    BackpackRepo backpackRepo;
    StudentRepo studentRepo;
    NotepadRepo notepadRepo;
    ProfesorRepo professorRepo;
    NoteRepo noteRepo;
    RoomRepo roomRepo;
    CleanerRepo cleanerRepo;

    @Autowired
    public Main(BackpackRepo backpackRepo, StudentRepo studentRepo, NotepadRepo notepadRepo, ProfesorRepo professorRepo,
                NoteRepo noteRepo, RoomRepo roomRepo, CleanerRepo cleanerRepo) {
        this.backpackRepo = backpackRepo;
        this.studentRepo = studentRepo;
        this.notepadRepo = notepadRepo;
        this.professorRepo = professorRepo;
        this.noteRepo = noteRepo;
        this.roomRepo = roomRepo;
        this.cleanerRepo = cleanerRepo;
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
        itNotepad.setBackpack(nikeBackpack);
        notepadRepo.save(itNotepad);

        // notes
        Note historicNote1 = new Note("HIS 121");
        historicNote1.setNotepad(histNotepad);
        noteRepo.save(historicNote1);
        Note historicNote2 = new Note("HIS 122");
        historicNote2.setNotepad(histNotepad);
        noteRepo.save(historicNote2);
        Note historicNote3 = new Note("HIS 123");
        historicNote3.setNotepad(histNotepad);
        noteRepo.save(historicNote3);
        Note mathNote1 = new Note("MATH 171");
        mathNote1.setNotepad(mathNotepad);
        noteRepo.save(mathNote1);
        Note mathNote2 = new Note("MATH 172");
        mathNote2.setNotepad(mathNotepad);
        noteRepo.save(mathNote2);
        Note physNote1 = new Note("PHYS 501");
        physNote1.setNotepad(physNotepad);
        noteRepo.save(physNote1);
        Note physNote2 = new Note("PHYS 502");
        physNote2.setNotepad(physNotepad);
        noteRepo.save(physNote2);
        Note physNote3 = new Note("PHYS 503");
        physNote3.setNotepad(physNotepad);
        noteRepo.save(physNote3);

        // students
        Student student1 = new Student("Adam", "Kowalski", "150");
        student1.setBackpack(adidasBackpack);
        Student student2 = new Student("Adrian", "Nowak", "185");
        student2.setBackpack(nikeBackpack);
        Set<Student> studentSet = Stream.of(student1, student2).collect(Collectors.toSet());

        // cleaners
        Cleaner cleaner1 = new Cleaner("Adam", "Smith");
        Cleaner cleaner2 = new Cleaner("John", "Sparrow");
        Cleaner cleaner3 = new Cleaner("Luke", "Sky");
        Set<Cleaner> cleanerSet1 = Stream.of(cleaner1).collect(Collectors.toSet());
        Set<Cleaner> cleanerSet2_3 = Stream.of(cleaner2, cleaner3).collect(Collectors.toSet());

        // rooms
        Room room4 = new Room(4L);
        Room room46 = new Room(46L);
        Room room50 = new Room(50L);
        Set<Room> roomSet4 = Stream.of(room4).collect(Collectors.toSet());
        Set<Room> roomSet46_50 = Stream.of(room46, room50).collect(Collectors.toSet());
        room4.setCleanerSet(cleanerSet1);
        room46.setCleanerSet(cleanerSet2_3);
        room50.setCleanerSet(cleanerSet2_3);

        cleaner1.setRoomSet(roomSet4);
        cleaner2.setRoomSet(roomSet46_50);
        cleaner3.setRoomSet(roomSet46_50);

        cleanerRepo.save(cleaner1);
        cleanerRepo.save(cleaner2);
        cleanerRepo.save(cleaner3);

        roomRepo.save(room4);
        roomRepo.save(room46);
        roomRepo.save(room46);

        //professors
        Professor prof1 = new Professor("Antoni", "Iknew", "dr hab.");
        prof1.setRoom(room4);
        Professor prof2 = new Professor("Janusz", "Iknow", "dr");
        prof2.setRoom(room46);
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
