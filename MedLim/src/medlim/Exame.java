package medlim;

public class Exame extends Atendimento {

    private String parecer_exame;

    public Exame(String nome_pac, String nome_prof, float date_agend, float horario_agend, String parecer_exame) {
        super(nome_pac, nome_prof, date_agend, horario_agend);
        this.parecer_exame = parecer_exame;
    }

    public void inserirParecer(String parecer_exame){

    }
}
