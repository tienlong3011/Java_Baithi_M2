package main;

import menu.MenuPhoneBookManager;

public class Main {
    public static void main(String[] args) {
        MenuPhoneBookManager menuPhoneBookManager = MenuPhoneBookManager.getInstance();
        menuPhoneBookManager.runMenu();
    }


}