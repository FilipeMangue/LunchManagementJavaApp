package mz.atarzan.sgv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class UtilDatabaseConnection {
    private static final String db_name = "dbsgv";
    private static final String username = "root";
    private static final String password = "";
    private static final String server = "localhost";
    
    public static Connection connect(){
        try {
            Class.forName("java.sql.Driver");
            String path = "jdbc:mysql://" + server + "/" + db_name;
            Connection connection = DriverManager.getConnection(path, username, password);
            
            System.out.println("Conexão feita com sucesso com o MySql no server: '" + server + "'...");
                        
            return connection;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UtilDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR COM O SERVIDOR: " + server + "\nError: " + ex.getMessage());
        }
        
        return null;
    }
}
