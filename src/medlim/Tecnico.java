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
public class Tecnico extends Profissional{
    public String funçao;

    public Tecnico(String funçao, String nome_prof, String rg_prof, String cpf_prof, String endereço_prof, String tel_prof, String cargo) {
        super(nome_prof, rg_prof, cpf_prof, endereço_prof, tel_prof, cargo);
        this.funçao = funçao;
    }
    
    public Tecnico(String cpf_prof){
        super(cpf_prof);
    }
      
    
      public void cadastrar_prof(String nome, String cpf, String rg, String endereço, String telefone, String cargo, String funçao) throws IOException{
            /**arquivo é criado e pronto para receber dados */
            FileWriter fw = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt", true);
            PrintWriter salvarDados = new PrintWriter(fw);
           
            /**função salva os dados recebidos no arquivo e os separa através do caracter / */
            salvarDados.append(nome);
            salvarDados.write("/");
            salvarDados.append(cpf);
            salvarDados.write("/");
            salvarDados.append(rg);
            salvarDados.write("/");
            salvarDados.append(endereço);
            salvarDados.write("/");
            salvarDados.append(telefone);
            salvarDados.write("/");
            salvarDados.append(cargo);
            salvarDados.write("/");
            salvarDados.append(funçao);
            salvarDados.write("\r\n");
            
            salvarDados.close();
            
            System.out.println("Dados cadastrados com sucesso!");
        }
             
    
    public String[] consultar_prof(String cpf) throws FileNotFoundException, IOException{
        /**arquivo é aberto para leitura */
        FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String limite = "/"; 
        String linha = ""; 
        String []dados = null;
        
        /**se a condição do if for cumprida a linha requisitada será salva no vetor dados */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados = linha.split(limite);  
                    
                    String nome = dados[0]; 
                    String CPF = dados[1];
                    String rg = dados[2];
                    String endereço = dados[3];
                    String telefone = dados[4];
                    String cargo = dados[5];
                    String funçao = dados[6];                 
                                                                              
                 } 
                 else{    
                 }
            } 
          return dados;
    }
    
    public boolean consultarExistencia_prof(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**se a variavel cpf digitada for encontrada no aqruivo aberto, será retornado true */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){                         
                    return true;
                 }                 
            }     
        return false;
    }
    
    public void remover_prof(String cpf) throws FileNotFoundException, IOException{        
        ArrayList<String> salvarDados;
        
        /**arquivo é aberto para consulta novamente */
        try (FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt");
            BufferedReader lerDados = new BufferedReader(fr)) {
            String linha ="";
            salvarDados = new ArrayList();
            
            /**todas as linhas do arquivo que não tiverem o cpf digitado serão salvas na ArrayList criada */
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf)==false){
                    salvarDados.add(linha);
                }
                                             
            }
        }
        
        /**arquivo é criado com a propriedade true para que ele tenha seu conteudo apagado */
        FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt" , true);
        fw2.close();     
        
        /**arquivo é criado novamente e receberá o ArrayList com o conteúdo necessário */
        FileWriter fw = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalTecnico.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    }
    
}
