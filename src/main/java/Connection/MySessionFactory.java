package Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MySessionFactory {
    private static MySessionFactory instance;
    private SqlSessionFactory factory;

    private MySessionFactory(){
        String resource = "mybatis-config.xml";
        Reader reader = null;

        try{
            reader = Resources.getResourceAsReader(resource);
            factory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static MySessionFactory getInstance(){
        if (instance == null){
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory(){
        return factory;
    }

}
