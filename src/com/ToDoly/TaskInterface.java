/*
 * Class to handle the Menu and associated tasks
 * @author Siminy
 * @version 27-09-2018 version 1 */


package com.ToDoly;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;
import java.time.LocalDate;



public class TaskInterface implements Serializable
{
    private FileHandler task_file_handler = new FileHandler();

    private List<Task> tasks = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private LocalDate current_date =  LocalDate.now();

    public TaskInterface()
    {
       tasks = task_file_handler.taskloadtoarray();
    }

    /* Display the menu options */

    public void myTasks()

    {

    }

    public void showMenu()
    {
        System.out.println("*********************************************************");
        System.out.println("                Welcome to ToDoly.");
        System.out.println("*********************************************************");
        System.out.println("You have " + "X tasks todo and "+ " Y tasks are done!");
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println();
        System.out.println("                      Pick up an option");
        System.out.println("*********************************************************");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task") ;
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("*********************************************************");
    }

    /* Functions to handle the various task functions */


    public void update()
    {

        display();
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("Edit tasks");
        System.out.println("============================================");
        System.out.println();
        System.out.println();
        System.out.println("Enter the Task No to edit: ");
        int taskindex = Integer.parseInt(sc.next());
        if(taskindex==tasks.size())
        {
            taskindex=tasks.size()-1;
        }
        else
        {
            taskindex=taskindex+1;
        }


       /* if (taskindex >tasks.size())
        {

            System.out.println();
            System.out.println("The task doesn't  exist, please add new task");
        }

        else
        {

            System.out.println();
            System.out.println("The task exist, please proceed to edit the task");
        } */

        /*
         * Update the task with the  new details and write the task to the file
         *
         */


        System.out.println();
        System.out.println();
        System.out.println("============================================");
        System.out.println("Edit tasks");
        System.out.println("============================================");
        System.out.println("1.Edit the task");
        System.out.println("2.Edit the task status");
        System.out.println("3.Delete the task");
        System.out.println();
        System.out.println("Select from the options ");
        String task_edit = sc.next();
        System.out.println();
        System.out.println();

            switch (task_edit)
            {
                case "1":
                    System.out.println("Edit tasks");
                    System.out.println("============================================");
                    task_edit(taskindex);
                    break;

                case "2":
                    System.out.println("Edit task status");
                    System.out.println("============================================");
                    task_editstatus(taskindex);
                    break;

                case "3":
                    System.out.println("Delete the task");
                    System.out.println("============================================");
                    task_delete(taskindex);
                    break;
            }
        System.out.println();
        System.out.println();
    }

    private void task_edit (int task_index) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String edit_taskname = sc.nextLine();
            System.out.println();
            System.out.println();
            System.out.println("Enter the due date (yyyy/mm/dd):");
            String new_dueDate = sc.nextLine();
            LocalDate task_due_date = LocalDate.parse(new_dueDate, dtf);
            
           /* if(task_due_date.equals(current_date))
            {
                System.out.println("Due date cannot be less than the current date") ;
                System.out.println();
                System.out.println();
            }
            else
            { */
            System.out.println();
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
            System.out.println("Current Task updated with new values:" + tasks.get(task_index).getTaskTitle() + " " + tasks.get(task_index).gettaskdueDate() + "   " + tasks.get(task_index).gettaskStatus() + "   " + tasks.get(task_index).getprojectName());
            System.out.println();
            System.out.println();
            //}

        } catch (java.time.format.DateTimeParseException parse_Exception) {
            System.out.println();
            System.out.println();

            System.out.println("Date entered is not in the specified format");

        }

        System.out.println();
        System.out.println();
    }


    private void task_editstatus (int task_index)

    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Enter the new Status :");
        String edit_status = sc.nextLine();
        System.out.println();
        tasks.get(task_index).settaskStatus(edit_status);
        System.out.println();
        System.out.println();
        System.out.println("Current Task updated with new status:" + "   "+tasks.get(task_index).gettaskStatus());
        System.out.println();
        System.out.println();


    }

    private void task_delete (int task_index)

    {
        tasks.remove(task_index);
        System.out.println();
        System.out.println();
        System.out.println("Task is deleted");
        System.out.println();
        System.out.println();
    }



    public void add() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("============================================");
            System.out.println("Add Task");
            System.out.println("============================================");
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String new_taskname = sc.nextLine();
            System.out.println();
            System.out.println();
            System.out.println("Enter the due date (yyyy/mm/dd):");
            String new_dueDate = sc.nextLine();
            LocalDate task_due_date = LocalDate.parse(new_dueDate, dtf);
            /*if (task_due_date.before(current_date)) {
                System.out.println("Due date cannot be less than the current date");
                System.out.println();
                System.out.println();
            } else {      */
            //System.out.println("Date Value :"+sdf.format(task_due_date));
            System.out.println();
            System.out.println();
            System.out.println("Enter the Status :");
            String new_status = sc.nextLine();
            System.out.println();
            System.out.println();
            System.out.println("Enter the Project Name :");
            String new_projectname = sc.nextLine();

            tasks.add(new Task(new_taskname, task_due_date, new_status, new_projectname));
            System.out.println();
            System.out.println();
            System.out.println("New task added");
            System.out.println();
            System.out.println();

            // }
        } catch (java.time.format.DateTimeParseException parse_exception) {
            System.out.println();
            System.out.println();

            System.out.println("Date entered is not in the specified format");

        }
        System.out.println();
        System.out.println();
    }

    public void display()

    {
        int index = 0;
        System.out.println("       Task No            Task Name       " + "        Due Date                   Status         " + "            Project Name             ");
        System.out.println("      --------         -------------             -----------               -------------                -------------         ");

        while(index<tasks.size())

        {
            System.out.format("%10d %20s %27s %25s %28s", index+1,tasks.get(index).getTaskTitle(), tasks.get(index).gettaskdueDate(),tasks.get(index).gettaskStatus(), tasks.get(index).getprojectName());
            System.out.println();
            index++;
        }
        System.out.println();
        System.out.println();
    }

    public void run()
    {
        Scanner sc = new Scanner(System.in);

        /* Perform various operations based on the user selection */

        while(true)
        {
            showMenu();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Please select from the menu list");
            String menuItem = sc.next();
            System.out.println();
            System.out.println();
            switch(menuItem)
            {
                case "1": System.out.println("                Show Task List                         ");
                    System.out.println("                ----------------");
                    display();
                    break;

                case "2": System.out.println("                 Add New Task");
                    System.out.println("                 ---------------");

                    add();
                    break;

                case "3": System.out.println("        Edit Task (update, mark as done, remove)");
                    System.out.println("         -----------------------------------------");

                    update();
                    break;

                case "4": System.out.println("                Save and Quit ");
                    System.out.println("               ------------------");

                    task_file_handler.taskwritetofile();
                    System.exit(0);

                default :
                    System.out.println();
                    System.out.println("Please specify a valid number");

            }
        }
    }
}

