import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		TableNameDAO t = new TableNameDAO();
		t.tavleInsert(1, "kim");
		t.tavleInsert(2, "gim");
		t.tavleInsert(3, "qim");
		t.tavleInsert(4, "wim");
		t.tavleInsert(5, "eim");
		t.tavleInsert(6, "rim");
		
		t.tableSelect();
	}

}
