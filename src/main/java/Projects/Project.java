package Projects;

import java.util.ArrayList;

public class Project {

    private String projectName;
    private int weeks;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;
    private int managerKey;
    private String startDate;
    private String endDate;
    private ArrayList<task> tasks = new ArrayList<>();
    private String projectDesc;
    private double budgetCost;
    private double realBudgetCost;

    public Project(String projectName, int projectKey, int weeks, int ownerKey,int managerKey, String startDate, String endDate,String projectDescription, ArrayList<task> tasks) {
        this.projectName = projectName;
        this.weeks = weeks;
        this.projectKey = projectKey;
        this.ownerKey = ownerKey;
        this.managerKey = managerKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
        this.projectDesc = projectDescription;
        this.budgetCost = 0;
        this.realBudgetCost = 0;
    }
    public Project() {
    }
    public String getProjectName() {
        return projectName;
    }
    public String getShortDescription(){
        return projectDesc;
    }
    public void setShortDescription(String projectDesc){
        this.projectDesc = projectDesc;
    }
    public int getWeeks() {
        return weeks;
    }
    public void addMemberKey(int key) {
        if(memberKey==null){
        memberKey = new ArrayList<Integer>();
        }
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
    public void addTask(task singleTask) {
        tasks.add(singleTask);
    }
    public double getBudgetCost() {
        return budgetCost;
    }
    public double getRealBudgetCost() {return realBudgetCost;}
    public void setBudgetCost(double budgetCost) {
        this.budgetCost = budgetCost;
    }
    public void setRealBudgetCost(double realBudgetCost){this.realBudgetCost = realBudgetCost;}
    public String getProjectDesc() { return projectDesc; }
    public void setWeeks(int weeks) {
                this.weeks = weeks;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public int getManagerKey() { return managerKey; }
    public int getOwnerKey(){
    return ownerKey;
    }
    public ArrayList<Integer> getMemberKey() { return memberKey; }
    public void addMember(int number){ memberKey.add(number); }
    public void setManagerKey(int managerKey) {
        this.managerKey = managerKey;
    }
    public void setTasks(ArrayList<task> tasks){
        this.tasks = tasks;
    }

}
