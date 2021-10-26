package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {
	public static void main(String[] args) {
		
		PhoneInfo pi1 = new PhoneInfo("유비", "010-1111-1111", "1980-10-10");
		pi1.showPhoneInfo();
		
		System.out.println();
		
		PhoneInfo pi2 = new PhoneInfo("류상미", "010-7669-4120");
		pi2.showPhoneInfo();
	}
}
