/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.*;

/**
 *
 * @author Davi
 */
public class LoginDAO extends DAO {
    
    private static LoginDAO instance;
    private static Connection myCONN;

    private LoginDAO() {
    }

    public static LoginDAO getInstance() {
        if (instance == null) {
            instance = new LoginDAO();
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
