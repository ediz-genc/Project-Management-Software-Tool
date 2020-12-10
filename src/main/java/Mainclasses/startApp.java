package Mainclasses;

import Menus.developerMenu;
import Tools.InputClass;
import Tools.randomID;
import Users.addedMembers;
import Users.createMember;
import Menus.ownerMenu;
import Menus.managerMenu;

public class startApp {


    static InputClass printOutput = new InputClass();


    static addedMembers addedmembers = addedMembers.getInstance();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static randomID randID = randomID.getInstance();


    public void run(){


        randID.generate();

        String choices = "1";
        String choices1;


        while (!choices.equals("4")) {
            System.out.println(ANSI_WHITE + "\n\nWelcome to EFICAZ! The one and only Project Management Tool right now.\n" + ANSI_RESET);

            choices = printOutput.readLine(ANSI_CYAN + "Insert a number between 1-3 and then hit `Enter´:\n\n1. Login\n2. New User? Register now!\n3. Exit program\n\n" + ANSI_RESET);
            int levelCheck;

            switch (choices) {
                case "1":
                    String userName = printOutput.readLine("Username: ");
                    String passWord = printOutput.readLine("Password: ");
                    levelCheck = addedmembers.findMember(userName, passWord);
                    if (levelCheck > 0) {
                        printOutput.printLine("Welcome!");
                        addedmembers.setActiveUser(userName);
                        menuDirectory(levelCheck);
                    } else {
                        printOutput.printLine("Invalid login information. Please try again!");
                    }
                    break;
                case "2":
                    newUser();
                    printOutput.printLine("Your account was successfully added");
                    break;
                case "3": {
                    printOutput.printLine("\nThank you for using Mainclasses.EFICAZ.\nSee you next time!");
                    System.exit(0);
                }
                default:
                    printOutput.printLine("Wrong input, try again:\n");
            }

        }
    }
    public void newUser(){

        String name = printOutput.readLine("Enter your full name: ");
        String userName = printOutput.readLine("Create a username: ");
        String pass = printOutput.readLine("Create a password: ");

        int level = printOutput.readInt("\nWhats your profession? Choose from the options below.\n\n" +
                "1. Project owner\n2. Project manager\n3. Developer/Designer\n(Enter 1-3 depending on your profession)\n\n");


        createMember createMember = new createMember(name, userName, pass, level);
        addedmembers.addMember(createMember);

    }
    public void menuDirectory(int level){

         switch (level) {
             case 1:
                 /*printOutput.printLine ("\nPlease wait...\n\nWelcome to the project owner menu");*/
                 ownerMenu oM = new ownerMenu();
                 oM.menu();
                 break;

             case 2:
                 /*printOutput.printLine ("\nPlease wait...\n\nWelcome to the project manager menu");*/
                 managerMenu mM = new managerMenu();
                 mM.menu();
                 break;
             case 3:
                 /*printOutput.printLine ("\nPlease wait...\n\nWelcome to the worker menu");*/
                 developerMenu wM = new developerMenu();
                 wM.menu();
                 break;
         }
    }
}

