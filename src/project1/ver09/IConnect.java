package project1.ver09;

public interface IConnect {
	
	/*
		멤버상수
			: 인터페이스에 선언된 변수는
			  무조건 public static final이 붙어 정적 상수로 선언된다.
	 */
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:xe";
	
	/*
		멤버추상메서드
			: public abstract가 붙어 추상메서드로 선언된다.
	 */
	void connect(String user, String pass); // DB연결
	void makeTable(); //  테이블 생성
	void dataInput(); //  입력 쿼리실행 PreparedStatement 
	void dataSearch(); // 검색 쿼리실행 Statement 
	void dataDelete(); // 삭제 쿼리실행 PreparedStatement 
	void dataAllShow();// 주소록 출력 쿼리실행
	void close(); // 자원반납
	
	// 사용자 입력을 위한 추상메서드 선언(매번 입력받을때마다 사용할 순 없으니 추상메서드를 생성해서 편리하게 사용)
	String scanValue(String title);
}
