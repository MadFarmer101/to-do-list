package toDoList;

public class Menus {

    public static void mainMenu(int tasksCompleted, int notCompletedTasks) {
        System.out.println("\n>> Welcome to ToDoListy");
        System.out.println(">> You have " + notCompletedTasks + " tasks todo and " + tasksCompleted + " tasks are done!");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Show ToDo List (by date or project)");
        System.out.println(">>> 2) Add New Task");
        System.out.println(">>> 3) Edit Task (update, mark as done, remove)");
        System.out.println(">>> 4) Save and Quit");
        System.out.println(">> Please enter your choice (1-4):");
    }
}
