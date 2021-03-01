package toDoList;

import java.time.*;
import java.util.Scanner;

public class Task {
    private String name;
    private String project;
    private boolean status;
    private LocalDate dueDate;

    public Task() {
        this.status = false;
    }

    /**
     * @return task's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return task's project.
     */
    public String getProject() {
        return project;
    }

    /**
     * @return task's dueDate.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @return task's status.
     */
    public boolean status() {
        return status;
    }

    /**
     * Setts a task's dueDate.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Setts a task's project.
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Setts a task's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Marks the task as done by setting it's status to true.
     */
    public void markAsDone() {
        this.status = true;
    }

    public void createTask() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Name: ");
        this.setName(userInput.nextLine());

        System.out.println("Project: ");
        this.setProject(userInput.nextLine());

        System.out.println("Due Date: ");
        System.out.println("Date must be entered in a format: YYYY-MM-DD");
        this.setDueDate(LocalDate.parse(userInput.nextLine()));
    }

    public String toString() {
        return "\nTASK: " + name + "\nPROJECT: " + project + "\nDUE DATE: " + dueDate + "\nSTATUS: " + (status ? "Task is completed" : "Task is not completed");
    }
}
