package controller;

import model.Admin;
import model.User;
import view.MainMenu;
import view.WelcomeArt;

import java.util.Scanner;

public class LoginController {

    private Admin admin;
    private Scanner scanner;


    public LoginController() {
        // Initialize users with credentials
        this.admin = new Admin("admin", "admin123");
       // this.hrManager = new HRManager("manager", "manager123");
       // this.hrAssistant = new HRAssistant("assistant", "assistant123");
        this.scanner = new Scanner(System.in);
    }

    public void initiateLogin() {
        WelcomeArt welcomeArt = new WelcomeArt();
        welcomeArt.printWelcome();

        MainMenu mainMenu = new MainMenu();
        mainMenu.menuPrint();

        System.out.print("Enter your role number: ");
        int role = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        switch (role) {
            case 1:
                authenticateUser(admin, username, password);
                break;
            case 2:
             //   authenticateUser(hrManager, username, password);
                break;
            case 3:
              //  authenticateUser(hrAssistant, username, password);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void authenticateUser(User user, String username, String password) {
        if (user.authenticate(username, password)) {
            System.out.println("Login successful as " + user.getClass().getSimpleName() + "!");
        } else {
            System.out.println("Login failed!");
        }
    }
}

