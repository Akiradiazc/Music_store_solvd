package JAXBHandlers;

import Model.Paying_method;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "Paying_methods")
public class Paying_methodHandler {
    private Set<Paying_method> PayingMethodList = new HashSet<>();
    public Set<Paying_method> getPayingMethodList(){
        return PayingMethodList;
    }

    @XmlElement(name="Paying_method")
    public void setPayingMethodList(Set<Paying_method> PayingMethodList){
        this.PayingMethodList = PayingMethodList;
    }
}
