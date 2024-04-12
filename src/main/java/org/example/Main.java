package org.example;

public class Main {
    public static void main(String[] args) {

        WelcomeArt welcomeArt = new WelcomeArt();
        welcomeArt.printWelcome();
        welcomeArt.printDate();


        MainMenu mainMenu =  new MainMenu();
        mainMenu.print();
    }
}
