package controller;

import model.*;
import view.*;

import java.util.Scanner;

public class LoginController {
    private Admin admin;
    private Scanner scanner;
    private MainMenu mainMenu;

    private Authenticatable currentUser;


    public LoginController() {
        this.admin = new Admin("admin", "admin123");
        Manager.loadManagerCredentials();
        this.scanner = new Scanner(System.in);
    }

    ManagerController managerController = new ManagerController();

    public void initiateLogin() {
        WelcomeArt welcomeArt = new WelcomeArt();
        welcomeArt.printWelcome();

        MainMenu mainMenu = new MainMenu();
        mainMenu.menuPrint();

        System.out.print("Enter your role number: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        switch (role) {
            case 1:
                if (admin.authenticate(username, password)) {
                    System.out.println("Login successful as Admin!");
                    adminMenu();
                } else {
                    System.out.println("Login failed!");
                }
                break;
            case 2:
                if (Manager.validateCredentials(username, password)) {
                    System.out.println("Login successful as HR Manager!");

                } else {
                    System.out.println("Login failed!");
                }
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void adminMenu() {
        int choice;
        do {
            System.out.println("\n ---- \t Admin Menu \t ----");
            System.out.println("1. Add HR Manager");
            System.out.println("2. View HR Managers");
            System.out.println("3. Edit HR Managers");
            System.out.println("4. Delete HR Managers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter HR Manager's username:");
                    String mUsername = scanner.nextLine();
                    System.out.println("Enter HR Manager's password:");
                    String mPassword = scanner.nextLine();
                    admin.addHRManager(mUsername, mPassword);
                    System.out.println("HR Manager added successfully.");
                    Manager.loadManagerCredentials();
                    break;
                case 2:
                    System.out.println("-------- All HR MANAGERS ARE --------\n");
                    managerController.displayHRManagers();
                    break;
                case 3:
                    System.out.println("----------------- Edit HR Managers ---------------------");
                    managerController.editHRManagers();
                    break;
                case 4:
                    System.out.println("----------------- Delete HR Managers ---------------------");
                    managerController.deleteHRManager();
                    break;
                case 6:
                    System.out.println("Good Bye !!!.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 6);
    }
}
