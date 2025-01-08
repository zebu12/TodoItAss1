package se.lexicon;

import java.util.Objects;

public class Person {

    private static int personCounter = 1;
    private int person_id;
    private String first_name;
    private String last_name;
    private String email;
    private AppUser credentials;


    public Person(int person_id, String first_name, String last_name, String email) {

        this.person_id = person_id;
        this.first_name = Objects.requireNonNull(first_name, "firstName must not be null");
        this.last_name = Objects.requireNonNull(last_name, "lastName must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");

    }

    public Person(String first_name, String last_name) {
        this.first_name = Objects.requireNonNull(first_name, "firstName must not be null");
        this.last_name = Objects.requireNonNull(last_name, "lastName must not be null");
    }

    public Person(int person_id, String first_name, String last_name) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Id: ").append(person_id).append("\n");
        builder.append("First Name: ").append(first_name).append("\n");
        builder.append("Last Name: ").append(last_name).append("\n");
        builder.append("Email: ").append(email).append("\n");
        return builder.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return person_id == person.person_id && Objects.equals(first_name, person.first_name) && Objects.equals(last_name, person.last_name) && Objects.equals(email, person.email);

    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, first_name, last_name, email);
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }
}
