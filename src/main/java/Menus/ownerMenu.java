package Menus;

import Projects.Project;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();

    public void menu() {
        int option = 0;

        while (option != 4) {

            printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. Open project\n2. Create new Project\n3. Delete/archive project\n4. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    break;
                case 2:
                    newProject();
                    printOutput.printLine("to be continued...");
                    break;
                case 3:
                    printOutput.printLine("to be continued...");
                    break;
                case 4:
                    return;
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

        String selection;

        do {
            String memberName = printOutput.printLine("Type team member's name: ");
            addedmember.setMemberName(memberName);
            printOutput.readLine("");
            String memberRole = printOutput.printLine("Type team member's role: ");
            addedmember.setMemberRole(memberRole);
            printOutput.readLine("");
            selection = printOutput.readLine("Would you like to add more team members?(y/n): ");
        } while (selection.equals("y"));

        int milestones = printOutput.readInt("What's the estimated number of milestones in the project?: ");
        int tasks = printOutput.readInt("How many inclusive task will each milestone have in average?: ");
        int managerKey=0;

        int option = printOutput.readInt("Would you like to assign a project manager? Enter '1' if yes and '2' if no.\n");
        if(option==1){ managerKey = printOutput.readInt("Please enter Managers Key?"); }

        String tempUser = addedmember.getActiveUser();
        int ownerKey = addedmember.getUserKey(tempUser);

        Project newProject = new Project(projectName,weeks, milestones, tasks, ownerKey, managerKey, startDate,endDate);
        allprojects.addProject(newProject);
    }

    void openProject(){

    }
}
