/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampus.go;

/**
 *
 * @author ramazan
 */
public class Urun {
    private int id,kategori;
    private float fiyat;
    private String isim;
    
    public Urun(){
        
    }

    public Urun(int id,String isim,int kategori,float fiyat){
        this.id=id;
        this.isim=isim;
        this.kategori=kategori;
        this.fiyat=fiyat;
    }
    public Urun(String isim,int kategori,float fiyat){
        this.isim=isim;
        this.kategori=kategori;
        this.fiyat=fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKategori() {
        return kategori;
    }

    public void setKategori(int kategori) {
        this.kategori = kategori;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    
    
    
}
