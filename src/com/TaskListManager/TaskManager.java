/**
 * Class to handle the Menu and activities for the particular task
 * @author Siminy
 * @version 27-09-2018 version 1
 */


package com.TaskListManager;

import ToDoList.FileHandler;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;


public class TaskManager implements Serializable {

    private FileHandler task_file_handler = new FileHandler();

    private List<Task> tasks;

    /**
     * Loads the existing tasks from the file to List.
     */

    public TaskManager() {
        tasks = task_file_handler.taskloadtoarray();
    }

    /** Method to find out number of tasks with status as "Done"
     * @return done_tasks
     */

    public int myTasks() {
        int done_task = 0;
        for (Task taskcount : tasks)
            if (taskcount.gettaskStatus().equals("Done")) {
                done_task++;
            }
        return done_task;
    }

    /**
     *  Method to display the menu to perform various operations for the tasks
     */
    public void showMenu() {
        int done_task = myTasks();
        System.out.println();
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("                Welcome to ToDoly                        ");
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

    /** Method to obtain the inputs for String type
     * @return scanner object
     */
    public Scanner scanner_string() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    /** Method to obtain the inputs for Integer type
     * @return scanner object
     */
    public Scanner scanner_integer() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    /**
     * Method to display the menu and enable user to select the preferred option from the menu. User can
     * perform various operations for the ToDoList.
     * Option 1 will display all of tasks based on due date or project name
     * Option 2 will allow the user to add a task
     * Option 3 will allow user to edit the task
     * Option 4 will save the tasks to the file and exit from the application
     */

    public void run() {
        while (true) {
            showMenu();
            System.out.println();
            System.out.println();
            System.out.println("Please select from the menu list");
            String menuItem = scanner_string().next();
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
                    saveandexit();

                default:
                    System.out.println();
                    System.out.println();
                    System.out.println("Please specify a valid number");
            }
        }
    }

    /**
     * Function is used to save the tasks to the file and exit from the program
     */

    public void saveandexit() {
        System.out.println("-------------------------------------------");
        System.out.println("Save and Quit");
        System.out.println("-------------------------------------------");
        task_file_handler.taskwritetofile();
        System.out.println();
        System.out.println();
        System.out.println("Saving the tasks to the file");
        System.exit(0);

    }

    /** Update method is used to modify the tasks based on the task number specified by the user.
     * User can perform the update of the tasks , change the task status
     * and delete the task from the list
     */

    public void update() {
        display();
        System.out.println();
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Edit tasks(update, mark as done, remove)");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Enter the Task No to edit: ");
        int taskindex = Integer.parseInt(scanner_integer().next());
        if (taskindex > tasks.size()) {
            System.out.println();
            System.out.println();
            System.out.println("Please specify valid task no");
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
            String task_edit = scanner_string().next();
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
                    System.out.println();
                    System.out.println("Please specify a valid option");
            }
        }
    }

    /** Method is used to modify the tasks based on the task number specified by the user.
     * User can modify the Task Name , Status due date & project name using this function
     * @param task_index
     */

    public void task_edit(int task_index) {
        try {
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String edit_taskname = scanner_string().nextLine();
            System.out.println();
            System.out.println("Enter the due date (yyyy-mm-dd):");
            String new_dueDate = scanner_string().nextLine();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate current_date = LocalDate.now();

            LocalDate edit_task_due_date = LocalDate.parse(new_dueDate, dtf);
            System.out.println();

            if ((edit_task_due_date.compareTo(current_date)) < 0) {
                System.out.println("Due date cannot be less than the current date");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Enter the new Status :");
                String edit_status = scanner_string().nextLine();
                System.out.println();

                System.out.println("Enter the new Project Name  :");
                String edit_projectname = scanner_string().nextLine();

                if (edit_projectname.isEmpty() || edit_status.isEmpty() || new_dueDate.isEmpty() || edit_taskname.isEmpty()) {
                    System.out.println();
                    System.out.println("No valid task details specified , Please specify the task details");
                } else {
                    tasks.get(task_index).setTaskTitle(edit_taskname);
                    tasks.get(task_index).setTaskdueDate(edit_task_due_date);
                    tasks.get(task_index).settaskStatus(edit_status);
                    tasks.get(task_index).setprojectName(edit_projectname);
                    System.out.println();
                    System.out.println();
                    System.out.println("Current Task " + (task_index + 1) + " updated with new values: " + tasks.get(task_index).getTaskTitle() + " " + tasks.get(task_index).gettaskdueDate() + "   " + tasks.get(task_index).gettaskStatus() + "   " + tasks.get(task_index).getprojectName());
                }
            }
        } catch (java.time.format.DateTimeParseException parse_Exception) {
            System.out.println();
            System.out.println();
            System.out.println("Date entered is not in the specified format, please specify in correct yyyy-MM-dd format");
        }
    }

    /** Method is used to modify the status of the task based on the task number specified by the user.
     * @param task_index
     */

    public void task_editstatus(int task_index) {
        System.out.println();
        System.out.println();
        System.out.println("Enter the new Status :");
        String edit_status = scanner_string().nextLine();
        if (edit_status.isEmpty()) {
            System.out.println();
            System.out.println();
            System.out.println("Please specify valid status for the task");
        } else {
            tasks.get(task_index).settaskStatus(edit_status);
            System.out.println();
            System.out.println();
            System.out.println("Current Task  " + (task_index + 1) + "  updated with new status: " + "   " + tasks.get(task_index).gettaskStatus());
        }
    }

    /** Method is used to delete the task based on the task number specified by the user.
     * @param task_index
     */

    public void task_delete(int task_index) {
        System.out.println();
        System.out.println();
        System.out.println("Do you want to delete the task(Y/N):");
        String delete_response = scanner_string().next();
        System.out.println();
        System.out.println();
        if (delete_response.toUpperCase().equals("Y")) {
            tasks.remove(task_index);
            System.out.println("Task " + (task_index + 1) + " is deleted");
        } else {
            System.out.println("Task" + (task_index + 1) + " not deleted");
        }
    }

    /**
     *  Method is is used to add the task to be performed for a particular project. The new task will be added to the list
     */

    public void add() {
        try {
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println(" Add Task");
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String new_taskname = scanner_string().nextLine();
            System.out.println();
            System.out.println("Enter the due date (yyyy-mm-dd):");
            String new_dueDate = scanner_string().nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate current_date = LocalDate.now();
            LocalDate task_due_date = LocalDate.parse(new_dueDate, dtf);
            if ((task_due_date.compareTo(current_date)) < 0) {
                System.out.println("Due date cannot be less than the current date");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Enter the Status :");
                String new_status = scanner_string().nextLine();
                System.out.println();
                System.out.println("Enter the Project Name :");
                String new_projectname = scanner_string().nextLine();
                if ((new_taskname.isEmpty()) || (new_projectname.isEmpty()) || (new_status.isEmpty()) || (new_dueDate.isEmpty())) {
                    System.out.println();
                    System.out.println("No valid task details specified,Please specify the task details");
                } else {
                    tasks.add(new Task(new_taskname, task_due_date, new_status, new_projectname));
                    System.out.println();
                    System.out.println("New task added");
                }
            }
        } catch (java.time.format.DateTimeParseException parse_exception) {
            System.out.println();
            System.out.println("Date entered is not in the specified format, please specify in yyyy-MM-dd format");

        }
    }

    /**
     *  Method will  display all the details associated with the tasks such as -
     *  task no , task name , due date , status & project name will be displayed
     */

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
    }

    /**
     *  Method provides options to display the tasks based on the user preference -
     *  display of tasks based on date or display of tasks based on project name
     */

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
        String display_option = scanner_string().next();
        System.out.println();
        System.out.println();

        switch (display_option) {
            case "1":
                System.out.println("Show task list - Sort by date  ");
                System.out.println("-------------------------------");
                if (tasks.isEmpty()) {
                    System.out.println();
                    System.out.println("No tasks available to be displayed , please proceed to add tasks from the main menu");
                } else {
                    System.out.printf("%10s %20s %25s %25s ", "Due Date", "Task Name", "Status", " Project Name ");
                    System.out.println();
                    System.out.printf("%10s %20s %25s %25s ", "--------", "---------", "--------", "-------------");
                    System.out.println();
                    tasks.sort((Task task1, Task task2) -> task1.gettaskdueDate().compareTo(task2.gettaskdueDate()));
                    tasks.forEach((sorted_list_date) -> System.out.format("%10s %20s %25s %25s %n", sorted_list_date.gettaskdueDate(), sorted_list_date.getTaskTitle(), sorted_list_date.gettaskStatus(), sorted_list_date.getprojectName()));
                }
                break;
            case "2":
                System.out.println("Show task list - Filter by project name ");
                System.out.println("----------------------------------------");
                if (tasks.isEmpty()) {
                    System.out.println();
                    System.out.println("No tasks available to be displayed , please proceed to add tasks from the main menu");

                } else {
                    System.out.println();
                    System.out.println();
                    System.out.printf("%10s %20s %25s %27s ", "Project Name", "Task Name", "Status", "Due Date ");
                    System.out.println();
                    System.out.printf("%10s %20s %25s %27s ", "------------", "---------", "--------", " ---------");
                    System.out.println();
                    tasks.sort((Task task1, Task task2) -> task1.getprojectName().compareTo(task2.getprojectName()));
                    tasks.forEach((sorted_list_project) -> System.out.printf("%10s %20s %25s %28s %n", sorted_list_project.getprojectName(), sorted_list_project.getTaskTitle(), sorted_list_project.gettaskStatus(), sorted_list_project.gettaskdueDate()));
                }
                break;
            default:
                System.out.println();
                System.out.println("Please specify a valid option");
        }
    }
}

