import com.dao.UserMapper;
import com.pojo.po.UserPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:56
 */
public class Main {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }




    @Test
    public void testBatch() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //可以执行批量操作的sqlSession
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        long start = System.currentTimeMillis();
        try{
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            for (int i = 0; i < 10000*500; i++){
                UserPO userPO = new UserPO(UUID.randomUUID().toString().substring(1, 5), (int) (Math.random() * 100));
                mapper.insertOne(userPO);
            }
            openSession.commit();
            long end = System.currentTimeMillis();
            //批量：（预编译sql一次==>设置参数===>10000次===>执行（1次））
            //Parameters: 616c1(String), b(String), 1(String)==>4598
            //非批量：（预编译sql=设置参数=执行）==》10000    10200
            System.out.println("执行时长："+(end-start));
        }finally{
            openSession.close();
        }

    }






}
