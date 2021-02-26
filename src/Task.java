import java.time.*;

public class Task {
    private String name;
    private  String project;
    private boolean status;
    private LocalDate dueDate;

    public Task() {
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean status() {
        return status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void markAsDone() {
        this.status = true;
    }

    public String toString() {
        return "Task name: " + name + ", Project: " + project + " , Due Date: " + dueDate + ", Status: " + (status ? "Task is completed" : "Task is not completed");
    }

}
