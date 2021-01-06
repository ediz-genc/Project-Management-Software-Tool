package Projects;

import java.util.ArrayList;

public class task {
//Task attributes

    private String milestoneDescription;
    private ArrayList<String> taskDescription = new ArrayList<>();

    public task(String projectMilestones, ArrayList<String> taskDescription){

        this.milestoneDescription = projectMilestones;
        this.taskDescription = taskDescription;
    }
    public task(){

    }

    public String getMilestoneDescription(){
        return milestoneDescription;
    }
    public void setMilestoneDescription(String milestoneDescription){
        this.milestoneDescription = milestoneDescription;
    }
    public ArrayList<String> getTaskDescription(){
        return taskDescription;
    }
    public void setTaskDescription(ArrayList<String> taskDescription){
        this.taskDescription = taskDescription;
    }

    public String toString() {
        return "\nMilestone Description: " + this.milestoneDescription + "\nTask Description: " + this.taskDescription;
    }
}
