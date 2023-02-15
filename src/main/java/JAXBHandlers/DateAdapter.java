package JAXBHandlers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd";

    @Override
    public Date unmarshal(String s) throws Exception {
        return (Date) new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(s);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(date);
    }
}
