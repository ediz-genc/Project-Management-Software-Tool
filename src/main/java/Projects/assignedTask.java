package Projects;


public class assignedTask {
    private final String projectName;
    private final String milestoneName;
    private final String taskDescription;
    private final String memberAssigned;
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

}
