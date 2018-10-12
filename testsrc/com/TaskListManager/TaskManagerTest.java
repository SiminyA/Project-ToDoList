package com.TaskListManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private List<Task> tasks = new ArrayList<>();
    TaskManager tf = new TaskManager();


    @BeforeEach
    void setUp() {
        Task t1 = new Task("Testing", LocalDate.parse("2018-12-13"), "Done", "ToDoListv0.1");
        tasks.add(t1);
        Task t2 = new Task("Design", LocalDate.parse("2018-12-17"), "Done", "ToDoListv0.1");
        tasks.add(t2);
        Task t3 = new Task("UAT", LocalDate.parse("2018-11-13"), "Done", "ToDoListv0.1");
        tasks.add(t3);
        Task t4 = new Task("Implement", LocalDate.parse("2018-12-29"), "Created", "ToDoListv4.1");
        tasks.add(t4);

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void myTasks() {
        assertEquals(2, 3);  //Failed case
        assertEquals(3, 3);  //Passed case

    }


    @Test
    void testtodisplayMenu() {

        PrintStream output = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        tf.showMenu();
        assertEquals("Hello", os.toString());
        System.setOut(System.out);
    }


    /**
     * Test the whether the task added is present in the List
     */
        /* @Test
        void addTestPass() {
            Task taskadd = new Task("Analysis",LocalDate.parse("2018-12-12"),"Done","ToDoListv0.1");
            tasks.add(taskadd);
            assertEquals("Analysis",tasks.get(3).getTaskTitle());
            assertEquals(LocalDate.parse("2018-12-12"),tasks.get(3).gettaskdueDate());
            assertEquals("Done",tasks.get(3).gettaskStatus());
            assertEquals("ToDoListv0.1",tasks.get(3).getprojectName());
        }*/

    /**
     * Test whether the task is present in the List -
     */
       /* void addTestFail() {
            Task taskadd = new Task("IT/SIT",LocalDate.parse("2018-12-16"),"Created","ToDoListv0.2");
            tasks.add(taskadd);
            assertEquals("IT/SIT",tasks.get(4).getTaskTitle());
            assertEquals(LocalDate.parse("2018-12-19"),tasks.get(4).gettaskdueDate());
            assertEquals("Done",tasks.get(4).gettaskStatus());
            assertEquals("ToDoListv0.1",tasks.get(4).getprojectName());
        }*/

    /**
     * Test for IndexOutOfBoundsException
     */

        /*void addTestOutofBoundsFail() {
            Task taskadd = new Task("IT/SIT",LocalDate.parse("2018-12-16"),"Created","ToDoListv0.2");
            tasks.add(taskadd);
            assertEquals("IT/SIT",tasks.get(5).getTaskTitle());
            assertEquals(LocalDate.parse("2018-12-19"),tasks.get(5).gettaskdueDate());
            assertEquals("Done",tasks.get(5).gettaskStatus());
            assertEquals("ToDoListv0.1",tasks.get(5).getprojectName());
        }*/
    @Test
    void display(){

    }

    @Test
    void showListdisplay() {

        ArrayList<Task> sorted = new ArrayList<>(tasks);

        tasks.sort((Task task1, Task task2) -> task1.gettaskdueDate().compareTo(task2.gettaskdueDate()));
        // for(Task k : sorted)
        assertEquals(sorted.get(1).gettaskdueDate(), tasks.get(1).gettaskdueDate());


    }

    @Test
    void run() {
    }

    /**
     * Test the edit function which modifies the task with the new values specified
     */

    @Test
    void test_task_edit() {
        Task taskadd = new Task("Requirement Analysis", LocalDate.parse("2018-11-25"), "InProgress", "ToDoListv1.6");
        tasks.add(taskadd);
        tasks.get(3).setprojectName("ToDoListv2.2");
        tasks.get(3).setTaskTitle("SIT");
        tasks.get(3).setTaskdueDate(LocalDate.parse("2018-12-25"));
        tasks.get(2).settaskStatus("Get2Done");
        assertEquals("ToDoListv2.2", tasks.get(3).getprojectName());  // Passed case for project name
        // assertEquals("ToDoListv3.2",tasks.get(3).getprojectName());  // Failed case for project name
        // assertEquals("Requirement Analysis",tasks.get(3).getTaskTitle());   // Failed case for task title
        // assertEquals("Task1",tasks.get(3).getTaskTitle());   // Passed case for task title
        // assertEquals(LocalDate.parse("2018-11-28"),tasks.get(3).gettaskdueDate()); // Failed case for task date
        // assertEquals(LocalDate.parse("2018-12-25"),tasks.get(3).gettaskdueDate()); // Passed case for task date
        // assertEquals("Done",tasks.get(3).gettaskStatus()); // Passed case for task status
        // assertEquals("InProgress",tasks.get(3).gettaskStatus()); // Failed case for task status
        // assertEquals("InProgress", tasks.get(4).gettaskStatus()); // Failed case - array out of bound
    }

    @Test
    void task_delete() {
        tasks.remove(3);
        // assertEquals(4,tasks.size()); // Failed case for task status
        assertEquals(3, tasks.size()); // Passed case for task status
    }
}
