package Controller;

import DAO.StockDAOImpl;
import Model.Stock;
import Views.ViewStock;
import Views.ViewStore;
import iDao_interfaces.IStockDAO;

import java.util.ArrayList;
import java.util.List;

public class StockController {
    ViewStock view = new ViewStock();
    public StockController(){}
    // --- CREATE
    public void create(Stock stock){
        IStockDAO dao = new StockDAOImpl();
        dao.create(stock);
    }
    // --- READ
    public List<Stock> getAllStock(){
        List<Stock> StockList = new ArrayList<>();
        IStockDAO dao = new StockDAOImpl();
        StockList = dao.getAllStock();
        view.ViewStocks(StockList);
        return StockList;
    }
    public List<Stock> getStockByStore(int Store_id_fk){
        List<Stock> StockList = new ArrayList<>();
        IStockDAO dao = new StockDAOImpl();
        StockList = dao.getStockByStore(Store_id_fk);
        view.ViewStocks(StockList);
        return StockList;
    }
    public List<Stock> getStockByAlbum(String Album_name_fk){
        List<Stock> StockList = new ArrayList<>();
        IStockDAO dao = new StockDAOImpl();
        StockList = dao.getStockByAlbum(Album_name_fk);
        view.ViewStocks(StockList);
        return StockList;
    }
    public List<Stock> getStockByArtist(String Artist_name_fk){
        List<Stock> StockList = new ArrayList<>();
        IStockDAO dao = new StockDAOImpl();
        StockList = dao.getStockByArtist(Artist_name_fk);
        view.ViewStocks(StockList);
        return StockList;
    }
    public Stock getStockById(int idStock){
        Stock stock = new Stock();
        IStockDAO dao = new StockDAOImpl();
        stock = dao.getStockById(idStock);
        view.ViewStocks(stock);
        return stock;
    }

    public Stock getStockByStoreAndAlbumName(int Store_id_fk, String Album_name_fk){
        Stock stock = new Stock();
        IStockDAO dao = new StockDAOImpl();
        stock = dao.getStockByStoreAndAlbumName(Store_id_fk, Album_name_fk);
        view.ViewStocks(stock);
        return stock;
    }
    // --- UPDATE
    public void update(Stock stock){
        IStockDAO dao = new StockDAOImpl();
        dao.update(stock);
    }
    // --- DELETE
    public void delete(Stock stock){
        IStockDAO dao = new StockDAOImpl();
        dao.delete(stock);
    }
}
