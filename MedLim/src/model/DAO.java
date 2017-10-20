package model;

import java.sql.*;

/**
 *
 * @author Davi
 */

public abstract class DAO {
  
    private static Connection con;    
    
    protected Connection getConnection() {//tentar abrir conexão com o banco de dados
       if (con == null) {
           try {
               con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medlim", "root", "davi");
           } catch (SQLException e) {
               throw new IllegalStateException("Não conseguimos conectar ao banco de dados!", e);
           }
       }
       return con;
    }
    
    
    
    
   
    
    
}
