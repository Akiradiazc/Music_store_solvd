package iDao_interfaces;
import Model.Stock;
import java.util.List;

public interface IStockDAO {
    // --- CREATE
    boolean create(Stock stock);
    // --- READ
    List<Stock> getAllStock();
    List<Stock> getStockByStore(int Store_id_fk);
    List<Stock> getStockByAlbum(String Album_name_fk);
    List<Stock> getStockByArtist(String Artist_name_fk);
    Stock getStockById(int idStock);
    Stock getStockByStoreAndAlbumName(int Store_id_fk, String Album_name_fk);
    // --- UPDATE
    boolean update(Stock stock);
    // --- DELETE
    boolean delete(Stock stock);
}
