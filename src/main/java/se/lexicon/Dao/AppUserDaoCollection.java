package se.lexicon.Dao;

import se.lexicon.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDaoCollection implements AppUserDao {

    private ArrayList<AppUser> users = new ArrayList<>();

    public AppUserDaoCollection() {

    }

    @Override
    public AppUser persist(AppUser appUser) {
        users.add(appUser);
        return appUser;

    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {

        return users;
    }

    @Override
    public void remove(String username) {
        for (AppUser user : users) {
            if(user.getUsername().equals(username)) {
                users.remove(user);

            }
        }

    }
}
