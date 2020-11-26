package Projects;

public class task {
//Task attributes

    private String projectMilestones;
    private String projectDescription;

    public task(String projectMilestones, String projectDescription){


        this.projectMilestones = projectMilestones;
        this.projectDescription = projectDescription;
    }

    public String getProjectMilestones(){
        return projectMilestones;
    }

    public String getProjectDescription(){
        return projectDescription;
    }

}
