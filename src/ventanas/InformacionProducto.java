/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.Conexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MINEDUCYT
 */
public class InformacionProducto extends javax.swing.JFrame {

    int articulo, n;
    String name, proveedor;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form InformacionProducto
     */
    public InformacionProducto() {
        initComponents();

        articulo = Inicio.producto;

        this.setLocationRelativeTo(null);
        setTitle("Ferreteria y Cerrajeria G&G");
        setResizable(false);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper.png");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon nulo = new ImageIcon("src/marcas/Inexistente.png");
        Icon fotos = new ImageIcon(nulo.getImage().getScaledInstance(LabelFoto.getWidth(),
                LabelFoto.getHeight(), Image.SCALE_DEFAULT));

        LabelFoto.setIcon(fotos);
        LabelWallpaper.setIcon(icon);
        LabelMarcas.setIcon(fotos);

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        Table.setShowGrid(false);

        try {
            Connection cn = Conexiones.conexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from articulos where ID = '" + articulo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                TxtNombre.setText(rs.getString("Nombre")+" "+rs.getString("Marca"));
                TxtPrecio.setText(rs.getString("Precio"));
                TxtDescripcion.setText(rs.getString("Drescripcion"));
                CmbMarca.setSelectedItem(rs.getString("Marca"));
                CmbOpcion.setSelectedItem(rs.getString("Existencias"));

                n = CmbMarca.getSelectedIndex();

                if (n == 0) {
                    proveedor = "Truper";
                } else if (n == 1) {
                    proveedor = "Viduc";
                } else if (n == 2) {
                    proveedor = "Total";
                } else if (n == 3) {
                    proveedor = "Iml";
                } else if (n == 4) {
                    proveedor = "Inversiones Asiaticas";
                } else if (n == 5) {
                    proveedor = "Nulo";
                }

                try {
                    cn = Conexiones.conexion();
                    pst = cn.prepareStatement(
                            "select Nombre from pronombres where IdProducto = '" + articulo + "'");
                    rs = pst.executeQuery();

                    jScrollPane1.setOpaque(false);
                    jScrollPane1.getViewport().setOpaque(false);
                    Table.setShowGrid(false);
                    Table = new JTable(model);
                    jScrollPane2.setViewportView(Table);

                    model.addColumn("Nombre");
                    while (rs.next()) {
                        Object[] fila = new Object[1];

                        for (int i = 0; i < 1; i++) {

                            fila[i] = rs.getObject(i + 1);

                        }
                        model.addRow(fila);
                    }
                } catch (Exception e) {
                    System.out.println("Error al llenar la tabla de pronombres: " + e);
                }
                ImageIcon cosa = new ImageIcon("src/articulos/" + articulo + ".png");
                Icon foto = new ImageIcon(cosa.getImage().getScaledInstance(LabelFoto.getWidth(),
                        LabelFoto.getHeight(), Image.SCALE_DEFAULT));

                LabelFoto.setIcon(foto);

                if (proveedor.equals("Truper") || proveedor.equals("Viduc") || proveedor.equals("Iml")
                        || proveedor.equals("Total") || proveedor.equals("Inversiones Asiaticas")) {

                    ImageIcon marc = new ImageIcon("src/marcas/" + proveedor + ".png");
                    Icon foto2 = new ImageIcon(marc.getImage().getScaledInstance(LabelMarcas.getWidth(),
                            LabelMarcas.getHeight(), Image.SCALE_DEFAULT));

                    LabelMarcas.setIcon(foto2);
                } else {
                    LabelMarcas.setIcon(fotos);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo llenar los datos, contacta al Desarrollador");
                this.dispose();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "images/iconoapp.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        CmbMarca = new javax.swing.JComboBox<>();
        CmbOpcion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        LabelMarcas = new javax.swing.JLabel();
        LabelFoto = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        TxtPrecio = new javax.swing.JTextField();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("🖊");
        jButton4.setToolTipText("");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 40, 20));

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 150, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Editar Pronombres");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 290, 40));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 290, 40));

        CmbMarca.setBackground(new java.awt.Color(0, 153, 153));
        CmbMarca.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CmbMarca.setForeground(new java.awt.Color(255, 255, 255));
        CmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Truper", "Viduc", "Total", "Iml", "Inversiones Asiaticas", "Nulo" }));
        CmbMarca.setSelectedIndex(5);
        CmbMarca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbMarcaItemStateChanged(evt);
            }
        });
        getContentPane().add(CmbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 220, 40));

        CmbOpcion.setBackground(new java.awt.Color(0, 153, 153));
        CmbOpcion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CmbOpcion.setForeground(new java.awt.Color(255, 255, 255));
        CmbOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si Tenemos", "No Tenemos" }));
        getContentPane().add(CmbOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 280, 40));

        TxtDescripcion.setBackground(new java.awt.Color(0, 153, 153));
        TxtDescripcion.setColumns(20);
        TxtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        TxtDescripcion.setRows(5);
        TxtDescripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(TxtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 290, 200));

        LabelMarcas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(LabelMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 170, 150));

        LabelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(LabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 170, 150));

        TxtNombre.setBackground(new java.awt.Color(0, 153, 153));
        TxtNombre.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 220, 40));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pronombres:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setOpaque(false);
        Table.setSelectionBackground(new java.awt.Color(0, 255, 204));
        jScrollPane2.setViewportView(Table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 71, 290, 360));

        TxtPrecio.setBackground(new java.awt.Color(0, 153, 153));
        TxtPrecio.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        TxtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        TxtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 290, 40));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int Opcion, Marca;
        String Precio, Descripcion, sOpcion = "", Nombre, sMarca = "";

        Marca = CmbMarca.getSelectedIndex();
        Nombre = TxtNombre.getText();
        Precio = TxtPrecio.getText();
        Descripcion = TxtDescripcion.getText();
        Opcion = CmbOpcion.getSelectedIndex();

        if (Marca == 0) {
            sMarca = "Truper";
        } else if (Marca == 1) {
            sMarca = "Viduc";
        } else if (Marca == 2) {
            sMarca = "Total";
        } else if (Marca == 3) {
            sMarca = "Iml";
        } else if (Marca == 4) {
            sMarca = "Inversiones Asiaticas";
        } else if (Marca == 5) {
            sMarca = "Nulo";
        }

        if (Opcion == 0) {
            sOpcion = "Si Tenemos";
        } else if (Opcion == 1) {
            sOpcion = "No Tenemos";
        }

        try {

            Connection cnz = Conexiones.conexion();
            PreparedStatement pstz = cnz.prepareStatement(
                    "update articulos set Precio=?, Drescripcion=?, Existencias=?, Marca=?, Nombre=? where ID = '" + articulo + "'");

            pstz.setString(1, Precio);
            pstz.setString(2, Descripcion);
            pstz.setString(3, sOpcion);
            pstz.setString(4, sMarca);
            pstz.setString(5, Nombre);

            pstz.executeUpdate();
            cnz.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void CmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbMarcaItemStateChanged

        int Marca = CmbMarca.getSelectedIndex();

        ImageIcon marca = new ImageIcon("");
        LabelMarcas.setOpaque(false);

        if (Marca == 0) {

            marca = new ImageIcon("src/marcas/Truper.png");
            LabelMarcas.setOpaque(true);

        } else if (Marca == 1) {

            marca = new ImageIcon("src/marcas/Viduc.png");
            LabelMarcas.setOpaque(true);

        } else if (Marca == 2) {

            marca = new ImageIcon("src/marcas/Total.png");
            LabelMarcas.setOpaque(true);

        } else if (Marca == 3) {

            marca = new ImageIcon("src/marcas/Iml.png");
            LabelMarcas.setOpaque(true);

        } else if (Marca == 4) {

            marca = new ImageIcon("src/marcas/Inversiones Asiaticas.png");
            LabelMarcas.setOpaque(true);

        } else if (Marca == 5) {

            marca = new ImageIcon("src/marcas/Inexistente.png");
            LabelMarcas.setOpaque(false);

        }

        Icon icon = new ImageIcon(marca.getImage().getScaledInstance(LabelMarcas.getWidth(),
                LabelMarcas.getHeight(), Image.SCALE_DEFAULT));
        LabelMarcas.setIcon(icon);

    }//GEN-LAST:event_CmbMarcaItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Pronombres().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {
            Connection cn = Conexiones.conexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select Nombre from pronombres where IdProducto = '" + articulo + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[1];

                for (int i = 0; i < 1; i++) {

                    fila[i] = rs.getObject(i + 1);

                }
                model.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al llenar la tabla de pronombres: " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int ID = articulo;
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);

        if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            rsdragdropfiles.RSDragDropFiles.setCopiar(jf.getSelectedFile().toString(),
                    "src/articulos/" + ID + ".png");

        }

        ImageIcon wallpaper = new ImageIcon("src/articulos/" + ID + ".png");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(LabelFoto.getWidth(),
                LabelFoto.getHeight(), Image.SCALE_DEFAULT));

        LabelFoto.setIcon(icon);


    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbMarca;
    private javax.swing.JComboBox<String> CmbOpcion;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JLabel LabelMarcas;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JTable Table;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
