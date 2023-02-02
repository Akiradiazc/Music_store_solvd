package Views;
import java.util.List;
import Model.Buy_order;

public class ViewBuy_order {
    public void ViewBuy_orders(Buy_order buy_order){
        System.out.println("Buy order info: "+buy_order);
    }
    public void ViewBuy_orders(List<Buy_order> buy_orderList){
        for (Buy_order buy_order: buy_orderList){
            System.out.println("Buy order info: "+buy_order);
        }
    }
}
