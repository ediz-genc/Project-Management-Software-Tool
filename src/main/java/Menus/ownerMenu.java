package Menus;

import Projects.Project;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;
import Mainclasses.startApp;

import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static Project projects = new Project();

    public void menu() {
        int option = 0;

        while (option != 4) {

            printOutput.printLine("Welcome!\n\nHere you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Create new Project\n3. Delete/archive project\n4. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    break;
                case 2:
                    newProject();
                    printOutput.printLine("to be continued...");
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    break;
                case 4:
                    returnedMenu.run();
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }
    void newProject() {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String projectName = printOutput.readLine("Project name: ");

        String startDate = printOutput.readLine("Enter the start date of the project (yyyy-MM-dd): ");
        String endDate = printOutput.readLine("Enter the end date of the project (yyyy-MM-dd): ");

        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        String select;
        String taskDescription;
        String milestones;
        ArrayList<Projects.task> tasks = projects.getTasks();
        do {
            milestones = printOutput.readLine("Enter the description of the milestones in the project?: ");
            taskDescription = printOutput.readLine("Enter the description of the task: ");
            Projects.task task = new Projects.task(milestones, taskDescription);
            tasks.add(task);

            select = printOutput.readLine("Would you like to add more tasks to your project? (y/n): ");
        } while (select.equals("y"));

        int managerKey=0;

        int option = printOutput.readInt("Would you like to assign a project manager? Enter '1' if yes and '2' if no.\n");
        if(option==1){ managerKey = printOutput.readInt("Please enter Managers Key?"); }

        String tempUser = addedmember.getActiveUser();
        int ownerKey = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName,weeks, milestones, taskDescription, ownerKey, managerKey, startDate,endDate, tasks);
        allprojects.addProject(newProject);
    }
    void openProject(){

    }
}
