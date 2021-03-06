package MyBatis3.dao;

import MyBatis3.po.UserPO;
import MyBatis3.po.UserPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    long countByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int deleteByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int insert(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int insertSelective(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    List<UserPO> selectByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    UserPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int updateByPrimaryKeySelective(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 19 18:51:26 CST 2022
     */
    int updateByPrimaryKey(UserPO record);
}