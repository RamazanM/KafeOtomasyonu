/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampus.go;

import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MasaDetay extends javax.swing.JFrame {
    private MainActivity mainActivity=null;
    private Urun gelenUrun=null;
    private Satis seciliSatis=null;
    private Satis seciliOdenen=null;
    private Masa masa;
    private Database db=new Database();
    public MasaDetay(Masa masa,MainActivity mainActivity) {
        this.masa=masa;
        this.mainActivity=mainActivity;
        initComponents();
        initVars();
        this.setTitle("Masa Detayı ("+masa.getMasaNo()+")");
        try {
            satislariCek();
        } catch (SQLException ex) {
            Logger.getLogger(MasaDetay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        masaNoLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        satislarList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        toplamLbl = new javax.swing.JLabel();
        tumunuOdeBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        odenelerList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        secilenlerLbl = new javax.swing.JLabel();
        secilenleriOdeBtn = new javax.swing.JButton();
        urunEkleBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        odenenLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kalanLbl = new javax.swing.JLabel();

        setTitle("Masa Detayı");
        setResizable(false);

        jLabel1.setText("Satışlar:");

        jLabel2.setText("Masa No:");

        masaNoLbl.setText("12");

        satislarList.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        satislarList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                satislarListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(satislarList);

        jLabel4.setText("Toplam:");

        toplamLbl.setText("56 TL");

        tumunuOdeBtn.setText("<html><center>Tümünü Öde<br>Adisyonu Kapat</center></html>");
        tumunuOdeBtn.setActionCommand("");
        tumunuOdeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tumunuOdeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tumunuOdeBtnActionPerformed(evt);
            }
        });

        odenelerList.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        odenelerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                odenelerListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(odenelerList);

        jLabel6.setText("Ödenenler:");

        jLabel7.setText("Seçilen:");

        secilenlerLbl.setText("12 TL");

        secilenleriOdeBtn.setText("Seçileni Öde");
        secilenleriOdeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secilenleriOdeBtnActionPerformed(evt);
            }
        });

        urunEkleBtn.setText("Ürün Ekle");
        urunEkleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunEkleBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Ödenen:");

        odenenLbl.setText("20 TL");

        jLabel11.setText("Kalan:");

        kalanLbl.setText("10TL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(masaNoLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(toplamLbl))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secilenlerLbl))
                                    .addComponent(tumunuOdeBtn)
                                    .addComponent(secilenleriOdeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(urunEkleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kalanLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(odenenLbl, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(masaNoLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(toplamLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(odenenLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(kalanLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(secilenlerLbl))
                        .addGap(21, 21, 21)
                        .addComponent(urunEkleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secilenleriOdeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tumunuOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void secilenleriOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secilenleriOdeBtnActionPerformed
        
        if(seciliSatis!=null || seciliOdenen!=null){
            try {
                if(secilenleriOdeBtn.getText()=="Seçileni Öde") db.urunOde(seciliSatis.getId());
                else if(secilenleriOdeBtn.getText()=="Seçileni Geri Al") db.urunOdeGeriAl(seciliOdenen.getId());
                satislariCek();

            } catch (SQLException ex) {
                Logger.getLogger(MasaDetay.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else{
            JOptionPane.showMessageDialog(null,"Lütfen bir ürün seçiniz.");
        }
    }//GEN-LAST:event_secilenleriOdeBtnActionPerformed

    private void urunEkleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunEkleBtnActionPerformed
       UrunEkleActivity urunEkleActivity=new UrunEkleActivity(this);
       urunEkleActivity.show();
    }//GEN-LAST:event_urunEkleBtnActionPerformed

    private void tumunuOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tumunuOdeBtnActionPerformed
        try {
            db.adisyonuKapat(masa.getId());
            satislariCek();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

                    } catch (SQLException ex) {
            Logger.getLogger(MasaDetay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tumunuOdeBtnActionPerformed

    private void satislarListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satislarListMouseClicked
        if(evt.getClickCount()>=2 && seciliSatis!=null){
            try {
                db.urunOde(seciliSatis.getId());
                satislariCek();

            } catch (SQLException ex) {
                Logger.getLogger(MasaDetay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_satislarListMouseClicked

    private void odenelerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odenelerListMouseClicked
        if(evt.getClickCount()>=2 && seciliOdenen!=null){
            try {
                db.urunOdeGeriAl(seciliOdenen.getId());
                satislariCek();
            } catch (SQLException ex) {
                Logger.getLogger(MasaDetay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_odenelerListMouseClicked

    void initVars(){
        masaNoLbl.setText(masa.getMasaNo()+"");
        toplamLbl.setText("0 TL");
        kalanLbl.setText("0 TL");
        odenenLbl.setText("0 TL");
        secilenlerLbl.setText("0 TL");
    }
    void satislariCek() throws SQLException{
        ArrayList<Satis> satislar=db.adisyonuCek(masa.getId());
        DefaultListModel<Satis> satisLm=new DefaultListModel<>();
        DefaultListModel<Satis> odendiLm=new DefaultListModel<>();
        seciliSatis=null;
        seciliOdenen=null;
        
        float sToplam=0,sKalan=0,sOdenen=0,sSecilen=0;
        
        int i=0,j=0;
        for(Satis s:satislar){
            System.out.println(s.getUrun().getIsim()+";Ödendi:"+s.getOdendi());
            if(s.getOdendi()==0){
                sToplam+=s.getUrun().getFiyat();
                sKalan+=s.getUrun().getFiyat();
                satisLm.add(i++,s);
            }
            else {
                sToplam+=s.getUrun().getFiyat();
                sOdenen+=s.getUrun().getFiyat();
                odendiLm.add(j++, s);
            }
        }
        satislarList.setModel(satisLm);
        odenelerList.setModel(odendiLm);
        
        toplamLbl.setText(sToplam+" TL");
        kalanLbl.setText(sKalan+" TL");
        odenenLbl.setText(sOdenen+" TL");
        
        satislarList.getSelectionModel().addListSelectionListener((lse) -> {
            seciliSatis=satislarList.getSelectedValue();
            if(satislarList.getSelectedValue()!=null){
            float secilenFiyat=satislarList.getSelectedValue().getUrun().getFiyat();
            secilenlerLbl.setText(secilenFiyat+" TL");
            secilenleriOdeBtn.setText("Seçileni Öde");
            }
        });
        odenelerList.getSelectionModel().addListSelectionListener((lse) -> {
            seciliOdenen=odenelerList.getSelectedValue();
            if(seciliOdenen!=null){
                float secilenFiyat=seciliOdenen.getUrun().getFiyat();
                secilenlerLbl.setText(secilenFiyat+" TL");
                secilenleriOdeBtn.setText("Seçileni Geri Al");
            }
        });
        mainActivity.masalariCek();
    }

    public void setUrun(Urun u) throws SQLException{
        this.gelenUrun=u;
        System.out.println("isim:"+gelenUrun.getIsim());
        db.adisyonaUrunEkle(masa.getId(), u);
        satislariCek();
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kalanLbl;
    private javax.swing.JLabel masaNoLbl;
    private javax.swing.JList<Satis> odenelerList;
    private javax.swing.JLabel odenenLbl;
    private javax.swing.JList<Satis> satislarList;
    private javax.swing.JLabel secilenlerLbl;
    private javax.swing.JButton secilenleriOdeBtn;
    private javax.swing.JLabel toplamLbl;
    private javax.swing.JButton tumunuOdeBtn;
    private javax.swing.JButton urunEkleBtn;
    // End of variables declaration//GEN-END:variables
}
