package Projects;

import java.util.ArrayList;

public class assignedTask {
    private String projectName;
    private String milestoneName;
    private String taskDescription;
    private String memberAssigned;
    private String Status;
    private double hoursSpent;

    public assignedTask(String projectName,String milestoneName,String taskDescription,String memberAssigned, String Status){
        this.projectName = projectName;
        this.milestoneName = milestoneName;
        this.taskDescription = taskDescription;
        this.memberAssigned = memberAssigned;
        this.Status = Status;
        this.hoursSpent = 0;
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

    public String getStatus(){return Status;}

    public void changeStatus(){
        this.Status = "Completed";
    }

    public void setHoursSpent(double hoursSpent) {
        this.hoursSpent = hoursSpent;
    }
    public double getHoursSpent(){
        return hoursSpent;
    }

    public static class allAssignedTasks{
        ArrayList<assignedTask> assignedTasks = new ArrayList<>();
        private static volatile allAssignedTasks soloAllAssignedTasks = new allAssignedTasks();

        public allAssignedTasks(){

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
        public void loadFromFile(ArrayList<assignedTask> savedAssignedTasks){
            this.assignedTasks = savedAssignedTasks;
        }
    }
}
