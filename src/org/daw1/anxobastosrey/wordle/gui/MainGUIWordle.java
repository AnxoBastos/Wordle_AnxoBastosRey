/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.gui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;
import org.daw1.anxobastosrey.wordle.classes.MotorArchivo;
import org.daw1.anxobastosrey.wordle.classes.PairMotorTema;
import org.daw1.anxobastosrey.wordle.enu.Idioma;

/**
 *
 * @author AnxoN
 */
public class MainGUIWordle extends javax.swing.JFrame{
    
    //*****************************CONSTANTES*****************************//
    
    private static final java.awt.Color VERDE_LETRAS = new java.awt.Color(102,255,51);
    private static final java.awt.Color AMARILLO_LETRAS = new java.awt.Color(255,204,51);
    private static final java.awt.Color ROJO_LETRAS = new java.awt.Color(255,51,51);
    
    protected static final java.awt.Color FONDO_LETRAS_OSCURO = new java.awt.Color(153,153,153);
    protected static final java.awt.Color FONDO_BOTTOM_OSCURO = new java.awt.Color(102,102,102);
    protected static final java.awt.Color FONDO_MENU_TEXTFIELD_OSCURO = new java.awt.Color(51,51,51);
    
    protected static final java.awt.Color FONDO_BUTTOM_OSCURO_COLOR_LETRAS_CLARO = new java.awt.Color(0,0,0);
    protected static final java.awt.Color COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO = new java.awt.Color(255,255,255);
    protected static final java.awt.Color FONDO_BOTTOM_CLARO = new java.awt.Color(204,204,255);
    
    private static final int MAX_INTENTOS = 6;
    private static final int TAMANHO_PALABRA = 5;
    
    public static final File CARPETA = new File(Paths.get(".") + File.separator + "data");
    private static final File GUARDADO = new File(Paths.get(".") + File.separator + "data" + File.separator + "guardado.dat");
    
    private static final javax.swing.JLabel[][] LABELS = new javax.swing.JLabel[MAX_INTENTOS][TAMANHO_PALABRA];
    private static final Map<String, Set<Character>> LETRAS = new HashMap<>();
    
    //*****************************VARIABLES*****************************//
    
    private String palabraDelDia;
    private IMotorIdioma motor = new MotorArchivo(Idioma.ES);
    private int intentos = 0;
    private Boolean tema = false;
    
    //*****************************CONSTRUCTOR*****************************//

    /**
     * Creates new form MainGUIWordle
     */
    public MainGUIWordle() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        if (cargarMotor() != null) {
            PairMotorTema c = cargarMotor();
            this.motor = (IMotorIdioma)c.getMotor();
            this.tema = (Boolean)c.getTema();
        }
        seleccionarTema();
        this.palabraDelDia = motor.generarPalabra();
        
        LETRAS.put("GOOD", new TreeSet<>());
        LETRAS.put("EXISTS", new TreeSet<>()); 
        
        LETRAS.put("GOODTOTAL", new TreeSet<>());
        LETRAS.put("EXISTSTOTAL", new TreeSet<>());
        LETRAS.put("WRONGTOTAL", new TreeSet<>());
        
        rellenarMatrizLabels();
        
        System.out.println(palabraDelDia);
    }
    
    //*****************************JUEGO*****************************//
    
    private void rellenarMatrizLabels(){
        for (int i = 1; i <= MAX_INTENTOS; i++) {
            for (int j = 1; j <= TAMANHO_PALABRA; j++) {
                try {
                    String nombreLabel = "jLabel" + i + "x" + j;
                    javax.swing.JLabel aux = (javax.swing.JLabel) this.getClass().getDeclaredField(nombreLabel).get(this);
                    LABELS[i-1][j-1] = aux;
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    public void rellenarLabels(int fila, String palabra){
        JLabel[] label = LABELS[fila];
        for (int i = 0; i < label.length; i++) {
            JLabel j = label[i];
            Character a = palabra.charAt(i);
            if (LETRAS.get("GOOD").contains(a) && !LETRAS.get("EXISTS").contains(a)){
                j.setText(a.toString()); 
                j.setForeground(VERDE_LETRAS);
            }
            else if(LETRAS.get("GOOD").contains(a) && LETRAS.get("EXISTS").contains(a)){
                if (palabraDelDia.charAt(i) == a) {
                    j.setText(a.toString()); 
                    j.setForeground(VERDE_LETRAS);
                }
                else{
                    j.setText(a.toString());
                }
            }
            else if(LETRAS.get("EXISTS").contains(a) && !LETRAS.get("GOOD").contains(a)){
                j.setText(a.toString()); 
                j.setForeground(AMARILLO_LETRAS);
            }
            else{
                j.setText(a.toString()); 
                j.setForeground(ROJO_LETRAS);
            }            
        }
        LETRAS.get("GOOD").clear();
        LETRAS.get("EXISTS").clear();
    }
    
    public void comprobarLetras(String actual){
        for(int i = 0; i < this.palabraDelDia.length(); i++) {
            for (int j = 0; j < actual.length(); j++) {
                Character ch = actual.charAt(j);
                if(this.palabraDelDia.contains(ch.toString())){
                    if(this.palabraDelDia.charAt(i) == actual.charAt(i)){
                        this.LETRAS.get("GOOD").add(actual.charAt(i));
                        //letras.get("GOODTOTAL").add(actual.get(i));
                        //letras.get("EXISTSTOTAL").remove(actual.get(i));
                    }
                    else{
                        this.LETRAS.get("EXISTS").add(actual.charAt(j));
                        //letras.get("EXISTSTOTAL").add(actual.get(j));
                    }
                }
                else{
                    //letras.get("WRONGTOTAL").add(actual.get(j));
                }
            }
        }
    }

    //*****************************TEMAS*****************************//
    
    private void seleccionarTema(){
        if(this.tema == true){
            this.lettersJPanel.setBackground(FONDO_LETRAS_OSCURO);
            this.goodLettersJPanel.setBackground(FONDO_BOTTOM_OSCURO);
            this.existsLettersJPanel.setBackground(FONDO_BOTTOM_OSCURO);
            this.wrongLettersJPanel.setBackground(FONDO_BOTTOM_OSCURO);
            this.inputJPanel.setBackground(FONDO_BOTTOM_OSCURO);
            this.messagesJPanel.setBackground(FONDO_BOTTOM_OSCURO);
            this.wordJTextField.setBackground(FONDO_MENU_TEXTFIELD_OSCURO);
            this.wordJTextField.setForeground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
            this.sendJButton.setBackground(FONDO_BUTTOM_OSCURO_COLOR_LETRAS_CLARO);
            this.sendJButton.setForeground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
            this.messagesJLabel.setForeground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
        }
        else{
            this.lettersJPanel.setBackground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
            this.goodLettersJPanel.setBackground(FONDO_BOTTOM_CLARO);
            this.existsLettersJPanel.setBackground(FONDO_BOTTOM_CLARO);
            this.wrongLettersJPanel.setBackground(FONDO_BOTTOM_CLARO);
            this.inputJPanel.setBackground(FONDO_BOTTOM_CLARO);
            this.messagesJPanel.setBackground(FONDO_BOTTOM_CLARO);
            this.wordJTextField.setBackground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
            this.wordJTextField.setForeground(FONDO_BUTTOM_OSCURO_COLOR_LETRAS_CLARO);
            this.sendJButton.setBackground(COLOR_LETRAS_OSCURO_FONDO_LETRAS_TEXTFIELD_BUTTOM_CLARO);
            this.sendJButton.setForeground(FONDO_BUTTOM_OSCURO_COLOR_LETRAS_CLARO);
            this.messagesJLabel.setForeground(FONDO_BUTTOM_OSCURO_COLOR_LETRAS_CLARO);
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

        mainJPanel = new javax.swing.JPanel();
        lettersJPanel = new javax.swing.JPanel();
        jLabel1x1 = new javax.swing.JLabel();
        jLabel1x2 = new javax.swing.JLabel();
        jLabel1x3 = new javax.swing.JLabel();
        jLabel1x4 = new javax.swing.JLabel();
        jLabel1x5 = new javax.swing.JLabel();
        jLabel2x1 = new javax.swing.JLabel();
        jLabel2x2 = new javax.swing.JLabel();
        jLabel2x3 = new javax.swing.JLabel();
        jLabel2x4 = new javax.swing.JLabel();
        jLabel2x5 = new javax.swing.JLabel();
        jLabel3x1 = new javax.swing.JLabel();
        jLabel3x2 = new javax.swing.JLabel();
        jLabel3x3 = new javax.swing.JLabel();
        jLabel3x4 = new javax.swing.JLabel();
        jLabel3x5 = new javax.swing.JLabel();
        jLabel4x1 = new javax.swing.JLabel();
        jLabel4x2 = new javax.swing.JLabel();
        jLabel4x3 = new javax.swing.JLabel();
        jLabel4x4 = new javax.swing.JLabel();
        jLabel4x5 = new javax.swing.JLabel();
        jLabel5x1 = new javax.swing.JLabel();
        jLabel5x2 = new javax.swing.JLabel();
        jLabel5x3 = new javax.swing.JLabel();
        jLabel5x4 = new javax.swing.JLabel();
        jLabel5x5 = new javax.swing.JLabel();
        jLabel6x1 = new javax.swing.JLabel();
        jLabel6x2 = new javax.swing.JLabel();
        jLabel6x3 = new javax.swing.JLabel();
        jLabel6x4 = new javax.swing.JLabel();
        jLabel6x5 = new javax.swing.JLabel();
        bottomJPanel = new javax.swing.JPanel();
        leftBottomJPanel = new javax.swing.JPanel();
        goodLettersJPanel = new javax.swing.JPanel();
        goodLettersJLabel = new javax.swing.JLabel();
        existsLettersJPanel = new javax.swing.JPanel();
        existsLettersJLabel = new javax.swing.JLabel();
        wrongLettersJPanel = new javax.swing.JPanel();
        wrongLettersJLabel = new javax.swing.JLabel();
        rightBottomJPanel = new javax.swing.JPanel();
        inputJPanel = new javax.swing.JPanel();
        wordJTextField = new javax.swing.JTextField();
        sendJButton = new javax.swing.JButton();
        messagesJPanel = new javax.swing.JPanel();
        messagesJLabel = new javax.swing.JLabel();
        mainJMenuBar = new javax.swing.JMenuBar();
        juegoJMenu = new javax.swing.JMenu();
        nuevaPartidaJMenuItem = new javax.swing.JMenuItem();
        salirJuegoMenuItem = new javax.swing.JMenuItem();
        ajustesJMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DAW1 Wordle AnxoBastosRey");
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainJPanel.setLayout(new java.awt.BorderLayout());

        lettersJPanel.setBackground(new java.awt.Color(255, 255, 255));
        lettersJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lettersJPanel.setForeground(new java.awt.Color(204, 204, 255));
        lettersJPanel.setLayout(new java.awt.GridLayout(6, 5));

        jLabel1x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1x1.setText("?");
        jLabel1x1.setToolTipText("");
        lettersJPanel.add(jLabel1x1);

        jLabel1x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1x2.setText("?");
        jLabel1x2.setToolTipText("");
        lettersJPanel.add(jLabel1x2);

        jLabel1x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1x3.setText("?");
        jLabel1x3.setToolTipText("");
        lettersJPanel.add(jLabel1x3);

        jLabel1x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1x4.setText("?");
        jLabel1x4.setToolTipText("");
        lettersJPanel.add(jLabel1x4);

        jLabel1x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1x5.setText("?");
        jLabel1x5.setToolTipText("");
        lettersJPanel.add(jLabel1x5);

        jLabel2x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2x1.setText("?");
        jLabel2x1.setToolTipText("");
        lettersJPanel.add(jLabel2x1);

        jLabel2x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2x2.setText("?");
        jLabel2x2.setToolTipText("");
        lettersJPanel.add(jLabel2x2);

        jLabel2x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2x3.setText("?");
        jLabel2x3.setToolTipText("");
        lettersJPanel.add(jLabel2x3);

        jLabel2x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2x4.setText("?");
        jLabel2x4.setToolTipText("");
        lettersJPanel.add(jLabel2x4);

        jLabel2x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2x5.setText("?");
        jLabel2x5.setToolTipText("");
        lettersJPanel.add(jLabel2x5);

        jLabel3x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3x1.setText("?");
        jLabel3x1.setToolTipText("");
        lettersJPanel.add(jLabel3x1);

        jLabel3x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3x2.setText("?");
        jLabel3x2.setToolTipText("");
        lettersJPanel.add(jLabel3x2);

        jLabel3x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3x3.setText("?");
        jLabel3x3.setToolTipText("");
        lettersJPanel.add(jLabel3x3);

        jLabel3x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3x4.setText("?");
        jLabel3x4.setToolTipText("");
        lettersJPanel.add(jLabel3x4);

        jLabel3x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3x5.setText("?");
        jLabel3x5.setToolTipText("");
        lettersJPanel.add(jLabel3x5);

        jLabel4x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4x1.setText("?");
        jLabel4x1.setToolTipText("");
        lettersJPanel.add(jLabel4x1);

        jLabel4x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4x2.setText("?");
        jLabel4x2.setToolTipText("");
        lettersJPanel.add(jLabel4x2);

        jLabel4x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4x3.setText("?");
        jLabel4x3.setToolTipText("");
        lettersJPanel.add(jLabel4x3);

        jLabel4x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4x4.setText("?");
        jLabel4x4.setToolTipText("");
        lettersJPanel.add(jLabel4x4);

        jLabel4x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4x5.setText("?");
        jLabel4x5.setToolTipText("");
        lettersJPanel.add(jLabel4x5);

        jLabel5x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5x1.setText("?");
        jLabel5x1.setToolTipText("");
        lettersJPanel.add(jLabel5x1);

        jLabel5x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5x2.setText("?");
        jLabel5x2.setToolTipText("");
        lettersJPanel.add(jLabel5x2);

        jLabel5x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5x3.setText("?");
        jLabel5x3.setToolTipText("");
        lettersJPanel.add(jLabel5x3);

        jLabel5x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5x4.setText("?");
        jLabel5x4.setToolTipText("");
        lettersJPanel.add(jLabel5x4);

        jLabel5x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5x5.setText("?");
        jLabel5x5.setToolTipText("");
        lettersJPanel.add(jLabel5x5);

        jLabel6x1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6x1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6x1.setText("?");
        jLabel6x1.setToolTipText("");
        lettersJPanel.add(jLabel6x1);

        jLabel6x2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6x2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6x2.setText("?");
        jLabel6x2.setToolTipText("");
        lettersJPanel.add(jLabel6x2);

        jLabel6x3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6x3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6x3.setText("?");
        jLabel6x3.setToolTipText("");
        lettersJPanel.add(jLabel6x3);

        jLabel6x4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6x4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6x4.setText("?");
        jLabel6x4.setToolTipText("");
        lettersJPanel.add(jLabel6x4);

        jLabel6x5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6x5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6x5.setText("?");
        jLabel6x5.setToolTipText("");
        lettersJPanel.add(jLabel6x5);

        mainJPanel.add(lettersJPanel, java.awt.BorderLayout.CENTER);

        bottomJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bottomJPanel.setForeground(new java.awt.Color(0, 0, 0));
        bottomJPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        bottomJPanel.setLayout(new java.awt.GridLayout(1, 2));

        leftBottomJPanel.setLayout(new java.awt.GridLayout(3, 1));

        goodLettersJPanel.setBackground(new java.awt.Color(204, 204, 255));
        goodLettersJPanel.setLayout(new java.awt.GridLayout(1, 0));

        goodLettersJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        goodLettersJLabel.setForeground(new java.awt.Color(102, 255, 51));
        goodLettersJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        goodLettersJLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        goodLettersJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        goodLettersJLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        goodLettersJPanel.add(goodLettersJLabel);

        leftBottomJPanel.add(goodLettersJPanel);

        existsLettersJPanel.setBackground(new java.awt.Color(204, 204, 255));
        existsLettersJPanel.setLayout(new java.awt.GridLayout(1, 0));

        existsLettersJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        existsLettersJLabel.setForeground(new java.awt.Color(255, 204, 51));
        existsLettersJPanel.add(existsLettersJLabel);

        leftBottomJPanel.add(existsLettersJPanel);

        wrongLettersJPanel.setBackground(new java.awt.Color(204, 204, 255));
        wrongLettersJPanel.setLayout(new java.awt.GridLayout(1, 0));

        wrongLettersJLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        wrongLettersJLabel.setForeground(new java.awt.Color(255, 51, 51));
        wrongLettersJPanel.add(wrongLettersJLabel);

        leftBottomJPanel.add(wrongLettersJPanel);

        bottomJPanel.add(leftBottomJPanel);

        rightBottomJPanel.setLayout(new java.awt.GridLayout(2, 1));

        inputJPanel.setBackground(new java.awt.Color(204, 204, 255));
        inputJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        wordJTextField.setBackground(new java.awt.Color(255, 255, 255));
        wordJTextField.setForeground(new java.awt.Color(0, 0, 0));
        wordJTextField.setMinimumSize(new java.awt.Dimension(120, 22));
        wordJTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        inputJPanel.add(wordJTextField);

        sendJButton.setBackground(new java.awt.Color(255, 255, 255));
        sendJButton.setForeground(new java.awt.Color(0, 0, 0));
        sendJButton.setText("Enviar");
        sendJButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sendJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendJButtonActionPerformed(evt);
            }
        });
        inputJPanel.add(sendJButton);

        rightBottomJPanel.add(inputJPanel);

        messagesJPanel.setBackground(new java.awt.Color(204, 204, 255));
        messagesJPanel.setLayout(new java.awt.GridLayout(1, 1));

        messagesJLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        messagesJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messagesJLabel.setText("Inserte una palabra de 5 letras");
        messagesJPanel.add(messagesJLabel);

        rightBottomJPanel.add(messagesJPanel);

        bottomJPanel.add(rightBottomJPanel);

        mainJPanel.add(bottomJPanel, java.awt.BorderLayout.PAGE_END);

        mainJMenuBar.setBackground(new java.awt.Color(51, 51, 51));

        juegoJMenu.setBackground(new java.awt.Color(51, 51, 51));
        juegoJMenu.setText("Juego");

        nuevaPartidaJMenuItem.setText("Nueva partida");
        nuevaPartidaJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidaJMenuItemActionPerformed(evt);
            }
        });
        juegoJMenu.add(nuevaPartidaJMenuItem);

        salirJuegoMenuItem.setText("Salir");
        salirJuegoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirJuegoMenuItemActionPerformed(evt);
            }
        });
        juegoJMenu.add(salirJuegoMenuItem);

        mainJMenuBar.add(juegoJMenu);

        ajustesJMenu.setBackground(new java.awt.Color(51, 51, 51));
        ajustesJMenu.setText("Ajustes");
        ajustesJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajustesJMenuMouseClicked(evt);
            }
        });
        ajustesJMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustesJMenuActionPerformed(evt);
            }
        });
        mainJMenuBar.add(ajustesJMenu);

        setJMenuBar(mainJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void ajustesJMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustesJMenuActionPerformed
    }//GEN-LAST:event_ajustesJMenuActionPerformed

    private void sendJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendJButtonActionPerformed
        if(this.intentos < MAX_INTENTOS){
            String palabra = this.wordJTextField.getText().toUpperCase();
            if (palabra.matches("[A-Z]{5}")) {
                try {
                    if(this.motor.existePalabra(palabra)){
                        comprobarLetras(palabra);
                        rellenarLabels(this.intentos, palabra);
                        this.intentos++;
                        if (this.palabraDelDia.equals(palabra)){
                            this.messagesJLabel.setText("VICTORIA");
                            this.mainJPanel.setEnabled(false);
                        }
                        this.goodLettersJLabel.setText(LETRAS.get("GOODTOTAL").toString());
                        this.existsLettersJLabel.setText(LETRAS.get("EXISTSTOTAL").toString());
                        this.wrongLettersJLabel.setText(LETRAS.get("WRONGTOTAL").toString());
                        this.messagesJLabel.setText("Inserte una palabra de 5 letras");
                    }
                    else{
                        this.messagesJLabel.setText("ERROR: La palabra insertada no existe");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Excepcion en app: " + ex.getMessage());
                }
            }
            else{
                this.messagesJLabel.setText("ERROR: Debe insertar una palabra de 5 letras");
            }
        }else{
            this.messagesJLabel.setText("GAME OVER");
        }
    }//GEN-LAST:event_sendJButtonActionPerformed

    private void ajustesJMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajustesJMenuMouseClicked
        AjustesGUIWordle ajustes = new AjustesGUIWordle(this, true, this.motor, this.tema);
        ajustes.setVisible(true);
        if(this.tema != ajustes.getTema()){
            this.tema = ajustes.getTema();
            seleccionarTema();
        }
        if(this.motor != ajustes.getMotor()){
            this.motor = ajustes.getMotor();
            try{
                reiniciarMotor();
            }
            catch(SQLException ex){
                showMessageDialog(ex);
            } 
            catch(IOException ex){
                showMessageDialog(ex);
            }
        }
    }//GEN-LAST:event_ajustesJMenuMouseClicked

    
    private void nuevaPartidaJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaJMenuItemActionPerformed
        try{
            reiniciarMotor();
        }
        catch(SQLException ex){
            showMessageDialog(ex);
        }
        catch(IOException ex){
            showMessageDialog(ex);
        }
        System.out.println(this.palabraDelDia);
    }//GEN-LAST:event_nuevaPartidaJMenuItemActionPerformed

    private void salirJuegoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirJuegoMenuItemActionPerformed
        try {
            guardarMotor();
        } catch (IOException ex) {
            Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_salirJuegoMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
            guardarMotor();
        }
        catch(IOException ex){
            Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

      
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
            java.util.logging.Logger.getLogger(MainGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUIWordle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUIWordle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void showMessageDialog(Exception ex){
        JOptionPane.showMessageDialog(this, "Excepcion en app: " + ex.getMessage());
    }

    private void reiniciarMotor() throws SQLException, IOException{
        this.palabraDelDia = this.motor.generarPalabra();
        seleccionarTema();
    }
    
    private PairMotorTema cargarMotor() throws FileNotFoundException, IOException, ClassNotFoundException{
        if(GUARDADO.exists() && GUARDADO.canRead()) {
            try (InputStream in = new FileInputStream(GUARDADO);
                ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(in))){                    
                PairMotorTema c = (PairMotorTema)objIn.readObject();
                return c;
            }
        }
        else{
            return null;
        }
    }
    
    private void guardarMotor() throws FileNotFoundException, IOException{
        if(GUARDADO.exists() && GUARDADO.canWrite()) {
            try (OutputStream out = new FileOutputStream(GUARDADO);
                ObjectOutputStream outObj = new ObjectOutputStream(new BufferedOutputStream(out))){                    
                PairMotorTema g = new PairMotorTema(this.motor, this.tema);
                outObj.writeObject(g);
            }
        }
        if (!GUARDADO.exists()) {
            if (!CARPETA.exists()) {
                CARPETA.mkdir();
            }
            GUARDADO.createNewFile();
            try (OutputStream out = new FileOutputStream(GUARDADO);
                ObjectOutputStream outObj = new ObjectOutputStream(new BufferedOutputStream(out))){                    
                PairMotorTema g = new PairMotorTema(this.motor, this.tema);
                outObj.writeObject(g);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajustesJMenu;
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JLabel existsLettersJLabel;
    private javax.swing.JPanel existsLettersJPanel;
    private javax.swing.JLabel goodLettersJLabel;
    private javax.swing.JPanel goodLettersJPanel;
    private javax.swing.JPanel inputJPanel;
    private javax.swing.JLabel jLabel1x1;
    private javax.swing.JLabel jLabel1x2;
    private javax.swing.JLabel jLabel1x3;
    private javax.swing.JLabel jLabel1x4;
    private javax.swing.JLabel jLabel1x5;
    private javax.swing.JLabel jLabel2x1;
    private javax.swing.JLabel jLabel2x2;
    private javax.swing.JLabel jLabel2x3;
    private javax.swing.JLabel jLabel2x4;
    private javax.swing.JLabel jLabel2x5;
    private javax.swing.JLabel jLabel3x1;
    private javax.swing.JLabel jLabel3x2;
    private javax.swing.JLabel jLabel3x3;
    private javax.swing.JLabel jLabel3x4;
    private javax.swing.JLabel jLabel3x5;
    private javax.swing.JLabel jLabel4x1;
    private javax.swing.JLabel jLabel4x2;
    private javax.swing.JLabel jLabel4x3;
    private javax.swing.JLabel jLabel4x4;
    private javax.swing.JLabel jLabel4x5;
    private javax.swing.JLabel jLabel5x1;
    private javax.swing.JLabel jLabel5x2;
    private javax.swing.JLabel jLabel5x3;
    private javax.swing.JLabel jLabel5x4;
    private javax.swing.JLabel jLabel5x5;
    private javax.swing.JLabel jLabel6x1;
    private javax.swing.JLabel jLabel6x2;
    private javax.swing.JLabel jLabel6x3;
    private javax.swing.JLabel jLabel6x4;
    private javax.swing.JLabel jLabel6x5;
    private javax.swing.JMenu juegoJMenu;
    private javax.swing.JPanel leftBottomJPanel;
    private javax.swing.JPanel lettersJPanel;
    private javax.swing.JMenuBar mainJMenuBar;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JLabel messagesJLabel;
    private javax.swing.JPanel messagesJPanel;
    private javax.swing.JMenuItem nuevaPartidaJMenuItem;
    private javax.swing.JPanel rightBottomJPanel;
    private javax.swing.JMenuItem salirJuegoMenuItem;
    private javax.swing.JButton sendJButton;
    private javax.swing.JTextField wordJTextField;
    private javax.swing.JLabel wrongLettersJLabel;
    private javax.swing.JPanel wrongLettersJPanel;
    // End of variables declaration//GEN-END:variables
}
