/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muficterials;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;


public class DrawScroll {
    
     public JComponent makeUI() {
    JTextArea cmp = new JTextArea();
    String str = "1234567890abcdefghijklmnopqrstuvwxyz";
    for(int i=0; i<20; i++) {
      cmp.append(str+str+"\n");
    }
    cmp.setForeground(Color.WHITE);
    cmp.setBackground(Color.BLACK);
    cmp.setOpaque(true);

    JScrollPane scrollPane = new JScrollPane(
      cmp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setComponentZOrder(scrollPane.getVerticalScrollBar(), 0);
    scrollPane.setComponentZOrder(scrollPane.getViewport(), 1);
    scrollPane.getVerticalScrollBar().setOpaque(false);

    scrollPane.setLayout(new ScrollPaneLayout() {
      @Override
      public void layoutContainer(Container parent) {
        JScrollPane scrollPane = (JScrollPane)parent;

        Rectangle availR = scrollPane.getBounds();
        availR.x = availR.y = 0;

        Insets insets = parent.getInsets();
        availR.x = insets.left;
        availR.y = insets.top;
        availR.width  -= insets.left + insets.right;
        availR.height -= insets.top  + insets.bottom;

        Rectangle vsbR = new Rectangle();
        vsbR.width  = 12;
        vsbR.height = availR.height;
        vsbR.x = availR.x + availR.width - vsbR.width;
        vsbR.y = availR.y;

        if(viewport != null) {
          viewport.setBounds(availR);
        }
        if(vsb != null) {
          vsb.setVisible(true);
          vsb.setBounds(vsbR);
        }
      }
    });
    scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
      private final Dimension d = new Dimension();
      @Override protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
          @Override public Dimension getPreferredSize() {
            return d;
          }
        };
      }
      @Override protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
          @Override public Dimension getPreferredSize() {
            return d;
          }
        };
      }
      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar)c;
        if(!sb.isEnabled() || r.width>r.height) {
          return;
        }else if(isDragging) {
          color = new Color(200,200,100,200);
        }else if(isThumbRollover()) {
          color = new Color(255,255,100,200);
        }else {
          color = new Color(220,220,200,200);
        }
        g2.setPaint(color);
        g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
        g2.setPaint(Color.WHITE);
        g2.drawRoundRect(r.x,r.y,r.width,r.height,10,10);
        g2.dispose();
      }
      @Override
      protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
      }
    });
    return scrollPane;
  }
}
