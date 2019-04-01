/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raxielh
 */
public class Conexion {

    private String db = "ipai";
    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/"+db;
    private Connection conn = null;

    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            
            if(conn !=null)
            {
                System.out.print("Conectado a la BD "+db);
            }
            
        } catch (Exception ex) {
            System.out.print("Error "+ex);
        }
        
    }

    public Connection getConn() {
        return conn;
    }
    
    
    
}
