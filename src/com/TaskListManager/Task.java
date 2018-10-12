/**
 * Task class represents task for a ToDoList application .
 * Task object store all the details associated with the Task including task ttile, due date, status and project name
 *
 * @author Siminy
 * @version 27-09-2018 version 1
 */


package com.TaskListManager;

import java.io.Serializable;
import java.time.LocalDate;


public class Task implements Serializable {

    /** Attributes for the task - title, duedate,taskstatus,projectname */

    private String taskTitle;
    private LocalDate dueDate;
    private String taskStatus;
    private String projectName;


    /** Constructor created with parameters - creates a new Task item
     * @param taskTitle
     * @param dueDate
     * @param taskStatus
     * @param projectName
     */

   public Task(String taskTitle, LocalDate dueDate, String taskStatus, String projectName) {
        this.taskTitle = taskTitle.trim();
        this.dueDate = dueDate;
        this.taskStatus = taskStatus.trim();
        this.projectName = projectName.trim();
    }

    /** Method to set the task title
     * @param taskTitle
     */

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /** Method to set the duedate
     * @param dueDate
     */

    public void setTaskdueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    /** Method to set the task Status
     * @param taskStatus
     */

    public void settaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }


    /** Method to set the project name
     * @param projectName
     */

    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }


    /** Method to return the title of the task
     * @return taskTitle
     */

    public String getTaskTitle() {
        return taskTitle;
    }


    /** Method to return the due date of the task
     * @return dueDate
     */

    public LocalDate gettaskdueDate() {
        return dueDate;
    }


    /** Method to return the status of the task
     * @return taskStatus
     */

    public String gettaskStatus() {
        return taskStatus;
    }


    /** Method to return the project name associated with the task
     * @return projectName
     */

    public String getprojectName() {
        return projectName;
    }


}




