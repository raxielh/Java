/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author raxielh
 */
public class UsuarioLogin {
    private String Usuario;
    private String Pass;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String Usuario, String Pass) {
        this.Usuario = Usuario;
        this.Pass = Pass;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
}
