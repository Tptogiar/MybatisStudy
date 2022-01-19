
import com.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.pojo.po.UserPO;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:56
 */
public class Main {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testHelloWorld() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserPO userPO = mapper.getUserById(1);
            System.out.println(userPO);
        } finally {
            sqlSession.close();
        }

    }








}
