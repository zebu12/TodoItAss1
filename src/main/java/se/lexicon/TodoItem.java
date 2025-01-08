package se.lexicon;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {

    private static int itemCount = 1;
    private int todo_id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person creator;


    public TodoItem(int todo_id, String title, String description, LocalDate deadline, Boolean done, Person creator) {

        this.todo_id = todo_id;

        this.title = Objects.requireNonNull(title, "Not allowed to be null or empty");
        this.description = description;
        this.deadline = Objects.requireNonNull(deadline, "Not allowed to be null");
        this.done = done;
        this.creator = Objects.requireNonNull(creator, "Not allowed to be null");


    }

    public TodoItem() {
    }

    public TodoItem(String title, String description, LocalDate deadline, boolean done, Person creator) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.creator = creator;
    }

    public TodoItem(int todo_id, String title, String description, LocalDate deadline, boolean done) {
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Person getCreator() {
        return creator;
    }

    public boolean isDone() {
        return done;
    }


    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Not allowed to be null or empty");
        }
        this.title = Objects.requireNonNull(title, "Not allowed to be null or empty");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = Objects.requireNonNull(deadline, "Not allowed to be null");
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id: ").append(todo_id).append("\n");
        builder.append("Title: ").append(title).append("\n");
        builder.append("Task Description: ").append(description).append("\n");
        builder.append("Deadline: ").append(deadline).append("\n");
        builder.append("Completed Status: ").append(done).append("\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return todo_id == todoItem.todo_id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, deadline, done);
    }
}
