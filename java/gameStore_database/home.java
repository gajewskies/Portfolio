package testGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class home extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    
    public home() {
        initComponents();
        DoConnection();
        setLocationRelativeTo(null);
    }
    public void DoConnection(){
        try {
            String  Database = "jdbc:oracle:thin:@141.238.32.242:1521:xe";
            String  User = "gajewski";
            String  Pswd = "password";
            con = DriverManager.getConnection(Database, User, Pswd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select accessory_id, accossory_name, accessory_description, accessory_type, accessory_price from accessories";
            rs = stmt.executeQuery(query);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtType = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        dtnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accessories");
        setResizable(false);

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Type");

        jLabel4.setText("Description");

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Record");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Record");
        btnDelete.setMinimumSize(new java.awt.Dimension(105, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        dtnAdd.setText("New Record");
        dtnAdd.setMaximumSize(new java.awt.Dimension(105, 23));
        dtnAdd.setMinimumSize(new java.awt.Dimension(105, 23));
        dtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnAddActionPerformed(evt);
            }
        });

        btnSave.setText("Save New Record");
        btnSave.setMaximumSize(new java.awt.Dimension(105, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(105, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel New Record");
        btnCancel.setMaximumSize(new java.awt.Dimension(105, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(105, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setMaximumSize(new java.awt.Dimension(105, 23));
        btnExit.setMinimumSize(new java.awt.Dimension(105, 23));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel5.setText("Price");

        btnReturn.setText("Return");
        btnReturn.setMaximumSize(new java.awt.Dimension(105, 23));
        btnReturn.setMinimumSize(new java.awt.Dimension(105, 23));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tyler\\Documents\\NetBeansProjects\\testConnect\\img\\Games-icon.png")); // NOI18N
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtType, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnLast)
                            .addComponent(btnNext)
                            .addComponent(btnPrev))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        
        try {
                rs.first();
                // Extract data from result set
                String AI = rs.getString("accessory_id");
                String AN = rs.getString("accossory_name");
                String AD = rs.getString("accessory_description");
                String AT = rs.getString("accessory_type");
                String AP = rs.getString("accessory_price");
                txtID.setText(AI);
                txtName.setText(AN);
                txtDescription.setText(AD);
                txtType.setText(AT);
                txtPrice.setText(AP);
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {
            rs.last();
            String AI = rs.getString("accessory_id");
            String AN = rs.getString("accossory_name");
            String AD = rs.getString("accessory_description");
            String AT = rs.getString("accessory_type");
            String AP = rs.getString("accessory_price");
            txtID.setText(AI);
            txtName.setText(AN);
            txtDescription.setText(AD);
            txtType.setText(AT);
            txtPrice.setText(AP);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {
                String AI = rs.getString("accessory_id");
                String AN = rs.getString("accossory_name");
                String AD = rs.getString("accessory_description");
                String AT = rs.getString("accessory_type");
                String AP = rs.getString("accessory_price");
                txtID.setText(AI);
                txtName.setText(AN);
                txtDescription.setText(AD);
                txtType.setText(AT);
                txtPrice.setText(AP);
            } else {
            JOptionPane.showMessageDialog(home.this, "End of Database");
        }
    } catch (SQLException err) {
        JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed

    private void dtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtnAddActionPerformed
        
        try {
            curRow = rs.getRow();

            txtID.setText("");
            txtDescription.setText("");
            txtName.setText("");
            txtType.setText("");
            txtPrice.setText("");
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            dtnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnSave.setEnabled(true);
            btnCancel.setEnabled(true);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
        
    }//GEN-LAST:event_dtnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String AI = txtID.getText();
        String AD = txtDescription.getText();
        String AN = txtName.getText();
        String AT = txtType.getText();
        String AP = txtPrice.getText();

        try {
            rs.moveToInsertRow();
            rs.updateString("accessory_id",AI);
            rs.updateString("accossory_name", AD);
            rs.updateString("accessory_description", AN);
            rs.updateString("accessory_type", AT);
            rs.updateString("accessory_price", AP);
            rs.insertRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select accessory_id, accossory_name, accessory_description, accessory_type, accessory_price from accessories";
            rs = stmt.executeQuery(query);
            String AI1 = txtID.getText();
            String AD1 = txtDescription.getText();
            String AN1 = txtName.getText();
            String AT1 = txtType.getText();
            String AP1 = txtPrice.getText();
            txtID.setText(AI1);
            txtDescription.setText(AD1);
            txtName.setText(AN1);
            txtType.setText(AT1);
            txtPrice.setText(AP1);
            btnFirst.setEnabled(true);
            btnPrev.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            dtnAdd.setEnabled(true);
            
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            rs.absolute( curRow );
            txtID.setText( rs.getString("accessory_id"));
            txtDescription.setText( rs.getString("accossory_name"));
            txtName.setText( rs.getString("accessory_description"));
            txtType.setText( rs.getString("accessory_type" ));
            txtPrice.setText(rs.getString("accessory_price"));

            txtID.setText("");
            txtDescription.setText("");
            txtName.setText("");
            txtType.setText("");
            txtPrice.setText("");
            btnFirst.setEnabled(true);
            btnPrev.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            dtnAdd.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        try {
            rs.deleteRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select accessory_id, accossory_name, accessory_description, accessory_type, accessory_price from accessories";
            rs = stmt.executeQuery(query);
            rs.next();
            String AI = rs.getString("accessory_id");
            String AN = rs.getString("accossory_name");
            String AD = rs.getString("accessory_description");
            String AT = rs.getString("accessory_type");
            String AP = rs.getString("accessory_price");
            txtID.setText(AI);
            txtDescription.setText(AN);
            txtName.setText(AD);
            txtType.setText(AT);
            txtPrice.setText(AP);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        String AI = txtID.getText();
        String AD = txtDescription.getText();
        String AN = txtName.getText();
        String AT = txtType.getText();
        String AP = txtPrice.getText();

        try {
            rs.updateString("accessory_id",AI);
            rs.updateString("accossory_name", AD);
            rs.updateString("accessory_description", AN);
            rs.updateString("accessory_type", AT);
            rs.updateString("accessory_price", AP);
            rs.updateRow();
            JOptionPane.showMessageDialog(home.this, "Updated");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

        try {
            if (rs.previous()){
                String AI = rs.getString("accessory_id");
                String AN = rs.getString("accossory_name");
                String AD = rs.getString("accessory_description");
                String AT = rs.getString("accessory_type");
                String AP = rs.getString("accessory_price");
                txtID.setText(AI);
                txtName.setText(AN);
                txtDescription.setText(AD);
                txtType.setText(AT);
                txtPrice.setText(AP);
                } else {
                    JOptionPane.showMessageDialog(home.this, "Start of Database");
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(home.this, err.getMessage()); }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        JFrame frame = new main();
        frame.show();
        this.hide();
    }//GEN-LAST:event_btnReturnActionPerformed

    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton dtnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

}