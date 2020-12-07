package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newTask implements ActionListener {

    private static volatile newTask soloNewTask = new newTask();
    static Users.addedMembers AddedMembers = Users.addedMembers.getInstance();
    static Projects.allProjects allProjects = Projects.allProjects.getInstance();




    JFrame frame;
    JComboBox chooseProjectName;
    JTextPane displayTasks;
    StringBuffer allTasks = new StringBuffer();


    public newTask() {

    }
    public static newTask getInstance(){
        if(soloNewTask == null){
            soloNewTask = new newTask();
        }
        return soloNewTask;
    }
    public void assignTask(){

        frame = new JFrame("Assigning tasks");

        JLabel projectName = new JLabel("Choose project name:");
        projectName.setBounds(20,20,150,30);
        projectName.setForeground(Color.black);

        ArrayList<String> projectNames = soloNewTask.getAllProjectNames();
        String[] projectNamesArray = projectNames.toArray(new String[0]);
        chooseProjectName = new JComboBox(projectNamesArray);
        chooseProjectName.setBounds(180,20,90,20);

        JButton okButton = new JButton("ok");
        okButton.setBounds(290,20,70,30);
        Color lightGreen = new Color(153, 206, 143);
        okButton.setBackground(lightGreen);
        okButton.addActionListener(this);

        JLabel numberOfTasks = new JLabel("Tasks in project:");
        numberOfTasks.setBounds(20,75,120,30);
        numberOfTasks.setForeground(Color.black);

        displayTasks = new JTextPane();
        displayTasks.setBounds(20,100,150,150);
        displayTasks.setForeground(Color.black);

        JLabel chooseMilestone = new JLabel("Choose milestone:");
        chooseMilestone.setBounds(20,250,120,30);
        chooseMilestone.setForeground(Color.black);

        JTextField milestoneChosen = new JTextField();
        milestoneChosen.setBounds(180,250,120,30);

        JLabel chooseTask = new JLabel("Choose task:");
        chooseTask.setBounds(20,300,120,30);
        chooseTask.setForeground(Color.black);

        JTextField taskChosen = new JTextField();
        taskChosen.setBounds(180,300,120,30);

        JLabel assignMember = new JLabel("Member assigned:");
        assignMember.setBounds(20,350,120,30);
        assignMember.setForeground(Color.black);

        JTextField memberAssigned = new JTextField();
        memberAssigned.setBounds(180,350,120,30);

        JButton assignTaskButton = new JButton("Assign task");
        assignTaskButton.setBounds(100,400,120,30);
        assignTaskButton.setBackground(lightGreen);

        frame.add(projectName); frame.add(chooseProjectName); frame.add(okButton);
        frame.add(numberOfTasks); frame.add(displayTasks);frame.add(chooseMilestone);frame.add(milestoneChosen);frame.add(chooseTask); frame.add(taskChosen);
        frame.add(assignMember);
        frame.add(memberAssigned);
        frame.add(assignTaskButton);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Color lightBlue = new Color(179,229,252);
        frame.getContentPane().setBackground(lightBlue);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    public void actionPerformed(ActionEvent event) {
        String chosenProject = (String) chooseProjectName.getItemAt(chooseProjectName.getSelectedIndex());
        String[][] allProjectTasks;
        ArrayList<Projects.Project>searchList = allProjects.getAllProjects();
        int position;
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getProjectName() != null && searchList.get(i).getProjectName().equals(chosenProject)) {
                position = i;
                allProjectTasks = searchList.get(position).getTasks();
                for(int k = 0;k<allProjectTasks.length;k++){
                    allTasks.append(allProjectTasks[i][0]);
                    allTasks.append(" ");
                    allTasks.append(allProjectTasks[i][1]);
                    allTasks.append("\n");

                }
                String tasksAndMilestones = allTasks.toString();
                displayTasks.setText(tasksAndMilestones);
            }else{
                System.out.println("No tasks registered");
            }
        }
    }

    public boolean findMember(String memberUsername){
        boolean assignTask = false;
        ArrayList<Users.createMember> allMembers = AddedMembers.getAllMembers();

        for (Users.createMember allMember : allMembers) {
            if (allMember.getUsername() != null && allMember.getUsername().equals(memberUsername)) {
                assignTask = true;
                break;
            }
        }
        return assignTask;
    }
    public ArrayList<String> getAllProjectNames(){
        ArrayList<Projects.Project> projects = allProjects.getAllProjects();
        ArrayList<String> allProjectNames = new ArrayList<>();

        for (Projects.Project project : projects) {
            String projectName = project.getProjectName();
            allProjectNames.add(projectName);
        }
        return allProjectNames;
    }

    public static void main(String[] args){
        newTask newTask = new newTask();
        newTask.assignTask();
    }
}

