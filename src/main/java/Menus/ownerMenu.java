package Menus;

import Tools.InputClass;
import Projects.createProject;
import Users.addedMembers;
import Projects.allProjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ownerMenu {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    private String teamMemberName;
    ArrayList<ownerMenu> allTeamMember;

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }

    public String getTeamMemberRole() {
        return teamMemberRole;
    }

    public void setTeamMemberRole(String teamMemberRole) {
        this.teamMemberRole = teamMemberRole;
    }

    private String teamMemberRole;

    public ArrayList<ownerMenu> getAllTeamMember() {
        return allTeamMember;
    }

    public void setAllTeamMember(ArrayList<ownerMenu> allTeamMember) {
        this.allTeamMember = allTeamMember;
    }

    public ownerMenu(String teamMemberName, String teamMemberRole) {
        this.teamMemberName = teamMemberName;
        this.teamMemberRole = teamMemberRole;
        allTeamMember = new ArrayList<>();
    }


    public void menu(){

        printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" + "Choose a option below.\n");

        String option = printOutput.readLine("1. Open project\n2. Create new Project\n3. Delete/archive project\n");
        int convertedOption = Integer.parseInt(option);

        switch(convertedOption){
            case 1:
                printOutput.printLine("to be continued...");
                break;
            case 2:

                newProject(allTeamMember);
                break;
            case 3:
                printOutput.printLine("to be continued...");
                break;
        }
    }

    void newProject(ArrayList<ownerMenu> allTeamMember){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String projectName = printOutput.readLine("Project name: ");
        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        String startDate = printOutput.readLine("Enter the start date of the project (yyyy-MM-dd); ");
        String endDate = printOutput.readLine("Enter the end date of the project (yyyy-MM-dd): ");

        char selection;

        do {

            String teamMemberName = printOutput.printLine("Type team member's name: ");
            printOutput.readLine("");
            String teamMemberRole = printOutput.printLine("Type team member's role: ");
            printOutput.readLine("");
            ownerMenu ownerMenu = new ownerMenu(teamMemberName, teamMemberRole);
            allTeamMember.add(ownerMenu);

            selection = printOutput.readChar("Would you like to add more team members?(y/n): ");
            selection = Character.toUpperCase(selection);

        }while(selection != 'n');

        int milestones = printOutput.readInt("What's the estimated number of milestones in the project?: ");
        int tasks = printOutput.readInt("How many inclusive task will each milestone have in average?: ");

        String tempUser = addedmember.getActiveUser();
        String key = addedmember.getUserKey(tempUser);
        int projectOwnerKey = Integer.parseInt(key);

        createProject newProject = new createProject(projectName,weeks, milestones, tasks, projectOwnerKey, startDate, endDate);
        allprojects.addProject(newProject);

    }
}
