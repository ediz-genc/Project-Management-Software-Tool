package Menus;

import Projects.Project;
import Tools.InputClass;
import Projects.newTask;
import Users.addedMembers;
import Projects.allProjects;
import Mainclasses.startApp;
import Tools.InputClass;

import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();
    static newTask assigningTask = newTask.getInstance();
    static Project projects = new Project();

    public void menu() {
        int option = 0;

        while (option != 4) {

            printOutput.printLine("Welcome!\n\nHere you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Create new Project\n3. Delete/archive project\n4. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    openProject();
                    break;
                case 2:
                    newProject();
                    printOutput.printLine("to be continued...");
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    assigningTask.assignTask();
                    break;
                case 4:
                    returnedMenu.run();
                default:
                    printOutput.printLine("Invalid input");
            }
        }
    }

    void newProject() {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String projectName = printOutput.readLine("Project name: ");

        String startDate = printOutput.readLine("Enter the start date of the project (yyyy-MM-dd): ");
        String endDate = printOutput.readLine("Enter the end date of the project (yyyy-MM-dd): ");

        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        int taskDescription;
        int milestones;

        milestones = printOutput.readInt("Enter the number of the milestones in the project?: ");
        taskDescription = printOutput.readInt("Enter the number of the tasks: ");


        int managerKey = 0;

        int option = printOutput.readInt("Would you like to assign a project manager? Enter '1' if yes and '2' if no.\n");
        if (option == 1) {
            managerKey = printOutput.readInt("Please enter Managers Key?");
        }

        String tempUser = addedmember.getActiveUser();
        int ownerKey = addedmember.getUserKey(tempUser);

        taskDescription++;

        Project newProject = new Project(projectName, weeks, milestones, taskDescription, ownerKey, managerKey, startDate, endDate);
        allprojects.addProject(newProject);
    }


    void openProject() {


        int option = 0;
        Object Project;

        while (option != 3) {

            option = printOutput.readInt("Hi Welcome your project!\n1. Add tasks\n2. Assign members to tasks\n3. Return");
            switch (option) {
                case 1:
                Project = getProject();
                addTasks((Projects.Project) Project);
                    break;
                case 2:
                Project = getProject();
                assignMember((Projects.Project) Project);

                break;
                case 3:
                return;
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }


    void addTasks(Project project) {

        int counter = 0;
        String[][] tempTasks = project.getTasks();
        int length = tempTasks[0].length-1;
        String[] taskDescription = new String[length];


        String milestoneName = printOutput.readLine("What is the name of the milestone?");

        do {

            String option = printOutput.readLine("Do you want to add another task? y/n");
            if (option.equals("y")) {
                taskDescription[counter] = printOutput.readLine("Please enter task description");
            } else {
                break;
            }

            counter++;

        } while (counter <= length);

        for (int i = 0; i < tempTasks.length; i++) {
            if (tempTasks[i][0] == null) {
                tempTasks[i][0] = milestoneName;
            }
            for (int j = 0; j < tempTasks[0].length-1; j++) {
                tempTasks[i][j] = taskDescription[j];
            }

        }


        project.setTasks(tempTasks);
        allprojects.addProject(project);


    }

    public Object getProject(){

    String activeUser = addedmember.getActiveUser();
    int key = addedmember.getUserKey(activeUser);


    return allprojects.getProject(key);
    }


    void assignMember(Project project){

    String[][] tempTasks = project.getTasks();

    ArrayList<Users.createMember> members = addedmember.getAllMembers();

    for(int k = 0; k < members.size(); k++ ){

    printOutput.printLine(members.get(k).getName() + " " + members.get(k).getUsername());

    }
    String assignedUser = printOutput.readLine("Which user do you want to assign?(username)");
    for(Users.createMember member:members){
        if(member.getUsername() != null && !member.getUsername().equals(assignedUser)){
           assignMember(project);
        }
    }


    for(int i =0;i < tempTasks.length;i++){

        for(int j =0; j < tempTasks[0].length;j++){
        printOutput.printLine(i+1 + "." + j+1 + tempTasks[i][j] + "\n");

        }
    }

    double option = printOutput.readDouble("What task do you want to assign the user to?(tasknumber)");

        String[] arr=String.valueOf(option).split("\\.");
        int[] intArr=new int[2];
        intArr[0]=Integer.parseInt(arr[0]);
        intArr[1]=Integer.parseInt(arr[1]);
        int row = intArr[0]; int column = intArr[1]; int length = tempTasks[0].length-1;

        tempTasks[row][length] = assignedUser;



    }


}




