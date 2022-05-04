/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Nasir
 */
public class historypanel extends javax.swing.JPanel {

    /**
     * Creates new form historypanel
     */
    
    String st_sender,st_receiver, st_email,st_amount;
    
    public historypanel() {
        initComponents();
        load();
    }
    
    public historypanel(String sen,String rec, String ema,String amo) {
        st_sender=sen;
        st_receiver=rec;
        st_email=ema;
        st_amount=amo;
        initComponents();
        load();
    }

    private void load() {
        try {
            FileReader fr = new FileReader("salami.csv");
            BufferedReader fbr = new BufferedReader(fr);
            String data = "";
            int c;
            try {
                while ((c = fbr.read()) != -1) {
                    data += (char) c;
                }

                String processeddata[] = data.split(",|\\\n");
                System.out.println(processeddata);
                for (int i = 0; i < processeddata.length; i++) {
                    System.out.println(processeddata[i]);
                }
                int totsum = 0;
                ArrayList<String> val = new ArrayList<>();
                for (int i = 0; i < processeddata.length; i++) {
                    if (i % 4 == 0) {
                        val.add(processeddata[i]);
                    }
                    if (i % 4 == 3) {
                        val.add(processeddata[i]);
                        totsum += Integer.parseInt(processeddata[i]);
                    }
                }

                totalpanel tp = new totalpanel();
                tp.setTaka(Integer.toString(totsum) + " Taka");
                int space = 4-Integer.toString(totsum).length();
                String sp = "";
                for (int j = 0; j < space; j++) {
                    sp += " ";
                }
                tp.setTaka(sp + tp.gettaka());
                scpane.add(tp);
                scpane.revalidate();
                scpane.repaint();

                int n = val.size()/2;
                scpane.setPreferredSize(new Dimension(scpane.getWidth(), 40 + n * 40));
                scpane.revalidate();
                scpane.repaint();
                for (int i = 0; i < val.size(); i += 2) {
                    individual in = new individual();
                    in.setname(val.get(i));
                    int exspace = 4 - val.get(i + 1).length();
                    System.out.println(exspace);
                    in.settaka(val.get(i + 1) + " Taka");
                    String spp = "";
                    for (int j = 0; j < exspace; j++) {
                        spp += " ";
                    }
                    in.settaka(spp + in.gettaka());
                    scpane.add(in);
                    scpane.revalidate();
                    scpane.repaint();
                }

            } catch (IOException ex) {
                Logger.getLogger(historypanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(historypanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        salami = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scpane = new javax.swing.JPanel();

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 75, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(245, 75, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        salami.setBackground(new java.awt.Color(245, 75, 100));
        salami.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salami.setForeground(new java.awt.Color(255, 255, 255));
        salami.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salami.setText("Receive Salami");
        salami.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salamiMouseClicked(evt);
            }
        });
        jPanel4.add(salami, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 40));

        jPanel5.setBackground(new java.awt.Color(233, 29, 61));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("History");
        jPanel5.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, 40));

        jPanel6.setBackground(new java.awt.Color(245, 75, 100));

        logout.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 150, 40));

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 400));

        jPanel2.setBackground(new java.awt.Color(36, 42, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("History");
        title.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(550, 32767));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(550, 1400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(550, 1400));

        scpane.setBackground(new java.awt.Color(36, 42, 56));
        scpane.setMaximumSize(new java.awt.Dimension(550, 1000));
        scpane.setMinimumSize(new java.awt.Dimension(550, 320));
        scpane.setPreferredSize(new java.awt.Dimension(550, 1000));
        scpane.setLayout(new javax.swing.BoxLayout(scpane, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(scpane);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 550, 320));
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 550, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        logoutpanel lgp = new logoutpanel(st_sender,st_receiver,st_email,st_amount);
        getParent().add(lgp);
        lgp.setVisible(true);
        JFrame frame = new JFrame();
        int n = JOptionPane.showConfirmDialog(frame, "Would you like to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
        //System.out.println(n);
        if (n == 0) {
            lgp.setVisible(false);
            loginpanel lp = new loginpanel();
            getParent().add(lp);
            lp.setVisible(true);
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void salamiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salamiMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        detailspanel dp = new detailspanel(st_sender,st_receiver,st_email,st_amount);
        getParent().add(dp);
        dp.setVisible(true);
    }//GEN-LAST:event_salamiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel salami;
    private javax.swing.JPanel scpane;
    private javax.swing.JPanel title;
    // End of variables declaration//GEN-END:variables
}
