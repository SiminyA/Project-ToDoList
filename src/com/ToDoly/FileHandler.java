package com.ToDoly;
import java.util.*;

import java.io.*;

public class FileHandler
{
    List<Task> tasks = new ArrayList<>();

    public void taskfilewrite()
    {
        try
        {s
            ObjectOutputStream output_stream   = new ObjectOutputStream(new FileOutputStream("/Users/tmp-sda-1189/Desktop/Project-ToDoList/src/com/ToDoly/Sample.txt"));
            for (Task tsk : tasks)
            {
                output_stream.writeObject(tsk);
                System.out.println("Logic check in writefile");
                System.out.println(tsk.getTaskTitle());
            }
            output_stream.flush();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void taskloadtoarray()
    {
        try
        {
            FileInputStream file_input_stream = new FileInputStream("/Users/tmp-sda-1189/Desktop/Project-ToDoList/src/com/ToDoly/Sample.txt");
            ObjectInputStream input_stream = new ObjectInputStream(file_input_stream);
            Object obj = null;
            while(file_input_stream.available()>0)
            {
                obj = input_stream.readObject();

                Task readtask = (Task) obj;
                tasks.add(readtask);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("task size :"+tasks.size());
    }


    public void updateTask()
    {
        //taskloadtoarray();
        System.out.println("Size: "+tasks.size());
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("Edit Task");
        System.out.println("**********************");
        System.out.println("Enter the Task Name to edit:");
        String taskname = sc.next();
        int index = 0;
        int taskindex=0;

        while(index<tasks.size())
        {
            if (tasks.get(index).getTaskTitle().equals(taskname))
            {
                System.out.println("The task exist");
                taskindex=index;
            }
            else
            {
                System.out.println("The task doesnot on exist, please add new task");
            }
            index++;
        }
        if(taskindex>0)
        {
            System.out.println("=====================");
            System.out.println("Add New Task");
            System.out.println("=====================");
            System.out.println("Task Name :");
            String edit_taskname = sc.next();
            System.out.println("Status :");
            String edit_status = sc.next();
            System.out.println("Project :");
            String edit_projectname = sc.next();
            tasks.get(taskindex).setTaskTitle(edit_taskname);
            tasks.get(taskindex).settaskStatus(edit_status);
            tasks.get(taskindex).setprojectName(edit_projectname);
            System.out.println("Task updated with new values:" +tasks.get(taskindex).getTaskTitle()+tasks.get(taskindex).gettaskStatus()+tasks.get(taskindex).getprojectName());
        }
        taskfilewrite();
    }

    public void addTask()
    {
        // Load all the tasks existing and then write all the tasks together
        tasks.clear();
        taskloadtoarray();
        Scanner sc = new Scanner(System.in);

        //    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
        //    Date date = sdf.parse(input);
        System.out.println("=====================");
        System.out.println("Add New Task");
        System.out.println("=====================");
        System.out.println("Task Name :");
        String taskname = sc.next();
        System.out.println("Status :");
        String status = sc.next();
        System.out.println("Project :");
        String projectname = sc.next();

        tasks.add(new Task(taskname,status,projectname));
        System.out.println("Logic check:"+tasks.size());


        taskfilewrite();
    }


    public void displaytask()
    {

        try
        {
            FileInputStream file_input_stream = new FileInputStream("/Users/tmp-sda-1189/Desktop/Project-ToDoList/src/com/ToDoly/Sample.txt");
            ObjectInputStream input_stream = new ObjectInputStream(file_input_stream);
            Object obj = null;
            while(file_input_stream.available()>0)
            {
                obj = input_stream.readObject();
                Task readtask = (Task) obj;
                System.out.println(readtask.getTaskTitle()+" "+readtask.gettaskStatus()+" "+readtask.getprojectName());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //for(int index = 0;index<tasks.size();index++)
        //{

        //}
        //  System.out.println("Sorted based on Project Name");
        // System.out.println("******************************");
        // Collections.sort(tasks,new TaskComparator());
        // System.out.println(tasks);
    }

}
