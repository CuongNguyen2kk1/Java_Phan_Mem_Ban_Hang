/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

//import com.sun.corba.se.spi.oa.OADefault;
//import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
//import javafx.scene.text.Text;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class FrmPhieuNhap extends javax.swing.JPanel {
DefaultTableModel tbn = new DefaultTableModel();
    /**
     * Creates new form FrmPhieuNhap
     */
    public FrmPhieuNhap() {
        initComponents();
        loadDataPhieuNhap();
        loadComoboxMaNhanVien();
        loadComboboxSanPham();
        loadComboboxNhaCungCap();
        SetNgayNhap();
        
    }
    public void SetNgayNhap(){
     Calendar cal = Calendar.getInstance();

    int day = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        for (int i = 1; i < 32; i++) {
            cbbNgay.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cbbThang.addItem(String.valueOf(i));
        }
        for (int i = year; i > 1980; i--) {
            cbbNam.addItem(String.valueOf(i));
        }
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
    }
    public void loadComboboxNhaCungCap() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenNhaCungCap from NhaCungCap group by TenNhaCungCap ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cboNhaCungCap_PhieuNhap.addItem(rs.getString("TenNhaCungCap"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadComboboxSanPham() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenSanPham from SanPham group by TenSanPham ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cboSanPham_CTPN.addItem(rs.getString("TenSanPham"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadComoboxMaNhanVien(){
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select TenNhanVien from NhanVien group by TenNhanVien");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cboTenNhanVien_PN.addItem(rs.getString("TenNhanVien"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadDataPhieuNhap(){
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PhieuNhap,NhaCungCap,NhanVien where PhieuNhap.MaNhaCungCap=NhaCungCap.MaNhaCungCap and PhieuNhap.MaNhanVien=NhanVien.MaNhanVien");
            ResultSetMetaData metaData = rs.getMetaData();
            Object[] obj = new Object[]{"Mã Phiếu Nhập","Tên Nhân Viên","Tên Nhà Cung Cấp","Ngày Nhập","Tổng Tiền"};
            DefaultTableModel tableModel = new DefaultTableModel(obj,0);
            tblPhieuNhap_PhieuNhap.setModel(tableModel);
            try {
                while(rs.next()){
                    Object[] item = new Object[5];
                    item[0] = rs.getInt("MaPhieuNhap");
                    item[1] = rs.getString("TenNhanVien");
                    item[2] = rs.getString("TenNhaCungCap");
                    item[3] = rs.getString("NgayNhap");
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
    public void loadDataChiTietPhieuNhap(String Text) throws SQLException{
        try {
            Connect a =new Connect();
            Connection conn =a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select MaCTPN, PhieuNhap.MaPhieuNhap, SanPham.TenSanPham, ChiTietPhieuNhap.SoLuong, ChiTietPhieuNhap.TongTien from PhieuNhap,ChiTietPhieuNhap,SanPham  where PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap and SanPham.MaSanPham = ChiTietPhieuNhap.MaSanPham and PhieuNhap.MaPhieuNhap="+ Text);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaPhieuNhap_PhieuNhap = new javax.swing.JTextField();
        txtTongTien_PhieuNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboTenNhanVien_PN = new javax.swing.JComboBox<>();
        cboNhaCungCap_PhieuNhap = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        btnThem_PhieuNhap = new javax.swing.JButton();
        btnSua_PhieuNhap = new javax.swing.JButton();
        btnXoa_PhieuNhap = new javax.swing.JButton();
        btnReset_PhieuNhap = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMaCTPN_PhieuNhap = new javax.swing.JTextField();
        txtMaPhieuNhap_CTPN = new javax.swing.JTextField();
        txtSoLuongCTPN_PhieuNhap = new javax.swing.JTextField();
        txtTongTienCTPN_PhieuNhap = new javax.swing.JTextField();
        cboSanPham_CTPN = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPhieuNhap_PhieuNhap = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblChiTietPhieuNhap_PhieuNhap = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Chi Tiết Phiếu Nhập");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Phiếu Nhập");

        jPanel11.setBackground(new java.awt.Color(153, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Mã Phiếu Nhập:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Tên Nhân Viên:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Ngày Nhập:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tổng Tiền:");

        txtMaPhieuNhap_PhieuNhap.setEditable(false);
        txtMaPhieuNhap_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nhà Cung Cấp:");

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });

        btnThem_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnThem_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnThem_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThem_PhieuNhap.setText("Thêm");
        btnThem_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_PhieuNhapActionPerformed(evt);
            }
        });

        btnSua_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnSua_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnSua_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        btnSua_PhieuNhap.setText("Sửa");
        btnSua_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_PhieuNhapActionPerformed(evt);
            }
        });

        btnXoa_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnXoa_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        btnXoa_PhieuNhap.setText("Xóa");
        btnXoa_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_PhieuNhapActionPerformed(evt);
            }
        });

        btnReset_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnReset_PhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset_PhieuNhap.setForeground(new java.awt.Color(0, 102, 102));
        btnReset_PhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnReset_PhieuNhap.setText("Reset");
        btnReset_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_PhieuNhapActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnThem_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnReset_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel17))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboNhaCungCap_PhieuNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaPhieuNhap_PhieuNhap)
                                    .addComponent(cboTenNhanVien_PN, 0, 253, Short.MAX_VALUE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(47, 47, 47)
                                .addComponent(txtTongTien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnSua_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXuat)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtMaPhieuNhap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboTenNhanVien_PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhaCungCap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTongTien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_PhieuNhap)
                    .addComponent(btnXoa_PhieuNhap)
                    .addComponent(btnReset_PhieuNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua_PhieuNhap)
                    .addComponent(btnXuat))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(153, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Mã CTPN:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Mã Phiếu Nhập:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Sản Phẩm:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Số Lượng:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Tổng Tiền:");

        txtMaCTPN_PhieuNhap.setEditable(false);
        txtMaCTPN_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));

        txtMaPhieuNhap_CTPN.setEditable(false);
        txtMaPhieuNhap_CTPN.setBackground(new java.awt.Color(204, 204, 204));

        txtSoLuongCTPN_PhieuNhap.setEditable(false);
        txtSoLuongCTPN_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));

        txtTongTienCTPN_PhieuNhap.setEditable(false);
        txtTongTienCTPN_PhieuNhap.setBackground(new java.awt.Color(204, 204, 204));
        txtTongTienCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        cboSanPham_CTPN.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoLuongCTPN_PhieuNhap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaPhieuNhap_CTPN, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSanPham_CTPN, 0, 228, Short.MAX_VALUE)
                    .addComponent(txtTongTienCTPN_PhieuNhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhieuNhap_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cboSanPham_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtSoLuongCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTongTienCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuNhap_PhieuNhap.setBackground(new java.awt.Color(255, 204, 204));
        tblPhieuNhap_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Nhập", "Nhân Viên", "Nhà Phân Phối", "Tổng Tiền", "Ngày Nhập"
            }
        ));
        tblPhieuNhap_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhap_PhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblPhieuNhap_PhieuNhap);
        if (tblPhieuNhap_PhieuNhap.getColumnModel().getColumnCount() > 0) {
            tblPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setMinWidth(100);
            tblPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jScrollPane7.setBackground(new java.awt.Color(255, 204, 204));

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
        if (tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumnCount() > 0) {
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setMinWidth(100);
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(0).setMaxWidth(100);
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(1).setMinWidth(100);
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblChiTietPhieuNhap_PhieuNhap.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTongTienCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienCTPN_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienCTPN_PhieuNhapActionPerformed

    private void btnThem_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_PhieuNhapActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
             if(txtMaPhieuNhap_PhieuNhap.getText().equals("")){
             }
             if(cboNhaCungCap_PhieuNhap.getSelectedItem().equals("")){
             sb.append("Hãy Nhập Nhà Cung Cấp! ");
             }
             else if(txtTongTien_PhieuNhap.getText().equals("")){
                   sb.append("Hãy Nhập Tổng Tiền! ");
               }else{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into PhieuNhap(MaNhanVien,MaNhaCungCap,NgayNhap,TongTien) values((select MaNhanVien from NhanVien where TenNhanVien=?),(select MaNhaCungCap from NhaCungCap where TenNhaCungCap=?),?,?)");
            //ps.setString(1, txtMaPhieuNhap_PhieuNhap.getText());
            ps.setString(1, cboTenNhanVien_PN.getSelectedItem().toString());
            ps.setString(2, cboNhaCungCap_PhieuNhap.getSelectedItem().toString());
            String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
            ps.setString(3,nam + "-" + thang + "-" + ngay);
            ps.setString(4, txtTongTien_PhieuNhap.getText());
            int chk = ps.executeUpdate();
            if(chk >0){
                JOptionPane.showMessageDialog(this, "Thêm Thành Công! ");
                tbn.setRowCount(0);
                loadDataPhieuNhap();
            }
             }
             if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(this, sb.toString());
                    return;
                }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnThem_PhieuNhapActionPerformed

    private void btnSua_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_PhieuNhapActionPerformed
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement comm=conn.prepareStatement("Update PhieuNhap set MaNhanVien=(select MaNhanVien from NhanVien where TenNhanVien=?),MaNhaCungCap=(select MaNhaCungCap from NhaCungCap where TenNhaCungCap=?),NgayNhap=?,TongTien=? where MaPhieuNhap=?");
            comm.setString(5, txtMaPhieuNhap_PhieuNhap.getText());
            comm.setString(1, cboTenNhanVien_PN.getSelectedItem().toString());
            comm.setString(2, cboNhaCungCap_PhieuNhap.getSelectedItem().toString());
            String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
            comm.setString(3,nam + "-" + thang + "-" + ngay);
            comm.setString(4, txtTongTien_PhieuNhap.getText());
            int chk =comm.executeUpdate();
            if(chk >0){
                JOptionPane.showMessageDialog(this, "Sửa Thành Công! ");
                tbn.setRowCount(0);
                loadDataPhieuNhap();
            }else{}
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnSua_PhieuNhapActionPerformed

    private void btnXoa_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_PhieuNhapActionPerformed
        try {StringBuilder sb= new StringBuilder();
            if(txtMaPhieuNhap_PhieuNhap.getText().equals("")){
                sb.append("Hãy click vào Mã Phiếu Nhập muốn xóa !");
            }
            else{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement comm=conn.prepareStatement("Delete PhieuNhap where MaPhieuNhap=?");
            comm.setString(1, tblPhieuNhap_PhieuNhap.getValueAt(tblPhieuNhap_PhieuNhap.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Dữ Liệu Hay Không ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                comm.executeUpdate();
                tbn.setRowCount(0);
                loadDataPhieuNhap();
            } }if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }              
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoa_PhieuNhapActionPerformed

    private void btnReset_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_PhieuNhapActionPerformed
        txtMaPhieuNhap_PhieuNhap.setText("");
        cboTenNhanVien_PN.setSelectedItem("");
        cboNhaCungCap_PhieuNhap.setSelectedItem("");
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
        txtTongTien_PhieuNhap.setText("");
    }//GEN-LAST:event_btnReset_PhieuNhapActionPerformed

    private void tblPhieuNhap_PhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhap_PhieuNhapMouseClicked
        int viTriDongVuaBam = tblPhieuNhap_PhieuNhap.getSelectedRow();
        txtMaPhieuNhap_PhieuNhap.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 0).toString());
        cboTenNhanVien_PN.setSelectedItem(tblPhieuNhap_PhieuNhap.getModel().getValueAt(tblPhieuNhap_PhieuNhap.getSelectedRow(),1));
        cboNhaCungCap_PhieuNhap.setSelectedItem(tblPhieuNhap_PhieuNhap.getModel().getValueAt(tblPhieuNhap_PhieuNhap.getSelectedRow(),2));
        String ngaynhap = tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 3).toString();
        String strngay, strthang, strnam;
        strngay = ngaynhap.substring(8, 10);
        strthang = ngaynhap.substring(5, 7);
        strnam = ngaynhap.substring(0, 4);
        int ngay, thang, nam;
        ngay = Integer.valueOf(strngay);
        thang = Integer.valueOf(strthang);
        nam = Integer.valueOf(strnam);
        cbbNgay.setSelectedItem(String.valueOf(ngay));
        cbbThang.setSelectedItem(String.valueOf(thang));
        cbbNam.setSelectedItem(String.valueOf(nam));
        txtTongTien_PhieuNhap.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 4).toString());
    try {
        loadDataChiTietPhieuNhap(txtMaPhieuNhap_PhieuNhap.getText());
    } catch (SQLException ex) {
        Logger.getLogger(FrmPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tblPhieuNhap_PhieuNhapMouseClicked

    private void tblChiTietPhieuNhap_PhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked
        int viTriDongVuaBam = tblChiTietPhieuNhap_PhieuNhap.getSelectedRow();
        txtMaCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 0).toString());
        txtMaPhieuNhap_CTPN.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 1).toString());
        txtSoLuongCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 3).toString());
        txtTongTienCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 4).toString());
        cboSanPham_CTPN.setSelectedItem(tblChiTietPhieuNhap_PhieuNhap.getModel().getValueAt(tblChiTietPhieuNhap_PhieuNhap.getSelectedRow(),2));
    }//GEN-LAST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked

    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged
        String thang = cbbThang.getSelectedItem().toString();
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        String thanght;

        thanght = cbbNgay.getSelectedItem().toString();

        if (thang.equals("4") || thang.equals("6") || thang.equals("9") || thang.equals("11")) {
            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 31; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 31) {
                cbbNgay.setSelectedItem(thanght);
            }
        } else if (thang.equals("1") || thang.equals("3") || thang.equals("5")
            || thang.equals("7") || thang.equals("8") || thang.equals("12") || thang.equals("10")) {

            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 32; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 32) {
                cbbNgay.setSelectedItem(thanght);
            }
        } else {
            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 29; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 29) {
                cbbNgay.setSelectedItem(thanght);
            }
        }
    }//GEN-LAST:event_cbbThangItemStateChanged

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
                for (int i = 0; i < tblChiTietPhieuNhap_PhieuNhap.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tblChiTietPhieuNhap_PhieuNhap.getColumnCount()-1; j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tblChiTietPhieuNhap_PhieuNhap.getValueAt(i, j).toString());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset_PhieuNhap;
    private javax.swing.JButton btnSua_PhieuNhap;
    private javax.swing.JButton btnThem_PhieuNhap;
    private javax.swing.JButton btnXoa_PhieuNhap;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JComboBox<String> cboNhaCungCap_PhieuNhap;
    private javax.swing.JComboBox<String> cboSanPham_CTPN;
    private javax.swing.JComboBox<String> cboTenNhanVien_PN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblChiTietPhieuNhap_PhieuNhap;
    private javax.swing.JTable tblPhieuNhap_PhieuNhap;
    private javax.swing.JTextField txtMaCTPN_PhieuNhap;
    private javax.swing.JTextField txtMaPhieuNhap_CTPN;
    private javax.swing.JTextField txtMaPhieuNhap_PhieuNhap;
    private javax.swing.JTextField txtSoLuongCTPN_PhieuNhap;
    private javax.swing.JTextField txtTongTienCTPN_PhieuNhap;
    private javax.swing.JTextField txtTongTien_PhieuNhap;
    // End of variables declaration//GEN-END:variables
}
