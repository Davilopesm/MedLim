
package medlim;

/**
 *
 * @author FabioPrado
 */
public class Profissional {
    public String nome_prof;
    public String rg_prof;
    public String cpf_prof;
    public String endereço_prof;
    public String tel_prof;
    public String cargo;
    
    public Profissional(String nome_prof, String rg_prof, String cpf_prof, String endereço_prof, String tel_prof, String cargo ){
        this.nome_prof = nome_prof;
        this.rg_prof = rg_prof;
        this.cpf_prof = cpf_prof;
        this.endereço_prof = endereço_prof;
        this.tel_prof = tel_prof;
        this.cargo = cargo;
    }

    public Profissional(String cpf) {
        this.cpf_prof = cpf_prof;
    }

    public String getNome_prof() {
        return nome_prof;
    }

    public void setNome_prof(String nome_prof) {
        this.nome_prof = nome_prof;
    }

    public String getRg_prof() {
        return rg_prof;
    }

    public void setRg_prof(String rg_prof) {
        this.rg_prof = rg_prof;
    }

    public String getCpf_prof() {
        return cpf_prof;
    }

    public void setCpf_prof(String cpf_prof) {
        this.cpf_prof = cpf_prof;
    }

    public String getEndereço_prof() {
        return endereço_prof;
    }

    public void setEndereço_prof(String endereço_prof) {
        this.endereço_prof = endereço_prof;
    }

    public String getTel_prof() {
        return tel_prof;
    }

    public void setTel_prof(String tel_prof) {
        this.tel_prof = tel_prof;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    public void cadastrar_prof(){       
    }
    
    public void consultar_prof(){  
    }
    
    public void alterar_prof(){
    }
    
    public void remover_prof(){
        
    }
        
}
