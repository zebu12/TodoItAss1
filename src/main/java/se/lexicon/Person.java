package se.lexicon;

import java.util.Objects;

public class Person {

    private static int personCounter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {

        this.id = personCounter++;
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");

    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Id: ").append(id).append("\n");
        builder.append("First Name: ").append(firstName).append("\n");
        builder.append("Last Name: ").append(lastName).append("\n");
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
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
