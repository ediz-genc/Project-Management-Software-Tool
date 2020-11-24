public class task {
//Task attributes
    private String senderUsername;
    private String receiverUsername;
    private String projectName;
    private String projectDescription;

    public task(String senderUsername,String receiverUsername,String projectName,String projectDescription){

        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public String getSenderUsername(){
        return senderUsername;
    }
    public String getReceiverUsername(){
        return receiverUsername;
    }

    public String getProjectName(){
        return projectName;
    }

    public String getProjectDescription(){
        return projectDescription;
    }

}
