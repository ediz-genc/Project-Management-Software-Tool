package Menus;

import Mainclasses.startApp;
import Projects.Project;
import Projects.allProjects;
import Projects.assignedTask;
import Tools.InputClass;
import Projects.myTasksInterface;
import Users.Member;
import Users.addedMembers;
import Users.allMessages;

import java.util.ArrayList;

public class developerMenu {
    public final String ANSI_YELLOW = "\u001B[33m";
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_RED = "\u001B[31m";
    static InputClass printOutput = new InputClass();
    static myTasksInterface myTasksInterface = new myTasksInterface();
    static allProjects allprojects = allProjects.getInstance();
    ArrayList<Project> projects = allprojects.getAllProjects();
    ArrayList<Member> allMembers = addedMembers.getInstance().getAllMembers();
    static allMessages AllMessages = allMessages.getInstance();
    static startApp returnedMenu = new startApp();

    public void menu() {

        int option = 0;
        while (option != 5) {

            printOutput.printLine(ANSI_YELLOW +"\nDeveloper Menu"+ ANSI_RESET+"\nHere you can work on your project\nand communicate with your team members.\n" + "\nChoose between one of the following options below:\n");
            option = printOutput.readInt("1. View my tasks\n2. Report about completed tasks\n3. Delete/archive project\n4. View Projects\n5. Send a message\n6. See your inbox\n7. Log out\n");
            switch (option) {
                case 1:
                    myTasksInterface.viewMyTasks();
                    break;
                case 2:
                    markTaskAsDone();
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    break;
                case 4:
                    accessToViewProject();
                    break;
                case 5:
                    AllMessages.sendMessage();
                    menu();
                    return;
                case 6:
                    AllMessages.readMessage();
                    menu();
                    return;
                case 7:
                    returnedMenu.run();
                default:
                    printOutput.printLine(ANSI_RED+"Invalid input, try again."+ANSI_RESET);
            }
        }
    }
    public void accessToViewProject() {
        //Method to be finished (Patricia and Jakob)
        // Verifying the access key to see the project

        int memberKey = printOutput.readInt("Enter your member key: ");

        for (int j = 0; j < allMembers.size(); j++) {
            if (memberKey == allMembers.get(j).getMemberKey() && allMembers.get(j).getGrantedAccess().equals("Access granted")) {
                viewProject();
                return;
            }
        }
        printOutput.printLine(ANSI_RED+"User key invalid"+ANSI_RESET);
    }
    public void viewProject(){
        for (int i = 0; i < projects.size(); i++){
            printOutput.printLine("Name of Project: " + projects.get(i).getProjectName() +"\n" + "Project Description: "+ projects.get(i).getProjectDesc()+"\n"+ "Start Date: "+ projects.get(i).getStartDate() +"\n"+
                    "End date: "+ projects.get(i).getEndDate()+"\n"+ "Length of Project: "+ projects.get(i).getWeeks()+
                    projects.get(i).getTasks().toString().replace("[", "").replace("]", "").replace(",", "")+ "\n");
        }
    }
    public void markTaskAsDone(){
        ArrayList<assignedTask> allAssignedTasks = assignedTask.allAssignedTasks.getInstance().getAssignedTasks();
        String username = printOutput.readLine("Please enter your username: ");
        String choice = "";
        double hoursSpent = 0;
        for(assignedTask AssignedTask: allAssignedTasks){
            if(AssignedTask.getMemberAssigned().equals(username) && AssignedTask.getStatus().equals("Uncompleted")){
                int position = allAssignedTasks.indexOf(AssignedTask);
                System.out.println("Task number: " + position + "\n" + "Project: " + AssignedTask.getProjectName() + "\n" + "Milestone: " + AssignedTask.getMilestoneName()
                        + "\n" + "Task description: " + AssignedTask.getTaskDescription());
                choice = printOutput.readLine("Please choose a task that has been completed: ");
                hoursSpent = printOutput.readDouble("Enter the hours you have spent working on this task: ");
            }else{
                printOutput.printLine("No tasks have been assigned to you.");
            }
            int completedTask = Integer.parseInt(choice);
            allAssignedTasks.get(completedTask).changeStatus();
            allAssignedTasks.get(completedTask).setHoursSpent(hoursSpent);
            printOutput.printLine("Task completed!");
        }
    }

}
