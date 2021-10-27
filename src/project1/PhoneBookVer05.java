package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
import project1.ver05.PhoneInfo;
import project1.ver05.SubMenuItem;

public class PhoneBookVer05 implements MenuItem{
	
	public static void main(String[] args) {
		//String name, String phoneNumber, String birthday
		Scanner scan = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager(100);
		
		int userAns = 0;
		while(true) {
			manager.printMenu();
			userAns = scan.nextInt();
			switch (userAns) {
			case ADDD:
				manager.addPhoneBook();
				break;
			case SERC:
				manager.dataSearch();
				break;
			case DELT:
				manager.deletePhoneBook();
				break;
			case SHOW:
				manager.showAllDate();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.println();
		}
	}
}


