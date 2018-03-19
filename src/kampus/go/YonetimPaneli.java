/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampus.go;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramazan
 */
public class YonetimPaneli extends javax.swing.JFrame {

    static Database db=new Database();
    ArrayList<Kategori> kategoriler;
    ArrayList<Urun> urunler;
    Urun selectedUrun=null;
    String seciliTarih;
    Kategori seciliKategori=null;
    
    public YonetimPaneli() throws SQLException {
        Date today=new Date();
        this.seciliTarih=new SimpleDateFormat("yyyy-MM-dd").format(today);
        
        System.out.println(seciliTarih);
        
        initComponents();
        urunListeDoldur();
        kategorileriDoldur();
        satisOzetiGuncelle(seciliTarih);
        

        satisOzetiTarih.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                seciliTarih=new SimpleDateFormat("yyyy-MM-dd").format(satisOzetiTarih.getValue());
                System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(satisOzetiTarih.getValue()));
                satisOzetiGuncelle(seciliTarih);
                 
            }
        });

        
        urunlerTbl.getSelectionModel().addListSelectionListener((tme) -> {
                if(urunlerTbl.getSelectedRow()!=-1){
                    selectedUrun=urunler.get(urunlerTbl.getSelectedRow());
                    urunAdi.setText(selectedUrun.getIsim());
                    urunFiyati.setText(selectedUrun.getFiyat()+"");
                    urunKategori.setSelectedIndex(katIdToKatIndex(selectedUrun.getKategori()));
                    duzenleBtn.setText("Düzenle("+selectedUrun.getIsim()+")");
                    silBtn.setText("Sil("+selectedUrun.getIsim()+")");
                }
            });


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        urunAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        urunKategori = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        urunFiyati = new javax.swing.JTextField();
        ekleBtn = new javax.swing.JButton();
        duzenleBtn = new javax.swing.JButton();
        silBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        urunlerTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kategoriAdiTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        kategorilerList = new javax.swing.JList<>();
        katEkleBtn = new javax.swing.JButton();
        katDuzenleBtn = new javax.swing.JButton();
        katSilBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        satisOzetiTarih = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        satisOzetiTbl = new javax.swing.JTable();

        setTitle("Yönetim Paneli");

        jLabel2.setText("Ürün Adı:");

        jLabel3.setText("Kategorisi:");

        urunKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Fiyatı:");

        ekleBtn.setText("Ekle");
        ekleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleBtnActionPerformed(evt);
            }
        });

        duzenleBtn.setText("Düzenle");
        duzenleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzenleBtnActionPerformed(evt);
            }
        });

        silBtn.setText("Sil");
        silBtn.setToolTipText("");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(urunlerTbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ekleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(urunAdi)
                            .addComponent(urunKategori, 0, 174, Short.MAX_VALUE)
                            .addComponent(urunFiyati)))
                    .addComponent(duzenleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(silBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(urunKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(urunFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ekleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(duzenleBtn)
                        .addGap(18, 18, 18)
                        .addComponent(silBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        urunAdi.getAccessibleContext().setAccessibleName("");
        urunAdi.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Ürünler", jPanel1);

        jLabel1.setText("Kategori Adı:");

        kategorilerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kategorilerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(kategorilerList);

        katEkleBtn.setText("Ekle");
        katEkleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                katEkleBtnActionPerformed(evt);
            }
        });

        katDuzenleBtn.setText("Düzenle");
        katDuzenleBtn.setEnabled(false);
        katDuzenleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                katDuzenleBtnActionPerformed(evt);
            }
        });

        katSilBtn.setText("Sil");
        katSilBtn.setEnabled(false);
        katSilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                katSilBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategoriAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(katEkleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(katDuzenleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(katSilBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kategoriAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(katEkleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(katDuzenleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(katSilBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kategoriler", jPanel2);

        satisOzetiTarih.setModel(new javax.swing.SpinnerDateModel());
        satisOzetiTarih.setEditor(new javax.swing.JSpinner.DateEditor(satisOzetiTarih, "dd-MM-yyyy"));

        satisOzetiTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(satisOzetiTbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(satisOzetiTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(satisOzetiTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Satış Özeti", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleBtnActionPerformed
        if(!isNumeric(urunFiyati.getText().replace(",",".")) ||urunAdi.getText()==null){
            JOptionPane.showMessageDialog(null,"Lütfen geçerli bir değer giriniz.");
            return;
        }
        Urun urun=new Urun(urunAdi.getText(),
                kategoriler.get(urunKategori.getSelectedIndex()).getId(),
                Float.parseFloat(urunFiyati.getText().replace(",", ".")));
        
        try {
            db.urunEkle(urun);
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        urunListeDoldur();
        
        
        
    }//GEN-LAST:event_ekleBtnActionPerformed

    private void duzenleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzenleBtnActionPerformed
        if(selectedUrun==null){
            JOptionPane.showMessageDialog(null,"Lütfen bir ürün seçiniz.");
            return; 
        }
        if(!isNumeric(urunFiyati.getText().replace(",",".")) ||urunAdi.getText()==null){
            JOptionPane.showMessageDialog(null,"Lütfen geçerli bir değer giriniz.");
            return;
        }
        Urun urun=selectedUrun;
        urun.setIsim(urunAdi.getText());
        urun.setFiyat(Float.parseFloat(urunFiyati.getText()));
        urun.setKategori(kategoriler.get(urunKategori.getSelectedIndex()).getId());
        try {
            db.urunDuzenle(urun);
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        urunListeDoldur();
    }//GEN-LAST:event_duzenleBtnActionPerformed

    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
        if(selectedUrun==null){
            JOptionPane.showMessageDialog(null,"Lütfen bir veri seçiniz.");
            return;
        }
        try {
            db.urunSil(selectedUrun.getId());
            urunListeDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_silBtnActionPerformed

    private void katEkleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_katEkleBtnActionPerformed
        System.out.println("data:-"+kategoriAdiTxt.getText()+"-");
        if(kategoriAdiTxt.getText().isEmpty()||kategoriAdiTxt.getText()==" "){
            JOptionPane.showMessageDialog(null,"Lütfen geçerli bir isim giriniz.");
            return;
        }
        try {
            db.kategoriEkle(new Kategori(kategoriAdiTxt.getText()));
            kategorileriDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_katEkleBtnActionPerformed

    private void katDuzenleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_katDuzenleBtnActionPerformed
        if(kategoriAdiTxt.getText().isEmpty()||kategoriAdiTxt.getText()==" "){
            JOptionPane.showMessageDialog(null,"Lütfen geçerli bir isim giriniz.");
            return;
        }
        if(seciliKategori==null){
            JOptionPane.showMessageDialog(null,"Lütfen bir kategori seçiniz.");
            return;
        }
        try {
            db.kategoriDuzenle(new Kategori(seciliKategori.getId(), kategoriAdiTxt.getText()));
            kategorileriDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_katDuzenleBtnActionPerformed

    private void katSilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_katSilBtnActionPerformed
        if(seciliKategori==null){
            JOptionPane.showMessageDialog(null,"Lütfen bir kategori seçiniz.");
            return;
        }
        try {
            db.kategoriSil(seciliKategori.getId());
            kategorileriDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_katSilBtnActionPerformed

    private void kategorilerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kategorilerListMouseClicked
        if(seciliKategori!=null){
            katDuzenleBtn.setEnabled(true);
            katSilBtn.setEnabled(true);
        }
    }//GEN-LAST:event_kategorilerListMouseClicked

    
    public void satisOzetiGuncelle(String tarih){
        DefaultTableModel tm=new DefaultTableModel();
        tm.addColumn("Masa No");
        tm.addColumn("Toplam Satış");
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();
        try {
            ArrayList<Adisyon> adisyonlar=db.tariheGoreAdisyonCek(tarih);
            adisyonlar.forEach(a->{
                System.out.println(a.masa_no+","+a.toplam);
                Object[] data={a.masa_no,a.toplam};
                tm.addRow(data);
                
            });
        } catch (SQLException ex) {
            Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        satisOzetiTbl.setModel(tm);

        
        
    }
    
    public void kategorileriDoldur() throws SQLException{
        kategoriler=db.kategorileriCek();
        seciliKategori=null;
        
        kategoriAdiTxt.setText("");
        katDuzenleBtn.setEnabled(false);
        katSilBtn.setEnabled(false);
        
        DefaultComboBoxModel<String> cm=new DefaultComboBoxModel<>();
        DefaultListModel<Kategori> lm=new DefaultListModel<Kategori>();
        
        int i=0;
        for(Kategori kategori:kategoriler){
            cm.addElement(kategori.getIsim());
            lm.addElement(kategori);
        }
        urunKategori.setModel(cm);
        kategorilerList.setModel(lm);
        kategorilerList.addListSelectionListener((lse) -> {
            seciliKategori=kategorilerList.getSelectedValue();
            if(seciliKategori!=null)kategoriAdiTxt.setText(seciliKategori.getIsim());
        });
    }
    
    public void urunListeDoldur(){
        DefaultTableModel tm=new DefaultTableModel();
        tm.addColumn("İsim");
        tm.addColumn("Fiyat");
        int sayac=0;
        try {
                    urunler=db.tumUrunler(-1);
                    for(Urun urun:urunler){
                        String text=urun.getIsim()+"<div style='float:right;>"+urun.getFiyat()+"</div>";
                        Object[] data = {urun.getIsim(),urun.getFiyat()};
                        tm.addRow(data);
                    }
                    
                            } catch (SQLException ex) {
                    Logger.getLogger(YonetimPaneli.class.getName()).log(Level.SEVERE, null, ex);
                }
        urunlerTbl.setModel(tm);
    }

    public int katIdToKatIndex(int katId){
        int i=0;
        while(kategoriler.get(i).getId()!=katId){
            i++;
            System.out.println("i:"+i);
        }
        return i;
    }
    
    
    
    public boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    }  
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton duzenleBtn;
    private javax.swing.JButton ekleBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton katDuzenleBtn;
    private javax.swing.JButton katEkleBtn;
    private javax.swing.JButton katSilBtn;
    private javax.swing.JTextField kategoriAdiTxt;
    private javax.swing.JList<Kategori> kategorilerList;
    private javax.swing.JSpinner satisOzetiTarih;
    private javax.swing.JTable satisOzetiTbl;
    private javax.swing.JButton silBtn;
    private javax.swing.JTextField urunAdi;
    private javax.swing.JTextField urunFiyati;
    private javax.swing.JComboBox<String> urunKategori;
    private javax.swing.JTable urunlerTbl;
    // End of variables declaration//GEN-END:variables
}
