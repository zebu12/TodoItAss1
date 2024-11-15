package se.lexicon;

import java.util.Objects;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {

        this.username = Objects.requireNonNull(username, "username must not be null or empty");
        this.password = Objects.requireNonNull(password, "password must not be null or empty");
        this.role = Objects.requireNonNull(role, "Not allowed to be null.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && Objects.equals(role, appUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
