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
public class Satis {
    private int id;
    private int odendi;
    private Urun urun;

    public Satis(int id, Urun urun,int odendi) {
        this.id = id;
        this.urun = urun;
        this.odendi=odendi;
                
    }

    public Satis(Urun urun,int odendi) {
        this.odendi=odendi;
        this.urun = urun;
    }

    public int getOdendi() {
        return odendi;
    }

    public void setOdendi(int odendi) {
        this.odendi = odendi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    @Override
    public String toString() {
        return this.urun.getIsim();//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
