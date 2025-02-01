import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description + " (Due: " + dueDate + ")";
    }
}
