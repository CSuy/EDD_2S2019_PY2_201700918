/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Estructuras.Matriz;
import Nodos.Nodo_Hash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static Aplicacion.Inicio_Sesion.sesion_user;
import App_Reportes.Reporte_Arbol;
import App_Reportes.Reporte_Archivo;
import App_Reportes.Reporte_Grafo;
import Estructuras.ArbolAVL;
import Nodos.Nodo_AVL;
import Nodos.Nodo_Matriz;
import edd_proyecto2.Obtener_Hora;

/**
 *
 * @author MiriamLeticia
 */
public class Interfaz_Usuario extends javax.swing.JFrame {
    private static Nodo_Hash user_actual;
    public static String nombre_usuarior;
    static String ruta_direccion = "/";
    boolean ya_cargue = true;
    boolean ya_cargue1 = true;
    boolean ya_asigne = true;
    Matriz m = new Matriz();
    ArbolAVL arbol = new ArbolAVL();
    ArrayList<String> Archivos = new ArrayList<>();
    ArrayList<String> Carpetas = new ArrayList<>();
    String eliminar = "", modificar="";
    int posX = 10, posY = 10;
    JButton[] carp;
    JLabel[] nomC;
    JButton[] carp1;
    JLabel[] nomC1;
    static Nodo_Matriz nod = null;
    
    /**
     * Creates new form Interfaz_Usuario
     */
    public Interfaz_Usuario() {
        initComponents();
        txtUsuario.setText("");
        txtRutaCarpeta.setText(ruta_direccion);
        if(sesion_user!=null){
            user_actual = sesion_user;
            txtUsuario.setText("Bienvenido, "+user_actual.getUsuario());
            nombre_usuarior = user_actual.getUsuario();
            if(user_actual.getCarpetas()==null){
                m.crear_Raiz();
                user_actual.setCarpetas(m.getRaiz());
                System.out.println("Cree la carpeta raiz");
            }else{
                m.setRaiz(user_actual.getCarpetas());
                System.out.println("Ya tenia una carpeta");
            }
        }else{
            System.out.println("NO HAY USUARIO");
        }
        CargarCarpetas();
        CargarArchivos();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCmodificar = new javax.swing.JButton();
        btnCeliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCcrear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAmodificar = new javax.swing.JButton();
        btnAeliminar = new javax.swing.JButton();
        btnAcrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAsubir = new javax.swing.JButton();
        btnACargaArchivos = new javax.swing.JButton();
        txtRutaCarpeta = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        btnMatriz = new javax.swing.JButton();
        btnGrafo = new javax.swing.JButton();
        btnArbol = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("USAC FILE DRIVE");

        txtUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        txtUsuario.setText("jLabel2");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        btnCmodificar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnCmodificar.setText("Modificar");
        btnCmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCmodificarActionPerformed(evt);
            }
        });

        btnCeliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnCeliminar.setText("Eliminar");
        btnCeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeliminarActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CARPETAS");

        btnCcrear.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnCcrear.setText("Crear");
        btnCcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCcrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCeliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCcrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCcrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCeliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCmodificar)
                .addGap(5, 5, 5))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        btnAmodificar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAmodificar.setText("Modificar");
        btnAmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmodificarActionPerformed(evt);
            }
        });

        btnAeliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAeliminar.setText("Eliminar");
        btnAeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAeliminarActionPerformed(evt);
            }
        });

        btnAcrear.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAcrear.setText("Crear");
        btnAcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcrearActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ARCHIVOS");

        btnAsubir.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAsubir.setText("Subir");

        btnACargaArchivos.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnACargaArchivos.setText("Carga Archivos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnACargaArchivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsubir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAcrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAeliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAcrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAeliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAsubir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnACargaArchivos)
                .addContainerGap())
        );

        btnAcceder.setText("Acceder");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        btnMatriz.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnMatriz.setText("Reporte Matriz");
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });

        btnGrafo.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnGrafo.setText("Reporte Grafo");
        btnGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafoActionPerformed(evt);
            }
        });

        btnArbol.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnArbol.setText("Reporte Arbol");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jPanel5.setPreferredSize(new java.awt.Dimension(687, 5000));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCerrarSesion)
                                    .addComponent(btnAcceder)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRutaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMatriz)
                                .addGap(18, 18, 18)
                                .addComponent(btnGrafo)
                                .addGap(18, 18, 18)
                                .addComponent(btnArbol)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnMatriz)
                    .addComponent(btnGrafo)
                    .addComponent(btnArbol)
                    .addComponent(btnCerrarSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario)
                    .addComponent(txtRutaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcceder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCcrearActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la carpeta");
        if(Carpetas.contains(nombre)){
            JOptionPane.showMessageDialog(null, "La Carpeta: " + nombre + " ya existe");
        }else{
            Carpetas.add(nombre);
            m.Insertar(txtRutaCarpeta.getText(), nombre);
            CargarCarpetas();
            CargarArchivos();
            this.repaint();
        }
    }//GEN-LAST:event_btnCcrearActionPerformed

    private void btnAcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcrearActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la Archivo");
        String contenido = JOptionPane.showInputDialog(null, "Escriba el contenido de la Archivo");
        Obtener_Hora ob = new Obtener_Hora();
        String creacion = ob.obtener_fecha();
        String _usuario = user_actual.getUsuario();
        if(Archivos.contains(nombre)){
            JOptionPane.showMessageDialog(null, "El Archivo: " + nombre + " ya existe");
        }else{
            Archivos.add(nombre);
            arbol.Insertar(nombre, contenido, creacion, _usuario);
            Buscar1(ruta_direccion);
            CargarCarpetas();
            CargarArchivos();
            this.repaint();
        }
    }//GEN-LAST:event_btnAcrearActionPerformed

    private void btnCeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeliminarActionPerformed
        ArrayList<String> aux = new ArrayList<>(Carpetas);
        Carpetas = new ArrayList<>();
        for(String p: aux){
            if(!p.equals(eliminar)){
                Carpetas.add(p);
            }
        }
        CargarCarpetas();
        CargarArchivos();
        this.repaint();
    }//GEN-LAST:event_btnCeliminarActionPerformed

    private void btnCmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCmodificarActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Escriba el nuevo nombre de la carpeta");
        int co = 0;
        if(Carpetas.contains(nombre)){
            JOptionPane.showMessageDialog(null, "La carpeta: "  + nombre + " ya existe");
        }else{
            for (String p: Carpetas) {
                if (p.equals(modificar)) {
                   Carpetas.set(co, nombre);
                }
                co++;
            }
        }
        CargarCarpetas();
        CargarArchivos();
        this.repaint();
    }//GEN-LAST:event_btnCmodificarActionPerformed

    private void btnAeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAeliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAeliminarActionPerformed

    private void btnAmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmodificarActionPerformed
        
    }//GEN-LAST:event_btnAmodificarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        ya_cargue = true;
        ya_cargue1 = true;
        Inicio_Sesion inicio_sesion = new Inicio_Sesion();
        inicio_sesion.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizActionPerformed
        m.Graficar(user_actual.getUsuario());
        Reporte_Archivo reporte_archivo = new Reporte_Archivo();
        reporte_archivo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMatrizActionPerformed

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        String j = ruta_direccion;
        ruta_direccion = txtRutaCarpeta.getText();
        boolean existe = Buscar(ruta_direccion);
        if(existe == true){
            JOptionPane.showMessageDialog(null, "Accesando a la carpeta");
            ya_cargue = true;
            ya_cargue1 = true;
            Asignar_Raiz(ruta_direccion);
            Buscar1(ruta_direccion);
            CargarCarpetas();
            CargarArchivos();
        }else{
            JOptionPane.showMessageDialog(null, "La Carpeta a la que desea acceder no existe");
            txtRutaCarpeta.setText(j);
            ruta_direccion = txtRutaCarpeta.getText();
        }
    }//GEN-LAST:event_btnAccederActionPerformed

    private void btnGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafoActionPerformed
        m.Graficar_Grafo(user_actual.getUsuario());
        Reporte_Grafo reporte_grafo = new Reporte_Grafo();
        reporte_grafo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGrafoActionPerformed

    private void btnArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolActionPerformed
        arbol.Graficar(user_actual.getUsuario());
        Reporte_Arbol reporte_arbol = new Reporte_Arbol();
        reporte_arbol.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnArbolActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnACargaArchivos;
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnAcrear;
    private javax.swing.JButton btnAeliminar;
    private javax.swing.JButton btnAmodificar;
    private javax.swing.JButton btnArbol;
    private javax.swing.JButton btnAsubir;
    private javax.swing.JButton btnCcrear;
    private javax.swing.JButton btnCeliminar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCmodificar;
    private javax.swing.JButton btnGrafo;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtRutaCarpeta;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    private void CargarArchivos() {
        try{
            Revisar_Arbol();
            int creacion = Archivos.size();
            System.out.println(creacion);
            if(0 != Carpetas.size()){
            } else { 
                posX = 10;
                posY = 10;
            }
            if(creacion > 0){
                carp1 = new JButton[creacion];
                nomC1 = new JLabel[creacion];
                for (int i = 0; i < creacion; i++) {
                    carp1[i] = new JButton();
                    nomC1[i] = new JLabel();
                    carp1[i].setBounds(posX, posY, 80, 80);
                    nomC1[i].setBounds(posX, posY + 90 , 80, 20);
                    nomC1[i].setText(Archivos.get(i));
                    ImageIcon icono = new ImageIcon("src/Prueba/archivo.png");
                    carp1[i].setIcon(icono);
                    jPanel5.add(carp1[i]);
                    jPanel5.add(nomC1[i]);
                    Accion1 a = new Accion1();
                    carp[i].addActionListener(a);
                    posX += 80;
                    if(posX >= 80*8){
                        posX = 10;
                        posY = posY + 130;
                    }
                }
            }
            jPanel5.repaint();
        }catch(Exception e){
            System.out.println("Se produjo un error");
        }
    }

    private void CargarCarpetas() {
        try{
            Revisar_Matriz();
            int creacion = Carpetas.size();
            posX = 10; posY = 10;
            jPanel5.removeAll();
            System.out.println(creacion);
            if(creacion > 0){
                carp = new JButton[creacion];
                nomC = new JLabel[creacion];
                for (int i = 0; i < creacion; i++) {
                    carp[i] = new JButton();
                    nomC[i] = new JLabel();
                    ImageIcon icono = new ImageIcon("src/Prueba/carpeta1.png");
                    carp[i].setIcon(icono);
                    carp[i].setBounds(posX, posY, 80, 80);
                    nomC[i].setBounds(posX, posY + 90 , 80, 20);
                    nomC[i].setText(Carpetas.get(i));
                    carp[i].setName(Carpetas.get(i));
                    jPanel5.add(carp[i]);
                    jPanel5.add(nomC[i]);
                    Accion a = new Accion();
                    carp[i].addActionListener(a);
                    posX += 80;
                    if(posX >= 80*8){
                        posX = 10;
                        posY = posY + 130;
                    }
                }  
            }
            jPanel5.repaint();
        }catch(Exception e){
            System.out.println("Se produjo un error");
        }
    }

    private void Revisar_Matriz(){
        if(ya_cargue){
            if(user_actual != null){
                Carpetas = new ArrayList<>();
                Nodo_Matriz aux = user_actual.getCarpetas();
                while(aux!=null){
                    if(aux.getRutaDeAcceso().equals(ruta_direccion)){
                        Carpetas.add(aux.getNombre());
                    }
                    aux = aux.getSiguiente();
                }
            }
            ya_cargue = false;
            System.out.println("Revise");
        }else{
            System.out.println("No revise matriz");
        }
    }
    
    private void Revisar_Arbol(){
        if(ya_cargue1){
            if(ruta_direccion.equals("/")){
                Nodo_Matriz aux_r = user_actual.getCarpetas();
                aux_r = aux_r.getAbajo();
                arbol.setRoot(aux_r.getArchivos());
            }else{
                Nodo_Matriz aux_r = user_actual.getCarpetas();
                String a = "raiz"+ruta_direccion;
                String [] aux1 = a.split("/");
                String aux2 = "";
                if(aux1.length != 2){
                    for (int i = 1; i < aux1.length - 1 ; i++) {
                        aux2 += "/" + aux1[i];
                    }
                }else{
                    aux2 = "/";
                }
                while(aux_r!=null){
                    if(aux_r.getNombre().equals(aux1[aux1.length - 1]) && aux_r.getRutaDeAcceso().equals(aux2)){
                        arbol.setRoot(aux_r.getArchivos());
                    }
                    aux_r = aux_r.getAbajo();
                }

            }
            ya_cargue1 = false;
            System.out.println("Revise Matriz");
            Archivos = new ArrayList<>();
            if(arbol.getRoot()!=null){
                String nodos = arbol.PreOrden();
                String[] nodos1 = nodos.split(";");
                for(int p = 0; p<nodos1.length; p++){
                    Archivos.add(nodos1[p]);
                }
            }
        }
    }
    
    private boolean Buscar(String carpeta) {
        if(carpeta.equals("/")){
            return true;
        }else{
            Nodo_Matriz aux_r = user_actual.getCarpetas();
            String a = "raiz"+carpeta;
            String [] aux1 = a.split("/");
            String aux2 = "";
            if(aux1.length != 2){
                for (int i = 1; i < aux1.length - 1 ; i++) {
                    aux2 += "/" + aux1[i];
                }
            }else{
                aux2 = "/";
            }
            while(aux_r!=null){
                if(aux_r.getNombre().equals(aux1[aux1.length - 1]) && aux_r.getRutaDeAcceso().equals(aux2)){
                    return true;
                }
                aux_r = aux_r.getAbajo();
            }
            
        }
        return false;
    }
    
    private void Buscar1(String carpeta){
        if(carpeta.equals("/")){
            Nodo_Matriz aux_r = user_actual.getCarpetas();
            aux_r = aux_r.getAbajo();
            aux_r.setArchivos(arbol.getRoot());
        }else{
            Nodo_Matriz aux_r = user_actual.getCarpetas();
            String a = "raiz"+carpeta;
            String [] aux1 = a.split("/");
            String aux2 = "";
            if(aux1.length != 2){
                for (int i = 1; i < aux1.length - 1 ; i++) {
                    aux2 += "/" + aux1[i];
                }
            }else{
                aux2 = "/";
            }
            while(aux_r!=null){
                if(aux_r.getNombre().equals(aux1[aux1.length - 1]) && aux_r.getRutaDeAcceso().equals(aux2)){
                    aux_r.setArchivos(arbol.getRoot());
                }
                aux_r = aux_r.getAbajo();
            }
            
        }
        
    }

    private void Asignar_Raiz(String ruta_direccion) {
            if(ruta_direccion.equals("/")){
                Nodo_Matriz aux_r = user_actual.getCarpetas();
                aux_r = aux_r.getAbajo();
                if(aux_r.getArchivos() != null){
                    arbol.setRoot(aux_r.getArchivos());
                }else{
                    arbol.setRoot(null);
                }
                
            }else{
                Nodo_Matriz aux_r = user_actual.getCarpetas();
                String a = "raiz"+ruta_direccion;
                String [] aux1 = a.split("/");
                String aux2 = "";
                if(aux1.length != 2){
                    for (int i = 1; i < aux1.length - 1 ; i++) {
                        aux2 += "/" + aux1[i];
                    }
                }else{
                    aux2 = "/";
                }
                while(aux_r!=null){
                    if(aux_r.getNombre().equals(aux1[aux1.length - 1]) && aux_r.getRutaDeAcceso().equals(aux2)){
                        if(aux_r.getArchivos() != null){
                            arbol.setRoot(aux_r.getArchivos());
                        }else{
                            arbol.setRoot(null);
                        }
                    }
                    aux_r = aux_r.getAbajo();
                }

            }
    }
    
    private class Accion implements ActionListener{
        
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Carpetas.size(); i++) {
            if(nomC[i].getBackground() == java.awt.Color.cyan ){
                nomC[i].setBackground(java.awt.Color.white);
                System.out.println("Entre aqui");
            }
            if(e.getSource().equals(carp[i])){
                nomC[i].setOpaque(true);
                nomC[i].setBackground(java.awt.Color.cyan);
                eliminar = carp[i].getName();
                modificar = carp[i].getName();
            }
        }
    }
    
}
    private class Accion1 implements ActionListener{
        
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Archivos.size(); i++) {
            if(nomC1[i].getBackground() == java.awt.Color.cyan ){
                nomC1[i].setBackground(java.awt.Color.white);
                System.out.println("Entre aqui");
            }
            if(e.getSource().equals(carp[i])){
                nomC1[i].setOpaque(true);
                nomC1[i].setBackground(java.awt.Color.cyan);
                eliminar = carp1[i].getName();
                modificar = carp1[i].getName();
            }
        }
    }
    
}
}

