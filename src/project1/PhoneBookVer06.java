package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06 implements MenuItem{
	
	@Override
	public void printMenu() {
		System.out.println("[ 메뉴선택 ]");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("입력하세요 : ");
	}
	
	public static void main(String[] args) throws MenuSelectException {
		//String name, String phoneNumber, String birthday
		PhoneBookVer06 PhoneBookVer05 = new PhoneBookVer06();
		PhoneBookManager manager = new PhoneBookManager(100);
		
		int userAns = 0;
		
		while(true) {
			PhoneBookVer05.printMenu();
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


