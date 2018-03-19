/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampus.go;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ramazan
 */
public class KampusGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        System.out.println(System.getProperty("user.dir"));
        Database db=new Database();
        ArrayList<Urun> urunler=db.tumUrunler(1);
        for(Urun urun:urunler){
            System.out.println(urun.getIsim());
        }
    }
    
}
