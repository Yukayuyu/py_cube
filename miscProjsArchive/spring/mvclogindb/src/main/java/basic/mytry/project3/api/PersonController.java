package basic.mytry.project3.api;

import basic.mytry.project3.model.Person;
import basic.mytry.project3.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    public void addPerson(Person person){
        personService.addPerson(person);
    }
}