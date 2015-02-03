package csee.narasarang.projmaker.DAO;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {

    public static SqlSessionFactory sqlSession;
    static {
        String resources = "Configuration.xml";
        Reader reader;
        
        try {
            reader = Resources.getResourceAsReader(resources);
            sqlSession = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static SqlSessionFactory getSqlSession() {
        return sqlSession;
    }
}
