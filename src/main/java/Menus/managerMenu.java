package Menus;

import Projects.Project;
import Projects.allProjects;
import Tools.InputClass;

import java.util.ArrayList;

public class managerMenu {
    static InputClass printOutput = new InputClass();
    static Project project = new Project();
    static allProjects allprojects = allProjects.getInstance();

    public void menu(){

        int option = 0;
        while (option != 4) {

            printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Add new task to existing project\n3. Delete/archive project\n4. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    break;
                case 2:
                    addTasks();
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    break;
                case 4:
                    return;
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }
    public void addTasks(){

        String projectName = printOutput.readLine("Which project do you want to add a task to?");
        ArrayList<Projects.Project> searchList= allprojects.getAllProjects();
        ArrayList<Projects.task> updatedTasks;
        int position;
        String option;
        for(int i = 0; i < searchList.size();i++){
            if(searchList.get(i).getProjectName() != null && searchList.get(i).getProjectName().equals(projectName)){
                position = i;
                updatedTasks = searchList.get(position).getTasks();
                do {
                    String milestones = printOutput.readLine("Enter the milestones in the project?: ");
                    String taskDescription = printOutput.readLine("Enter the description of the Projects.task: ");
                    Projects.task task = new Projects.task(milestones, taskDescription);
                    updatedTasks.add(task);

                    option = printOutput.readLine("Do you want to enter more tasks to your project? (y/n): ");
                }while (option.equals("y"));
            }
            else{
                printOutput.printLine("Project not found");
                return;
            }
        }
    }
    }


