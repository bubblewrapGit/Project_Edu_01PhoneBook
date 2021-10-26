package project1;

import java.util.Scanner;
import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {
	public static void main(String[] args) {
		//String name, String phoneNumber, String birthday
		
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			int userAns = scan.nextInt();
			
			switch (userAns) {
			case 1:
				System.out.print("이름 : ");
				String name = scan.next();
				System.out.print("전화번호 : ");
				String phoneNumber = scan.next();
				System.out.print("생년월일 : ");
				String birthday = scan.next();
				PhoneInfo user = new PhoneInfo(name, phoneNumber, birthday);
				System.out.println();
				System.out.println("입력된 정보 출력.");
				user.showPhoneInfo();
				System.out.println();
				continue;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.err.println("(1)데이터 입력 / (2)프로그램 종료");
				break;
			}
			System.out.println();
		}
	}
}
