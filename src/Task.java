import java.util.Date;

public class Task {
    private String name;
    private  String project;
    private boolean isDone;
    private Date status;

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public Date getDueDate() {
        return status;
    }

    public void setDueDate(Date dueDate) {
        this.status = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setName(String name) {
        this.name = name;
    }
}
