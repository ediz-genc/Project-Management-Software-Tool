package Users;

import Tools.InputClass;

import java.util.ArrayList;

public class allMessages {
    private ArrayList<Message> allMessages = new ArrayList<>();
    private static volatile allMessages soloAllMessages = new allMessages();
    static addedMembers AddedMembers = addedMembers.getInstance();
    static InputClass printOutput = new InputClass();

    private allMessages(){

    }
    public static allMessages getInstance(){
        if(soloAllMessages == null){
            soloAllMessages = new allMessages();
        }
        return soloAllMessages;
    }
    public ArrayList<Message> getAllMessages(){
        return allMessages;
    }
    public void sendMessage() {
        String Sender = printOutput.readLine("Please enter your username: ");
        String Receiver = printOutput.readLine("Please enter receiver username: ");
        String Status = "Unread";
        ArrayList<Member> allMembers = AddedMembers.getAllMembers();

        for (Member member : allMembers){
            if (member.getUsername() != null && member.getUsername().equals(Receiver)) {
                String Content = printOutput.readLine("Please enter message content: ");
                Message newMessage = new Message(Sender, Receiver, Content, Status);
                allMessages.add(newMessage);
                printOutput.printLine("Your message has been sent!");
            } else {
                printOutput.printLine("Receiver not found");
            }
        }
    }
    public void readMessage(){
        String username = printOutput.readLine("Please enter your username: ");
        for(Message message: allMessages){
            if(message.getReceiver().equals(username) && message.getStatus().equals("Unread")){
                printOutput.printLine("New messages: ");
                printOutput.printLine("From " + message.getSender() + ":");
                printOutput.printLine(message.getContent());
                message.changeStatus();
            }else if (message.getReceiver().equals(username) && message.getStatus().equals("Read")){
                printOutput.printLine("Read messages: ");
                printOutput.printLine("From " + message.getSender() + ":");
                printOutput.printLine(message.getContent());
            }else{
                printOutput.printLine("No new messages");
            }
        }
    }
}
