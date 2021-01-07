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
        return assignedTasks;
    }

    public void loadFromFile(ArrayList<assignedTask> savedAssignedTasks){
        this.assignedTasks = savedAssignedTasks;
    }
}
