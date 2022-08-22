/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import Frm.ChucVu;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Frm.DangNhap;

/**
 *
 * @author Administrator
 */
public class FrmTrangChu extends javax.swing.JFrame {

    private FrmNhanVien NhanVien;
    private FrmTaiKhoan TaiKhoan;
    private ChucVu chucVu;
    private FrmKhachHang KhachHang;
    private FrmNhaCungCap NhaCungCap;
    private FrmLoaiSanPham LoaiSanPham;
    private FrmSanPham SanPham;
    private FrmPhieuNhap PhieuNhap;
    private FrmChiTietPhieuNhap CTPhieuNhap;
    private FrmHoaDon HoaDon;
    private FrmChiTietHoaDon CTHoaDon;
    private FrmDoiMk DoiMk;
    private FrmThongKe ThongKe;
    private int idQuyen;
    
    public FrmTrangChu() {
        initComponents(); 
        Ktra();
        setLocationRelativeTo(null);
    }
    public FrmTrangChu(int idQuyen) {
        initComponents(); 
        setLocationRelativeTo(null);
        this.idQuyen = idQuyen;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tplMainBoard = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnClose = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnDoiMK = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnDangXuat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuNhanVien = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuTaiKhoan = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuChucVu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuThongKe = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuKhachHang = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuNhaCungCap = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnuHoaDon = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuCTHoaDon = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuSanPham = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuLoaiSanPham = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuPhieuNhap = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuCTPhieuNhap = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tplMainBoard.setBackground(new java.awt.Color(255, 204, 204));

        jToolBar1.setRollover(true);

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel_16x16.png"))); // NOI18N
        btnClose.setText("Đóng");
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClose);
        jToolBar1.add(jSeparator5);

        btnDoiMK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Remove_16x16.png"))); // NOI18N
        btnDoiMK.setText("Đổi mật khẩu ");
        btnDoiMK.setFocusable(false);
        btnDoiMK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoiMK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDoiMK);
        jToolBar1.add(jSeparator10);

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Log Out_16x16.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Archive-manage-icon.png"))); // NOI18N
        jMenu1.setText("Quản lí ");

        mnuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/engineer-icon.png"))); // NOI18N
        mnuNhanVien.setText("Nhân viên");
        mnuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNhanVienActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNhanVien);
        jMenu1.add(jSeparator1);

        mnuTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reseller-account-template-icon.png"))); // NOI18N
        mnuTaiKhoan.setText("Tài khoản ");
        mnuTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTaiKhoanActionPerformed(evt);
            }
        });
        jMenu1.add(mnuTaiKhoan);
        jMenu1.add(jSeparator2);

        mnuChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/company/quanlyshopquanao/icons/Person-Male-Light-icon-16.png"))); // NOI18N
        mnuChucVu.setText("Chức vụ");
        mnuChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChucVuActionPerformed(evt);
            }
        });
        jMenu1.add(mnuChucVu);
        jMenu1.add(jSeparator6);

        mnuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt-sticky-note-icon.png"))); // NOI18N
        mnuThongKe.setText("Thống kê");
        mnuThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThongKeActionPerformed(evt);
            }
        });
        jMenu1.add(mnuThongKe);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Groups-Meeting-Light-icon.png"))); // NOI18N
        jMenu2.setText("Khách hàng");

        mnuKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-group-icon.png"))); // NOI18N
        mnuKhachHang.setText("Khách hàng ");
        mnuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKhachHangActionPerformed(evt);
            }
        });
        jMenu2.add(mnuKhachHang);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Office-Customer-Male-Light-icon.png"))); // NOI18N
        jMenu3.setText("Đối tác ");

        mnuNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Facebook-shop-icon.png"))); // NOI18N
        mnuNhaCungCap.setText("Nhà cung cấp ");
        mnuNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNhaCungCapActionPerformed(evt);
            }
        });
        jMenu3.add(mnuNhaCungCap);

        jMenuBar1.add(jMenu3);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt-invoice-icon.png"))); // NOI18N
        jMenu6.setText("Hóa đơn");

        mnuHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipts-text-icon.png"))); // NOI18N
        mnuHoaDon.setText("Hóa đơn");
        mnuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHoaDonActionPerformed(evt);
            }
        });
        jMenu6.add(mnuHoaDon);
        jMenu6.add(jSeparator3);

        mnuCTHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt-pencil-icon.png"))); // NOI18N
        mnuCTHoaDon.setText("Chi tiết hóa đơn ");
        mnuCTHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCTHoaDonActionPerformed(evt);
            }
        });
        jMenu6.add(mnuCTHoaDon);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/t-shirt-icon.png"))); // NOI18N
        jMenu4.setText("Sản phẩm ");

        mnuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/t-shirt-icon.png"))); // NOI18N
        mnuSanPham.setText("Sản phẩm ");
        mnuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSanPhamActionPerformed(evt);
            }
        });
        jMenu4.add(mnuSanPham);
        jMenu4.add(jSeparator4);

        mnuLoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_store_front_32.png"))); // NOI18N
        mnuLoaiSanPham.setText("Loại sản phẩm ");
        mnuLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoaiSanPhamActionPerformed(evt);
            }
        });
        jMenu4.add(mnuLoaiSanPham);
        jMenu4.add(jSeparator7);

        mnuPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt-sticky-note-icon.png"))); // NOI18N
        mnuPhieuNhap.setText("Phiếu nhập ");
        mnuPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPhieuNhapActionPerformed(evt);
            }
        });
        jMenu4.add(mnuPhieuNhap);
        jMenu4.add(jSeparator8);

        mnuCTPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt-pencil-icon.png"))); // NOI18N
        mnuCTPhieuNhap.setText("Chi tiết phiếu nhập");
        mnuCTPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCTPhieuNhapActionPerformed(evt);
            }
        });
        jMenu4.add(mnuCTPhieuNhap);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tplMainBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tplMainBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Ktra(){
        if(sharedata.ngdangnhap.getQuyen().equals("0")){
            mnuNhanVien.setEnabled(true);
            mnuTaiKhoan.setEnabled(true);
            mnuChucVu.setEnabled(true);
        }else if(sharedata.ngdangnhap.getQuyen().equals("1")){
            mnuNhanVien.setEnabled(false);
            mnuTaiKhoan.setEnabled(false);
            mnuChucVu.setEnabled(false);
        }
    }
    private void mnuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNhanVienActionPerformed
        if(NhanVien == null){
            try {
                if (idQuyen==0) {
                    NhanVien = new FrmNhanVien();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn không có quyền quản trị");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Quản lí nhân viên",NhanVien);
        }
        tplMainBoard.setSelectedComponent(NhanVien);
    }//GEN-LAST:event_mnuNhanVienActionPerformed

    private void mnuTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTaiKhoanActionPerformed
        if(TaiKhoan == null){
            try {
                if (idQuyen==0) {
                    TaiKhoan = new FrmTaiKhoan();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn không có quyền quản trị");
                    return;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Quản lí tài khoản",TaiKhoan);
        }
        tplMainBoard.setSelectedComponent(TaiKhoan);
    }//GEN-LAST:event_mnuTaiKhoanActionPerformed

    private void mnuChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChucVuActionPerformed
        if(chucVu == null){
           try {
               if (idQuyen==0) {
                    chucVu = new ChucVu();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn không có quyền quản trị");
                    return;
                }
           } catch (SQLException ex) {
               Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
           }
        tplMainBoard.addTab ("Quản lí chức vụ",chucVu);
        }
        tplMainBoard.setSelectedComponent(chucVu); 
    }//GEN-LAST:event_mnuChucVuActionPerformed

    private void mnuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKhachHangActionPerformed
        if(KhachHang == null){
            try {
                KhachHang = new FrmKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Quản lí khách hàng",KhachHang);
        }
        tplMainBoard.setSelectedComponent(KhachHang);
    }//GEN-LAST:event_mnuKhachHangActionPerformed

    private void mnuNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNhaCungCapActionPerformed
        if(NhaCungCap == null){
        NhaCungCap = new FrmNhaCungCap();
        tplMainBoard.addTab ("Nhà cung cấp",NhaCungCap);
        }
        tplMainBoard.setSelectedComponent(NhaCungCap);
    }//GEN-LAST:event_mnuNhaCungCapActionPerformed

    private void mnuPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPhieuNhapActionPerformed
        if(PhieuNhap == null){
        PhieuNhap = new FrmPhieuNhap();
        tplMainBoard.addTab ("Phiếu nhập",PhieuNhap);
        }
        tplMainBoard.setSelectedComponent(PhieuNhap);
    }//GEN-LAST:event_mnuPhieuNhapActionPerformed

    private void mnuLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoaiSanPhamActionPerformed
        if(LoaiSanPham == null){
            try {
                LoaiSanPham = new FrmLoaiSanPham();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Loại sản phẩm",LoaiSanPham);
        }
        tplMainBoard.setSelectedComponent(LoaiSanPham);
    }//GEN-LAST:event_mnuLoaiSanPhamActionPerformed

    private void mnuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSanPhamActionPerformed
        if(SanPham == null){
            try {
                SanPham = new FrmSanPham();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Sản phẩm",SanPham);
        }
        tplMainBoard.setSelectedComponent(SanPham);
    }//GEN-LAST:event_mnuSanPhamActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void mnuCTPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCTPhieuNhapActionPerformed
       if(CTPhieuNhap == null){
           try {
               CTPhieuNhap = new FrmChiTietPhieuNhap();
           } catch (SQLException ex) {
               Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
           }
        tplMainBoard.addTab ("Chi tiết phiếu nhập",CTPhieuNhap);
        }
        tplMainBoard.setSelectedComponent(CTPhieuNhap); 
    }//GEN-LAST:event_mnuCTPhieuNhapActionPerformed

    private void mnuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHoaDonActionPerformed
        if(HoaDon == null){
            try {
                HoaDon = new FrmHoaDon();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Hóa đơn",HoaDon);
        }
        tplMainBoard.setSelectedComponent(HoaDon);
    }//GEN-LAST:event_mnuHoaDonActionPerformed

    private void mnuCTHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCTHoaDonActionPerformed
        if(CTHoaDon == null){
            try {
                CTHoaDon = new FrmChiTietHoaDon();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Chi tiết hóa đơn",CTHoaDon);
        }
        tplMainBoard.setSelectedComponent(CTHoaDon);
    }//GEN-LAST:event_mnuCTHoaDonActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       Component selected = tplMainBoard.getSelectedComponent();
        if (selected != null) {
            tplMainBoard.remove(selected);
            chucVu=null;
            KhachHang=null;
            NhaCungCap=null;
            LoaiSanPham=null;
            SanPham=null;
            PhieuNhap=null;
            TaiKhoan = null;
            NhanVien = null;
            HoaDon = null;
            CTHoaDon = null;
            CTPhieuNhap = null;
            ThongKe = null;
            }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        DangNhap dangNhap = new DangNhap();
        dangNhap.show();
        this.dispose();
        
//        processLoginSuccessfull();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        FrmDoiMk doiMk = new FrmDoiMk();
            doiMk.show();
            this.dispose();
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void mnuThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThongKeActionPerformed
        if(ThongKe == null){
            try {
                ThongKe = new FrmThongKe();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        tplMainBoard.addTab ("Thống Kê Doanh Thu",ThongKe);
        }
        tplMainBoard.setSelectedComponent(ThongKe);
    }//GEN-LAST:event_mnuThongKeActionPerformed
//    private void processLoginSuccessfull(){
//        lblTenDangNhap.setText(sharedata.ngdangnhap.getTenDangNhap());
//        lblQuyen.setText(sharedata.ngdangnhap.getQuyen());
//        
//        if(sharedata.ngdangnhap.getQuyen().equals("Admin")){
//            mnuNhanVien.setEnabled(true);
//            mnuTaiKhoan.setEnabled(true);
//            mnuChucVu.setEnabled(true);
//        }else if(sharedata.ngdangnhap.getQuyen().equals("Nhân Viên")){
//            mnuNhanVien.setEnabled(false);
//            mnuTaiKhoan.setEnabled(false);
//            mnuChucVu.setEnabled(false);
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTrangChu().setVisible(true);
            }
        });
    }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuCTHoaDon;
    private javax.swing.JMenuItem mnuCTPhieuNhap;
    private javax.swing.JMenuItem mnuChucVu;
    private javax.swing.JMenuItem mnuHoaDon;
    private javax.swing.JMenuItem mnuKhachHang;
    private javax.swing.JMenuItem mnuLoaiSanPham;
    private javax.swing.JMenuItem mnuNhaCungCap;
    private javax.swing.JMenuItem mnuNhanVien;
    private javax.swing.JMenuItem mnuPhieuNhap;
    private javax.swing.JMenuItem mnuSanPham;
    private javax.swing.JMenuItem mnuTaiKhoan;
    private javax.swing.JMenuItem mnuThongKe;
    private javax.swing.JTabbedPane tplMainBoard;
    // End of variables declaration//GEN-END:variables
}
