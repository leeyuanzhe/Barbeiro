/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;
import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

/**
 *
 * @author operador
 */
public class Main {
    
    public static void main(String[] args) {
        
        String nome = "tiago";
        System.out.println(nome);
        
        Servico servico =  new Servico(1, "barba", 30);
        
        
        System.out.println(servico.getValor());
        System.out.println(servico.getDescricao());
        
       Cliente cliente = new Cliente(1, "teste", "rua teste", "90137510");
        System.out.println(cliente.getNome());
       
        Usuario usuario = new Usuario(1, "barbeiro", "senha");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "01/04/2020 15:25");
        System.out.println(agendamento.getCliente().getNome());
    }
    
    
}
