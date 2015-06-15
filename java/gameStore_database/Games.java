package testGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Games extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    
    public Games() {
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
            String query = "select games_id, game_name, game_type, esrb_rating, game_developer, number_of_players, game_console, game_price from games";
            rs = stmt.executeQuery(query);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        txtRating = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDeveloper = new javax.swing.JTextField();
        dtnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPlayers = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtConsole = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Games");

        jLabel3.setText("Rating");

        jLabel4.setText("Type");

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

        jLabel2.setText("Name");

        jLabel1.setText("ID");

        dtnAdd.setText("New Record");
        dtnAdd.setMaximumSize(new java.awt.Dimension(105, 23));
        dtnAdd.setMinimumSize(new java.awt.Dimension(105, 23));
        dtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Developer");

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

        jLabel6.setText("Players");

        jLabel7.setText("Console");

        jLabel8.setText("Price");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(txtType, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRating, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(txtConsole)
                                    .addComponent(txtPlayers))))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
            String A = rs.getString("games_id");
            String B = rs.getString("game_name");
            String C = rs.getString("game_type");
            String D = rs.getString("esrb_rating");
            String E = rs.getString("game_developer");
            String F = rs.getString("number_of_players");
            String G = rs.getString("game_console");
            String H = rs.getString("game_price");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

        try {
            if (rs.previous()){
                String A = rs.getString("games_id");
                String B = rs.getString("game_name");
                String C = rs.getString("game_type");
                String D = rs.getString("esrb_rating");
                String E = rs.getString("game_developer");
                String F = rs.getString("number_of_players");
                String G = rs.getString("game_console");
                String H = rs.getString("game_price");
                txtID.setText(A);
                txtName.setText(B);
                txtType.setText(C);
                txtRating.setText(D);
                txtDeveloper.setText(E);
                txtPlayers.setText(F);
                txtConsole.setText(G);
                txtPrice.setText(H);
            } else {
                JOptionPane.showMessageDialog(Games.this, "Start of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {
                String A = rs.getString("games_id");
                String B = rs.getString("game_name");
                String C = rs.getString("game_type");
                String D = rs.getString("esrb_rating");
                String E = rs.getString("game_developer");
                String F = rs.getString("number_of_players");
                String G = rs.getString("game_console");
                String H = rs.getString("game_price");
                txtID.setText(A);
                txtName.setText(B);
                txtType.setText(C);
                txtRating.setText(D);
                txtDeveloper.setText(E);
                txtPlayers.setText(F);
                txtConsole.setText(G);
                txtPrice.setText(H);
            } else {
                JOptionPane.showMessageDialog(Games.this, "End of Database");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {
            rs.last();
            String A = rs.getString("games_id");
            String B = rs.getString("game_name");
            String C = rs.getString("game_type");
            String D = rs.getString("esrb_rating");
            String E = rs.getString("game_developer");
            String F = rs.getString("number_of_players");
            String G = rs.getString("game_console");
            String H = rs.getString("game_price");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnLastActionPerformed

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
            rs.updateString("games_id", A);
            rs.updateString("game_name", B);
            rs.updateString("game_type", C);
            rs.updateString("esrb_rating", D);
            rs.updateString("game_developer", E);
            rs.updateString("number_of_players", F);
            rs.updateString("game_console", G);
            rs.updateString("game_price", H);
            rs.updateRow();
            JOptionPane.showMessageDialog(Games.this, "Updated");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            rs.deleteRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select games_id, game_name, game_type, esrb_rating, game_developer, number_of_players, game_console, game_price from games";
            rs = stmt.executeQuery(query);
            rs.next();
            String A = rs.getString("games_id");
            String B = rs.getString("game_name");
            String C = rs.getString("game_type");
            String D = rs.getString("esrb_rating");
            String E = rs.getString("game_developer");
            String F = rs.getString("number_of_players");
            String G = rs.getString("game_console");
            String H = rs.getString("game_price");
            txtID.setText(A);
            txtName.setText(B);
            txtType.setText(C);
            txtRating.setText(D);
            txtDeveloper.setText(E);
            txtPlayers.setText(F);
            txtConsole.setText(G);
            txtPrice.setText(H);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }

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
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }

    }//GEN-LAST:event_dtnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            rs.absolute( curRow );
            txtID.setText( rs.getString("games_id"));
            txtType.setText( rs.getString("game_name"));
            txtName.setText( rs.getString("game_type"));
            txtRating.setText( rs.getString("esrb_rating" ));
            txtDeveloper.setText(rs.getString("game_develoer"));
            txtPlayers.setText(rs.getString("number_of_players"));
            txtConsole.setText(rs.getString("game_console"));
            txtPrice.setText(rs.getString("game_price"));
            
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
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }
    }//GEN-LAST:event_btnCancelActionPerformed

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
            rs.updateString("games_id", A);
            rs.updateString("game_name", B);
            rs.updateString("game_type", C);
            rs.updateString("esrb_rating", D);
            rs.updateString("game_developer", E);
            rs.updateString("number_of_players", F);
            rs.updateString("game_console", G);
            rs.updateString("game_price", H);
            rs.insertRow();
            stmt.close();
            rs.close();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select games_id, game_name, game_type, esrb_rating, game_developer, number_of_players, game_console, game_price from games";
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
            JOptionPane.showMessageDialog(Games.this, err.getMessage()); }

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
            java.util.logging.Logger.getLogger(Games.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Games.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Games.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Games.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Games().setVisible(true);
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
