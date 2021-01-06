package Import_Export;

import Tools.InputClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import Users.addedMembers;
import Users.Member;
import Projects.Project;
import java.io.IOException;
import Projects.allProjects;
import com.google.gson.Gson;
import java.io.Reader;
import Projects.allProjects;
import Projects.assignedTask;
import Projects.allAssignedTasks;
import Users.allMessages;
import Users.Message;

public class importAndExportSavedInfo {

    InputClass input = new InputClass();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    addedMembers addedmembers = addedMembers.getInstance();
    allProjects allprojects = allProjects.getInstance();
    static allAssignedTasks AllAssignedTasks = allAssignedTasks.getInstance();
    allMessages AllMessages = Users.allMessages.getInstance();
    static ArrayList<Member> allMembers = new ArrayList<Member>();
    static ArrayList<Project> allProject = new ArrayList<>();
    static ArrayList<assignedTask> AssignedTasks = new ArrayList<>();
    static ArrayList<Message> allMessages = new ArrayList<>();

    public void loadUser() throws IllegalStateException {

        Gson gson = new Gson();
        File file = new File("savedUsersObjects.json");
        String path = file.getAbsolutePath();

        try (Reader reader = new FileReader(path)) {

            Type type = new TypeToken<ArrayList<Member>>(){}.getType();
            allMembers = gson.fromJson(reader, type);
            try {
                int secondsToSleep = 2;
                input.printLine("Loading program...");
                Thread.sleep(secondsToSleep * 1000);
                addedmembers.loadFromFile(allMembers);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("mmm no");
            }

        } catch (IOException e) {
            input.printLine("fyi no saved data was loaded... :/");
            e.printStackTrace();
        }
    }
    public void loadProject() throws IllegalStateException {

        Gson gson = new Gson();
        File file = new File("savedProjectsObjects.json");
        String path = file.getAbsolutePath();

        try (Reader reader = new FileReader(path)) {
            Type type = new TypeToken<ArrayList<Project>>(){}.getType();
            allProject = gson.fromJson(reader, type);
            allprojects.loadFromFile(allProject);

        } catch (IOException e) {
            System.out.print(ANSI_RED + "File not found..."+ ANSI_RESET);
            e.printStackTrace();
        }
    }
    public void loadAssignedTasks() throws IllegalStateException {

        Gson gson = new Gson();
        File file = new File("savedAssignedTasksObjects.json");
        String path = file.getAbsolutePath();

        try (Reader reader = new FileReader(path)) {
            Type type = new TypeToken<ArrayList<assignedTask>>() {}.getType();
            AssignedTasks = gson.fromJson(reader, type);
            AllAssignedTasks.loadFromFile(AssignedTasks);

        } catch (IOException e) {
            System.out.print(ANSI_RED +"File not found..."+ANSI_RESET);
            e.printStackTrace();
        }
    }
    public void loadMessages() throws IllegalStateException {
        Gson gson = new Gson();
        File file = new File("savedMessageObjects.json");
        String path = file.getAbsolutePath();

        try (Reader reader = new FileReader(path)) {
            Type type = new TypeToken<ArrayList<Message>>() {
            }.getType();
            allMessages = gson.fromJson(reader, type);
            AllMessages.loadFromFile(allMessages);

        } catch (IOException e) {
            System.out.print(ANSI_RED+"File not found..."+ANSI_RESET);
            e.printStackTrace();
        }
    }
    public void exportUsers() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("savedUsersObjects.json");
        String path = file.getAbsolutePath();

        Type type = new TypeToken<ArrayList<Member>>(){}.getType();
        ArrayList<Member> allMembers = addedmembers.getAllMembers();

            try (FileWriter writer = new FileWriter(path)) {
               gson.toJson(allMembers,type,writer);
           } catch (IOException e) {
                input.printLine("No file found");
            }
    }
    public void exportProjects(){
     Gson gson = new GsonBuilder().setPrettyPrinting().create();
     Type type = new TypeToken<ArrayList<Project>>(){}.getType();
     ArrayList<Project> allProjects = allprojects.getAllProjects();
        File file = new File("savedProjectsObjects.json");
        String path = file.getAbsolutePath();

      try (FileWriter writer = new FileWriter(path)) {
                    gson.toJson(allProjects,type,writer);
                 } catch (IOException e) {
                     input.printLine("No file found");
                 }
    }
    public void exportTasks() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<ArrayList<assignedTask>>() {
        }.getType();
        ArrayList<assignedTask> allAssignedTasks = AllAssignedTasks.getAssignedTasks();
        File file = new File("savedAssignedTasksObjects.json");
        String path = file.getAbsolutePath();

        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(allAssignedTasks, type, writer);
        } catch (IOException e) {
            input.printLine("No file found");
        }
    }
    public void exportMessages () {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<ArrayList<Message>>() {}.getType();
        ArrayList<Message> allMessages = AllMessages.getAllMessages();
        File file = new File("savedMessageObjects.json");
        String path = file.getAbsolutePath();

        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(allMessages, type, writer);
        } catch (IOException e) {
            input.printLine("No file found");
        }
    }
}
