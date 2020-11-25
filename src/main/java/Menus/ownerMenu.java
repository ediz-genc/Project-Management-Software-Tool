package Menus;

import Tools.randomID;
import Tools.InputClass;
import Projects.createProject;
import Users.addedMembers;
import Projects.allProjects;



public class ownerMenu {

    static InputClass printOutput = new InputClass();
    static addedMembers addedmember = addedMembers.getInstance();
    static allProjects allprojects = allProjects.getInstance();


   public void menu(){

       int option=0;

       while(option!=4) {

           printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                   "Choose a option below.\n");
           option = printOutput.readInt("1. Open project\n2. Create new Project\n3. Delete/archive project\n4. Return to main menu\n");
           switch (option) {
               case 1:
                   printOutput.printLine("to be continued...");
                   break;
               case 2:
                   newProject();

                   printOutput.printLine("to be continued...");

                   break;
               case 3:
                   printOutput.printLine("to be continued...");
                   break;
               case 4:
                   return;
               default:
                   printOutput.printLine("Invalid input");
           }
       }


    }

    void newProject(){

        String projectName = printOutput.readLine("Name: ");
        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        int milestones = printOutput.readInt("What's the estimated number of milestones in the project? ");
        int tasks = printOutput.readInt("How many inclusive task will each milestone have in average? ");

        String tempUser = addedmember.getActiveUser();
        String key = addedmember.getUserKey(tempUser);
        int projectOwnerKey = Integer.parseInt(key);


        createProject newProject = new createProject(projectName,weeks, milestones, tasks,projectOwnerKey);
        allprojects.addProject(newProject);




    }

    void openProject(){






    }
}
