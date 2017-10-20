package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Davi
 */
public class LoginDAO extends DAO {
    
    private static LoginDAO instance;
    private static Connection myCONN;

    private LoginDAO() {
    }

    public static LoginDAO getInstance() {//tentar pegar instancia de conexão com o banco de dados
        if (instance == null) {
            instance = new LoginDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
    
    public static boolean checarLogin(String login, String senha){//passar os dados de login e senha e checar se eles estão no banco == true
        String checar = "select * from login where login = ? and senha = ?";
        PreparedStatement pstmt;
        try{
            pstmt = myCONN.prepareStatement(checar);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
               pstmt.close();
               return true;                             
            }
            else{
               pstmt.close();
               return false;             
            }

        }catch(SQLException ex){
            return false;
        }
        finally{
           
        }
    }
        
}
