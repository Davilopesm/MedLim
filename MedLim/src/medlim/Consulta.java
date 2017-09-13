package medlim;

public class Consulta extends Atendimento {

    private String parecer_consulta;

    public Consulta(String nome_pac, String nome_prof, float date_agend, float horario_agend, String parecer_consulta) {
        super(nome_pac, nome_prof, date_agend, horario_agend);
        this.parecer_consulta = parecer_consulta;
    }


    public void inserirParecerM(String parecer_consulta){

    }
}
