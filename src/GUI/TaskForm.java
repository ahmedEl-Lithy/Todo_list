package GUI;

import Model.Task;
import Model.TaskHelper;
import Model.User;
import Model.UserHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TaskForm extends javax.swing.JFrame {

    /**
     * Creates new form add_Task
     */
    private int subjectID;
    ArrayList<Task>utasks=new ArrayList<>();
    DefaultTableModel dtm = new DefaultTableModel();
    public TaskForm(int subId) {
        initComponents();
        TaskHelper tsh=new TaskHelper();
        //Task tsk=new Task();
        this.subjectID=(int)subId;
        utasks=(ArrayList<Task>)tsh.SelectAll(subjectID);
        taskTable.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("Task");
        for(int i=0;i<utasks.size();i++){
            dtm.addRow(new Object[]{utasks.get(i).getId(),utasks.get(i).getTask()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addTask = new javax.swing.JButton();
        Title = new javax.swing.JTextField();
        deleteTask = new javax.swing.JButton();
        savechanges = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 380));
        setResizable(false);
        getContentPane().setLayout(null);

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Task"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(taskTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 350, 140);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("To Do List");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(173, 13, 69, 17);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Task");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 200, 27, 14);

        addTask.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addTask.setText("add");
        addTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskActionPerformed(evt);
            }
        });
        getContentPane().add(addTask);
        addTask.setBounds(240, 210, 103, 30);

        Title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleActionPerformed(evt);
            }
        });
        getContentPane().add(Title);
        Title.setBounds(30, 220, 160, 30);

        deleteTask.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteTask.setText("Delete");
        deleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskActionPerformed(evt);
            }
        });
        getContentPane().add(deleteTask);
        deleteTask.setBounds(240, 250, 103, 30);

        savechanges.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savechanges.setText("Save");
        savechanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savechangesActionPerformed(evt);
            }
        });
        getContentPane().add(savechanges);
        savechanges.setBounds(240, 300, 100, 30);

        Back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(70, 300, 70, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskActionPerformed
        // TODO add your handling code here:
        Task tsk = new Task();
        TaskHelper tskhp = new TaskHelper();
        if(!Title.getText().isEmpty())
        {
           tsk.setTask(Title.getText());
            if(!(Title.getText().isEmpty())){
                tskhp.AddTask(tsk, subjectID);
                JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                TaskForm t = new TaskForm(subjectID);
                t.setVisible(true);
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "Please enter a Task name", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addTaskActionPerformed

    private void deleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskActionPerformed
        // TODO add your handling code here:
        int row= taskTable.getSelectedRow();
        if(row!=-1){
        int tskid=(int)taskTable.getValueAt(row, 0);
        TaskHelper tskhelper = new TaskHelper();
        tskhelper.DeleteTask(tskid);
        JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        TaskForm k = new TaskForm(subjectID);
        k.setVisible(true);
        }else{
             JOptionPane.showMessageDialog(null, "Please select a subject first", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteTaskActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       User u=new User();
        UserHelper uh=new UserHelper();
        u=uh.getUser_sub(subjectID);
        SubjectForm sub=new SubjectForm(u);
        sub.setLocation(400, 400);
        sub.setSize(350, 350);
        sub.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void TitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleActionPerformed

    private void savechangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savechangesActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<utasks.size();i++){
            TaskHelper tsk = new TaskHelper();
            Task mytsk=new Task();
            mytsk.setId((int) taskTable.getValueAt(i, 0));
            mytsk.setTask((String) taskTable.getValueAt(i, 1));
            tsk.UpdateTask(mytsk);
        }
        JOptionPane.showMessageDialog(null, "Done !", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        TaskForm k = new TaskForm(subjectID);
        k.setVisible(true);
    }//GEN-LAST:event_savechangesActionPerformed

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
            java.util.logging.Logger.getLogger(TaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new add_Task().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Title;
    private javax.swing.JButton addTask;
    private javax.swing.JButton deleteTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savechanges;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables
}
