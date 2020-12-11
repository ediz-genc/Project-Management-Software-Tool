package Users;

import Menus.ownerMenu;
import Tools.randomID;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Member {

    randomID randID = randomID.getInstance();

    private String name;
    private String username;
    private String password;
    private int level;
    private int memberKey;
    private String grantedAccess;

    public Member (String name, String username, String password, int level){
        this.name = name;
        this.username=username;
        this.password=password;
        this.level=level;
        this.memberKey = randID.getRandom();
        this.grantedAccess = "access not granted";
    }

    public Member() {
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getMemberKey() {
        return memberKey;
    }

    public String getGrantedAccess() { return grantedAccess; }

    public void setGrantedAccess(String grantedAccess) { this.grantedAccess = grantedAccess; }

}
