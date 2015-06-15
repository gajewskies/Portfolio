
package testGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class order extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    
    public order() {
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
            String query = "select order_id, order_total, products_id, qty, shipping_address, payment_id from orderr";
            rs = stmt.executeQuery(query);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBox3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBox1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBox2 = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        txtBox4 = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBox5 = new javax.swing.JTextField();
        dtnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        txtBox6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order");

        jLabel3.setText("quantity");

        jLabel4.setText("Products id");

        btnExit.setText("Exit");
        btnExit.setMaximumSize(new java.awt.Dimension(105, 23));
        btnExit.setMinimumSize(new java.awt.Dimension(105, 23));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Total");

        jLabel1.setText("order id");

        dtnAdd.setText("New Record");
        dtnAdd.setMaximumSize(new java.awt.Dimension(105, 23));
        dtnAdd.setMinimumSize(new java.awt.Dimension(105, 23));
        dtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("shipping address");

        btnCancel.setText("Cancel New Record");
        btnCancel.setMaximumSize(new java.awt.Dimension(105, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(105, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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

        btnReturn.setText("Return");
        btnReturn.setMaximumSize(new java.awt.Dimension(105, 23));
        btnReturn.setMinimumSize(new java.awt.Dimension(105, 23));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel6.setText("payment id");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tyler\\Documents\\NetBeansProjects\\testConnect\\img\\Games-icon.png")); // NOI18N
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)))
                            .addGap(9, 9, 9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBox2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBox3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBox4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(txtBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
            String AI = rs.getString("order_id");
            String AN = rs.getString("order_total");
            String AD = rs.getString("products_id");
            String AT = rs.getString("qty");
            String AP = rs.getString("shipping_address");
            String AL = rs.getString("payment_id");
            txtBox1.setText(AI);
            txtBox2.setText(AN);
            txtBox3.setText(AD);
            txtBox4.setText(AT);
            txtBox5.setText(AP);
            txtBox6.setText(AL);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

        try {
            if (rs.previous()){
                String AI = rs.getString("order_id");
                String AN = rs.getString("order_total");
                String AD = rs.getString("products_id");
                String AT = rs.getString("qty");
                String AP = rs.getString("shipping_address");
                String AL = rs.getString("payment_id");
                txtBox1.setText(AI);
                txtBox2.setText(AN);
                txtBox3.setText(AD);
                txtBox4.setText(AT);
                txtBox5.setText(AP);
                txtBox6.setText(AL);
            } else {
                JOptionPane.showMessageDialog(order.this, "Start of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {
                String AI = rs.getString("order_id");
                String AN = rs.getString("order_total");
                String AD = rs.getString("products_id");
                String AT = rs.getString("qty");
                String AP = rs.getString("shipping_address");
                String AL = rs.getString("payment_id");
                txtBox1.setText(AI);
                txtBox2.setText(AN);
                txtBox3.setText(AD);
                txtBox4.setText(AT);
                txtBox5.setText(AP);
                txtBox6.setText(AL);
            } else {
                JOptionPane.showMessageDialog(order.this, "End of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {
            rs.last();
            String AI = rs.getString("order_id");
            String AN = rs.getString("order_total");
            String AD = rs.getString("products_id");
            String AT = rs.getString("qty");
            String AP = rs.getString("shipping_address");
            String AL = rs.getString("payment_id");
            txtBox1.setText(AI);
            txtBox2.setText(AN);
            txtBox3.setText(AD);
            txtBox4.setText(AT);
            txtBox5.setText(AP);
            txtBox6.setText(AL);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String AI = txtBox1.getText();
        String AD = txtBox3.getText();
        String AN = txtBox2.getText();
        String AT = txtBox4.getText();
        String AP = txtBox5.getText();
        String AL = txtBox6.getText();

        try {
            rs.updateString("order_id",AI);
            rs.updateString("order_total", AD);
            rs.updateString("products_id", AN);
            rs.updateString("qty", AT);
            rs.updateString("shipping_address", AP);
            rs.updateString("payment_id", AL);
            rs.updateRow();
            JOptionPane.showMessageDialog(order.this, "Updated");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            rs.deleteRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select order_id, order_total, products_id, qty, shipping_address, payment_id from orderr";
            rs = stmt.executeQuery(query);
            rs.next();
            String AI = rs.getString("order_id");
            String AN = rs.getString("order_total");
            String AD = rs.getString("products_id");
            String AT = rs.getString("qty");
            String AP = rs.getString("shipping_address");
            String AL = rs.getString("payment_id");
            txtBox1.setText(AI);
            txtBox2.setText(AN);
            txtBox3.setText(AD);
            txtBox4.setText(AT);
            txtBox5.setText(AP);
            txtBox6.setText(AL);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void dtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtnAddActionPerformed

        try {
            curRow = rs.getRow();

            txtBox1.setText("");
            txtBox3.setText("");
            txtBox2.setText("");
            txtBox4.setText("");
            txtBox5.setText("");
            txtBox6.setText("");
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
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }

    }//GEN-LAST:event_dtnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            rs.absolute( curRow );
            txtBox1.setText( rs.getString("order_id"));
            txtBox3.setText( rs.getString("order_total"));
            txtBox2.setText( rs.getString("products_id"));
            txtBox4.setText( rs.getString("qty" ));
            txtBox5.setText( rs.getString("shipping_address"));
            txtBox6.setText( rs.getString("payment_id"));

            txtBox1.setText("");
            txtBox3.setText("");
            txtBox2.setText("");
            txtBox4.setText("");
            txtBox5.setText("");
            txtBox6.setText("");
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
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String AI = txtBox1.getText();
        String AD = txtBox3.getText();
        String AN = txtBox2.getText();
        String AT = txtBox4.getText();
        String AP = txtBox5.getText();
        String AL = txtBox6.getText();

        try {
            rs.moveToInsertRow();
            rs.updateString("order_id",AI);
            rs.updateString("order_total", AD);
            rs.updateString("products_id", AN);
            rs.updateString("qty", AT);
            rs.updateString("shipping_address", AP);
            rs.updateString("payment_id", AL);
            rs.insertRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select order_id, order_total, products_id, qty, shipping_address, payment_id from orderr";
            rs = stmt.executeQuery(query);
            String AI1 = txtBox1.getText();
            String AD1 = txtBox3.getText();
            String AN1 = txtBox2.getText();
            String AT1 = txtBox4.getText();
            String AP1 = txtBox5.getText();
            String AL1 = txtBox6.getText();
            txtBox1.setText(AI1);
            txtBox3.setText(AD1);
            txtBox2.setText(AN1);
            txtBox4.setText(AT1);
            txtBox5.setText(AP1);
            txtBox6.setText(AL1);
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
            JOptionPane.showMessageDialog(order.this, err.getMessage()); }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        JFrame frame = new main();
        frame.show();
        this.hide();
    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBox1;
    private javax.swing.JTextField txtBox2;
    private javax.swing.JTextField txtBox3;
    private javax.swing.JTextField txtBox4;
    private javax.swing.JTextField txtBox5;
    private javax.swing.JTextField txtBox6;
    // End of variables declaration//GEN-END:variables
}
