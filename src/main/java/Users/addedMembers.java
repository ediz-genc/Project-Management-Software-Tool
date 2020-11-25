package Users;

import java.util.ArrayList;

public class addedMembers {

    private static volatile addedMembers soloAddedMembers = new addedMembers();

    private ArrayList<createMember> allMembers;
    private String memberRole;
    private String memberName;
    private String activeUser;

    public addedMembers(ArrayList<createMember> allMembers, String memberName, String memberRole) {
        this.allMembers = new ArrayList();
        this.memberName = memberName;
        this.memberRole = memberRole;
    }

    public addedMembers() {
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

    public ArrayList<createMember> getAllMembers(){
        return allMembers;
    }
    public String getMemberName(){
        return memberName;
    }
    public String getMemberRole(){
        return memberRole;
    }
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    public void setMemberRole(String memberRole){
        this.memberRole = memberRole;
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


    public void setActiveUser(String userName){this.activeUser=userName;}

    public String getActiveUser(){return activeUser;}

    public String getUserKey(String userName){

        int tempKey=0; boolean found = false; String key;

        for(int i=0; i< allMembers.size();i++){
            if(allMembers.get(i).getUsername()!=null &&
                    allMembers.get(i).getUsername().equals(userName)){
                tempKey = allMembers.get(i).getMemberKey();
                found = true;
                break;
            }
        }

        if(found){
             key = String.valueOf(tempKey);
        } else {
             key = "Key not found";
        }
        return key;
    }
}