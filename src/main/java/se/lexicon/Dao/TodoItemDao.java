package se.lexicon.Dao;

import se.lexicon.Person;
import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDao {

    TodoItem create(TodoItem todoItem);
    Collection<TodoItem> findAll();
    TodoItem findById(int id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByAssignee(int personId);
    Collection<TodoItem> findByPersonId(Person person);
    Collection<TodoItem> findByUnassignedTodoitems();
    TodoItem update(TodoItem todoItem);
    boolean remove(int id);



//    Collection<TodoItem> findByTitleContains(String title);
//    Collection<TodoItem> findDeadlineBefore(LocalDate date);
//    Collection<TodoItem> findDeadlineAfter(LocalDate date);







}
