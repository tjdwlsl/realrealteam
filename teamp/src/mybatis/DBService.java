package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBService {
    private static SqlSessionFactory factory;
    static String resource = "mybatis/config.xml";

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
        }
    }
    // DAO에서 factory를 호출할 메서드
    public static SqlSessionFactory getFactory() {
        return factory;
    }
}