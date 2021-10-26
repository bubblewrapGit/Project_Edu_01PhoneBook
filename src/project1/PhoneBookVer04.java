package project1;

import java.util.Scanner;
import project1.ver04.PhoneBookManager;
import project1.ver04.PhoneInfo;

public class PhoneBookVer04 {
	
	public static void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	
	public static void main(String[] args) {
		//String name, String phoneNumber, String birthday
		
		Scanner scan = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			printMenu();
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
				return;
			}
			System.out.println();
		}
	}
}


