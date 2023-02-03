package Controller;

import DAO.Buy_orderDAOImpl;
import DAO.StockDAOImpl;
import Model.Stock;
import Views.ViewBuy_order;
import iDao_interfaces.IBuy_orderDAO;
import Model.Buy_order;
import iDao_interfaces.IStockDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Buy_orderController {
    ViewBuy_order view = new ViewBuy_order();
    public Buy_orderController(){}

    /*/ --------- DAO to CREATE
    public void create(Buy_order buy_order){
        IBuy_orderDAO daoBuyOrder = new Buy_orderDAOImpl();
        daoBuyOrder.create(buy_order);
    } */

    public void create(Buy_order buy_order){
        IBuy_orderDAO daoBuyOrder = new Buy_orderDAOImpl();
        IStockDAO daoStock = new StockDAOImpl();

        Stock stock = daoStock.getStockByStoreAndAlbumName(buy_order.getStore_id_fk(), buy_order.getAlbum_name_fk());

        if(stock.getQuantity()>=buy_order.getQuantity()){
            daoBuyOrder.create(buy_order);
            stock.setQuantity(stock.getQuantity() - buy_order.getQuantity());
            daoStock.update(stock);
        } else {
            System.out.println("Item out of stock");
        }


    }

    // --------- DAO to READ
    public List<Buy_order> getAllBuyOrders(){
        List<Buy_order> BuyOrderList = new ArrayList<>();
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        BuyOrderList = dao.getAllBuyOrders();
        view.ViewBuy_orders(BuyOrderList);
        return BuyOrderList;
    }

    public List<Buy_order> getBuyOrdersByAlbum(String album_name_fk){
        List<Buy_order> BuyOrderList = new ArrayList<>();
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        BuyOrderList = dao.getBuyOrderByAlbumId(album_name_fk);
        view.ViewBuy_orders(BuyOrderList);
        return BuyOrderList;
    }

    public Buy_order getBuyOrderById(int idBuy_order){
        Buy_order buyOrderByID = new Buy_order();
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        buyOrderByID = dao.getBuyOrderById(idBuy_order);
        view.ViewBuy_orders(buyOrderByID);
        return buyOrderByID;
    }

    public List<Buy_order> getBuyOrdersByStoreId(int Store_id_fk){
        List<Buy_order> BuyOrderList = new ArrayList<>();
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        BuyOrderList = dao.getBuyOrdersByStoreId(Store_id_fk);
        view.ViewBuy_orders(BuyOrderList);
        return BuyOrderList;
    }

    // --------- DAO to UPDATE
    public void update(Buy_order buy_order){
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        dao.update(buy_order);
    }

    // --------- DAO to DELETE
    public void delete(Buy_order buy_order){
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        dao.delete(buy_order);
    }

}
