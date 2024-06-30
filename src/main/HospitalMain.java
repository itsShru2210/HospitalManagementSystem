package main;

public class HospitalMain {
	public static void main(String[] args) {
		System.out.println("**********Welcome to Hospital Management System***********");
        MainMenu menu = new MainMenu();
        menu.login();
        menu.mainMenu();
    }

}
