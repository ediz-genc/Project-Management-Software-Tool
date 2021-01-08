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
    public void addBudget(double budget){
        allProjects.get(getterPosition).setBudgetCost(budget);
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
            if(allprojects.get(i) != null && allprojects.get(i).getOwnerKey()==key || allprojects.get(i).getManagerKey()==key) {
                projectNames.add(allprojects.get(i).getProjectName());
            }
        }

        return projectNames;
    }
    public void setProject(Project project){
        int position = getterPosition;
        allProjects.set(position,project);
   }

   public ArrayList<Project> getAssignedProject(){

   ArrayList<Project> assignedProject = new ArrayList<>();
   String activeUser = addedmembers.getActiveUser();
   int key = addedmembers.getUserKey(activeUser);
   ArrayList<Project> allProject = getAllProjects();
   int totalAmount = 0;

   for(int i=0;i<allProject.size();i++){
   if(allProject.get(i)!= null && allProject.get(i).getOwnerKey() == key || allProject.get(i).getManagerKey()==key){
        assignedProject.add(allProject.get(i)); totalAmount++;
   }
}
    if(totalAmount==0){return null;}
    return assignedProject;
}

    public void setGetterPosition(int projectKey){

        for(int i = 0;i<allProjects.size();i++){
            if(allProjects.get(i)!= null && allProjects.get(i).getProjectKey()== projectKey){
            this.getterPosition = i;
            break;

            }

        }

    }

   public Project getThroughIndex(int key){

   Project project = null;
   if(allProjects.get(this.getterPosition).getOwnerKey() == key || allProjects.get(this.getterPosition).getManagerKey() == key){
   project = allProjects.get(getterPosition);
   } else {
   project = null;
   }
   
   return project;
   }
}