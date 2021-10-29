package project1.ver08;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AutoSaverT extends Thread{

	PhoneBookManager pm;
	
	public AutoSaverT(PhoneBookManager pm) {
		this.pm = pm;
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				PrintWriter out = 
						new PrintWriter(
							new FileWriter("src/project1/ver08/AutoSaveBook.txt")
						);
				System.out.println();
				System.out.println("-------------------------------[ 자동저장 ]");
				
				for(PhoneInfo in : pm.myPhoneBook) {
					out.println(in);
				}
				out.close();
				sleep(5000);
			}
		} catch (Exception e) {
			
		}
	}
}
