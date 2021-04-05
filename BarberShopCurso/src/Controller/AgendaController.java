
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;


public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
    private ArrayList<Agendamento> Agendamentos;
    private ArrayList<Cliente> clientes;

    public AgendaController(Agenda view) {
        this.view = view;
         this.helper = new AgendaHelper(view);
        
    }
    
    public void atualizaTabela(){
        
        //busca lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //exibir esta lista na view
        helper.preencherTabela(agendamentos);
    
      }
   
    public void atualizaCliente(){
        
        //Buscar Clientes do banco de dados 
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        //exibir clientes no combobox clientes 
      
        helper.preencherClientes(clientes);
        
    }
    
    public void atualizaServico(){
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
        
       Servico servico =  helper.obterServico();
       helper.setarValor(servico.getValor());
        
    }
    
    public void agendar(){
        //buscar objeto agendamento da tela 
        Agendamento agendamento = (Agendamento) helper.obterModelo();
        
        //salva objeto do banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        //inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
        
    }
    
    
}
