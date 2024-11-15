package se.lexicon.Dao;

import se.lexicon.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDaoCollection implements PersonDao {

    private Collection<Person> persons = new ArrayList<>();

    public PersonDaoCollection() {
    }

    @Override
    public Person persist(Person person) {
        persons.add(person);


        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        Collection<Person> result = new ArrayList<>();
        result.addAll(persons);
        return result;


    }

    @Override
    public void remove(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.remove(person);
            }
        }

    }
}
