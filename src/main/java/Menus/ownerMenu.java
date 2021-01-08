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
import java.util.InputMismatchException;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public final String ANSI_RESET = "\u001B[0m";
    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static Project project = new Project();
    static Project theProject = new Project();
    static task task = new task();
    static taskAssignmentGUI newTask = new taskAssignmentGUI();
    static allMessages AllMessages = allMessages.getInstance();
    static startApp returnedMenu = new startApp();
    static managerMenu managerMenu = new managerMenu();
    randomID randID = randomID.getInstance();
    static Budget budget = new Budget(); String activeUser; boolean checker;
    importAndExportSavedInfo ie = new importAndExportSavedInfo();

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
                    newTask.projectChecker();
                    break;
                case 3:
                    activeUser = addedmember.getActiveUser();
                    checker = checkProject();
                    if(checker){
                    int key = addedmember.getUserKey(activeUser);
                    managerMenu.chooseProject();
                    this.theProject = (Project) allprojects.getThroughIndex(key);
                    addTasksToProject();
                    } else {
                    System.out.println("You have no projects");
                    return;
                    }

                    break;
                case 4:
                    String activeUser = addedmember.getActiveUser();
                    Project tempProject; boolean checker = checkProject();
                    if(checker){

                        int key = addedmember.getUserKey(activeUser);
                        managerMenu.chooseProject();
                        tempProject = (Project) allprojects.getThroughIndex(key);
                        managerMenu.setProject(tempProject);
                        managerMenu.editProject();
                    } else {
                    System.out.println("You have no projects");
                    return;
                    }
                    break;
                case 5:
                    AllMessages.sendMessage();
                    ie.exportMessages();
                    break;
                case 6:
                    AllMessages.readMessage();
                    break;
                case 7:
                    activeUser = addedmember.getActiveUser();
                    checker = checkProject();
                    if(checker){
                    int key = addedmember.getUserKey(activeUser);
                    managerMenu.chooseProject();
                    this.theProject = (Project) allprojects.getThroughIndex(key);

                    } else {
                    System.out.println("You have no projects");
                    return;
                    }
                    assert theProject != null;
                    String choice = printOutput.readLine("Do you want to assign a developer or manager?\n1. Developer\n2. Project Manager\n");
                    if (choice.equals("1")) {
                        printedDevelopers();
                    } else if(choice.equals("2")){
                        printedManagers();
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
            moreMilestones = printOutput.readYN("Do you want to add another milestone to your project? (y/n):\n");
        }while(moreMilestones.equals("y"));

        int managerKey = randID.getRandom();
        int projectKey = randID.getRandom();
        String tempUser = addedmember.getActiveUser();
        int ownerKey = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName,projectKey, weeks, ownerKey,managerKey, startDate, endDate,projectDescription,tasks);
        allprojects.addProject(newProject);
        printOutput.printLine(ANSI_BRIGHT_GREEN+"Project created!"+ANSI_RESET);
    }

    public void printedDevelopers(){

        System.out.println(ANSI_YELLOW + "These are all the available Developers: \n" + ANSI_RESET);
        ArrayList<Member> temp = addedmember.getAllMembers();
        for(Member member: temp){
            if(member.getLevel()!= 0 && member.getLevel() == 3){
                System.out.println("Name: " + member.getName() +  " ID: " + member.getMemberKey());
            }
        }
        assignedDeveloper();
    }
    public void assignedDeveloper(){

        int number = printOutput.readInt("\nWho do you want to assign?\nState the ID: ");
        if (number == 0){
            menu();
        }
        boolean exist = addedmember.findMemberINT(number);
        if(!exist){
            printOutput.printLine(ANSI_RED+"The ID doesn't exist."+ANSI_RESET+ANSI_YELLOW+"\n(Type '0' to go back)."+ANSI_RESET);
            assignedDeveloper();
        }
        allprojects.addMember(number);
        printOutput.printLine(ANSI_BRIGHT_GREEN+"\nMember added!\n"+ANSI_RESET);
        menu();
    }
    void addTasksToProject(){
        String option;
        ArrayList<String> tasksInMilestone = new ArrayList<>();
        String milestones; int number = 0;

   do {

            milestones = printOutput.readLine("Enter milestone description: ");
            number = printOutput.readInt("How many tasks do you want to add?");
            for(int i=0;i<number;i++){
            String descp = printOutput.readLine("Enter task description: ");
             tasksInMilestone.add(descp);
            }

            Projects.task task = new Projects.task(milestones, tasksInMilestone);
            theProject.addTask(task);
            option = printOutput.readYN("Do you want to enter more tasks to your project? (y/n):\n");
        }while (option.equals("y"));

       allprojects.setProject(theProject);

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
            option = printOutput.readYN("Do you want to enter more tasks to your milestone? (y/n):\n");
        }while (option.equals("y"));

        return new task(milestones, taskDescriptions);
    }
    public void printedManagers(){

        printOutput.printLine(ANSI_YELLOW+"These are all the available managers: \n"+ANSI_RESET);
        ArrayList<Member> tempUsers = addedmember.getAllMembers();
        for(int i=0;i<tempUsers.size();i++){
            if(tempUsers.get(i)!=null && tempUsers.get(i).getLevel()==2){
                printOutput.printLine("Name " + tempUsers.get(i).getName() + "| ID " + tempUsers.get(i).getMemberKey());
            }
        } assignedManager();
    }
    public void assignedManager(){

        int ID = printOutput.readInt("\nWho do you want to assign?\nState the ID: ");
        if(ID == 0){
            menu();
        }
        boolean found = addedmember.findMemberINT(ID);
        if (!found){
            printOutput.printLine(ANSI_RED+"The ID doesn't exist."+ANSI_RESET+ANSI_YELLOW+"\n(Type '0' to go back)."+ANSI_RESET);
            assignedManager();
        }
            String activeUser = addedmember.getActiveUser();
            int key = addedmember.getUserKey(activeUser);
            this.theProject.setManagerKey(ID);
            printOutput.printLine(ANSI_BRIGHT_GREEN+"\nMember added!\n"+ANSI_RESET);
            allprojects.setProject(theProject);
            menu();

            }
    public void estimatedBudget(){
        ArrayList<Budget> budgetCost = budget.getBudgetCost();
        managerMenu.chooseProject();

        try {
            printOutput.printLine(ANSI_YELLOW + "Enter the input to the nearest whole number! " + ANSI_RESET);
            int totalWorkHours = printOutput.readInt("Enter the estimated amount of hours to complete the project (in hours): ");
            int memberCostPerHour = printOutput.readInt("Enter the cost for the working member per hour: ");
            int amountOfMembers = printOutput.readInt("Enter the amount of members that will be working on the project: ");
            int velocity = printOutput.readInt("Enter the estimated velocity for the project: ");
            int extraCost = printOutput.readInt("If any, enter the estimated extra cost that for the project: ");
            Budget budget = new Budget(totalWorkHours, memberCostPerHour, amountOfMembers, velocity, extraCost);
            budgetCost.add(budget);
        }catch (InputMismatchException exception){
            printOutput.printLine(ANSI_RED + "Please round the work hours to the nearest whole number." + ANSI_RESET);
            menu();
        }

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
        try {
            printOutput.printLine(ANSI_YELLOW + "Enter the input to the nearest whole number! " + ANSI_RESET);
            int realVelocity = printOutput.readInt("Enter the real velocity after the project is finished: ");
            int realExtraCost = printOutput.readInt("Enter the total extra cost after project is finished: ");

            for (int i = 0; i < budgetCost.size(); i++) {
                totalRealBudget = (realVelocity * budgetCost.get(i).getAmountOfMembers() * budgetCost.get(i).getMemberCostPerHour() *
                        totalTimeWorked) + realExtraCost;
            }
            printOutput.printLine("The real total budget after the project is finished is: " + totalRealBudget);
        }catch (InputMismatchException inputMismatchException){
            printOutput.printLine(ANSI_RED +"Please round all estimations to the nearest whole number. "+ ANSI_RESET);
            menu();
        }
        allprojects.addRealCostBudget(totalRealBudget);
        budgetCalculation();
        menu();
    }


     public boolean checkProject(){
        boolean checker = false;

        try {
                    String activeUser = addedmember.getActiveUser();
                    int key = addedmember.getUserKey(activeUser);
                    Project theProject = (Project) allprojects.getProject(key);
                    if(theProject==null){
                        return checker;
                    } else {
                    checker = true;
                    }
                } catch (Exception e){
                    printOutput.printLine("You have no active projects...returning");

                }
        return checker;
        }



}
