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

            printOutput.printLine("Welcome!\n\nHere you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. View my tasks\n2. Report about completed tasks\n3. Delete/archive project\n4. View Projects\n5. Send a message\n6. See your inbox\n7. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
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
                    return;
                case 6:
                    AllMessages.readMessage();
                case 7:
                    returnedMenu.run();
                default:
                    printOutput.printLine("Invalid input");
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
        printOutput.printLine(" User key invalid ");
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
        for(assignedTask AssignedTask: allAssignedTasks){
            if(AssignedTask.getMemberAssigned().equals(username) && AssignedTask.getStatus().equals("Uncompleted")){
                int position = allAssignedTasks.indexOf(AssignedTask);
                System.out.println("Task number: " + position + "\n" + "Project: " + AssignedTask.getProjectName() + "\n" + "Milestone: " + AssignedTask.getMilestoneName()
                        + "\n" + "Task description: " + AssignedTask.getTaskDescription());
                choice = printOutput.readLine("Please choose a task that has been completed: ");
            }else{
                printOutput.printLine("No tasks have been assigned to you.");
            }
            int completedTask = Integer.parseInt(choice);
            allAssignedTasks.get(completedTask).changeStatus();
            printOutput.printLine("Task completed!");
        }
    }

}
