/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/**
 *
 * @author raxielh
 */
public class Conexion {
    
    public Connection conexion;
    public Statement consulta;
    public String ruta;
    
    public Conexion(){
        ruta = "database.db";
    }
    
    public void ConectarDB(){
        
        
	try {
            Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage());
        }	 
	
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            consulta = conexion.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    
}
