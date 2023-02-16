package Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Languages {
    private int idLanguages;
    private String Language_name;
    public Languages(){}
    public Languages(String Language_name){
        this.idLanguages = idLanguages;
        this.Language_name = Language_name;
    }
    public Languages(int idLanguages, String Language_name){
        this.idLanguages = idLanguages;
        this.Language_name = Language_name;
    }

    public int getIdLanguages() {
        return idLanguages;
    }

    public void setIdLanguages(int idLanguages) {
        this.idLanguages = idLanguages;
    }

    public String getLanguage_name() {
        return Language_name;
    }

    public void setLanguage_name(String language_name) {
        Language_name = language_name;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "idLanguages=" + idLanguages +
                ", Language_name='" + Language_name + '\'' +
                '}';
    }
}
