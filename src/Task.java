import java.util.Date;

public class Task {
    private String name;
    private  String project;
    private boolean status;
    private Date dueDate;

    public Task() {
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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
