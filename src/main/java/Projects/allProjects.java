package Projects;
import java.util.ArrayList;

public class allProjects {

    private static volatile allProjects soloAllProjects = new allProjects();
    private ArrayList<Project> allProjects = new ArrayList<Project>();

    private allProjects() {
    }

    public static allProjects getInstance() {
        if (soloAllProjects == null) {
            soloAllProjects = new allProjects();
        }
        return soloAllProjects;
    }

    public void addProject(Object o){
        allProjects.add((Project) o);
    }

    public void addMember(int key){

        for(int i=0;i< allProjects.size();i++){
            if(allProjects.get(i).getProjectKey() == key){
            }
        }
    }


}
