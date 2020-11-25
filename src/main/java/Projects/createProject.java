package Projects;

import java.util.ArrayList;
import java.util.List;

import Menus.ownerMenu;
import Tools.randomID;

public class createProject {


    randomID randID = randomID.getInstance();

    private String projectName;
    private int weeks;
    private String[][] projectMilestones;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;


    public createProject(String projectName, int weeks, int milestones, int task,int ownerKey){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectMilestones = new String[milestones][task];
        this.projectKey=randID.getRandom();
        this.ownerKey = ownerKey;
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
}
