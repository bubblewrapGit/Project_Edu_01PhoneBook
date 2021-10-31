package project1.ver09;

import java.util.Scanner;

public class PhoneBookManager{
	
	private PhoneInfo[] myPhoneBook;
	private int numOfmyPhoneBook;
	
	managerSQL mgrSQL = new managerSQL();
	
	public PhoneBookManager(int num) {
		// num크기의 객체배열 생성
		myPhoneBook = new PhoneInfo[num];
		// 최초 실행시 저장된 객체가 없음으로 0으로 초기화
		numOfmyPhoneBook = 0;
	}
	
	public static void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	
	
	public void addPhoneBook() {
		System.out.println("데이터 입력을 시작합니다...");
		Scanner scan = new Scanner(System.in);
		
		mgrSQL.dataInput();
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataSearch() {
		System.out.println("데이터를 검색합니다...");
		Scanner scan = new Scanner(System.in);

		mgrSQL.dataSearch();
		
		System.out.println("데이터 검색이 완료되었습니다.");
	}
	
	
	public void deletePhoneBook() {
		System.out.println("데이터를 삭제합니다...");
		Scanner scan = new Scanner(System.in);
		
		mgrSQL.dataDelete();
		
		System.out.println("데이터 삭제를 완료하였습니다.");
	}
	
	public void showAllDate() {
		System.out.println("전체정보를 출력합니다.");
		mgrSQL.dataAllShow();
	}
}
