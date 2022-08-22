/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hp
 */
public class FrmChiTietPhieuNhap extends javax.swing.JPanel {

    DefaultTableModel tbn = new DefaultTableModel();
    /**
     * Creates new form FrmCTPhieuNhap
     */
    public FrmChiTietPhieuNhap() throws SQLException {
        initComponents();
        loadDataChiTietPhieuNhap();
        loadComoboxSanPham();
        loadComoboxMaPhieuNhap();
    }
    public void loadComoboxMaPhieuNhap(){
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select MaPhieuNhap from PhieuNhap group by MaPhieuNhap");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cboMaPhieuNhap_CTPN.addItem(rs.getString("MaPhieuNhap"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadComoboxSanPham(){
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select TenSanPham from SanPham group by TenSanPham");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cboSanPhamCTPN_PhieuNhap.addItem(rs.getString("TenSanPham"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void SetTongTien(String MaPhieuNhap) throws SQLException {
         Connect a = new Connect();
         Connection conn = a.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("select sum(ChiTietPhieuNhap.TongTien) as TongTienHienTai,PhieuNhap.MaPhieuNhap from PhieuNhap,ChiTietPhieuNhap "
                + "where PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap"
                + " and PhieuNhap.MaPhieuNhap=" + MaPhieuNhap + "group by PhieuNhap.MaPhieuNhap");
        String ttht = "";

        try {
            if (rs.next()) {
                ttht = rs.getString("TongTienHienTai");
                String ctv = "update PhieuNhap set TongTien= " + ttht + "where MaPhieuNhap=" + MaPhieuNhap;
                System.out.println(ctv);
                ResultSet ra = st.executeQuery(ctv);
                loadDataChiTietPhieuNhap();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void SetTonKho(String TenSanPham) throws SQLException {
         Connect a = new Connect();
         Connection conn = a.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("select sum(ChiTietPhieuNhap.SoLuong) as TonKho,SanPham.MaSanPham from SanPham,ChiTietPhieuNhap "
                + "where SanPham.MaSanPham = ChiTietPhieuNhap.MaSanPham"
                + " and SanPham.MaSanPham=(select MaSanPham from SanPham where TenSanPham = N'" + TenSanPham + "')group by SanPham.MaSanPham");
        String tk = "";

        try {
            if (rs.next()) {
                tk = rs.getString("TonKho");
                String ctv = "update SanPham set TonKho= " + tk + "where MaSanPham=(select MaSanPham from SanPham where TenSanPham = N'" + TenSanPham + "')";
//                System.out.println(ctv);
                ResultSet ra = st.executeQuery(ctv);
                loadDataChiTietPhieuNhap();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadDataChiTietPhieuNhap() throws SQLException{
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select MaCTPN, PhieuNhap.MaPhieuNhap, ChiTietPhieuNhap.MaSanPham, SanPham.TenSanPham, ChiTietPhieuNhap.SoLuong, ChiTietPhieuNhap.TongTien from PhieuNhap,ChiTietPhieuNhap,SanPham  where PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap and SanPham.MaSanPham = ChiTietPhieuNhap.MaSanPham " );
            ResultSetMetaData metaData = rs.getMetaData();
            Object[] obj = new Object[]{"Mã Chi Tiết Phiếu Nhập","Mã Phiếu Nhập","Sản Phẩm","Số Lượng","Tổng Tiền"};
            DefaultTableModel tableModel = new DefaultTableModel(obj,0);
            tblChiTietPhieuNhap_PhieuNhap.setModel(tableModel);
            try {
                while(rs.next()){
                    Object[] item = new Object[5];
                    item[0] = rs.getInt("MaCTPN");
                    item[1] = rs.getString("MaPhieuNhap");
                    item[2] = rs.getString("TenSanPham");
                    item[3] = rs.getString("SoLuong");
                    item[4] = rs.getInt("TongTien");
                    tableModel.addRow(item);
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMaCTPN_PhieuNhap = new javax.swing.JTextField();
        txtSoLuongCTPN_PhieuNhap = new javax.swing.JTextField();
        txtTongTienCTPN_PhieuNhap = new javax.swing.JTextField();
        cboSanPhamCTPN_PhieuNhap = new javax.swing.JComboBox<>();
        cboMaPhieuNhap_CTPN = new javax.swing.JComboBox<>();
        btnThemCTPN_PhieuNhap = new javax.swing.JButton();
        btnSuaCTPN_PhieuNhap = new javax.swing.JButton();
        btnXoaCTPN_PhieuNhap = new javax.swing.JButton();
        btnResetCTPN_PhieuNhap = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblChiTietPhieuNhap_PhieuNhap = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(153, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Mã CTPN:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Mã Phiếu Nhập:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Sản Phẩm:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Số Lượng:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Tổng Tiền:");

        txtMaCTPN_PhieuNhap.setEditable(false);
        txtMaCTPN_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));
        txtMaCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        txtTongTienCTPN_PhieuNhap.setEditable(false);
        txtTongTienCTPN_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));
        txtTongTienCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnThemCTPN_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnThemCTPN_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemCTPN_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnThemCTPN_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThemCTPN_PhieuNhap.setText("Thêm");
        btnThemCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnSuaCTPN_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnSuaCTPN_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaCTPN_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnSuaCTPN_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        btnSuaCTPN_PhieuNhap.setText("Sửa");
        btnSuaCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnXoaCTPN_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaCTPN_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaCTPN_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnXoaCTPN_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete_16x16.png"))); // NOI18N
        btnXoaCTPN_PhieuNhap.setText("Xóa");
        btnXoaCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnResetCTPN_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnResetCTPN_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetCTPN_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnResetCTPN_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnResetCTPN_PhieuNhap.setText("Reset");
        btnResetCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTienCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboSanPhamCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel22))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboMaPhieuNhap_CTPN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuongCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(btnXoaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnResetCTPN_PhieuNhap))))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnThemCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnSuaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaPhieuNhap_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoLuongCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboSanPhamCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTongTienCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCTPN_PhieuNhap)
                    .addComponent(btnSuaCTPN_PhieuNhap)
                    .addComponent(btnXoaCTPN_PhieuNhap)
                    .addComponent(btnResetCTPN_PhieuNhap))
                .addGap(19, 19, 19))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bảng Chi Tiết Phiếu Nhập");

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tblChiTietPhieuNhap_PhieuNhap.setBackground(new java.awt.Color(255, 204, 204));
        tblChiTietPhieuNhap_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã CTPN", "Mã Phiếu Nhập", "Sản Phẩm", "Số Lượng", "Tổng Tiền"
            }
        ));
        tblChiTietPhieuNhap_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietPhieuNhap_PhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblChiTietPhieuNhap_PhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTongTienCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienCTPN_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienCTPN_PhieuNhapActionPerformed

    private void btnThemCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTPN_PhieuNhapActionPerformed
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            String MaPhieuNhap, TenSanPham;
            MaPhieuNhap = cboMaPhieuNhap_CTPN.getSelectedItem().toString();
            TenSanPham = cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString();
            PreparedStatement ps = conn.prepareStatement("insert into ChiTietPhieuNhap(MaPhieuNhap,MaSanPham,SoLuong,TongTien) values(?,(select MaSanPham from SanPham where TenSanPham=?),?,(select GiaNhap from SanPham where TenSanPham = ?)*?)");
            //ps.setString(1, txtMaPhieuNhap_PhieuNhap.getText());
            ps.setString(1, cboMaPhieuNhap_CTPN.getSelectedItem().toString());
            ps.setString(2, cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString());
            ps.setString(3, txtSoLuongCTPN_PhieuNhap.getText());
            ps.setString(4, cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString());
            ps.setString(5, txtSoLuongCTPN_PhieuNhap.getText());
            int chk = ps.executeUpdate();
            if(chk >0){
                JOptionPane.showMessageDialog(this, "Thêm Thành Công! ");
                tbn.setRowCount(0);
                loadDataChiTietPhieuNhap();
                SetTongTien(MaPhieuNhap);
                SetTonKho(TenSanPham);
            }else{
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnThemCTPN_PhieuNhapActionPerformed

    private void btnSuaCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTPN_PhieuNhapActionPerformed
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            String MaPhieuNhap, TenSanPham;
            TenSanPham = cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString();
            MaPhieuNhap = cboMaPhieuNhap_CTPN.getSelectedItem().toString();
            PreparedStatement comm=conn.prepareStatement("Update ChiTietPhieuNhap set MaPhieuNhap=?, MaSanPham=(select MaSanPham from SanPham where TenSanPham=?),SoLuong=?,TongTien=? where MaCTPN=?");
            comm.setString(5, txtMaCTPN_PhieuNhap.getText());
            comm.setString(1, cboMaPhieuNhap_CTPN.getSelectedItem().toString());
            comm.setString(2, cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString());
            comm.setString(3, txtSoLuongCTPN_PhieuNhap.getText());
            comm.setString(4, txtTongTienCTPN_PhieuNhap.getText());
            int chk =comm.executeUpdate();
            if(chk >0){
                JOptionPane.showMessageDialog(this, "Sửa Thành Công! ");
                tbn.setRowCount(0);
                loadDataChiTietPhieuNhap();
                SetTongTien(MaPhieuNhap);
                SetTonKho(TenSanPham);
            }else{}
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnSuaCTPN_PhieuNhapActionPerformed

    private void btnXoaCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTPN_PhieuNhapActionPerformed
        try {StringBuilder sb= new StringBuilder();
            if(cboMaPhieuNhap_CTPN.getSelectedItem().equals("")){
                sb.append("Hãy click vào Mã Phiếu Nhập muốn xóa !");
            }
            else{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            String MaPhieuNhap, TenSanPham;
            TenSanPham = cboSanPhamCTPN_PhieuNhap.getSelectedItem().toString();
            MaPhieuNhap = cboMaPhieuNhap_CTPN.getSelectedItem().toString();
            PreparedStatement comm=conn.prepareStatement("Delete ChiTietPhieuNhap where MaCTPN=?");
            comm.setString(1, tblChiTietPhieuNhap_PhieuNhap.getValueAt(tblChiTietPhieuNhap_PhieuNhap.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Dữ Liệu Hay Không ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                comm.executeUpdate();
                tbn.setRowCount(0);
                loadDataChiTietPhieuNhap();
                SetTongTien(MaPhieuNhap);
                SetTonKho(TenSanPham);
            } }if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }              
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaCTPN_PhieuNhapActionPerformed

    private void btnResetCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCTPN_PhieuNhapActionPerformed
        txtMaCTPN_PhieuNhap.setText("");
        cboMaPhieuNhap_CTPN.setSelectedItem("");
        cboSanPhamCTPN_PhieuNhap.setSelectedItem("");
        txtSoLuongCTPN_PhieuNhap.setText("");
        txtTongTienCTPN_PhieuNhap.setText("");
    }//GEN-LAST:event_btnResetCTPN_PhieuNhapActionPerformed

    private void tblChiTietPhieuNhap_PhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked
        int viTriDongVuaBam = tblChiTietPhieuNhap_PhieuNhap.getSelectedRow();
        txtMaCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 0).toString());
        cboMaPhieuNhap_CTPN.setSelectedItem(tblChiTietPhieuNhap_PhieuNhap.getModel().getValueAt(tblChiTietPhieuNhap_PhieuNhap.getSelectedRow(), 1));
        txtSoLuongCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 3).toString());
        txtTongTienCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 4).toString());
        cboSanPhamCTPN_PhieuNhap.setSelectedItem(tblChiTietPhieuNhap_PhieuNhap.getModel().getValueAt(tblChiTietPhieuNhap_PhieuNhap.getSelectedRow(), 2));
    }//GEN-LAST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked

    private void txtMaCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTPN_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTPN_PhieuNhapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetCTPN_PhieuNhap;
    private javax.swing.JButton btnSuaCTPN_PhieuNhap;
    private javax.swing.JButton btnThemCTPN_PhieuNhap;
    private javax.swing.JButton btnXoaCTPN_PhieuNhap;
    private javax.swing.JComboBox<String> cboMaPhieuNhap_CTPN;
    private javax.swing.JComboBox<String> cboSanPhamCTPN_PhieuNhap;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tblChiTietPhieuNhap_PhieuNhap;
    private javax.swing.JTextField txtMaCTPN_PhieuNhap;
    private javax.swing.JTextField txtSoLuongCTPN_PhieuNhap;
    private javax.swing.JTextField txtTongTienCTPN_PhieuNhap;
    // End of variables declaration//GEN-END:variables
}
