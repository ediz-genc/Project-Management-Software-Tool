package Menus;

import Tools.InputClass;
import Projects.Project;
import Users.Member;
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
    static Member member = new Member();
    ArrayList<Member> allMembers = addedmember.getAllMembers();

    public void menu() {

        int option = 0;

        while (option != 6) {

            printOutput.printLine("\nWelcome!\n\nHere you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Assign task to user \n3. Create new Project\n4. Delete/archive project\n5. Allow users to see projects\n6. Return to main menu\n");
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
                    allowUserToSeeProject();
                    break;
                case 6:
                    return;
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }

    void newProject() {

        String projectName = printOutput.readLine("Project name: ");
        String projectDescription = printOutput.readLine("Enter a short description of the project you want to create: ");

        String startDate = printOutput.readLine("Enter the start date of the project (yyyy-MM-dd): ");
        String endDate = printOutput.readLine("Enter the end date of the project (yyyy-MM-dd): ");

        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        String option;
        String taskDescription;
        String milestones;
        ArrayList<Projects.task> tasks = project.getTasks();
        do {
            milestones = printOutput.readLine("Enter the description of the milestones: ");
            taskDescription = printOutput.readLine("Enter the description of the task: ");
            Projects.task task = new Projects.task(milestones, taskDescription);
            tasks.add(task);

            option = printOutput.readLine("Do you want to enter more tasks to your milestone? (y/n): ");
        }while (option.equals("y"));

        int managerKey = 2;

        String tempUser = addedmember.getActiveUser();
        int key = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName,weeks, milestones, taskDescription, key,managerKey, startDate, endDate,tasks, projectDescription);
        allprojects.addProject(newProject);
    }

    void openProject(){

    }

    public void viewUsers(){

        //Method to be finished (Patricia and Jakob)

        for (int i = 0; i < allMembers.size(); i++){
            printOutput.printLine("Name of the User: " +allMembers.get(i).getName()+ "\n" + "User ID: " +allMembers.get(i).getUsername() + "\n"+ "User Key: "+allMembers.get(i).getMemberKey()+"\n"+
                    "Use Access to see project: "+ allMembers.get(i).getGrantedAccess());
        }
    }

    public void allowUserToSeeProject (){

        //Method to be finished (Patricia and Jakob)
        //Choose which user can see the project and allow access to the user
        viewUsers();

        String select;

        do {

            int selectedUser = printOutput.readInt("Select the User's key that will have access to see the project: ");

            for (int j = 0; j < allMembers.size(); j++) {
                if (selectedUser == allMembers.get(j).getMemberKey()) {
                    allMembers.get(j).setGrantedAccess("Access granted");
                }
            }
            select = printOutput.readLine("Do you want to give access to another user to see the project? (yes/no) ");

        }while (select.equals("yes"));
    }
}
