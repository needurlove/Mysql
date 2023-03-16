/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.io.IOException;
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
public class Add implements Cmd { 

    @Override
    public void exec(String[] parts) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO posts(id,name,text) VALUES(?,?,?)")) {
            ps.setInt(1, Integer.parseInt(parts[1]));
            ps.setString(2, parts[2]);
            ps.setString(3, parts[3]);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
