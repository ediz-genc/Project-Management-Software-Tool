package Mainclasses;

import Import_Export.importAndExportSavedInfo;
import Projects.allProjects;
import Users.Member;
import Users.addedMembers;


import java.io.IOException;
import java.util.ArrayList;
import Tools.randomID;



public class EFICAZ {

    static importAndExportSavedInfo io = new importAndExportSavedInfo();
    static allProjects allprojects = allProjects.getInstance();
    static addedMembers allMembers = addedMembers.getInstance();
    static randomID random = randomID.getInstance();


    public static void main(String[] args) throws IOException {
       random.generate();


       io.loadUser();
       io.loadProject();
       io.loadMessages();
       io.loadAssignedTasks();


       startApp start = new startApp();
       start.run();

    }

}