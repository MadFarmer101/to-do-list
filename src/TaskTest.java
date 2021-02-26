import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

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
}
