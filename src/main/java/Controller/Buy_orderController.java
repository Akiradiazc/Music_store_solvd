package Controller;

import DAO.Buy_orderDAOImpl;
import Views.ViewBuy_order;
import iDao_interfaces.IBuy_orderDAO;
import Model.Buy_order;

import java.util.ArrayList;
import java.util.List;

public class Buy_orderController {
    ViewBuy_order view = new ViewBuy_order();
    public Buy_orderController(){}

    // --------- DAO to CREATE
    public void create(Buy_order buy_order){
        IBuy_orderDAO dao = new Buy_orderDAOImpl();
        dao.create(buy_order);
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
