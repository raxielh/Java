/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipai;

import Connection.Conexion;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;
import View.Login;

/**
 *
 * @author raxielh
 */
public class Ipai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
	  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
	e.printStackTrace();
	}
        //maximizar la ventana
        Login main = new Login();
        //main.setExtendedState(MAXIMIZED_BOTH);
        main.setVisible(true);
        new Conexion();
    }
    
}
