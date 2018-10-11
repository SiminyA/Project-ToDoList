# Project-ToDoList

## 1. Project Objective 

#####  Build a ToDoList application​ - ToDoLy which enable the user to organise the day to day tasks based on the the specific project

## 2. Product Features

##### ToDoList application is text based UI application that will enable the user to manage tasks.

##### The application will allow the user to perform the following operations
##### 2.1. Add new tasks 
##### User can add a specific task that has to be performed. User will specify details such as 
##### task title, status , due date & project name to create the task.
##### 2.2 Edit the task 
##### User can modify the tasks that are already created. User can update the all the details of the existing tasks - Task Title, due date , Status , Project name . User can also just update the status of the project alone. User is also provided with the provision of deleting the particular task 
##### 2.3 Display tasks
##### User can view the tasks based on the date or on based on project name
##### 2.4 Save and Quit
##### The user can save all the tasks  and quit from the application

##### All the tasks added will be saved in the text file. 
##### Each time the application launches, the existing task details are read from the file and the necessary operations can be performed.


## 3. Functional Requirements
##### This section includes the requirements that specify all the fundamental actions of the software system.

#### 3.2 Key Functional requirements

##### 3.2.1 ID: FR1
##### Title:  Interactive User Text based menu
##### Description: In this feature an interactive text based menu will be created
##### The user : User will be displayed with an interactive menu as shown below 

<img width="447" alt="mainmenu" src="https://user-images.githubusercontent.com/29890115/46719535-f9ff1b80-cc22-11e8-8e03-cdbf0c3dd7ee.png">

##### User will be displayed with the tasks to be done and tasks already done from the existing tasks.

##### 3.2.2 ID: FR2
##### Title:  Show Task List
##### Description: In this feature , tasks can be displayed based on the sort criteria. 
##### The user : User on selecting the Show task list will be displayed with interactive menu to select the sort criteria - sort by due date or sort by project name

##### 3.2.2 ID: FR3
##### Title:  Add New task
##### Description: In this feature, it is described the procedure of creating a new task, completing task’s fields and adding the task to a project
##### The user : User will select the Add new task option and on selection user will be prompted to specify the Task title, Due date , status and project name. On specifying the details , new task will be created 

#### 3.2.2 ID: FR4
##### Title:  Edit task
##### Description: In this feature, it is explained the procedure of editing an existing task and its fields.
##### The user : User will select the Edit task option. On selection user will be displayed with the existing task with taskno and all the necessary details
##### User will provide the task number which has to be modified. If the task exist , the user will be Edit menu which provides the option
##### - Update the task , Mark task as Done and Delete the task. 
##### On selecting 'Update the task', User will be prompted to enter new values for task title, due date , Status and Project name.
##### User can modify the status of the task by selecting 'Mark as Done' , for the task no specified
##### User prompted with confirmation to proceed with the deletion of the specific task number provided

##### 3.2.2 ID: FR5
##### Title:  Save and Exit
##### Description: In this feature, it is described the procedure of saving the tasks to the file and exit from the application
##### The user : User will save the tasks created/updated to the file and will exit from the application

##  4.Analysis Models

##### 3.1 Class Diagram

<img width="998" alt="class diagram todoly v0 1" src="https://user-images.githubusercontent.com/29890115/46829837-c7087500-cd53-11e8-99d8-3d73bf7b4035.png">



##### 3.2 Activity Diagram

<img width="718" alt="activity diagram 1" src="https://user-images.githubusercontent.com/29890115/46829924-0a62e380-cd54-11e8-92c5-deb774ff7d8b.png">


<img width="327" alt="activity diagram contd 3" src="https://user-images.githubusercontent.com/29890115/46829968-236b9480-cd54-11e8-9488-0d3b546f6dca.png">


<img width="1085" alt="activity diagram contd 2" src="https://user-images.githubusercontent.com/29890115/46829967-236b9480-cd54-11e8-9493-50e78324fffb.png">











