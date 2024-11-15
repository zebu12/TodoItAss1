package se.lexicon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TodoItem {

    private static int itemCount = 1;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean completed;
    private Person creator;


    public TodoItem(String title, String taskDescription, LocalDate deadline, Boolean completed, Person creator) {

        this.id = itemCount++;
        this.title = Objects.requireNonNull(title, "Not allowed to be null or empty");
        this.taskDescription = taskDescription;
        this.deadline = Objects.requireNonNull(deadline, "Not allowed to be null");
        this.completed = completed;
        this.creator = Objects.requireNonNull(creator, "Not allowed to be null");


    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Person getCreator() {
        return creator;
    }

    public boolean isCompleted() {
        return completed;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Not allowed to be null or empty");
        }
        this.title = Objects.requireNonNull(title, "Not allowed to be null or empty");
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = Objects.requireNonNull(deadline, "Not allowed to be null");
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id: ").append(id).append("\n");
        builder.append("Title: ").append(title).append("\n");
        builder.append("Task Description: ").append(taskDescription).append("\n");
        builder.append("Deadline: ").append(deadline).append("\n");
        builder.append("Completed Status: ").append(completed).append("\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && completed == todoItem.completed && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadline, completed);
    }
}
