/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Nodos.Nodo_Hash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MiriamLeticia
 */
public class Interfaz_Usuario extends javax.swing.JFrame {
    private static Nodo_Hash user_actual;
    ArrayList<String> Archivos = new ArrayList<>();
    ArrayList<String> Carpetas = new ArrayList<>();
    String eliminar = "", modificar="";
    int posX = 10, posY = 10;
    JButton[] carp;
    JLabel[] nomC;
    JButton[] carp1;
    JLabel[] nomC1;
    
    /**
     * Creates new form Interfaz_Usuario
     */
    public Interfaz_Usuario() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCmodificar = new javax.swing.JButton();
        btnCeliminar = new javax.swing.JButton();
        btnCcrear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAmodificar = new javax.swing.JButton();
        btnAeliminar = new javax.swing.JButton();
        btnAcrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAsubir = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("USAC FILE DRIVE");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel2.setText("jLabel2");

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

        btnCcrear.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnCcrear.setText("Crear");
        btnCcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCcrearActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CARPETAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCcrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCeliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCcrear)
                .addGap(11, 11, 11)
                .addComponent(btnCeliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCmodificar)
                .addGap(5, 5, 5))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        btnAmodificar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAmodificar.setText("Modificar");

        btnAeliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnAeliminar.setText("Eliminar");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAcceder.setText("Acceder");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(btnAcceder))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcceder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCcrearActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la carpeta");
        if(Carpetas.contains(nombre)){
            JOptionPane.showMessageDialog(null, "La Carpeta: " + nombre + " ya existe");
        }else{
            Carpetas.add(nombre);
            CargarCarpetas();
            CargarArchivos();
            this.repaint();
        }
    }//GEN-LAST:event_btnCcrearActionPerformed

    private void btnAcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcrearActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la Archivo");
        Archivos.add(nombre);
        CargarCarpetas();
        CargarArchivos();
        this.repaint();
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
        this.repaint();
    }//GEN-LAST:event_btnCmodificarActionPerformed

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
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnAcrear;
    private javax.swing.JButton btnAeliminar;
    private javax.swing.JButton btnAmodificar;
    private javax.swing.JButton btnAsubir;
    private javax.swing.JButton btnCcrear;
    private javax.swing.JButton btnCeliminar;
    private javax.swing.JButton btnCmodificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    public void Usuario(Nodo_Hash datos){
      user_actual = datos;
    }

    private void CargarArchivos() {
        try{
            int creacion = Archivos.size();
            if(creacion > 0){
                carp1 = new JButton[creacion];
                nomC1 = new JLabel[creacion];
                for (int i = 0; i < creacion; i++) {
                    carp1[i] = new JButton();
                    nomC1[i] = new JLabel();
                    carp1[i].setBounds(posX, posY, 80, 80);
                    nomC1[i].setBounds(posX, posY + 80 , 80, 20);
                    nomC1[i].setText(Archivos.get(i));
                    ImageIcon icono = new ImageIcon("src/Prueba/archivo.png");
                    carp1[i].setIcon(icono);
                    jPanel3.add(carp1[i]);
                    jPanel3.add(nomC1[i]);
                    posX += 80;
                }
                
            }
        }catch(Exception e){
            System.out.println("Se produjo un error");
        }
    }

    private void CargarCarpetas() {
        try{
            int creacion = Carpetas.size();
            posX = 10; posY = 10;
            jPanel3.removeAll();
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
                    jPanel3.add(carp[i]);
                    jPanel3.add(nomC[i]);
                    Accion a = new Accion();
                    carp[i].addActionListener(a);
                    posX += 80;
                }
                
            }
        }catch(Exception e){
            System.out.println("Se produjo un error");
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
}

