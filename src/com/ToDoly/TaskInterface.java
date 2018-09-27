package com.ToDoly;

import java.util.*;

public class TaskInterface
{
    FileHandler task_file_handler = new FileHandler();

    public TaskInterface()
    {
    }
    public void showMenu()
    {
        System.out.println("*********************************************************");
        System.out.println("                Welcome to ToDoly.");
        System.out.println("*********************************************************");
        System.out.println("You have " + "X tasks todo and "+ " Y tasks are done!");
        System.out.println(" *********************************************************");
        System.out.println();
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
    public void update()
    {
        task_file_handler.updateTask();
    }
    public void add()
    {
        task_file_handler.addTask();
    }
    public void display()
    {
        task_file_handler.displaytask();
    }
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            showMenu();
            System.out.println();
            System.out.println();
            System.out.println("Please select from the menu list");
            String menuItem = sc.next();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            switch(menuItem)
            {
                case "1": System.out.println("Show Task List");
                    System.out.println("-----------------------------------------------------------");
                    display();
                    break;

                case "2": System.out.println("Add New Task");
                    System.out.println("-----------------------------------------------------------");

                    add();
                    break;

                case "3": System.out.println("Edit Task (update, mark as done, remove)");
                    System.out.println("-----------------------------------------------------------");

                    update();
                    break;

                case "4": System.out.println("Save and Quit ");
                    System.out.println("-----------------------------------------------------------");

                    System.exit(0);

                default :
                    System.out.println();
                    System.out.println("Please specify a valid number");

            }
        }
    }
}

