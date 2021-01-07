package pl.pozadr.dbrelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.pozadr.dbrelationship.model.Backpack;
import pl.pozadr.dbrelationship.model.Student;
import pl.pozadr.dbrelationship.repository.BackpackRepo;
import pl.pozadr.dbrelationship.repository.StudentRepo;

@Component
public class Main {
    BackpackRepo backpackRepo;
    StudentRepo studentRepo;

    @Autowired
    public Main(BackpackRepo backpackRepo, StudentRepo studentRepo) {
        this.backpackRepo = backpackRepo;
        this.studentRepo = studentRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Backpack adidasBackpack = backpackRepo.getOne(1L);
        Backpack nikeBackpack = backpackRepo.getOne(2L);

        Student adam = new Student("Adam", "Kowalski", "150");
        adam.setBackpack(adidasBackpack);
        studentRepo.save(adam);

        Student adrian = new Student("Adrian", "Nowak", "185");
        adrian.setBackpack(nikeBackpack);
        studentRepo.save(adrian);

    }
}
