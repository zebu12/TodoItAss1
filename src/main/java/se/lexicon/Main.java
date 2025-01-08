package se.lexicon;

import se.lexicon.Dao.AppUserDaoCollection;
import se.lexicon.Dao.PersonDaoCollection;
import se.lexicon.Dao.TodoItemDaoCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

//        AppUserDaoCollection appUserDaoCollection = new AppUserDaoCollection();
//
//        appUserDaoCollection.persist(new AppUser("zebu", "OneLove", AppRole.ROLE_APP_USER));
//        appUserDaoCollection.persist(new AppUser("zebuLove", "OneLove123", AppRole.ROLE_APP_ADMIN));
//
//
//        var appUsers = appUserDaoCollection.findByUsername("salum");
//
//        System.out.println(appUsers);


        PersonDaoCollection test1 = new PersonDaoCollection();
//        test.create(new Person("John", "Doe"));
//        test.create(new Person("Bachar", "Abo"));
//        test.create(new Person("Broccoli", "Snuss"));


//        System.out.println(test.findById(1));
//        System.out.println(test.findAll());
//        System.out.println(test.findByName("Bac"));

//        test.update(new Person(2,"Jari","Snuss"));
//        System.out.println(test.findAll());
//        System.out.println(test.remove(2));
//        System.out.println(test.findAll());

        TodoItemDaoCollection test = new TodoItemDaoCollection();
//        test.create(new TodoItem("Bonjour","salut", LocalDate.now(),true,test1.findById(3)));

        System.out.println(test.findById(1));














    }
}