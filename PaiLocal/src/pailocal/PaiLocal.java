/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pailocal;

import Utilidades.Hash;
import Vistas.LoginView;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author raxielh
 */
public class PaiLocal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
            e.printStackTrace();
	}
        
              
        LoginView login = new LoginView();
        //main.setExtendedState(MAXIMIZED_BOTH);
        login.setVisible(true);
    }
    
}
