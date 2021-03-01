package toDoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();

    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    public void addTask() {
        Scanner userInput = new Scanner(System.in);
        Task task = new Task();

        System.out.println("Name: ");
        task.setName(userInput.nextLine());

        System.out.println("Project: ");
        task.setProject(userInput.nextLine());

        System.out.println("Due Date: ");
        System.out.println("Date must be entered in a format: YYYY-MM-DD");
        task.setDueDate(LocalDate.parse(userInput.nextLine()));

        toDoList.add(task);
        System.out.println("Task is successfully added");
    }

}
