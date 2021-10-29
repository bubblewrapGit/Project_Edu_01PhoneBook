package project1.ver08;

class PhoneCompanyInfo extends PhoneInfo {
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("  · 회사 : " + companyName);
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + " ｜ 전화번호 : " + phoneNumber + " ｜ 회사 : " + companyName;
	}
}

