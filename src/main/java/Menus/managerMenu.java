package Menus;

import Projects.*;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Mainclasses.startApp;
import Users.allMessages;
import org.springframework.scheduling.config.Task;
import Projects.assignedTask;

import javax.validation.constraints.Null;
import java.util.ArrayList;

public class managerMenu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static allMessages AllMessages = allMessages.getInstance();
    static ownerMenu OwnerMenu = new ownerMenu();
    static Project theProject;


    public void menu() {

        int option = 0;

        try {
            String activeUser = addedmembers.getActiveUser();
            int managerKey = addedmembers.getUserKey(activeUser);
            theProject = (Project) allprojects.getManagerProject(managerKey);
            if(theProject.getProjectName()==null&&theProject.getMilestoneDescription()==null){
                throw new Exception();
            }
        } catch (Exception e){
            printOutput.printLine("You have no active projects...returning");
            return;
        }

        while(option !=3) {
            printOutput.printLine("\nWelcome to the Manager Menu! Take care of your Team well.");
            option = printOutput.readInt("\n1. Add tasks to an existing project \n2. Edit Project\n3. View project progress\n4. Send a message.\n5. See my inbox.\n6. Log out.\n");

            switch (option) {
                case 1:
                    OwnerMenu.addTasksToProject();
                    break;
                case 2:
                    editProject();
                    break;
                case 3:
                    viewProjectProgress();
                    break;
                case 4:
                    AllMessages.sendMessage();
                    break;
                case 5:
                    AllMessages.readMessage();
                    break;
                case 6:
                    returnedMenu.run();
                    break;
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }
    public void editProject(){

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
                    case 'N' -> editNameOfProject();
                    case 'P' -> editShortDescription();
                    case 'S' -> editStartDate();
                    case 'E' -> editEndDate();
                    case 'A' -> editWeeks();
                    case 'M' -> editMilestoneDescription();
                    case 'T' -> editTaskDescription();
                    default ->  System.out.println("Invalid input. Please try again!");
                }
            }else{
                break;
            }
        }while(editChoice == "y");
        allprojects.setProject(theProject);
    }

    public void editNameOfProject (){
            printOutput.printLine("The name of the project is " + theProject.getProjectName());
            String newName = printOutput.readLine("Type the new name of the project (If you would like to go back, type 'BACK').");
             if (newName.equals("BACK")){
            editProject();
        }else{theProject.setProjectName(newName);
        printOutput.printLine("New name saved!");
        }
    }
    public void editShortDescription(){
        printOutput.printLine("The short description of the task is " + theProject.getShortDescription());
        String newName = printOutput.readLine("What's the new description? (If you would like to go back, insert 'BACK'. ");
        theProject.setShortDescription(newName);

    }
    public void editStartDate(){
        printOutput.printLine("The start date of the project is " + theProject.getStartDate());
        String newStartDate = printOutput.readLine("What's the new start date of the project? (If you would like to go back, insert 'BACK'. ");
        theProject.setStartDate(newStartDate);
    }
    public void editEndDate(){
        printOutput.printLine("The end date of the project is " + theProject.getEndDate());
        String newEndDate = printOutput.readLine("What's the new end date of the project? (If you would like to go back, insert 'BACK'. ");
        theProject.setEndDate(newEndDate);
    }
    public void editWeeks(){
        printOutput.printLine("The number of weeks in the project is " + theProject.getWeeks());
        int newWeeks = printOutput.readInt("What's the new number of weeks? (If you would like to go back, insert 'BACK'. ");
        theProject.setWeeks(newWeeks);
    }

    public void editMilestoneDescription() {
        printOutput.printLine("The Milestone description of the project is " + theProject.getMilestoneDescription());
        String newMilestoneDescription = printOutput.readLine("What's the new Milestone description of the project? (If you would like to go back, insert 'BACK'. ");
        theProject.setMilestoneDescription(newMilestoneDescription);
    }

    public void editTaskDescription(){
        printOutput.printLine("The task description is " + theProject.getProjectName());
        String newTaskDescription = printOutput.readLine("What's the new task description? (If you would like to go back, insert 'BACK'. ");
        theProject.setTaskDescription(newTaskDescription);
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

    public void setProject(Project project){

        this.theProject = project;
    }


}
