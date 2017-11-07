package medlim;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author FabioPrado
 */
public class paciente {
    public String nome_pac;
    public String cpf_pac;
    public String rg_pac;
    public String endereço_pac;
    public String tel_pac;
    public String dados;

    public paciente(String nome_pac, String cpf_pac, String rg_pac, String endereço_pac, String tel_pac) {
        this.nome_pac = nome_pac;
        this.cpf_pac = cpf_pac;
        this.rg_pac = rg_pac;
        this.endereço_pac = endereço_pac;
        this.tel_pac = tel_pac;
    }
    
     public paciente(String cpf_pac) {     
        this.cpf_pac = cpf_pac;      
    }
    

    public String getNome_pac() {
        return nome_pac;
    }

    public void setNome_pac(String nome_pac) {
        this.nome_pac = nome_pac;
    }

    public String getCpf_pac() {
        return cpf_pac;
    }

    public void setCpf_pac(String cpf_pac) {
        this.cpf_pac = cpf_pac;
    }

    public String getRg_pac() {
        return rg_pac;
    }

    public void setRg_pac(String rg_pac) {
        this.rg_pac = rg_pac;
    }

    public String getEndereço_pac() {
        return endereço_pac;
    }

    public void setEndereço_pac(String endereço_pac) {
        this.endereço_pac = endereço_pac;
    }

    public String getTel_pac() {
        return tel_pac;
    }

    public void setTel_pac(String tel_pac) {
        this.tel_pac = tel_pac;
    }
    
    
    public void cadastrar_pac(String nome, String cpf, String rg, String endereço, String telefone) throws IOException{
       
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt", true);
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
        salvarDados.write("\r\n");
        
        salvarDados.close();
        
        System.out.println("Dados cadastrados com sucesso!");
    }
    
   
    public  String[] consultar_pac(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
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
                                                                   
                 } 
                 else{  
                     
                 }
            } 
          return dados;         
    }
    
    
    public boolean consultarExistencia_pac(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
        BufferedReader lerDados = new BufferedReader(fr);
        
        String linha = ""; 
        
            while ((linha = lerDados.readLine()) != null){
                                    
                 if(linha.contains(cpf)){
                       
                    return true;
                 }                 
            }     
        return false;
    }
       
    public void remover_pac(String cpf) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
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
            
        FileWriter fw2 = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt" , true);
        fw2.close();     
        
        FileWriter fw = new FileWriter("C:\\Users\\FabioPrado\\Documents\\NetBeansProjects\\medlim\\src\\medlim\\paciente.txt");
        BufferedWriter salvar = new BufferedWriter(fw);  
        
        
        for(int x=0; x<salvarDados.size(); x++){
            salvar.write(salvarDados.get(x));
            salvar.newLine();           
        }
        
        salvar.close();
        fw.close();
              
    }
}
    


