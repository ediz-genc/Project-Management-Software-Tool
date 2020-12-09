package Menus;


import Projects.Project;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;
import Mainclasses.startApp;
public class developerMenu {


    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();
    static startApp returnedMenu = new startApp();

    public void menu(){

        int option = 0;

        while(option != 3) {
            printOutput.printLine("\nWelcome to the menu where stuff gets done!");
            option = printOutput.readInt("\n1. Open assigned projects\n2. Explore Projects\n3. Return to menu\n");

            switch(option){
                case 1:
                    menuDirectory(option);
                    break;
                case 2:
                    menuDirectory(option);
                    break;
                case 3:
                    returnedMenu.run();
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }
    
    void menuDirectory(int caseNumber){

        Project project = (Project) getProject();

        switch(caseNumber){

            case 1:
                openProject(project);

                break;
            case 2:
                break;


        }
    }
    void openProject(Project project){

        int option = 0;
        Object Project;

        while (option != 3) {

            option = printOutput.readInt("Hi Welcome to your project!\n1.View tasks\n2. Report status \n3. Return");
            switch (option) {
                case 1:
                    viewTasks(project);
                    break;
                case 2:
                    statusReport(project);

                    break;
                case 3:
                    return;
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }



    void viewTasks(Project project){

        String[][] tempTasks = project.getTasks();
        String option = printOutput.readYN("Do you want to view all the tasks? alternatively just the ones assigned to you." +
                " (y/n) \n");

        if(option.equals("y")){
            for(int i =0;i < tempTasks.length;i++){

                for(int j =0; j < tempTasks[0].length-1;j++){
                    printOutput.printLine(i+1 + "." + j+1 + " " + tempTasks[i][j]);
                    if(j==0){
                        printOutput.printLine("Milestone: ");
                    }
                    if(j==tempTasks[0].length-1){
                        printOutput.printLine("\n");
                    }

                }
            }

        } else if(option.equals("n")) {
            for(int i =0;i < tempTasks.length;i++){

                if(tempTasks[i][tempTasks.length-1]!=null &&
                        tempTasks[i][tempTasks.length-1].equals(addedmember.getActiveUser())) {

                    for (int j = 0; j < tempTasks[i].length-1; j++) {
                        printOutput.printLine(i + 1 + "." + j + 1 + " " + tempTasks[i][j]);
                        if (j == 0) {
                            printOutput.printLine("Milestone: ");
                        }
                        if (j == tempTasks[0].length - 1) {
                            printOutput.printLine("\n");
                        }

                    }
                }
            }
        }
    }



    void statusReport(Project project){






    }


    public Object getProject(){

        String activeUser = addedmember.getActiveUser();
        int key = addedmember.getUserKey(activeUser);


        return allprojects.getProject(key);
    }





}
