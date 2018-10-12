package com.TaskListManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskTest {



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getTaskTitle() {
        Task task_test = new Task("Analysis", LocalDate.now(),"Created","ToDoList");
        assertEquals("Analysis",task_test.getTaskTitle());
    }
    /*@Test
    void gettaskdueDate() {
        Task task_test = new Task("Design",LocalDate.now(),"In Progress","ToDoList v0.1");
        assertEquals(LocalDate.now(),task_test.gettaskdueDate());
    }*/

    @Test
    void gettaskdueDate() {
        Task task_test;
        task_test = new Task("Testing",LocalDate.parse("0000-00-13"),"Created","ToDoListv0.1");
        task_test.setTaskdueDate(LocalDate.parse("2018-12-13"));
        assertEquals(LocalDate.parse("2018-11-13"),task_test.gettaskdueDate());

    }

    @Test
     void getprojectName() {
        Task task_test;
        task_test = new Task("UAT", LocalDate.parse("2018-11-12"),"IN Progress","ToDOLost v0.0");
        assertEquals("ToDOLost v0.0",task_test.getprojectName());
    }


    @Test
    void setTaskdueDate() {
        Task task_test= new Task("Design",LocalDate.parse("2018-11-12"),"InProgress","Project23");
        task_test.setTaskdueDate(LocalDate.now());
        assertTrue(task_test.gettaskdueDate().equals(LocalDate.now()));

    }

    @Test
    void settaskStatus() {
        Task task_test= new Task("Analysis",LocalDate.now(),"Created","Project12");
        task_test.settaskStatus("InProgress");
        assertTrue(task_test.gettaskStatus().equals("InProgress"));
    }

    @Test
    void setprojectName() {
        Task task_test;
        task_test = new Task("UAT", LocalDate.parse("2018-10-12"),"IN Progress","Project12");
        task_test.setprojectName("Project123");
        assertTrue(task_test.getprojectName().equals("Project123"));

    }

    @Test
    void setTaskTitle() {
        Task task_test;
        task_test = new Task("UAT", LocalDate.parse("2018-10-12"),"IN Progress","Project12");
        task_test.setprojectName("Analysis");
        assertTrue(task_test.getprojectName().equals("Analysis"));


    }
}