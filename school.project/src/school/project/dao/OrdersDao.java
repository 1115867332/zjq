package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.Orders;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

public class OrdersDao {
	public void OrdersAdd(Connection con,Orders orders) throws SQLException {
		Orders resultOrders = null;
		String sql = "insert into orders values(null,?,?,?,?,?,null,?)";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, orders.getIsbn());
		ptsm.setString(2, orders.getMname());
		ptsm.setString(3,orders.getTime());
		ptsm.setInt(4, orders.getCount());
		ptsm.setString(5, orders.getSdept());
		ptsm.setString(6, orders.getState());
		ptsm.execute();
	}
	public ResultSet list(Connection con,String sdept) throws SQLException {
		
		StringBuffer sb = new StringBuffer("select * from orders");
		if(StringUtil.isNotEmpty(sdept)) {
			sb.append(" where D_sdept like '%"+sdept+"%'");//待改
		}
		PreparedStatement ptsm = con.prepareStatement(sb.toString());
		return ptsm.executeQuery();//返回结果集合
	}
	public int updateOrders(Orders orders) throws SQLException {
		Connection con = DbUtil.getInstance().getConnection();
		String sql = "update orders set D_isbn=?,D_tmname=?,D_count=? where D_no=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, orders.getIsbn());
		pstmt.setString(2, orders.getMname());
		pstmt.setInt(3, orders.getCount());
		pstmt.setInt(4, orders.getId());
		return pstmt.executeUpdate();
	}
	public int deleteOrders(int id) throws SQLException {
		Connection con = DbUtil.getInstance().getConnection();
		String sql = "delete from orders where D_no=?";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setInt(1, id);
		return ptsm.executeUpdate();
		
	}
}
