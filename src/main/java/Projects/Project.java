package Projects;

import java.util.ArrayList;
import java.util.List;

import Menus.ownerMenu;
import Tools.randomID;

public class Project {

    randomID randID = randomID.getInstance();

    private String projectName;
    private int weeks;
    private String projectMilestones;
    private String task;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;
    private int managerKey;
    private String startDate;
    private String endDate;
    private ArrayList<task> tasks = new ArrayList<>();

    public Project(String projectName, int weeks, String milestones, String task, int ownerKey, int managerKey, String startDate, String endDate, ArrayList<task> tasks) {
        this.projectName = projectName;
        this.weeks = weeks;
        this.projectMilestones = milestones;
        this.task = task;
        this.projectKey = randID.getRandom();
        this.ownerKey = ownerKey;
        this.managerKey = managerKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public Project() {
    }

    public String getProjectName() {
        return projectName;
    }

    public int getWeeks() {
        return weeks;
    }

    public String getProjectMilestones() {
        return projectMilestones;
    }

    public void addMemberKey(int key) {
        memberKey.add(key);
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getProjectKey() {
        return projectKey;
    }

    public ArrayList<task> getTasks() {
        return tasks;
    }

    public void addTask(Object o) {
        tasks.add((task) o);
    }

    public void setMilestoneDescription(String milestoneDescription) {
        //this.tasks[0][0] = milestoneDescription;
    }

    public void setTaskDescription(String taskDescription) {
        //this.tasks[0][0] = taskDescription;
    }

    public void statusReport(int status, int row, int column) {

        String RED = "\u001B[31m";

    }

    public String getMilestoneDescription(){
            String[][] task = new String[2][2];
            return task[0][0];
        }
        public String getTaskDescription(){
           String[][] task = new String[2][2];
           return task[0][0];

        }

        public void setWeeks(int weeks) {
                this.weeks = weeks;
            }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public int getManagerKey() { return managerKey; }
    public ArrayList<Integer> getMemberKey() { return memberKey; }


}
