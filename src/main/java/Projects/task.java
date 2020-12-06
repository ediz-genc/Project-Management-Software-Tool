package Projects;

public class task {
//Task attributes

    private String projectMilestones;
    private String taskDescription;

    public task(String projectMilestones, String projectDescription){


        this.projectMilestones = projectMilestones;
        this.taskDescription = projectDescription;
    }

    public String getProjectMilestones(){
        return projectMilestones;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

}
