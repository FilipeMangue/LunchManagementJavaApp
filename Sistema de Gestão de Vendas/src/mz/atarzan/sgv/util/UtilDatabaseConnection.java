package mz.atarzan.sgv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class UtilDatabaseConnection {
    private static String db_name = "dblanchonete"; //Nome da base de dados
    private static String username = "root"; //Nome de usuário para conexão com a db
    private static String password = ""; //Password de acesso
    private static String server = "localhost"; //Servidor or ip, mas geralmente: localhost
    
    public static Connection conectar (){
        try {
            Class.forName("java.sql.Driver");
            String path = "jdbc:mysql://" + server + "/" + db_name;
            Connection con = DriverManager.getConnection(path, username, password);
            
            System.out.println("Conexao feita com sucesso com o mysql no server: '" + server + "'...");
            
//            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!");
            
            return con;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UtilDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao contactar com o server: " + server + "\nError: " + ex.getMessage());
        }
        
        return null;
    }
}
