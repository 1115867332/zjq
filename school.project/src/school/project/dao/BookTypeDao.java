package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.BookType;
import school.project.util.StringUtil;

public class BookTypeDao {

	public int add(Connection con,BookType bookType) throws SQLException {
		String sql = "insert into bookType value(null,?,?)";
		
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, bookType.getBookTypeName());
		ptsm.setString(2, bookType.getBookTypeDesc());
		
		return ptsm.executeUpdate();
	}
	public ResultSet list(Connection con,BookType bookType) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int delete(Connection con,String id) throws SQLException {
		String sql = "delete from bookType where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * 更新图书类别
	 */
	public int update(Connection con,BookType bookType) throws SQLException {
		String sql = "update bookType set bookTypeName = ? ,bookTypeDesc = ? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
}
