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
import mz.atarzan.sgv.model.ModelFornecedores;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 *
 * @author Filipe Emanuel
 */
public class ControlCRUDFornecedores {
    public static ArrayList<ModelFornecedores> providersList = new ArrayList<>();
    public static int forn_registados;
    
    public static ModelFornecedores create(ModelFornecedores fornecedor) {
        try {
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                String query = "INSERT INTO fornecedores (nome, endereco, telemovel, pais, data_de_registo, registado_por, alterado_por, alterado_em,email)"
                             + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);

                preparedStmt.setString(1, fornecedor.getNome());
                preparedStmt.setString(2, fornecedor.getEndereco());
                preparedStmt.setString(3, fornecedor.getTelemovel());
                preparedStmt.setString(4, fornecedor.getPais());
                preparedStmt.setString(5, fornecedor.getData_de_registo());
                preparedStmt.setString(6, fornecedor.getRegistado_por());
                preparedStmt.setString(7, fornecedor.getAlterado_por());
                preparedStmt.setString(8, fornecedor.getAlterado_em());
                preparedStmt.setString(9, fornecedor.getEmail());

                preparedStmt.execute();
            }
            return fornecedor;
        } catch (Exception e) {
            System.err.println("\tErro cadastrando fornecedor: \n" + e.getMessage()+"\n");
        }
        return null;
    }
    
    public static ModelFornecedores  update (int codigo, ModelFornecedores fornecedor){
        try {
            // Create the java mysql update preparedstatement
            try (Connection conn = UtilDatabaseConnection.connect()) {
                // Create the java mysql update preparedstatement
                String query = "UPDATE fornecedores set nome = ?, "
                        + "endereco = ?, telemovel = ?, pais = ?, "
                        + "data_de_registo = ?, registado_por = ?,"
                        + "alterado_por = ?, alterado_em = ?, "
                        + "email = ?, WHERE codigo = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                
                preparedStmt.setString (1, fornecedor.getNome());
                preparedStmt.setString(2, fornecedor.getEndereco());
                preparedStmt.setString(3, fornecedor.getTelemovel());
                preparedStmt.setString(4, fornecedor.getPais());
                preparedStmt.setString(5, fornecedor.getData_de_registo());
                preparedStmt.setString(6, fornecedor.getRegistado_por());
                preparedStmt.setString(7, fornecedor.getAlterado_em());
                preparedStmt.setString(8, fornecedor.getEmail());
                preparedStmt.setInt(9, codigo);
                // Executes the java preparedstatement
                preparedStmt.executeUpdate();
            }
            return fornecedor;
        } catch (Exception e){
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Infelizmente, ocorreu um erro actualizando o fornecedor: " + fornecedor.getNome());
        }
        return null;
    }
    
    public static JTable read(JTable table){
        String[] columns = {"Código", "Nome", "Endereço", "Telemóvel", "País", "Data de Registo", "Registado por", "Alterado em", "Alterado por", "Email"};
        ArrayList list = data();
        ControlTableModel mt = new ControlTableModel(list, columns);
        table.setModel(mt); 
        
        return table;
    }
    
    public static ArrayList data(){
        ArrayList list = new ArrayList();
        providersList = new ArrayList<>();
        try{
            Connection conn = UtilDatabaseConnection.connect();
            String query = "SELECT * FROM fornecedores";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    providersList.add(new ModelFornecedores(
                        rs.getInt("codigo"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("telemovel"), 
                        rs.getString("pais"), 
                        rs.getString("data_de_registo"), 
                        rs.getString("registado_por"), 
                        rs.getString("alterado_por"), 
                        rs.getString("alterado_em"),
                        rs.getString("email")
                    ));
                    list.add(new Object[]{
                        rs.getInt("codigo"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("telemovel"), 
                        rs.getString("pais"), 
                        rs.getString("data_de_registo"), 
                        rs.getString("registado_por"), 
                        rs.getString("alterado_por"), 
                        rs.getString("alterado_em"),
                        rs.getString("email")
                    });
                    //forn_registados += 1;
                }
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro enquanto carregava os dados dos fornecedores!");
        }
        return list;
  }
    
  public static ModelFornecedores delete(ModelFornecedores fornecedor) {
        try {
            // the mysql insert statement
            try (Connection dbconnect = UtilDatabaseConnection.connect()) {
                // the mysql insert statement
                String query = "DELETE FROM `forncecedores` WHERE `fornecedores`.`id` = "+fornecedor.getCodigo();
                
                // criando a mysql preparedstatement para inserção dos dados
                PreparedStatement preparedStmt = dbconnect.prepareStatement(query);
                
                preparedStmt.setInt(1, fornecedor.getCodigo());
                
                // executando a preparedstatement
                preparedStmt.execute();
            }
            
            return fornecedor;
              
        } catch (Exception e) {
            System.err.println("\tERRO AO APAGAR FORNECEDOR: \n" + e.getMessage());
        }
        
        return null;
  }
}
