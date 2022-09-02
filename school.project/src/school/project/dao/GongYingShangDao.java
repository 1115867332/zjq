package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.GongYingShang;
import school.project.model.Publish;
import school.project.util.DbUtil;
import school.project.util.StringUtil;


public class GongYingShangDao {
	
	public int add(GongYingShang gongYingShang) throws SQLException {
		String sql = "insert into gongyingshang value(null,?,?,?,?)";
		Connection con = DbUtil.getInstance().getConnection();
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, gongYingShang.getPeople());
		ptsm.setString(2, gongYingShang.getDz());
		ptsm.setString(3, gongYingShang.getTel());
		ptsm.setString(4, gongYingShang.getGys_name());
		return ptsm.executeUpdate();
	}
	public ResultSet list(GongYingShang gongYingShang) throws SQLException {
		Connection con = DbUtil.getInstance().getConnection();
		String sql = ("select * from gongyingshang");
		PreparedStatement ptsm = con.prepareStatement(sql);
		return ptsm.executeQuery();
	}
}
