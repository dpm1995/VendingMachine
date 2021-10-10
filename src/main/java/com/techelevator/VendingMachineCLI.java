package com.techelevator;

import java.io.FileNotFoundException;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) throws FileNotFoundException {
		MainMenu menu = new MainMenu(); //Call main menu class, where most of the program is
		// Make some objects here!

		menu.openMenu();
	}
}
