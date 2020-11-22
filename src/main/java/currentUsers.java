

public class currentUsers {

    static InputClass printOutput = new InputClass();
    static userList uList = userList.getInstance();
    static String tempU; int tempPosition;

    public static void currUserMenu(String userName){
        tempU = userName;

        String choices2 = "0";

        while (!choices2.equals("2")){
            choices2 = printOutput.readLine("Press `X` to go back\nPress 1. to test your account.");
            switch (choices2){
                case "1":
                    System.out.println("test");
                    break;
                case "X":
                return;

            }
        }

    }
    public boolean passwordCheck(String userName, String passWord){

        String[][] checkList = uList.getList();
        boolean safe = false;

        for(int i=0;i< checkList.length;i++) {
            if (checkList[i][1]!=null && userName.equals(checkList[i][1]) && passWord.equals(checkList[i][3])){
                tempPosition = i;
                safe = true;

            }
        }
        return safe;
    }
}
