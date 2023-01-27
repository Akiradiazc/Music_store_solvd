package Views;

import Model.Store;
import java.util.List;

public class ViewStore {
    public void ViewStores(Store store){
        System.out.println("Store Info: "+ store);
    }
    public void ViewStores(List<Store> StoresList){
        for(Store store: StoresList){
            System.out.println("Store Info: "+ store);
        }
    }
}
