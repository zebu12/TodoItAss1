package se.lexicon;

import java.util.Objects;

public class TodoItemTask {

    private static int taskCount = 1;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;


    public TodoItemTask(TodoItem todoItem, Person assignee){
        if(assignee != null){
            this.assignee = assignee;
        }
        this.todoItem = Objects.requireNonNull(todoItem, "TotoItem can not be null");
        this.assignee = assignee;
        this.id = taskCount++;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem can not be null");
    }

    public void setAssignee(Person assignee) {
        if(assignee == null){
            this.assigned = false;
        }
        this.assignee = assignee;
        this.assigned = true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").append(id).append(", assigned: ").append(assigned);
        builder.append("todoItem: ");
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        TodoItemTask that = (TodoItemTask) obj;
        return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
