/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author acer
 */
public class Connect {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyShopQuanAo","HaiNguyen","161001");
            
            if(conn != null){
            System.out.println("Kết nối CSDL SQL Server thành công!");
            
            }
        }catch (Exception ex) {
                System.out.println(ex.toString());
                } 
        return conn;
    }
    
}
