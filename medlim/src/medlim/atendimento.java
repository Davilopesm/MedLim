/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medlim;

/**
 *
 * @author FabioPrado
 */
public class atendimento {
    public String cpf_pac;
    public String data_agend;
    public String horario_agend;

    public atendimento(String cpf_pac, String data_agend, String horario_agend) {
        this.cpf_pac = cpf_pac;
        this.data_agend = data_agend;
        this.horario_agend = horario_agend;
    }
    
    public atendimento(String cpf_pac){
         this.cpf_pac = cpf_pac;
    }

    public String getCpf_pac() {
        return cpf_pac;
    }

    public void setCpf_pac(String cpf_pac) {
        this.cpf_pac = cpf_pac;
    }

    public String getData_agend() {
        return data_agend;
    }

    public void setData_agend(String data_agend) {
        this.data_agend = data_agend;
    }

    public String getHorario_agend() {
        return horario_agend;
    }

    public void setHorario_agend(String horario_agend) {
        this.horario_agend = horario_agend;
    }
    
    
    public void agendar_atend(){
    }
    
    public void consultar_atend(){
    }
    
    public void alterar_atend(){
    }
    
    public void remover_atend(){
    }
    
}
