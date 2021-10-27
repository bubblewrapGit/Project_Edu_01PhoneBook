package project1.ver07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem{
	
	HashSet<PhoneInfo> myPhoneBook = new HashSet<PhoneInfo>();
	private int numOfmyPhoneBook;

	
	
	public void printMenu() {
		System.out.println("[ 메뉴선택 ]");
		System.out.println(">> 1. 데이터 입력 | 2. 데이터 검색 | 3. 데이터 삭제 | 4. 주소록 출력 | 5. 프로그램 종료");
		System.out.print("입력하세요 : ");
	}
	
	public PhoneBookManager(int num) {
		// num크기의 객체배열 생성
		myPhoneBook = new HashSet<PhoneInfo>();
		// 최초 실행시 저장된 객체가 없음으로 0으로 초기화
		numOfmyPhoneBook = 0;
	}
	
	public void addPhoneBook() {
		System.out.println("데이터 입력을 시작합니다...");
		Scanner scan = new Scanner(System.in);
		
		String name, phoneNumber, major, companyName;
		int grade;
		
		System.out.println("1.일반 2.동창 3.회사");
		int userInput = scan.nextInt();
		
		System.out.print("이름 : ");		name = scan.next();
		System.out.print("전화번호 : ");	phoneNumber = scan.next();
		
		switch (userInput) {
		case NORMAL:
			myPhoneBook.add(new PhoneInfo(name, phoneNumber));
			break;
		case SCHOOL:	
			System.out.print("전공 : ");		major = scan.next();
			System.out.print("학년 : ");		grade = scan.nextInt();
			
			myPhoneBook.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
			break;
		case COMPANY:
			System.out.print("회사 : ");		companyName = scan.next();
			
			myPhoneBook.add(new PhoneCompanyInfo(name, phoneNumber, companyName));
			break;
		}
		
		if(myPhoneBook.equals(name)) {
			System.out.println("참이냐 거짓이냐 : " + myPhoneBook.equals(name));
			System.out.println("이미 저장된 데이터입니다.");
			System.out.print("덮어쓸까요? Y(y) / N(n) : ");
			String answer = scan.nextLine();
			
			boolean toggle = true;
			
			while(toggle) {
				switch (answer) {
				case "y": case "Y":	
					System.out.println("-------[ 입력한 정보가 저장되었습니다 ]-------");
					toggle = false;
					break;
				case "n": case "N":
					System.out.println("-------[ 저장하지 않습니다 ]-------");
					name = null;
					toggle = false;
					break;
				default:
					System.out.println("-------[ 잘못입력하셨습니다 ]-------");
					continue;
				}
			}
		}else{
			System.out.println("false반환");
		}
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	
	
	public void dataSearch() {
		System.out.println("데이터를 검색합니다...");
		Scanner scan = new Scanner(System.in);
		boolean isFind = false;
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchDate = scan.nextLine();
		
		Iterator<PhoneInfo> itr = myPhoneBook.iterator();
		while(itr.hasNext()) {
			PhoneInfo itrNext = itr.next();
			if(searchDate.compareTo(itrNext.name)==0) {
				itrNext.showPhoneInfo();
				
				System.out.println("[ " + searchDate + " ] 를 검색합니다.");
				isFind = true;
			}
		}
		
		if(isFind==false) {
			System.out.println("찾는 정보가 없습니다.");
		}
		System.out.println("데이터 검색이 완료되었습니다.");
	}
	
	
	public void deletePhoneBook() {
		System.out.println("데이터를 삭제합니다...");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름을 입력해주세요 : ");
		String delDate = scan.nextLine();
		int delDateIndex = -1;
		
		for(PhoneInfo index : myPhoneBook) {
			if(delDate.compareTo(index.name)==0) {
				myPhoneBook.remove(index);
				delDateIndex = 1; 
				break;
			}
		}	
		
		if(delDateIndex== -1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}else {
			System.out.println("==데이터가 삭제되었습니다.");
		}
		
		System.out.println("데이터 삭제를 완료하였습니다.");
	}
	
	public void showAllDate() {
		System.out.println("전체정보를 출력합니다.");
		
		Iterator<PhoneInfo> itr = myPhoneBook.iterator();
		
		while(itr.hasNext()) {
			
			PhoneInfo o = itr.next();
			o.showPhoneInfo();	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
