package Menus;

import Projects.*;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Mainclasses.startApp;
import Users.allMessages;
import org.springframework.scheduling.config.Task;
import Projects.assignedTask;

import java.util.ArrayList;

public class managerMenu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static Project projects = new Project();
    static allMessages AllMessages = allMessages.getInstance();
    static ownerMenu OwnerMenu = new ownerMenu();


    public void menu(){


        Project project = (Project) getProject();
        int option = 0;


        while(option !=3) {
            printOutput.printLine("\nWelcome to the Manager Menu! Take care of your Team well.");
            option = printOutput.readInt("\n1. Open assigned projects\n2. Explore Projects\n3. Add tasks to an existing project \n4. Edit Project\n5. View project progress\n6. Send a message.\n7. See my inbox.\n8. Log out.\n");

            switch (option) {
                case 1:
                    menuDirectory(option);
                    break;
                case 2:
                    menuDirectory(option);
                    break;
                case 3:
                    OwnerMenu.addTasksToProject();
                    break;
                case 4:
                    editProject(project);
                    break;
                case 5:
                    viewProjectProgress();
                    break;
                case 6:
                    AllMessages.sendMessage();
                    break;
                case 7:
                    AllMessages.readMessage();
                    break;
                case 8:
                    returnedMenu.run();
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }

    void menuDirectory(int caseNumber){

        switch(caseNumber){

            case 1:
                String activeUser = addedmembers.getActiveUser();
                int managerKey = addedmembers.getUserKey(activeUser);
                Object Project = allprojects.getManagerProject(managerKey);
                openProject((Projects.Project) Project);
                break;
            case 2:
                break;
        }
    }

    void openProject(Project Project){
    }

    public void editProject(Project projects){

        String editChoice;
        do{
            editChoice = printOutput.readLine("Would you like to edit the project?(y/n)");
            if (editChoice.equals("y")){
                System.out.println();
                System.out.println("[N]ame of the project");
                System.out.println("[P]roject's short description");
                System.out.println("[S]tart Date");
                System.out.println("[E]nd Date");
                System.out.println("[A]mount of weeks");
                System.out.println("[M]ilestone description");
                System.out.println("[T]ask description");
                System.out.println();
                char editSelection = printOutput.readChar("What would you would like to edit in the project?");
                editSelection = Character.toUpperCase(editSelection);

                switch(editSelection){
                    case 'N' -> editNameOfProject(allprojects.getAllProjects());
                    case 'P' -> editShortDescription(allprojects.getAllProjects());
                    case 'S' -> editStartDate(allprojects.getAllProjects());
                    case 'E' -> editEndDate(allprojects.getAllProjects());
                    case 'A' -> editWeeks(allprojects.getAllProjects());
                    case 'M' -> editMilestoneDescription(allprojects.getAllProjects());
                    case 'T' -> editTaskDescription(allprojects.getAllProjects());
                    default ->  System.out.println("Invalid input. Please try again!");
                }
            }else{
                break;
            }
        }while(editChoice == "y");
        System.out.println();
    }

    public void editNameOfProject (ArrayList<Project> allProjects){

        for (Project project : allProjects) {
            String oldName = printOutput.readLine("What is the project name you would like to edit?: ");
            printOutput.printLine("Project name to be edited is \"" + ANSI_GREEN + projects.getProjectName() + ANSI_RESET + "\"");
            if (project.getProjectName().equals(oldName)) {
                String newName = printOutput.readLine("Please type the new name of the project: ");
                project.setProjectName(newName);
                System.out.println("Name of the project edited successfully.");
                break;
            }else{
                System.out.println("Invalid input. Please type it correctly!");
            }
        }
    }

    public void editShortDescription (ArrayList<Project> allProjects){

        for (Project project : allProjects) {
            String oldShortDescription = printOutput.readLine("Type few words of project's short description to identify!: ");
            printOutput.printLine("Identified project's short description to be edited is \"" + ANSI_GREEN + projects.getShortDescription() + ANSI_RESET + "\"");
            if (project.getShortDescription().contains(oldShortDescription)) {
                String newShortDescription = printOutput.readLine("Please type the new short description of the project: ");
                project.setShortDescription(newShortDescription);
                System.out.println("Short description of the project edited successfully.");
                break;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public void editStartDate(ArrayList<Project> allProjects){

        for (Project project : allProjects) {
            String oldStartDate = printOutput.readLine("What is the project's start date(yyyy-mm-dd) you would like to edit?: ");
            printOutput.printLine("Project's start date to be edited is \"" + ANSI_GREEN + projects.getStartDate() + ANSI_RESET + "\"");
            if (project.getStartDate().equals(oldStartDate)) {
                String newStartDate = printOutput.readLine("Please type the new start date of the project: ");
                project.setStartDate(newStartDate);
                System.out.println("Start date of the project edited successfully.");
                break;
            }else{
                System.out.println("Invalid input. Please type it correctly (yyyy-mm-dd)!");
            }
        }
    }

    public void editEndDate(ArrayList<Project> allProjects){
        for (Project project : allProjects) {
            String oldEndDate = printOutput.readLine("What is the project end date(yyyy-mm-dd) you would like to edit?: ");
            printOutput.printLine("Project's end date to be edited is \"" + ANSI_GREEN + projects.getEndDate() + ANSI_RESET + "\"");
            if (project.getEndDate().equals(oldEndDate)) {
                String newEndDate = printOutput.readLine("Please type the new end date of the project: ");
                project.setEndDate(newEndDate);
                System.out.println("End date of the project edited successfully.");
                break;
            }else{
                System.out.println("Invalid input. Please type it correctly (yyyy-mm-dd)!");
            }
        }
    }

    public void editWeeks(ArrayList<Project> allProjects){
        for (Project project : allProjects) {
            int oldWeeks = printOutput.readInt("What is the project's amount of the weeks you would like to edit?: ");
            printOutput.printLine("Project's amount of the weeks to be edited is \"" + ANSI_GREEN + projects.getWeeks() + ANSI_RESET + "\"");
            if (project.getWeeks() == oldWeeks) {
                int newWeeks = printOutput.readInt("Please type the new project's amount of the weeks: ");
                project.setWeeks(newWeeks);
                System.out.println("Project's amount of the weeks edited successfully.");
                break;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public void editMilestoneDescription(ArrayList<Project> allProjects) {
        for (Project project : allProjects) {
            String oldMilestoneDescription = printOutput.readLine("Type few words of milestone description to identify!: ");
            printOutput.printLine("Identified project's milestone description to be edited is \"" + ANSI_GREEN + projects.getMilestoneDescription() + ANSI_RESET + "\"");
            if (project.getMilestoneDescription().contains(oldMilestoneDescription)) {
                String newMilestoneDescription = printOutput.readLine("Please type the new project's milestone description: ");
                project.setMilestoneDescription(newMilestoneDescription);
                System.out.println("Project's milestone description edited successfully.");
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public void editTaskDescription(ArrayList<Project> allProjects){
        for (Project project : allProjects) {
            String oldTaskDescription = printOutput.readLine("Type few words of task description to identify!: ");
            printOutput.printLine("Identified project's task description to be edited is \"" + ANSI_GREEN + projects.getTaskDescription() + ANSI_RESET + "\"");
            if (project.getTaskDescription().contains(oldTaskDescription)) {
                String newTaskDescription = printOutput.readLine("Please type the new project's task description: ");
                project.setTaskDescription(newTaskDescription);
                System.out.println("Project's task description edited successfully.");
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public Object getProject(){

        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);


        return allprojects.getProject(key);
    }
    public int numOfTasksInProject(String projectName) {
        int tasksInProject = 0;
        ArrayList<Project> allProjects = allprojects.getAllProjects();
        for (Project project : allProjects) {
            if (project.getProjectName() != null && project.getProjectName().equals(projectName)) {
                tasksInProject = project.getTasks().size();
            } else {
                printOutput.readLine("Project not found");
            }
        }
        return tasksInProject;
    }

    public void viewProjectProgress() {
        String projectName = printOutput.readLine("Please enter project name: ");
        ArrayList<assignedTask> allAssignedTasks = assignedTask.allAssignedTasks.getInstance().getAssignedTasks();
        int totalNumOfTasks = numOfTasksInProject(projectName);
        int tasksCompleted = 0;
        for (assignedTask AssignedTask : allAssignedTasks) {
            if (AssignedTask.getProjectName() != null && AssignedTask.getProjectName().equals(projectName) && AssignedTask.getStatus().equals("Completed")) {
                tasksCompleted++;
            } else {
                printOutput.printLine("No completed tasks found.");
            }
        }
        if (tasksCompleted < totalNumOfTasks) {
            System.out.println(tasksCompleted + " out of " + totalNumOfTasks + " tasks are completed");
        }else{
            printOutput.printLine("Congratulations! You have completed the project!");
        }

    }


}
