package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import school.project.model.DingDan;
import school.project.util.DbUtil;

public class DingDanDao {
	
	public int add(DingDan dingDan) throws SQLException {
		String sql = "insert into dingdan value(null,?,?,?,?)";
		Connection con = DbUtil.getInstance().getConnection();
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, dingDan.getIsbn());
		ptsm.setString(2, dingDan.getName());
		ptsm.setString(3, dingDan.getGys());
		ptsm.setInt(4, dingDan.getCount());
		return ptsm.executeUpdate();
	}
}
