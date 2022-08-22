/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FrmNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form FrmNhanVien
     * @throws java.sql.SQLException
     */
    private byte[] personalImage;
    public class LayHinh {
    private byte[] Hinh;
    public  LayHinh(){
    }

    public LayHinh( byte[] Hinh) {

        this.Hinh = Hinh;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

    
}

    public  LayHinh findbyID(String MaNhanVien) throws SQLException{
        Connect a = new Connect();
        Connection conn = a.getConnection();
        PreparedStatement pv = conn.prepareStatement("Select* from NhanVien where MaNhanVien= "+MaNhanVien);
        try(ResultSet rt = pv.executeQuery();) {
            if(rt.next()){
            LayHinh nv = new LayHinh();
            Blob blob = rt.getBlob("img");
            nv.setHinh(blob.getBytes(1, (int) blob.length()));
            return nv;
        }  
            return null;
        } catch (Exception e) {
        }
        return null; 
    }
    public FrmNhanVien() throws SQLException {
        initComponents();
        loadDataNhanVien();
        loadCombobox();
        rdoNam.setSelected(true);
        cbChucVu.setSelectedIndex(0);
        SetNgaySinh();
    }
    public void loadCombobox() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenChucVu from ChucVu group by TenChucVu");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               cbChucVu.addItem(rs.getString("TenChucVu"));
            }
        } catch (Exception e) {
        }

    }
    public  void loadDataNhanVien() throws SQLException{
        {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from NhanVien join ChucVu on Nhanvien.MaChucVu=ChucVu.MaChucVu");
            Object[] obj = new Object[]{ "Mã Nhân Viên ", "Tên Nhân Viên","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại","Tên Chức Vụ"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblNhanVien.setModel(tableModel);

            try {
                while (rs.next()) {

                    Object[] item = new Object[8];
                    item[0] = rs.getInt("MaNhanVien");
                    item[1] = rs.getString("TenNhanVien");
                    item[2] = rs.getDate("NgaySinh");
                    item[3] = rs.getString("GioiTinh");
                    item[4] = rs.getString("DiaChi");
                    item[5] = rs.getString("SDT");
                    item[6] = rs.getString("TenChucVu");
                    tableModel.addRow(item);
                }
   
        } catch (SQLException ex) {
                System.out.println(ex.toString());
        }
        }
    }
    public void Reset(){
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
        txtDiaChi.setText("");
        txtSDT.setText("");
        cbChucVu.setSelectedIndex(0);
        rdoNam.setSelected(true);

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
        for (int i = 1969; i < year; i++) {
            cbbNam.addItem(String.valueOf(i));
        }
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbChucVu = new javax.swing.JComboBox<>();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        rdoTheoMa = new javax.swing.JRadioButton();
        rdoTheoTen = new javax.swing.JRadioButton();
        btnTimKiem = new javax.swing.JButton();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        lblImage = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhân Viên");

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mã Nhân Viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Họ Tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ngày Sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Giới Tính:");

        txtMaNhanVien.setEditable(false);
        txtMaNhanVien.setBackground(java.awt.SystemColor.controlHighlight);
        txtMaNhanVien.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup2.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Chức Vụ:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Số Điện thoại:");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 102, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add_16x16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 102, 102));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete_16x16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
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

        buttonGroup1.add(rdoTheoMa);
        rdoTheoMa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoMa.setText("Mã Nhân Viên");

        buttonGroup1.add(rdoTheoTen);
        rdoTheoTen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoTen.setText("Tên Nhân Viên");

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Preview_16x16.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });
        cbbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenNhanVien)
                                .addComponent(txtMaNhanVien)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbbNam, 0, 54, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(68, 68, 68)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(19, 19, 19)
                        .addComponent(btnSua)
                        .addGap(19, 19, 19)
                        .addComponent(btnXoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiaChi)
                                    .addComponent(cbChucVu, 0, 149, Short.MAX_VALUE))))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoTheoMa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoTheoTen))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnReset)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnTimKiem))
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTheoMa)
                    .addComponent(rdoTheoTen))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset)
                    .addComponent(btnTimKiem))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tblNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Toại", "Chức Vụ", "Link Avatar"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(50);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(50);
            tblNhanVien.getColumnModel().getColumn(4).setMinWidth(80);
            tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblNhanVien.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        lblImage.setBackground(new java.awt.Color(51, 51, 51));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NOIMAGE.jpg"))); // NOI18N

        btnChonAnh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChonAnh.setForeground(new java.awt.Color(0, 102, 102));
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Check_16x16.png"))); // NOI18N
        btnChonAnh.setText("Chọn Ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnChonAnh))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChonAnh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Reset();
        rdoTheoMa.setSelected(true);
        txtTimKiem.setText("");
        personalImage = null;
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/NOIMAGE.jpg"));
        lblImage.setIcon(icon);
        try {
            loadDataNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int viTriDongVuaBam = tblNhanVien.getSelectedRow();
        txtMaNhanVien.setText(tblNhanVien.getValueAt(viTriDongVuaBam, 0).toString());
        txtTenNhanVien.setText(tblNhanVien.getValueAt(viTriDongVuaBam, 1).toString());
        String ngaysinh = tblNhanVien.getValueAt(viTriDongVuaBam, 2).toString();
        String strngay, strthang, strnam;
        strngay = ngaysinh.substring(8, 10);
        strthang = ngaysinh.substring(5, 7);
        strnam = ngaysinh.substring(0, 4);
        int ngay, thang, nam;
        ngay = Integer.valueOf(strngay);
        thang = Integer.valueOf(strthang);
        nam = Integer.valueOf(strnam);
        cbbNgay.setSelectedItem(String.valueOf(ngay));
        cbbThang.setSelectedItem(String.valueOf(thang));
        cbbNam.setSelectedItem(String.valueOf(nam));
        txtDiaChi.setText(tblNhanVien.getValueAt(viTriDongVuaBam, 4).toString());
        txtSDT.setText(tblNhanVien.getValueAt(viTriDongVuaBam, 5).toString());
        cbChucVu.setSelectedItem(tblNhanVien.getModel().getValueAt(tblNhanVien.getSelectedRow(),6));
        String GioiTinh = tblNhanVien.getValueAt(viTriDongVuaBam, 3).toString();
        if(GioiTinh.equals("Nam")){
            rdoNam.setSelected(true);
        }
        if(GioiTinh.equals("Nữ")){
            rdoNu.setSelected(true);
        }
      
        try {
            String id = tblNhanVien.getValueAt(viTriDongVuaBam, 0).toString();
            /*System.out.println(id);*/
            LayHinh nv = findbyID(id);
            /*System.out.println(nv);*/
            if (nv.getHinh()!= null) {
            Image img = ImageHelper.createImageFromByteArray(nv.getHinh(),"jpg");
            lblImage.setIcon(new ImageIcon(img));
            /*System.out.println(Arrays.toString(nv.getHinh()));*/
            }
            else{
             personalImage = nv.getHinh();
             ImageIcon icon = new ImageIcon(getClass().getResource("/image/aaa.jpg"));
             lblImage.setIcon(icon);
            }
        } catch (SQLException ex) {
            System.out.println("Frm.FrmNhanVien.tblNhanVienMouseClicked()");
        } catch (IOException ex) {
            Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
             StringBuilder sb = new StringBuilder();
             if(txtMaNhanVien.getText().equals("")){
             if(txtTenNhanVien.getText().equals("")){
             sb.append("Hãy Nhập Tên Nhân Viên !");
             }
             else if(txtDiaChi.getText().equals("")){
             sb.append("Hãy Nhập Địa Chỉ");
             }
             else if(txtSDT.getText().equals("")){
             sb.append("Hãy Nhập Số Điện Thoại");
             }
             else{
             Connect a = new Connect();
             Connection conn = a.getConnection();
                     
             PreparedStatement ps = conn.prepareStatement("insert into NhanVien(TenNhanVien, NgaySinh, GioiTinh, DiaChi, SDT, MaChucVu,img) values(?,?,?, ?, ?,(Select MaChucVu from ChucVu where TenChucVu=?),?)");
             /* ps.setString(1,txtMaNhanVien.getText());*/
             ps.setString(1,txtTenNhanVien.getText());
             String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
             ps.setString(2,nam + "-" + thang + "-" + ngay);
             if(rdoNam.isSelected()){
             ps.setString(3,"Nam");
             }
             else{
             ps.setString(3,"Nữ");
             }
             ps.setString(4,txtDiaChi.getText()); 
             ps.setString(5,txtSDT.getText());
             ps.setString(6,cbChucVu.getSelectedItem().toString());
             if(personalImage!=null){
             Blob PI = new SerialBlob(personalImage);
             ps.setBlob(7,PI);
             }else{
             Blob PI = null;
             ps.setBlob(7,PI);
             }
             int chk = ps.executeUpdate();
             if(chk>0){
             sb.append("Thêm thành công!");
             loadDataNhanVien();
             Reset();
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

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
             if(txtMaNhanVien.getText().equals("")){
             sb.append("Hãy Chọn Nhân Viên Bạn Muốn Sửa !");
             }
             else{
             if(txtTenNhanVien.getText().equals("")){
             sb.append("Hãy Nhập Tên Nhân Viên !");
             }
             else if(txtDiaChi.getText().equals("")){
             sb.append("Hãy Nhập Địa Chỉ !");
             }
             else if(txtSDT.getText().equals("")){
             sb.append("Hãy Nhập Số Điện Thoại!");
             }
             else{ 
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pr = conn.prepareStatement("update NhanVien set TenNhanVien=?,NgaySinh=?,GioiTinh=?,DiaChi=?,SDT=?,MaChucVu=(Select MaChucVu from ChucVu where TenChucVu=?),img=? where MaNhanVien=?");
            pr.setString(1,txtTenNhanVien.getText());
            String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
            pr.setString(2,nam + "-" + thang + "-" + ngay);
            if(rdoNam.isSelected()){
             pr.setString(3,"Nam");
             }
             else{
             pr.setString(3,"Nữ");
             }
            pr.setString(4,txtDiaChi.getText());
            pr.setString(5,txtSDT.getText());
            pr.setString(6,cbChucVu.getSelectedItem().toString());
            if(personalImage!=null){
             Blob PI = new SerialBlob(personalImage);
             pr.setBlob(7,PI);
             }else{
             Blob PI = null;
             pr.setBlob(7,PI);
             }
            pr.setString(8, tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(),0).toString());
            pr.executeUpdate();
            loadDataNhanVien();
            Reset();
            sb.append("Sửa Thành Công");
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            StringBuilder sb= new StringBuilder();
            String MaNhanVien = txtMaNhanVien.getText();
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement sv = conn.createStatement();
            Statement st = conn.createStatement();
            Statement sc = conn.createStatement();
            
            if (!MaNhanVien.equals("")) {
                String cautruyvan = "delete NhanVien where MaNhanVien=" + MaNhanVien;
                String ctvKiemThu = "select count(MaHoaDon) as SoHoaDon"
                        + " from NhanVien,HoaDon where NhanVien.MaNhanVien=HoaDon.MaNhanVien and NhanVien.MaNhanVien=" + MaNhanVien;
                ResultSet rs1 = sv.executeQuery(ctvKiemThu);
                String ctvKiemThu2 = "select count(MaPhieuNhap) as SoPhieuNhap"
                        + " from NhanVien,PhieuNhap where NhanVien.MaNhanVien=PhieuNhap.MaNhanVien and NhanVien.MaNhanVien=" + MaNhanVien;
                ResultSet rs2 = st.executeQuery(ctvKiemThu2);
                int so1 = 0, so2 = 0;
                
                try {
                    if (rs1.next()) {
                        so1 = rs1.getInt("SoHoaDon");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
                try {
                    
                    if (rs2.next()) {
                        so2 = rs2.getInt("SoPhieuNhap");
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
                if (so2 == 0 && so1 == 0) {
                            sc.executeUpdate(cautruyvan);
                            System.out.println("đã xóa");
                            loadDataNhanVien();
                            Reset();
                        } else {
                            sb.append("không thể xóa bởi có trong " + so1 + " hóa đơn \n và có trong "
                                    + so2 + "   phiếu Nhập");
                        }
            } else {
                sb.append("Hãy click vào nhân viên bạn muốn xóa!");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            if(rdoTheoMa.isSelected()){
                if (txtTimKiem.getText().equals("")) {
                    sb.append("Hãy nhập Mã bạn muốn tìm kiếm !");
                }
                else{
                 PreparedStatement pa = conn.prepareStatement("select * from NhanVien join ChucVu on Nhanvien.MaChucVu=ChucVu.MaChucVu where MaNhanVien=?");
                 pa.setString(1, txtTimKiem.getText());
                 ResultSet ra = pa.executeQuery();
                 Object[] obj = new Object[]{ "Mã Nhân Viên ", "Tên Nhân Viên","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại","Tên Chức Vụ"};
                 DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                 tblNhanVien.setModel(tableModel);
                 try {
                while (ra.next()) {

                    Object[] item = new Object[8];
                    item[0] = ra.getInt("MaNhanVien");
                    item[1] = ra.getString("TenNhanVien");
                    item[2] = ra.getDate("NgaySinh");
                    item[3] = ra.getString("GioiTinh");
                    item[4] = ra.getString("DiaChi");
                    item[5] = ra.getString("SDT");
                    item[6] = ra.getString("TenChucVu");
                    
                    tableModel.addRow(item);
                }
   
                 } catch (SQLException ex) {
                            System.out.println(ex.toString());
                    }
           
                }
                 if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                }
            }
            else if(rdoTheoTen.isSelected()){
                  if (txtTimKiem.getText().equals("")) {
                    sb.append("Hãy nhập Tên bạn muốn tìm kiếm !");
                }
                else{
                 PreparedStatement pf = conn.prepareStatement("select * from NhanVien join ChucVu on Nhanvien.MaChucVu=ChucVu.MaChucVu where TenNhanVien like ?");
                 pf.setString(1,('%'+ txtTimKiem.getText() +'%'));
                 /*pf.setString(2,(txtTimKiem.getText()));
                 pf.setString(3,(txtTimKiem.getText()+'%'));*/
                 ResultSet rb = pf.executeQuery();
                 Object[] obj = new Object[]{ "Mã Nhân Viên ", "Tên Nhân Viên","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại","Tên Chức Vụ"};
                 DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                 tblNhanVien.setModel(tableModel);
                 try {
                while (rb.next()) {

                    Object[] item = new Object[8];
                    item[0] = rb.getInt("MaNhanVien");
                    item[1] = rb.getString("TenNhanVien");
                    item[2] = rb.getDate("NgaySinh");
                    item[3] = rb.getString("GioiTinh");
                    item[4] = rb.getString("DiaChi");
                    item[5] = rb.getString("SDT");
                    item[6] = rb.getString("TenChucVu");
                    
                    tableModel.addRow(item);
                }
   
                 } catch (SQLException ex) {
                            System.out.println(ex.toString());
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
        } catch (SQLException e) {
        }
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

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

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        JFileChooser Chooser = new JFileChooser();
        Chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory()){
                    return true;
                }else{
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }
            @Override
            public String getDescription() {
                return "Image File(*.jpg)";
             }
            
        });
        if(Chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION){
             return;
        }
        File file = Chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(),230,266);
            ImageIcon resizedIcon = new ImageIcon(img);
            lblImage.setIcon(resizedIcon);
            personalImage = ImageHelper.tobyteArray(img,"jpg");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Loi");
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void cbbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTheoMa;
    private javax.swing.JRadioButton rdoTheoTen;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}