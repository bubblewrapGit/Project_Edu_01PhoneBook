package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;



public class PhoneBookManager implements SubMenuItem{
	
	HashSet<PhoneInfo> myPhoneBook = new HashSet<PhoneInfo>();
	private int numOfmyPhoneBook;

	public PhoneBookManager(int num) {
		myPhoneBook = new HashSet<PhoneInfo>();
		numOfmyPhoneBook = 0;
		
		readPhoneBook();
	}
	
	public void printMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("[ 메뉴선택 ]");
		System.out.println("    1. 데이터 입력");
		System.out.println("    2. 데이터 검색");
		System.out.println("    3. 데이터 삭제");
		System.out.println("    4. 주소록 출력");
		System.out.println("    5. 자동저장 옵션");
		System.out.println("    6. 프로그램 종료");
		System.out.println("-------------------------------------------------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	
	public void addPhoneBook() {
		System.out.println();
		System.out.println("----------[ 데이터 입력을 시작합니다... ]----------");
		Scanner scan = new Scanner(System.in);
		
		String name, phoneNumber, major, companyName;
		int grade;
		
		while(true) {
			System.out.println("[ 분류선택 ]");
			System.out.println("    1.일반 | 2.동창 | 3.회사");
			System.out.print("분류를 선택하세요 : ");
			
			int userInput = scan.nextInt();
			try {
				if(userInput >= 1 && userInput <= 3) {
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
					
					if(myPhoneBook.add(info) == false) {// T. 여기랑 .... 여기서 한번 추가가 되고 나서...
						// HashSet의 add메서드는 hashCode와 equals 메서드를 자동으로 사용한다.
						// > HashSet의 add메서드를 사용할 시 hashCode와 equals 메서드를 오버라이딩해줘야하고 필요한 사항에 맞게 hashCode와 equals 메서드를 재정의 해줘야함.
						// ※ HashSet은 중복값을 허용하지 않는다.
						
						// >> 비교값이 같으면 equals메소드에서 true
						// >>>> 중복됨으로 add메서드는 false를 반환한다.
						
						// >> 비교값이 다르면 equals메소드에서 false
						// >>>> 중복되는 값이 없음으로 add메서드는 true를 반환한다.
						
						// add로 들어가보면 add메서드는 boolean타입으로 true/false를 반환한다.
						System.out.println("== 이미 저장된 데이터입니다 ==\r\n"
								+ " - 덮어쓸까요? Y(y) / N(n)");
						scan.nextLine();
						String userAns = scan.nextLine();
						
						if(userAns.equalsIgnoreCase("y")) {
							// 저장소 : '홍길동' && 비교값 : '홍길동'
							myPhoneBook.remove(info); // >> 저장소의 '홍길동' 삭제
							myPhoneBook.add(info);	  // >> 비교값의 '홍길동' 입력
							System.out.println("== 덮어쓰는중 ==");
						}else {
							System.out.println("== 저장하지 않습니다 ==");
						}
						
					}else {
//						myPhoneBook.add(info);//  T. 여기가 문제인건데...여기서 다시 추가하는 로직이야..중복처리 되어있어서 안들어가긴 하겠지만.,,두번 추가되고있다..만약 리스트면 2개씩 들어갈거야..^^
						// └ 위 if조건문에서 이미 추가(첫번째)가 되고있다. 조건에 맞지 않아서 else문으로 오면 또 추가(두번째)가되고 있다.
						// └ 결과가 제대로 나오는 이유는 HashSet이라서 자동으로 중복되는걸 지워줘서임. 두번씩 저장되고 중복되는걸 자동으로 지워서. 여긴 add를 쓰면 안됨. ok?
						System.out.println("== 저장중 ==");
					}
				}else {
					System.out.println("1.일반 | 2.동창 | 3.회사 중에 입력하세요");
					return;				
				}
			} catch (InputMismatchException e) {
				System.out.println("------------[ 올바른 메뉴의 번호를 입력해주세요 ]------------");
			}
			
			System.out.println("[ 데이터 입력이 완료되었습니다 ]");
			break;
		}
	}
	
	
	public void dataSearch() {
		System.out.println();
		System.out.println("----------[ 데이터를 검색합니다... ]----------");
		Scanner scan = new Scanner(System.in);
		boolean isFind = false;
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchDate = scan.nextLine();
		
		Iterator<PhoneInfo> itr = myPhoneBook.iterator();
		while(itr.hasNext()) {
			PhoneInfo itrNext = itr.next();
			if(searchDate.compareTo(itrNext.name)==0) {
				System.out.println("[ " + searchDate + " ] 를 검색합니다.");
				itrNext.showPhoneInfo();
				
				isFind = true;
			}
		}
		
		if(isFind==false) {
			System.out.println("== 찾는 정보가 없습니다 ==");
		}
		System.out.println("[ 데이터 검색이 완료되었습니다 ]");
	}
	
	
	public void deletePhoneBook() {
		System.out.println();
		System.out.println("----------[ 데이터를 삭제합니다... ]----------");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름을 입력해주세요 : ");
		String delDate = scan.nextLine();
		int delDateIndex = -1;
		
		for(PhoneInfo index : myPhoneBook) {
			if(delDate.compareTo(index.name)==0) {
				System.out.println("[ " + delDate + " ] 를 삭제합니다.");
				myPhoneBook.remove(index);
				delDateIndex = 1; 
				break;
			}
		}	
		
		if(delDateIndex== -1) {
			System.out.println("== 삭제된 데이터가 없습니다 ==");
		}else {
			System.out.println("== 데이터가 삭제되었습니다.");
		}
		
		System.out.println("[ 데이터 삭제를 완료하였습니다 ]");
	}
	
	public void showAllDate() {
		System.out.println();
		System.out.println("----------[ 전체정보를 출력합니다 ]----------");
		
		Iterator<PhoneInfo> itr = myPhoneBook.iterator();
		
		while(itr.hasNext()) {
			
			PhoneInfo o = itr.next();
			o.showPhoneInfo();	
		}
		System.out.println("[ 전체정보를 출력를 완료하였습니다 ]");
	}
	
	public void savePhoneBook() {
		try {
			ObjectOutputStream out = 
				new ObjectOutputStream(
					new FileOutputStream("src/project1/ver08/PhoneBook.obj")
				);
				
				for(PhoneInfo pi : myPhoneBook) {
					out.writeObject(pi);
				}
				
				System.out.println("[ 주소록 저장이 완료되었습니다 ]");
				out.close();
		} catch (Exception e) {
			System.out.println("친구 정보 직렬화시 예외가 발생");
		}
	}
	
	public void readPhoneBook() {
		try {
			ObjectInputStream in = 
				new ObjectInputStream(
					new FileInputStream("src/project1/ver08/PhoneBook.obj")
				);
			while(true) {
				PhoneInfo index = (PhoneInfo)in.readObject();			
				myPhoneBook.add(index);
				if(index == null) break;
			}			
		} catch (Exception e) {
			System.out.println("더 이상 읽을 객체가 없습니다.");
		}
		System.out.println("친구 정보가 복원되었습니다.");
	}
	
	public void autoSaveBook(AutoSaverT auto) {
		System.out.println();
		System.out.println("----------[ 자동저장 옵션]----------");
		System.out.println("[ 자동저장 ]");
		System.out.println("    1.자동저장 ON | 2.자동저장 OFF");
		System.out.print("저장옵션을 선택하세요 : ");
		
		Scanner scan = new Scanner(System.in);
		try {
			int userAns = scan.nextInt();
		
			switch (userAns) {
			case 1:
				if(auto.isAlive()) {
					System.out.println("[ 이미 자동저장이 실행중입니다 ]");
				}else {
					System.out.println("[ 자동저장을 실행합니다 ]");
					auto.setDaemon(true);
					auto.start();
				}
				break;
			case 2:
				if(auto.isAlive()) {
					System.out.println("[ 자동저장을 종료합니다 ]");
					auto.interrupt();
				}else {
					System.out.println("[ 자동저장이 실행중이지 않습니다 ]");
				}
				break;
			default:
				System.out.println("[ 올바른 번호를 입력해주세요 ]");
				break;
			}	
		} catch (InputMismatchException e) {
			System.out.println("------------[ 번호를 입력해주세요 ]------------");
		}catch (Exception e) {
			System.out.println("------------[ 알수없는 오류가 발생하였습니다 ]------------");
		}
		
	}
	

	
	
	
	
	
	
	
	
}
