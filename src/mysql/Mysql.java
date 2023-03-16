/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mysql;

import java.sql.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author yo
 */
public class Mysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        
        Scanner s = new Scanner(System.in);
        Map<String, Cmd> cmds = new HashMap<String, Cmd>();
        cmds.put("ADD", new Add());
        cmds.put("PRINT", new Print());
        cmds.put("DEL", new Del());
        
        while(true) {
           String line = s.nextLine();
           String[] parts = line.split(" ");
           
           String cmdName = parts[0].toUpperCase();
           cmds.get(cmdName).exec(parts);           
        }
    }
}
