package se.lexicon.Dao;

import se.lexicon.Person;
import se.lexicon.Sequencers.PersonIdSequencer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static se.lexicon.db.MySQLConnection.getConnection;

public class PersonDaoCollection implements PersonDao {

    private Collection<Person> persons = new ArrayList<>();

    public PersonDaoCollection() {
    }

    @Override
    public Person create(Person person) {

//        int id = PersonIdSequencer.nextId();
//        person = new Person(id, person.getFirst_name(), person.getLast_name(), person.getEmail());
//        persons.add(person);
//

        String sql = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";

        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
           preparedStatement.setString(1,person.getFirst_name());
           preparedStatement.setString(2,person.getLast_name());
           int rowsAffected = preparedStatement.executeUpdate();
           if(rowsAffected>0){
               System.out.println("Person created successfully");
           }
           try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
               if(generatedKeys.next()){
                   int generatedId = generatedKeys.getInt(1);
                   person.setPerson_id(generatedId);
               }
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }




        return person;
    }

    @Override
    public Person findById(int id) {
//        for (Person person : persons) {
//            if (person.getPerson_id() == id) {
//                return person;
//            }
//        }
        String sql = "SELECT * FROM person WHERE person_id = ?";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    int personId = resultSet.getInt("person_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_Name");
                    return new Person(personId,firstName,lastName);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findByName(String name) {
        String sql = "SELECT * FROM person WHERE last_name LIKE ? or first_name LIKE ?";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                persons.add(new Person(resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),resultSet.getString("last_name")));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return persons;

    }

    @Override
    public Person update(Person person) {

        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,person.getFirst_name());
            preparedStatement.setString(2,person.getLast_name());
            preparedStatement.setInt(3,person.getPerson_id());
            preparedStatement.executeUpdate();
            return person;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public Person findByEmail(String email) {
//        for (Person person : persons) {
//            if (person.getEmail().equals(email)) {
//                return person;
//            }
//        }
//        return null;
//    }

    @Override
    public Collection<Person> findAll() {
//        Collection<Person> result = new ArrayList<>();
//        result.addAll(persons);
        String sql = "SELECT * FROM person";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                persons.add(new Person(resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),resultSet.getString("last_name")));

            }

        }catch(SQLException e){
            e.printStackTrace();

        }
        return persons;


    }

    @Override
    public boolean remove(int id) {
//        for (Person person : persons) {
//            if (person.getPerson_id() == id) {
//                persons.remove(person);
//            }
//        }
        String sql = "DELETE FROM person WHERE person_id = ?";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Person removed successfully");
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;

    }
}
