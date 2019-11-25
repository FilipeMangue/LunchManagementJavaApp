package mz.atarzan.sgv.vision;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import mz.atarzan.sgv.control.ControlCRUDClient;
import mz.atarzan.sgv.util.UtilDatabaseConnection;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class VisionListarClientes extends javax.swing.JFrame {
    /**
     * Creates new form PainelListaUsuarioss
     * @throws java.sql.SQLException
     */
    public VisionListarClientes() throws SQLException {
        initComponents();
        listarUsuarios();
        setLocationRelativeTo(this);
    }
    
    private void listarUsuarios() throws SQLException{
        try {
            try (Connection connect = UtilDatabaseConnection.connect()) {
                String sql = "SELECT * FROM clients";
                PreparedStatement stmt = connect.prepareStatement(sql);
                try (ResultSet rs = stmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel)jtClients.getModel();
                    model.setNumRows(0);
                    
                    while(rs.next()){
                        model.addRow(new Object[]{
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("tell"),
                            rs.getString("endereco")});
                    }
                }
            }
        } catch (SQLException e) {
        }
        
    }
    
    private void searchClients(String username) throws SQLException{
        try {
            try (Connection connect = UtilDatabaseConnection.connect()) {
                String sql = "SELECT FROM clients WHERE name = ?"+username;
                PreparedStatement stmt = connect.prepareStatement(sql);
                try (ResultSet rs = stmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel)jtClients.getModel();
                    model.setNumRows(0);
                    
                    while(rs.first()){
                        model.addRow(new Object[]{rs.getString("name"),rs.getString("email"),rs.getString("tell"),rs.getString("endereco")});
                    }
                }
            }
        } catch (SQLException e) {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClients = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbCliRegistados = new javax.swing.JLabel();

        setTitle("LISTAGEM DE CLIENTES");
        setType(java.awt.Window.Type.UTILITY);

        jtfPesquisar.setBackground(new java.awt.Color(240, 244, 250));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Email", "Telemóvel", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClients.getTableHeader().setReorderingAllowed(false);
        jtClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtClientsMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jtClients);
        if (jtClients.getColumnModel().getColumnCount() > 0) {
            jtClients.getColumnModel().getColumn(1).setResizable(false);
            jtClients.getColumnModel().getColumn(2).setResizable(false);
        }

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Clientes Registados:");

        lbCliRegistados.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbCliRegistados.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbCliRegistados, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCliRegistados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            // TODO add your handling code here:
            String search = jtfPesquisar.getText();
            searchClients(search);
            VisionListarClientes vlc = new VisionListarClientes();
            vlc.setVisible(true);
            ControlCRUDClient.read(jtClients);
        } catch (SQLException ex) {
            Logger.getLogger(VisionListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtClientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtClientsMouseEntered

    private void jtClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientsMouseClicked
        // TODO add your handling code here:
        VisionCadastrarCliente vcc = new VisionCadastrarCliente();
        vcc.setVisible(true);
        VisionCadastrarCliente.btnCadastrar.setVisible(false);
        VisionCadastrarCliente.jtfName.setText(jtClients.getValueAt(jtClients.getSelectedRow(), 0).toString());
        VisionCadastrarCliente.jtfEmail.setText(jtClients.getValueAt(jtClients.getSelectedRow(), 1).toString());
        VisionCadastrarCliente.jtfTell.setText(jtClients.getValueAt(jtClients.getSelectedRow(), 2).toString());
        VisionCadastrarCliente.jtfAddress.setText(jtClients.getValueAt(jtClients.getSelectedRow(), 3).toString());
        
        
    }//GEN-LAST:event_jtClientsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisionListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisionListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisionListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisionListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VisionListarClientes().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(VisionListarClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtClients;
    private javax.swing.JTextField jtfPesquisar;
    public static javax.swing.JLabel lbCliRegistados;
    // End of variables declaration//GEN-END:variables
}
