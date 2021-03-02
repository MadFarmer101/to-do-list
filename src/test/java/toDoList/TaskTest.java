package toDoList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.*;

public class TaskTest {
    static Task task = new Task();

    @BeforeAll
    public static void createTask() {
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
        Task task = new Task();
        task.setProject("project1");
        assertTrue(task.getProject().equals("project1"));
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
    void taskHasACorrectDueDate() {
        LocalDate deadline = LocalDate.parse("2021-03-03");
        task.setDueDate(deadline);
        assertTrue(task.getDueDate().toString().equals("2021-03-03"));
    }

}
