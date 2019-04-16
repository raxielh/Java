/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Models.Tipo_insumos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author raxielh
 */
public class Consult extends Conexion {
    
    private QueryRunner QR = new QueryRunner();
    private List<Tipo_insumos> tipo_insumo;
    
    public List<Tipo_insumos> tipo_insumo(){
        
        try{
            
            tipo_insumo=(List<Tipo_insumos>) QR.query(getConn(),
                                                        "SELECT * FROM tipo_insumo",
                                                        new BeanListHandler(Tipo_insumos.class)
                                                    );
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error: "+ex);
            
        } 
        
        return tipo_insumo;
        
    }
    
    public void insert(String sql,Object[] data){
        
        try{
            
            final QueryRunner QR = new QueryRunner(true);
            QR.insert(getConn(),sql,new ColumnListHandler(),data);
            //JOptionPane.showMessageDialog(null,"Dato Ingresado");
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error: "+ex);
            
        } 
        
    }
    
}
