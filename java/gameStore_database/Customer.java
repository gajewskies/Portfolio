package testGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Customer extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
        
    public Customer() {
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
            String query = "select customer_id, fname, lname, email, address, dob, phone_number from customer";
            rs = stmt.executeQuery(query);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtBox3 = new javax.swing.JTextField();
        txtBox7 = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        txtBox6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBox2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBox1 = new javax.swing.JTextField();
        txtBox4 = new javax.swing.JTextField();
        btnPrev = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBox5 = new javax.swing.JTextField();
        dtnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customers");

        jLabel6.setText("DOB");

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

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        jLabel4.setText("Last Name");

        jLabel7.setText("Phone Number");

        jLabel3.setText("Email");

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
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

        jLabel2.setText("First Name");

        jLabel1.setText("ID");
        jLabel1.setToolTipText("");

        dtnAdd.setText("New Record");
        dtnAdd.setMaximumSize(new java.awt.Dimension(105, 23));
        dtnAdd.setMinimumSize(new java.awt.Dimension(105, 23));
        dtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Address");

        btnReturn.setText("Return");
        btnReturn.setMaximumSize(new java.awt.Dimension(105, 23));
        btnReturn.setMinimumSize(new java.awt.Dimension(105, 23));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tyler\\Documents\\NetBeansProjects\\testConnect\\img\\Games-icon.png")); // NOI18N
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBox6)
                            .addComponent(txtBox4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBox3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBox7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addGap(43, 43, 43)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addComponent(jLabel8)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jLabel3)
                    .addComponent(txtBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String A = txtBox1.getText();
        String B = txtBox2.getText();
        String C = txtBox3.getText();
        String D = txtBox4.getText();
        String E = txtBox5.getText();
        String F = txtBox6.getText();
        String G = txtBox7.getText();

        try {
            rs.moveToInsertRow();
            rs.updateString("customer_id", A);
            rs.updateString("fname", B);
            rs.updateString("lname", C);
            rs.updateString("email", D);
            rs.updateString("address", E);
            rs.updateString("dob", F);
            rs.updateString("phone_number", G);
            rs.insertRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select customer_id, fname, lname, email, address, dob, phone_number from customer";
            rs = stmt.executeQuery(query);
            String A1 = txtBox1.getText();
            String B1 = txtBox2.getText();
            String C1 = txtBox3.getText();
            String D1 = txtBox4.getText();
            String E1 = txtBox5.getText();
            String F1 = txtBox6.getText();
            String G1 = txtBox7.getText();
            txtBox1.setText(A1);
            txtBox3.setText(B1);
            txtBox2.setText(C1);
            txtBox4.setText(D1);
            txtBox5.setText(E1);
            txtBox6.setText(F1);
            txtBox7.setText(G1);

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
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            rs.absolute( curRow );
            txtBox1.setText( rs.getString("customer_id"));
            txtBox3.setText( rs.getString("fname"));
            txtBox2.setText( rs.getString("lname"));
            txtBox4.setText( rs.getString("email" ));
            txtBox5.setText(rs.getString("address"));
            txtBox6.setText(rs.getString("dob"));
            txtBox7.setText(rs.getString("phone_number"));


            txtBox1.setText("");
            txtBox3.setText("");
            txtBox2.setText("");
            txtBox4.setText("");
            txtBox5.setText("");
            txtBox6.setText("");
            txtBox7.setText("");

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
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {
            rs.first();
            // Extract data from result set
            String A = rs.getString("customer_id");
            String B = rs.getString("fname");
            String C = rs.getString("lname");
            String D = rs.getString("email");
            String E = rs.getString("address");
            String F = rs.getString("dob");
            String G = rs.getString("phone_number");

            txtBox1.setText(A);
            txtBox2.setText(B);
            txtBox3.setText(C);
            txtBox4.setText(D);
            txtBox5.setText(E);
            txtBox6.setText(F);
            txtBox7.setText(G);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

        try {
            if (rs.previous()){
                String A = rs.getString("customer_id");
                String B = rs.getString("fname");
                String C = rs.getString("lname");
                String D = rs.getString("email");
                String E = rs.getString("address");
                String F = rs.getString("dob");
                String G = rs.getString("phone_number");

                txtBox1.setText(A);
                txtBox2.setText(B);
                txtBox3.setText(C);
                txtBox4.setText(D);
                txtBox5.setText(E);
                txtBox6.setText(F);
                txtBox7.setText(G);
            } else {
                JOptionPane.showMessageDialog(Customer.this, "Start of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {
            rs.last();
            String A = rs.getString("customer_id");
            String B = rs.getString("fname");
            String C = rs.getString("lname");
            String D = rs.getString("email");
            String E = rs.getString("address");
            String F = rs.getString("dob");
            String G = rs.getString("phone_number");

            txtBox1.setText(A);
            txtBox2.setText(B);
            txtBox3.setText(C);
            txtBox4.setText(D);
            txtBox5.setText(E);
            txtBox6.setText(F);
            txtBox7.setText(G);
 
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {
                String A = rs.getString("customer_id");
                String B = rs.getString("fname");
                String C = rs.getString("lname");
                String D = rs.getString("email");
                String E = rs.getString("address");
                String F = rs.getString("dob");
                String G = rs.getString("phone_number");

                txtBox1.setText(A);
                txtBox2.setText(B);
                txtBox3.setText(C);
                txtBox4.setText(D);
                txtBox5.setText(E);
                txtBox6.setText(F);
                txtBox7.setText(G);
            } else {
                JOptionPane.showMessageDialog(Customer.this, "End of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String A = txtBox1.getText();
        String B = txtBox2.getText();
        String C = txtBox3.getText();
        String D = txtBox4.getText();
        String E = txtBox5.getText();
        String F = txtBox6.getText();
        String G = txtBox7.getText();

        try {
            rs.updateString("customer_id", A);
            rs.updateString("fname", B);
            rs.updateString("lname", C);
            rs.updateString("email", D);
            rs.updateString("address", E);
            rs.updateString("dob", F);
            rs.updateString("phone_number", G);

            rs.updateRow();
            JOptionPane.showMessageDialog(Customer.this, "Updated");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            rs.deleteRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select customer_id, fname, lname, email, address, dob, phone_number from customer";
            rs = stmt.executeQuery(query);
            rs.next();
            String A = rs.getString("customer_id");
            String B = rs.getString("fname");
            String C = rs.getString("lname");
            String D = rs.getString("email");
            String E = rs.getString("address");
            String F = rs.getString("dob");
            String G = rs.getString("phone_number");

            txtBox1.setText(A);
            txtBox2.setText(B);
            txtBox3.setText(C);
            txtBox4.setText(D);
            txtBox5.setText(E);
            txtBox6.setText(F);
            txtBox7.setText(G);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
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
            txtBox7.setText("");

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
            JOptionPane.showMessageDialog(Customer.this, err.getMessage()); }
    }//GEN-LAST:event_dtnAddActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBox1;
    private javax.swing.JTextField txtBox2;
    private javax.swing.JTextField txtBox3;
    private javax.swing.JTextField txtBox4;
    private javax.swing.JTextField txtBox5;
    private javax.swing.JTextField txtBox6;
    private javax.swing.JTextField txtBox7;
    // End of variables declaration//GEN-END:variables
}
