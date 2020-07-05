package basic.mytry.project3.service;

import basic.mytry.project3.dao.PersonDAO;
import basic.mytry.project3.model.Person;

public class PersonService {
    private final PersonDAO personDAO;
    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    
}