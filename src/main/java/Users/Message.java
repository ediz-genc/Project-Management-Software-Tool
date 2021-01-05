package Users;

public class Message {
    private String Sender;
    private String Receiver;
    private String Content;
    private String Status;

    public Message(String Sender, String Receiver, String Content, String Status){
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.Content = Content;
        this.Status = Status;
    }
    public String getSender() {
        return Sender;
    }
    public String getReceiver() {
        return Receiver;
    }
    public String getContent(){
        return Content;
    }
    public String getStatus(){
        return Status;
    }
    public String changeStatus(){
        this.Status = "Read";
        return Status;
    }
}
