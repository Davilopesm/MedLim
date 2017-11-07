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
public class medico extends profissional{
    public String area;
    public String crm;

    public medico(String area, String crm, String nome_prof, String rg_prof, String cpf_prof, String endereço_prof, String tel_prof, String cargo) {
        super(nome_prof, rg_prof,cpf_prof, endereço_prof, tel_prof, cargo);
        this.area = area;
        this.crm = crm;
    }

    public medico(String cpf_prof){
        super(cpf_prof);
    }

    
    public void cadastrar_prof(String nome, String cpf, String rg, String endereço, String telefone, String cargo, String area, String crm ) throws IOException{
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt", true);
        PrintWriter salvarDados = new PrintWriter(fw);
        
        salvarDados.append(nome);
        salvarDados.write(" ");
        salvarDados.append(cpf);
        salvarDados.write(" ");
        salvarDados.append(rg);
        salvarDados.write(" ");     
        salvarDados.append(endereço);
        salvarDados.write(" ");
        salvarDados.append(telefone);
        salvarDados.write(" ");
        salvarDados.append(cargo);
        salvarDados.write(" ");
        salvarDados.append(area);
        salvarDados.write(" ");
        salvarDados.append(crm);
        salvarDados.write(" ");
        salvarDados.write("\r\n");
                   
        salvarDados.close();
        
        System.out.println("Dados cadastrados com sucesso!");
    }
    
    
    public String[] consultar_prof(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String limite = " "; 
        String linha = ""; 
        String []dados = null;
        
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){

                    dados = linha.split(limite);  
                    
                    String nome = dados[0]; 
                    String CPF = dados[1];
                    String rg = dados[2];
                    String endereço = dados[3];
                    String telefone = dados[4];
                    String cargo = dados[5];
                    String area = dados[6];
                    String crm = dados[7];
                                                                              
                 } 
                 else{    
                 }
            } 
          return dados;
    }
    
    public boolean consultarExistencia_prof(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){                         
                    return true;
                 }                 
            }     
        return false;
    }
    
    public void remover_prof(String cpf) throws FileNotFoundException, IOException{
        ArrayList<String> salvarDados;
        try (FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt");
            BufferedReader lerDados = new BufferedReader(fr)) {
            String linha ="";
            salvarDados = new ArrayList();
            while ((linha = lerDados.readLine()) != null){
                if(linha.contains(cpf)==false){
                    salvarDados.add(linha);
                }
                                             
            }
        }
            
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt" , true);
        fw2.close();     
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\profissionalMedico.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
    }
    
}
