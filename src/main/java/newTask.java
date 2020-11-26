import Projects.task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newTask implements ActionListener {

    private static volatile newTask soloNewTask = new newTask();
    static Users.addedMembers AddedMembers = Users.addedMembers.getInstance();
    public final ArrayList<task> tasks = new ArrayList<>();

    JFrame frame;
    JTextField writeUsername;
    JTextField memberAssigned;
    JTextField nameOfProject;
    JTextArea taskSummary;
    JLabel message;

    private newTask() {

    }
    public static newTask getInstance(){
        if(soloNewTask == null){
            soloNewTask = new newTask();
        }
        return soloNewTask;
    }
    public void assignTask(){

        frame = new JFrame("Assigning tasks");

        JLabel yourUsername = new JLabel("Your username:");
        yourUsername.setBounds(20,20,120,30);
        yourUsername.setForeground(Color.white);

        JLabel receiverUsername = new JLabel("Member assigned:");
        receiverUsername.setBounds(20,75,120,30);
        receiverUsername.setForeground(Color.white);

        JLabel projectName = new JLabel("Project name:");
        projectName.setBounds(20,130,120,30);
        projectName.setForeground(Color.white);

        JLabel taskDescription = new JLabel("Task description:");
        taskDescription.setBounds(20,185,120,30);
        taskDescription.setForeground(Color.white);

        writeUsername = new JTextField();
        writeUsername.setBounds(180,20,100,30);

        memberAssigned = new JTextField();
        memberAssigned.setBounds(180,75,100,30);

        nameOfProject = new JTextField();
        nameOfProject.setBounds(180,130,100,30);

        taskSummary = new JTextArea();
        taskSummary.setBounds(180,185,150,150);

        JButton assignNewTask = new JButton("Assign Projects.task");
        assignNewTask.setBounds(30, 260,130,30);
        Color darkGreen = new Color(85,139,47);
        assignNewTask.setFont(new Font("SansSerif", Font.BOLD, 14));
        assignNewTask.setBackground(darkGreen);
        assignNewTask.addActionListener(this);

        message = new JLabel();
        message.setBounds(30,300,120,30);
        message.setForeground(Color.white);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color darkBlue = new Color(40, 96, 134);
        frame.getContentPane().setBackground(darkBlue);

        frame.add(yourUsername);
        frame.add(receiverUsername);
        frame.add(projectName);
        frame.add(taskDescription);
        frame.add(writeUsername);
        frame.add(memberAssigned);
        frame.add(nameOfProject);
        frame.add(taskSummary);
        frame.add(assignNewTask);
        frame.add(message);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);


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
    public void actionPerformed(ActionEvent e){
        task task = new task(nameOfProject.getText(), taskSummary.getText());
        if(newTask.getInstance().findMember(memberAssigned.getText())){
            tasks.add(task);
            message.setText("Task assigned");
        }else{
            message.setForeground(Color.red);
            message.setText("Wrong username");
        }
    }
    public static void main(String[] args){
        newTask newTask = new newTask();
        newTask.assignTask();
    }
}
