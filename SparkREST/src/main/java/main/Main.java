package main;

import controller.UserController;
import services.UserService;


public class Main {
    public static void main(String[] args) {
        new UserController(new UserService());
    }
}
