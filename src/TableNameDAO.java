import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableNameDAO {	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/db?useSSL=false";

	static final String USERNAME = "kyung2687";
	static final String PASSWORD = "kyung3687";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public TableNameDAO() {
		System.out.print("DatabaseName 데이터베이스 접속 : ");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
			if(conn != null) System.out.print("성공!");
			else System.out.print("실패");
		} catch (ClassNotFoundException e) {
			System.out.print("Class Not Found");
		} catch (SQLException e) {
			System.out.print("SQL Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void tavleInsert(int no, String name) {
		TableName tn = new TableName(no, name);
		
		String query = "insert into user " + "value (" + tn.no + ", '" + tn.name + "');";
		
		System.out.println(query);
		
		try {
			Class.forName(JDBC_DRIVER);
			
			
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
		}
	}
	
	public void tableSelect() {
		String query = "select * from user";
		
		try { 
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			// executeUpdate -> insert, update, delete;
			// executeQuery -> DDL, select;
			while(rs.next()) {
				//tn.setNo(rs.getInt("no"));
				//tn.setName(rs.getString("name"));
				
				System.out.println("id : " + rs.getInt("id") + " name : " + rs.getString("name"));
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
		}
	}
}
