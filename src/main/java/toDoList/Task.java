package toDoList;

import java.io.Serializable;
import java.time.*;
import java.util.Scanner;

/**
 * This is a model class and it represents a Task object
 * It contains necessary fields and methods to operate on task object.
 *
 * @author Janko
 * @version 1.0
 * @since 2021-03-15
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
     *
     * @return a String containing the title of a task
     */
    public String getName() {
        return this.name;
    }

    /**
     * A method to set the title of a Task object
     *
     * @param name A String that holds the name of a task and it cannot be empty.
     * @throws NullPointerException if name is an empty string
     */
    public void setName(String name) throws NullPointerException {

        //Throws NullPointerException if name field is empty
        if (name.trim().equals("")) {
            throw new NullPointerException("Name can't be empty.");
        }

        this.name = name;
    }

    /**
     * A method to get the project of a task
     *
     * @return a String containing the project field
     */
    public String getProject() {
        return this.project;
    }

    /**
     * A method to set the project field
     *
     * @param project A String that holds the name of project associated with task.
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * A method to get the due date of the task
     *
     * @return the due date of task as LocalDate object
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * A method to set the due date of a task
     *
     * @param dueDate The object of LocalDate
     * @throws DateTimeException if given date is a past date
     */
    public void setDueDate(LocalDate dueDate) throws DateTimeException {

        // Throw DateTimeException if past date is given
        if (dueDate.compareTo(LocalDate.now()) < 0) {
            throw new DateTimeException("You entered the date in the past!");
        }

        this.dueDate = dueDate;
    }

    /**
     * A method to get the status of task
     *
     * @return true: if the task is marked as done, otherwise it will return false
     */
    public boolean status() {
        return status;
    }

    /**
     * A method to mark a task's status field as true
     */
    public void markAsDone() {
        this.status = true;
    }

    /**
     * A method that sets the name, project and dueDate
     * fields according to the user's input
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

    /**
     * A method to get the task data as formatted string to display in multiple lines
     *
     * @return formatted string of all fields of a task
     */
    public String toString() {
        return "\n====================\nTASK: " + name + "\nPROJECT: " + project + "\nDUE DATE: " + dueDate + "\nSTATUS: " + (status ? "Done" : "Not Done\n====================");
    }
}
