package Menus;

import Mainclasses.startApp;
import Tools.InputClass;
import Projects.Project;
import Users.Member;
import Users.addedMembers;
import Projects.allProjects;
import Projects.taskAssignmentGUI;
import Users.allMessages;

import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static Project project = new Project();
    static taskAssignmentGUI newTask = new taskAssignmentGUI();
    static Member member = new Member();
    ArrayList<Member> allMembers = addedmember.getAllMembers();
    static allMessages AllMessages = allMessages.getInstance();
    static startApp returnedMenu = new startApp();
    static managerMenu managerMenu = new managerMenu();

    public void menu() {

        int option = 0;

        while (option != 8) {

            printOutput.printLine("\nWelcome!\n\nHere you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Add tasks to existing project\n2. Assign task to user \n3. Create new Project\n4. Edit the project\n5. Send a message\n6. See your inbox\n7. Invite users to project\n8. Log out\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    addTasksToProject();
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
                    String activeUser = addedmember.getActiveUser();
                    Project project;
                    try {
                        int key = addedmember.getUserKey(activeUser);
                        project = (Project) allprojects.getProject(key);
                        if(project.getProjectName()==null){throw new Exception();}
                        managerMenu.setProject(project);
                        managerMenu.editProject();
                    } catch(Exception e) {
                        printOutput.printLine("No project active with your active.");
                    }
                    break;
                case 5:
                    AllMessages.sendMessage();
                    break;
                case 6:
                    AllMessages.readMessage();
                    break;
                case 7:
                    addMemberToProject();
                    return;
                case 8:
                    returnedMenu.run();
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
        int ownerKey = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName, weeks, ownerKey,managerKey, startDate, endDate,projectDescription,tasks);
        allprojects.addProject(newProject);
    }
    public void viewUsers(){

        for (int i = 0; i < allMembers.size(); i++){
            printOutput.printLine("Name of the User: " +allMembers.get(i).getName()+ "\n" + "User ID: " +allMembers.get(i).getUsername() + "\n"+ "User Key: "+allMembers.get(i).getMemberKey()+"\n"+
                    "Use Access to see project: "+ allMembers.get(i).getGrantedAccess());
        }
    }

    public void addMemberToProject(){
        Project theProject;

        try {
            String activeUser = addedmember.getActiveUser();
            int key = addedmember.getUserKey(activeUser);
            theProject = (Project) allprojects.getProject(key);
            if(theProject.getProjectName()==null&&theProject.getMilestoneDescription()==null&&theProject.getMemberKey()==null){
                throw new Exception();
            }
        } catch (Exception e){
            printOutput.printLine("No project was found...returning.");
            return;
        }
        System.out.println("Which user do you want to assign to " + theProject.getProjectName());
        ArrayList<Member> temp = addedmember.getAllMembers();
        for(Member member: temp){
            System.out.println("Name: " + member.getName() +  "ID: " + member.getMemberKey());
        }
        int number = printOutput.readInt("Who do you want to add? State the ID: ");
        allprojects.addMember(number);
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
    void addTasksToProject(){
        String option;
        String taskDescription;
        String milestones;
        String projectName = printOutput.readLine("Please enter project name: ");
        int position = allprojects.findProjectByName(projectName);
        ArrayList<Projects.task> tasks = allprojects.getAllProjects().get(position).getTasks();
        do {
            milestones = printOutput.readLine("Enter milestone description: ");
            taskDescription = printOutput.readLine("Enter task description: ");
            Projects.task task = new Projects.task(milestones, taskDescription);
            tasks.add(task);

            option = printOutput.readLine("Do you want to enter more tasks to your project? (y/n): ");
        }while (option.equals("y"));

    }


}
