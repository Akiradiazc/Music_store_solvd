package JAXBHandlers;

import Model.Languages;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "Languages")
public class LanguagesHandler {
    private Set<Languages> LanguageList = new HashSet<Languages>();
    public Set<Languages> getLanguageList(){
        return LanguageList;
    }

    @XmlElement(name="Language")
    public void setLanguageList(Set<Languages> LanguageList){
        this.LanguageList = LanguageList;
    }
}
