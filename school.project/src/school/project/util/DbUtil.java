package school.project.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbUtil {
	private Connection connection;
	private DbUtil() {}
	private static DbUtil instance = new DbUtil();//µ¥ÀýÄ£Ê½
	
	
	public static DbUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksmanagement","root","1203");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeCon(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
}
