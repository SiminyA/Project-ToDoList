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
    private List<Task> tasks = new ArrayList<>();

    /*
     * Function to handle the file operations - write the tasks to the file
     */

    public void taskwritetofile()
    {
        try
        {
            ObjectOutputStream output_stream   = new ObjectOutputStream(new FileOutputStream("/Users/tmp-sda-1189/Documents/SampleTest.txt"));
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

    public List<Task> taskloadtoarray()
    {
        try
        {
            FileInputStream file_input_stream = new FileInputStream("/Users/tmp-sda-1189/Documents/SampleTest.txt");
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

return tasks;

    }




    }



