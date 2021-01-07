package Users;

import Tools.InputClass;

import java.util.ArrayList;

public class allMessages {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
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
        boolean sent = false;

        for (Member member : allMembers){
            if (member.getUsername() != null && member.getUsername().equals(Receiver)) {
                String Content = printOutput.readLine("Type message: ");
                Message newMessage = new Message(Sender, Receiver, Content, Status);
                allMessages.add(newMessage);
                printOutput.printLine(ANSI_GREEN+"Your message has been sent!"+ANSI_RESET);
                sent = true;
            }
        }
        if(!sent){
            printOutput.printLine(ANSI_RED+"\nReceiver not found"+ANSI_RESET);
        }
    }
    public void readMessage(){
        String username = printOutput.readLine("Please enter your username: ");
        boolean received = false;
        for(Message message: allMessages){
            if(message.getReceiver() != null && message.getReceiver().equals(username) && message.getStatus().equals("Unread")){
                received = true;
                printOutput.printLine("New messages: ");
                printOutput.printLine("From " + message.getSender() + ":");
                printOutput.printLine(message.getContent());
                message.changeStatus();
            }
        }
        if(!received){
            printOutput.printLine("No new messages");
        }
    }
    public void loadFromFile(ArrayList<Message> savedMessages){
        this.allMessages = savedMessages;
    }
}
