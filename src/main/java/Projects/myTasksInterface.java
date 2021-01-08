package Projects;
import Users.addedMembers;
import Users.Member;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class myTasksInterface {
    StringBuilder displayTasks = new StringBuilder();
    static allAssignedTasks AllAssignedTasks = allAssignedTasks.getInstance();
    static Users.addedMembers AddedMembers = addedMembers.getInstance();
    JTextArea tasksDisplay;

    public myTasksInterface(){

    }
    public void viewMyTasks(){
        String username = findUserNameByKey();
        ArrayList<assignedTask> searchList = AllAssignedTasks.getAssignedTasks();
        int position;
        for(int i = 0; i< searchList.size();i++){
            if(searchList.get(i).getMemberAssigned() != null && searchList.get(i).getMemberAssigned().equals(username)){
                position = i;

                displayTasks.append("Project name: ").append(searchList.get(position).getProjectName());
                displayTasks.append("\n");
                displayTasks.append("Milestone: ").append(searchList.get(position).getMilestoneName());
                displayTasks.append("\n");
                displayTasks.append("Task description: ").append(searchList.get(position).getTaskDescription()).append("\n");
                displayTasks.append("\n");

                String myTasks = displayTasks.toString();
                tasksDisplay = new JTextArea(20,15);
                tasksDisplay.setText(myTasks);
            }
        }
        displayTasks.setLength(0);
        JFrame frame = new JFrame();
        JScrollPane scrollableTaskDisplay = new JScrollPane(tasksDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(tasksDisplay);
        frame.add(scrollableTaskDisplay);
        frame.getContentPane().setLayout(new FlowLayout());
        Color lightBlue = new Color(179,229,252);
        frame.getContentPane().setBackground(lightBlue);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
    public String findUserNameByKey(){
        String activeUser = AddedMembers.getActiveUser();
        int key = AddedMembers.getUserKey(activeUser);
        String username = "";
        ArrayList<Member> allMembers = AddedMembers.getAllMembers();
        for(Member member: allMembers){
            if(member.getMemberKey() == key){
                username = member.getUsername();
            }
        }
        return username;
    }
}
