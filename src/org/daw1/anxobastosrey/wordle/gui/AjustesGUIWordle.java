/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.daw1.anxobastosrey.wordle.classes.MotorArchivo;
import org.daw1.anxobastosrey.wordle.classes.MotorBase;
import org.daw1.anxobastosrey.wordle.classes.MotorTest;
import org.daw1.anxobastosrey.wordle.enu.Idioma;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class AjustesGUIWordle extends javax.swing.JDialog {

    private IMotorIdioma motor;
    /**
     * Creates new form AjustesGUIWordle
     */
    public AjustesGUIWordle(java.awt.Frame parent, boolean modal, IMotorIdioma motor) {
        super(parent, modal);
        this.motor = motor;
        System.out.println();
        initComponents();
        getSelecciones();
    }

    private AjustesGUIWordle(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void getSelecciones(){
        switch (this.motor.getClass().getSimpleName()) {
            case "MotorBase":
                this.motorBaseJRadioButton.setSelected(true);
                break;
            case "MotorArchivo":
                this.motorArchivoJRadioButton.setSelected(true);
                break;
            default:
                this.motorTestJRadioButton.setSelected(true);
                break;
        }
        switch (this.motor.getIdioma()) {
            case EN:
                this.inglesJRadioButton.setSelected(true);
                break;
            case ES:
                this.castellanoJRadioButton.setSelected(true);
                break;
            case PT:
                this.portuguesJRadioButton.setSelected(true);
                break;
            case FR:
                this.francesJRadioButton.setSelected(true);
                break;
            case GL:
                this.gallegoJRadioButton.setSelected(true);
                break;
            default:
                this.italianoJRadioButton.setSelected(true);
                break;
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

        seleccionarMotorButtonGroup = new javax.swing.ButtonGroup();
        seleccionarTemaButtonGroup = new javax.swing.ButtonGroup();
        seleccionarIdiomaButtonGroup = new javax.swing.ButtonGroup();
        mainJPanel = new javax.swing.JPanel();
        elegirMotorJPanel = new javax.swing.JPanel();
        textoMotorJLabel = new javax.swing.JLabel();
        motorBaseJRadioButton = new javax.swing.JRadioButton();
        motorArchivoJRadioButton = new javax.swing.JRadioButton();
        motorTestJRadioButton = new javax.swing.JRadioButton();
        elegirIdiomaJPanel = new javax.swing.JPanel();
        textoIdiomaJLabel = new javax.swing.JLabel();
        castellanoJRadioButton = new javax.swing.JRadioButton();
        gallegoJRadioButton = new javax.swing.JRadioButton();
        inglesJRadioButton = new javax.swing.JRadioButton();
        portuguesJRadioButton = new javax.swing.JRadioButton();
        italianoJRadioButton = new javax.swing.JRadioButton();
        francesJRadioButton = new javax.swing.JRadioButton();
        elegirTemaJPanel = new javax.swing.JPanel();
        textoTemaJLabel = new javax.swing.JLabel();
        temaClaroJRadioButton = new javax.swing.JRadioButton();
        temaOscuroJRadioButton = new javax.swing.JRadioButton();
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
        mostrarPalabrasJPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAW1 Ajustes Wordle AnxoBastosRey");

        mainJPanel.setMaximumSize(new java.awt.Dimension(400, 400));
        mainJPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        mainJPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        elegirMotorJPanel.setAutoscrolls(true);
        elegirMotorJPanel.setMinimumSize(new java.awt.Dimension(400, 30));
        elegirMotorJPanel.setPreferredSize(new java.awt.Dimension(400, 30));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        elegirMotorJPanel.setLayout(flowLayout1);

        textoMotorJLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoMotorJLabel.setText("Elegir un motor:");
        elegirMotorJPanel.add(textoMotorJLabel);

        seleccionarMotorButtonGroup.add(motorBaseJRadioButton);
        motorBaseJRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        motorBaseJRadioButton.setSelected(true);
        motorBaseJRadioButton.setText("Base de datos");
        motorBaseJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorBaseJRadioButtonActionPerformed(evt);
            }
        });
        elegirMotorJPanel.add(motorBaseJRadioButton);

        seleccionarMotorButtonGroup.add(motorArchivoJRadioButton);
        motorArchivoJRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        motorArchivoJRadioButton.setText("Archivo");
        motorArchivoJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorArchivoJRadioButtonActionPerformed(evt);
            }
        });
        elegirMotorJPanel.add(motorArchivoJRadioButton);

        seleccionarMotorButtonGroup.add(motorTestJRadioButton);
        motorTestJRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        motorTestJRadioButton.setText("Test");
        motorTestJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorTestJRadioButtonActionPerformed(evt);
            }
        });
        elegirMotorJPanel.add(motorTestJRadioButton);

        mainJPanel.add(elegirMotorJPanel);

        elegirIdiomaJPanel.setMinimumSize(new java.awt.Dimension(400, 50));
        elegirIdiomaJPanel.setPreferredSize(new java.awt.Dimension(400, 50));
        elegirIdiomaJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textoIdiomaJLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoIdiomaJLabel.setText("Elegir un idioma:");
        elegirIdiomaJPanel.add(textoIdiomaJLabel);

        seleccionarIdiomaButtonGroup.add(castellanoJRadioButton);
        castellanoJRadioButton.setSelected(true);
        castellanoJRadioButton.setText("Castellano");
        castellanoJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castellanoJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(castellanoJRadioButton);

        seleccionarIdiomaButtonGroup.add(gallegoJRadioButton);
        gallegoJRadioButton.setText("Gallego");
        gallegoJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gallegoJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(gallegoJRadioButton);

        seleccionarIdiomaButtonGroup.add(inglesJRadioButton);
        inglesJRadioButton.setText("Ingles");
        inglesJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(inglesJRadioButton);

        seleccionarIdiomaButtonGroup.add(portuguesJRadioButton);
        portuguesJRadioButton.setText("Portugues");
        portuguesJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portuguesJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(portuguesJRadioButton);

        seleccionarIdiomaButtonGroup.add(italianoJRadioButton);
        italianoJRadioButton.setText("Italiano");
        italianoJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italianoJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(italianoJRadioButton);

        seleccionarIdiomaButtonGroup.add(francesJRadioButton);
        francesJRadioButton.setText("Frances");
        francesJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                francesJRadioButtonActionPerformed(evt);
            }
        });
        elegirIdiomaJPanel.add(francesJRadioButton);

        mainJPanel.add(elegirIdiomaJPanel);

        elegirTemaJPanel.setMinimumSize(new java.awt.Dimension(400, 30));
        elegirTemaJPanel.setPreferredSize(new java.awt.Dimension(400, 30));
        elegirTemaJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textoTemaJLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoTemaJLabel.setText("Elegir un tema:");
        elegirTemaJPanel.add(textoTemaJLabel);

        seleccionarTemaButtonGroup.add(temaClaroJRadioButton);
        temaClaroJRadioButton.setSelected(true);
        temaClaroJRadioButton.setText("Claro");
        elegirTemaJPanel.add(temaClaroJRadioButton);

        seleccionarTemaButtonGroup.add(temaOscuroJRadioButton);
        temaOscuroJRadioButton.setText("Oscuro");
        elegirTemaJPanel.add(temaOscuroJRadioButton);

        mainJPanel.add(elegirTemaJPanel);

        añadirJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadir palabra"));
        añadirJPanel.setMinimumSize(new java.awt.Dimension(400, 105));
        añadirJPanel.setPreferredSize(new java.awt.Dimension(400, 105));
        añadirJPanel.setLayout(new java.awt.GridLayout(2, 0));

        insertarJTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        insertarJTextField.setActionCommand("<Not Set>");
        insertarJTextField.setMinimumSize(new java.awt.Dimension(120, 22));
        insertarJTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        insertarJPanel.add(insertarJTextField);

        insertarJButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        insertarJButton.setText("Añadir");
        insertarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarJButtonActionPerformed(evt);
            }
        });
        insertarJPanel.add(insertarJButton);

        añadirJPanel.add(insertarJPanel);

        estadoInsertarJPanel.setLayout(new java.awt.GridLayout());

        estadoInsertarJLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        estadoInsertarJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoInsertarJLabel.setText("Inserte la palabra que desea añadir");
        estadoInsertarJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estadoInsertarJPanel.add(estadoInsertarJLabel);

        añadirJPanel.add(estadoInsertarJPanel);

        mainJPanel.add(añadirJPanel);

        borrarJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Borrar palabra"));
        borrarJPanel.setMinimumSize(new java.awt.Dimension(400, 105));
        borrarJPanel.setPreferredSize(new java.awt.Dimension(400, 105));
        borrarJPanel.setLayout(new java.awt.GridLayout(2, 1));

        eliminarJPanel.setMinimumSize(new java.awt.Dimension(207, 30));
        eliminarJPanel.setPreferredSize(new java.awt.Dimension(207, 30));

        eliminarJTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        eliminarJTextField.setMinimumSize(new java.awt.Dimension(120, 22));
        eliminarJTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        eliminarJPanel.add(eliminarJTextField);

        eliminarJButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        eliminarJButton.setText("Borrar");
        eliminarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJButtonActionPerformed(evt);
            }
        });
        eliminarJPanel.add(eliminarJButton);

        borrarJPanel.add(eliminarJPanel);

        estadoEliminarJPanel.setMinimumSize(new java.awt.Dimension(200, 30));
        estadoEliminarJPanel.setPreferredSize(new java.awt.Dimension(200, 30));
        estadoEliminarJPanel.setLayout(new java.awt.GridLayout(1, 1));

        estadoEliminarJLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        estadoEliminarJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoEliminarJLabel.setText("Inserte la palabra que desea borrar");
        estadoEliminarJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estadoEliminarJPanel.add(estadoEliminarJLabel);

        borrarJPanel.add(estadoEliminarJPanel);

        mainJPanel.add(borrarJPanel);

        mostrarPalabrasJPanel.setPreferredSize(new java.awt.Dimension(400, 40));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setText("Mostrar palabras");
        mostrarPalabrasJPanel.add(jButton1);

        mainJPanel.add(mostrarPalabrasJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJButtonActionPerformed
        try {
            if(this.eliminarJTextField.getText().length() == 5) {
                motor.borrarPalabra(this.eliminarJTextField.getText());
                this.estadoEliminarJLabel.setText("La palabra se ha borrado con exito");
            }
            else{
                this.estadoEliminarJLabel.setText("ERROR: La palabra tiene que estar formada por 5 letras");
            }
        } catch (IOException ex) {
            Logger.getLogger(AjustesGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AjustesGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarJButtonActionPerformed

    private void motorBaseJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorBaseJRadioButtonActionPerformed
        this.motor = new MotorBase(this.motor.getIdioma());
    }//GEN-LAST:event_motorBaseJRadioButtonActionPerformed

    private void motorArchivoJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorArchivoJRadioButtonActionPerformed
        this.motor = new MotorArchivo(this.motor.getIdioma());
    }//GEN-LAST:event_motorArchivoJRadioButtonActionPerformed

    private void motorTestJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorTestJRadioButtonActionPerformed
        this.motor = new MotorTest();
    }//GEN-LAST:event_motorTestJRadioButtonActionPerformed

    private void insertarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarJButtonActionPerformed
        try {
            if(this.insertarJTextField.getText().length() == 5) {
                motor.añadirPalabra(this.insertarJTextField.getText());
                this.estadoInsertarJLabel.setText("La palabra se ha insertado con exito");
            }
            else{
                this.estadoInsertarJLabel.setText("ERROR: La palabra tiene que estar formada por 5 letras");
            }
        } catch (IOException ex) {
            Logger.getLogger(AjustesGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AjustesGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertarJButtonActionPerformed

    public void seleccionarIdioma(Idioma idioma){
        if(this.motorArchivoJRadioButton.isSelected()) {
            this.motor = new MotorArchivo(idioma);
        }
        else if(this.motorBaseJRadioButton.isSelected()){
            this.motor = new MotorBase(idioma);
        }
        else{
            this.motor = new MotorTest();
        }
    }
    
    private void castellanoJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_castellanoJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.ES);
    }//GEN-LAST:event_castellanoJRadioButtonActionPerformed

    private void gallegoJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gallegoJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.GL);
    }//GEN-LAST:event_gallegoJRadioButtonActionPerformed

    private void inglesJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.EN);
    }//GEN-LAST:event_inglesJRadioButtonActionPerformed

    private void portuguesJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portuguesJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.PT);
    }//GEN-LAST:event_portuguesJRadioButtonActionPerformed

    private void italianoJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italianoJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.IT);
    }//GEN-LAST:event_italianoJRadioButtonActionPerformed

    private void francesJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_francesJRadioButtonActionPerformed
        seleccionarIdioma(Idioma.FR);
    }//GEN-LAST:event_francesJRadioButtonActionPerformed

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
    private javax.swing.JPanel añadirJPanel;
    private javax.swing.JPanel borrarJPanel;
    private javax.swing.JRadioButton castellanoJRadioButton;
    private javax.swing.JPanel elegirIdiomaJPanel;
    private javax.swing.JPanel elegirMotorJPanel;
    private javax.swing.JPanel elegirTemaJPanel;
    private javax.swing.JButton eliminarJButton;
    private javax.swing.JPanel eliminarJPanel;
    private javax.swing.JTextField eliminarJTextField;
    private javax.swing.JLabel estadoEliminarJLabel;
    private javax.swing.JPanel estadoEliminarJPanel;
    private javax.swing.JLabel estadoInsertarJLabel;
    private javax.swing.JPanel estadoInsertarJPanel;
    private javax.swing.JRadioButton francesJRadioButton;
    private javax.swing.JRadioButton gallegoJRadioButton;
    private javax.swing.JRadioButton inglesJRadioButton;
    private javax.swing.JButton insertarJButton;
    private javax.swing.JPanel insertarJPanel;
    private javax.swing.JTextField insertarJTextField;
    private javax.swing.JRadioButton italianoJRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JPanel mostrarPalabrasJPanel;
    private javax.swing.JRadioButton motorArchivoJRadioButton;
    private javax.swing.JRadioButton motorBaseJRadioButton;
    private javax.swing.JRadioButton motorTestJRadioButton;
    private javax.swing.JRadioButton portuguesJRadioButton;
    private javax.swing.ButtonGroup seleccionarIdiomaButtonGroup;
    private javax.swing.ButtonGroup seleccionarMotorButtonGroup;
    private javax.swing.ButtonGroup seleccionarTemaButtonGroup;
    private javax.swing.JRadioButton temaClaroJRadioButton;
    private javax.swing.JRadioButton temaOscuroJRadioButton;
    private javax.swing.JLabel textoIdiomaJLabel;
    private javax.swing.JLabel textoMotorJLabel;
    private javax.swing.JLabel textoTemaJLabel;
    // End of variables declaration//GEN-END:variables
}
