package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FlowerDAO {
	
	public int deletFlower(String del) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn();
			String sql="delete from flower where del=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, del);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return result;
	}
	
	public int insertFlower(FlowerDTO dto) {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="INSERT INTO flower VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCod());
			pstmt.setString(2, dto.getCategory());
			pstmt.setString(3, dto.getProduct());
			pstmt.setString(4, dto.getOps());
			pstmt.setString(5, dto.getUnit());
			pstmt.setInt(6, dto.getWearing());
			pstmt.setInt(7, dto.getShipping());
			pstmt.setInt(8, dto.getWcount());
			pstmt.setInt(9, dto.getScount());
			pstmt.setInt(10, dto.getStock());
		    pstmt.setString(11, dto.getDel());
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return result;
		
	}
	
	public int updateFlower(FlowerDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DB.dbConn();
			String sql= "update flower "
					+ "set category=?, product=?, ops=?,unit=?, wearing=?,"
					+ " shipping=?, wcount=?,scount=?,stock=(wcount-scount),del=? "
					+ "where cod=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getProduct());
			pstmt.setString(3, dto.getOps());
			pstmt.setString(4, dto.getUnit());
			pstmt.setInt(5, dto.getWearing());
			pstmt.setInt(6, dto.getShipping());
			pstmt.setInt(7, dto.getWcount());
			pstmt.setInt(8, dto.getScount());
			pstmt.setString(9, dto.getDel());
			pstmt.setInt(10, dto.getCod());
			
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return result;
	}
	
	public Vector searchFlower(String cod) {
		Vector items = new Vector();
	    Connection conn =null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
			conn = DB.dbConn();
			String sql= "select cod,category,product,ops,unit,wearing,shipping,wcount,scount,stock "
					+ " from flower where cod like ? order by cod";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+cod+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("cod"));
				row.add(rs.getString("category"));
				row.add(rs.getString("product"));
				row.add(rs.getString("ops"));
				row.add(rs.getString("unit"));
				row.add(rs.getInt("wearing"));
				row.add(rs.getInt("shipping"));
				row.add(rs.getInt("wcount"));
				row.add(rs.getInt("scount"));
				row.add(rs.getInt("stock"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	    return items;
	}
	
	public Vector listFlower() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql= "select cod,category,product,ops,unit,wearing,shipping,wcount,scount,stock,del "
					+ " from flower order by cod";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("cod"));
				row.add(rs.getString("category"));
				row.add(rs.getString("product"));
				row.add(rs.getString("ops"));
				row.add(rs.getString("unit"));
				row.add(rs.getInt("wearing"));
				row.add(rs.getInt("shipping"));
				row.add(rs.getInt("wcount"));
				row.add(rs.getInt("scount"));
				row.add(rs.getInt("stock"));
				row.add(rs.getString("del"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			try {
				if(conn!= null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return items;
		
	}

	

}
