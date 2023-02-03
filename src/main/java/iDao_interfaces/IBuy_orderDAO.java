package iDao_interfaces;

import Model.Buy_order;
import java.util.List;

public interface IBuy_orderDAO {
    // --- CREATE
    boolean create(Buy_order buy_order);
    // --- READ
    List<Buy_order> getAllBuyOrders();
    List<Buy_order> getBuyOrderByAlbumId(String album_name_fk);
    List<Buy_order> getBuyOrdersByStoreId(int Store_id_fk);
    Buy_order getBuyOrderById(int idBuy_order);
    // --- UPDATE
    boolean update(Buy_order buy_order);
    // --- DELETE
    boolean delete(Buy_order buy_order);
}
