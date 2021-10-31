package project1.ver09;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;


public class managerSQL extends IConnectImpl{
	
	public managerSQL() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
//	void makeTable(); // 테이블 저장 쿼리실행
//	void dataInput(); //  입력 쿼리실행 PreparedStatement 
//	void dataSearch(); // 검색 쿼리실행 Statement 
//	void dataDelete(); // 삭제 쿼리실행 PreparedStatement 

	@Override
	public void makeTable() {
		try {
			stmt = con.createStatement();
			
			String sql ="CREATE TABLE phonebook_tb( "
					+ " idx number PRIMARY KEY, "
					+ " name VARCHAR2(50), "
					+ " phoneNumber VARCHAR2(50), "
					+ " birthday date)";
			
			stmt.executeQuery(sql);
			
			String seq ="CREATE sequence seq_phonebook "
					+ "    increment by 1 "
					+ "    nomaxvalue "
					+ "    minvalue 1 "
					+ "    nocycle "
					+ "    nocache";
			
			stmt.executeQuery(seq);
			
		}catch(Exception e) {
			// 테이블 + 시퀀스 생성부분 프로그램 실행시 작동된다.
			// 최초실행시 테이블 + 시퀀스가 만들어지고
			// 두번째 ~ 실행시 중복된 테이블로 생성이 불가능하다.
		}
	}
	
	
	@Override
	public void dataInput() {
		// 1. 쿼리문준비 : 값의 세팅이 필요한 부분을 ?(인파라미터)로 대체한다.
		
		//seq_phonebook.nextval, 
		try {
			stmt = con.createStatement();
			
			String query = "INSERT INTO phonebook_tb VALUES "
					+ "(seq_phonebook.NEXTVAL, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			// 3. 입력할 내용을 사용자로부터 입력받는다.		
			psmt.setString(1, scanValue("이름"));
			psmt.setString(2, scanValue("전화번호"));
			psmt.setString(3, scanValue("생일"));
			
			psmt.executeUpdate();// ★ 업데이트
			
			System.out.println("입력이 완료되었습니다.");
			
		}catch(SQLException e) {
			System.out.println("[ 실행에 문제가 발생하였습니다 ]");
		} catch (Exception e) {
			System.out.println("[ 알수 없는 오류가 발생하였습니다 ]");
		}
	}
	
	@Override
	public void dataSearch() {
		try {
			
			stmt = con.createStatement();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("찾는이름 : ");
			String searchName = scan.nextLine();
			
			String query = "SELECT idx, name, phoneNumber, "
					+ "	to_char(birthday, 'yyyy-mm-dd') birthday "
					+ " FROM phonebook_tb "
					+ " WHERE name LIKE '%" + searchName + "%' ";
			
			rs = stmt.executeQuery(query);
			
			boolean isFind = false;
			
			while(rs.next()){
				int idx = rs.getInt("idx"); 
				String name = rs.getString("name"); 
				String phoneNumber = rs.getString("phoneNumber");
				String birthday =rs.getString("birthday");
				
				System.out.printf("번호 : %d ｜ 이름 : %s ｜ 전화번호 : %s ｜ 생일 : %s",
						idx, name, phoneNumber, birthday);
				
				isFind = true;
			}
			
			if(isFind==false) {
				System.out.println("\n[" + searchName+ "] 데이터가 없습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println("[ 알수 없는 오류가 발생하였습니다 ]");
		}
	}
	
	@Override
	public void dataDelete() {
		try {
			// 1. 쿼리문 준비
			String query  = "DELETE FROM phonebook_tb WHERE name=?";
			// 2. 쿼리문을 인자로 prepared객체 생성
			psmt = con.prepareStatement(query);
			// 3. 인파라미터 설정
			psmt.setString(1, scanValue("삭제할아이디"));
			
			System.out.println("\n" +psmt.executeUpdate() +"행이 삭제 되었습니다.");
			
		} catch (Exception e) {
			System.out.println("[ 알수 없는 오류가 발생하였습니다 ]");
		}
	}
	
	@Override
	public void dataAllShow() {
		try {
			stmt = con.createStatement();

			// 쿼리 준비
			String query  = " SELECT idx, name, phoneNumber, to_char(birthday, 'YYYY-MM-DD') birthday "
					+ " FROM phonebook_tb";
				
			rs = stmt.executeQuery(query);
			
			boolean isFind = false;
			
			while(rs.next()){
				int idx = rs.getInt("idx"); 
				String name = rs.getString("name"); 
				String phoneNumber = rs.getString("phoneNumber");
				String birthday =rs.getString("birthday");
				
				System.out.printf("번호 : %2d ｜ 이름 : %3s ｜ 전화번호 : %13s ｜ 생일 : %10s \n",
						idx, name, phoneNumber, birthday);
				
				isFind = true;
			}
			
			if(isFind==false) {
				System.out.println("데이터가 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("[ 알수 없는 오류가 발생하였습니다 ]");
		}
		
	
		
	}

	public static void main(String[] args) {
		new managerSQL().makeTable();
		new managerSQL().dataInput();
		new managerSQL().dataSearch();
		new managerSQL().dataDelete();
	}
}
