/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import clases.Conexiones;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static ventanas.Inicio.producto;

/**
 *
 * @author MINEDUCYT
 */
public class Provedor extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Inicio
     */
    public Provedor() {
        initComponents();

        this.setLocationRelativeTo(null);
        setTitle("Marcas");
        setResizable(false);

        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper3.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon Boton1 = new ImageIcon("src/marcas/Truper.png");
        Icon but1 = new ImageIcon(Boton1.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        ImageIcon Boton2 = new ImageIcon("src/marcas/Viduc.png");
        Icon but2 = new ImageIcon(Boton2.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        ImageIcon Boton3 = new ImageIcon("src/marcas/Total.png");
        Icon but3 = new ImageIcon(Boton3.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        ImageIcon Boton4 = new ImageIcon("src/marcas/Iml.png");
        Icon but4 = new ImageIcon(Boton4.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        ImageIcon Boton5 = new ImageIcon("src/marcas/Inexistente.png");
        Icon but5 = new ImageIcon(Boton5.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        ImageIcon Boton6 = new ImageIcon("src/marcas/Inversiones Asiaticas.png");
        Icon but6 = new ImageIcon(Boton6.getImage().getScaledInstance(Truper.getWidth() - 2,
                Truper.getHeight() - 2, Image.SCALE_DEFAULT));

        Susan.setIcon(but6);
        SinMarca.setIcon(but5);
        Iml.setIcon(but4);
        Total.setIcon(but3);
        Viduc.setIcon(but2);
        Truper.setIcon(but1);
        LabelWallpaper.setIcon(icon);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        Table.setShowGrid(false);

        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Marca");
            model.addColumn("Precio");
            model.addColumn("En existencias");

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Filap = Table.rowAtPoint(e.getPoint());
                int Columna = 0;
                if (Filap >= -1) {
                    try {
                        producto = (int) model.getValueAt(Filap, Columna);

                        new InformacionProducto().setVisible(true);

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
            }
        });
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Viduc = new javax.swing.JButton();
        Total = new javax.swing.JButton();
        Iml = new javax.swing.JButton();
        Truper = new javax.swing.JButton();
        SinMarca = new javax.swing.JButton();
        Susan = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pastel.png"))); // NOI18N
        jButton1.setText("Marcas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 230, 60));

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barra.png"))); // NOI18N
        jButton2.setText("Exsistencias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 230, 60));

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
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 760, 230));

        Viduc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Viduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViducActionPerformed(evt);
            }
        });
        getContentPane().add(Viduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 100));

        Total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });
        getContentPane().add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 100, 100));

        Iml.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Iml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImlActionPerformed(evt);
            }
        });
        getContentPane().add(Iml, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 100));

        Truper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Truper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TruperActionPerformed(evt);
            }
        });
        getContentPane().add(Truper, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 100));

        SinMarca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SinMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(SinMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 100, 100));

        Susan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Susan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SusanActionPerformed(evt);
            }
        });
        getContentPane().add(Susan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, 100));

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NuevaEmpresa.png"))); // NOI18N
        jButton3.setText("Inventario a pdf");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 230, 60));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new GraficaMarcas().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new GraficaExsistencia().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ViducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViducActionPerformed

        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos where marca = 'Viduc'");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }

            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_ViducActionPerformed

    private void TruperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TruperActionPerformed

        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos where marca = 'Truper'");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }
            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_TruperActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed

        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos where marca = 'Total'");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }

            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_TotalActionPerformed

    private void SinMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinMarcaActionPerformed
        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }

            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_SinMarcaActionPerformed

    private void ImlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImlActionPerformed
        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos where marca = 'Iml'");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }

            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_ImlActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Document pdf = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(pdf, new FileOutputStream(ruta + "/Desktop/Inventario.pdf"));

            com.itextpdf.text.Image head = com.itextpdf.text.Image.getInstance("src/images/Banner.png");
            head.scaleToFit(650, 1000);
            head.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial Black", 8, Font.BOLD, BaseColor.LIGHT_GRAY));
            parrafo.add("Programa hecho por B.A.G.G © \n\n");

            parrafo.setFont(FontFactory.getFont("Arial Black", 14, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Inventario de Ferrerteria y cerrajeria G&G \n\n");

            pdf.open();

            pdf.add(head);
            pdf.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            
            tabla.addCell("Nombre del articulo");
            tabla.addCell("Marca");
            tabla.addCell("Exsistencias");
            tabla.addCell("Precio");

            try {
                Connection cn = Conexiones.conexion();
                PreparedStatement pst = cn.prepareStatement("select Nombre, Marca, Existencias, Precio from articulos");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {

                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));

                    } while (rs.next());

                    pdf.add(tabla);

                } else {
                }

            } catch (Exception e) {
            }
            pdf.close();
            JOptionPane.showMessageDialog(null, "PDF creado");
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void SusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SusanActionPerformed
        for (int i = 0; i < Table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Marca, Precio,Existencias from articulos where marca = 'Inversiones Asiaticas'");

            ResultSet rs1 = pst1.executeQuery();

            Table = new JTable(model);
            jScrollPane1.setViewportView(Table);

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }

            Table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = Table.rowAtPoint(e.getPoint());
                    int Columna = 0;
                    if (Filap >= -1) {
                        try {
                            producto = (int) model.getValueAt(Filap, Columna);

                            new InformacionProducto().setVisible(true);

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_SusanActionPerformed

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
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Provedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Provedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iml;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JButton SinMarca;
    private javax.swing.JButton Susan;
    private javax.swing.JTable Table;
    private javax.swing.JButton Total;
    private javax.swing.JButton Truper;
    private javax.swing.JButton Viduc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
