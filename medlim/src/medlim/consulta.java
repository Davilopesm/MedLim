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
import java.util.Arrays;

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
        /**criando arquivo */
        try (FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt", true)) {
            PrintWriter salvarDados = new PrintWriter(fw);
            
            /**salvando variáveis no arquivo e separando-as pelo caracter/ */
            salvarDados.append(cpf_pac);
            salvarDados.write("/");
            salvarDados.append(cpf_prof);
            salvarDados.write("/");
            salvarDados.append(data);
            salvarDados.write("/");
            salvarDados.append(horario);
                     
            salvarDados.write("\r\n");
        }
        
        System.out.println("Agendado com sucesso!");
    
    }
    
    
     public ArrayList<String> consultarAgendamento(String cpf) throws FileNotFoundException, IOException{
         /**abrindo arquivo para leitura do seu conteúdo */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String limite = "/"; 
        String linha = ""; 
        ArrayList<String> dados = new ArrayList<> ();
        
        /**função percorre arquivo procurando pelo cpf digitado */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados.add(linha);  
                                                                                        
                 } 
                 else{    
                 }
            } 
          return dados;    
        
    }
    
    public void excluirAgendamento(String cpf_pac, String cpf_prof, String  data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura do seu conteúdo */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha ="";
        ArrayList<String> salvarDados;
        salvarDados = new ArrayList();
        
        /**função procura por linha com o valor das variáveis digitadas, todas as linhas que não cumprirem a condição
        serão salvas no ArrayList 
        */
        while ((linha = lerDados.readLine()) != null){
            if(linha.contains(cpf_pac) && linha.contains(cpf_prof) && linha.contains(data) && linha.contains(horario)){
            } else {               
                salvarDados.add(linha);
            }
                                             
        }
        lerDados.close();
        fr.close();
       
        /**criando arquivo com a propriedade true para limpar seu conteúdo */        
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt" , true);
        fw2.close();     
        
        /**cirando arquivo novamente e salvando a ArrayList no seu conteúdo */
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    
    
    }
    
     public boolean consultarExistencia_pac(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo para consulta */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função percorre arquivo verificando seu o cpe digitado existe no seu corpo, se for encontrado a função
        retorna true 
        */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
     
     public boolean consultarExistenciaConsulta(String cpf, String data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função percorre arquivo para ver se as variaveis já existem no seu conteúdo */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf) && linha.contains(data) && linha.contains(horario)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
     
     public boolean consultarExistenciaConsulta2(String cpf, String data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função percorre arquivo para ver se as variaveis já existem no seu conteúdo */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf) && linha.contains(data) && linha.contains(horario)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
     
     public boolean consultarExistenciaConsulta3(String cpf_pac, String cpf_prof, String data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoConsulta.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função procura nas linhas do arquivo se todas as variáveis digitadas já existem no arquivo, retornando true
        se todas já existirem 
        */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf_pac) && linha.contains(cpf_prof) && linha.contains(data) && linha.contains(horario)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
     
     public boolean consultarExistencia_prof(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função percorre arquivo para ver se cpf já existe dentro do arquivo */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){                         
                    return true;
                 }                 
            }     
        return false;
    }
    
    
}
