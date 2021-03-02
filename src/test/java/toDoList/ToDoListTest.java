package toDoList;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    static ToDoList toDoLy = new ToDoList();

    @BeforeAll
    public static void add2TasksToTheList() {
        String input = "task1\nproject1\n2021-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        toDoLy.addTask();

        String input2 = "task2\nproject2\n2021-04-15";
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());

        System.setIn(inputStream2);
        toDoLy.addTask();
    }

    @Test
    public void checksForCorrectListSize() {
        assertEquals(2, toDoLy.getToDoList().size());
    }

    @Test
    public void checksForCorrectTaskName() {
        assertEquals("task1", toDoLy.getToDoList().get(0).getName());
    }

    @Test
    public void checksForCorrectTaskProject() {
        assertEquals("project2", toDoLy.getToDoList().get(1).getProject());
    }

    @Test
    public void checksForCorrectTaskDueDate() {
        assertEquals("2021-04-15", toDoLy.getToDoList().get(1).getDueDate().toString());
    }

    @Test
    public void userSuccessfullyRemovesTaskByName() {
        String input = "task2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        toDoLy.removeTask();

        assertEquals(1, toDoLy.getToDoList().size());
    }

    @Test
    public void userCanSeeCorrectErrorMessage() {

        String input = "task3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputStream));

        toDoLy.removeTask();

        String expectedOutput = "There is no task with that name on the list." + System.getProperty("line.separator");

        assertEquals(expectedOutput, outputStream.toString());
    }

}
