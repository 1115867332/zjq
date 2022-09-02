package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.User;

/*
 * 用户dao类
 * 
 */
public class UserDao {
	public User login(Connection con,User user) throws SQLException {
		User resultUser = null;
		String sql = "select * from user where username=? and password=?";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, user.getUserName());
		ptsm.setString(2, user.getPassword());
		ResultSet rs = ptsm.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setUserName(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	/*
	 * 添加管理员
	 */
	public void userAdd(Connection con,User user) throws SQLException {
		User resultUser = null;
		String sql = "insert into user values(?,?,?,?)";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, user.getUserName());
		ptsm.setString(2, user.getSex());
		ptsm.setString(3, user.getAddress());
		ptsm.setString(4, user.getPassword());
		ptsm.execute();
	}
	/*
	 * 删除管理员
	 */
	public int userDelete(Connection con,int id) throws SQLException {
		String sql = "delete from user where id=?";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setInt(1, id);
		return ptsm.executeUpdate();
	}
	/*
	 * 管理员信息查询
	 */
	public ResultSet list(Connection con) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from user");
		PreparedStatement ptsm = con.prepareStatement(sb.toString());
		return ptsm.executeQuery();//返回结果集合
	}
	
}
