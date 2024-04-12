package model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Manager extends User {
    private static Map<String, String> managerCredentials = new HashMap<>();

    public Manager(String username, String password) {
        super(username, password);
    }

    public static void loadManagerCredentials() {
        managerCredentials.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("managers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    managerCredentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading manager credentials: " + e.getMessage());
        }
    }

    public static boolean validateCredentials(String username, String password) {
        if (managerCredentials.isEmpty()) {
            loadManagerCredentials();
        }
        return password.equals(managerCredentials.get(username));
    }

    public static void displayAllManagers() {

        System.out.println("\tId\t | Username");
        System.out.println("\t------------------");
        int id = 1;
        for (String username : managerCredentials.keySet()) {
            System.out.println("\t"+id + "\t | " + username);
            id++;
        }
        if (managerCredentials.isEmpty()) {
            System.out.println("No HR Managers found.");
        }
    }

    public static void updateManager(String oldUsername, String newUsername, String newPassword) {
        if (managerCredentials.containsKey(oldUsername)) {
            managerCredentials.remove(oldUsername);
            managerCredentials.put(newUsername, newPassword);
        } else {
            System.out.println("Manager not found!");
        }
    }

    public static void saveManagerCredentials() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("managers.txt"))) {
            for (Map.Entry<String, String> entry : managerCredentials.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void deleteManager(String username) {
        if (managerCredentials.containsKey(username)) {
            managerCredentials.remove(username);
            saveManagerCredentials();
            System.out.println("HR Manager removed successfully.");
        } else {
            System.out.println("Manager not found!");
        }
    }
}
