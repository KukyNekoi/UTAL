/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fondo.java
 *
 * Created on 07-12-2009, 12:42:12 AM
 */

package day_of_sagitarius;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import javax.swing.*;
/**
 *
 * @author kuroneko
 */
public class Fondo extends javax.swing.JPanel {

    /** Creates new form Fondo */
    ImageIcon Fondo;
    public Fondo(ImageIcon fondo) {
        this.Fondo = fondo;
        initComponents();
    }
    @Override
    public void paintComponent(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = this.Fondo;
        g.drawImage(imagenFondo.getImage(), 0, 0,
                tamanio.width, tamanio.height, null);
        setOpaque(false);

        super.paintComponent(g);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
