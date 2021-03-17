package toDoList;

/**
 * This class contains various menus that user will interact with
 *
 * @author Janko
 * @version 1.0
 * @since 2021-03-11
 **/
public class Menus {

    /**
     * This method will display the main menu
     * with all options for user selection.
     *
     * @param tasksCompleted    takes the number of complete tasks (int) to show in main menu
     * @param notCompletedTasks takes the number of incomplete tasks (int) to show in main menu
     */
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

    /**
     * This method displays the menu to show the options to edit task fields
     * according to user's selection
     */
    public static void showEditTaskMenu() {
        System.out.println("\n>> Edit Task Menu");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Edit Task's Name");
        System.out.println(">>> 2) Edit Task's Project");
        System.out.println(">>> 3) Edit Task's Due Date");
        System.out.println(">>> Press any key and then Enter to return to Main Menu");
        System.out.println(">>  Please enter your choice (1-3):");
    }

    /**
     * This method displays the menu to show the options to display all tasks
     * according to user's selection
     */
    public static void showListMenu() {
        System.out.println("\n>> Show List Menu");
        System.out.println("\n>> Pick an option:");
        System.out.println(">>> 1) Show List by Due Date");
        System.out.println(">>> 2) Show List by Project");
        System.out.println(">>> Press any key and then Enter to return to Main Menu");
        System.out.println(">>  Please enter your choice (1-2):");

    }
}
