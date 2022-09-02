package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.SdeptUser;
import school.project.model.User;

public class SdeptUserDao {
	public SdeptUser login(Connection con,SdeptUser sdeptUser) throws SQLException {
		SdeptUser resultSdeptUser = null;
		String sql = "select * from sdeptuser where sdept=? and password=?";
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, sdeptUser.getSdept());
		ptsm.setString(2, sdeptUser.getPassword());
		ResultSet rs = ptsm.executeQuery();
		if(rs.next()) {
			resultSdeptUser = new SdeptUser();
			resultSdeptUser.setSdept(rs.getString("sdept"));
			resultSdeptUser.setPassword(rs.getString("password"));
		}
		return resultSdeptUser;
	}
}
