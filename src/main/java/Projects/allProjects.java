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
    public void addProject(Object o) {
        this.allProjects.add((Project) o);
    }
    public void addMember(int key) {

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.get(i).getProjectKey() == key) {
            }
        }
    }
    public Object getManagerProject(int key) {

        Object project = null;

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.get(i).getManagerKey() > 1001 &&
                    allProjects.get(i).getManagerKey() == key) {
                project = allProjects.get(i);
            }
        }
        return project;

    }
    public Object getProject(int key) {

        Object project = null;
        ArrayList<Integer> tempKeys;

        for (int i = 0; i < allProjects.size(); i++) {
            if(key==allProjects.get(i).getOwnerKey() || key==allProjects.get(i).getManagerKey()){project=allProjects.get(i); break;}
            tempKeys = allProjects.get(i).getMemberKey();
            for (int j = 0; j < tempKeys.size(); j++) {
                if (tempKeys.get(i) == key) {
                    project = allProjects.get(i);
                }
            }
        }
        return project;
    }
    public ArrayList<Project> getAllProjects(){
        return allProjects;
    }


}
