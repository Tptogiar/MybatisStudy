import com.dao.EmployeeMapper;
import com.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.pojo.po.Employee;

import java.io.IOException;
import java.io.InputStream;

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
    public void addEmp() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Long aLong = mapper.addEmp(new Employee("last1", "252@", "sd"));
            sqlSession.commit();
            System.out.println(aLong);
        } finally {
            sqlSession.close();
        }
    }








}
