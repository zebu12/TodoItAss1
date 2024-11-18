package se.lexicon.Dao;

import se.lexicon.Sequencers.TodoItemTaskSequencer;
import se.lexicon.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDaoCollection implements TodoItemTaskAdo {

    private Collection<TodoItemTask> list = new ArrayList<>();

    public TodoItemTaskDaoCollection() {
    }



    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {

        int id = TodoItemTaskSequencer.nextId();
        todoItemTask = new TodoItemTask(id,todoItemTask.getTodoItem(),todoItemTask.getAssignee());
        list.add(todoItemTask);



        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask element : list){
            if (element.getId() == id){
                return element;
            }
        }
        return null;

    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return list;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask element : list){
            if(element.isAssigned()){
                result.add(element);

            }
        }
        return result;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        Collection<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask element : list){
            if(element.getAssignee().getId() == id){
                result.add(element);

            }


        }
        return result;

    }

    @Override
    public void remove(int id) {

        for (TodoItemTask element : list){
            if(element.getId() == id){
                list.remove(element);
            }
        }

    }
}
