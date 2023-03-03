package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.HangTrongKhoModel;
import database.JDBCUtil;

public class HangTrongKhoDAO implements DAOInterface<HangTrongKhoModel> {
	public static HangTrongKhoDAO getInstance() {
		return new HangTrongKhoDAO();
	}

	@Override
	public int insert(HangTrongKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO hangtrongkho (maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap) "+
						" VALUES ('"+t.getMaHang()+"' "
								+ ", '"+t.getTenHang()+"' "
								+ ", '"+t.getSoLuong()+"' "
								+ ", '"+t.getGiaMotDonHang()+"' "
								+ ", '"+t.getGiaNhap()+"' "
								+ ", '"+t.getNgayNhap()+"')";

			ketQua = st.executeUpdate(sql);
			
			// Bước 4:  sử lí kết quả đầu ra
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: ngắt kết nối với CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	@Override
	public int update(HangTrongKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE hangtrongkho "+
						 " SET " +
						 " tenHang='"+ t.getTenHang()+"'"
						 +", soLuong='"+ t.getSoLuong()+"'"
		 				 +", giaMotDonHang='"+ t.getGiaMotDonHang()+"'"
		 				 +", giaNhap='"+ t.getGiaNhap()+"'"
						 +", ngayNhap='"+ t.getNgayNhap()+ "'"
						 +" WHERE maHang='"+t.getMaHang()+"\'";
			
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	@Override
	public int delete(HangTrongKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from hangtrongkho " + "WHERE maHang = '" + t.getMaHang() + "'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	

}
