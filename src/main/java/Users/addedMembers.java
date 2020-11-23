package Users;

import java.util.ArrayList;

public class addedMembers {

    private static volatile addedMembers soloAddedMembers = new addedMembers();
    private ArrayList<createMember> allMembers = new ArrayList<createMember>();


    private addedMembers() {
    }

    public static addedMembers getInstance() {
        if (soloAddedMembers == null) {
            soloAddedMembers = new addedMembers();
        }
        return soloAddedMembers;
    }


    public void addMember(Object o) {

        allMembers.add((createMember) o);

    }

    public int findMember(String username, String password) {

        int valid = 0;
        int searchListLength = allMembers.size();

        for (int i = 0; i < searchListLength; i++) {
            if (allMembers.get(i).getUsername()!=null && allMembers.get(i).getUsername().equals(username) &&
                    allMembers.get(i).getPassword().equals(password)) {
                valid = allMembers.get(i).getLevel();
                break;

            }
        }
        return valid;
    }
}