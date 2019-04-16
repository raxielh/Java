/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Connection.Conexion;
import Modelos.Usuarios;
import Utilidades.Hash;
import Vistas.UsuariosView;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raxielh
 */
public class UsuariosController extends Conexion{
    
    public void Insertar(Usuarios usuario) throws NoSuchAlgorithmException, SQLException{
        Conectar();
        
        Hash hash = new Hash();
        
        try {
            String pass = Hash.sha1(usuario.getPass());
            String sql="INSERT INTO Usuarios VALUES("+usuario.getId()
                    +",'"+usuario.getNombre()
                    +"','"+usuario.getUsuario()
                    +"','"+pass+"')";
            consulta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Usuario creado");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        
        
        conexion.close();

    }

    public void Actualizar(Usuarios usuario) throws SQLException{
        Conectar();     
        
        try {
            String sql= "UPDATE Usuarios "
                    + "SET Nombre = '"+usuario.getNombre()+"',"
                    + "Usuario = '"+usuario.getUsuario()+"' "
                    + "WHERE Id = "+usuario.getId()+"";
            
            System.out.println(sql);
            consulta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Usuario actualizado");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        
        conexion.close();

    }
    
    public void CargarDatos(DefaultTableModel tbl_datos) throws SQLException{
        ResultSet resultado = null;
        tbl_datos.setRowCount(0);
        tbl_datos.setColumnCount(0);
        String sql = "SELECT * from Usuarios";
        
        try {
            resultado = consultar(sql);
            if(resultado != null){
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for(int j = 1;j <= numeroColumna;j++){
                    tbl_datos.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while(resultado.next()){
                    Object []objetos = new Object[numeroColumna];
                    for(int i = 1;i <= numeroColumna;i++){
                        objetos[i-1] = resultado.getObject(i);
                    }
                    tbl_datos.addRow(objetos);
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
        
        conexion.close();
        
    }

    public ResultSet CargarDatosEditar(String codigo) throws SQLException{
        ResultSet resultado = null;
        String sql = "SELECT * from Usuarios WHERE id="+codigo+" ";
        resultado = consultar(sql);  
        return resultado;          
    }
    
    public ResultSet consultar(String sql) throws SQLException{
        Conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        conexion.close();
        return resultado;
    }
    
    
    
    
    
    
}
