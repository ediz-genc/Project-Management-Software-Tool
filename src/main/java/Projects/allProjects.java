package Projects;
import java.util.ArrayList;
import Tools.InputClass;

public class allProjects {

    private static volatile allProjects soloAllProjects = new allProjects();
    private ArrayList<Project> allProjects = new ArrayList<Project>();
    static InputClass printOutput = new InputClass();
    static private int getterPosition =0;

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

        Project project = null;
        ArrayList<Integer> tempKeys =null;

        for (int i = 0; i < allProjects.size(); i++) {
        if(key == allProjects.get(i).getOwnerKey() || key == allProjects.get(i).getManagerKey()){project = allProjects.get(i);getterPosition=i; return project;}
          if(allProjects.get(i).getMemberKey()!=null){tempKeys = allProjects.get(i).getMemberKey();
            for (int j = 0; j < tempKeys.size(); j++) {
                if (tempKeys.get(i) != null && tempKeys.get(i) == key) {
                    project = allProjects.get(i);
                    getterPosition=i;
                }
            }}
        }
        return project;
    }
    public int findProjectByName(String projectName){
        ArrayList<Project> allProjects = getAllProjects();
        int position = 0;
        for(int i = 0; i < allProjects.size();i++){
            if(allProjects.get(i).getProjectName() != null && allProjects.get(i).getProjectName().equals(projectName)){
                position = i;
            }else{
                printOutput.printLine("Project not found");
                break;
            }
        }
        return position;
    }
    public ArrayList<Project> getAllProjects(){
        return allProjects;
    }


    public void loadFromFile(ArrayList<Project> savedProjects){
                this.allProjects = savedProjects;

            }


    public void allProjectsToString(){
        StringBuffer printAllProjects = new StringBuffer();
        for(Project project: allProjects){
            printAllProjects.append(project.getProjectName());
            printAllProjects.append("\n");
            printAllProjects.append(project.getWeeks());
            printAllProjects.append("\n");
            printAllProjects.append(project.getMemberKey());
            printAllProjects.append("\n");
            printAllProjects.append(project.getManagerKey());
            printAllProjects.append("\n");
            printAllProjects.append(project.getTasks());
            printAllProjects.append("\n");
        }
        String printAllProjectsArray = printAllProjects.toString();
        System.out.println(printAllProjectsArray);



    }
    
    
    public void setProject(Project project){
        int position = getterPosition;
        allProjects.set(position,project);
    }
}
