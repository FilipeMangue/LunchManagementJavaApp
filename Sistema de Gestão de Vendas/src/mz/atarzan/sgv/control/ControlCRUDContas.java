/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.atarzan.sgv.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mz.atarzan.sgv.model.ModelContas;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ControlCRUDContas {
    public static ArrayList<ModelContas> contasList;
    public static int cli_registados;
    
    public static ModelContas create(ModelContas conta) {
        try {
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                String query = "INSERT INTO contas (tipo, valor, data, referente_a, estado)"
                             + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);

                preparedStmt.setString(1, conta.getTipo());
                preparedStmt.setDouble(2, conta.getValor());
                preparedStmt.setDate(3, conta.getData());
                preparedStmt.setString(4, conta.getReferente_a());
                preparedStmt.setBoolean(5, conta.isEstado());

                preparedStmt.execute();
            }
            return conta;
        } catch (Exception e) {
            System.err.println("\tERRO AO REGISTAR CONTA: \n" + e.getMessage()+"\n");
        }
        return null;
    }
    
    public static ModelContas  update (int id, ModelContas conta){
        try {
            // Create the java mysql update preparedstatement
            try (Connection conn = UtilDatabaseConnection.connect()) {
                // Create the java mysql update preparedstatement
                String query = "UPDATE contas SET tipo = ?, valor = ?, data = ?, referente_a = ?, estado = ?, where id = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                
                preparedStmt.setString(1, conta.getTipo());
                preparedStmt.setDouble(2, conta.getValor());
                preparedStmt.setDate(3, conta.getData());
                preparedStmt.setString(4, conta.getReferente_a());
                preparedStmt.setBoolean(5, conta.isEstado());
                preparedStmt.setInt(6, id);
                // Executes the java preparedstatement
                preparedStmt.executeUpdate();
            }
            return conta;
        } catch (Exception e){
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO AO ACTUALIZAR A CONTA.");
        }
        return null;
    }
    
    public static JTable read(JTable table){
        String[] columns = {"Tipo", "Valor", "Data", "Referente a", "Estado"};
        ArrayList list = data();
        ControlTableModel mt = new ControlTableModel(list, columns);
        table.setModel(mt); 
        
        return table;
    }
    
    public static ArrayList data(){
        ArrayList list = new ArrayList();
        contasList = new ArrayList<>();
        try{
            Connection conn = UtilDatabaseConnection.connect();
            String query = "SELECT * FROM contas";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    contasList.add(new ModelContas(
                        rs.getString("tipo"), 
                        rs.getDouble("valor"), 
                        rs.getDate("data"), 
                        rs.getString("referente_a"), 
                        rs.getBoolean("estado")
                    ));
                    list.add(new Object[]{
                        rs.getString("tipo"), 
                        rs.getDouble("valor"), 
                        rs.getDate("data"), 
                        rs.getString("referente_a"), 
                        rs.getBoolean("estado")
                    });
                    //cli_registados += 1;
                }
                //VisionListarClientes.lbCliRegistados.setText(""+cli_registados);
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO ENQUANTO CARREGAVA OS DADOS DE CONTAS!");
        }
        return list;
  }
    
  public static ModelContas delete(ModelContas conta) {
        try {
            // the mysql insert statement
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                // the mysql insert statement
                String query = "DELETE FROM `contass` WHERE `contas`.`cod` = "+conta.getCod();
                
                // criando a mysql preparedstatement para inserção dos dados
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);
                
                preparedStmt.setInt(1, conta.getCod());
                
                // executando a preparedstatement
                preparedStmt.execute();
            }
            
            return conta;
              
        } catch (Exception e) {
            System.err.println("\tERRO AO APAGAR CONTA: \n" + e.getMessage());
        }
        
        return null;
  }
}
