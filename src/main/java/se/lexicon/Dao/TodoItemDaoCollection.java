package se.lexicon.Dao;

import se.lexicon.Person;
import se.lexicon.Sequencers.TodoItemIdSequencer;
import se.lexicon.TodoItem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.sql.Types.NULL;
import static se.lexicon.db.MySQLConnection.getConnection;

public class TodoItemDaoCollection implements TodoItemDao{

    private Collection<TodoItem> todoItems = new ArrayList<>();

    public TodoItemDaoCollection() {
    }



    @Override
    public TodoItem create(TodoItem todoItem) {

//        int id = TodoItemIdSequencer.nextId();
//        todoItem = new TodoItem(id,todoItem.getTitle(), todoItem.getDescription(), todoItem.getDeadline(), todoItem.isDone(),todoItem.getCreator());
//        todoItems.add(todoItem);

        String sql = "INSERT INTO todo_item(title,description,deadline,done,assignee_id) VALUES(?,?,?,?,?) ";
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement
                (sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,todoItem.getTitle());
            preparedStatement.setString(2,todoItem.getDescription());
            preparedStatement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            preparedStatement.setBoolean(4,todoItem.isDone());
            if(todoItem.getCreator() != null) {
                preparedStatement.setInt(5, todoItem.getCreator().getPerson_id());
            }
            else {
                preparedStatement.setNull(5,NULL);
            }
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("TodItem created");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    todoItem.setTodo_id(id);
                    return todoItem;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        String sql = "SELECT * FROM todo_item WHERE todo_id = ?";
        PersonDaoCollection creator = new PersonDaoCollection();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int todoId = resultSet.getInt("todo_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    LocalDate date = LocalDate.parse(resultSet.getString("deadline"));
                    boolean done = resultSet.getBoolean("done");
                    if (creator.findById(resultSet.getInt("assignee_id")) != null) {
                        Person person = creator.findById(resultSet.getInt("assignee_id"));
                        return new TodoItem(todoId, title, description, date, done, person);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {

        String sql = "SELECT * FROM todo_item ";
        PersonDaoCollection creator = new PersonDaoCollection();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(new TodoItem(resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")),
                        resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id"))));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return todoItems;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
//        ArrayList<TodoItem> result = new ArrayList<>();
//        for (TodoItem element : todoItems){
//            if (element.isDone()){
//                result.add(element);
//            }
//        }
        String sql = "SELECT * FROM todo_item WHERE done = ?";

        PersonDaoCollection creator = new PersonDaoCollection();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, done);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt("todo_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    LocalDate date = LocalDate.parse(resultSet.getString("deadline"));
                    boolean done1 = resultSet.getBoolean("done");
                    if (creator.findById(resultSet.getInt("assignee_id")) != null) {
                        Person person = creator.findById(resultSet.getInt("assignee_id"));
                        todoItems.add(new TodoItem(todoId, title, description, date, done1, person));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

//    @Override
//    public Collection<TodoItem> findByTitleContains(String title) {
//        ArrayList<TodoItem> result = new ArrayList<>();
//        for (TodoItem element : todoItems){
//            if (element.getTitle().contains(title)){
//                result.add(element);
//            }
//        }
//        return result;
//    }

    @Override
    public Collection<TodoItem> findByAssignee(int personId) {
//        ArrayList<TodoItem> result = new ArrayList<>();
//        for (TodoItem element : todoItems){
//            if(element.getCreator().getPerson_id() == personId){
//                result.add(element);
//            }
//        }
//        return result;

        String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";

        PersonDaoCollection creator = new PersonDaoCollection();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, personId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt("todo_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    LocalDate date = LocalDate.parse(resultSet.getString("deadline"));
                    boolean done1 = resultSet.getBoolean("done");
                    if (creator.findById(resultSet.getInt("assignee_id")) != null) {
                        Person person = creator.findById(resultSet.getInt("assignee_id"));
                        todoItems.add(new TodoItem(todoId, title, description, date, done1, person));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByPersonId(Person person) {

        String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";

        PersonDaoCollection creator = new PersonDaoCollection();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, person.getPerson_id());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt("todo_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    LocalDate date = LocalDate.parse(resultSet.getString("deadline"));
                    boolean done1 = resultSet.getBoolean("done");
                    if (creator.findById(resultSet.getInt("assignee_id")) != null) {
                        Person person1 = creator.findById(resultSet.getInt("assignee_id"));
                        todoItems.add(new TodoItem(todoId, title, description, date, done1, person1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoitems() {

        String sql = "SELECT * FROM todo_item WHERE assignee_id IS NULL ";

        PersonDaoCollection creator = new PersonDaoCollection();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt("todo_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    LocalDate date = LocalDate.parse(resultSet.getString("deadline"));
                    boolean done1 = resultSet.getBoolean("done");

                        todoItems.add(new TodoItem(todoId, title, description, date, done1));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;

    }

    @Override
    public TodoItem update(TodoItem todoItem) {

        String sql = "UPDATE todo_item SET title = ?, description = ? , deadline = ?, done = ?, " +
                "assignee_id = ? WHERE todo_id = ?";

        PersonDaoCollection creator = new PersonDaoCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,todoItem.getTitle());
            preparedStatement.setString(2,todoItem.getDescription());
            preparedStatement.setDate(3,Date.valueOf(todoItem.getDeadline()));
            preparedStatement.setBoolean(4,todoItem.isDone());
            preparedStatement.setInt(5,creator.findById(todoItem.getCreator().getPerson_id()).getPerson_id());
            preparedStatement.setInt(6,todoItem.getTodo_id());

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return todoItem;

    }

//    @Override
//    public Collection<TodoItem> findDeadlineBefore(LocalDate date) {
//
//        ArrayList<TodoItem> result = new ArrayList<>();
//        for (TodoItem element : todoItems){
//            if(element.getDeadline().isBefore(date)){
//
//                result.add(element);
//            }
//        }
//        return result;
//
//    }

//    @Override
//    public Collection<TodoItem> findDeadlineAfter(LocalDate date) {
//        ArrayList<TodoItem> result = new ArrayList<>();
//        for (TodoItem element : todoItems){
//            if(element.getDeadline().isAfter(date)){
//
//                result.add(element);
//            }
//        }
//        return result;
//    }

    @Override
    public boolean remove(int id) {

        String sql = "DELETE FROM todo_item WHERE todo_id = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("todoItem removed successfully");
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
