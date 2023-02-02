package Views;

import java.util.List;
import Model.Stock;

public class ViewStock {
    public void ViewStocks(Stock stock){
        System.out.println("Stock Info: "+ stock);
    }
    public void ViewStocks(List<Stock> StockList){
        for(Stock stock:StockList){
            System.out.println("Stock Info: "+stock);
        }
    }
}
