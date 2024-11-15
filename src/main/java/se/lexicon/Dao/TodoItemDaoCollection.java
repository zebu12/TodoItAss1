package se.lexicon.Dao;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDaoCollection implements TodoItemDao{

    private Collection<TodoItem> todoItems = new ArrayList<>();

    public TodoItemDaoCollection() {
    }



    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItems.add(todoItem);

        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem element : todoItems){
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        ArrayList<TodoItem> result = new ArrayList<>();
        for (TodoItem element : todoItems){
            if (element.isCompleted()){
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        ArrayList<TodoItem> result = new ArrayList<>();
        for (TodoItem element : todoItems){
            if (element.getTitle().contains(title)){
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        ArrayList<TodoItem> result = new ArrayList<>();
        for (TodoItem element : todoItems){
            if(element.getId() == personId){
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findDeadlineBefore(LocalDate date) {

        ArrayList<TodoItem> result = new ArrayList<>();
        for (TodoItem element : todoItems){
            if(element.getDeadline().isBefore(date)){

                result.add(element);
            }
        }
        return result;

    }

    @Override
    public Collection<TodoItem> findDeadlineAfter(LocalDate date) {
        ArrayList<TodoItem> result = new ArrayList<>();
        for (TodoItem element : todoItems){
            if(element.getDeadline().isAfter(date)){

                result.add(element);
            }
        }
        return result;
    }

    @Override
    public void remove(int id) {
        for (TodoItem todoItem : todoItems){
            if (todoItem.getId() == id){
                todoItems.remove(todoItem);
            }
        }

    }
}
