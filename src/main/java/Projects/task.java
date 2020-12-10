package Projects;

public class task {
//Task attributes

    private String milestoneDescription;
    private String taskDescription;

    public task(String projectMilestones, String projectDescription){

        this.milestoneDescription = projectMilestones;
        this.taskDescription = projectDescription;
    }

    public String getMilestoneDescription(){
        return milestoneDescription;
    }
    public void setMilestoneDescription(String milestoneDescription){
        this.milestoneDescription = milestoneDescription;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }
}
