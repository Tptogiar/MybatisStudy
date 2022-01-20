import dao.UserMapper;
import pojo.po.UserPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.po.UserPO;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:56
 */
public class Main {


    @Test
    public void testHelloWorld() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
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
