package control;

import model.*;

/**
 *
 * @author ScrumTeam
 */
public class Control {
    
    public static void fazerLogin(String login, String senha){
        PacienteDAO.getInstance().checarLogin(login, senha);
        
    }
        
    
}
