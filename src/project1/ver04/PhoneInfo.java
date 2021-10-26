package project1.ver04;

public class PhoneInfo {
	String name; 		// 멤버1 : 이름 
	String phoneNumber; // 멤버2 : 전화번호 
	
	// 3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showPhoneInfo() {
		System.out.printf("이름 : %s | 전화번호 : %s \n", name, phoneNumber);
	}
}

