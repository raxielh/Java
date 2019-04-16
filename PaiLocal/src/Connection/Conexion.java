/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * Write a description of class Conexion here.
 * 
 * @author Rey Salcedo 
 * @version (a version number or a date)
 */
public class Conexion{
    
	public Connection conexion;
	public Statement consulta;
	public String ruta;

    /**
     * Constructor for objects of class Conexion
     */
    public Conexion()
    {
        ruta = "DataBase.db";
    }
    
    public void Conectar(){
        
	try {
            Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage());
        }	 
	
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            consulta = conexion.createStatement();
            
            String sql_tabla_Usuarios = "CREATE TABLE IF NOT EXISTS Usuarios (\n"
                + "	Id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + "	Nombre TEXT,\n"
                + "	Usuario	TEXT UNIQUE,\n"
                + "	Pass	TEXT \n"
                + ");";
            String sql_insert_Usuarios = "INSERT INTO Usuarios VALUES(1,'Rodrigo Garcia','raxielh','40bd001563085fc35165329ea1ff5c5ecbdbbeef');";
                                
            consulta.execute(sql_tabla_Usuarios);
            //consulta.execute(sql_insert_Usuarios);
                  
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
}
