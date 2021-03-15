package toDoList;

import java.io.Serializable;
import java.time.*;
import java.util.Scanner;

/**
 * This is a model class and it represents a Task object
 * It contains necessary fields and methods to operate on task object.
 *
 * @author  Janko
 * @version 1.0
 * @since   2021-03-15
 **/
public class Task implements Serializable {

    private String name;
    private String project;
    private boolean status;
    private LocalDate dueDate;

    /**
     * Creating an object of Task class
     */
    public Task() {
        this.status = false;
    }

    /**
     * A method to get the task title
     * @return a String containing the title of a task
     */
    public String getName() {
        return name;
    }

    /**
     * A method to set the title of a Task object
     * @param name A String that holds the title of a task and it cannot be empty or null.
     * @throws NullPointerException if title is null or empty string
     */
    public void setName(String name) throws NullPointerException {
        if (name.trim().equals("")) {
            throw new NullPointerException("REQUIRED: Name can't be empty.");
        }
        this.name = name;
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
     * Marks the task as done by setting it's status to true.
     */
    public void markAsDone() {
        this.status = true;
    }

    /**
     * Sets Task's name, project and due date in accordance with user's input.
     */
    public void createTask() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Name: ");
        this.setName(userInput.nextLine());

        System.out.println("Project: ");
        this.setProject(userInput.nextLine());

        System.out.println("Due Date (YYYY-MM-DD): ");
        this.setDueDate(LocalDate.parse(userInput.nextLine()));
    }

    public String toString() {
        return "\n====================\nTASK: " + name + "\nPROJECT: " + project + "\nDUE DATE: " + dueDate + "\nSTATUS: " + (status ? "Done" : "Not Done\n====================");
    }
}
