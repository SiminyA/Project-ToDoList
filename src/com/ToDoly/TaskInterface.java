/*
 * Class to handle the Menu and associated tasks
 * @author Siminy
 * @version 27-09-2018 version 1 */


package com.ToDoly;

import TaskToDoly.FileHandler;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;
import java.util.Comparator;


public class TaskInterface implements Serializable {
    private FileHandler task_file_handler = new FileHandler();

    private List<Task> tasks;

    public TaskInterface() {
        tasks = task_file_handler.taskloadtoarray();
    }

    /* Display the menu options */

    public int myTasks() {
        int done_task = 0;
        int todo_task = 0;
        for (Task taskcount : tasks)
            if (taskcount.gettaskStatus().equals("Done")) {
                done_task++;

            }
        return done_task;

    }

    public void showMenu() {
        int done_task = myTasks();
        System.out.println("*********************************************************");
        System.out.println("                Welcome to ToDoly.");
        System.out.println("*********************************************************");
        System.out.println("You have " + (tasks.size() - done_task) + " tasks todo and " + done_task + " tasks are done!");
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println();
        System.out.println("                      Pick up an option");
        System.out.println("*********************************************************");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("*********************************************************");
    }

    /* Functions to handle the various task functions */


    public void update() {

        display();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Edit tasks(update, mark as done, remove)");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Enter the Task No to edit: ");
        int taskindex = Integer.parseInt(sc.next());
        if (taskindex > tasks.size()) {
            System.out.println("Please specify valid task no:");
        } else {
            taskindex = taskindex - 1;
            System.out.println();
            System.out.println();
            System.out.println("Edit menu");
            System.out.println("|------------------------------------------|");
            System.out.println("|1.Update the task                         |");
            System.out.println("|2.Mark as Done                            |");
            System.out.println("|3.Remove the task                         |");
            System.out.println("|------------------------------------------|");
            System.out.println();
            System.out.println();
            System.out.println("Select from the options ");
            String task_edit = sc.next();
            System.out.println();
            System.out.println();

            switch (task_edit) {
                case "1":

                    System.out.println("-------------------------------------------");
                    System.out.println("Update the tasks");
                    System.out.println("-------------------------------------------");
                    task_edit(taskindex);
                    break;

                case "2":
                    System.out.println("-------------------------------------------");
                    System.out.println("Mark as Done");
                    System.out.println("-------------------------------------------");
                    task_editstatus(taskindex);
                    break;

                case "3":
                    System.out.println("-------------------------------------------");
                    System.out.println("Remove the task");
                    System.out.println("-------------------------------------------");
                    task_delete(taskindex);
                    break;

                default:
                    System.out.println();
                    System.out.println("Please specify a valid option");
            }
        }
        System.out.println();
        System.out.println();
    }

    private void task_edit(int task_index) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String edit_taskname = sc.nextLine();
            System.out.println();
            System.out.println("Enter the due date (yyyy-mm-dd):");
            String new_dueDate = sc.nextLine();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate current_date = LocalDate.now();

            LocalDate task_due_date = LocalDate.parse(new_dueDate, dtf);
            System.out.println();

            if ((task_due_date.compareTo(current_date)) < 0) {
                System.out.println("Due date cannot be less than the current date");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Enter the new Status :");
                String edit_status = sc.nextLine();
                System.out.println();

                System.out.println("Enter the new Project Name  :");
                String edit_projectname = sc.nextLine();
                tasks.get(task_index).setTaskTitle(edit_taskname);
                tasks.get(task_index).setTaskdueDate(task_due_date);
                tasks.get(task_index).settaskStatus(edit_status);
                tasks.get(task_index).setprojectName(edit_projectname);
                System.out.println();
                System.out.println();
                System.out.println("Current Task " + (task_index + 1) + "updated with new values:" + tasks.get(task_index).getTaskTitle() + " " + tasks.get(task_index).gettaskdueDate() + "   " + tasks.get(task_index).gettaskStatus() + "   " + tasks.get(task_index).getprojectName());
                System.out.println();
                System.out.println();
            }

        } catch (java.time.format.DateTimeParseException parse_Exception) {
            System.out.println();
            System.out.println();
            System.out.println("Date entered is not in the specified format, please specify in yyyy-MM-dd format");

        }

        System.out.println();
        System.out.println();
    }


    private void task_editstatus(int task_index) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Enter the new Status :");
        String edit_status = sc.nextLine();
        tasks.get(task_index).settaskStatus(edit_status);
        System.out.println();
        System.out.println();
        System.out.println("Current Task " + (task_index + 1) + " updated with new status:" + "   " + tasks.get(task_index).gettaskStatus());
        System.out.println();
        System.out.println();


    }

    private void task_delete(int task_index) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Do you want to delete the task(Y/N");
        String delete_response = sc.next();
        System.out.println();
        System.out.println();
        if (delete_response.equals("Y")) {
            tasks.remove(task_index);
            System.out.println("Task " + (task_index + 1) + " is deleted");
        } else {
            System.out.println("Task" + (task_index + 1) + " not deleted");
        }

        System.out.println();
        System.out.println();
    }


    public void add() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println(" Add Task");
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String new_taskname = sc.nextLine();
            System.out.println();

            System.out.println("Enter the due date (yyyy-mm-dd):");
            String new_dueDate = sc.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate current_date = LocalDate.now();
            LocalDate task_due_date = LocalDate.parse(new_dueDate, dtf);
            System.out.println();

            if ((task_due_date.compareTo(current_date)) < 0) {
                System.out.println("Due date cannot be less than the current date");
                System.out.println();
            } else {


                System.out.println();
                System.out.println("Enter the Status :");
                String new_status = sc.nextLine();

                System.out.println();
                System.out.println("Enter the Project Name :");
                String new_projectname = sc.nextLine();

                tasks.add(new Task(new_taskname, task_due_date, new_status, new_projectname));
                System.out.println();

                System.out.println("New task added");
                System.out.println();


            }
        } catch (java.time.format.DateTimeParseException parse_exception) {
            System.out.println();
            System.out.println("Date entered is not in the specified format, please specify in yyyy-MM-dd format");

        }
        System.out.println();
        System.out.println();
    }

    public void display() {
        int index = 0;

        System.out.println("-------------------------------------------");
        System.out.println(" Task List");
        System.out.println("-------------------------------------------");
        System.out.println();


        System.out.printf("%10s %20s %27s %25s %28s ", "Task No", "Task Name", "Due Date ", "Status", "Project Name");
        System.out.println();

        System.out.printf("%10s %20s %27s %25s %28s", "--------", "---------", "--------", "-------", "------------");
        System.out.println();
        while (index < tasks.size()) {
            System.out.format("%10d %20s %27s %25s %28s", index + 1, tasks.get(index).getTaskTitle(), tasks.get(index).gettaskdueDate(), tasks.get(index).gettaskStatus(), tasks.get(index).getprojectName());
            System.out.println();
            index++;
        }
        System.out.println();
        System.out.println();
    }


    public void showListdisplay() {
        int index = 0;
        System.out.println();
        System.out.println();
        System.out.println("Show Task List");
        System.out.println("|------------------------------------------|");
        System.out.println("|1. Show task list - Sort by date          |");
        System.out.println("|2. Show task list - Filter by project name|");
        System.out.println("|------------------------------------------|");
        System.out.println();

        System.out.println("Select from the option ");
        Scanner sc = new Scanner(System.in);
        String display_option = sc.next();
        System.out.println();
        System.out.println();
        switch (display_option) {
            case "1":
                System.out.println("Show task list - Sort by date  ");
                System.out.println("-------------------------------");

                System.out.printf("%10s %20s %25s %25s ", "Due Date", "Task Name", "Status", " Project Name ");
                System.out.println();
                System.out.printf("%10s %20s %25s %25s ", "--------", "---------", "--------", "-------------");
                System.out.println();


                Comparator<Task> task_duedate_comparator = new Comparator<Task>() {
                    @Override
                    public int compare(Task task1, Task task2) {
                        return task1.gettaskdueDate().compareTo(task2.gettaskdueDate());
                    }
                };

                Collections.sort(tasks, task_duedate_comparator);
                while (index < tasks.size()) {
                    System.out.printf("%10s %20s %25s %25s ", tasks.get(index).gettaskdueDate(), tasks.get(index).getTaskTitle(), tasks.get(index).gettaskStatus(), tasks.get(index).getprojectName());
                    System.out.println();
                    index++;
                }
                break;


            case "2":
                System.out.println("Show task list - Filter by project name ");
                System.out.println("----------------------------------------");
                System.out.println();
                System.out.println();


                Comparator<Task> project_name_comparator = new Comparator<Task>() {
                    @Override
                    public int compare(Task task1, Task task2) {
                        return task1.getprojectName().compareTo(task2.getprojectName());
                    }
                };

                Collections.sort(tasks, project_name_comparator);

                System.out.printf("%10s %20s %25s %28s ", "Project Name", "Task Name", "Status", "  Due Date ");
                System.out.println();
                System.out.printf("%10s %20s %25s %28s ", "-------------", "---------", "--------", " ---------");
                System.out.println();

                while (index < tasks.size()) {
                    System.out.printf("%10s %20s %25s %30s ", tasks.get(index).getprojectName(), tasks.get(index).getTaskTitle(), tasks.get(index).gettaskStatus(), tasks.get(index).gettaskdueDate());
                    System.out.println();
                    index++;
                }
                break;
            default:
                System.out.println();
                System.out.println("Please specify a valid option");

        }


        System.out.println();
        System.out.println();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        /* Perform various operations based on the user selection */

        while (true) {
            showMenu();
            System.out.println();
            System.out.println();
            System.out.println("Please select from the menu list");
            String menuItem = sc.next();
            switch (menuItem) {
                case "1":
                    showListdisplay();
                    break;

                case "2":
                    add();
                    break;

                case "3":
                    update();
                    break;

                case "4":
                    System.out.println("-------------------------------------------");
                    System.out.println("Save and Quit");
                    System.out.println("-------------------------------------------");
                    task_file_handler.taskwritetofile();
                    System.exit(0);

                default:
                    System.out.println();
                    System.out.println("Please specify a valid number");

            }
        }
    }
}

