package Controller;

import DAO.BillDAOImpl;
import Model.Bill;
import Views.ViewBIll;
import iDao_interfaces.IBillDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillController {
    ViewBIll view = new ViewBIll();
    BillController(){}
    // --- CREATE
    public void create(Bill bill){
        IBillDAO dao = new BillDAOImpl();
        dao.create(bill);
    }
    // --- READ
    public List<Bill> getAllBill(){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getAllBill();
        view.ViewBills(BillList);
        return BillList;
    }
    public List<Bill> getBillByDate(Date date){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getBillByDate(date);
        view.ViewBills(BillList);
        return BillList;
    }
    public List<Bill> getBillByClient(int Client_id_fk){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getBillByClient(Client_id_fk);
        view.ViewBills(BillList);
        return BillList;
    }
    public List<Bill> getBillByStore(int Store_id_fk){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getBillByStore(Store_id_fk);
        view.ViewBills(BillList);
        return BillList;
    }
    public List<Bill> getBillByEmployee(int Employee_id_fk){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getBillByEmployee(Employee_id_fk);
        view.ViewBills(BillList);
        return BillList;
    }
    public List<Bill> getBillByPayingMethod(String PayingMethod_name_fk){
        List<Bill> BillList = new ArrayList<>();
        IBillDAO dao = new BillDAOImpl();
        BillList = dao.getBillByPayingMethod(PayingMethod_name_fk);
        view.ViewBills(BillList);
        return BillList;
    }
    public Bill getBillById(int idBill){
        Bill bill = new Bill();
        IBillDAO dao = new BillDAOImpl();
        bill = dao.getBillById(idBill);
        view.ViewBills(bill);
        return bill;
    }
    public Bill getBillByBuyOrder(int Buy_order_id_fk){
        Bill bill = new Bill();
        IBillDAO dao = new BillDAOImpl();
        bill = dao.getBillByBuyOrder(Buy_order_id_fk);
        view.ViewBills(bill);
        return bill;
    }
    // --- UPDATE
    public void update(Bill bill){
        IBillDAO dao = new BillDAOImpl();
        dao.update(bill);
    }
    // --- DELETE
    public void delete(Bill bill){
        IBillDAO dao = new BillDAOImpl();
        dao.delete(bill);
    }
}
