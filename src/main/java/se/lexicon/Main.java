package se.lexicon;

import se.lexicon.Dao.AppUserDaoCollection;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        AppUserDaoCollection appUserDaoCollection = new AppUserDaoCollection();

        appUserDaoCollection.persist(new AppUser("zebu", "OneLove", AppRole.ROLE_APP_USER));
        appUserDaoCollection.persist(new AppUser("zebuLove", "OneLove123", AppRole.ROLE_APP_ADMIN));


        var appUsers = appUserDaoCollection.findByUsername("salum");

        System.out.println(appUsers);


    }
}