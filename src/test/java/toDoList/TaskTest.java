package toDoList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Test class for Task class.
 *
 * @author Janko
 * @version 1.0
 * @since 2021-03-15
 */
public class TaskTest {

    // Create a new Task object
    static Task task = new Task();

    /**
     * Set up all the Task's field's
     * In the end it will test that createTask method
     * and all the setter methods are working correctly
     */
    @BeforeAll
    public static void setTaskFields() {
        String input = "task1\nproject1\n2034-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        task.createTask();
    }

    /**
     * Assert that getName method returns a correct task's name.
     */
    @Test
    public void taskHasACorrectName() {
        assertEquals("task1", task.getName());
    }

    /**
     * Assert that getProject method returns a correct task's project.
     */
    @Test
    void taskHasACorrectProject() {
        assertEquals("project1", task.getProject());
    }

    /**
     * Assert that getDueDate method returns a correct task's due date.
     */
    @Test
    void taskHasACorrectDueDate() {
        assertEquals("2034-05-03", task.getDueDate().toString());
    }

    /**
     * Assert that status field is false
     * when task object is created.
     */
    @Test
    void statusIsFalseWhenTaskIsCreated() {
        assertFalse(task.status());
    }

    /**
     * Assert that status field is true
     * when task is marked as done.
     */
    @Test
    void statusIsTrueWhenTaskIsMarkedAsDone() {
        task.markAsDone();
        assertTrue(task.status());
    }

    /**
     * Assert that NullPointerException is thrown
     * when we try to set a name as an empty string
     */
    @Test
    public void exceptionIsThrownOnEmptyTitle() {
        assertThrows(NullPointerException.class, () -> task.setName(""));
    }

    /**
     * Assert that NullPointerException is thrown
     * when we try to set a name with only empty spaces and no characters.
     */
    @Test
    public void exceptionIsThrownOnTitleWithOnlySpaces() {
        assertThrows(NullPointerException.class, () -> task.setName("   "));
    }

    /**
     * Assert that DateTimeException is thrown
     * when we try to set a due date in past
     */
    @Test
    public void exceptionIsThrownOnDueDateSetInPast() {
        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("2021-03-14")));
    }

    /**
     * Assert that DateTimeException is thrown
     * when we try to set a due date with wrong format
     */
    @Test
    public void exceptionIsThrownOnDueDateWithWrongFormat() {
        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("22-05-03")));
    }

}
