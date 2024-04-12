package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Manager> managers;

    public Admin(String username, String password) {
        super(username, password);
        this.managers = new ArrayList<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        System.out.println("Admin authentication in progress...");
        return super.authenticate(username, password);
    }

    public void addHRManager(String username, String password) {
        Manager manager = new Manager(username, password);
        managers.add(manager);
        saveManagerCredentials(manager);
    }

    private void saveManagerCredentials(Manager manager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("managers.txt", true))) {
            writer.write(manager.getUsername() + "," + manager.getPassword() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


}
