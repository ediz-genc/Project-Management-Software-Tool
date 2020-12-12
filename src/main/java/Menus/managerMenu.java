package Menus;

import Projects.Project;
import Projects.task;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;
import Mainclasses.startApp;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;

public class managerMenu {

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static Project projects = new Project();


    public void menu(){


        Project project = (Project) getProject();
        int option = 0;


        while(option !=3) {
            printOutput.printLine("\nWelcome to the Manager Menu! Take care of your Team well.");
            option = printOutput.readInt("\n1. Open assigned projects\n2. Explore Projects\n3. Edit Project\n4. Return to Main menu\n");

            switch (option) {
                case 1:
                    menuDirectory(option);
                    break;
                case 2:
                    menuDirectory(option);
                    break;
                case 3:
                    editProject(project);
                    break;
                case 4:
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
                char editSelection = printOutput.readChar("Enter the first letter of the option you want choose: ");
                System.out.println("[N]ame of the project");
                System.out.println("[S]tart Date");
                System.out.println("[E]nd Date");
                System.out.println("[A]mount of weeks");
                System.out.println("[M]ilestone description");
                System.out.println("[T]ask description");
                switch(editSelection){
                    case 'N' -> editNameOfProject(projects);
                    case 'S' -> editStartDate(projects);
                    case 'E' -> editEndDate(projects);
                    case 'A' -> editWeeks(projects);
                    case 'M' -> editMilestoneDescription();
                    case 'T' -> editTaskDescription();
                    default ->  System.out.println("Invalid input. Please try again!");
                }
            }else{
                break;
            }
        }while(editChoice == "y");
        System.out.println();
    }
    public void editNameOfProject (Project projects){

        printOutput.printLine(projects.getProjectName());
        String newName = printOutput.readLine("Please type the new name of the project: ");
        projects.setProjectName(newName);
        System.out.println("New name of the project edited successfully.");
    }
    public void editStartDate(Project projects){
        printOutput.printLine(projects.getStartDate());
        String newStartDate = printOutput.readLine("Please type the new start date of the project: ");
        projects.setStartDate(newStartDate);
        System.out.println("Start date of the project edited successfully.");
    }
    public void editEndDate(Project projects){
        printOutput.printLine(projects.getEndDate());
        String newEndDate = printOutput.readLine("Please type the new end date of the project: ");
        projects.setEndDate(newEndDate);
        System.out.println("New end date of the project edited successfully.");
    }
    public void editWeeks(Project projects){
        printOutput.printInt(projects.getWeeks());
        int newWeeks = printOutput.readInt("Please type the amount of weeks: ");
        projects.setWeeks(newWeeks);
        System.out.println("The new amount of weeks edited successfully.");
    }
    public void editMilestoneDescription(){
        printOutput.printLine(projects.getMilestoneDescription());
        String newProjectMilestones = printOutput.readLine("Please type the new description of milestone: ");
        projects.setMilestoneDescription(newProjectMilestones);
        System.out.println("The new description of milestone edited successfully.");
    }
    public void editTaskDescription(){
        printOutput.printLine(projects.getTaskDescription());
        String newTaskDescription = printOutput.readLine("Please type the new description of tasks: ");
        projects.setTaskDescription(newTaskDescription);
        System.out.println("The new description of tasks edited successfully.");
    }

    public Object getProject(){

        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);
        return allprojects.getProject(key);
    }

}
