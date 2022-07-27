package ch01;
// mybatis ����, ���İ�Ƽ �ڵ� �����, �ڵ� ����, Ʈ���� �ߺ��ڵ� �����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// jdbc ����ϱ�
public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null;
		// statement = query
		PreparedStatement stmt = null;
		// table�� ��� �뵵�� ����.
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// ���� �ٸ� �� �����ִ�. [�ϴ� �빮�ڴ� sql]
			String query = "SELECT USER_ID, USER_NAME, REG_DATE";
			query += " FROM USERS";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			//OR mapping(Object Relation)
			User user = null;
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setRegDate(rs.getDate(3));
				
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
	}
}