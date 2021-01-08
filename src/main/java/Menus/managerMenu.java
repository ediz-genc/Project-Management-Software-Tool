package Menus;

import Import_Export.importAndExportSavedInfo;
import Projects.*;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Mainclasses.startApp;
import Users.allMessages;
import Projects.assignedTask;
import Projects.allAssignedTasks;

import java.util.ArrayList;

public class managerMenu {
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_YELLOW = "\u001B[33m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static allMessages AllMessages = allMessages.getInstance();
    static ownerMenu OwnerMenu = new ownerMenu();
    static Project theProject;
    static allAssignedTasks AllAssignedTasks = allAssignedTasks.getInstance();
    importAndExportSavedInfo ie = new importAndExportSavedInfo();

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

        while(option != 3) {
            printOutput.printLine("\nWelcome to the Manager Menu! Take care of your Team well.");
            option = printOutput.readInt("\n1. Add tasks to an existing project \n2. Edit Project\n3. View project progress\n4. Send a message.\n5. See my inbox.\n6. Log out.\n");

            switch (option) {
                case 1 -> OwnerMenu.addTasksToProject();
                case 2 -> editProject();
                case 3 -> viewProjectProgress();
                case 4 -> AllMessages.sendMessage();
                case 5 -> {
                    AllMessages.readMessage();
                    ie.exportMessages();
                }
                case 6 -> returnedMenu.run();
                default -> printOutput.printLine("Invalid input");
            }
        }
    }
    public void editProject(){

        String editChoice;
        char editSelection;

        do{
            System.out.println();
            editChoice = printOutput.readLine("Would you like to edit the project?(y/n)");
            System.out.println();
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

                editSelection = printOutput.readChar("What would you would like to edit in the project?");

                switch (editSelection) {
                    case 'N' -> editNameOfProject();
                    case 'P' -> editShortDescription();
                    case 'S' -> editStartDate();
                    case 'E' -> editEndDate();
                    case 'A' -> editWeeks();
                    case 'M' -> editMilestoneDescription();
                    case 'T' -> editTaskDescription();
                    default -> System.out.println("Invalid input. Please try again!");
                }
            }else{
                break;
            }
        }while(editChoice == "y");
        allprojects.setProject(theProject);
    }
    public void editNameOfProject () {
        printOutput.printLine("The name of the project is \"" + ANSI_GREEN + theProject.getProjectName() + ANSI_RESET + "\"");
        String newName = printOutput.readLine("Type the new name of the project " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(!newName.equals("0")) {
            theProject.setProjectName(newName);
            printOutput.printLine("New name is saved!");
        }else{
            editProject();
        }
    }
    public void editShortDescription(){
        printOutput.printLine("The short description of the task is \"" + ANSI_GREEN + theProject.getShortDescription() + ANSI_RESET + "\"");
        String newShortDescription = printOutput.readLine("What's the new short description of the project " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(!newShortDescription.equals("0")) {
            theProject.setShortDescription(newShortDescription);
            printOutput.printLine("New short description is saved!");
        }else{
            editProject();
        }
    }
    public void editStartDate(){
        printOutput.printLine("The start date of the project is \"" + ANSI_GREEN + theProject.getStartDate() + ANSI_RESET + "\"");
        String newStartDate = printOutput.readLine("What's the new start date of the project " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(!newStartDate.equals("0")) {
            theProject.setStartDate(newStartDate);
            printOutput.printLine("New start date is saved!");
        }else{
            editProject();
        }
    }
    public void editEndDate(){
        printOutput.printLine("The end date of the project is \"" + ANSI_GREEN + theProject.getEndDate() + ANSI_RESET + "\"");
        String newEndDate = printOutput.readLine("What's the new end date of the project " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(!newEndDate.equals("0")) {
            theProject.setEndDate(newEndDate);
            printOutput.printLine("New end date is saved!");
        }else{
            editProject();
        }
    }
    public void editWeeks(){
        printOutput.printLine("The number of weeks in the project is \"" + ANSI_GREEN + theProject.getWeeks() + ANSI_RESET + "\"");
        int newWeeks = printOutput.readInt("What's the new number of weeks " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(newWeeks != 0) {
            theProject.setWeeks(newWeeks);
            printOutput.printLine("New number of weeks is saved!");
        }else{
            editProject();
        }
    }
    public void editMilestoneDescription() {
        ArrayList<task> tempTask = theProject.getTasks();
        for(int i =0;i<tempTask.size();i++){
            if(tempTask.get(i).getMilestoneDescription()!=null) {
                printOutput.printLine(i + 1 + " Milestone description is \""  + ANSI_GREEN + tempTask.get(i).getMilestoneDescription() + ANSI_RESET + "\"");
            }
        }
        int option = printOutput.readInt("Choose the number of which description you want to edit: ");
        String newMilestoneDescription = printOutput.readLine("Enter the new milestone description "  + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        if(!newMilestoneDescription.equals("0")) {
            tempTask.get(option-1).setMilestoneDescription(newMilestoneDescription);
            printOutput.printLine("New milestone description is saved!");
        }else{
            editProject();
        }
    }
    public void editTaskDescription() {
        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);
        theProject = (Project) allprojects.getProject(key);
        ArrayList<task> tempTask = theProject.getTasks();
        int counter = 0; int index = 0;

        for (int i = 0; i < tempTask.size(); i++) {
            if (theProject.getTasks().get(i).getTaskDescription() != null && theProject.getManagerKey()==key || theProject.getOwnerKey()==key) {
                index = i;
                ArrayList<String> allTaskDescriptions = theProject.getTasks().get(i).getTaskDescription();
                for (int j = 0;j<allTaskDescriptions.size();j++) {
                    counter = j;
                    counter++;
                    System.out.println("Task " + counter + " description: \"" + ANSI_GREEN + allTaskDescriptions.get(j) + ANSI_RESET + "\"");
                }
            }
        }
        int option = printOutput.readInt("Choose the number of which description you want to edit: ");
        String newTaskDescription = printOutput.readLine("Enter a new task description " + ANSI_YELLOW + "(Enter \"0\" to go back): " + ANSI_RESET);
        option--;

        theProject.getTasks().get(index).setTaskDescription(newTaskDescription,option);
        theProject.setTasks(tempTask);
        printOutput.printLine("New task description is saved!");
        allprojects.setProject(theProject);
        if (key == 3) {
            ownerMenu oM = new ownerMenu();
            oM.menu();
        } else {
            return;
        }
    }
    public Object getProject(){

        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);

        return allprojects.getProject(key);
    }
    public int numOfTasksInProject(String projectName) {
        int tasksInProject = 0;
        boolean projectFound = false;
        ArrayList<Project> allProjects = allprojects.getAllProjects();
        for (Project project : allProjects) {
            if (project.getProjectName() != null && project.getProjectName().equals(projectName)) {
                tasksInProject = project.getTasks().size();
                projectFound = true;
            }
            else if(!projectFound){
                printOutput.printLine("Project not found");
                menu();
            }
        }
        return tasksInProject;
    }
    public void viewProjectProgress() {
        String projectName = printOutput.readLine("Please enter project name: ");
        ArrayList<assignedTask> allAssignedTasks = AllAssignedTasks.getAssignedtasks();
        int totalNumOfTasks = numOfTasksInProject(projectName);
        int tasksCompleted = 0;
        for (assignedTask AssignedTask : allAssignedTasks) {
            if (AssignedTask.getProjectName() != null && AssignedTask.getProjectName().equals(projectName) && AssignedTask.getStatus().equals("Completed")) {
                tasksCompleted++;
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