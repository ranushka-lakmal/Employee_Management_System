package controller;

import model.Manager;

import java.util.Scanner;

import static model.Manager.saveManagerCredentials;
import static model.Manager.updateManager;

public class ManagerController {

    Scanner scanner = new Scanner(System.in);
    public void displayHRManagers() {
        Manager.loadManagerCredentials();
        Manager.displayAllManagers();
    }

    public void editHRManagers(){
        System.out.println("Enter the username of the manager you want to edit:");
        String oldUsername = scanner.nextLine();

        System.out.println("Enter the new username:");
        String newUsername = scanner.nextLine();

        System.out.println("Enter the new password:");
        String newPassword = scanner.nextLine();

        updateManager(oldUsername, newUsername, newPassword);
        saveManagerCredentials();

    }

    public void deleteHRManager(){
        System.out.println("Enter the username of the HR Manager to delete:");
        String delUsername = scanner.nextLine();
        Manager.deleteManager(delUsername);
    }

}
