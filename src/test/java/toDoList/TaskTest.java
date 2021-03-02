package toDoList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TaskTest {
    static Task task = new Task();

    @BeforeAll
    public static void setTaskFields() {
        String input = "task1\nproject1\n2021-05-03";
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
        assertEquals("2021-05-03", task.getDueDate().toString());
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

}
