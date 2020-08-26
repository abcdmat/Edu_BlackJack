package com.edu.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.database.Access_DB;
import com.edu.database.dto.CasinoDto;

//Data Access Object
public class CasinoDao extends Access_DB{
	public boolean update(CasinoDto dto) {
		boolean isc = false;
		Connection conn =null;
		PreparedStatement stmt = null;
		String sql = "UPDATE SQLD.GAMER SET GAMER.MONEY = ? , GAMER.RECENT_VISIT = sysdate WHERE GAMER.NAME = ?" ;
		sql.trim();
		sql = " ".concat(sql).concat(" ");
		
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dto.getMONEY());
			stmt.setString(2, dto.getNAME());
			int isDo = stmt.executeUpdate();

			isc = (isDo != 0)? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, stmt, null);
			
		}
		

		
		return isc;
	}
	public CasinoDto selectOne(String id , String password) {
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CasinoDto dto = new CasinoDto();
		String sql = "SELECT * FROM SQLD.GAMER WHERE ID = ? AND PASSWORD =?";
		sql.trim();
		sql = " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, password);
			System.out.println("3. PreparedQuery Success");
			rs = stmt.executeQuery();
			System.out.println("4. Execute QuerySuccess");
			
			while (rs.next()) {
				dto = new CasinoDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);
			}
			System.out.println("5. GetResult Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, stmt, rs);
		}
		return dto;
	}
	
	//SELECTALL���� �غ���
	public ArrayList<CasinoDto> selectAll(){
		ArrayList<CasinoDto> ResultLists = new ArrayList<CasinoDto>();
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM GAMER";
		sql.trim();
		sql = " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			System.out.println("3. PreparedQuery Success");
			rs = stmt.executeQuery();
			System.out.println("4. Execute QuerySuccess");
			
			while (rs.next()) {
				ResultLists.add(
						new CasinoDto(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getInt(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8)
								)) ;
				
			}
			System.out.println("5. GetResult Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, stmt, rs);
		}
		
		
		return ResultLists; 
	}
}
