/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.gui;

/**
 *
 * @author AnxoN
 */
public class AjustesGUIWordle extends javax.swing.JDialog {

    /**
     * Creates new form AjustesGUIWordle
     */
    public AjustesGUIWordle(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionarMotorButtonGroup = new javax.swing.ButtonGroup();
        mainJPanel = new javax.swing.JPanel();
        tituloJPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ajustesJPanel = new javax.swing.JPanel();
        añadirJPanel = new javax.swing.JPanel();
        insertarJPanel = new javax.swing.JPanel();
        insertarJTextField = new javax.swing.JTextField();
        insertarJButton = new javax.swing.JButton();
        estadoInsertarJPanel = new javax.swing.JPanel();
        estadoInsertarJLabel = new javax.swing.JLabel();
        borrarJPanel = new javax.swing.JPanel();
        eliminarJPanel = new javax.swing.JPanel();
        eliminarJTextField = new javax.swing.JTextField();
        eliminarJButton = new javax.swing.JButton();
        estadoEliminarJPanel = new javax.swing.JPanel();
        estadoEliminarJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAW1 Ajustes Wordle AnxoBastosRey");

        mainJPanel.setPreferredSize(new java.awt.Dimension(300, 300));
        mainJPanel.setLayout(new java.awt.BorderLayout());

        tituloJPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        tituloJPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        tituloJPanel.setLayout(new java.awt.GridLayout(2, 1));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Elegir un motor:");
        jPanel1.add(jLabel1);

        seleccionarMotorButtonGroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton1.setText("Base de datos");
        jPanel1.add(jRadioButton1);

        seleccionarMotorButtonGroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton2.setText("Archivo");
        jPanel1.add(jRadioButton2);

        seleccionarMotorButtonGroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton3.setText("Test");
        jPanel1.add(jRadioButton3);

        tituloJPanel.add(jPanel1);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setText("Mostrar palabras");
        jPanel2.add(jButton1);

        tituloJPanel.add(jPanel2);

        mainJPanel.add(tituloJPanel, java.awt.BorderLayout.PAGE_START);

        ajustesJPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        ajustesJPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        ajustesJPanel.setLayout(new java.awt.GridLayout(2, 1));

        añadirJPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 51), 3, true));
        añadirJPanel.setLayout(new java.awt.GridLayout(2, 1));

        insertarJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        insertarJTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        insertarJTextField.setMinimumSize(new java.awt.Dimension(120, 22));
        insertarJTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        insertarJPanel.add(insertarJTextField);

        insertarJButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        insertarJButton.setText("Añadir");
        insertarJPanel.add(insertarJButton);

        añadirJPanel.add(insertarJPanel);

        estadoInsertarJPanel.setLayout(new java.awt.GridLayout(1, 1));

        estadoInsertarJLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        estadoInsertarJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoInsertarJLabel.setText("Inserte la palabra que desea añadir");
        estadoInsertarJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estadoInsertarJPanel.add(estadoInsertarJLabel);

        añadirJPanel.add(estadoInsertarJPanel);

        ajustesJPanel.add(añadirJPanel);

        borrarJPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
        borrarJPanel.setLayout(new java.awt.GridLayout(2, 1));

        eliminarJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        eliminarJTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        eliminarJTextField.setMinimumSize(new java.awt.Dimension(120, 22));
        eliminarJTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        eliminarJPanel.add(eliminarJTextField);

        eliminarJButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        eliminarJButton.setText("Borrar");
        eliminarJPanel.add(eliminarJButton);

        borrarJPanel.add(eliminarJPanel);

        estadoEliminarJPanel.setLayout(new java.awt.GridLayout(1, 1));

        estadoEliminarJLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        estadoEliminarJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoEliminarJLabel.setText("Inserte la palabra que desea borrar");
        estadoEliminarJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estadoEliminarJPanel.add(estadoEliminarJLabel);

        borrarJPanel.add(estadoEliminarJPanel);

        ajustesJPanel.add(borrarJPanel);

        mainJPanel.add(ajustesJPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AjustesGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjustesGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjustesGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjustesGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjustesGUIWordle dialog = new AjustesGUIWordle(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ajustesJPanel;
    private javax.swing.JPanel añadirJPanel;
    private javax.swing.JPanel borrarJPanel;
    private javax.swing.JButton eliminarJButton;
    private javax.swing.JPanel eliminarJPanel;
    private javax.swing.JTextField eliminarJTextField;
    private javax.swing.JLabel estadoEliminarJLabel;
    private javax.swing.JPanel estadoEliminarJPanel;
    private javax.swing.JLabel estadoInsertarJLabel;
    private javax.swing.JPanel estadoInsertarJPanel;
    private javax.swing.JButton insertarJButton;
    private javax.swing.JPanel insertarJPanel;
    private javax.swing.JTextField insertarJTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.ButtonGroup seleccionarMotorButtonGroup;
    private javax.swing.JPanel tituloJPanel;
    // End of variables declaration//GEN-END:variables
}
