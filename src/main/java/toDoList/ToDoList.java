package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    ArrayList<Task> toDoList = new ArrayList<>();

    public void addTask() {
        Scanner userInput = new Scanner(System.in);
        Task task = new Task();

        System.out.println("Please enter Task's name: ");
        task.setName(userInput.nextLine());
        
    }

}
