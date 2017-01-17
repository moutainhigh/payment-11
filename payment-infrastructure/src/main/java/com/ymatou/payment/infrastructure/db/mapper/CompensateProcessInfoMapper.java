package com.ymatou.payment.infrastructure.db.mapper;

import com.ymatou.payment.infrastructure.db.model.CompensateProcessInfoExample;
import com.ymatou.payment.infrastructure.db.model.CompensateProcessInfoPo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompensateProcessInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int countByExample(CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int deleteByExample(CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int deleteByPrimaryKey(Long compensateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int insert(CompensateProcessInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int insertSelective(CompensateProcessInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    List<CompensateProcessInfoPo> selectByExampleWithBLOBs(CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    List<CompensateProcessInfoPo> selectByExample(CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    CompensateProcessInfoPo selectByPrimaryKey(Long compensateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") CompensateProcessInfoPo record, @Param("example") CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") CompensateProcessInfoPo record, @Param("example") CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByExample(@Param("record") CompensateProcessInfoPo record, @Param("example") CompensateProcessInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByPrimaryKeySelective(CompensateProcessInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(CompensateProcessInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByPrimaryKey(CompensateProcessInfoPo record);
}