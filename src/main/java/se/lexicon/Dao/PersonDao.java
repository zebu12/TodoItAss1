package se.lexicon.Dao;

import se.lexicon.Person;

import java.util.Collection;

public interface PersonDao {

    Person persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void  remove(int id);



}
