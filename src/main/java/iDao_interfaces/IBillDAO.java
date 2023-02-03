package iDao_interfaces;

import Model.Bill;

import java.util.List;
import java.util.Date;

public interface IBillDAO {
    // --- CREATE
    boolean create(Bill bill);
    // --- READ
    List<Bill> getAllBill();
    List<Bill> getBillByDate(Date date);
    List<Bill> getBillByClient(int Client_id_fk);
    List<Bill> getBillByEmployee(int Employee_id_fk);
    List<Bill> getBillByPayingMethod(String PayingMethod_name_fk);
    Bill getBillById(int idBill);
    Bill getBillByBuyOrder(int Buy_order_id_fk);
    // --- UPDATE
    boolean update(Bill bill);
    // --- DELETE
    boolean delete(Bill bill);
}
