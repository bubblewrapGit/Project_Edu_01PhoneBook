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
		
		PhoneInfo info = null;
		
		switch (userInput) {
		case NORMAL:
			PhoneInfo nInfo = new PhoneInfo(name, phoneNumber);
			info = nInfo;
			break;
		case SCHOOL:	
			System.out.print("전공 : ");		major = scan.next();
			System.out.print("학년 : ");		grade = scan.nextInt();
			
			PhoneSchoolInfo sInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			info = sInfo;
			break;
		case COMPANY:
			System.out.print("회사 : ");		companyName = scan.next();
			
			PhoneCompanyInfo cInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
			info = cInfo;
			break;
		}
		
		if(myPhoneBook.add(info) == false) {
			// HashSet의 add메서드는 hashCode와 equals 메서드를 자동으로 사용한다.
			// > HashSet의 add메서드를 사용할 시 hashCode와 equals 메서드를 오버라이딩해줘야하고 필요한 쿼리로 재정의 해줘야함.
			// ※ HashSet은 중복값을 허용하지 않는다.
			
			// >> 비교값이 같으면 equals메소드에서 true
			// >>>> 중복됨으로 add메서드는 fasle를 반환한다.
			
			// >> 비교값이 다르면 equals메소드에서 false
			// >>>> 중복되는 값이 없음으로 add메서드는 ture 반환한다.
			
			// add로 들어가보면 add메서드는 boolean타입으로 true/false를 반환한다.
			System.out.println("이미 저장된 데이터입니다.\r\n"
					+ "덮어쓸까요? Y(y) / N(n)");
			scan.nextLine();
			String userAns = scan.nextLine();
			
			if(userAns.equalsIgnoreCase("y")) {
				// 저장소 : '홍길동' && 비교값 : '홍길동'
				myPhoneBook.remove(info); // >> 저장소의 '홍길동' 삭제
				myPhoneBook.add(info);	  // >> 비교값의 '홍길동' 입력
				System.out.println("덮어썼습니다.");
			}else {
				System.out.println("저장하지 않습니다.");
			}
			
		}else {
			myPhoneBook.add(info);
			System.out.println("일반적인 저장입니다.");
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
		System.out.println();
		System.out.println("----------[ 전체정보를 출력합니다 ]----------");
		
		Iterator<PhoneInfo> itr = myPhoneBook.iterator();
		
		while(itr.hasNext()) {
			
			PhoneInfo o = itr.next();
			o.showPhoneInfo();	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
