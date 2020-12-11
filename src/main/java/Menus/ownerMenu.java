package Menus;

import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;
import Projects.assignTaskInterface;

import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static Project project = new Project();
    static assignTaskInterface newTask = new assignTaskInterface();



    public void menu() {

        int option = 0;

        while (option != 4) {

            printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Assign task to user \n3.Create new Project\n4. Delete/archive project\n5. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    break;
                case 2:
                    newTask.assignTask();
                    printOutput.printLine("to be continued...");
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    newProject();
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }

    void newProject() {

//      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String projectName = printOutput.readLine("Project name: ");

        String startDate = printOutput.readLine("Enter the start date of the project (yyyy-MM-dd): ");
        String endDate = printOutput.readLine("Enter the end date of the project (yyyy-MM-dd): ");

        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        String selection;

        /*do {
            String memberName = printOutput.printLine("Type team member's name: ");
            addedmember.setMemberName(memberName);
            printOutput.readLine("");
            String memberRole = printOutput.printLine("Type team member's role: ");
            addedmember.setMemberRole(memberRole);
            printOutput.readLine("");
            selection = printOutput.readLine("Would you like to add more team members?(y/n): ");
        } while (selection.equals("y"));*/

        String option;
        String taskDescription;
        String milestones;
        ArrayList<Projects.task> tasks = project.getTasks();
        do {
            milestones = printOutput.readLine("Enter the milestones in the project?: ");
            taskDescription = printOutput.readLine("Enter the description of the Projects.task: ");
            Projects.task task = new Projects.task(milestones, taskDescription);
            tasks.add(task);

            option = printOutput.readLine("Do you want to enter more tasks to your project? (y/n): ");
        }while (option.equals("y"));

        String tempUser = addedmember.getActiveUser();
        int key = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName,weeks, milestones, taskDescription, key, startDate, endDate,tasks);
        allprojects.addProject(newProject);
    }

    void openProject(){

    }
}
