/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

/**
 *
 * @author Administrator
 */

public class TaiKhoan {
    private  String tenDangNhap, matKhau, Quyen; 

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, String Quyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.Quyen = Quyen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }
    
}