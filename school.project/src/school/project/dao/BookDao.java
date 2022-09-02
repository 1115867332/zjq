package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.Book;
import school.project.model.BookType;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

public class BookDao {
	private Connection con = DbUtil.getInstance().getConnection();
	public int add(Book book) throws SQLException {
		String sql = "insert into books values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, book.getBookIsbn());
		ptsm.setString(2, book.getBookName());
		ptsm.setInt(3, book.getTypeId());
		ptsm.setString(4, book.getBookSd());
		ptsm.setString(5, book.getBookCbs());
		ptsm.setString(6, book.getBookPd());
		ptsm.setString(7, book.getBookW());
		ptsm.setInt(8, book.getPage());
		ptsm.setInt(9, book.getCount());
		ptsm.setDouble(10, book.getBookPrice());
		return ptsm.executeUpdate();
	}
	public ResultSet list(Connection con) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from books");
		PreparedStatement ptsm = con.prepareStatement(sb.toString());
		return ptsm.executeQuery();
	}
}
