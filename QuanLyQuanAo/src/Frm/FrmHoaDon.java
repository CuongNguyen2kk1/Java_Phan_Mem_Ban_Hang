/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hai Nguyen
 */
public class FrmHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form FrmHoaDon
     */
    DefaultTableModel tbn = new DefaultTableModel();
    public FrmHoaDon() throws SQLException {
        initComponents();
        loadDataHoaDon();
        loadComboboxKhachHang();
        loadComboboxNhanVien();
        loadComboboxSanPham();
        SetNgaySinh();
    }
    private static String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";
    public void loadComboboxKhachHang() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenKhachHang from KhachHang group by TenKhachHang ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbbMaKhachHang.addItem(rs.getString("TenKhachHang"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void loadComboboxNhanVien() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenNhanVien from NhanVien group by TenNhanVien ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbbMaNhanVien.addItem(rs.getString("TenNhanVien"));
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
                cbbSanPham_ChiTietHoaDon.addItem(rs.getString("TenSanPham"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void SetNgaySinh(){
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
    public  void loadDataHoaDon() throws SQLException{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from HoaDon,NhanVien,KhachHang where NhanVien.MaNhanVien=HoaDon.MaNhanVien and KhachHang.MaKhachHang=HoaDon.MaKhachHang");
            Object[] obj = new Object[]{"Mã Hóa Đơn ", "Khách Hàng", "Nhân Viên", "Ngày Lập HĐ", "Tổng Tiền"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblHoaDon.setModel(tableModel);
            int c = 0;
            try {
                while (rs.next()) {
                    c++;
                    Object[] item = new Object[6];
                    item[0] = rs.getInt("MaHoaDon");
                    item[1] = rs.getString("TenKhachHang");
                    item[2] = rs.getString("TenNhanVien");
                    item[3] = rs.getString("NgayLapHoaDon");
                    item[4] = rs.getInt("Tongtien");
                    tableModel.addRow(item);
                    
                }
   
        } catch (SQLException ex) {
                System.out.println(ex.toString());
        }
    }
    private void loadDataChiTietHoaDon(String text) throws SQLException {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select ChiTietHoaDon.*,SanPham.TenSanPham from HoaDon,ChiTietHoaDon,SanPham where  SanPham.MaSanPham=ChiTietHoaDon.MaSanPham and HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon and HoaDon.MaHoaDon= "+text );
            Object[] obj = new Object[]{"Mã CTDH", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Tổng Tiền"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblChiTietHoaDon.setModel(tableModel);
            int c = 0;
            try {
                while (rs.next()) {
                    c++;
                    Object[] item = new Object[5];
                    item[0] = rs.getInt("MaCTHD");
                    item[1] = rs.getInt("MaHoaDon");
                    item[2] = rs.getString("TenSanPham");
                    item[3] = rs.getInt("SoLuong");
                    item[4] = rs.getInt("TongTien");
                    tableModel.addRow(item);
                }
            } catch (SQLException ex) {
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

        jLabel35 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        lblMaHoaDon_HoaDon = new javax.swing.JLabel();
        lblTongTien_HoaDon = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        cbbMaKhachHang = new javax.swing.JComboBox<>();
        cbbMaNhanVien = new javax.swing.JComboBox<>();
        txtMaHoaDon = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblNgayLap = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        lblMaCTHD = new javax.swing.JLabel();
        lblSoLuong_CTPM = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTongTien_ChiTietHoaDon = new javax.swing.JTextField();
        cbbSanPham_ChiTietHoaDon = new javax.swing.JComboBox<>();
        txtMaCTHD = new javax.swing.JTextField();
        txtMaHoaDon_ChiTietHoaDon = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtSoLuong_ChiTietHoaDon = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Bảng Hóa Đơn");

        tblHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Khách Hàng", "Nhân Viên", "Ngày Lập HĐ", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblHoaDon);

        jPanel14.setBackground(new java.awt.Color(153, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(400, 227));

        lblMaHoaDon_HoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaHoaDon_HoaDon.setText("Mã Hóa Đơn:");

        lblTongTien_HoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTongTien_HoaDon.setText("Tổng Tiền:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Nhân Viên:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Khách Hàng:");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        cbbMaNhanVien.setActionCommand("");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setBackground(new java.awt.Color(204, 204, 204));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 102, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 102, 102));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete_16x16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(0, 102, 102));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit_16x16.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 102, 102));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblNgayLap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayLap.setText("Ngày Lập:");
        lblNgayLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNgayLapMouseClicked(evt);
            }
        });

        cbbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(cbbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbMaNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset))
                .addGap(14, 14, 14))
        );

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Bảng Chi Tiết Hóa Đơn");

        tblChiTietHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Tổng Tiền"
            }
        ));
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblChiTietHoaDon);

        jPanel19.setBackground(new java.awt.Color(153, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(400, 230));

        lblMaCTHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaCTHD.setText("Mã CTHD:");

        lblSoLuong_CTPM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoLuong_CTPM.setText("Số Lượng:");

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaHoaDon.setText("Mã Hóa Đơn:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Sản Phẩm:");

        txtTongTien_ChiTietHoaDon.setEditable(false);
        txtTongTien_ChiTietHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        txtTongTien_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTien_ChiTietHoaDonActionPerformed(evt);
            }
        });

        cbbSanPham_ChiTietHoaDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSanPham_ChiTietHoaDonItemStateChanged(evt);
            }
        });

        txtMaCTHD.setEditable(false);
        txtMaCTHD.setBackground(new java.awt.Color(204, 204, 204));

        txtMaHoaDon_ChiTietHoaDon.setEditable(false);
        txtMaHoaDon_ChiTietHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        txtMaHoaDon_ChiTietHoaDon.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Tổng Tiền:");

        txtSoLuong_ChiTietHoaDon.setEditable(false);
        txtSoLuong_ChiTietHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        txtSoLuong_ChiTietHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtMaHoaDon_ChiTietHoaDon)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoLuong_CTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuong_ChiTietHoaDon)
                    .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoLuong_CTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int viTriDongVuaBam = tblHoaDon.getSelectedRow();
        txtMaHoaDon.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 0).toString());
        String ngaynhap = tblHoaDon.getValueAt(viTriDongVuaBam, 3).toString();
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
        txtTongTien.setText(tblHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        cbbMaKhachHang.setSelectedItem(tblHoaDon.getModel().getValueAt(tblHoaDon.getSelectedRow(), 1));
        cbbMaNhanVien.setSelectedItem(tblHoaDon.getModel().getValueAt(tblHoaDon.getSelectedRow(), 2));
        try {
            loadDataChiTietHoaDon(txtMaHoaDon.getText());
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked

    }//GEN-LAST:event_jLabel30MouseClicked

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
             StringBuilder sb = new StringBuilder();
             if(txtMaHoaDon.getText().equals("")){
             if(txtTongTien.getText().equals("")){
             sb.append("Hãy Nhập Tổng Tiền !");
             }
             else{
                Connect a = new Connect();
                Connection conn = a.getConnection();

                PreparedStatement ps = conn.prepareStatement("insert into HoaDon(MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien) values((Select MaKhachHang from KhachHang where TenKhachHang=?),(Select MaNhanVien from NhanVien where TenNhanVien=?),?,?)");
                ps.setString(1,cbbMaKhachHang.getSelectedItem().toString());
                ps.setString(2,cbbMaNhanVien.getSelectedItem().toString());
                String ngay, thang, nam;
                ngay = cbbNgay.getSelectedItem().toString();
                thang = cbbThang.getSelectedItem().toString();
                nam = cbbNam.getSelectedItem().toString();
                ps.setString(3,nam + "-" + thang + "-" + ngay);
                ps.setString(4,txtTongTien.getText());
                int chk = ps.executeUpdate();
             if(chk>0){
                sb.append("Thêm thành công!");
                loadDataHoaDon();
                        }
                }
                }
             else{
                 sb.append("Hãy Nhấn Reset Trước Khi Thêm");
             }
                if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }

             JOptionPane.showMessageDialog(this, sb.toString());
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
       
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            StringBuilder sb= new StringBuilder();
            if(txtMaHoaDon.getText().equals("")){
                sb.append("Hãy click vào Hóa Đơn Bạn muốn xóa !");
            }
            else{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pc = conn.prepareStatement("delete HoaDon where MaHoaDon=?");
            pc.setString(1, tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Bạn thật sự muốn xóa ?", "Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            pc.executeUpdate();
            sb.append("Xóa Thành Công");
            loadDataHoaDon();
            }
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
             if(txtMaHoaDon.getText().equals("")){
             sb.append("Hãy Chọn Hóa Đơn Bạn Muốn Sửa !");
             }
             else{
             if(txtTongTien.getText().equals("")){
             sb.append("Hãy Nhập Tổng Tiền !");
             }
             else{ 
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pr = conn.prepareStatement("update HoaDon set MaKhachHang=(Select MaKhachHang from KhachHang where TenKhachHang=?),MaNhanVien=(Select MaNhanVien from NhanVien where TenNhanVien=?),NgayLapHoaDon=?,TongTien=? where MaHoaDon=?");
            pr.setString(1,cbbMaKhachHang.getSelectedItem().toString());
            pr.setString(2,cbbMaNhanVien.getSelectedItem().toString());
            String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
            pr.setString(3,nam + "-" + thang + "-" + ngay);
            pr.setString(4,txtTongTien.getText());
            pr.setString(5,txtMaHoaDon.getText());
            pr.executeUpdate();
            sb.append("Sửa Thành Công");
            loadDataHoaDon();
             }
             }
             if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaHoaDon.setText("");
        cbbMaKhachHang.setSelectedIndex(0);
        cbbMaNhanVien.setSelectedIndex(0);
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
        txtTongTien.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void lblNgayLapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNgayLapMouseClicked
//        frmNgay frmngaylap = new frmNgay();
//        frmngaylap.show();
    }//GEN-LAST:event_lblNgayLapMouseClicked

    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
        int viTriDongVuaBam = tblChiTietHoaDon.getSelectedRow();
        txtMaCTHD.setText(tblChiTietHoaDon.getValueAt(viTriDongVuaBam, 0).toString());
        txtMaHoaDon_ChiTietHoaDon.setText(tblChiTietHoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtSoLuong_ChiTietHoaDon.setText(tblChiTietHoaDon.getValueAt(viTriDongVuaBam, 3).toString());
        txtTongTien_ChiTietHoaDon.setText(tblChiTietHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        cbbSanPham_ChiTietHoaDon.setSelectedItem(tblChiTietHoaDon.getModel().getValueAt(tblChiTietHoaDon.getSelectedRow(), 2));
    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked

    private void txtTongTien_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_ChiTietHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien_ChiTietHoaDonActionPerformed

    private void cbbSanPham_ChiTietHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPham_ChiTietHoaDonItemStateChanged

    }//GEN-LAST:event_cbbSanPham_ChiTietHoaDonItemStateChanged

    private void txtSoLuong_ChiTietHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    private void txtSoLuong_ChiTietHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyReleased

    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyReleased

    private void cbbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbMaKhachHang;
    private javax.swing.JComboBox<String> cbbMaNhanVien;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbSanPham_ChiTietHoaDon;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLabel lblMaCTHD;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaHoaDon_HoaDon;
    public javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSoLuong_CTPM;
    private javax.swing.JLabel lblTongTien_HoaDon;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaCTHD;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaHoaDon_ChiTietHoaDon;
    private javax.swing.JTextField txtSoLuong_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTien_ChiTietHoaDon;
    // End of variables declaration//GEN-END:variables



}
