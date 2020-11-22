

public class EFICAZ {

    static InputClass printOutput = new InputClass();
    static registerUser rU = new registerUser();
    static currentUsers tU = new currentUsers();
    static users us = users.getInstance();

    public static void main(String[] args) {

        String choices = "1";
        String choices1;


        while(!choices.equals("4")){
            System.out.println("\n\nWelcome to EFICAZ! The one and only Project Management Tool right now.\n");

            choices = printOutput.readLine("Insert a number between 1-3 and then hit `Enter´:\n\n1. Login\n2. New User? Register now!\n3. Exit program");


            switch (choices) {
                case "1":
                    String userName = printOutput.readLine("Username: ");
                    String passWord = printOutput.readLine("Password: ");
                    boolean credCheck = us.passwordCheck(userName, passWord);

                    if (credCheck==true){

                        printOutput.printLine("\n\nWelcome " + userName +"!\n");
                        tU.currUserMenu(userName);
                    } else {
                        printOutput.printLine("Invalid Username or Password.");
                    }
                    break;
                case "2":
                        choices1 = printOutput.readLine("Choose your position: (Insert a number between 1-3 and then hit `Enter´)\n(Press `X´ to go back)\n\n1. Project Owner \n2. Project Manager\n3. Software developer/Interface designer\n");
                        switch (choices1) {
                        case "1":
                            rU.selectPosition(1);
                            break;
                        case "2":
                            rU.selectPosition(2);
                            break;
                        case "3":
                            rU.selectPosition(3);
                            break;
                        case "X":
                            return;
                        default:
                            printOutput.printLine("Invalid input, try again");

                        }
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
}





