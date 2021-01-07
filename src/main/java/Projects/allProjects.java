package Projects;
import java.util.ArrayList;
import Tools.InputClass;
import Users.addedMembers;

public class allProjects {

    private static volatile allProjects soloAllProjects = new allProjects();
    private ArrayList<Project> allProjects = new ArrayList<Project>();
    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    private int getterPosition =0;

    private allProjects() {
    }
    public static allProjects getInstance() {
        if (soloAllProjects == null) {
            soloAllProjects = new allProjects();
        }
        return soloAllProjects;
    }
    public void addProject(Object o) {
        allProjects.add((Project) o);
    }
    public void addMember(int memberID) {

        allProjects.get(getterPosition).addMemberKey(memberID);
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

        Project project = null;
        ArrayList<Integer> tempKeys =null;

        for (int i = 0; i < allProjects.size(); i++) {
        if(key == allProjects.get(i).getOwnerKey() || key == allProjects.get(i).getManagerKey()){project = allProjects.get(i);getterPosition=i; return project;}
          if(allProjects.get(i).getMemberKey()!=null){tempKeys = allProjects.get(i).getMemberKey();
            for (int j = 0; j < tempKeys.size(); j++) {
                if (tempKeys.get(j) != null && tempKeys.get(j) == key) {
                    project = allProjects.get(i);
                    getterPosition = i;
                    return project;
                }
            }}
        }
        return project;
    }

    public ArrayList<Project> getAllProjects(){
        return allProjects;
    }


    public void loadFromFile(ArrayList<Project> savedProjects){
                this.allProjects = savedProjects;

            }

    public ArrayList<String> findProjectsNames(){

        ArrayList<String> projectNames = new ArrayList<String>();
        String activeUser = addedmembers.getActiveUser();
        int key = addedmembers.getUserKey(activeUser);
        ArrayList<Project> allprojects = getAllProjects();

        for (int i = 0; i < allProjects.size(); i++) {
            if(allprojects.get(i).getOwnerKey()==key || allprojects.get(i).getManagerKey()==key) {
                projectNames.add(allprojects.get(i).getProjectName());
            }
        }

        return projectNames;
    }




    public void setProject(Project project){
        int position = getterPosition;
        allProjects.set(position,project);
    }
}
