package Projects;

import java.util.ArrayList;
import Projects.assignedTask;

public class allAssignedTasks {
    ArrayList<assignedTask> assignedtasks = new ArrayList<>();
    private static volatile allAssignedTasks soloAllAssignedTasks = new allAssignedTasks();

    public allAssignedTasks(){

    }

    public static allAssignedTasks getInstance(){
        if(soloAllAssignedTasks == null){
            soloAllAssignedTasks = new allAssignedTasks();
        }
        return soloAllAssignedTasks;
    }

    public ArrayList<assignedTask> getAssignedtasks(){
        return assignedtasks;
    }

    public void loadFromFile(ArrayList<assignedTask> savedAssignedTasks){
        this.assignedtasks = savedAssignedTasks;
    }

    public assignedTask getTotalSpentHours(String projectName){
        assignedTask assignedtask = null;
        for(int i = 0; i < assignedtasks.size(); i++){
            if(assignedtasks.get(i) != null && assignedtasks.get(i).getProjectName().equals(projectName)){
              assignedtask = assignedtasks.get(i);
              break;
            }
        }
        return assignedtask;
    }
}
