package simpleBatis;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// read the myBatisConfig.xml, generate a SqlSessionFactory first, then use the factory to generate session.
public class MySessionFactory{
    public static SqlSessionFactory buildTheFactory() {
            SqlSessionFactory sqlSessionFactory = null;
//            URL u = URLHelper.newExtendedURL("log4j.xml");
//            DOMConfigurator.configureAndWatch(u.getPath());
//            DOMConfigurator.configure("log4j.xml");
        try {
            String resource = "myBatisConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory; 
    } 
}
