package test;

import javax.swing.UIManager;

import view.QuanLyKhoView;
import view.dangNhapView;

public class Test {
	
	
	public static void main(String[] args) {
		try {
			UIManager.setInstalledLookAndFeels(UIManager.getInstalledLookAndFeels());
			new dangNhapView();
			//new QuanLyKhoView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
