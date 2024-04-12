package view;

import controller.LoginController;
import model.Admin;

import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        LoginController controller = new LoginController();
        controller.initiateLogin();

    }


}
