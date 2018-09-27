/*
 * Task class hold the details of the specific details associated with the Task
 * @author Siminy
 * @version 27-09-2018 version 1 */




package com.ToDoly;

import java.io.Serializable;


public class Task implements Serializable
{
    /* Attributes for the task - title, duedate,taskstatus,projectname */

    private String taskTitle;
    //private Date dueDate;  --- not implemented
    private String taskStatus;
    private String projectName;

    /* Constructor created with parameters - title,taskstatus,projectname */


    Task(String taskTitle,String taskStatus,String projectName )
    {
        if(taskTitle ==null)
        {
            taskTitle ="";
        }
        if(taskStatus ==null)
        {
            taskStatus ="";
        }
        if(projectName ==null)
        {
            projectName ="";
        }
        this.taskTitle=taskTitle.trim();
        //this.dueDate=dueDate;
        this.taskStatus=taskStatus.trim();
        this.projectName=projectName.trim();

        if(this.taskTitle.isEmpty() && this.taskStatus.isEmpty() && this.projectName.isEmpty())

        {
            throw new IllegalStateException("The task list cannot be empty");
        }
    }

    /* Mutator methods for setting the title,taskstatus,projectname */

    public void setTaskTitle(String taskTitle)
    {
        this.taskTitle = taskTitle;
    }

    public void settaskStatus(String taskStatus)
    {
        this.taskStatus = taskStatus;
    }

    public void setprojectName(String projectName)
    {
        this.projectName = projectName;
    }



    /* Accessor methods for accessing the title,taskstatus,projectname */

    public String getTaskTitle()
    {
        return taskTitle;
    }

    public String gettaskStatus()
    {
        return taskStatus ;
    }

    public String getprojectName()
    {
        return projectName ;
    }

}

/*
Functionality yet to be implemented
**************************************
* public Date getdueDate()
* {
* return dueDate ;
* }
* public void setdueDate(Date dueDate)
* {
* this.dueDate = dueDate;
* }
*/


