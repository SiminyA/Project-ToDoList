import TaskToDoly.FileHandler;
import com.ToDoly.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FileHandlerTest {
    private List<Task> tasks = new ArrayList<>();
    FileHandler fh = new FileHandler();
    ;


    @BeforeEach
    void setUp() {
      /*  Task t1 = new Task("Testing", LocalDate.parse("2018-12-13"), "Done", "ToDoListv0.1");
        tasks.add(t1);
        Task t2 = new Task("Design", LocalDate.parse("2018-12-17"), "Done", "ToDoListv0.1");
        tasks.add(t2);
        Task t3 = new Task("UAT", LocalDate.parse("2018-11-13"), "Done", "ToDoListv0.1");
        tasks.add(t3);
        Task t4 = new Task("Implement", LocalDate.parse("2018-12-29"), "Created", "ToDoListv4.1");
        tasks.add(t4); */

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void taskwritetofile() {
        try {
            FileOutputStream file_output_stream = new FileOutputStream("/Users/tmp-sda-1189/Documents/TestTack.txt");
            ObjectOutputStream output_stream = new ObjectOutputStream(file_output_stream);
            Task t1 = new Task("Testing", LocalDate.parse("2018-12-13"), "Done", "ToDoListv0.1");
            tasks.add(t1);
            Task t2 = new Task("Design", LocalDate.parse("2018-12-17"), "Done", "ToDoListv0.1");
            tasks.add(t2);
            Task t3 = new Task("UAT", LocalDate.parse("2018-11-13"), "Done", "ToDoListv0.1");
            tasks.add(t3);
            Task t4 = new Task("Implement", LocalDate.parse("2018-12-29"), "Created", "ToDoListv4.1");
            tasks.add(t4);
            output_stream.writeObject(tasks);


             //   assertEquals("true", output_stream.equals(tasks));
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    void taskloadtoarray() {

    }
}
