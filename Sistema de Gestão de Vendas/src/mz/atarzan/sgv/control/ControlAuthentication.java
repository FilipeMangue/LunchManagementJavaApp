package mz.atarzan.sgv.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import mz.atarzan.sgv.model.ModelUser;
import mz.atarzan.sgv.util.UtilDatabaseConnection;
/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class ControlAuthentication {
    public static ModelUser login(String username, String password) {
       
        try {
              Connection conn = UtilDatabaseConnection.connect();
             
              String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = conn.createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                
                if (rs.first())
                {
                    return new ModelUser (
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
