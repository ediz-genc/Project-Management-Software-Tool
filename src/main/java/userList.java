

public class userList {

    private final String[][] userList;
    private static volatile userList exclusiveUserList = new userList();


    public userList() {

        this.userList = new String[10000][4];
    }
    public static userList getInstance(){
        if(exclusiveUserList == null){
            exclusiveUserList = new userList();
        }
        return exclusiveUserList;
    }
    public String[][] getList() {

        return this.userList;
    }
    public void regUser(String Authority, String Username, String Name, String Password) {
        for (int i = 0; i < userList.length; i++) {

            if (userList[i][0] == null) {
                int j = 0;
                this.userList[i][j] = Authority;
                j++;
                this.userList[i][j] = Username;
                j++;
                this.userList[i][j] = Name;
                j++;
                this.userList[i][j] = Password;
                break;

            }
        }
    }
    public boolean passwordCheck(String userName, String passWord) {

        boolean safe = false;

        for(int i=0;i< userList.length;i++) {
            if (userList[i][0]!=null && userName.equals(userList[i][1]) && passWord.equals(userList[i][3])){
                int tempPosition = i;
                safe = true;

            }
        }
        return safe;
    }
}