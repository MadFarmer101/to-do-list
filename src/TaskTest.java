import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;
import java.time.*;

public class TaskTest {
    @Test
    void taskHasACorrectName() {
        Task task = new Task();
        task.setName("task1");
        assertTrue(task.getName().equals("task1"));
    }

    @Test
    void taskHasACorrectProject() {
        Task task = new Task();
        task.setProject("project1");
        assertTrue(task.getProject().equals("project1"));
    }

    @Test
    void statusIsFalseWhenTaskIsCreated() {
        Task task = new Task();
        assertFalse(task.status());
    }

    @Test
    void statusIsTrueWhenTaskIsMarkedAsDone() {
        Task task = new Task();
        task.markAsDone();
        assertTrue(task.status());
    }

    @Test
    void taskHasACorrectDueDate() {
        Task task = new Task();
        LocalDate deadline = LocalDate.parse("2021-03-03");
        task.setDueDate(deadline);
        assertTrue(task.getDueDate().toString().equals("2021-03-03"));
    }
}
