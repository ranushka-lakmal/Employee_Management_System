package controller;

import model.*;
import view.*;

import java.util.Scanner;

public class LoginController {
    private Admin admin;
    private Scanner scanner;

    public LoginController() {
        this.admin = new Admin("admin", "admin123");
        this.scanner = new Scanner(System.in);
    }

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

        if (role == 1 && admin.authenticate(username, password)) {
            System.out.println("Login successful as Admin!");
            adminMenu();
        } else {
            System.out.println("Login failed!");
        }
    }

    private void adminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Add HR Manager");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter HR Manager's username:");
                String mUsername = scanner.nextLine();
                System.out.println("Enter HR Manager's password:");
                String mPassword = scanner.nextLine();
                admin.addHRManager(mUsername, mPassword);
                System.out.println("HR Manager added successfully.");
                break;
            case 2:
                System.out.println("Exiting admin menu.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
