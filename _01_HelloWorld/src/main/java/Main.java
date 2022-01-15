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
//            UserPO user = sqlSession.selectOne("selectUser", new UserPO(1,"22",4));//会去自动调用getId，没有则报错
            UserPO user = sqlSession.selectOne("selectUser", 1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }

    }








}
