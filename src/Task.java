import java.util.Date;

public class Task {
    private String name;
    private  String project;
    private boolean status;
    private Date dueDate;

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
}
