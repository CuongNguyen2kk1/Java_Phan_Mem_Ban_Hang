/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;
//import com.sun.xml.internal.ws.util.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FrmKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form FrmKhachHang
     */
    public FrmKhachHang() throws SQLException {
        initComponents();
        loadCombobox();
        loadDataKH();
        rdoNam.setSelected(true);
        cbLoaiKhachHang.setSelectedIndex(0);
        SetNgaySinh();
        
    }
       
     
    public void loadCombobox() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenLoaiKhachHang from LoaiKhachHang ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               cbLoaiKhachHang.addItem(rs.getString("TenLoaiKhachHang"));
            }
        } catch (Exception e) {
        }

    }
    public  void loadDataKH() throws SQLException{
        {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from KhachHang join LoaiKhachHang on KhachHang.MaLoaiKhachHang=LoaiKhachHang.MaLoaiKhachHang");
            Object[] obj = new Object[]{ "Mã Khách Hàng ", "Tên Khách Hàng","Loại Khách Hàng","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại"};
            DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
            tblKhachHang.setModel(tableModel);

            try {
                while (rs.next()) {

                    Object[] item = new Object[8];
                    item[0] = rs.getInt("MaKhachHang");
                    item[1] = rs.getString("TenKhachHang");
                    item[2] = rs.getString("TenLoaiKhachHang");
                    item[3] = rs.getDate("NgaySinh");
                    item[4] = rs.getString("GioiTinh");
                    item[5] = rs.getString("DiaChi");
                    item[6] = rs.getString("SDT");
                    
                    tableModel.addRow(item);
                }
   
        } catch (SQLException ex) {
                System.out.println(ex.toString());
        }
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
        for (int i = 1969; i < year; i++) {
            cbbNam.addItem(String.valueOf(i));
        }
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
    }                
    public void reset(){
        txtMaKH.setText("");
        txtTenKH.setText("");
        cbbNam.setSelectedIndex(0);
        cbbNgay.setSelectedIndex(0);
        cbbThang.setSelectedIndex(0);
        txtDiaChi.setText("");
        txtSDT.setText("");
        cbLoaiKhachHang.setSelectedIndex(0);
        rdoNam.setSelected(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbLoaiKhachHang = new javax.swing.JComboBox<>();
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
        tblKhachHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách Hàng");

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tên Khách Hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ngày Sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Giới Tính:");

        txtMaKH.setEditable(false);
        txtMaKH.setBackground(new java.awt.Color(204, 204, 204));
        txtMaKH.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Loại Khách Hàng :");

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

        buttonGroup2.add(rdoTheoMa);
        rdoTheoMa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoMa.setText("Mã Khách Hàng");

        buttonGroup2.add(rdoTheoTen);
        rdoTheoTen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoTheoTen.setText("Tên Khách Hàng");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbThang, 0, 52, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenKH)
                    .addComponent(txtMaKH))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLoaiKhachHang, javax.swing.GroupLayout.Alignment.LEADING, 0, 177, Short.MAX_VALUE)
                            .addComponent(txtSDT))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoTheoMa)
                                    .addComponent(rdoTheoTen)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdoTheoMa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoTheoTen))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tblKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Loại Khách Hàng", "Địa Chỉ", "Số Điện Thoại"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(1).setMinWidth(200);
            tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblKhachHang.getColumnModel().getColumn(1).setMaxWidth(200);
            tblKhachHang.getColumnModel().getColumn(2).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblKhachHang.getColumnModel().getColumn(2).setMaxWidth(150);
            tblKhachHang.getColumnModel().getColumn(3).setMinWidth(80);
            tblKhachHang.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblKhachHang.getColumnModel().getColumn(3).setMaxWidth(80);
            tblKhachHang.getColumnModel().getColumn(4).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblKhachHang.getColumnModel().getColumn(4).setMaxWidth(150);
            tblKhachHang.getColumnModel().getColumn(5).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblKhachHang.getColumnModel().getColumn(5).setMaxWidth(150);
            tblKhachHang.getColumnModel().getColumn(6).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblKhachHang.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
             StringBuilder sb = new StringBuilder();
             if(txtMaKH.getText().equals("")){
             if(txtTenKH.getText().equals("")){
             sb.append("Hãy Nhập Tên Khách Hàng!");
             }
             else if(txtDiaChi.getText().equals("")){
             sb.append("Hãy Nhập Địa Chỉ Của Khách Hàng!");
             }
             else if(txtSDT.getText().equals("")){
             sb.append("Hãy Nhập Số Điện Thoại Của Khách Hàng!");
             }
             else{
             Connect a = new Connect();
             Connection conn = a.getConnection();
                     
             PreparedStatement ps = conn.prepareStatement("insert into KhachHang(TenKhachHang,MaLoaiKhachHang, NgaySinh, GioiTinh, DiaChi, SDT) values(?,(Select MaLoaiKhachHang from LoaiKhachHang where TenLoaiKhachHang=?),?, ?, ?,?)");
             /* ps.setString(1,txtMaNhanVien.getText());*/
             ps.setString(1,txtTenKH.getText());
             ps.setString(2,cbLoaiKhachHang.getSelectedItem().toString());
             String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
             ps.setString(3,nam + "-" + thang + "-" + ngay);
             if(rdoNam.isSelected()){
             ps.setString(4,"Nam");
             }
             else{
             ps.setString(4,"Nữ");
             }
             ps.setString(5,txtDiaChi.getText()); 
             ps.setString(6,txtSDT.getText());

             int chk = ps.executeUpdate();
             if(chk>0){
             sb.append("Thêm thành công!");
             loadDataKH();
              reset();
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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
                try {
            StringBuilder sb = new StringBuilder();
             if(txtMaKH.getText().equals("")){
             sb.append("Hãy Chọn Khách Hàng Bạn Muốn Sửa !");
             }
             else{
             if(txtTenKH.getText().equals("")){
             sb.append("Hãy Nhập Tên Khách Hàng !");
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
            PreparedStatement pr = conn.prepareStatement("update KhachHang set TenKhachHang=?,MaLoaiKhachHang=(Select MaLoaiKhachHang from LoaiKhachHang where TenLoaiKhachHang=?),NgaySinh=?,GioiTinh=?,DiaChi=?,SDT=? where MaKhachHang = ?");
            pr.setString(1,txtTenKH.getText());
            pr.setString(2,cbLoaiKhachHang.getSelectedItem().toString());
            String ngay, thang, nam;
             ngay = cbbNgay.getSelectedItem().toString();
             thang = cbbThang.getSelectedItem().toString();
             nam = cbbNam.getSelectedItem().toString();
            pr.setString(3,nam + "-" + thang + "-" + ngay);
            if(rdoNam.isSelected()){
             pr.setString(4,"Nam");
             }
             else{
             pr.setString(4,"Nữ");
             }
            pr.setString(5,txtDiaChi.getText());
            pr.setString(6,txtSDT.getText());

            pr.setString(7, tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(),0).toString());
            pr.executeUpdate();
            loadDataKH();
            sb.append("Sửa Thành Công");
            reset();
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
        reset();
        rdoTheoMa.setSelected(true);
        txtTimKiem.setText("");
        try {
            loadDataKH();
        } catch (SQLException ex) {
            Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb= new StringBuilder();
        String MaKH = txtMaKH.getText();
        if (!MaKH.equals("")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                String cautruyvan = "delete KhachHang where MaKhachHang=" +MaKH;
                String ctvKiemThu = "select count(MaHoaDon) as SoPhieuMua"
                    + " from KhachHang,HoaDon where KhachHang.MaKhachHang=HoaDon.MaKhachHang"
                    + " and  KhachHang.MaKhachHang=" + MaKH;
                Statement st = conn.createStatement();
                ResultSet rs1 = st.executeQuery(ctvKiemThu);
                int so1 = 0;
                try {
                    
                    if (rs1.next()) {
                    so1 = rs1.getInt("SoPhieuMua");
                    if (rs1.getInt("SoPhieuMua") == 0) {
                        st.executeUpdate(cautruyvan);
                        sb.append("Xóa thành công !");
                        loadDataKH();
                        reset();;
                    } else {
                        sb.append("Không thể xóa bởi Khách Hàng đã có " + so1 + " hóa đơn!");
                    }
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sb.append("Hãy click vào Khách Hàng Bạn muốn xóa !");
        }
        if (sb.length() > 0) {
        JOptionPane.showMessageDialog(this, sb.toString());
        return;
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
                    PreparedStatement pa = conn.prepareStatement("select * from KhachHang join LoaiKhachHang on KhachHang.MaLoaiKhachHang=LoaiKhachHang.MaLoaiKhachHang where MaKhachHang=?");
                    pa.setString(1, txtTimKiem.getText().toString());
                    ResultSet ra = pa.executeQuery();
                    Object[] obj = new Object[]{ "Mã Khách Hàng ", "Tên Khách Hàng","Loại Khách Hàng","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại"};
                    DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                    tblKhachHang.setModel(tableModel);

                    try {
                    while (ra.next()) {

                        Object[] item = new Object[8];
                        item[0] = ra.getInt("MaKhachHang");
                        item[1] = ra.getString("TenKhachHang");
                        item[2] = ra.getString("TenLoaiKhachHang");
                        item[3] = ra.getDate("NgaySinh");
                        item[4] = ra.getString("GioiTinh");
                        item[5] = ra.getString("DiaChi");
                        item[6] = ra.getString("SDT");

                        tableModel.addRow(item);
                    }

                    } catch (SQLException ex) {
                            System.out.println(ex.toString());
                    }

           
                }
                    if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(this, sb.toString());
                    return;
                    }
            }
            else if(rdoTheoTen.isSelected()){
                  if (txtTimKiem.getText().equals("")) {
                    sb.append("Hãy nhập Tên bạn muốn tìm kiếm !");
                }
                else{
                 PreparedStatement pf = conn.prepareStatement("select * from KhachHang join LoaiKhachHang on KhachHang.MaLoaiKhachHang=LoaiKhachHang.MaLoaiKhachHang where TenKhachHang like ? or TenKhachHang = ? or TenKhachHang like ?");
                 pf.setString(1,('%'+ txtTimKiem.getText().toString()));
                 pf.setString(2,(txtTimKiem.getText().toString()));
                 pf.setString(3,(txtTimKiem.getText().toString()+'%'));
                 ResultSet rb = pf.executeQuery();
                    Object[] obj = new Object[]{ "Mã Khách Hàng ", "Tên Khách Hàng","Loại Khách Hàng","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại"};
                    DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                    tblKhachHang.setModel(tableModel);

                    try {
                    while (rb.next()) {

                        Object[] item = new Object[8];
                        item[0] = rb.getInt("MaKhachHang");
                        item[1] = rb.getString("TenKhachHang");
                        item[2] = rb.getString("TenLoaiKhachHang");
                        item[3] = rb.getDate("NgaySinh");
                        item[4] = rb.getString("GioiTinh");
                        item[5] = rb.getString("DiaChi");
                        item[6] = rb.getString("SDT");

                        tableModel.addRow(item);
                    }

                    } catch (SQLException ex) {
                            System.out.println(ex.toString());
                    }
           
                }
                 if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
                }
            }
            else{
             sb.append("Hãy chọn trường bạn muốn tìm kiếm");
             if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
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

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int viTriDongVuaBam = tblKhachHang.getSelectedRow();
        txtMaKH.setText(tblKhachHang.getValueAt(viTriDongVuaBam, 0).toString());
        txtTenKH.setText(tblKhachHang.getValueAt(viTriDongVuaBam, 1).toString());
        cbLoaiKhachHang.setSelectedItem(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(),2));
        String ngaysinh = tblKhachHang.getValueAt(viTriDongVuaBam, 3).toString();
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
        String GioiTinh = tblKhachHang.getValueAt(viTriDongVuaBam, 4).toString();
        if(GioiTinh.equals("Nam")){
            rdoNam.setSelected(true);
        }
        if(GioiTinh.equals("Nữ")){
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(tblKhachHang.getValueAt(viTriDongVuaBam, 5).toString());
        txtSDT.setText(tblKhachHang.getValueAt(viTriDongVuaBam, 6).toString());

    }//GEN-LAST:event_tblKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbLoaiKhachHang;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
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
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTheoMa;
    private javax.swing.JRadioButton rdoTheoTen;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
