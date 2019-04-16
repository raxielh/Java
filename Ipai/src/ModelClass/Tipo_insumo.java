/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import Connection.Consult;
import Models.Tipo_insumos;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raxielh
 */
public class Tipo_insumo extends Consult{
    
    //private Consult consult = new Consult();
    private DefaultTableModel modelo;
    private List<Tipo_insumos> tipo_insumo,tipo_insumoFilter;
    private int id;
    private String sql;
    private Object[] obect;
    
    public void insertTipo_insumo(String nombre){
        
        sql="INSERT INTO tipo_insumo(nombre)"+
            "VALUES(?)";
        
        obect = new Object[]{nombre};
        
        insert(sql,obect);
        
        tipo_insumo = tipo_insumo();
                
    }
 
    public List<Tipo_insumos> getTipo_insumos(){
        
        return tipo_insumo();
                
    }
    
    
}
