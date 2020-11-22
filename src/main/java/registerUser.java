

public class registerUser {
    static InputClass printOutput = new InputClass();
    static users UserList = users.getInstance();


    public static void selectPosition(int type){

        String position = null;

        switch (type){
            case 1:
                position = "Project Owner";
                regUser(position);
                break;
            case 2:
                position = "Project Manager";
                regUser(position);
                break;
            case 3:
                position = "Software developer/Interface designer";
                regUser(position);
                break;

        }
    }
    public static void regUser(String position){
        int j = 0;

        String[] tempList = new String[4];
        tempList[j] = position;
        printOutput.printLine("Position: " + tempList[j]);
        j++;
        tempList[j] = printOutput.readLine("Username: ");
        j++;
        tempList[j] = printOutput.readLine("Name: ");
        j++;
        tempList[j] = printOutput.readLine("Password: ");
        j=0;
        //printOutput.readLine("Enter same Password again: ");

        UserList.regUser(tempList[j], tempList[j + 1], tempList[j + 2], tempList[j + 3]);
        printOutput.printLine("\nYour account has successfully been created. Enjoy!\nTaking you back to the main menu...");




    }

}
