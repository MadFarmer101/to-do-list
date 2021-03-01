package toDoList;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    void successfullyAddTaskToTheToDOList() {

        ToDoList toDoLy = new ToDoList();
        String input = "task1\nproject1\n2021-05-03";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);

        toDoLy.addTask();

        assertFalse(toDoLy.getToDoList().isEmpty());
    }
}
