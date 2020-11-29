package Projects;

import java.util.ArrayList;
import java.util.List;

import Menus.ownerMenu;
import Tools.randomID;

public class Project {

    randomID randID = randomID.getInstance();

    private String projectName;
    private int weeks;
    private String[][] projectMilestones;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;
    private int managerKey;
    private String startDate;
    private String endDate;
    private ArrayList<task> tasks = new ArrayList<>();

    public Project(String projectName, int weeks, int milestones, int task, int ownerKey, int managerKey, String startDate, String endDate){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectMilestones = new String[20][100];
        this.projectKey=randID.getRandom();
        this.ownerKey = ownerKey;
        this.managerKey = managerKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = new ArrayList<>();
    }

    public Project(){
    }

    public String getProjectName() {
        return projectName;
    }

    public int getWeeks() {
        return weeks;
    }

    public String[][] getProjectMilestones() {
        return projectMilestones;
    }

    public void addMemberKey(int key){
        memberKey.add(key);
    }

    public String getStartDate() { return startDate; }

    public String getEndDate() { return endDate; }

    public int getProjectKey() {
        return projectKey;
    }

    public ArrayList<task> getTasks() {
        return tasks;
    }

    public void addTask(Object o){
        tasks.add((task) o);
    }

    public int getManagerKey() {
        return managerKey;
    }

    public ArrayList<Integer> getMemberKey() {
        return memberKey;
    }
}
