package Views;

import Model.Paying_method;

import java.util.List;

public class ViewPaying_Method {
    public void ViewPaying_methods(Paying_method paying_method){
        System.out.println("Paying Method Info: "+paying_method);
    }
    public void ViewPaying_methods(List<Paying_method> payingMethodList){
        for (Paying_method payingMethod :payingMethodList){
            System.out.println("Paying Method Info: "+payingMethod);
        }
    }
}