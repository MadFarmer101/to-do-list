import java.text.SimpleDateFormat;
import java.util.Date;
import  java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        task.setName("Task1");
        task.setProject("Project1");
        Date d = null;
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setDueDate(d);
        System.out.println(task);

        task.markAsDone();
        System.out.println(task);


    }
}
