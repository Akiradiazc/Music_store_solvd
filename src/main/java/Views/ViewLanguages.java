package Views;

import Model.Languages;

import java.util.List;

public class ViewLanguages {
    public void ViewLanguage(Languages language){
        System.out.println("Language Info: "+language);
    }
    public void ViewLanguage(List<Languages> languageList){
        for (Languages language : languageList){
            System.out.println("Country Info: "+language);
        }
    }
}