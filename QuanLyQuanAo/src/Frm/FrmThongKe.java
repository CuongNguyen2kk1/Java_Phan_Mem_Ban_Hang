/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hai Nguyen
 */
public class FrmThongKe extends javax.swing.JPanel {

    /**
     * Creates new form FrmThongKe
     */
    DefaultTableModel tbn = new DefaultTableModel();

    public FrmThongKe() throws SQLException {
        initComponents();
        loadDataThongKe();
        Tong();
    }

    private void loadDataThongKe() throws SQLException {
        Connect a = new Connect();
        Connection conn = a.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from HoaDon");
        Object[] obj = new Object[]{"Mã Hóa Đơn", "Ngày Đặt", "Thành Tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblThongKe.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[3];
                item[0] = rs.getInt("MaHoaDon");
                item[1] = rs.getString("NgayLapHoaDon");
                item[2] = rs.getInt("TongTien");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    private void Tong() throws SQLException {
        DecimalFormat x = new DecimalFormat("###,###,###");
        Connect a = new Connect();
        Connection conn = a.getConnection();
        loadDataThongKe();
        int Tong = 0;
        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            Tong += Integer.parseInt(tblThongKe.getValueAt(i, 2).toString());
        }
        jLabelTong.setText("Tổng doanh thu: " + x.format(Tong));
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
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        rdbThang = new javax.swing.JRadioButton();
        rdbMHD = new javax.swing.JRadioButton();
        jLabelTong = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnReset = new javax.swing.JButton();
        btnXuatExel = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống kê doanh thu");

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Preview_16x16.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblThongKe.setBackground(new java.awt.Color(255, 204, 204));
        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày đặt", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblThongKe);
        if (tblThongKe.getColumnModel().getColumnCount() > 0) {
            tblThongKe.getColumnModel().getColumn(0).setMinWidth(100);
            tblThongKe.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblThongKe.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        buttonGroup1.add(rdbThang);
        rdbThang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdbThang.setForeground(new java.awt.Color(0, 102, 102));
        rdbThang.setText("Theo tháng");

        buttonGroup1.add(rdbMHD);
        rdbMHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdbMHD.setForeground(new java.awt.Color(0, 102, 102));
        rdbMHD.setText("Theo MHD");

        jLabelTong.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelTong.setForeground(new java.awt.Color(0, 102, 102));
        jLabelTong.setText("Tổng doanh thu:");

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 102, 102));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_16x16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXuatExel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXuatExel.setForeground(new java.awt.Color(0, 102, 102));
        btnXuatExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Print_16x16.png"))); // NOI18N
        btnXuatExel.setText("Xuất Exel");
        btnXuatExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXuatExel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbThang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(rdbMHD))
                                    .addComponent(txtTimKiem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbMHD)
                    .addComponent(rdbThang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTong, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXuatExel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            if (rdbMHD.isSelected()) {
                if (txtTimKiem.getText().equals("")) {
                    sb.append("Hãy nhập Mã bạn muốn tìm kiếm !");
                } else {
                    PreparedStatement pa = conn.prepareStatement("select * from HoaDon where MaHoaDon=?");
                    pa.setString(1, txtTimKiem.getText().toString());
                    ResultSet rs = pa.executeQuery();
                    Object[] obj = new Object[]{"Mã Hóa Đơn", "Ngày Đặt", "Thành Tiền"};
                    DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                    tblThongKe.setModel(tableModel);

                    try {
                        while (rs.next()) {

                            Object[] item = new Object[3];
                            item[0] = rs.getInt("MaHoaDon");
                            item[1] = rs.getString("NgayLapHoaDon");
                            item[2] = rs.getInt("TongTien");
                            tableModel.addRow(item);
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.toString());
                    }
                    int Tong = 0;
                    for (int i = 0; i < tblThongKe.getRowCount(); i++) {
                        Tong += Integer.parseInt(tblThongKe.getValueAt(i, 2).toString());
                    }
                    jLabelTong.setText("Tổng doanh thu: " + Tong);

                }
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(this, sb.toString());
                    return;
                }
            } else if (rdbThang.isSelected()) {
                if (txtTimKiem.getText().equals("")) {
                    sb.append("Hãy nhập tháng muốn tìm kiếm !");
                } else {
                    PreparedStatement pf = conn.prepareStatement("select * from HoaDon where month(NgayLapHoaDon)=?");
                    pf.setString(1, (txtTimKiem.getText().toString()));
                    ResultSet rb = pf.executeQuery();
                    Object[] obj = new Object[]{"Mã Hóa Đơn", "Ngày Đặt", "Thành Tiền"};
                    DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
                    tblThongKe.setModel(tableModel);

                    try {
                        while (rb.next()) {

                            Object[] item = new Object[3];
                            item[0] = rb.getInt("MaHoaDon");
                            item[1] = rb.getString("NgayLapHoaDon");
                            item[2] = rb.getInt("TongTien");
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
            } else {
                sb.append("Hãy chọn trường bạn muốn tìm kiếm");
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(this, sb.toString());
                    return;
                }
            }
        } catch (SQLException e) {
        }
        int Tong = 0;
        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            Tong += Integer.parseInt(tblThongKe.getValueAt(i, 2).toString());
        }
        jLabelTong.setText("Tổng doanh thu: " + Tong);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTimKiem.setText("");
        try {
            loadDataThongKe();
        } catch (SQLException ex) {
            Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        int Tong = 0;
        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            Tong += Integer.parseInt(tblThongKe.getValueAt(i, 2).toString());
        }
        jLabelTong.setText("Tổng doanh thu: " + Tong);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXuatExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExelActionPerformed
//        FileOutputStream exfos = null;
//        BufferedOutputStream exbou = null;
//        XSSFWorkbook excelTableExport = null;
// 
//        JFileChooser excelFileChooser = new JFileChooser("E:\\UTT\\2021-2022\\Java nâng cao\\Xuất Exel");
//        excelFileChooser.setDialogTitle("Save as");
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
//        int excelChooser = excelFileChooser.showSaveDialog(null);
// 
//        if (excelChooser == JFileChooser.APPROVE_OPTION) {
// 
//            try {
//                excelTableExport = new XSSFWorkbook();
//                XSSFSheet excelSheet = excelTableExport.createSheet("Thống Kê");
//                for (int i = 0; i < tblThongKe.getRowCount(); i++) {
//                    XSSFRow excelRow = excelSheet.createRow(i);
//                    for (int j = 0; j < tblThongKe.getColumnCount(); j++) {
//                        XSSFCell excelCell = excelRow.createCell(j);
//                        excelCell.setCellValue(tblThongKe.getValueAt(i, j).toString());
//                    }
//                }
//                exfos = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
//                exbou = new BufferedOutputStream(exfos);
//                excelTableExport.write(exbou);
//                JOptionPane.showMessageDialog(this, "Lưu File thành công");
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
//            } finally {
//                try {
//                    if (exfos != null) {
//                        exfos.close();
//                    }
//                    if (exbou != null) {
//                        exbou.close();
//                    }
// 
//                } catch (IOException ex) {
//                    Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(this);
            File saveFile = fileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("thongke");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblThongKe.getColumnCount(); i++) {
                    //Cell stt = rowCol.createCell(0);
                    //stt.setCellValue("STT");
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblThongKe.getColumnName(i));
                }

                int stt = 1;
                for (int j = 0; j < tblThongKe.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 1; k < tblThongKe.getColumnCount(); k++) {
                        Cell column0 = row.createCell(0);

                        Cell cell = row.createCell(k);
                        if (tblThongKe.getValueAt(j, k) != null) {
                            cell.setCellValue(tblThongKe.getValueAt(j, k).toString());
                            column0.setCellValue(stt);
                        }

                    }
                    stt++;
                }

                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                out.close();
                JOptionPane.showMessageDialog(this, "Lưu File thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXuatExelActionPerformed

    public static void main(String[] args) throws SQLException {
        new FrmThongKe().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXuatExel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdbMHD;
    private javax.swing.JRadioButton rdbThang;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
