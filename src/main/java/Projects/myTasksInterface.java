package Projects;
import Tools.InputClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class myTasksInterface {
    static InputClass printOutput = new InputClass();
    StringBuilder displayTasks = new StringBuilder();

    public myTasksInterface(){

    }
    public void viewMyTasks(){
        String username = printOutput.readLine("Please type your username:");
        ArrayList<assignedTask> searchList = assignedTask.allAssignedTasks.getInstance().getAssignedTasks();
        int position;
        for(int i = 0; i< searchList.size();i++){
            if(searchList.get(i).getMemberAssigned() != null && searchList.get(i).getMemberAssigned().equals(username)){
                position = i;

                displayTasks.append("Project name: ").append(searchList.get(position).getProjectName()).append("\n");
                displayTasks.append("\n");
                displayTasks.append(searchList.get(position).getMilestoneName());
                displayTasks.append("\n");
                displayTasks.append(searchList.get(position).getTaskDescription());

                String myTasks = displayTasks.toString();
                JFrame frame = new JFrame();

                JLabel tasksDisplay = new JLabel();
                tasksDisplay.setSize(150,150);
                tasksDisplay.setText(myTasks);

                frame.add(tasksDisplay);
                frame.setLayout(new GridLayout());
                frame.setSize(500,500);
                frame.setVisible(true);
            }
        }

    }
}
