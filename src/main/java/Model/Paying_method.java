package Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Paying_method {
    private int idPaying_method;
    private String Paying_method_name;
    public Paying_method(){}
    public Paying_method(String Paying_method_name){
        this.idPaying_method = idPaying_method;
        this.Paying_method_name = Paying_method_name;
    }
    public Paying_method(int idPaying_method, String Paying_method_name){
        this.idPaying_method = idPaying_method;
        this.Paying_method_name = Paying_method_name;
    }

    public int getIdPaying_method() {
        return idPaying_method;
    }

    public void setIdPaying_method(int idPaying_method) {
        this.idPaying_method = idPaying_method;
    }

    public String getPaying_method_name() {
        return Paying_method_name;
    }

    public void setPaying_method_name(String paying_method_name) {
        Paying_method_name = paying_method_name;
    }

    @Override
    public String toString() {
        return "Paying_method{" +
                "idPaying_method=" + idPaying_method +
                ", Paying_method_name='" + Paying_method_name + '\'' +
                '}';
    }
}
