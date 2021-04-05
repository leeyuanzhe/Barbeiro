
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;


public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    public void entrarNoSistema(){
        
         //pegar um usuario da view
         Usuario usuario = helper.obterModelo();
         
        //pesquisa usuario no banco 
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
         //se o usuario d aview tiver o mesmo e a senha que o usuario vindo do banco direcionar para o menu principal 
        //senao vou mostrar uma mensagem ao usuario "Usuario ou senha invalidos"
        if(usuarioAutenticado != null ){
            MenuPrincipal menu =  new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMensagem("Usuario ou senha invalidos");
        }
                
            
    }
    
    public void fizTarefa(){    
        System.out.println("Busquei algo do banco de dados");
    
        this.view.exibeMensagem("Executei o fiz tarefa");
    
    
    
    }
}
