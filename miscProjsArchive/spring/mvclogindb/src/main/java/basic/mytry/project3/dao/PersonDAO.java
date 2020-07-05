package basic.mytry.project3.dao;

import java.util.UUID;

import basic.mytry.project3.model.Person;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);
    
    default int insertPerson(Person person){
        UUID id= UUID.randomUUID();
        return insertPerson(id, person);
    }
}