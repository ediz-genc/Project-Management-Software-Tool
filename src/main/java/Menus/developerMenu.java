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

        switch(caseNumber){

            case 1:
                String activeUser = addedmember.getActiveUser();
                int key = addedmember.getUserKey(activeUser);
                Object Project = allprojects.getProject(key);
                openProject((Projects.Project) Project);
                break;
            case 2:
                break;


        }
    }
    void openProject(Project project){

    }





}
