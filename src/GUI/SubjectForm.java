package GUI;

import Model.Subject;
import Model.SubjectHelper;
import Model.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SubjectForm extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    public SubjectForm() {
        initComponents();
    }
    
    User user;
    ArrayList<Subject> sub = new ArrayList<>();
    public SubjectForm(User u) {
        initComponents();
        user = u;
        SubjectHelper ss = new SubjectHelper();
        
        sub=(ArrayList<Subject>)ss.SelectAll(user.getId());
        subjectTable.setModel(dtm);
        dtm.addColumn("subjectid");
        dtm.addColumn("subject");
        for(int i=0;i<sub.size();i++){
            dtm.addRow(new Object[]{sub.get(i).getId(),sub.get(i).getSubject()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addSub = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        savechanges = new javax.swing.JButton();
        DeleteSubject = new javax.swing.JButton();
        showTasks = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        addSub.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addSub.setText("add Subject");
        addSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubActionPerformed(evt);
            }
        });
        getContentPane().add(addSub);
        addSub.setBounds(210, 220, 140, 30);

        subjectTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SubjectId", "Subject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(subjectTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 380, 130);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("To Do List");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 69, 17);

        Title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleActionPerformed(evt);
            }
        });
        getContentPane().add(Title);
        Title.setBounds(20, 220, 160, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("New Subject");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 200, 90, 15);

        savechanges.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savechanges.setText("Save");
        savechanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savechangesActionPerformed(evt);
            }
        });
        getContentPane().add(savechanges);
        savechanges.setBounds(210, 320, 140, 40);

        DeleteSubject.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteSubject.setText("Delete");
        DeleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteSubject);
        DeleteSubject.setBounds(210, 270, 140, 30);

        showTasks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showTasks.setText("Show Tasks");
        showTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTasksActionPerformed(evt);
            }
        });
        getContentPane().add(showTasks);
        showTasks.setBounds(50, 280, 110, 40);

        Logout.setBackground(new java.awt.Color(0, 0, 0));
        Logout.setForeground(new java.awt.Color(51, 51, 51));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/inside-logout-icon.png"))); // NOI18N
        Logout.setText("logout");
        Logout.setContentAreaFilled(false);
        Logout.setFocusPainted(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout);
        Logout.setBounds(50, 0, 100, 50);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTasksActionPerformed
        // TODO add your handling code here:
        int row= subjectTable.getSelectedRow();
        if(row!=-1){
        int SubId=(int)subjectTable.getValueAt(row, 0);
        TaskForm atask=new TaskForm(SubId);
        atask.setLocation(400, 200);
        atask.setSize(350,350);
        atask.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_showTasksActionPerformed

    private void addSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubActionPerformed
        Subject subject = new Subject();
        SubjectHelper subjecthelper = new SubjectHelper();
        if(!Title.getText().isEmpty())
        {
            subject.setSubject(Title.getText());
            if(!(Title.getText().isEmpty())){
                subjecthelper.AddSubject(subject, user.getId());
                JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                SubjectForm k = new SubjectForm(user);
                k.setVisible(true);
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "Please enter a subject name", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addSubActionPerformed

    private void DeleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSubjectActionPerformed
        int row= subjectTable.getSelectedRow();
        if(row!=-1){
        int SubId=(int)subjectTable.getValueAt(row, 0);
        System.out.println(SubId);
        SubjectHelper subjecthelper = new SubjectHelper();
        subjecthelper.DeleteSubject(SubId);
        JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        SubjectForm k = new SubjectForm(user);
        k.setVisible(true);
        }else{
             JOptionPane.showMessageDialog(null, "Please select a subject first", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteSubjectActionPerformed

    private void TitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleActionPerformed

    private void savechangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savechangesActionPerformed
        for(int i=0;i<sub.size();i++){
            SubjectHelper subb = new SubjectHelper();
            subb.UpdateSubject((String) subjectTable.getValueAt(i, 1), (int) subjectTable.getValueAt(i, 0));
        }
        JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        SubjectForm k = new SubjectForm(user);
        k.setVisible(true);
    }//GEN-LAST:event_savechangesActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        LoginForm sub=new LoginForm();
        sub.setLocation(400, 400);
        sub.setSize(350, 350);
        sub.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteSubject;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField Title;
    private javax.swing.JButton addSub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savechanges;
    private javax.swing.JButton showTasks;
    private javax.swing.JTable subjectTable;
    // End of variables declaration//GEN-END:variables
}
