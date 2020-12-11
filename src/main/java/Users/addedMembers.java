package Users;

import java.util.ArrayList;

public class addedMembers {

    private static volatile addedMembers soloAddedMembers = new addedMembers();

    private final ArrayList<Member> allMembers = new ArrayList<>();
    private String memberRole;
    private String memberName;
    private String activeUser;



    public addedMembers() {
    }

    public static addedMembers getInstance() {
        if (soloAddedMembers == null) {
            soloAddedMembers = new addedMembers();
        }
        return soloAddedMembers;
    }


    public void addMember(Object o) {

        allMembers.add((Member) o);

    }

    public ArrayList<Member> getAllMembers(){
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
    public boolean findMember(String memberUsername){
        boolean assignTask = false;

        for (Member allMember : allMembers) {
            if (allMember.getUsername() != null && allMember.getUsername().equals(memberUsername)) {
                assignTask = true;
                break;
            }
        }
        return assignTask;
    }


    public void setActiveUser(String userName){this.activeUser=userName;}

    public String getActiveUser(){return activeUser;}

    public int getUserKey(String userName){

        int tempKey=0; boolean found = false; int key = 0;

        for(int i=0; i< allMembers.size();i++){
            if(allMembers.get(i).getUsername()!=null &&
                    allMembers.get(i).getUsername().equals(userName)){
                key = allMembers.get(i).getMemberKey();
                found = true;
                break;
            }
        }


        return key;
    }
}