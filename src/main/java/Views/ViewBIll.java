package Views;
import Model.Bill;
import java.util.List;

public class ViewBIll {
    public void ViewBills(Bill bill){
        System.out.println("Bill Info: "+bill);
    }
    public void ViewBills(List<Bill> BillList){
        for(Bill bill:BillList){
            System.out.println("Bill Info: "+bill);
        }
    }
}
