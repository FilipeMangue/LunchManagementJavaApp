package mz.atarzan.sgv.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mz.atarzan.sgv.model.ModelUser;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class ControlCRUDUser {
    public static ModelUser registarUsuario(ModelUser usuario) {
       
        try {
            // the mysql insert statement
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                // the mysql insert statement
                String query = "INSERT INTO users (name, username, password)"
                             + " values (?, ?, ?)";
                
                // criando a mysql preparedstatement para inserção dos dados
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);
                
                preparedStmt.setString (1, usuario.getName());
                preparedStmt.setString(2, usuario.getUsername());
                preparedStmt.setString(3, usuario.getPassword());
                
                
                // executando a preparedstatement
                preparedStmt.execute();
            }
            
            return usuario;
              
        } catch (Exception e) {
            System.err.println("\tErro gravando usuario: \n" + e.getMessage());
        }
        
        return null;
    }
    
    public static ModelUser actualizarUsuario(ModelUser usuario, String name) {
       
        try {
            // the mysql insert statement
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                // the mysql insert statement
                String query = "UPDATE users SET name = ?, username = ?, password = ?, WHERE name = "+name;
                
                // criando a mysql preparedstatement para inserção dos dados
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);
                
                preparedStmt.setString (1, usuario.getName());
                preparedStmt.setString(2, usuario.getUsername());
                preparedStmt.setString(2, usuario.getPassword());
                
                // executando a preparedstatement
                preparedStmt.execute();
            }
            
            return usuario;
              
        } catch (Exception e) {
            System.err.println("\tErro actualizdo usuario: \n" + e.getMessage());
        }
        
        return null;
    }
 
    public static ModelUser apagarUsuario(ModelUser usuario) {
       
        try {
            // the mysql insert statement
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                // the mysql insert statement
                String query = "DELETE FROM `users` WHERE `users`.`name` = "+usuario.getUsername();
                
                // criando a mysql preparedstatement para inserção dos dados
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);
                
                preparedStmt.setString (1, usuario.getUsername());
                
                // executando a preparedstatement
                preparedStmt.execute();
            }
            
            return usuario;
              
        } catch (Exception e) {
            System.err.println("\tERRO AO APAGAR USUARIO: \n" + e.getMessage());
        }
        
        return null;
  }
}
