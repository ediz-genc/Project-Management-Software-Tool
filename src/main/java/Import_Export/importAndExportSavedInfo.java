package Import_Export;

import Tools.InputClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
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
import Users.allMessages;
import Users.Message;

public class importAndExportSavedInfo {

    InputClass input = new InputClass();
    addedMembers addedmembers = addedMembers.getInstance();
    allProjects allprojects = allProjects.getInstance();
    assignedTask.allAssignedTasks allAssignedTasks = assignedTask.allAssignedTasks.getInstance();
    allMessages AllMessages = Users.allMessages.getInstance();
    static ArrayList<Member> allMembers = new ArrayList<Member>();
    static ArrayList<Project> allProject = new ArrayList<>();
    static ArrayList<assignedTask> AssignedTasks = new ArrayList<>();
    static ArrayList<Message> allMessages = new ArrayList<>();


    public void loadUser() throws IllegalStateException {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\irina\\Eficaz Mini Project\\Eficaz_4\\src\\main\\java\\SavedInfo\\savedUsersObjects.json")) {

            Type type = new TypeToken<ArrayList<Member>>(){}.getType();
            allMembers = gson.fromJson(reader, type);
            try {
                int secondsToSleep = 2;
                input.printLine("Loading saved data...");
                Thread.sleep(secondsToSleep * 1000);
                addedmembers.loadFromFile(allMembers);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        } catch (IOException e) {
            input.printLine("fyi no saved data was loaded... :/");
            e.printStackTrace();
        }

    }

    public void loadProject() throws IllegalStateException {

        Gson gson = new Gson();


        try (Reader reader = new FileReader("C:\\Users\\irina\\Eficaz Mini Project\\Eficaz_4\\src\\main\\java\\SavedInfo\\savedProjectsObjects.json")) {
            Type type = new TypeToken<ArrayList<Project>>(){}.getType();
            allProject = gson.fromJson(reader, type);
            allprojects.loadFromFile(allProject);

        } catch (IOException e) {
            System.out.print("File not found...");
            e.printStackTrace();
        }


    }

    public void loadAssignedTasks() throws IllegalStateException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\irina\\Eficaz Mini Project\\Eficaz_4\\src\\main\\java\\SavedInfo\\savedAssignedTasksObjects.json")) {
            Type type = new TypeToken<ArrayList<assignedTask>>() {}.getType();
            AssignedTasks = gson.fromJson(reader, type);
            allAssignedTasks.loadFromFile(AssignedTasks);

        } catch (IOException e) {
            System.out.print("File not found...");
            e.printStackTrace();
        }
    }

    public void loadMessages() throws IllegalStateException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\irina\\Eficaz Mini Project\\Eficaz_4\\src\\main\\java\\SavedInfo\\savedMessageObjects.json")) {
            Type type = new TypeToken<ArrayList<Message>>() {
            }.getType();
            allMessages = gson.fromJson(reader, type);
            AllMessages.loadFromFile(allMessages);

        } catch (IOException e) {
            System.out.print("File not found...");
            e.printStackTrace();
        }
    }

    public void exportUsers() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Type type = new TypeToken<ArrayList<Member>>(){}.getType();
        ArrayList<Member> allMembers = addedmembers.getAllMembers();

            try (FileWriter writer = new FileWriter("/Users/hagosaraya/IdeaProjects/eficaza/src/main/java/savedInfo/savedUsersObjects.json")) {
               gson.toJson(allMembers,type,writer);

            } catch (IOException e) {
                input.printLine("No file found");

            }
        }
    public void exportProjects(){
    
    }


}