package medlim;

public class ProfissionalTecnico extends Profissional {

    private String funcao;

    public ProfissionalTecnico(String nome, float RG, float CPF, String endereco, float telefone, String cargo, String funcao) {
        super(nome, RG, CPF, endereco, telefone, cargo);
        this.funcao = funcao;
    }


    public void cadastrarTecnico(String nome, float RG, float CPF, String endereco, float telefone, String cargo, String funcao){

    }

    public void alterarTecnico(String nome){

    }

    public void removerTecnico(String nome){

    }

    public void consultarTecnico(float CPF){

    }
}
