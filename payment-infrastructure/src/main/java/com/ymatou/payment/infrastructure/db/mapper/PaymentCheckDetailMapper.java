package com.ymatou.payment.infrastructure.db.mapper;

import com.ymatou.payment.infrastructure.db.model.PaymentCheckDetailExample;
import com.ymatou.payment.infrastructure.db.model.PaymentCheckDetailPo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentCheckDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int countByExample(PaymentCheckDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int deleteByExample(PaymentCheckDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int insert(PaymentCheckDetailPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int insertSelective(PaymentCheckDetailPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    List<PaymentCheckDetailPo> selectByExample(PaymentCheckDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    PaymentCheckDetailPo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") PaymentCheckDetailPo record, @Param("example") PaymentCheckDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByExample(@Param("record") PaymentCheckDetailPo record, @Param("example") PaymentCheckDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByPrimaryKeySelective(PaymentCheckDetailPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_PaymentCheckDetail
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    int updateByPrimaryKey(PaymentCheckDetailPo record);
}