package Menus;

import Tools.InputClass;
import Projects.myTasksInterface;

public class developerMenu {
    static InputClass printOutput = new InputClass();
    static myTasksInterface myTasksInterface = new myTasksInterface();
    public void menu(){

        int option = 0;
        while (option != 4) {

            printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                    "Choose a option below.\n");
            option = printOutput.readInt("1. View my tasks\n2. Add new task to existing project\n3. Delete/archive project\n4. Return to main menu\n");
            switch (option) {
                case 1:
                    printOutput.printLine("to be continued...");
                    myTasksInterface.viewMyTasks();
                    break;
                case 2:
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

}
