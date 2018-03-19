/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampus.go;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


public class UrunEkleActivity extends javax.swing.JFrame {

    MasaDetay masaDetay;
    Database db=new Database();
    int seciliKategori=-1;
    ArrayList<Kategori> kategoriler;
    ArrayList<Urun> urunler;
    Urun seciliUrun=null;

    public UrunEkleActivity(MasaDetay masaDetay) {
        initComponents();
        this.masaDetay=masaDetay;
        try {
            getKategoriler();
            getUrunler();
        } catch (SQLException ex) {
            Logger.getLogger(UrunEkleActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        urunlerList = new javax.swing.JList<>();
        kategorilerCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ekleBtn = new javax.swing.JButton();

        setTitle("Ürün Ekle");

        jLabel1.setText("Eklenecek Ürünü Seçiniz:");

        urunlerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        urunlerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urunlerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(urunlerList);

        kategorilerCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Kategori:");

        ekleBtn.setText("Ekle");
        ekleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategorilerCB, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(ekleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kategorilerCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ekleBtn)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleBtnActionPerformed
        if(seciliUrun!=null){
            try {
                masaDetay.setUrun(seciliUrun);
            } catch (SQLException ex) {
                Logger.getLogger(UrunEkleActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.hide();}
        else
            JOptionPane.showMessageDialog(this,"Lütfen eklenecek ürünü seçiniz...");    
    }//GEN-LAST:event_ekleBtnActionPerformed

    private void urunlerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urunlerListMouseClicked
        if(evt.getClickCount()>=2){
            if(seciliUrun!=null){
            try {
                masaDetay.setUrun(seciliUrun);
            } catch (SQLException ex) {
                Logger.getLogger(UrunEkleActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.hide();}
        else
            JOptionPane.showMessageDialog(this,"Lütfen eklenecek ürünü seçiniz...");    
        }
    }//GEN-LAST:event_urunlerListMouseClicked
   
    void getUrunler() throws SQLException{
        seciliKategori=kategoriler.get(kategorilerCB.getSelectedIndex()).getId();
        urunler=db.tumUrunler(seciliKategori);
        int i=0;
        DefaultListModel<String> lm=new DefaultListModel<>();
        for(Urun u:urunler){
            lm.add(i++, u.getIsim());
        }
        urunlerList.setModel(lm);
        
        urunlerList.getSelectionModel().addListSelectionListener((lse) -> {
            if(urunlerList.getSelectedIndex()!=-1)
            seciliUrun= urunler.get(urunlerList.getSelectedIndex());
        });
    }
    void getKategoriler() throws SQLException{
        kategoriler=db.kategorileriCek();
        DefaultComboBoxModel<String> cm=new DefaultComboBoxModel<>();
        for(Kategori k:kategoriler){
            cm.addElement(k.getIsim());
        }
        kategorilerCB.setModel(cm);
        kategorilerCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                seciliKategori=kategoriler.get(kategorilerCB.getSelectedIndex()).getId();
                try {
                    getUrunler();
                } catch (SQLException ex) {
                    Logger.getLogger(UrunEkleActivity.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategorilerCB;
    private javax.swing.JList<String> urunlerList;
    // End of variables declaration//GEN-END:variables
}
