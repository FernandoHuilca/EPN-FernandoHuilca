/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb.abolb;

import java.util.*;
import javax.swing.JOptionPane;

public class Interfaz2 extends javax.swing.JFrame {
    // Declaración de variables
    Lista datos;   // Lista de datos, probablemente una clase personalizada
    Raiz raiz1;    // Raíz del árbol B, otra clase personalizada
    boolean ya = false; // Bandera para verificar si el árbol B ya ha sido creado
    boolean existe = false; // Bandera para verificar la existencia de algo (probablemente el árbol)
    Raiz raizAux = new Raiz(2); // Creación de una raíz auxiliar con un grado de 2

    // Constructor de la clase Interfaz2
    public Interfaz2() {
        initComponents(); // Método para inicializar los componentes de la interfaz gráfica
    }
    /**
     * Método llamado desde el constructor para inicializar el formulario.
     * ADVERTENCIA: No modifiques este código. El contenido de este método es siempre
     * regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Definición de los componentes de la interfaz gráfica
        frameArbol = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();


        // Configuración del frame para mostrar el árbol B
        frameArbol.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel4.setText("El Arbol B con los valores ingresados esta asi: ");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout frameArbolLayout = new javax.swing.GroupLayout(frameArbol.getContentPane());
        frameArbol.getContentPane().setLayout(frameArbolLayout);
        frameArbolLayout.setHorizontalGroup(
                frameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frameArbolLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel4)
                                .addContainerGap(115, Short.MAX_VALUE))
                        .addGroup(frameArbolLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        frameArbolLayout.setVerticalGroup(
                frameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frameArbolLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        setResizable(false);


        // Panel de opciones para interactuar con el árbol B
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setToolTipText("Numero entero");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setToolTipText("Numero entero");
        jTextField3.setPreferredSize(new java.awt.Dimension(73, 20));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setToolTipText("Numero entero");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(jTextField1))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(jTextField2))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear"));

        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setToolTipText("Grado");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });


        // Panel para crear un nuevo árbol B
        jButton5.setText("Crear NUEVO Arbol");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton5)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizar"));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 92));

        jButton4.setText("Ver Arbol");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


        if(!jTextField2.getText().equals("")){
        boolean numero = raizAux.esNumero(jTextField2.getText());
        if(numero){
        if(ya){
        boolean esta = raiz1.buscar(Integer.parseInt(jTextField2.getText()));
        if(esta){
            JOptionPane.showMessageDialog(this, "El elemento " +
                    jTextField2.getText() + " SI se encuentra en el arbol B",
               "Dato encontrado!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "El elemento " +
                    jTextField2.getText() + " NO se encuentra en el arbol B",
               "Dato no encontrado!!!", JOptionPane.WARNING_MESSAGE);
        }

      }else{
          JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
               "Error!!", JOptionPane.WARNING_MESSAGE);
      }

        }else{
            JOptionPane.showMessageDialog(this, "Ingrese numeros entero diferentes de 0",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
      }else{
          JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
               "Error!!", JOptionPane.WARNING_MESSAGE);
      }
      jTextField2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        raiz1.arbol = "";
        if(ya){
        String raiz = "raiz [ ";
        for(int i = 0; i < raiz1.primerNodo.valores.length && raiz1.primerNodo.valores[i] != 0; i++){
            raiz += raiz1.primerNodo.valores[i] + ", ";
        }
        raiz += " ]\n";
        raiz += raiz1.llamarRecorrer();
        jTextArea1.setText(raiz);
        }
        frameArbol.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            raiz1.arbol = "";
            if(!jTextField4.getText().equals("")){
            boolean numero = raizAux.esNumero(jTextField4.getText());
            if(numero){
                if(!(Integer.parseInt(jTextField4.getText()) < 1)){
                    datos = new Lista();
                    existe = true;
                    raiz1 = new Raiz(Integer.parseInt(jTextField4.getText()));
                     JOptionPane.showMessageDialog(this, "se ha creado un nuevo arbol de grado "
                             + jTextField4.getText(),
               "Novedad", JOptionPane.WARNING_MESSAGE);
                    ya = true;
                }else{
                    JOptionPane.showMessageDialog(this, "Ingrese un grado entero mayor o igual que 1",
               "Error!!", JOptionPane.WARNING_MESSAGE);

                }
            }else{
               JOptionPane.showMessageDialog(this, "Ingrese un grado entero mayor o igual que 1",
               "Error!!", JOptionPane.WARNING_MESSAGE);
            }
        }else{
           JOptionPane.showMessageDialog(this, "Ingrese datos en el campo de texto",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        jTextField4.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(!jTextField1.getText().equals("")){
            boolean numero = raizAux.esNumero(jTextField1.getText());
            if(numero){
        boolean adentro = false;
        if(existe){
        for(int i = 0; i < datos.ingresados.size(); i++){
            if(datos.ingresados.get(i) == Integer.parseInt(jTextField1.getText())){
                 adentro = true;
            }
        }
        }
        if(!adentro){
        if(!jTextField1.getText().equals("")){
            if(!jTextField1.getText().equals("0")){
            if(ya){
        raiz1.insertar(Integer.parseInt(jTextField1.getText()));
        JOptionPane.showMessageDialog(this, "El elemento " +
                    jTextField1.getText() + " fue ingresado al arbol B exitosamente",
               "Novedad", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
           }else{
               JOptionPane.showMessageDialog(this, "Ingrese datos diferentes de 0",
               "Error!!", JOptionPane.WARNING_MESSAGE);
           }

        }else{
           JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(this, "El elemento ya habia sido ingresado previamente",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese numeros enteros diferentes de 0",
               "Error!!", JOptionPane.WARNING_MESSAGE);
            }
    }else{
          JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        jTextField1.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean esta = false;
        boolean numero = raizAux.esNumero(jTextField3.getText());
        if(!jTextField3.getText().equals("")){
            if(numero){
            if(ya){
            for(int i = 0; i < datos.ingresados.size(); i++){
                if(datos.ingresados.get(i) == Integer.parseInt(jTextField3.getText())){
                    esta = true;
                }
            }
             raiz1.eliminar(Integer.parseInt(jTextField3.getText()));
             if(esta){
           JOptionPane.showMessageDialog(this, "El elemento " + jTextField3.getText() +
                   " fue eliminado exitosamente",
               "Novedad", JOptionPane.WARNING_MESSAGE);
             }else{
               JOptionPane.showMessageDialog(this, "El elemento " + jTextField3.getText() +
                   " no estaba en el arbol",
               "Novedad", JOptionPane.WARNING_MESSAGE);
             }
            }else{
                JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
               "Error!!", JOptionPane.WARNING_MESSAGE);
            }

         }else{
             JOptionPane.showMessageDialog(this, "Ingrese numeros enteros diferentes de 0",
               "Novedad", JOptionPane.WARNING_MESSAGE);

         }
         jTextField3.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame frameArbol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
