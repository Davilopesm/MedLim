package medlim;

public class ProfissionalMedico extends Profissional {

    private int CRM;
    private String areaDeAtuacao;

    public ProfissionalMedico(String nome, float RG, float CPF, String endereco, float telefone, String cargo, int CRM, String areaDeAtuacao) {
        super(nome, RG, CPF, endereco, telefone, cargo);
        this.CRM = CRM;
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public void cadastrarTecnico(String nome, float RG, float CPF, String endereco, float telefone, String cargo, String funcao, int CRM, String areaDeAtuacao){

    }

    public void alterarMedico(String nome) {

    }

    public void removerMedico(String nome) {

    }

    public void consultarMedico(float CPF){

    }

}
