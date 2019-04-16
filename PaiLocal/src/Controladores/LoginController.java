/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Connection.Conexion;
import Modelos.UsuarioLogin;
import Utilidades.Hash;
import Vistas.LoginView;
import Vistas.PrincipalView;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author raxielh
 */
public class LoginController extends Conexion{
    
    public void Entrar(UsuarioLogin usuario) throws NoSuchAlgorithmException{
        
        ResultSet r = null;
             
        if ( (usuario.getUsuario() == null) || (usuario.getUsuario().isEmpty()) )
        {
            JOptionPane.showMessageDialog(null, "Usuario Vacio");
        }
        else
        {
            if ( (usuario.getPass() == null) || (usuario.getPass().isEmpty()) )
            {
                JOptionPane.showMessageDialog(null, "Contraseña Vacio");
            }
            else
            {
                Conectar();

                try
                {
                    Hash hash = new Hash();
                    String pass = hash.sha1(usuario.getPass());
                    String sql = "SELECT COUNT(*) AS rowcount,Usuario "
                            + "FROM usuarios "
                            + "WHERE "
                            + "Usuario='"+usuario.getUsuario()+"' "
                            + "AND "
                            + "Pass='"+pass+"' "
                            + "LIMIT 1";
                    r = consulta.executeQuery(sql);
                    System.out.println(sql);
                    
                    if(r != null)
                    {
                        r.next();
                        int count = r.getInt("rowcount");
                        r.close();
                        
                        if(count == 0)
                        {
                            JOptionPane.showMessageDialog(null,"Datos Incorrectos");
                            LoginView login = new LoginView();
                            login.setVisible(true);
                        }
                        else{
                            PrincipalView principal = new PrincipalView();
                            principal.setVisible(true);
                        }
                           
                    }
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        
    } 
    
}
