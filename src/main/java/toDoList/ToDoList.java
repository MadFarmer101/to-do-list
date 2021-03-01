package toDoList;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();

    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    public void addTask() {
        Task task = new Task();

        task.createTask();

        toDoList.add(task);
        System.out.println("Task is successfully added");
    }

}
