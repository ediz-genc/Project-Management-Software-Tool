package Mainclasses;

import Import_Export.importSavedInfo;

import java.io.IOException;

public class EFICAZ {

    static importSavedInfo io = new importSavedInfo();


    public static void main(String[] args) throws IOException {

       io.loadUser();

       startApp start = new startApp();
       start.run();

    }

}