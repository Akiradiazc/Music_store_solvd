package JAXBHandlers;

import Model.Bill;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "Bills")
public class BillHandler {
    private Set<Bill> BillSet = new HashSet<>();
    public Set<Bill> getBillSet(){
        return BillSet;
    }

    @XmlElement(name="Bill")
    public void setBillSet(Set<Bill> BillSet){
        this.BillSet = BillSet;
    }

}
