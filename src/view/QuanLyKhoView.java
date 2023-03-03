package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.QuanLyKhocontoller;
import dao.HangTrongKhoDAO;
import dao.QuanLyXuatKhoDAO;
import model.HangTrongKhoModel;
import model.QuanLyXuatKhoModel;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JSlider;

public class QuanLyKhoView extends JFrame {

	private JPanel contentPane;
	private JTable table_hangTrongKho;
	private JTable table_hangDaXuat;
	private JTextField textField_maHang;
	private JTextField textField_TenHang;
	private JTextField textField_soLuong;
	private JTextField textField_timKiem;
	private JTextField textField_giaMotDonHang;
	private JTextField textField_giaNhap;
	private JTextField textField_ngayNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhoView frame = new QuanLyKhoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public QuanLyKhoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("QUẢN LÝ XUẤT NHẬP HÀNG HÓA TRONG KHO");
		setBounds(100, 100, 1209, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ActionListener actionListener = new QuanLyKhocontoller(this);
	
		this.loadDataToJTable_hangTrongKho();
		this.loadDataToJTable_xuatKho();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1252, 741);
		contentPane.add(tabbedPane);
		
		JPanel panel_hangTrongKho = new JPanel();
		panel_hangTrongKho.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Nhập Kho", null, panel_hangTrongKho, null);
		panel_hangTrongKho.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table_hangTrongKho);
		scrollPane.setBounds(31, 105, 1137, 336);
		panel_hangTrongKho.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Mã Hàng");
		lblNewLabel.setBounds(20, 486, 75, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblNewLabel);
		
		JLabel lblTnHng = new JLabel("Tên Hàng");
		lblTnHng.setBounds(20, 540, 75, 31);
		lblTnHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblTnHng);
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setBounds(20, 602, 75, 30);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblSLng);
		
		JLabel lblnV = new JLabel("Giá Một Đơn Hàng");
		lblnV.setBounds(282, 486, 164, 31);
		lblnV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblnV);
		
		JLabel lblGi = new JLabel("Giá Nhập");
		lblGi.setBounds(282, 540, 91, 31);
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblGi);
		
		JLabel lblNgyNhp = new JLabel("Ngày Nhập");
		lblNgyNhp.setBounds(282, 602, 91, 31);
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_hangTrongKho.add(lblNgyNhp);
		
		textField_maHang = new JTextField();
		textField_maHang.setBounds(118, 487, 122, 34);
		panel_hangTrongKho.add(textField_maHang);
		textField_maHang.setColumns(10);
		
		textField_TenHang = new JTextField();
		textField_TenHang.setBounds(118, 541, 122, 34);
		textField_TenHang.setColumns(10);
		panel_hangTrongKho.add(textField_TenHang);
		
		textField_soLuong = new JTextField();
		textField_soLuong.setBounds(118, 603, 122, 34);
		textField_soLuong.setColumns(10);
		panel_hangTrongKho.add(textField_soLuong);
		
		JButton btnNewButton_them = new JButton("Thêm");
		btnNewButton_them.setForeground(new Color(51, 0, 255));
		btnNewButton_them.setBackground(new Color(255, 255, 204));
		btnNewButton_them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_them.addActionListener(actionListener);
		btnNewButton_them.setBounds(659, 482, 85, 35);
		panel_hangTrongKho.add(btnNewButton_them);
		
		JButton btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.setBackground(new Color(255, 255, 204));
		btnNewButton_xoa.setForeground(new Color(0, 0, 255));
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_xoa.addActionListener(actionListener);
		btnNewButton_xoa.setBounds(659, 542, 85, 31);
		panel_hangTrongKho.add(btnNewButton_xoa);
		
		JButton btnNewButton_sua = new JButton("Sửa");
		btnNewButton_sua.setBackground(new Color(255, 255, 204));
		btnNewButton_sua.setForeground(new Color(0, 0, 255));
		btnNewButton_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_sua.addActionListener(actionListener);
		btnNewButton_sua.setBounds(659, 604, 85, 30);
		panel_hangTrongKho.add(btnNewButton_sua);
		
		JButton bnt_xuatKho = new JButton("Xuất Kho");
		bnt_xuatKho.setBackground(new Color(255, 255, 204));
		bnt_xuatKho.setForeground(new Color(0, 0, 255));
		bnt_xuatKho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bnt_xuatKho.addActionListener(actionListener);
		bnt_xuatKho.setBounds(1068, 593, 114, 49);
		panel_hangTrongKho.add(bnt_xuatKho);
		
		JButton bnt_timKiem = new JButton("Tìm Kiếm");
		bnt_timKiem.setBackground(new Color(255, 255, 204));
		bnt_timKiem.setForeground(new Color(0, 0, 255));
		bnt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bnt_timKiem.addActionListener(actionListener);
		bnt_timKiem.setBounds(1068, 484, 114, 35);
		panel_hangTrongKho.add(bnt_timKiem);
		
		JButton bnt_huyTim = new JButton("Hủy Tìm");
		bnt_huyTim.setBackground(new Color(255, 255, 204));
		bnt_huyTim.setForeground(new Color(0, 0, 255));
		bnt_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bnt_huyTim.addActionListener(actionListener);
		bnt_huyTim.setBounds(1068, 538, 114, 34);
		panel_hangTrongKho.add(bnt_huyTim);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setBounds(817, 509, 203, 44);
		textField_timKiem.setColumns(10);
		panel_hangTrongKho.add(textField_timKiem);
		
		textField_giaMotDonHang = new JTextField();
		textField_giaMotDonHang.setBounds(441, 486, 122, 34);
		textField_giaMotDonHang.setColumns(10);
		panel_hangTrongKho.add(textField_giaMotDonHang);
		
		textField_giaNhap = new JTextField();
		textField_giaNhap.setBounds(441, 541, 122, 34);
		textField_giaNhap.setColumns(10);
		panel_hangTrongKho.add(textField_giaNhap);
		
		textField_ngayNhap = new JTextField();
		textField_ngayNhap.setBounds(441, 603, 122, 34);
		textField_ngayNhap.setColumns(10);
		panel_hangTrongKho.add(textField_ngayNhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("NHẬP XUẤT HÀNG HOÁ TRONG KHO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_1_1.setBounds(296, 34, 581, 40);
		panel_hangTrongKho.add(lblNewLabel_1_1);
		
		JPanel panel_hangDaXuat = new JPanel();
		panel_hangDaXuat.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Hàng Đã Xuất", null, panel_hangDaXuat, null);
		panel_hangDaXuat.setLayout(null);
		this.setVisible(true);
//		table_hangDaXuat = new JTable();
//		table_hangDaXuat.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column", "New column"
//			}
//		));
//		table_hangTrongKho = new JTable(new DefaultTableModel(
//		      	new Object[][] {
//		      		{null, null, null, null, null, null},
//		      		{null, null, null, null, null, null},
//		      	},
//		      	new String[] {
//		      		"New column", "New column", "New column", "New column", "New column", "New column"
//		      	}
//		      ));
		JScrollPane scrollPane_1 = new JScrollPane(table_hangDaXuat);
		scrollPane_1.setBounds(27, 125, 1133, 531);
		panel_hangDaXuat.add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("HÀNG ĐÃ XUẤT KHO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(427, 39, 387, 40);
		panel_hangDaXuat.add(lblNewLabel_1);
		
//		Sự kiện click chuột trái lên 1 dòng trong JTable
		table_hangTrongKho.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table_hangTrongKho.getSelectedRow();
		        textField_maHang.setText(table_hangTrongKho.getValueAt(selectedRow, 0).toString());
		        textField_TenHang.setText(table_hangTrongKho.getValueAt(selectedRow, 1).toString());
		        textField_soLuong.setText(table_hangTrongKho.getValueAt(selectedRow, 2).toString());
		        textField_giaMotDonHang.setText(table_hangTrongKho.getValueAt(selectedRow, 3).toString());
		        textField_giaNhap.setText(table_hangTrongKho.getValueAt(selectedRow, 4).toString());
		        textField_ngayNhap.setText(table_hangTrongKho.getValueAt(selectedRow, 5).toString());
		    }
		});
		
	}
	public void xoaForm() {
		textField_maHang.setText("");
		textField_TenHang.setText("");
		textField_soLuong.setText("");
		textField_giaMotDonHang.setText("");
		textField_giaNhap.setText("");
		textField_ngayNhap.setText("");
	}

	public void loadDataToJTable_hangTrongKho() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/kho";
	    String user = "root";
	    String password = "";
	    String query = "SELECT * FROM hangtrongkho";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("Mã Hàng", 0);
	      columns_name.setElementAt("Tên Hàng", 1);
	      columns_name.setElementAt("Số Lượng", 2);
	      columns_name.setElementAt("Giá Một Đơn Hàng", 3);
	      columns_name.setElementAt("Giá Nhập", 4);
	      columns_name.setElementAt("Ngày Nhập", 5);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      table_hangTrongKho = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	public void loadDataToJTable_xuatKho() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/kho";
	    String user = "root";
	    String password = "";
	    String query = "SELECT * FROM quanlyxuatkho";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("Mã Hàng", 0);
	      columns_name.setElementAt("Tên Hàng", 1);
	      columns_name.setElementAt("Số Lượng", 2);
	      columns_name.setElementAt("Giá Một Đơn Hàng", 3);
	      columns_name.setElementAt("Giá Nhập", 4);
	      columns_name.setElementAt("Ngày Nhập", 5);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      table_hangDaXuat = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	public void themVaoCSDL_hangTrongKho() {
		try {
			String maHang = textField_maHang.getText();
			String tenHang = textField_TenHang.getText();
			int soLuong = Integer.parseInt(textField_soLuong.getText());
			double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
			double giaNhap = soLuong * giaMotDonHang;
//			double giaNhap = Double.valueOf(textField_giaNhap.getText());
			String ngayNhap = textField_ngayNhap.getText();

			HangTrongKhoModel model = new HangTrongKhoModel(maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap);
			HangTrongKhoDAO.getInstance().insert(model);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoCSDL_xuatKho() {
		try {
			String maHang = textField_maHang.getText();
			String tenHang = textField_TenHang.getText();
			int soLuong = Integer.parseInt(textField_soLuong.getText());
			double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
			double giaNhap = soLuong * giaMotDonHang;
//			double giaNhap = Double.valueOf(textField_giaNhap.getText());
			String ngayNhap = textField_ngayNhap.getText();

			QuanLyXuatKhoModel model = new QuanLyXuatKhoModel(maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap);
			QuanLyXuatKhoDAO.getInstance().insert(model);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoJtable_hangTrongKho() {
		String maHang = textField_maHang.getText();
		String tenHang = textField_TenHang.getText();
		int soLuong = Integer.parseInt(textField_soLuong.getText());
		double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
		double giaNhap = soLuong * giaMotDonHang;
//		double giaNhap = Double.valueOf(textField_giaNhap.getText());
		String ngayNhap = textField_ngayNhap.getText();
		
		DefaultTableModel model = (DefaultTableModel) table_hangTrongKho.getModel();
		model.addRow(new Object[] {	maHang, 
				tenHang, 
				soLuong, 
				giaMotDonHang,  
				giaNhap, 
				ngayNhap});
	}
	public void themVaoJtable_xuatKho() {
		String maHang = textField_maHang.getText();
		String tenHang = textField_TenHang.getText();
		int soLuong = Integer.parseInt(textField_soLuong.getText());
		double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
		double giaNhap = soLuong * giaMotDonHang;
//		double giaNhap = Double.valueOf(textField_giaNhap.getText());
		String ngayNhap = textField_ngayNhap.getText();
		
		DefaultTableModel model = (DefaultTableModel) table_hangDaXuat.getModel();
		model.addRow(new Object[] {	maHang, 
				tenHang, 
				soLuong, 
				giaMotDonHang,  
				giaNhap, 
				ngayNhap});
	}
	public void xoaKhoiJtable_hangTrongKho() {
		DefaultTableModel model = (DefaultTableModel) table_hangTrongKho.getModel();
		int selectedRow = table_hangTrongKho.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiJtable_xuatKho() {
		DefaultTableModel model = (DefaultTableModel) table_hangDaXuat.getModel();
		int selectedRow = table_hangDaXuat.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiCSDL_hangTrongKho() {
		try {
			String maHang = textField_maHang.getText();
			String tenHang = textField_TenHang.getText();
			int soLuong = Integer.parseInt(textField_soLuong.getText());
			double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
			double giaNhap = soLuong * giaMotDonHang;
//			double giaNhap = Double.valueOf(textField_giaNhap.getText());
			String ngayNhap = textField_ngayNhap.getText();

			HangTrongKhoModel model = new HangTrongKhoModel(maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap);
			HangTrongKhoDAO.getInstance().delete(model);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void xoaKhoiCSDL_xuatKho() {
		try {
			String maHang = textField_maHang.getText();
			String tenHang = textField_TenHang.getText();
			int soLuong = Integer.parseInt(textField_soLuong.getText());
			double giaMotDonHang = Double.valueOf(textField_giaMotDonHang.getText());
			double giaNhap = soLuong * giaMotDonHang;
//			double giaNhap = Double.valueOf(textField_giaNhap.getText());
			String ngayNhap = textField_ngayNhap.getText();

			QuanLyXuatKhoModel model = new QuanLyXuatKhoModel(maHang, tenHang, soLuong, giaMotDonHang, giaNhap, ngayNhap);
			QuanLyXuatKhoDAO.getInstance().delete(model);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void timKiemHangTrongKho() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(table_hangTrongKho.getModel());
		table_hangTrongKho.setRowSorter(sorter1);
		
		String text = textField_timKiem.getText(); // Lấy từ khóa tìm kiếm từ JTextField
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter1.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});
	}
	public void huyTimKiemChuaThanhToan() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(table_hangTrongKho.getModel());
		table_hangTrongKho.setRowSorter(sorter1);
		
		String text = ""; // Lấy từ khóa tìm kiếm từ JTextField
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter1.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});
	}
	
}
