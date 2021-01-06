package Projects;
import Tools.InputClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class myTasksInterface {
    static InputClass printOutput = new InputClass();
    StringBuilder displayTasks = new StringBuilder();
    static allAssignedTasks AllAssignedTasks = allAssignedTasks.getInstance();
    JTextArea tasksDisplay;

    public myTasksInterface(){

    }
    public void viewMyTasks(){
        String username = printOutput.readLine("Please type your username:");
        ArrayList<assignedTask> searchList = AllAssignedTasks.getAssignedTasks();
        int position;
        for(int i = 0; i< searchList.size();i++){
            if(searchList.get(i).getMemberAssigned() != null && searchList.get(i).getMemberAssigned().equals(username)){
                position = i;

                displayTasks.setLength(0);
                displayTasks.append("Project name: ").append(searchList.get(position).getProjectName());
                displayTasks.append("\n");
                displayTasks.append("Milestone: ").append(searchList.get(position).getMilestoneName());
                displayTasks.append("\n");
                displayTasks.append("Task description: ").append(searchList.get(position).getTaskDescription()).append("\n");
                displayTasks.append("\n");

                String myTasks = displayTasks.toString();
                tasksDisplay = new JTextArea(10,15);
                tasksDisplay.setText(myTasks);
            }
        }
        JFrame frame = new JFrame();
        JScrollPane scrollableTaskDisplay = new JScrollPane(tasksDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(tasksDisplay);
        frame.add(scrollableTaskDisplay);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.setVisible(true);

    }
}
