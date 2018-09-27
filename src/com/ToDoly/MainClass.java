package com.ToDoly;

public class MainClass
{
    public static void main(String  args[])
    {
        for (int i=0; i<=10; i++)
            System.out.print("\n");
        TaskInterface task_interface = new TaskInterface();
        task_interface.run();
    }
}

