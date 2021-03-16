package toDoList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents ToDoList which contains the ArrayList of Task objects
 *
 * @author Janko
 * @version 1.0
 * @since 2021-03-12
 **/

public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();

    /**
     * @return toDoList.
     */
    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    /**
     * A method calls on createTask method,
     * After task is created it's added to the list.
     */
    public void addTask() {
        Task task = new Task();

        task.createTask();

        toDoList.add(task);

        System.out.println("Task is successfully added");
    }

    /**
     * A method to read the value from user
     * and after loops through the list trying to find a match by name
     *
     * @return task when name is matching with user's input
     */
    public Task findTaskByName() {

        Scanner userInput = new Scanner(System.in);

        for (Task task : toDoList) {
            if (task.getName().equalsIgnoreCase(userInput.nextLine()))
                return task;
        }
        System.err.println("You don't have a task with that name.");
        return null;
    }

    /**
     * A method calls on findTaskByName method
     * and stores the value in a Task object
     *
     * @return true if Task object is not equal to null
     * and removes the object from the List, false otherwise
     */
    public boolean removeTask() {

        System.out.println("\nPlease enter a name of a task you would like to remove:");

        Task task = this.findTaskByName();

        if (task != null) {
            toDoList.remove(task);
            System.out.println("\nTask has been successfully removed");
            return true;

        } else
            return false;
    }

    /**
     * A method that finds all the tasks with under same project
     * and prints them on the screen.
     */
    public ArrayList<Task> findTasksUnderSameProject() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasksUnderSameProject = new ArrayList<>();

        System.out.println("\nPlease enter a project name:");
        String usersDateInput = scanner.nextLine();

        for (Task task : toDoList) {
            if (task.getProject().equalsIgnoreCase(usersDateInput)) {
                tasksUnderSameProject.add(task);
            }
        }

        if (tasksUnderSameProject.isEmpty())
            System.out.println("\nYou have no tasks under that project on your ToDoListy!");
        return tasksUnderSameProject;
    }

    /**
     * A method that finds all the tasks with same due date
     * and prints them on the screen.
     */
    public void showTasksWithSameDueDate() {
        Scanner scanner = new Scanner(System.in);
        int hits = 0;

        System.out.println("\nPlease enter a Due Date (YYYY-MM-DD):\"");
        String usersDateInput = scanner.nextLine();

        for (Task task : toDoList) {
            if (task.getDueDate().toString().equalsIgnoreCase(usersDateInput)) {
                System.out.println(task);
                hits++;
            }
        }

        if (hits == 0)
            System.out.println("\nYou have no tasks for that due date!");
        else
            System.out.println("\nYou have " + hits + " task" + (hits == 1 ? "" : "s") + " on your list!");
    }

    /**
     * A method to display the contents of ArrayList
     *
     * @param userChoice a string holding a number, "1" for calling on a findTasksWithSameDueDate method,
     *               "2" for calling on a findTasksBelongingToSameProject method.
     */
    public void showTasksByDateOrProject(String userChoice) {
        ArrayList<Task> sortedTasks;

        if (userChoice.equals("1")) {
            this.showTasksWithSameDueDate();

        } else if (userChoice.equals("2")) {
            sortedTasks = this.findTasksUnderSameProject();
            for (Task task : sortedTasks)
                System.out.println(task);
        } else
        System.out.println("Returning to Main Menu...");
    }

    /**
     * @param choice a string holding a number, "1" for editing task's name, "2" for editing task's project,
     *               "3" for editing task's due date
     *               The method calls on findTaskByName and stores the value in the Task object
     *               if Task object is not equal to null the method will prompt the user to enter a new value for a selected field.
     */
    public void editTask(String choice) {

        if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {

            System.out.println("Please enter a name of a task you would like to edit:");

            Task task = this.findTaskByName();
            Scanner userInput = new Scanner(System.in);

            if (task != null) {

                switch (choice) {
                    case "1" -> {
                        System.out.println("Please enter new name:");
                        task.setName(userInput.nextLine());
                        System.out.println("\nTask's name is successfully changed");
                    }
                    case "2" -> {
                        System.out.println("Please enter new project:");
                        task.setProject(userInput.nextLine());
                        System.out.println("\nTask's project is successfully changed");
                    }
                    case "3" -> {
                        System.out.println("Please enter new due date:");
                        task.setDueDate(LocalDate.parse(userInput.nextLine()));
                        System.out.println("\nTask's Due Date is successfully changed");
                    }
                }
            }
        }
        System.out.println("\nReturning to Main Menu!");
    }

    /**
     * A method to count the number of tasks with status true
     *
     * @return number of tasks with status true
     */
    public int completedTasksCount() {
        int count = 0;

        for (Task task : toDoList) {
            if (task.status()) {
                count++;
            }
        }
        return count;
    }

    /**
     * A method to count the number of tasks with status false
     *
     * @return number of tasks with status false
     */
    public int notCompletedTasksCount() {
        int count = 0;

        for (Task task : toDoList) {
            if (!task.status()) {
                count++;
            }
        }
        return count;
    }

    /**
     * A method that finds task by name and marks it status to true if it was false before
     *
     * @return true if task is marked as done, false otherwise
     */
    public boolean markTaskAsDoneOnTheList() {

        System.out.println("\nPlease enter a name of a task you would like to mark as done:");

        Task task = this.findTaskByName();

        if (!task.status()) {
            task.markAsDone();
            System.out.println("\nTask is successfully marked as done!");
            return true;
        } else {
            System.out.println("\nTask is already marked as done!");
            return false;
        }
    }

    /**
     * A method to display the contents of ArrayList
     */
    public void showFormattedList() {
        if (toDoList.size() == 0)
            System.err.println("\n>>>You don't have any tasks.");
        else
            System.out.println("\n>>>TO DO LIST:");
        for (Task task : toDoList) {
            System.out.println(task);
        }
    }

    /**
     * This method will write the data of Tasks from ArrayList to data file
     *
     * @param filename a string specifying the full path and extension of data file,
     * @return true if the writing operation was successful, otherwise false
     */
    public boolean writeToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(toDoList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method will read the data file from disk which will contain the data of previously saved tasks
     *
     * @param filename a string specifying the full path and extension of data file
     * @return true if the reading operation was successful, otherwise false
     */
    public boolean readFromFile(String filename) {

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                System.out.println(filename + " does not exists!");
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            toDoList = (ArrayList<Task>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
