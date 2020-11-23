public class ownerMenu {

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
        int weeks = printOutput.readInt("The amount of weeks project will take: ");
        printOutput.printLine("\nThe coming questions are just your own projected estimated project details. " +
                "\nThey can be changed moving forward");

        int milestones = printOutput.readInt("What's the estimated milestones of the project? ");
        int tasks = printOutput.readInt("How many inclusive task will each milestone have in average? ");




        createProject newProject = new createProject(projectName,weeks, milestones, tasks);




    }
}
