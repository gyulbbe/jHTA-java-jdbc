package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "hta";
	private static final String PASSWORD = "zxcv1234";
	
	/*
	 * static 초기화 블록
	 * - ConnectionUtils 클래스가 메모리에 로딩될 때 실행된다.
	 * - 오라클 JDBC 드라이버를 로딩해서 레지스트리에 등록시킨다.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 데이터베이스와 연결된 Connection 객체를 반환한다.
	 * @return 데이터베이스와 연결된 Connection 객체
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}