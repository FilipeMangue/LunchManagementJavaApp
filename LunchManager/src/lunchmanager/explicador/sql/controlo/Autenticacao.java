package lunchmanager.explicador.sql.controlo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import lunchmanager.explicador.sql.modelo.Usuario;
import lunchmanager.explicador.sql.util.ConexaoBaseDados;
/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class Autenticacao {
    public static Usuario login(String username, String password) {
       
        try {
              Connection conn = ConexaoBaseDados.conectar();
             
              String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = conn.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                
                if (rs.first())
                {
                    return new Usuario (
                            rs.getInt("id"),
                            rs.getString("username"),"",
                            rs.getString("name")
                    );
                }
            }
              
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return null;
  }

}
