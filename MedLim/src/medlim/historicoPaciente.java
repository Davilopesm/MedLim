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
public class historicoPaciente {
    public String cpf_pac;
    public String historico;

    public historicoPaciente(String cpf_pac, String historico) {
        this.cpf_pac = cpf_pac;
        this.historico = historico;
    }
    
    public historicoPaciente(String cpf_pac) {
        this.cpf_pac = cpf_pac;        
    }
    
    public void cadastrar_historico(String cpf, String historico) throws IOException{
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt", true);
        try (PrintWriter salvarDados = new PrintWriter(fw)) {
            salvarDados.append(cpf);
            salvarDados.write(" ");
            salvarDados.append(historico);
            salvarDados.write("\r\n");
        }
               
    }
    
    public String consultar_historico(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
                
        String linha = ""; 
        String dados = "";
        
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados = linha;  
                                                                     
                 } 
                 else{    
                 }
            } 
          return dados;
    }
    public void remover_historico(String cpf) throws FileNotFoundException, IOException{
        ArrayList<String> salvarDados;
        try (FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt"); BufferedReader lerDados = new BufferedReader(fr)) {
            String linha ="";
            salvarDados = new ArrayList();
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf)==false){
                    salvarDados.add(linha);
                }
                                             
            }
        }
            
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt" , true);
        fw2.close();     
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    }
}
