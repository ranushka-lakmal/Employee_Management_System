package view;

import model.Admin;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainMenu {
    String selectMessage = "Please select below options";
    private Admin admin;
    private Scanner scanner;

    public void menuPrint(){

        System.out.println(selectMessage);
        System.out.println("1. Admin");
        System.out.println("2. HR Manager");
        System.out.println("3. HR Assistant");

    }




}
