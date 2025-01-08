package se.lexicon.Dao;

import se.lexicon.Person;

import java.util.Collection;

public interface PersonDao {

    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean  remove(int id);


//    Person findByEmail(String email);



}
