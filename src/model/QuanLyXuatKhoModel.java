package model;

import java.util.Objects;

public class QuanLyXuatKhoModel {
	private String maHang, tenHang;
	private int soLuong;
	private double giaMotDonHang, giaNhap;
	private String ngayNhap;
	public QuanLyXuatKhoModel() {
	}
	public QuanLyXuatKhoModel(String maHang, String tenHang, int soLuong, double giaMotDonHang, double giaNhap,
			String ngayNhap) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.giaMotDonHang = giaMotDonHang;
		this.giaNhap = giaNhap;
		this.ngayNhap = ngayNhap;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaMotDonHang() {
		return giaMotDonHang;
	}
	public void setGiaMotDonHang(double giaMotDonHang) {
		this.giaMotDonHang = giaMotDonHang;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	@Override
	public String toString() {
		return "QuanLyXuatKhoModel [maHang=" + maHang + ", tenHang=" + tenHang + ", soLuong=" + soLuong
				+ ", giaMotDonHang=" + giaMotDonHang + ", giaNhap=" + giaNhap + ", ngayNhap=" + ngayNhap + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(giaMotDonHang, giaNhap, maHang, ngayNhap, soLuong, tenHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanLyXuatKhoModel other = (QuanLyXuatKhoModel) obj;
		return Double.doubleToLongBits(giaMotDonHang) == Double.doubleToLongBits(other.giaMotDonHang)
				&& Double.doubleToLongBits(giaNhap) == Double.doubleToLongBits(other.giaNhap)
				&& Objects.equals(maHang, other.maHang) && Objects.equals(ngayNhap, other.ngayNhap)
				&& soLuong == other.soLuong && Objects.equals(tenHang, other.tenHang);
	}
	
}
