package Projects;

import java.util.ArrayList;
import java.util.List;

import Menus.ownerMenu;
import Tools.randomID;

public class Project {

    randomID randID = randomID.getInstance();

    private String projectName;
    private int weeks;
    private ArrayList<Integer> memberKey = new ArrayList<>();
    private int projectKey;
    private int ownerKey;
    private int managerKey;
    private String startDate;
    private String endDate;
    private String[][] tasks;

    public Project(String projectName, int weeks, int milestones, int task, int ownerKey, int managerKey, String startDate, String endDate){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectKey=randID.getRandom();
        this.ownerKey = ownerKey;
        this.managerKey = managerKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = new String[milestones][task];
    }

    public Project(){
    }

    public String getProjectName(){ return projectName; }

    public int getWeeks() { return weeks; }

   // public String getProjectMilestones(){ return projectMilestones; }

    public void addMemberKey(int key){ memberKey.add(key); }

    public String getStartDate(){ return startDate; }

    public String getEndDate(){ return endDate; }

    public int getProjectKey() { return projectKey; }

    //public ArrayList<task> getTasks() { return tasks; }

   // public void addTask(Object o){ tasks.add((task) o); }

    public int getManagerKey() { return managerKey; }

    public String[][] getTasks(){
        return tasks;
    }

    public ArrayList<Integer> getMemberKey() { return memberKey; }

    public void setTasks(String[][] tasks){
    this.tasks = tasks;
    }


    public int getOwnerKey() {
        return ownerKey;
    }

    public void statusReport(int status, int row, int column){

         String RED = "\u001B[31m";
         String GREEN = "\u001B[32m";
         String YELLOW = "\u001B[33m";
         String update = null;

         switch(status) {
             case 1:
                 update = GREEN;
                 break;
             case 2:
                 update = YELLOW;
                 break;
             case 3:
                 update = RED;
                 break;
         }

        StringBuilder str = new StringBuilder(tasks[row][column]);
        String previousStatus = str.substring(6,7);

        if(previousStatus.equals("[3")){
            str.delete(0,9);
            str.insert(0,str);
        } else {
            str.insert(0,str);
        }

        tasks[row][column] = String.valueOf(str);

    }


}
