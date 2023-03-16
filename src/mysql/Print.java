/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author yo
 */
public class Print implements Cmd {

    @Override
    public void exec(String[] parts) {
        if(parts.length == 1){
            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
                PreparedStatement ps = conn.prepareStatement("select * from posts;")) {
            ps.execute();
            while(ps.getResultSet().next()){
                System.out.print(ps.getResultSet().getInt(1) + " ");
                System.out.print(ps.getResultSet().getString(2) + " ");
                System.out.println(ps.getResultSet().getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
                PreparedStatement ps = conn.prepareStatement("select * from posts where id = ?;")) {
            ps.setInt(1, Integer.parseInt(parts[1]));
            ps.execute();
            while(ps.getResultSet().next()){
                System.out.print(ps.getResultSet().getInt(1) + " ");
                System.out.print(ps.getResultSet().getString(2) + " ");
                System.out.println(ps.getResultSet().getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    }
}
