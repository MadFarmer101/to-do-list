package toDoList;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();

    /**
     * @return toDoList.
     */
    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    /**
     * Calls on createTask method to set all the task's fields.
     * After task is created it's added to the list.
     */
    public void addTask() {
        Task task = new Task();

        task.createTask();

        toDoList.add(task);

        System.out.println("Task is successfully added");
    }

    public Task findTaskByName() {

        System.out.println("Please enter a name of a task:");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        for (Task task : toDoList) {
            if (task.getName().equalsIgnoreCase(userInput))
                return task;
        }
        System.err.println("You don't have a task with that name.");
        return null;
    }

    /**
     * Asks a user to input a name of the task that he wants deleted.
     * Loops toDoList field
     *
     * @return true if name that user entered is matching any of a tasks names from the list
     */
    public boolean removeTask() {

        Task task = this.findTaskByName();

        if (task != null) {
            toDoList.remove(task);
            System.out.println("\nTask has been successfully removed");
            return true;

        } else
            return false;
    }

    /**
     * Asks a user to input a project of the tasks he wants the view
     * Search through toDoList field to see if there is a match by project
     *
     * @return null if there is no match and display an error message
     * otherwise an ArrayList populated with tasks with the same project as the user input
     */
    public void showTasksByDateOrProject(String choice) {
        Scanner userInput = new Scanner(System.in);
        int hitsCounter = 0;

        if (choice.equals("1")) {
            System.out.println("\nPlease enter a Date (YYYY-MM-DD):");
            String usersDateInput = userInput.nextLine();

            for (Task task : toDoList) {
                if (task.getDueDate().toString().equalsIgnoreCase(usersDateInput)) {
                    System.out.println(task);
                    hitsCounter++;
                }
            }

        } else if (choice.equals("2")) {

            System.out.println("\nPlease enter a project name:");
            String usersProjectInput = userInput.nextLine();

            for (Task task : toDoList) {
                if (task.getProject().equalsIgnoreCase(usersProjectInput)) {
                    System.out.println(task);
                    hitsCounter++;
                }
            }

        }

        if (hitsCounter == 0 && (choice.equals("1") || choice.equals("2")))
            System.err.println("\nNo tasks found for your query. Try again");
    }

    /**
     * Asks a user to input a date of the tasks he wants the view
     * Search through toDoList field to see if there is a match by date user entered
     *
     * @return null if there is no match and display a message
     * otherwise an ArrayList populated with tasks with the same due date
     */
    public ArrayList<Task> showTasksByDueDate() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        ArrayList<Task> tasksWithSameDate = new ArrayList<>();
        System.out.println("Please enter a Date (YYYY-MM-DD):");

        for (Task task : toDoList) {
            if (task.getDueDate().toString().equalsIgnoreCase(userInput))
                tasksWithSameDate.add(task);
        }

        if (tasksWithSameDate.isEmpty()) {
            System.out.println("You have no tasks for that due date.");
            return null;
        }
        return tasksWithSameDate;
    }

    /**
     * A method that finds the task by name
     * Then prompts the user what field he wants to edit
     * Sets task name, project or due date depending on users choice
     */
    public void editTask() {

        Task task = this.findTaskByName();

        if (task != null) {
            System.out.println("1) Edit Name\n2) Edit Project\n3) Edit Due Date");
            System.out.println("Please enter a number next to the option you would like to edit");


            Scanner userInput = new Scanner(System.in);
            String choice = userInput.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Please enter new name:");
                    task.setName(userInput.nextLine());
                    System.out.println("Name is successfully changed");
                }
                case "2" -> {
                    System.out.println("Please enter new project:");
                    task.setProject(userInput.nextLine());
                    System.out.println("Project is successfully changed");
                }
                case "3" -> {
                    System.out.println("Please enter new due date:");
                    task.setDueDate(LocalDate.parse(userInput.nextLine()));
                    System.out.println("Project is successfully changed");
                }
                default -> {
                    System.out.println("There is no option with that number. Let's go from the begging");
                    this.editTask();
                }
            }
        }
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
        Task task = this.findTaskByName();

        if (!task.status()) {
            task.markAsDone();
            System.out.println("Task is marked as done!");
            return true;
        } else {
            System.err.println("Task is already marked as completed!");
            return false;
        }
    }

    public void showFormattedList() {
        if (toDoList.size() == 0)
            System.err.println("\n>>>You don't have any tasks.");
        else
            System.out.println("\n>>>TO DO LIST:");
        for (Task task : toDoList) {
            System.out.println(task);
        }
    }

}
