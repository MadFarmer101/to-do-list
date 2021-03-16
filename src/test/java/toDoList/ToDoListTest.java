package toDoList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ToDoList class.
 *
 * @author Janko
 * @version 1.0
 * @since 2021-03-15
 */
public class ToDoListTest {

    // Create a new ToDoList object
    private static final ToDoList toDoLy = new ToDoList();

    /**
     * Add three different Task objects to the toDoLy object
     * Two tasks have same project
     * and two of them have same due date
     * It uses addTask method and if all the tests are passing
     * addTask method is working
     */
    @BeforeAll
    public static void addThreeTasksToTheList() {
        String input = "task1\nproject1\n2021-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        toDoLy.addTask();

        String input2 = "task2\nproject2\n2021-04-15";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());

        System.setIn(inputStream2);
        toDoLy.addTask();

        String input3 = "task3\nproject1\n2021-04-15";
        InputStream inputStream3 = new ByteArrayInputStream(input3.getBytes());

        System.setIn(inputStream3);
        toDoLy.addTask();
    }

    /**
     * Assert that toDoly has a correct size.
     */
    @Test
    public void checksForCorrectListSize() {
        assertEquals(3, toDoLy.getToDoList().size());
    }

    /**
     * Assert that task object at first index
     * has correct name.
     */
    @Test
    public void checksForCorrectTaskName() {
        assertEquals("task1", toDoLy.getToDoList().get(0).getName());
    }

    /**
     * Assert that task object at second index
     * has correct project.
     */
    @Test
    public void checksForCorrectTaskProject() {
        assertEquals("project2", toDoLy.getToDoList().get(1).getProject());
    }

    /**
     * Assert that task object at third index
     * has correct due date.
     */
    @Test
    public void checksForCorrectTaskDueDate() {
        assertEquals("2021-04-15", toDoLy.getToDoList().get(2).getDueDate().toString());
    }

    /**
     * Assert that true is returned
     * when user removes a task from a list.
     */
    @Test
    public void userSuccessfullyRemovesTask() {
        // Add a task that is to be removed from the list
        String input = "taskToBeRemoved\nproject1\n2021-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        toDoLy.addTask();

        String input2 = "taskToBeRemoved";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        assertTrue(toDoLy.removeTask());
    }

    /**
     * Assert that list size is decreased by one
     * when task has been removed from a list.
     */
    @Test
    public void checksForCorrectListSizeAfterTaskIsRemovedFromAList() {
        // Add a task that is to be removed from the list
        String input = "taskToBeRemoved\nproject1\n2021-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        toDoLy.addTask();

        String input2 = "taskToBeRemoved";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        toDoLy.removeTask();

        assertEquals(3, toDoLy.getToDoList().size());
    }

    /**
     * Assert that false is returned when
     * a user is trying to remove a task when a name doesn't match with his input.
     */
    @Test
    public void methodReturnsFalseWhenRemovingATaskWhenNameInputDoesntMatch() {
        String input = "task4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertFalse(toDoLy.removeTask());
    }

    /**
     * Assert that list has a correct size
     * of tasks objects with same project.
     */
    @Test
    public void checksForCorrectListSizeOnTasksWithSameProject() {
        String input = "project1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ArrayList<Task> tasksWitSameProject = toDoLy.findTasksUnderSameProject();

        assertEquals(2, tasksWitSameProject.size());
    }


    /**
     * Assert that returned list is empty
     * when project from user's input doesn't match
     * with any of the project from tasks on the list.
     */
    @Test
    public void checkThatListIsEmptyIfThereIsNoTasksUnderInputtedProject() {
        String input = "project120";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ArrayList<Task> tasksWitSameProject = toDoLy.findTasksUnderSameProject();

        assertTrue(tasksWitSameProject.isEmpty());
    }

    /**
     * Assert that list has a correct size
     * of tasks objects with same due date.
     */
    @Test
    public void checksForCorrectListSizeOnTasksWithSameDueDate() {
        String input = "2021-04-15";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ArrayList<Task> tasksWitSameDueDate = toDoLy.findTasksWithSameDueDate();

        assertEquals(2, tasksWitSameDueDate.size());
    }


    /**
     * Assert that returned list is empty
     * when due date from user's input doesn't match
     * with any of the due dates from tasks on the list.
     */
    @Test
    public void checkThatListIsEmptyWhenThereAreNoTasksWithInputtedDueDate() {
        String input = "project120";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ArrayList<Task> tasksWitSameDueDate = toDoLy.findTasksWithSameDueDate();

        assertTrue(tasksWitSameDueDate.isEmpty());
    }

    /**
     * Assert that true is returned when
     * task is marked as done on the ToDoList.
     */
    @Test
    public void returnsTrueWhenTaskIsSuccessfullyMarkedAsDone() {

        String input = "task2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertTrue(toDoLy.markTaskAsDoneOnTheList());
    }

    /**
     * Assert that false is returned when
     * when user tries to mark a task as done
     * that is already marked as done.
     */
    @Test
    public void returnsFalseWhenTaskIsAlreadyMarkedDone() {
        String input = "task1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        toDoLy.markTaskAsDoneOnTheList();

        String input2 = "task1";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        assertFalse(toDoLy.markTaskAsDoneOnTheList());
    }

    /**
     * Assert that there are correct number of
     * tasks that are marked as done on the list.
     */
    @Test
    public void checkCompletedTaskCount() {
        assertEquals(1, toDoLy.completedTasksCount());
    }

    /**
     * Assert that there are correct number of
     * tasks that are not marked as done on the list.
     */
    @Test
    public void checkNotCompletedTaskCount() {
        assertEquals(3, toDoLy.notCompletedTasksCount());
    }

    @Test
    public void userSuccessfullyEditsTaskName() {
        String input = "task1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Scanner newName = new Scanner("new task1");

        toDoLy.editTask("1", newName);

        assertEquals("new task1", toDoLy.getToDoList().get(0).getName());
    }

}
