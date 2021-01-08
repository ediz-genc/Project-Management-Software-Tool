package Projects;

import java.util.ArrayList;

public class allAssignedTasks {
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
       if(assignedTasks==null){
           assignedTasks = new ArrayList<assignedTask>();
       }

        return assignedTasks;
    }
    public void loadFromFile(ArrayList<assignedTask> savedAssignedTasks){
        this.assignedTasks = savedAssignedTasks;
    }
    public assignedTask getTotalSpentHours(String projectName){
        assignedTask assignedtask = null;
        for(int i = 0; i < assignedTasks.size(); i++){
            if(assignedTasks.get(i) != null && assignedTasks.get(i).getProjectName().equals(projectName)){
              assignedtask = assignedTasks.get(i);
              break;
            }
        }
        return assignedtask;
    }
}
