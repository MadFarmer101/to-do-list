package toDoList;

import java.util.Scanner;

public class Menus {

    public static void mainMenu(int tasksCompleted, int notCompletedTasks) {
        System.out.println("\n>> Welcome to ToDoListy");
        System.out.println(">> You have " + notCompletedTasks + " tasks todo and " + tasksCompleted + " tasks are done!");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Show ToDo List (by date or project)");
        System.out.println(">>> 2) Add New Task");
        System.out.println(">>> 3) Remove Task");
        System.out.println(">>> 4) Mark Task as Done");
        System.out.println(">>> 5) Edit Task");
        System.out.println(">>> 6) Save and Quit");
        System.out.println(">> Please enter your choice (1-6):");
    }

    public static void editTaskMenu() {

    }

    public static void showListMenu() {
        System.out.println("\n>> Show List Menu");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Show List by Due Date");
        System.out.println(">>> 2) Show List by Project");
        System.out.println(">>> Press any key to return to Main Menu");
        System.out.println(">>  Please enter your choice (1-2):");

    }
}
