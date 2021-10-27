package project1.ver05;

import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{
	
	private PhoneInfo[] myPhoneBook;
	private int numOfmyPhoneBook;
	

	public PhoneBookManager(int num) {
		// num크기의 객체배열 생성
		myPhoneBook = new PhoneInfo[num];
		// 최초 실행시 저장된 객체가 없음으로 0으로 초기화
		numOfmyPhoneBook = 0;
	}
	
	public void printMenu() {
		System.out.println("선택하시오...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
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
			myPhoneBook[numOfmyPhoneBook++] = new PhoneInfo(name, phoneNumber);
			break;
		case SCHOOL:	
			System.out.print("전공 : ");		major = scan.next();
			System.out.print("학년 : ");		grade = scan.nextInt();
			
			myPhoneBook[numOfmyPhoneBook++] = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			break;
		case COMPANY:
			System.out.print("회사 : ");		companyName = scan.next();
			
			myPhoneBook[numOfmyPhoneBook++] = new PhoneCompanyInfo(name, phoneNumber, companyName);
			break;
		}
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataSearch() {
		System.out.println("데이터를 검색합니다...");
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchDate = scan.nextLine();
		
		for(int i = 0; i < numOfmyPhoneBook; i++) {
			if(searchDate.compareTo(myPhoneBook[i].name)==0) {
				myPhoneBook[i].showPhoneInfo();
			}else {
				System.out.println("찾는 정보가 없습니다.");
			}
		}
		System.out.println("데이터 검색이 완료되었습니다.");
	}
	
	
	public void deletePhoneBook() {
		System.out.println("데이터를 삭제합니다...");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름을 입력해주세요 : ");
		String delDate = scan.nextLine();
		int delDateIndex = -1;
		
		for(int i = 0; i < numOfmyPhoneBook; i++) {
			if(delDate.compareTo(myPhoneBook[i].name) == 0) {
				myPhoneBook[i] = null;
				delDateIndex = i;
				numOfmyPhoneBook--;
				break;
			}			
		}
		
		if(delDateIndex == -1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}else {

			for(int i = delDateIndex; i<numOfmyPhoneBook; i++) {
				myPhoneBook[i] = myPhoneBook[i+1];
			}
			System.out.println("==데이터(" + delDateIndex + "번)가 삭제되었습니다.");
		}
		System.out.println("데이터 삭제를 완료하였습니다.");
	}
	
	public void showAllDate() {
		System.out.println("전체정보를 출력합니다.");
		for(int i = 0; i < numOfmyPhoneBook; i++) {
			myPhoneBook[i].showPhoneInfo();
		}
	}
}
