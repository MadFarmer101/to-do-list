import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void taskHasAName() {
        Task task = new Task();
        task.setName("task1");

        assertTrue(task.getName().equals("task1"));
    }
}
