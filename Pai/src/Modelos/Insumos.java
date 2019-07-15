/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Connection.Conexion;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author raxielh
 */
public class Insumos {
    private int Id;
    private String Nombre;
    
    Conexion conn = new Conexion();

    public Insumos() {
    }

    public Insumos(int Id, String Nombre) {
        this.Id = Id;
        this.Nombre = Nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void llenar_combo(JComboBox<Insumos> CB_TipoInsumos) {  
        ResultSet rs = null;
        try {
            String Sql="select * from Insumos";
            conn.ConectarDB();
            rs = conn.consulta.executeQuery(Sql);
            System.out.println(Sql);
            CB_TipoInsumos.addItem(new Insumos(
                                -1,
                                "Elija"
                            )
            );
            while(rs.next()){                            
                CB_TipoInsumos.addItem(new Insumos(
                                    rs.getInt("Id"),
                                    rs.getString("Nombre")
                                )
                );
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @Override
    public String toString(){
        return Nombre;
    }
}
