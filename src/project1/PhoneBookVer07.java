package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.MenuItem;
import project1.ver07.MenuSelectException;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 implements MenuItem{
	
	public static void main(String[] args) throws MenuSelectException {
		//String name, String phoneNumber, String birthday
		PhoneBookManager manager = new PhoneBookManager(100);
		
		int userAns = 0;
		
		while(true) {
			manager.printMenu();
			try {
				
				Scanner scan = new Scanner(System.in);
				userAns = scan.nextInt();
				
				if(userAns >= 1 && userAns <= 5) {
					
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
				}else {
					MenuSelectException menuSelectErr = new MenuSelectException("------------[ 올바른 숫자가 아닙니다 ]------------");
					continue;
				} 
			}catch (InputMismatchException e) {				
				System.out.println("------------[ 입력값이 올바르지 않습니다 ]------------");
			}catch(NullPointerException e) {
				System.out.println("------------[ 입력 된 값이 없습니다 ]------------");
			}
		}
	}
}


