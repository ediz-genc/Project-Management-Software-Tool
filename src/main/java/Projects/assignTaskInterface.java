package Projects;

import Users.Member;
import Users.addedMembers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class assignTaskInterface {

    private static volatile assignTaskInterface soloNewTask = new assignTaskInterface();
    static Users.addedMembers AddedMembers = addedMembers.getInstance();
    static Projects.allProjects allProjects = Projects.allProjects.getInstance();





    JFrame frame;
    JComboBox chooseProjectName;
    JTextField milestoneChosen;
    JTextField taskChosen;
    JTextField memberAssigned;
    JTextPane displayTasks;
    StringBuffer allTasks = new StringBuffer();


    public assignTaskInterface() {

    }
    public static assignTaskInterface getInstance(){
        if(soloNewTask == null){
            soloNewTask = new assignTaskInterface();
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
        okButton.addActionListener(new okButtonListener());

        JLabel numberOfTasks = new JLabel("Tasks in project:");
        numberOfTasks.setBounds(20,75,120,30);
        numberOfTasks.setForeground(Color.black);

        displayTasks = new JTextPane();
        displayTasks.setBounds(20,100,150,150);
        displayTasks.setForeground(Color.black);

        JLabel chooseMilestone = new JLabel("Choose milestone:");
        chooseMilestone.setBounds(20,250,120,30);
        chooseMilestone.setForeground(Color.black);

        milestoneChosen = new JTextField();
        milestoneChosen.setBounds(180,250,120,30);

        JLabel chooseTask = new JLabel("Choose task:");
        chooseTask.setBounds(20,300,120,30);
        chooseTask.setForeground(Color.black);

        taskChosen = new JTextField();
        taskChosen.setBounds(180,300,120,30);

        JLabel assignMember = new JLabel("Member assigned:");
        assignMember.setBounds(20,350,120,30);
        assignMember.setForeground(Color.black);

        memberAssigned = new JTextField();
        memberAssigned.setBounds(180,350,120,30);

        JButton assignTaskButton = new JButton("Assign task");
        assignTaskButton.setBounds(100,400,120,30);
        assignTaskButton.setBackground(lightGreen);
        assignTaskButton.addActionListener(new assignTaskButtonListener());

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

    class okButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            String chosenProject = (String) chooseProjectName.getItemAt(chooseProjectName.getSelectedIndex());
            ArrayList<Projects.task> allProjectTasks;
            ArrayList<Projects.Project> searchList = allProjects.getAllProjects();
            int position;
            for (int i = 0; i < searchList.size(); i++) {
                if (searchList.get(i).getProjectName() != null && searchList.get(i).getProjectName().equals(chosenProject)) {
                    position = i;
                    allProjectTasks = searchList.get(position).getTasks();
                    System.out.println(allProjectTasks.get(position).getTaskDescription());
                    for(task Task:allProjectTasks){
                        allTasks.append(Task.getProjectMilestones());
                        allTasks.append(" ");
                        allTasks.append(Task.getTaskDescription());
                        allTasks.append("\n");

                    }
                    String tasksAndMilestones = allTasks.toString();
                    displayTasks.setText(tasksAndMilestones);
                }else{
                    System.out.println("Project not found");
                }
            }
        }

    }
    class assignTaskButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String memberUsername = memberAssigned.getText();
            boolean memberFound = AddedMembers.findMember(memberUsername);
            if(memberFound){
                String projectName = (String) chooseProjectName.getItemAt(chooseProjectName.getSelectedIndex());
                String chosenMilestone = milestoneChosen.getText();
                String chosenTask = taskChosen.getText();
                ArrayList<assignedTask> allAssignedTasks = assignedTask.allAssignedTasks.getInstance().getAssignedTasks();
                assignedTask assignedTask = new assignedTask(projectName,chosenMilestone,chosenTask,memberUsername);
                allAssignedTasks.add(assignedTask);
                frame.setVisible(false);

            }else{
                System.out.println("Not found");
            }
        }
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
        assignTaskInterface newTask = new assignTaskInterface();
        newTask.assignTask();
    }
}
