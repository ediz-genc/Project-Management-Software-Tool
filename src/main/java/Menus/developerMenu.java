package Menus;

import Projects.Project;
import Projects.allProjects;
import Tools.InputClass;
import Projects.myTasksInterface;

import java.util.ArrayList;

public class developerMenu {
    static InputClass printOutput = new InputClass();
    static myTasksInterface myTasksInterface = new myTasksInterface();
    static allProjects allprojects = allProjects.getInstance();

    public void menu(){

        int option = 0;
        while (option != 5) {

            printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. View my tasks\n2. Add new task to existing project\n3. Delete/archive project\n4. View Projects\n5. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    myTasksInterface.viewMyTasks();
                    break;
                case 2:
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    break;
                case 4:
                    viewProject();
                    break;
                case 5:
                    return;
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }

    public void viewProject(){

        //Method to be finished (Patricia and Jakob)
        // Verifying the access key to see the project

        ArrayList<Project> projects = allprojects.getAllProjects();

        for (int i = 0; i < projects.size(); i++){
            printOutput.printLine("Name of Project: " + projects.get(i).getProjectName() +"\n" + " Start Date: "+ projects.get(i).getStartDate() +"\n"+
                    "Length of Project: "+ projects.get(i).getWeeks() +"\n" + "Project tasks: " +projects.get(i).getTasks());
        }
    }

}
