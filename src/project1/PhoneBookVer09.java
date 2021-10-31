package project1;

import java.util.Scanner;
import project1.ver09.PhoneBookManager;
import project1.ver09.PhoneInfo;
import project1.ver09.managerSQL;

public class PhoneBookVer09 {
	
	
	
	public static void main(String[] args) {
		//String name, String phoneNumber, String birthday
		
		Scanner scan = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager(100);
		managerSQL mgr = new managerSQL();
		
		mgr.makeTable();
		
		while(true) {
			manager.printMenu();
			int userAns = scan.nextInt();
			
			switch (userAns) {
			case 1:
				manager.addPhoneBook();
				break;
			case 2:
				manager.dataSearch();
				break;
			case 3:
				manager.deletePhoneBook();
				break;
			case 4:
				manager.showAllDate();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				mgr.close();
				return;
			}
			System.out.println();
		}
	}
}


