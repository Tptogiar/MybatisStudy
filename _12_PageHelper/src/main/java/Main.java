import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.po.UserPO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/15 - 10:56
 */
public class Main {


    @Test
    public void testUser() throws IOException {
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



    @Test
    public void testPageHelper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            PageHelper.startPage(2,5);
            List<UserPO> users = mapper.getUsers();
            System.out.println("\n\n");
            for (UserPO user : users) {
                System.out.println(user);
            }
            System.out.println("\n\n");

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testPageInfo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserPO> users = mapper.getUsers();
            PageInfo<UserPO> userPOPageInfo = new PageInfo<>(users);

            System.out.println("\n\n");
            for (UserPO user : users) {
                System.out.println(user);
            }
            System.out.println("\n\n");
            System.out.println(userPOPageInfo.getTotal());
            System.out.println("\n\n");

        } finally {
            sqlSession.close();
        }
    }



    @Test
    public void testPageInfoNavigatepage() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            PageHelper.startPage(4,2);
            List<UserPO> users = mapper.getUsers();
            PageInfo<UserPO> userPOPageInfo = new PageInfo<>(users,3);
            System.out.println("\n\n");
            for (UserPO user : users) {
                System.out.println(user);
            }
            System.out.println("\n\n");
            System.out.println(Arrays.toString(userPOPageInfo.getNavigatepageNums()));
            System.out.println("\n\n");

        } finally {
            sqlSession.close();
        }
    }

}
