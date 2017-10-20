package control;

import java.sql.ResultSet;
import model.*;

/**
 *
 * @author ScrumTeam
 */
public class Control {
    
    public static boolean fazerLogin(String login, String senha){ // chamar a função do DAO para verificar o login e senha
        LoginDAO.getInstance();                
        return LoginDAO.checarLogin(login, senha) == true;        //retorno true se login e senha estiverem certos
    }
    
    public static boolean inserirPaciente(String nome, long CPF, long RG, String endereco, String telefone){ //chamar a função do DAO para inserir paciente
        PacienteDAO.getInstance();                
        return PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone) == true; //retorno true se conseguiu inserir paciente na table
    }
    
    public static ResultSet buscarPaciente(){//chamar a função de buscar todos os pacientes no DAO, retorno ResultSet que vai para a jTable
        PacienteDAO.getInstance();  
        ResultSet rs = PacienteDAO.buscarPaciente();
        return rs;
    }
    
    public static ResultSet buscarUmPaciente(long CPF){//chamar a função de buscar um paciente no DAO, retorno ResultSet que vai para a jTable
        PacienteDAO.getInstance();  
        ResultSet rs = PacienteDAO.buscarUmPaciente(CPF);
        return rs;
    }
       
        
    
}
