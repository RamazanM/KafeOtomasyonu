package kampus.go;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainActivity extends javax.swing.JFrame {

    Database db=new Database();
    ArrayList<Masa> masalar;
    Masa seciliMasa;
    public MainActivity() {
        try {
            initComponents();
            masalariCek();
        } catch (SQLException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        adisyonAc = new javax.swing.JButton();
        yonetimPaneliBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        masalarTbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Masalar");

        jLabel1.setText("Masalar");

        adisyonAc.setText("Adisyon Aç / Düzenle");
        adisyonAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adisyonAcActionPerformed(evt);
            }
        });

        yonetimPaneliBtn.setText("Yönetim Paneli");
        yonetimPaneliBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yonetimPaneliBtnActionPerformed(evt);
            }
        });

        masalarTbl.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        masalarTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        masalarTbl.setEditingColumn(0);
        masalarTbl.setEditingRow(0);
        masalarTbl.setIntercellSpacing(new java.awt.Dimension(5, 3));
        masalarTbl.setRowHeight(22);
        masalarTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                masalarTblMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(masalarTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(adisyonAc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(yonetimPaneliBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adisyonAc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yonetimPaneliBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yonetimPaneliBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yonetimPaneliBtnActionPerformed
        try {
            YonetimPaneli yp=new YonetimPaneli();
            yp.show();
        } catch (SQLException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yonetimPaneliBtnActionPerformed

    private void adisyonAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adisyonAcActionPerformed
        adisyonAc();

    }//GEN-LAST:event_adisyonAcActionPerformed

    private void masalarTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masalarTblMousePressed
        int selectedRow=masalarTbl.getSelectedRow();
        seciliMasa=masalar.get(selectedRow);
        System.out.println(selectedRow);
        System.out.println(masalar.get(selectedRow).getMasaNo());
        if(evt.getClickCount()>=2){
            adisyonAc();
            }
    }//GEN-LAST:event_masalarTblMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainActivity().setVisible(true);
        }
    });
    }
    
    void adisyonAc(){
        if(seciliMasa==null){
                JOptionPane.showMessageDialog(null,"Lütfen bir masa seçiniz.");
                return;
             }
            System.out.println(seciliMasa.getMasaNo()+"");
            MasaDetay masaDetay=new MasaDetay(seciliMasa,this);
            masaDetay.show();
        
    }
    void masalariCek() throws SQLException{
        masalar=db.tumMasalar();
        DefaultTableModel tm=new DefaultTableModel();
       
        int i=0;
       
        tm.addColumn("Masa No");
        tm.addColumn("Kalan");
        tm.addColumn("Ödenen");
        tm.addColumn("Toplam Hesap");
        
        for(Masa masa:masalar){
            float toplamSatis=0;
            float odenenSatis=0;
            float kalanSatis=0;
            
            ArrayList<Satis> satislar=db.adisyonuCek(masa.getId());
            for(Satis s:satislar){
                toplamSatis+=s.getUrun().getFiyat();
                if(s.getOdendi()==0)kalanSatis+=s.getUrun().getFiyat();
                else odenenSatis+=s.getUrun().getFiyat();
            }
            Object[] data={masa.getMasaNo(),kalanSatis,odenenSatis,toplamSatis};
            Object[] dataWoutPrice={masa.getMasaNo(),"-","-","-"};
            
            if(toplamSatis>0)
                tm.addRow(data);
            else
                tm.addRow(dataWoutPrice);
        }

        masalarTbl.setModel(tm);
        masalarTbl.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adisyonAc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable masalarTbl;
    private javax.swing.JButton yonetimPaneliBtn;
    // End of variables declaration//GEN-END:variables
}
