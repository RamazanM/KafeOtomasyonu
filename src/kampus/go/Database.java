package kampus.go;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    
    private Connection connection;
    
    public Database(){

    }
    
    private void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            String exePath=System.getProperty("user.dir");
            connection=DriverManager.getConnection("jdbc:sqlite:"+exePath+"/database.db");
            System.out.println(exePath+"/database.db");
            System.out.println("Database Connected");
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    private void disconnect() throws SQLException{
        System.out.println("Disconnect");
        connection.close();
    }
    
    
    
    public ArrayList<Masa> tumMasalar() throws SQLException{
        connect();
        String sql="SELECT * FROM masalar";
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        
        ArrayList<Masa> returnList=new ArrayList<>();
        
        while(rs.next()){
            Masa masa=new Masa(rs.getInt("id"),
                               rs.getInt("masa_no"));
            returnList.add(masa);
        }
        disconnect();
        return returnList;
    }
    
    public int masaEkle(int masaNo) throws SQLException{
        connect();
        String sql="INSERT INTO masalar(masa_no) VALUES(?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, masaNo);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;

    }
    
    public int masaSil(int masaId) throws SQLException{
        connect();
        String sql="DELETE FROM masalar WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, masaId);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;

    }
   
    public ArrayList<Urun> tumUrunler(int kategoriId) throws SQLException{
        connect();
        String sql="SELECT * FROM urunler";
        if(kategoriId!=-1) sql+=" WHERE kategori="+kategoriId;
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        
        ArrayList<Urun> returnList=new ArrayList<>();
        
        while(rs.next()){
            Urun urun=new Urun(rs.getInt("id"),
                               rs.getString("isim"),
                               rs.getInt("kategori"),
                               rs.getFloat("fiyat"));
            returnList.add(urun);
        }
        disconnect();
        return returnList;
    }
    
    public int urunEkle(Urun urun) throws SQLException{
        connect();
        String sql="INSERT INTO urunler(isim,kategori,fiyat) VALUES(?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setString(1, urun.getIsim());
        stmt.setInt(2, urun.getKategori());
        stmt.setFloat(3, urun.getFiyat());
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
   }
    
    public int urunDuzenle(Urun urun) throws SQLException{
        connect();
        String sql="UPDATE urunler SET isim=?, kategori=?, fiyat=? WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setString(1, urun.getIsim());
        stmt.setInt(2, urun.getKategori());
        stmt.setFloat(3, urun.getFiyat());
        stmt.setInt(4, urun.getId());
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    
    public int urunSil(int urunId) throws SQLException{
        connect();
        String sql="DELETE FROM urunler WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, urunId);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    
    public ArrayList<Kategori> kategorileriCek() throws SQLException{
        connect();
        String sql="SELECT * FROM kategoriler";
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        
        ArrayList<Kategori> returnList=new ArrayList<>();
        
        while(rs.next()){
            Kategori kategori=new Kategori(rs.getInt("id"),rs.getString("isim"));
            returnList.add(kategori);
        }
        disconnect();
        return returnList;
    }
    
    public int kategoriEkle(Kategori kategori) throws SQLException{
        connect();
        String sql="INSERT INTO kategoriler(isim) VALUES(?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setString(1, kategori.getIsim());
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }

    public int kategoriDuzenle(Kategori kategori) throws SQLException{
        connect();
        String sql="UPDATE kategoriler SET isim=? WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setString(1, kategori.getIsim());
        stmt.setInt(2, kategori.getId());
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }

    public int kategoriSil(int kategoriId) throws SQLException{
        connect();
        String sql="DELETE FROM kategoriler WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, kategoriId);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    
    public int masadaAdisyonVar(int masaId) throws SQLException{
        connect();
        boolean masadaAdisyonVar=false;
        int adisyonId;
        String sql="SELECT * FROM adisyon WHERE aktif=1 AND masa_id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, masaId);
        ResultSet rs=stmt.executeQuery();
        masadaAdisyonVar=rs.next();
        if(masadaAdisyonVar){
            adisyonId=rs.getInt("id");
            return adisyonId;
        }
        else adisyonId=-1;
        disconnect();
        return adisyonId;
        
    }
        
    public ArrayList<Satis> adisyonuCek(int masaId) throws SQLException{
        connect();
        ArrayList<Satis> satislar=new ArrayList<>();
        int adisyonId=masadaAdisyonVar(masaId);
        if(adisyonId!=-1){
            String sql="select urun_adisyon.id,urun_adisyon.odendi, urunler.id as urunId,urunler.isim,urunler.kategori,urunler.fiyat from urun_adisyon inner join urunler on urun_adisyon.urun_id=urunler.id where urun_adisyon.adisyon_id=?  ORDER by urunler.isim DESC";
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, adisyonId);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Urun urun=new Urun(rs.getInt("urunId"),
                        rs.getString("isim"),
                        rs.getInt("kategori"),
                        rs.getFloat("fiyat"));
                Satis satis=new Satis(rs.getInt("id"),urun,rs.getInt("odendi"));
                satislar.add(satis);
            }
        }
        disconnect();
        return satislar;

    }
            
    public int adisyonaUrunEkle(int masaId,Urun urun) throws SQLException{
        
        //Eğer masaya ait bir adisyon varsa o adisyona gelen ürünü ekle
        //Yoksa adisyon aç.
        connect();

        boolean masadaAdisyonVar=false;
        int adisyonId;
        String sql="SELECT * FROM adisyon WHERE aktif=1 AND masa_id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, masaId);
        ResultSet rs=stmt.executeQuery();
        masadaAdisyonVar=rs.next();
        
        if(masadaAdisyonVar){
            adisyonId=rs.getInt("id");
            sql="INSERT INTO urun_adisyon(urun_id,adisyon_id,odendi) VALUES(?,?,0)";
            stmt=connection.prepareStatement(sql);
            stmt.setInt(1, urun.getId());
            stmt.setInt(2, adisyonId);
            int ret=stmt.executeUpdate(); 
            disconnect();
            return ret;
        }
        else{
            sql="INSERT INTO adisyon(masa_id,aktif,tarih) VALUES(?,1,date('now'))";
            stmt=connection.prepareStatement(sql);
            stmt.setInt(1, masaId);
            stmt.executeUpdate();
            rs=stmt.getGeneratedKeys();
            if(rs.next()){
                adisyonId=rs.getInt(1);
                sql="INSERT INTO urun_adisyon(urun_id,adisyon_id,odendi) VALUES(?,?,0)";
                stmt=connection.prepareStatement(sql);
                stmt.setInt(1, urun.getId());
                stmt.setInt(2, adisyonId);
                int ret=stmt.executeUpdate(); 
                disconnect();
                stmt.close();
                return ret;
            }
            else{
                disconnect();
                stmt.close();
                return -1;
            }

        }
    }

    public ArrayList<Adisyon>  tariheGoreAdisyonCek(String tarih) throws SQLException{        
        //2018-02-12 tarih tipi
        //yyyy-MM-dd
        connect();
        String sql="SELECT masalar.masa_no,sum(urunler.fiyat) as toplam FROM adisyon " +
                    "INNER JOIN masalar ON masalar.id=adisyon.masa_id " +
                    "INNER JOIN urun_adisyon ON urun_adisyon.adisyon_id=adisyon.id " +
                    "INNER JOIN urunler ON urunler.id=urun_adisyon.urun_id " +
                    "WHERE adisyon.tarih=? " +
                    "GROUP BY adisyon.masa_id";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setString(1, tarih);
        ResultSet rs=stmt.executeQuery();
        ArrayList<Adisyon> ret=new ArrayList<>();
        while(rs.next()){
            ret.add(new Adisyon(rs.getInt("masa_no"), rs.getFloat("toplam")));
        }
        return ret;

    }
    
    public int adisyondanUrunSil(int id) throws SQLException{
        connect();
        String sql="DELETE FROM urun_adisyon WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, id);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    
    public int adisyonuKapat(int masaId) throws SQLException{
        connect();
        boolean masadaAdisyonVar=false;
        int adisyonId=-1;
        String sql="SELECT * FROM adisyon WHERE aktif=1 AND masa_id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, masaId);
        ResultSet rs=stmt.executeQuery();
        masadaAdisyonVar=rs.next();
        if(masadaAdisyonVar){
            adisyonId=rs.getInt("id");
        }
        
        sql="UPDATE adisyon SET aktif=0 WHERE id=?";
        stmt=connection.prepareStatement(sql);
        stmt.setInt(1, adisyonId);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    
    public int urunOde(int id) throws SQLException{
        connect();
        String sql="UPDATE urun_adisyon SET odendi=1 WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, id);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
    public int urunOdeGeriAl(int id) throws SQLException{
        connect();
        String sql="UPDATE urun_adisyon SET odendi=0 WHERE id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, id);
        int ret=stmt.executeUpdate();
        disconnect();
        return ret;
    }
}
