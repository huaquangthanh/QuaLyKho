package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuanLyKhoView;

public class QuanLyKhocontoller implements ActionListener{
	QuanLyKhoView quanLyKhoView;
	
	public QuanLyKhocontoller(QuanLyKhoView quanLyKhoView) {
		this.quanLyKhoView = quanLyKhoView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("Thêm")) {
			this.quanLyKhoView.themVaoCSDL_hangTrongKho();
			this.quanLyKhoView.themVaoJtable_hangTrongKho();
			this.quanLyKhoView.xoaForm();
		} else if(action.equals("Xóa")) {
			this.quanLyKhoView.xoaKhoiJtable_hangTrongKho();
			this.quanLyKhoView.xoaKhoiCSDL_hangTrongKho();
			this.quanLyKhoView.xoaForm();
		} else if(action.equals("Xóa")) {
			this.quanLyKhoView.xoaKhoiJtable_hangTrongKho();
			this.quanLyKhoView.xoaKhoiCSDL_hangTrongKho();
			this.quanLyKhoView.themVaoCSDL_hangTrongKho();
			this.quanLyKhoView.themVaoJtable_hangTrongKho();
			this.quanLyKhoView.xoaForm();
		}  else if(action.equals("Tìm Kiếm")) {
			this.quanLyKhoView.timKiemHangTrongKho();
		}   else if(action.equals("Hủy Tìm")) {
			this.quanLyKhoView.huyTimKiemChuaThanhToan();
		}  else if(action.equals("Xuất Kho")) {
			this.quanLyKhoView.xoaKhoiJtable_hangTrongKho();
			this.quanLyKhoView.xoaKhoiCSDL_hangTrongKho();
			this.quanLyKhoView.themVaoCSDL_xuatKho();
			this.quanLyKhoView.themVaoJtable_xuatKho();
			this.quanLyKhoView.xoaForm();
		}
		
	}

}
