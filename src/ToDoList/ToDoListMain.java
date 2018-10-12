package ToDoList;
/** Class to launch the task menu interface
 *  @author Siminy
 * version 27-09-2018 version 1
 */


import com.TaskListManager.TaskManager;

public class ToDoListMain {
    public static void main(String args[]) {
        TaskManager task_interface = new TaskManager();
        task_interface.run();
    }
}


