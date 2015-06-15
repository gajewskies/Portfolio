package testGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class pays_for extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    public pays_for() {
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
            String query = "select payment_id, doe, sec_num, billing, name_on_card, card_type, card_name, card_number from pays_for";
            rs = stmt.executeQuery(query);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtType = new javax.swing.JTextField();
        txtConsole = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        txtPlayers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtRating = new javax.swing.JTextField();
        btnPrev = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDeveloper = new javax.swing.JTextField();
        dtnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment");

        jLabel6.setText("card type");

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

        jLabel8.setText("card number");

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        jLabel4.setText("secure number");

        jLabel7.setText("card name");

        jLabel3.setText("billing address");

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

        jLabel2.setText("date of exp");

        jLabel1.setText("payment id");

        dtnAdd.setText("New Record");
        dtnAdd.setMaximumSize(new java.awt.Dimension(105, 23));
        dtnAdd.setMinimumSize(new java.awt.Dimension(105, 23));
        dtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("name on card");

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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtName)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtType, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRating, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDeveloper)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtConsole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(txtPrice)
                                    .addComponent(txtPlayers, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap())
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
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String A = txtID.getText();
        String B = txtName.getText();
        String C = txtType.getText();
        String D = txtRating.getText();
        String E = txtDeveloper.getText();
        String F = txtPlayers.getText();
        String G = txtConsole.getText();
        String H = txtPrice.getText();

        try {
            rs.moveToInsertRow();
            rs.updateString("payment_id", A);
            rs.updateString("doe", B);
            rs.updateString("sec_num", C);
            rs.updateString("billing", D);
            rs.updateString("name_on_card", E);
            rs.updateString("card_type", F);
            rs.updateString("card_name", G);
            rs.updateString("card_number", H);
            rs.insertRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select payment_id, doe, sec_num, billing, name_on_card, card_type, card_name, card_number from pays_for";
            rs = stmt.executeQuery(query);
            String A1 = txtID.getText();
            String B1 = txtName.getText();
            String C1 = txtType.getText();
            String D1 = txtRating.getText();
            String E1 = txtDeveloper.getText();
            String F1 = txtPlayers.getText();
            String G1 = txtConsole.getText();
            String H1 = txtPrice.getText();
            txtID.setText(A1);
            txtType.setText(B1);
            txtName.setText(C1);
            txtRating.setText(D1);
            txtDeveloper.setText(E1);
            txtPlayers.setText(F1);
            txtConsole.setText(G1);
            txtPrice.setText(H1);
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
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            rs.absolute( curRow );
            txtID.setText( rs.getString("payment_id"));
            txtType.setText( rs.getString("doe"));
            txtName.setText( rs.getString("sec_num"));
            txtRating.setText( rs.getString("billing" ));
            txtDeveloper.setText(rs.getString("name_on_card"));
            txtPlayers.setText(rs.getString("card_type"));
            txtConsole.setText(rs.getString("card_name"));
            txtPrice.setText(rs.getString("card_number"));

            txtID.setText("");
            txtType.setText("");
            txtName.setText("");
            txtRating.setText("");
            txtDeveloper.setText("");
            txtPlayers.setText("");
            txtConsole.setText("");
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
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {
            rs.first();
            // Extract data from result set
            String A = rs.getString("payment_id");
            String B = rs.getString("doe");
            String C = rs.getString("sec_num");
            String D = rs.getString("billing");
            String E = rs.getString("name_on_card");
            String F = rs.getString("card_type");
            String G = rs.getString("card_name");
            String H = rs.getString("card_number");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

        try {
            if (rs.previous()){
                String A = rs.getString("payment_id");
                String B = rs.getString("doe");
                String C = rs.getString("sec_num");
                String D = rs.getString("billing");
                String E = rs.getString("name_on_card");
                String F = rs.getString("card_type");
                String G = rs.getString("card_name");
                String H = rs.getString("card_number");
                txtID.setText(A);
                txtName.setText(B);
                txtType.setText(C);
                txtRating.setText(D);
                txtDeveloper.setText(E);
                txtPlayers.setText(F);
                txtConsole.setText(G);
                txtPrice.setText(H);
            } else {
                JOptionPane.showMessageDialog(pays_for.this, "Start of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {
            rs.last();
            String A = rs.getString("payment_id");
            String B = rs.getString("doe");
            String C = rs.getString("sec_num");
            String D = rs.getString("billing");
            String E = rs.getString("name_on_card");
            String F = rs.getString("card_type");
            String G = rs.getString("card_name");
            String H = rs.getString("card_number");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {
                String A = rs.getString("payment_id");
                String B = rs.getString("doe");
                String C = rs.getString("sec_num");
                String D = rs.getString("billing");
                String E = rs.getString("name_on_card");
                String F = rs.getString("card_type");
                String G = rs.getString("card_name");
                String H = rs.getString("card_number");
                txtID.setText(A);
                txtName.setText(B);
                txtType.setText(C);
                txtRating.setText(D);
                txtDeveloper.setText(E);
                txtPlayers.setText(F);
                txtConsole.setText(G);
                txtPrice.setText(H);
            } else {
                JOptionPane.showMessageDialog(pays_for.this, "End of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String A = txtID.getText();
        String B = txtName.getText();
        String C = txtType.getText();
        String D = txtRating.getText();
        String E = txtDeveloper.getText();
        String F = txtPlayers.getText();
        String G = txtConsole.getText();
        String H = txtPrice.getText();
        try {
            rs.updateString("payment_id", A);
            rs.updateString("doe", B);
            rs.updateString("sec_num", C);
            rs.updateString("billing", D);
            rs.updateString("name_on_card", E);
            rs.updateString("card_type", F);
            rs.updateString("card_name", G);
            rs.updateString("card_number", H);
            rs.updateRow();
            JOptionPane.showMessageDialog(pays_for.this, "Updated");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            rs.deleteRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select payment_id, doe, sec_num, billing, name_on_card, card_type, card_name, card_number from pays_for";
            rs = stmt.executeQuery(query);
            rs.next();
            String A = rs.getString("payment_id");
            String B = rs.getString("doe");
            String C = rs.getString("sec_num");
            String D = rs.getString("billing");
            String E = rs.getString("name_on_card");
            String F = rs.getString("card_type");
            String G = rs.getString("card_name");
            String H = rs.getString("card_number");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void dtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtnAddActionPerformed

        try {
            curRow = rs.getRow();

            txtID.setText("");
            txtType.setText("");
            txtName.setText("");
            txtRating.setText("");
            txtDeveloper.setText("");
            txtPlayers.setText("");
            txtConsole.setText("");
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
            JOptionPane.showMessageDialog(pays_for.this, err.getMessage()); }
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
            java.util.logging.Logger.getLogger(pays_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pays_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pays_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pays_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pays_for().setVisible(true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtConsole;
    private javax.swing.JTextField txtDeveloper;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPlayers;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtRating;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
