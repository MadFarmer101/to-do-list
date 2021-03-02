package toDoList;

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

    public boolean removeTask() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println("Please enter a name of a task you want to delete:");

        for (Task task : toDoList) {
            if (task.getName().equalsIgnoreCase(userInput)) {
                toDoList.remove(task);
                System.out.println("Task has been successfully removed");
                return true;
            }
        }
        System.err.println("There is no task with that name on the list.");
        return false;
    }

}
