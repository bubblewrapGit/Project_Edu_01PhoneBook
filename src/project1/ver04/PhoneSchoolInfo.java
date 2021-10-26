package project1.ver04;

public class PhoneSchoolInfo extends PhoneInfo{
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("\n[동창 주소록]");
		super.showPhoneInfo();
		System.out.printf(">>>> | 전공 : %s | 학년 : %d \n", major, grade);
	}
}


