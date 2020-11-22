public class managerMenu {

    static InputClass printOutput = new InputClass();

    void menu(){

        printOutput.printLine("Welcome!\n\n Here you can start on a new project or open existing ones.\n" +
                "Choose a option below.\n");
        String option = printOutput.readLine("1. Open project\n2. Create new Project\n3. Delete/archive project\n");
        int convertedOption = Integer.parseInt(option);
        switch(convertedOption){
            case 1:
                newProject();
                printOutput.printLine("to be continued...");
                break;
            case 2:
                printOutput.printLine("to be continued...");

                break;
            case 3:
                printOutput.printLine("to be continued...");

                break;
        }



    }

    void newProject(){

        String projectName = printOutput.readLine("Name: ");
        String weeks = printOutput.readLine("The amount of weeks project will take: ");

        int convertedWeeks = Integer.parseInt(weeks);
        createProject CreateProject = new createProject(projectName,convertedWeeks);




    }
}
