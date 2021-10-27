package project1.ver07;

public class PhoneInfo {
	String name; 		// 멤버1 : 이름 
	String phoneNumber; // 멤버2 : 전화번호 
	
	// 2개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showPhoneInfo() {
		System.out.printf("이름 : %s | 전화번호 : %s \n", name, phoneNumber);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo pi = (PhoneInfo)obj;
	  	if(obj instanceof PhoneInfo) {
	 
			System.out.println("이건 어떠냐 : " + name.equals(((PhoneInfo) obj).name));
			return name.equals(((PhoneInfo) obj).name);
		}else {
			return false;
		}


//		if(pi.name.equals(this.name)) {
//			return true;
//		}else {
//			return false;				
//		}

	}
	
	
	
}

