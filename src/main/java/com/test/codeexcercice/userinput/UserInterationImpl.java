package com.test.codeexcercice.userinput;

import java.io.InputStream;
import java.util.Scanner;

public class UserInterationImpl implements UserInteration {

	public UserData getUserOptions(InputStream in) {
		Scanner scanner = new Scanner(in);
		UserData userOption = null;
		
		System.out.println("------------------------");
		System.out.println("Please Choose an option.");
		System.out.println("1 - Add Person");
		System.out.println("2 - Edit Person");
		System.out.println("3 - Delete Person");
		System.out.println("4 - Count Persons");
		System.out.println("5 - List Persons");
		System.out.println("------------------------");

		if(scanner.hasNext()) {
		//TODO: find a better way to avoid any programmatic error where wrong code is passed in the UserData constructor
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Please enter person details in this format: id, firstName, surname");
				userOption = new UserData(1, scanner.next());
				break;
			case 2:
				System.out.println("Please enter person details in this format: firstName, surname");
				userOption = new UserData(1, scanner.next());
				break;
			case 3:
				System.out.println("Please enter person details in this format: id");
				userOption = new UserData(1, scanner.next());
				break;
			case 4:
				userOption = new UserData(4);
				break;
			case 5:
				userOption = new UserData(5);
				break;
			default:
				System.exit(0);
				break;
			}
		}
		
		return userOption;
	}
}
