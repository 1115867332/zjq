package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChuKuDao {
		
	public int chuku(Connection con,String id,int sum,int D_no) throws SQLException {
		
		String sql = "update  books set Tm_count = Tm_count-? where Tm_isbn=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sum);
		pstmt.setString(2, id);
		String sql2 = "update orders set D_state= \"ÒÑ¾­³ö¿â\"  where D_no=?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setInt(1, D_no);
		pstmt2.executeUpdate();
		return pstmt.executeUpdate();
	}
}
