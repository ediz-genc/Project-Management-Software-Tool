import java.util.ArrayList;
import java.util.List;

public class createProject {

    private String projectName;
    private int weeks;
    private String[][] projectMilestones;
    private ArrayList<Integer> memberKey;
    private int projectKey;

    public createProject(String projectName, int weeks, int milestones, int task){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectMilestones = new String[milestones][task];
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


}
