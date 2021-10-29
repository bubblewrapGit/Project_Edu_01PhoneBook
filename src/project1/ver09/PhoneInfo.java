package project1.ver09;

public class PhoneInfo {
	String name; 		// 멤버1 : 이름 
	String phoneNumber; // 멤버2 : 전화번호 
	String birthday; 	// 멤버3 : 생년월일 
	
	// 3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	// 2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	public void showPhoneInfo() {
		System.out.printf("이름 : %s | 전화번호 : %s | 생년월일 : %s \n", name, phoneNumber, birthday);
	}
	
	
}
