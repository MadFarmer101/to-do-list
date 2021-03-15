package toDoList;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        String input = "task2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertTrue(toDoLy.removeTask());
    }

    /**
     * Assert that list size is decreased by one
     * when task has been removed from a list.
     */
    @Test
    public void checksForCorrectListSizeAfterTaskIsRemovedFromAList() {
        String input = "task2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        toDoLy.removeTask();

        assertEquals(2, toDoLy.getToDoList().size());
    }

    /**
     * Assert that false is returned when
     * a user is trying to remove a task when a name doesn't match with his input.
     */
    @Test
    public void userGetsAnErrorMessageWhenRemovingATaskWhenNameInputDoesntMatch() {
        String input = "task4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertFalse(toDoLy.removeTask());
    }


    @Test
    public void userGetsErrMsgWhenNoTasksHasThatProject() {
        String input = "project450";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = "\nPlease enter a project name:\n\nNo tasks found for that project!" + System.getProperty("line.separator");

        toDoLy.showTasksByDateOrProject("2");

        assertEquals(expectedOutput, outputStream.toString());

    }


    @Test
    public void userGetsMsgWhenNoTasksHasThatDueDate() {
        String input = "2021-04-16";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = "\nPlease enter a Due Date (YYYY-MM-DD):\n\nNo tasks found for that due date!" + System.getProperty("line.separator");

        toDoLy.showTasksByDateOrProject("1");

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void returnsTrueWhenTaskIsSuccessfullyMarkedAsDone() {
        String input = "task2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertTrue(toDoLy.markTaskAsDoneOnTheList());
    }

    @Test
    public void returnsFalseWhenTaskisAlreadyMarkedDone() {
        String input = "task1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        toDoLy.markTaskAsDoneOnTheList();

        String input2 = "task1";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        assertFalse(toDoLy.markTaskAsDoneOnTheList());
    }

    @Test
    public void checkCompletedTaskCount() {
        assertEquals(2, toDoLy.completedTasksCount());
    }

    @Test
    public void checkNotCompletedTaskCount() {
        assertEquals(3, toDoLy.notCompletedTasksCount());
    }

}
