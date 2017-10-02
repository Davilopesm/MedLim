package model;

import java.sql.*;
import javax.swing.JOptionPane;
import view.*;




public class PacienteDAO extends DAO {
    
   private static PacienteDAO instance;
    private static Connection myCONN;

    private PacienteDAO() {
    }

    public static PacienteDAO getInstance() {
        if (instance == null) {
            instance = new PacienteDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
    
    public void checarLogin(String login, String senha){
        String checar = "select * from login where login = ? and senha = ?";
        PreparedStatement pstmt;
        try{
            pstmt = myCONN.prepareStatement(checar);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
               Login.abrirTela();         
            }
            else{
               Login.erroLogin();             
            }

        }catch(SQLException ex){
            
        }
        
    }
    
    
}
