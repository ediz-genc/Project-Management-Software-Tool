package Menus;

import Projects.Project;
import Tools.InputClass;
import Projects.Project;
import Users.addedMembers;
import Projects.allProjects;

public class managerMenu {

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();

    public void menu(){

        int option = 0;

        printOutput.readInt("\nWelcome to the Manager Menu!\n1. Open assigned projects\n2. Explore Projects\n" +
                "3. Return to menu");

        while(!(option ==3)) {
            switch(option){
                case 1:
                    menuDirectory(option);
                    break;
                case 2:
                    menuDirectory(option);
                    break;
                case 3:
                    return;
                default:
                    printOutput.printLine("Invalid input");

            }
        }
    }

    void menuDirectory(int caseNumber){

        switch(caseNumber){

            case 1:
                String activeUser = addedmembers.getActiveUser();
                int managerKey = addedmembers.getUserKey(activeUser);
                Object Project = allprojects.getManagerProject(managerKey);
                openProject((Projects.Project) Project);
                break;
            case 2:
                break;


        }
    }


    void openProject(Project Project ){




    }

}
