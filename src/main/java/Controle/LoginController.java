package Controle;

import Modelo.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "login")
@ApplicationScoped

public class LoginController {

    Usuario usuario;
    ArrayList<Usuario> usuarios;

    public LoginController() {
        usuario = new Usuario();
        usuarios = new ArrayList<Usuario>();
        
    }

    public void salvar() {
        usuarios.add(usuario);
        System.out.println("O usuário " + usuario.getUser() + " foi adicionado");
        usuario = new Usuario();
    }

    public void mostrarUsuariosConsole() {
        for (Usuario i : usuarios) {
            System.out.println("Nome = " + i.getUser() + " Senha = " + i.getSenha());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
