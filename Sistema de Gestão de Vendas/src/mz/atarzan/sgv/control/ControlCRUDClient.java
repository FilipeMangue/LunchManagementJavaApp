
package mz.atarzan.sgv.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mz.atarzan.sgv.model.ModelClient;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ControlCRUDClient {
    public static ModelClient create(ModelClient client) {
        try {
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                String query = "INSERT INTO clients (type, name, birth, email, tell, age, address, comment)"
                             + " values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);

                preparedStmt.setBoolean(1, client.isType());
                preparedStmt.setString (2, client.getName());
                preparedStmt.setInt(3, client.getBirth());
                preparedStmt.setString(4, client.getEmail());
                preparedStmt.setString(5, client.getTell());
                preparedStmt.setInt(5, client.getAge());
                preparedStmt.setString(6, client.getAddress());
                preparedStmt.setString(7, client.getComment());

                preparedStmt.execute();
            }
            return client;
        } catch (Exception e) {
            System.err.println("\tErro cadastrando cliente: \n" + e.getMessage()+"\n");
        }
        return null;
    }    
}
