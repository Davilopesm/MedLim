package medlim;

public class Paciente {

    private String nome;
    private float CPF;
    private float RG;
    private String endereco;
    private float telefone;


    public Paciente(String nome, float CPF, float RG, String endereco, float telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
    }


   public void cadastrarPaciente(String nome, float CPF, float RG, String endereco, float telefone){

   }

    public void alterarPaciente(float CPF){

    }
    public void removerPaciente(float CPF){

    }

    public void consultarPaciente(float CPF){

    }
}
