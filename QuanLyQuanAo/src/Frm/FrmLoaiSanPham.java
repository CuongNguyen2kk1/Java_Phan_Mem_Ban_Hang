/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import javax.swing.filechooser.FileFilter;
import java.util.Arrays;
import java.sql.ResultSetMetaData;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Administrator
 */
public class FrmLoaiSanPham extends javax.swing.JPanel {
    DefaultTableModel tbn = new DefaultTableModel();
    public FrmLoaiSanPham() throws SQLException {
        initComponents();
        loadDataLoaiSanPham();
    }
    public void loadDataLoaiSanPham() throws SQLException{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from LoaiSanPham ");
            Object[] obj = new Object[] {"Mã Loại Sản Phẩm","Tên Loại Sản Phẩm"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblLoaiSanPham.setModel(tableModel);
            try {
            while (rs.next()) {
                Object[] item = new Object[2];
                item[0] = rs.getInt("LoaiSanPham");
                item[1] = rs.getString("TenLoaiSanPham");
                tableModel.addRow(item);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadDataSanPham(String text) throws SQLException{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from SanPham,LoaiSanPham where SanPham.LoaiSanPham=LoaiSanPham.LoaiSanPham and LoaiSanPham.LoaiSanPham="+text );
            Object[] obj = new Object[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblSanPham_LoaiSanPham.setModel(tableModel);
            
            try {
            while (rs.next()) {
                Object[] item = new Object[4];
                    item[0] = rs.getInt("MaSanPham");
                    item[1] = rs.getString("TenSanPham");
                    item[2] = rs.getString("TenLoaiSanPham");
                    tableModel.addRow(item);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
            
    }
            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMaLoaiSanPham_LoaiSanPham = new javax.swing.JTextPane();
        txtTenLoaiSanPham_LoaiSanPham = new javax.swing.JTextField();
        btnThem_LoaiSanPham = new javax.swing.JButton();
        btnSua_LoaiSanPham = new javax.swing.JButton();
        btnReset_LoaiSanPham = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLoaiSanPham = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tblsanpham = new javax.swing.JScrollPane();
        tblSanPham_LoaiSanPham = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnXoaSP_LoaiSanPham = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(153, 255, 255));
        jPanel9.setAutoscrolls(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Mã Loại Sản Phẩm");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tên Loại Sản Phẩm");

        jScrollPane5.setViewportView(txtMaLoaiSanPham_LoaiSanPham);

        btnThem_LoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnThem_LoaiSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem_LoaiSanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnThem_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThem_LoaiSanPham.setText("Thêm");
        btnThem_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnSua_LoaiSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua_LoaiSanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnSua_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        btnSua_LoaiSanPham.setText("Sửa");
        btnSua_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnReset_LoaiSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset_LoaiSanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnReset_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnReset_LoaiSanPham.setText("Reset");
        btnReset_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_LoaiSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(btnThem_LoaiSanPham))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenLoaiSanPham_LoaiSanPham)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(btnSua_LoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_LoaiSanPham)
                    .addComponent(btnReset_LoaiSanPham)
                    .addComponent(btnSua_LoaiSanPham))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Loại Sản Phẩm");

        tblLoaiSanPham.setBackground(new java.awt.Color(255, 204, 204));
        tblLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại Sản Phẩm", "Tên Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLoaiSanPham);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sản Phẩm");

        tblSanPham_LoaiSanPham.setBackground(new java.awt.Color(255, 204, 204));
        tblSanPham_LoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsanpham.setViewportView(tblSanPham_LoaiSanPham);

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Lưu Ý Khi Xóa Loại Sản Phẩm Chứa Sản Phẩm Nằm Trong Hóa Đơn, Phiếu Nhập...");

        btnXoaSP_LoaiSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaSP_LoaiSanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnXoaSP_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete_16x16.png"))); // NOI18N
        btnXoaSP_LoaiSanPham.setText("Xóa Sản Phẩm");
        btnXoaSP_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP_LoaiSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(tblsanpham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnXoaSP_LoaiSanPham))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnXoaSP_LoaiSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tblsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReset_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_LoaiSanPhamActionPerformed
        txtMaLoaiSanPham_LoaiSanPham.setText("");
        txtTenLoaiSanPham_LoaiSanPham.setText("");
        try {
            loadDataLoaiSanPham();
        } catch (Exception ex) {
            Logger.getLogger(FrmLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReset_LoaiSanPhamActionPerformed

    private void btnThem_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_LoaiSanPhamActionPerformed
       StringBuilder sb = new StringBuilder();
        if(txtMaLoaiSanPham_LoaiSanPham.getText().equals("")){
        if(txtTenLoaiSanPham_LoaiSanPham.getText().equals("")){
            sb.append("Hãy nhập tên Tên Sản Phẩm ! \n");
            txtTenLoaiSanPham_LoaiSanPham.requestFocus();
        } else{
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                PreparedStatement ps = conn.prepareStatement("insert into LoaiSanPham(TenLoaiSanPham) values(?) ");
             
                ps.setString(1,txtTenLoaiSanPham_LoaiSanPham.getText());
             int chk = ps.executeUpdate();
             if(chk>0){
                 sb.append("Thêm thành công!");
                 loadDataLoaiSanPham();
             }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        }
        else{
            sb.append("vui lòng nhấn Reset trước khi thêm! \n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
    }//GEN-LAST:event_btnThem_LoaiSanPhamActionPerformed

    private void btnSua_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_LoaiSanPhamActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtMaLoaiSanPham_LoaiSanPham.getText().equals("")){
            sb.append("Hãy Chọn Loại Sản Phẩm Mà Bạn Muốn Sửa! \n");
        }
        else{
        if(txtTenLoaiSanPham_LoaiSanPham.getText().equals("")){
            sb.append("Hãy Nhập Tên Mà Bạn Muốn Sửa! \n");
            txtTenLoaiSanPham_LoaiSanPham.requestFocus();
        }
        else{
            try {
                Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement comm = conn.prepareStatement("update LoaiSanPham set TenLoaiSanPham=? where LoaiSanPham=?");
            comm.setString(1,txtTenLoaiSanPham_LoaiSanPham.getText());
            comm.setString(2,tblLoaiSanPham.getValueAt(tblLoaiSanPham.getSelectedRow(),0).toString());
            comm.executeUpdate();
            loadDataLoaiSanPham();
            sb.append("Sửa Thành Công");
            loadDataChucVuNhanVien(txtMaLoaiSanPham_LoaiSanPham.getText());
            
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
    }//GEN-LAST:event_btnSua_LoaiSanPhamActionPerformed

    private void tblLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSanPhamMouseClicked
        int viTriDongVuaBam = tblLoaiSanPham.getSelectedRow();
        txtMaLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham.getValueAt(viTriDongVuaBam, 0).toString());
        txtTenLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham.getValueAt(viTriDongVuaBam, 1).toString());
        try {
            loadDataSanPham(txtMaLoaiSanPham_LoaiSanPham.getText());
        } catch (Exception ex) {
            Logger.getLogger(ChucVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblLoaiSanPhamMouseClicked

    private void btnXoaSP_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP_LoaiSanPhamActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if(txtMaLoaiSanPham_LoaiSanPham.getText().equals("")){
                    sb.append("Hãy click vào loại sản phẩm mà bạn muốn xóa \n");
                }
            else{
            if((tblSanPham_LoaiSanPham.getRowCount())<=0){
                Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pc = conn.prepareStatement("delete LoaiSanPham where LoaiSanPham=?");
            pc.setString(1, tblLoaiSanPham.getValueAt(tblLoaiSanPham.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Bạn thật sự muốn xóa ?", "Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            sb.append("Xóa Thành Công");
            pc.executeUpdate();
            loadDataLoaiSanPham();
             }
            }
            else{
            sb.append("chỉ xóa được khi chức vụ này trống");
            
            }
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaSP_LoaiSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset_LoaiSanPham;
    private javax.swing.JButton btnSua_LoaiSanPham;
    private javax.swing.JButton btnThem_LoaiSanPham;
    private javax.swing.JButton btnXoaSP_LoaiSanPham;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblLoaiSanPham;
    private javax.swing.JTable tblSanPham_LoaiSanPham;
    private javax.swing.JScrollPane tblsanpham;
    private javax.swing.JTextPane txtMaLoaiSanPham_LoaiSanPham;
    private javax.swing.JTextField txtTenLoaiSanPham_LoaiSanPham;
    // End of variables declaration//GEN-END:variables

    private void loadDataChucVuNhanVien(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
