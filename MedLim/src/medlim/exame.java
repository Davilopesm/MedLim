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
public class exame extends atendimento{
    public String parecer_exame;
    public int id_exame;
    
    public exame(String cpf_pac, String nome_prof, String data_agend, String horario_agend, String parecer_exame, int id_exame){
        super(cpf_pac, data_agend, horario_agend);
        this.parecer_exame = parecer_exame;
        this.id_exame = id_exame;
    }

        public exame(String cpf_pac, String data_agend, String horario_agend) {
        super(cpf_pac, data_agend, horario_agend);
    }
    

    public exame(String cpf_pac){
        super(cpf_pac);
    }
    
    
    public void cadastrarAgendamento(String cpf, String data, String horario) throws IOException{
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt", true);
        PrintWriter salvarDados = new PrintWriter(fw);
               
        salvarDados.append(cpf);
        salvarDados.write(" ");
        salvarDados.append(data);
        salvarDados.write(" ");
        salvarDados.append(horario);  
        salvarDados.write("\r\n");
        
        fw.close();
        
        System.out.println("Agendado com sucesso!");
        
}
    
    public ArrayList<String> consultarAgendamento(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
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
    
    public void excluirAgendamento(String cpf, String data, String horario) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
        BufferedReader lerDados = new BufferedReader(fr);
               
        String linha ="";
        ArrayList<String> salvarDados = new ArrayList();
        
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf)==false){
                    salvarDados.add(linha);
                }
                                             
            }
            
           lerDados.close();
           fr.close();
            
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt" , true);
        fw2.close();     
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
        
    }
    
}

