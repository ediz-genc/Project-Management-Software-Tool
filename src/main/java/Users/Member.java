package Users;

import Menus.ownerMenu;
import Tools.randomID;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Member {

    randomID randID = randomID.getInstance();

    private final String name;
    private final String username;
    private final String password;
    private final int level;
    private final int memberKey;

    public Member(String name, String username, String password, int level){
        this.name = name;
        this.username=username;
        this.password=password;
        this.level=level;
        this.memberKey = randID.getRandom();

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
}
