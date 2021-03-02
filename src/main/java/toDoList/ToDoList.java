package toDoList;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Task> iterator = toDoList.iterator();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a name of a task you want to delete: ");
        while (iterator.hasNext()) {
            if (userInput.nextLine().equalsIgnoreCase(iterator.next().getName())) {
                toDoList.remove(iterator.next());
                System.out.println("Task has been successfully deleted");
                return true;
            } else {
                System.out.println("You don't have a task with that name");
            }
        }
    }

}
