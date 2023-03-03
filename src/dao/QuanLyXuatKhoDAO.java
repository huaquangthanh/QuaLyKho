package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.QuanLyXuatKhoModel;
import database.JDBCUtil;

public class QuanLyXuatKhoDAO implements DAOInterface<QuanLyXuatKhoModel> {
	public static QuanLyXuatKhoDAO getInstance() {
		return new QuanLyXuatKhoDAO();
	}

	@Override
	public int insert(QuanLyXuatKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO quanlyxuatkho (maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap) "+
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
	public int update(QuanLyXuatKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE quanlyxuatkho "+
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
	public int delete(QuanLyXuatKhoModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from quanlyxuatkho " + "WHERE maHang = '" + t.getMaHang() + "'";
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
