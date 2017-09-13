package medlim;

public class Profissional {

    private String nome;
    private float RG;
    private float CPF;
    private String endereco;
    private float telefone;
    private String cargo;

    public Profissional(String nome, float RG, float CPF, String endereco, float telefone, String cargo) {
        this.nome = nome;
        this.RG = RG;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public void cadastrarProfissional(String nome, float RG, float CPF, String endereco, float telefone, String cargo){

    }

    public void alterarProfissional(float CPF){

    }
    public void removerProfisissional(float CPF){

    }

    public void consultarProfissional(float CPF){

    }
}
