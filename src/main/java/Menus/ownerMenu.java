package Menus;

import Import_Export.importAndExportSavedInfo;
import Mainclasses.startApp;
import Projects.task;
import Tools.InputClass;
import Projects.Project;
import Users.Member;
import Projects.*;
import Users.addedMembers;
import Projects.allProjects;
import Projects.taskAssignmentGUI;
import Users.allMessages;
import Tools.randomID;

import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public final String ANSI_RESET = "\u001B[0m";
    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static Project project = new Project();
    static task task = new task();
    static taskAssignmentGUI newTask = new taskAssignmentGUI();
    static Member member = new Member();
    ArrayList<Member> allMembers = addedmember.getAllMembers();
    static allMessages AllMessages = allMessages.getInstance();
    static startApp returnedMenu = new startApp();
    static managerMenu managerMenu = new managerMenu();
    randomID randID = randomID.getInstance();
    static Budget budget = new Budget();
    static allAssignedTasks AllAssignedTasks = new allAssignedTasks();


    public void menu() {

        int option = 0;

        while (option != 10) {

            printOutput.printLine(ANSI_YELLOW + "\nProduct Owner Menu\n"+ ANSI_RESET +"Create a new project and assign people,\nor continue working on existing one!\n" +
                    "\nChoose between one of the following options below:\n");
            option = printOutput.readInt("1. Create new Project\n2. Assign task to user \n3. Add tasks to existing project\n4. Edit the project\n5. Send a message\n6. See your inbox\n7. Invite users to project\n8. Estimate project budget\n9. Compare initial and final budget\n10. Log out\n");
            switch (option) {
                case 1:
                    newProject();
                    break;
                case 2:
                    newTask.assignTask();
                    break;
                case 3:
                    addTasksToProject();
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
                        printOutput.printLine(ANSI_RED+"No projects were found within your account, please create a project in order to edit."+ANSI_RESET);
                    }
                    break;
                case 5:
                    AllMessages.sendMessage();
                    break;
                case 6:
                    AllMessages.readMessage();
                    break;
                case 7:
                    String choice = printOutput.readLine("Do you want to assign a developer or manager? 'y' for developer and 'n' for manager  (y/n)");
                    if (choice.equals("y")) {
                        addMemberToProject();
                    } else if(choice.equals("n")){
                        assignManager();
                    }
                    return;
                case 8:
                    estimatedBudget();
                case 9:
                    budgetComparison();
                case 10:
                    returnedMenu.run();
                default:
                    printOutput.printLine(ANSI_RED+"Invalid input, try again."+ANSI_RESET);
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

        ArrayList<Projects.task> tasks = project.getTasks();
        String moreMilestones;
        do{
            tasks.add(addMoreMilestones());
            moreMilestones = printOutput.readLine("Do you want to add another milestone? (yes/no):\n");
        }while(moreMilestones.equals("yes"));

        int managerKey = randID.getRandom();

        String tempUser = addedmember.getActiveUser();
        int ownerKey = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName, weeks, ownerKey,managerKey, startDate, endDate,projectDescription,tasks);
        allprojects.addProject(newProject);
        printOutput.printLine("good job");
    }
    public void viewUsers(){

        for (int i = 0; i < allMembers.size(); i++){
            printOutput.printLine("Name of the User: " +allMembers.get(i).getName()+ "\n" + "User ID: " +allMembers.get(i).getUsername() + "\n"+ "User Key: "+allMembers.get(i).getMemberKey()+"\n"+
                    "Use Access to see project: "+ allMembers.get(i).getGrantedAccess());
        }
    }
    public void addMemberToProject(){
        Project theProject = null;

        try {
            String activeUser = addedmember.getActiveUser();
            int key = addedmember.getUserKey(activeUser);
            theProject = (Project) allprojects.getProject(key);
            if(theProject.getProjectName()==null&&theProject.getMilestoneDescription()==null&&theProject.getMemberKey()==null){
                throw new Exception();
            }
        } catch (Exception e){
            printOutput.printLine(ANSI_RED+"No project was found within your account,\nyou need to create one before inviting users."+ANSI_RESET);
            menu();
        }
        assert theProject != null;
        System.out.println("Which user do you want to assign to " + theProject.getProjectName());
        ArrayList<Member> temp = addedmember.getAllMembers();
        for(Member member: temp){
            System.out.println("Name: " + member.getName() +  " ID: " + member.getMemberKey());
        }
        int number = printOutput.readInt("\nWho do you want to add?\nState the ID: ");
        boolean exist = addedmember.findMemberINT(number);
        if(!exist){
            String option = printOutput.readLine("The ID doesn't exist..returning to menu. Do you want to try again? (y/n)");
            switch(option){
                case "y":
                    addMemberToProject();
                    break;
                case "n":
                    return;
                default:
                    printOutput.printLine("Invalid input");
            }
        }
        allprojects.addMember(number);
        //needs a checker if the member id typed in exists or not
        printOutput.printLine(ANSI_BRIGHT_GREEN+"\nMember added!\n"+ANSI_RESET);
        menu();
    }

    void addTasksToProject(){
        String option;
        ArrayList<String> tasksInMilestone = task.getTaskDescription();
        String milestones;
        String taskDescription;
        String projectName = printOutput.readLine("Please enter project name: ");
        int position = findProjectByName(projectName);
        ArrayList<Projects.task> tasks = allprojects.getAllProjects().get(position).getTasks();
        do {
            milestones = printOutput.readLine("Enter milestone description: ");
            taskDescription = printOutput.readLine("Enter task description: ");
            tasksInMilestone.add(taskDescription);
            option = printOutput.readLine("Do you want to enter more tasks to your project? (y/n):\n");
        }while (option.equals("y"));

        Projects.task task = new Projects.task(milestones, tasksInMilestone);
        tasks.add(task);

    }
    public int findProjectByName(String projectName){
        ArrayList<Project> allProjects = allprojects.getAllProjects();
        int position = 0;
        boolean projectFound = false;
        for(int i = 0; i < allProjects.size();i++){
            if(allProjects.get(i).getProjectName() != null && allProjects.get(i).getProjectName().equals(projectName)){
                position = i;
                projectFound = true;
            }
        }
        if(!projectFound){
            printOutput.printLine("Project not found");
        }
        return position;
    }
    public Projects.task addMoreMilestones(){
        String option;
        ArrayList<String> taskDescriptions = task.getTaskDescription() ;
        String milestones;
        String taskDescription;
        milestones = printOutput.readLine("Enter the description of the milestone: ");
        do {
            taskDescription = printOutput.readLine("Enter the description of the task: ");
            taskDescriptions.add(taskDescription);
            option = printOutput.readLine("Do you want to enter more tasks to your milestone? (y/n):\n");
        }while (option.equals("y"));

        return new task(milestones, taskDescriptions);
    }

    public void assignManager(){

        ArrayList<Member> tempUsers = addedmember.getAllMembers();
        printOutput.printLine("These are all available managers:\n");
        for(int i=0;i<0;i++){
            if(tempUsers.get(i)!=null && tempUsers.get(i).getLevel()==2){
                printOutput.printLine("Name " + tempUsers.get(i).getName() + " ID " + tempUsers.get(i).getMemberKey());

            }
        }
        int ID = printOutput.readInt("Which user do you want to assign as manager? (ID)");
        try {
            String activeUser = addedmember.getActiveUser();
            int key = addedmember.getUserKey(activeUser);
            Project theProject = (Project) allprojects.getProject(key);
            if(theProject.getProjectName()==null&&theProject.getMilestoneDescription()==null&&theProject.getMemberKey()==null){
                throw new Exception();
            } else {
                theProject.setManagerKey(ID);
            }
        } catch (Exception e){
            printOutput.printLine(ANSI_RED+"No project was found within your account,\nyou need to create one before inviting users."+ANSI_RESET);
            menu();
        }



    }

    public void estimatedBudget(){
        ArrayList<Budget> budgetCost = budget.getBudgetCost();
        Project theProject = null;

        String activeUser = addedmember.getActiveUser();
        int key = addedmember.getUserKey(activeUser);
        theProject = (Project) allprojects.getProject(key);
        printOutput.printLine("Project name: " + theProject.getProjectName());

        int totalWorkHours = printOutput.readInt("Enter the estimated amount of hours to complete the project (in hours): ");
        int memberCostPerHour = printOutput.readInt("Enter the cost for the working member per hour: ");
        int amountOfMembers = printOutput.readInt("Enter the amount of members that will be working on the project: ");
        int velocity = printOutput.readInt("Enter the estimated velocity for the project: ");
        int extraCost = printOutput.readInt("If any, enter the estimated extra cost that for the project: ");
        Budget budget = new Budget(totalWorkHours, memberCostPerHour, amountOfMembers, velocity, extraCost);
        budgetCost.add(budget);

        double totalEstimatedBudget = budgetCalculation();
        allprojects.addBudget(totalEstimatedBudget);
        menu();
    }

    public double budgetCalculation(){
        ArrayList<Budget> budgetCost = budget.getBudgetCost();
        double totalEstimatedBudget = 0.0;

        for(int i = 0; i < budgetCost.size(); i++){
            totalEstimatedBudget = (budgetCost.get(i).getVelocity() * budgetCost.get(i).getAmountOfMembers() * budgetCost.get(i).getMemberCostPerHour() *
                    budgetCost.get(i).getTotalWorkHours()) + budgetCost.get(i).getExtraCost();
        }
        printOutput.printLine("The total estimated budget for the project is: " + totalEstimatedBudget);
        return totalEstimatedBudget;
    }

    public double calculateTotalTimeWorked(){
        Project theProject = null;
        String activeUser = addedmember.getActiveUser();
        int key = addedmember.getUserKey(activeUser);
        theProject = (Project) allprojects.getProject(key);
        String projectName = theProject.getProjectName();
        double timeWorked = 0;
        assignedTask assignedtask = allAssignedTasks.getInstance().getTotalSpentHours(projectName);
        timeWorked = timeWorked + assignedtask.getHoursSpent();

        return timeWorked;
    }

    public void budgetComparison(){
        ArrayList<Budget> budgetCost = budget.getBudgetCost();
        double totalTimeWorked = calculateTotalTimeWorked();
        double totalRealBudget = 0.0;
        int realVelocity = printOutput.readInt("Enter the real velocity after the project is finished: ");
        int realExtraCost = printOutput.readInt("Enter the total extra cost after project is finished: ");

        for(int i = 0; i < budgetCost.size(); i++){
            totalRealBudget = (realVelocity * budgetCost.get(i).getAmountOfMembers() * budgetCost.get(i).getMemberCostPerHour() *
                    totalTimeWorked) + realExtraCost;
            printOutput.printLine("The real total budget after the project is finished is: " + totalRealBudget);
        }
        budgetCalculation();
        menu();
    }


}
