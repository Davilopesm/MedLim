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
        /**criando arquivo para salvar dados */
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt", true);
        PrintWriter salvarDados = new PrintWriter(fw);
              
        /**salvando dados e separando as variavéis recebidas através do caracter / */
        salvarDados.append(cpf);
        salvarDados.write("/");
        salvarDados.append(data);
        salvarDados.write("/");
        salvarDados.append(horario);  
        salvarDados.write("\r\n");
        
        fw.close();
        
        System.out.println("Agendado com sucesso!");
        
}
    
    public ArrayList<String> consultarAgendamento(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo selecionado para ler seu conteúdo */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String limite = "/"; 
        String linha = ""; 
        /**criando ArrayList que receberá os dados requisitados */
        ArrayList<String> dados = new ArrayList<> ();
        
        /**lendo linha a linha do arquivo procurando cpf requisitado, caso for encontrado a linha então será adicinada 
        a variável dados 
        */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados.add(linha);  
                                                                                        
                 } 
                 else{    
                 }
            } 
        /**retornando variavel dados para o pacote view */
          return dados;    
        
    }
    
    public boolean consultarExistencia_pac(String cpf) throws FileNotFoundException, IOException{
        /**abrindo arquivo para consultar existência do cpf solicitado */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função procura nas linhas do arquivo pelo cpf digitado, retornando true caso encontre o mesmo */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
    
    public boolean consultarExistenciaExame(String cpf, String data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
        /**função procura nas linhas do arquivo se todas as variáveis digitadas já existem no arquivo, retornando true
        se todas já existirem 
        */
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf) && linha.contains(data) && linha.contains(horario)){
                       
                    return true;
                 }                 
            }     
        return false;
    }

    
    
    public void excluirAgendamento(String cpf, String data, String horario) throws FileNotFoundException, IOException{
        /**abrindo arquivo para leitura */
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt");
        BufferedReader lerDados = new BufferedReader(fr);
               
        String linha ="";
        ArrayList<String> salvarDados = new ArrayList();
        
        /**função procura no arquivo uma linha que tenha todas as variáveis digitadas, se encontrar esta linha será perdida
        e as outras que não cumpriram a condição serão adicionadas no ArrayList 
        */
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf) && linha.contains(data) && linha.contains(horario)){                  
                }
                else{
                  salvarDados.add(linha);
                }                                             
            }
            
           lerDados.close();
           fr.close();
        
        /**criando arquivo com a propriedade true para limpar seu conteúdo */
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\agendamentoExame.txt" , true);
        fw2.close();     
        
        /**criando arquivo e salvando a ArrayList no seu conteúdo */
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

