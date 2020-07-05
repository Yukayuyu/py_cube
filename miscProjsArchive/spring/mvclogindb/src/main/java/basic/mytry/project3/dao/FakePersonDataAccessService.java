package basic.mytry.project3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import basic.mytry.project3.model.Person;

public class FakePersonDataAccessService implements PersonDAO {

    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    } 
    
}