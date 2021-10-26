package project1.ver06;

class PhoneCompanyInfo extends PhoneInfo {
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("\n[회사 주소록]");
		super.showPhoneInfo();
		System.out.printf(">>>> | 회사 : %s \n", companyName);
	}
}

