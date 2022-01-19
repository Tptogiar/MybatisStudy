import MyBatis3.dao.UserPOMapper;
import MyBatis3.po.UserPO;
import MyBatis3.po.UserPOExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/19 - 17:51
 */
public class Main {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testMybatisGenerator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("C:\\MyFiles\\CodeFile\\Study\\JAVA\\Study\\MybatisStudy\\Demos\\MybatisStudy\\_09_MybatisGenerator\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }




    @Test
    public void testMybatis3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserPOMapper userPOMapper = sqlSession.getMapper(UserPOMapper.class);
        long l = userPOMapper.countByExample(new UserPOExample());
        System.out.println(l);
        UserPOExample example=new UserPOExample();
//        Criteria：用于瓶装查询条件
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andAgeBetween(1,100);


        List<UserPO> userPOS = userPOMapper.selectByExample(example);
        System.out.println(Arrays.toString(userPOS.toArray()));
    }

    @Test
    public void testMybatis3Simple() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MyBatis3Simple.dao.UserPOMapper mapper = sqlSession.getMapper(MyBatis3Simple.dao.UserPOMapper.class);

    }


}
