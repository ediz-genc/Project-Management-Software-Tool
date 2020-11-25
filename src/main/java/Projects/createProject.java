package Projects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Tools.randomID;

public class createProject {

    static randomID randID = new randomID();
    Date date = new Date();

    private String projectName;
    private int weeks;
    private String[][] projectMilestones;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;
    private String startDate;
    private String endDate;

    public static void setRandID(randomID randID) {
        createProject.randID = randID;
    }

    public createProject(String projectName, int weeks, int milestones, int task, int ownerKey, String startDate, String endDate){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectMilestones = new String[milestones][task];
        this.projectKey = randID.getRandom();
        this.ownerKey = ownerKey;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getProjectKey() {
        return projectKey;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
}
