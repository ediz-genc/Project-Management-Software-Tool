public class createMember {

    private String name;
    private String username;
    private String password;
    private int level;

    public createMember(String name, String username, String password, int level){
        this.name =name;
        this.username=username;
        this.password=password;
        this.level=level;
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
}
