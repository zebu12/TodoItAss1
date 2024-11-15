package se.lexicon.Dao;

import se.lexicon.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskAdo {

    TodoItemTask persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int id);
    void remove(int id);
}
