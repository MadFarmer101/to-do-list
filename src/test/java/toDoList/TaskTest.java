package toDoList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.LocalDate;

public class TaskTest {

    static Task task = new Task();

    @BeforeAll
    public static void setTaskFields() {
        String input = "task1\nproject1\n2034-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        task.createTask();
    }

    @Test
    public void taskHasACorrectName() {
        assertEquals("task1", task.getName());
    }

    @Test
    void taskHasACorrectProject() {
        assertEquals("project1", task.getProject());
    }

    @Test
    void taskHasACorrectDueDate() {
        assertEquals("2034-05-03", task.getDueDate().toString());
    }

    @Test
    void statusIsFalseWhenTaskIsCreated() {
        assertFalse(task.status());
    }

    @Test
    void statusIsTrueWhenTaskIsMarkedAsDone() {
        task.markAsDone();
        assertTrue(task.status());
    }

    @Test
    public void exceptionIsThrownOnEmptyTitle() {
        assertThrows(NullPointerException.class, () -> task.setName(""));
    }

    @Test
    public void exceptionIsThrownOnTitleWithOnlySpaces() {
        assertThrows(NullPointerException.class, () -> task.setName("   "));
    }

    @Test
    public void exceptionIsThrownOnDueDateSetInPast() {
        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("2020-05-03")));
    }

    @Test
    public void exceptionIsThrownOnDueDateWithWrongFormat() {
        assertThrows(DateTimeException.class, () -> task.setDueDate(LocalDate.parse("22-05-03")));
    }

}
