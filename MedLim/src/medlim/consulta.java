/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medlim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author FabioPrado
 */
public class consulta extends atendimento{
    public String cpf_prof;
    
    public consulta(String cpf_pac, String cpf_prof, String data_agend, String horario_agend){
        super(cpf_pac, data_agend, horario_agend);
        this.cpf_prof = cpf_prof;
    }
    
    public consulta(String cpf_pac, String data_agend, String horario_agend){
        super(cpf_pac, data_agend, horario_agend);
        this.cpf_prof = cpf_prof;
    }
    
    public consulta(String cpf_pac){
        super(cpf_pac);
    }
    
    public void cadastrarAgendamento(String cpf_pac, String cpf_prof, String data, String horario) throws IOException{
        try (FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt", true)) {
            PrintWriter salvarDados = new PrintWriter(fw);
            
            salvarDados.append(cpf_pac);
            salvarDados.write(" ");
            salvarDados.append(cpf_prof);
            salvarDados.write(" ");
            salvarDados.append(data);
            salvarDados.write(" ");
            salvarDados.append(horario);
                     
            salvarDados.write("\r\n");
        }
        
        System.out.println("Agendado com sucesso!");
    
    }
    
    
     public ArrayList<String> consultarAgendamento(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String limite = " "; 
        String linha = ""; 
        ArrayList<String> dados = new ArrayList<> ();
        
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados.add(linha);  
                                                                                        
                 } 
                 else{    
                 }
            } 
          return dados;    
        
    }
    
    public void excluirAgendamento(String cpf_pac, String  data, String horario) throws FileNotFoundException, IOException{
        ArrayList<String> salvarDados;
        try (FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt")) {
            BufferedReader lerDados = new BufferedReader(fr);
            String linha ="";
            salvarDados = new ArrayList();
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf_pac)==false && linha.contains(data)==false && linha.contains(horario)==false){
                    salvarDados.add(linha);
                }
                                             
            }
            lerDados.close();
        }
            
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt" , true);
        fw2.close();     
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    
    
    }
    
    
}
