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
public class HistoricoPaciente {
    public String cpf_pac;
    public String historico;

    public HistoricoPaciente(String cpf_pac, String historico) {
        this.cpf_pac = cpf_pac;
        this.historico = historico;
    }
    
    public HistoricoPaciente(String cpf_pac) {
        this.cpf_pac = cpf_pac;        
    }
    
    public void cadastrar_historico(String cpf, String historico) throws IOException{
        /**criando arquivo onde será salvo o cadastro */
        FileWriter fw = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt", true);
        try (PrintWriter salvarDados = new PrintWriter(fw)) {
           
            /**gravando dados recebidos do pacote view no arquivo selecionado anteriormente */
            salvarDados.append(cpf);
            salvarDados.write(" ");
            salvarDados.append(historico);
            salvarDados.write("\r\n");
        }
               
    }
    
    public String consultar_historico(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo para consulta do seu conteúdo */
        FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
                
        String linha = ""; 
        String dados = "";
        
        /**lendo arquivo atrás do cpf pesquisado pelo usuário */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados = linha;  
                                                                     
                 } 
                 else{    
                 }
            } 
            /** retornando variavel para classe view com o valor da variavel dados*/
          return dados;
    }
    
     public boolean consultarExistencia_pac2(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo novamente para consulta */
        FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**lendo arquivo procurando o cpf para saber se o cadastro já existe no sistema, se existir a função retorna true */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){
                    
                    return true;
                 }                 
            }     
        return false;
    } 
    
     public boolean consultarExistencia_pac(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo novamente para consulta */
        FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**lendo arquivo procurando o cpf para saber se o cadastro já existe no sistema, se existir a função retorna true */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){
                    
                    return true;
                 }                 
            }     
        return false;
    }
    
    public void remover_historico(String cpf) throws FileNotFoundException, IOException{
        ArrayList<String> salvarDados;
        /**abrindo arquivo selecionado para leitura */
        try (FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
            BufferedReader lerDados = new BufferedReader(fr)) {
            String linha ="";
            salvarDados = new ArrayList();
            
            /**todas as linhas que não tiverem o cpf pesquisado serão salvos na ArrayList */
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf)==false){
                    salvarDados.add(linha);
                }
                                             
            }
        }
        
        /**criando arquivo com a propriedade true para limpar seu conteúdo */
        FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt" , true);
        fw2.close();     
        
        /**criando o arquivo novamente e passando a ArrayList com os dados para o arquivo */
        FileWriter fw = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\pacienteHistorico.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    }
}
