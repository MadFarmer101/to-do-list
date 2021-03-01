package toDoList;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    void successfullyAddTaskToTheToDOList() {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask();
        String name = "task1";
        InputStream in = new ByteArrayInputStream(name.getBytes());
        System.setIn(in);

        assertFalse(toDoList.toDoList.isEmpty());
    }
}
