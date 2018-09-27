/*
 * Task class to handle the task related activities
 * @author Siminy
 * @version 27-09-2018 version 1
 * */


package com.ToDoly;
import java.util.*;

import java.io.*;

public class FileHandler implements Serializable
{
    List<Task> tasks = new ArrayList<>();

    /*
     * Function to handle the file operations - write the tasks to the file
     */

    public void taskfilewrite()
    {
        try
        {
            ObjectOutputStream output_stream   = new ObjectOutputStream(new FileOutputStream("/Users/tmp-sda-1189/Documents/Check.txt"));
            for (Task tsk : tasks)
            {
                output_stream.writeObject(tsk);

            }
            output_stream.flush();

        }


        catch(EOFException eof_exception)
        {
            System.out.println("No tasks to be displayed");
        }

        catch(FileNotFoundException fnf_Exception)
        {
            System.out.println("The file is not available to read the data");
        }

        catch(IOException io_exception)
        {
            System.out.println("Unexpected error");
            io_exception.printStackTrace();
        }

    }

    /*
     * Function to handle the file operations - read the file and load the tasks to the List
     */

    public void taskloadtoarray()
    {
        try
        {
            FileInputStream file_input_stream = new FileInputStream("/Users/tmp-sda-1189/Documents/Check.txt");
            ObjectInputStream input_stream = new ObjectInputStream(file_input_stream);
            Object obj = null;
            while(file_input_stream.available()>0)
            {
                obj = input_stream.readObject();

                Task readtask = (Task) obj;
                tasks.add(readtask);
            }
        }
        catch(ClassNotFoundException cnf_exception)
        {
            System.out.println("The class not found");
        }
        catch(EOFException eof_exception)
        {
            System.out.println("No tasks to be displayed");
        }

        catch(FileNotFoundException fnf_Exception)
        {
            System.out.println("The file is not available to read the data");
        }

        catch(IOException io_exception)
        {
            System.out.println("Unexpected error");
            io_exception.printStackTrace();
        }



    }
    /*
     * Function to update the particular task with the new details
     */

    public void updateTask()
    {


        Scanner sc = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("        Edit Task"      );
        System.out.println("**********************");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Enter the Task Name to edit:    ");
        String taskname = sc.next();
        int index = 0;
        int taskindex=0;

        while(index<tasks.size())
        {
            if (tasks.get(index).getTaskTitle().equals(taskname))
            {
                taskindex=index;
            }

            index++;
        }
        if(taskindex == 0)
        {

            System.out.println();
            System.out.println("The task doesnot on exist, please add new task");
        }
        else
        {

            System.out.println();
            System.out.println("The task exist, please proceed to edit the task");
        }

        /*
         * Update the task with the  new details and write the task to the file
         *
         */

        if(taskindex>0)
        {
            System.out.println();
            System.out.println("      Current task to be edited ");
            System.out.println("       Task Name          " + "        Status         " + "            Project Name             ");
            System.out.println("      -------------              -----------                 -------------    ");
            System.out.format("%15s %25s %30s",tasks.get(taskindex).getTaskTitle(),tasks.get(taskindex).gettaskStatus(),tasks.get(taskindex).getprojectName());
            System.out.println();
            System.out.println();
            System.out.println("============================================");
            System.out.println("Edit tasks");
            System.out.println("============================================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Task Name :");
            String edit_taskname = sc.next();
            System.out.println();
            System.out.println();
            System.out.println("Enter the new Status :");
            String edit_status = sc.next();
            System.out.println();
            System.out.println("Enter the new Project Name  :");
            String edit_projectname = sc.next();
            tasks.get(taskindex).setTaskTitle(edit_taskname);
            tasks.get(taskindex).settaskStatus(edit_status);
            tasks.get(taskindex).setprojectName(edit_projectname);
            System.out.println();
            System.out.println();
            System.out.println("Current Task updated with new values:" +tasks.get(taskindex).getTaskTitle()+ "   "+tasks.get(taskindex).gettaskStatus()+"   "+tasks.get(taskindex).getprojectName());
        }
        taskfilewrite();
        System.out.println();

    }

    /*
     * Function to add a new task and write the task to the file
     */

    public void addTask()
    {
        // Load all the tasks existing and then write all the tasks together
        tasks.clear();
        taskloadtoarray();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("============================================");
        System.out.println("Add Task");
        System.out.println("============================================");
        System.out.println();
        System.out.println();
        System.out.println("Enter the new Task Name :");
        String taskname = sc.next();
        System.out.println();
        System.out.println();
        System.out.println("Enter the Status :");
        String status = sc.next();
        System.out.println();
        System.out.println();
        System.out.println("Enter the Project Name :");
        String projectname = sc.next();

        tasks.add(new Task(taskname,status,projectname));

        taskfilewrite();
        System.out.println("New task added");

    }

    /*
     * Function to display the tasks from the file
     */

    public void displaytask()
    {

        try
        {
            FileInputStream file_input_stream = new FileInputStream("/Users/tmp-sda-1189/Documents/Check.txt");
            ObjectInputStream input_stream = new ObjectInputStream(file_input_stream);
            Object obj = null;
            System.out.println("       Task Name          " + "        Status         " + "            Project Name             ");
            System.out.println("      -------------              -----------                 -------------    ");
            while(file_input_stream.available()>0)
            {
                obj = input_stream.readObject();
                Task readtask = (Task) obj;
                System.out.format("%15s %25s %30s",readtask.getTaskTitle(),readtask.gettaskStatus(),readtask.getprojectName());
                System.out.println();
            }
        }

        catch(ClassNotFoundException cnf_exception)
        {
            System.out.println("The class not found");
        }
        catch(EOFException eof_exception)
        {
            System.out.println("No tasks to be displayed");
        }

        catch(FileNotFoundException fnf_Exception)
        {
            System.out.println("The file is not available to read the data");
        }

        catch(IOException io_exception)
        {
            System.out.println("Unexpected error");
            io_exception.printStackTrace();
        }

        System.out.println();

    }

}

