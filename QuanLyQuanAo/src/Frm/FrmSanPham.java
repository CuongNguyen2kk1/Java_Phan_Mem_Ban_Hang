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
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class FrmSanPham extends javax.swing.JPanel {
    
    
    DefaultTableModel tbn = new DefaultTableModel();
    private Object ex;
    byte[] Hinh;
    String filename =  null;
    public FrmSanPham() throws SQLException {
        initComponents();
        loadDataSanPham();
        loadComobox();
        loadComobox1();
    }
    public void loadComobox(){
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select TenLoaiSanPham from LoaiSanPham");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            cbbMaLoaiSanPham_SanPham.addItem(rs.getString("TenLoaiSanPham"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadComobox1(){
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pa = conn.prepareStatement("Select TenNhaCungCap from NhaCungCap");
            ResultSet ra = pa.executeQuery();
            while(ra.next()) {
            cboNCC.addItem(ra.getString("TenNhaCungCap"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public  void loadDataSanPham() throws SQLException {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from SanPham join LoaiSanPham on SanPham.LoaiSanPham= LoaiSanPham.LoaiSanPham JOIN dbo.NhaCungCap on SanPham.MaNhaCungCap=NhaCungCap.MaNhaCungCap ");
           Object[] obj = new Object[]{"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm","Nhà Cung Cấp", "Giá nhập","Giá bán","Tồn kho","Ảnh"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblSanPham.setModel(tableModel);
            try {
            while (rs.next()) {
                
                Object[] item = new Object[8];
                item[0] = rs.getInt("MaSanPham");
                item[1] = rs.getString("TenSanPham");
                item[2] = rs.getString("TenLoaiSanPham");
                item[3] = rs.getString("TenNhaCungCap");
                item[4] = rs.getInt("GiaNhap");
                item[5] = rs.getInt("GiaBan");
                item[6] = rs.getInt("TonKho");
                item[7] = rs.getBytes("Image");
                tableModel.addRow(item);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSanPham_SanPham = new javax.swing.JTextField();
        txtTenSanPham_SanPham = new javax.swing.JTextField();
        txtGiaNhap_SanPham = new javax.swing.JTextField();
        txtGiaBan_SanPham = new javax.swing.JTextField();
        cbbMaLoaiSanPham_SanPham = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboNCC = new javax.swing.JComboBox<>();
        bntSua_SanPham = new javax.swing.JButton();
        btnThem_SanPham = new javax.swing.JButton();
        btnXoa_SanPham = new javax.swing.JButton();
        btnReset_SanPham = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem_SanPham = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        txtTonKho_SanPham = new javax.swing.JTextField();
        rdoTheoTen = new javax.swing.JRadioButton();
        rdoTheoMa = new javax.swing.JRadioButton();
        lblImage = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setBackground(new java.awt.Color(255, 204, 204));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Nhà Cung Cấp", "Giá Nhập", "Giá Bán", "Tồn Kho", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(7).setPreferredWidth(0);
        }

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Giá Nhập");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Loại Sản Phẩm");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tên Sản Phẩm");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Giá Bán");

        txtMaSanPham_SanPham.setEnabled(false);

        txtGiaBan_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBan_SanPhamActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tồn Kho");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nhà Cung Cấp");

        bntSua_SanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntSua_SanPham.setForeground(new java.awt.Color(0, 102, 102));
        bntSua_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        bntSua_SanPham.setText("Sửa");
        bntSua_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSua_SanPhamActionPerformed(evt);
            }
        });

        btnThem_SanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem_SanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnThem_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThem_SanPham.setText("Thêm");
        btnThem_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_SanPhamActionPerformed(evt);
            }
        });

        btnXoa_SanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa_SanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnXoa_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete_16x16.png"))); // NOI18N
        btnXoa_SanPham.setText("Xóa");
        btnXoa_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_SanPhamActionPerformed(evt);
            }
        });

        btnReset_SanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset_SanPham.setForeground(new java.awt.Color(0, 102, 102));
        btnReset_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnReset_SanPham.setText("Reset");
        btnReset_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_SanPhamActionPerformed(evt);
            }
        });

        btnXuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(0, 102, 102));
        btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Print_16x16.png"))); // NOI18N
        btnXuat.setText("Xuất Excel");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tìm Kiếm");

        txtTimKiem_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem_SanPhamActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Preview_16x16.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtTonKho_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTonKho_SanPhamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTheoTen);
        rdoTheoTen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoTen.setText("Tên Sản Phẩm");

        buttonGroup1.add(rdoTheoMa);
        rdoTheoMa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoMa.setText("Mã Sản Phẩm");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NOIMAGE.jpg"))); // NOI18N

        btnChonAnh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Check_16x16.png"))); // NOI18N
        btnChonAnh.setText("Chọn");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSanPham_SanPham)
                    .addComponent(txtMaSanPham_SanPham)
                    .addComponent(cbbMaLoaiSanPham_SanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGiaNhap_SanPham)
                    .addComponent(txtGiaBan_SanPham)
                    .addComponent(txtTonKho_SanPham)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimKiem_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoTheoTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuat)
                            .addComponent(btnReset_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSua_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChonAnh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem_SanPham))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSua_SanPham))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaLoaiSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa_SanPham))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGiaNhap_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTonKho_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTimKiem_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(rdoTheoTen)
                                    .addComponent(rdoTheoMa)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnReset_SanPham)
                                .addGap(18, 18, 18)
                                .addComponent(btnXuat)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)))
                        .addGap(20, 20, 20))))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sản phẩm ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int viTriDongVuaBam = tblSanPham.getSelectedRow();
        txtMaSanPham_SanPham.setText(tblSanPham.getValueAt(viTriDongVuaBam, 0).toString());
        txtTenSanPham_SanPham.setText(tblSanPham.getValueAt(viTriDongVuaBam, 1).toString());
        cbbMaLoaiSanPham_SanPham.setSelectedItem(tblSanPham.getValueAt(viTriDongVuaBam, 2).toString());
        cboNCC.setSelectedItem(tblSanPham.getValueAt(viTriDongVuaBam, 3).toString());
        txtGiaNhap_SanPham.setText(tblSanPham.getValueAt(viTriDongVuaBam, 4).toString());
        txtGiaBan_SanPham.setText(tblSanPham.getValueAt(viTriDongVuaBam, 5).toString());
        txtTonKho_SanPham.setText(tblSanPham.getValueAt(viTriDongVuaBam, 6).toString());
        
        if(tblSanPham.getValueAt(viTriDongVuaBam, 7) != null){
            byte[] img = (byte[]) tblSanPham.getValueAt(viTriDongVuaBam, 7);
            ImageIcon icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_SMOOTH));
            lblImage.setIcon(icon);
            Hinh = (byte[]) tblSanPham.getValueAt(viTriDongVuaBam, 7);
        } else {
            Hinh = (byte[]) tblSanPham.getValueAt(viTriDongVuaBam, 7);
            
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            if(rdoTheoMa.isSelected()) {
                if(txtTimKiem_SanPham.getText().equals("")) {
                    sb.append("Hãy Nhập Mã Bạn Muốn Tìm Kiếm !");
                }
                else {
                PreparedStatement pa = conn.prepareStatement("select *from SanPham join LoaiSanPham on SanPham.LoaiSanPham = LoaiSanPham.LoaiSanPham JOIN NhaCungCap on SanPham.MaNhaCungCap=NhaCungCap.MaNhaCungCap  where MaSanPham = ?");
                pa.setString(1, txtTimKiem_SanPham.getText());
                ResultSet ra = pa.executeQuery();
                Object[] obj = new Object[] {"Mã Sản Phẩm","Tên Sản Phẩm","Loại Sản Phẩm","Nhà Cung Cấp","Giá Nhập","Giá Bán","Tồn Kho"};
                DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                tblSanPham.setModel(tableModel);
                    try {
                        while (ra.next()) {
                        Object[] item = new Object[8];
                        item[0] = ra.getInt("MaSanPham");
                        item[1] = ra.getString("TenSanPham");
                        item[2] = ra.getString("TenLoaiSanPham");
                        item[3] = ra.getString("TenNhaCungCap");
                        item[4] = ra.getInt("GiaNhap");
                        item[5] = ra.getInt("GiaBan");
                        item[6] = ra.getInt("TonKho");
                        item[7] = ra.getInt("Image");
                        
                         tableModel.addRow(item);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                        
                    }
                }
                if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                }
            }
            else if(rdoTheoTen.isSelected()){
                if(txtTimKiem_SanPham.getText().equals("")) {
                    sb.append("Hãy Nhập Tên Bạn Muốn Tìm Kiếm");
                }
                else {
                PreparedStatement pf = conn.prepareStatement("select *from SanPham join LoaiSanPham on SanPham.LoaiSanPham = LoaiSanPham.LoaiSanPham  JOIN NhaCungCap on SanPham.MaNhaCungCap=NhaCungCap.MaNhaCungCap WHERE TenSanPham like ? or TenSanPham = ? or TenSanPham like ?");
                pf.setString(1,('%'+ txtTimKiem_SanPham.getText()));
                 pf.setString(2,(txtTimKiem_SanPham.getText()));
                 pf.setString(3,(txtTimKiem_SanPham.getText()+'%'));
                 ResultSet rb = pf.executeQuery();
                 Object[] obj = new Object[] {"Mã Sản Phẩm","Tên Sản Phẩm","Loại Sản Phẩm","Nhà Cung Cấp","Giá Nhập","Giá Bán","Tồn Kho" };
                 DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                 tblSanPham.setModel(tableModel);
                    try {
                        while (rb.next()) {
                        Object[] item = new Object[8];
                        item[0] = rb.getInt("MaSanPham");
                        item[1] = rb.getString("TenSanPham");
                        item[2] = rb.getString("TenLoaiSanPham");
                        item[3] = rb.getString("TenNhaCungCap");
                        item[4] = rb.getInt("GiaNhap");
                        item[5] = rb.getInt("GiaBan");
                        item[6] = rb.getInt("TonKho");
                        tableModel.addRow(item);
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
                if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                }
            }
            else{
             sb.append("Hãy chọn trường bạn muốn tìm kiếm");
             if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory()){
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return("Image File (*.jpg)");
            }
        });
        if(chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION )
            return;
        
        File file = chooser.getSelectedFile();
        filename = file.getAbsolutePath();
        ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_SMOOTH));
        lblImage.setIcon(icon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf= new byte[1024];
            for(int readNum;(readNum=fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
               
            }
            Hinh = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnReset_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_SanPhamActionPerformed
        txtMaSanPham_SanPham.setText("");
        txtTenSanPham_SanPham.setText("");
        txtGiaNhap_SanPham.setText("");
        txtGiaBan_SanPham.setText("");
        cbbMaLoaiSanPham_SanPham.setSelectedIndex(0);
        txtTonKho_SanPham.setText("");
        try {
            loadDataSanPham();
        } catch (Exception ex) {
            Logger.getLogger(FrmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReset_SanPhamActionPerformed

    private void btnXoa_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_SanPhamActionPerformed
        try {

            StringBuilder sb = new StringBuilder();
            if(txtMaSanPham_SanPham.getText().equals("")){
                sb.append("Hãy click Vào Sản Phẩm Bạn Muốn Xóa!");
            }
            else {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                PreparedStatement pc = conn.prepareStatement("delete SanPham where MaSanPham = ?");
                pc.setString(1, tblSanPham.getValueAt(tblSanPham.getSelectedRow(),0).toString());
                if(JOptionPane.showConfirmDialog(this, "Bạn Thật Sự Muốn Xóa ?" ,"Confirm",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    pc.executeUpdate();
                    sb.append("Xóa Thành Công");
                    loadDataSanPham();
                }
            }
            if(sb.length() >0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoa_SanPhamActionPerformed

    private void bntSua_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSua_SanPhamActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if(txtMaSanPham_SanPham.getText().equals("")){
                sb.append("Hãy Chọn Mã Sản Phẩm Muốn Sửa");
            } else {
                if(txtTenSanPham_SanPham.getText().equals("")) {
                    sb.append("Hãy Nhập Tên Nhân Viên! \n");
                }
                else if(txtGiaNhap_SanPham.getText().equals("")) {
                    sb.append("Chưa Điền Giá Nhập! \n");
                }
                if(!StringUtils.isNumeric(txtGiaNhap_SanPham.getText().toString())){
                    sb.append("Giá Nhập Chỉ Nhập Được Dạng Số!\n");
                    txtGiaNhap_SanPham.requestFocus();
                }
                else if(txtGiaBan_SanPham.getText().equals("")) {
                    sb.append("Chưa Điền Giá Bán!\n ");
                }
                else if(!StringUtils.isNumeric(txtGiaBan_SanPham.getText().toString())){
                    sb.append("Giá Bán Chỉ Nhập Được Dạng Số!\n");
                    txtGiaBan_SanPham.requestFocus();
                }
                else if(txtTonKho_SanPham.getText().equals("")) {
                    sb.append("Chưa Điền Tồn Kho!\n");
                }
                else if(!StringUtils.isNumeric(txtTonKho_SanPham.getText().toString())){
                    sb.append("Tồn Kho Chỉ Nhập Được Dạng Số!\n");
                    txtTonKho_SanPham.requestFocus();
                }
                else {
                    Connect a = new Connect();
                    Connection conn = a.getConnection();
                    PreparedStatement pr = conn.prepareStatement("update SanPham set TenSanPham = ?, LoaiSanPham=(Select LoaiSanPham from LoaiSanPham where TenLoaiSanPham = ?),MaNhaCungCap=(SELECT MaNhaCungCap FROM dbo.NhaCungCap WHERE TenNhaCungCap = ?),GiaNhap=?,GiaBan=?,TonKho=?,Image = ? where MaSanPham = ?");

                    pr.setString(1, txtTenSanPham_SanPham.getText());
                    pr.setString(2, cbbMaLoaiSanPham_SanPham.getSelectedItem().toString());
                    pr.setString(3, cboNCC.getSelectedItem().toString());
                    pr.setInt(4, Integer.parseInt(txtGiaNhap_SanPham.getText()));
                    pr.setInt(5, Integer.parseInt(txtGiaBan_SanPham.getText()));
                    pr.setInt(6, Integer.parseInt(txtTonKho_SanPham.getText()));
                    pr.setBytes(7,Hinh);
                    pr.setString(8, tblSanPham.getValueAt(tblSanPham.getSelectedRow(),0).toString());
                    pr.executeUpdate();
                    sb.append("Sửa Thành Công");
                    loadDataSanPham();
                }
            }
            if(sb.length() >0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_bntSua_SanPhamActionPerformed

    private void btnThem_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_SanPhamActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if(txtMaSanPham_SanPham.getText().equals("")) {
                if(txtTenSanPham_SanPham.getText().equals("")) {
                    sb.append("Bạn Chưa Nhập Tên Sản Phẩm! \n");
                    txtTenSanPham_SanPham.requestFocus();
                }

                if(!StringUtils.isNumeric(txtGiaNhap_SanPham.getText().toString())){
                    sb.append("Giá Nhập Chỉ Nhập Được Dạng Số!\n");
                    txtGiaNhap_SanPham.requestFocus();
                }
                if(txtGiaNhap_SanPham.getText().toString().isEmpty()) {
                    sb.append("Giá Nhập Không Được Để trống\n");
                    txtGiaNhap_SanPham.requestFocus();
                }
                if(!StringUtils.isNumeric(txtGiaBan_SanPham.getText().toString())){
                    sb.append("Giá Bán Chỉ Nhập Được Dạng Số!\n");
                    txtGiaBan_SanPham.requestFocus();
                }
                if(txtGiaBan_SanPham.getText().toString().isEmpty()) {
                    sb.append("Giá Bán Không Được Để trống\n");
                    txtGiaBan_SanPham.requestFocus();
                }
                if(!StringUtils.isNumeric(txtTonKho_SanPham.getText().toString())){
                    sb.append("Tồn Kho Chỉ Nhập Được Dạng Số!\n");
                    txtTonKho_SanPham.requestFocus();
                }
                if(txtTonKho_SanPham.getText().toString().isEmpty()) {
                    sb.append("Số lượng tồn kho không được để trống!\n");
                    txtTonKho_SanPham.requestFocus();
                }
                else {
                    Connect a = new Connect();
                    Connection conn = a.getConnection();
                    PreparedStatement ps = conn.prepareStatement("insert into SanPham(TenSanPham,LoaiSanPham,MaNhaCungCap,GiaNhap,GiaBan,TonKho,Image) values(?,(Select LoaiSanPham from LoaiSanPham where TenLoaiSanPham = ?),(SELECT MaNhaCungCap FROM dbo.NhaCungCap WHERE TenNhaCungCap = ?),?,?,?,?)");

                    ps.setString(1, txtTenSanPham_SanPham.getText());
                    ps.setString(2, cbbMaLoaiSanPham_SanPham.getSelectedItem().toString());
                    ps.setString(3, cboNCC.getSelectedItem().toString());
                    ps.setInt(4, Integer.parseInt(txtGiaNhap_SanPham.getText()));
                    ps.setInt(5, Integer.parseInt(txtGiaBan_SanPham.getText()));
                    ps.setInt(6, Integer.parseInt(txtTonKho_SanPham.getText()));
                    ps.setBytes(7,Hinh);
                    
                 

                    int chk = ps.executeUpdate();
                    if(chk>0) {
                        sb.append("Thêm Thành Công");
                        loadDataSanPham();
                    }
                }
            } else {
                sb.append("Hãy Nhấn Reset Trước Khi Thêm");
            }
            if(sb.length() >0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnThem_SanPhamActionPerformed

    private void txtGiaBan_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBan_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBan_SanPhamActionPerformed

    private void txtTonKho_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTonKho_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTonKho_SanPhamActionPerformed

    private void txtTimKiem_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem_SanPhamActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        FileOutputStream exfos = null;
        BufferedOutputStream exbou = null;
        XSSFWorkbook excelTableExport = null;
 
        JFileChooser excelFileChooser = new JFileChooser("D:\\Study\\UTT\\HK2\\JAVA\\file_excel");
        excelFileChooser.setDialogTitle("Save as");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        int excelChooser = excelFileChooser.showSaveDialog(null);
 
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
 
            try {
                excelTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelTableExport.createSheet("Sản Phẩm");
                for (int i = 0; i < tblSanPham.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tblSanPham.getColumnCount()-1; j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tblSanPham.getValueAt(i, j).toString());
                    }
                }
                exfos = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                exbou = new BufferedOutputStream(exfos);
                excelTableExport.write(exbou);
                JOptionPane.showMessageDialog(this, "Lưu File thành công");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FrmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (exfos != null) {
                        exfos.close();
                    }
                    if (exbou != null) {
                        exbou.close();
                    }
 
                } catch (IOException ex) {
                    Logger.getLogger(FrmSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    
//    public boolean KiemTraNhanSanPham(int ts){
//        String  MaSanPham,TenSanPham,GiaBan,GiaNhap,TonKho;
//        boolean kiemtra = false;
//        
//        return kiemtra;
//        
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSua_SanPham;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnReset_SanPham;
    private javax.swing.JButton btnThem_SanPham;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa_SanPham;
    private javax.swing.JButton btnXuat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaLoaiSanPham_SanPham;
    private javax.swing.JComboBox<String> cboNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdoTheoMa;
    private javax.swing.JRadioButton rdoTheoTen;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan_SanPham;
    private javax.swing.JTextField txtGiaNhap_SanPham;
    private javax.swing.JTextField txtMaSanPham_SanPham;
    private javax.swing.JTextField txtTenSanPham_SanPham;
    private javax.swing.JTextField txtTimKiem_SanPham;
    private javax.swing.JTextField txtTonKho_SanPham;
    // End of variables declaration//GEN-END:variables

    

   
}
