

public class EFICAZ {


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

    public static void main(String[] args) {

        String choices = "1";
        String choices1;



        while(!choices.equals("4")){
            System.out.println(ANSI_WHITE + "\n\nWelcome to EFICAZ! The one and only Project Management Tool right now.\n" + ANSI_RESET);


            choices = printOutput.readLine(ANSI_CYAN + "Insert a number between 1-3 and then hit `Enter´:\n\n1. Login\n2. New User? Register now!\n3. Exit program\n\n"  + ANSI_RESET);
            int levelCheck;

            switch (choices) {
                case "1":
                    String userName = printOutput.readLine("Username: ");
                    String passWord = printOutput.readLine("Password: ");
                    levelCheck = addedmembers.findMember(userName,passWord);
                    if(levelCheck > 0){
                        printOutput.printLine("Welcome!");
                        menuDirectory(levelCheck);
                    } else {
                        printOutput.printLine("Invalid login information");
                    }

                    break;
                case "2":
                    newUser();
                    printOutput.printLine("Your account was succesfully added");
                    break;
                case "3": {
                    printOutput.printLine("\nThank you for using EFICAZ.\nSee you next time!");
                    System.exit(0);
                }
                default:
                    printOutput.printLine("Wrong input, try again:\n");
            }

            }
    }

    static void newUser(){

        String name = printOutput.readLine("Whats your name?");
        String userName = printOutput.readLine("Create a new username...");
        String pass = printOutput.readLine("Create a password...");
        String level = printOutput.readLine("Whats your profession? Choose from the options below.\n\n" +
                "1. Project owner\n2. Project manager\n3.Developer/Designer (Enter 1-3 depending on your profession)\n\n");

        int convertedLevel = Integer.parseInt(level);

        createMember createMember = new createMember(name,userName,pass,convertedLevel);
        addedmembers.addMember(createMember);



    }


    static void menuDirectory(int level){

        switch(level){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }


    }
}





