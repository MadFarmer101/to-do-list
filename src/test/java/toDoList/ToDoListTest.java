package toDoList;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    static  ToDoList toDoLy = new ToDoList();

    @BeforeAll
    public static void createATask() {
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
}
