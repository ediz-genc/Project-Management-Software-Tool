package Projects;

import java.util.ArrayList;

public class assignedTask {
    private final String projectName;
    private final String milestoneName;
    private final String taskDescription;
    private final String memberAssigned;

    public assignedTask(String projectName,String milestoneName,String taskDescription,String memberAssigned){
        this.projectName = projectName;
        this.milestoneName = milestoneName;
        this.taskDescription = taskDescription;
        this.memberAssigned = memberAssigned;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getMemberAssigned() {
        return memberAssigned;
    }
    static class allAssignedTasks{
       ArrayList<assignedTask> assignedTasks = new ArrayList<>();
       private static volatile allAssignedTasks soloAllAssignedTasks = new allAssignedTasks();

       private allAssignedTasks(){

       }
       public static allAssignedTasks getInstance(){
           if(soloAllAssignedTasks == null){
               soloAllAssignedTasks = new allAssignedTasks();
           }
           return soloAllAssignedTasks;
       }
       public ArrayList<assignedTask> getAssignedTasks(){
           return assignedTasks;
       }
    }
}
