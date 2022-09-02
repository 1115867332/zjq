package school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import school.project.model.Publish;
import school.project.util.StringUtil;

public class PublishDao {
	public int add(Connection con,Publish publish) throws SQLException {
		String sql = "insert into Cbs value(null,?,?,?,?)";
		
		PreparedStatement ptsm = con.prepareStatement(sql);
		ptsm.setString(1, publish.getCbsName());
		ptsm.setString(2, publish.getCbsTel());
		ptsm.setString(3, publish.getCbsCp());
		ptsm.setString(4, publish.getCbsDz());
		return ptsm.executeUpdate();
	}
	public ResultSet list(Connection con,Publish publish) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from Cbs");
		if(StringUtil.isNotEmpty(publish.getCbsName())) {
			sb.append(" and Cbs_name like '%"+publish.getCbsName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int delete(Connection con,String id) throws SQLException {
		String sql = "delete from Cbs where Cbs_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * 更新出版社
	 */
	public int update(Connection con,Publish publish) throws SQLException {
		String sql = "update Cbs set Cbs_name = ? ,Cbs_tel = ? ,Cbs_cp =?,Cbs_dz=? where Cbs_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, publish.getCbsName());
		pstmt.setString(2, publish.getCbsTel());
		pstmt.setString(3, publish.getCbsCp());
		pstmt.setString(4, publish.getCbsDz());
		pstmt.setInt(5, publish.getId());
		return pstmt.executeUpdate();
	}
}
