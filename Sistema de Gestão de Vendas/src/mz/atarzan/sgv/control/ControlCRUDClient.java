
package mz.atarzan.sgv.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import mz.atarzan.sgv.model.ModelClient;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ControlCRUDClient {
    
    public static ArrayList<ModelClient> clientsList = new ArrayList<>();
    
    public static ModelClient create(ModelClient client) {
        try {
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                String query = "INSERT INTO clients (type, name, birth, email, tell, age, address, comment)"
                             + " values (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);

                preparedStmt.setBoolean(1, client.isType());
                preparedStmt.setString (2, client.getName());
                preparedStmt.setInt(3, client.getBirth());
                preparedStmt.setString(4, client.getEmail());
                preparedStmt.setString(5, client.getTell());
                preparedStmt.setInt(6, client.getAge());
                preparedStmt.setString(7, client.getAddress());
                preparedStmt.setString(8, client.getComment());

                preparedStmt.execute();
            }
            return client;
        } catch (Exception e) {
            System.err.println("\tErro cadastrando cliente: \n" + e.getMessage()+"\n");
        }
        return null;
    }
    
    public static JTable read(JTable table){
        String[] columns = {"Nome", "Email", "Telemóvel", "Endereço"  };
        ArrayList list = data();
        ControlTableModel mt = new ControlTableModel(list, columns);
        table.setModel(mt); 
        
        return table;
    }
    
    public static ArrayList data(){
        ArrayList list = new ArrayList();
        clientsList = new ArrayList<>();
        try{
            Connection conn = UtilDatabaseConnection.connect();
            String query = "SELECT * FROM clients";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    clientsList.add(new ModelClient(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("tell"),
                            rs.getString("endereco")
                    ));
                    list.add(new Object[]{
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("tell"),
                        rs.getString("endereco")
                    });
                }
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro enquanto carregava os dados dos clintes!");
        }
        return list;
  }
}
