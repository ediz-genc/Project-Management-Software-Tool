package Projects;
import Users.addedMembers;
import Users.createMember;
import java.util.ArrayList;



public class allProjects {

    private static volatile allProjects soloAllProjects = new allProjects();
    private ArrayList<createProject> allProjects = new ArrayList<createProject>();



    private allProjects() {
    }

    public static allProjects getInstance() {
        if (soloAllProjects == null) {
            soloAllProjects = new allProjects();
        }
        return soloAllProjects;
    }


    public void addProject(Object o){

        allProjects.add((createProject) o);

    }


    public void addMember(int key){

        for(int i=0;i< allProjects.size();i++){
            if(allProjects.get(i).getProjectKey()==key){


            }
        }


    }


}
