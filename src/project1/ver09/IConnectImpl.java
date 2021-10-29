package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	인터페이스를 구현한 클래스로 extends 대신 implements를 사용한다.
	또한 용어도 '상속'이 아닌 '구현'이라 표현한다.
 */
public class IConnectImpl implements IConnect{
	
	public Connection con;
	public Statement stmt;	//정적쿼리 실행을 위한 객체
	public PreparedStatement psmt; // 동적쿼리 실행을 위한 객체
	public ResultSet rs;
	
	// 기본(디폴트) 생성자
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	
	// 접속 계정
	public IConnectImpl(String driver, String user, String pass) {
		try {
			Class.forName(driver);
			connect(user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	// 오라클에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	// 오버라이딩의 목적으로 정의한 메서드. 쿼리실행은 각 클래스에서 기술함.
	@Override
	public void makeTable() {} // 테이블생성
	@Override
	public void dataInput() {} // 입력
	@Override
	public void dataSearch() {} // 찾기
	@Override
	public void dataDelete() {} // 삭제
	@Override
	public void dataAllShow() {} // 출력
	
	
	// 자원반납
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		} catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	
	// 사용자로부터 입력값을 받기 위한 메서드
	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print(title + "을(를) 입력(exit -> 종료) : ");
		String inputStr = scan.nextLine();
		
		/*
			equalsIgnoreCase()
				: equals()와 동일하게 문자열이 같은지를 비교하는 메소드로
				  대소문자를 구분없이 비교할 수 있다.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			
			System.exit(0); // 프로그램 자체가 즉시 종료된다.
		}
		return inputStr;
	}
}
