package Menus;

import Import_Export.importAndExportSavedInfo;
import Mainclasses.startApp;
import Projects.*;
import Tools.InputClass;
import Users.addedMembers;
import Users.allMessages;
import Projects.allAssignedTasks;
import java.util.ArrayList;

public class developerMenu {
    public final String ANSI_YELLOW = "\u001B[33m";
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_RED = "\u001B[31m";
    static InputClass printOutput = new InputClass();
    static myTasksInterface myTasksInterface = new myTasksInterface();
    static allProjects allprojects = allProjects.getInstance();
    static allMessages AllMessages = allMessages.getInstance();
    static startApp returnedMenu = new startApp();
    static allAssignedTasks AllAssignedTasks = allAssignedTasks.getInstance();
    importAndExportSavedInfo ie = new importAndExportSavedInfo();
    static addedMembers addedmembers = addedMembers.getInstance();

    public void menu() {

        int option = 0;
        while (option != 5) {

            printOutput.printLine(ANSI_YELLOW + "\nDeveloper Menu" + ANSI_RESET + "\nHere you can work on your project\nand communicate with your team members.\n" + "\nChoose between one of the following options below:\n");
            option = printOutput.readInt("1. View my tasks\n2. Report about completed tasks\n3. View Projects\n4. Send a message\n5. See your inbox\n6. Log out\n");
            switch (option) {
                case 1:
                    myTasksInterface.viewMyTasks();
                    break;
                case 2:
                    markTaskAsDone();
                    break;
                case 3:
                    accessToViewProject();
                    break;
                case 4:
                    AllMessages.sendMessage();
                    ie.exportMessages();
                    break;
                case 5:
                    AllMessages.readMessage();
                    menu();
                    return;
                case 6:
                    returnedMenu.run();
                default:
                    printOutput.printLine(ANSI_RED + "Invalid input, try again." + ANSI_RESET);
            }
        }
    }

    public void accessToViewProject() {

        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);
        try {
            Project project = (Project) allprojects.getProject(key);
            if (project == null) {
                throw new Exception();
            } else {
                viewProject(project);
            }

        } catch (Exception e) {
            printOutput.printLine("You have no projects assigned to you...returning to menu");
            return;
        }

    }

    public void viewProject(Project project) {

        printOutput.printLine("Name of Project: " + project.getProjectName() + "\n" + "Project Description: " + project.getProjectDesc() + "\n" + "Start Date: " + project.getStartDate() + "\n" +
                "End date: " + project.getEndDate() + "\n" + "Length of Project: " + project.getWeeks() +
                project.getTasks().toString().replace("[", "").replace("]", "").replace(",", "") + "\n");


    }

    public void markTaskAsDone() {
        ArrayList<assignedTask> allAssignedTasks = AllAssignedTasks.getAssignedTasks();
        String username = printOutput.readLine("Please enter your username: ");
        String choice = "";
        String hoursSpent;
        int position;
        boolean tasksFound = false;

        for (int i = 0; i < allAssignedTasks.size(); i++) {
            if (allAssignedTasks.get(i).getMemberAssigned() != null && allAssignedTasks.get(i).getMemberAssigned().equals(username) && allAssignedTasks.get(i).getStatus().equals("Uncompleted")) {
                position = i;
                System.out.println("Task number: " + position + "\n" + "Project: " + allAssignedTasks.get(position).getProjectName() + "\n" + "Milestone: " + allAssignedTasks.get(position).getMilestoneName()
                        + "\n" + "Task description: " + allAssignedTasks.get(position).getTaskDescription());
                tasksFound = true;

            }

        }
        if (!tasksFound) {
            printOutput.printLine("No uncompleted tasks found");
        } else {
            try {
                choice = printOutput.readLine("Please choose a task that has been completed: ");
                hoursSpent = printOutput.readLine("Enter the hours you have spent working on this task: ");
                double hoursSpentToDouble = Double.parseDouble(hoursSpent);
                int completedTask = Integer.parseInt(choice);
                allAssignedTasks.get(completedTask).changeStatus();
                allAssignedTasks.get(completedTask).setHoursSpent(hoursSpentToDouble);
                printOutput.printLine("Task completed!");
                ie.exportTasks();

            } catch (IndexOutOfBoundsException exception) {
                printOutput.printLine("A task with this number doesn't exist, please try again");
            }

        }
    }
}
