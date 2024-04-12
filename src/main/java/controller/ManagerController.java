package controller;

import model.Manager;

import java.util.Scanner;

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

        Manager.updateManager(oldUsername, newUsername, newPassword);
        Manager.saveManagerCredentials();
    }

}
