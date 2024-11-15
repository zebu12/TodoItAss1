package se.lexicon.Dao;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDao {

    TodoItem persist(TodoItem todoItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findDeadlineBefore(LocalDate date);
    Collection<TodoItem> findDeadlineAfter(LocalDate date);
    void remove(int id);






}
