/*
 * Task class hold the details of the specific details associated with the Task
 * @author Siminy
 * @version 27-09-2018 version 1 */


package com.ToDoly;

import java.io.Serializable;
import java.time.LocalDate;

//, Comparable<Task>

public class Task implements Serializable {
    /* Attributes for the task - title, duedate,taskstatus,projectname */

    private String taskTitle;
    private LocalDate dueDate;
    private String taskStatus;
    private String projectName;

    /* Constructor created with parameters - title,dueDate, taskstatus, projectname */


    Task(String taskTitle, LocalDate dueDate, String taskStatus, String projectName) {
        this.taskTitle = taskTitle.trim();
        this.dueDate = dueDate;
        this.taskStatus = taskStatus.trim();
        this.projectName = projectName.trim();


    }

    /* Mutator methods for setting the title,dueDate, taskstatus,projectname */

    public void setTaskdueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void settaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskTitle() {
        return taskTitle;
    }



    /* Accessor methods for accessing the title,dueDate,taskstatus,projectname */

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public LocalDate gettaskdueDate() {
        return dueDate;
    }

    public String gettaskStatus() {
        return taskStatus;
    }

    public String getprojectName() {
        return projectName;
    }


}




