package com.ymatou.payment.infrastructure.db.model;

public class RefundrequestWithBLOBs extends RefundrequestPo {
    /**
     * BINARY(8) 必填<br>
     * 
     */
    private byte[] dataversion;

    /**
     * CLOB(2147483647)<br>
     * 
     */
    private String memo;

    /**
     * BINARY(8) 必填<br>
     */
    public byte[] getDataversion() {
        return dataversion;
    }

    /**
     * BINARY(8) 必填<br>
     */
    public void setDataversion(byte[] dataversion) {
        this.dataversion = dataversion;
    }

    /**
     * CLOB(2147483647)<br>
     */
    public String getMemo() {
        return memo;
    }

    /**
     * CLOB(2147483647)<br>
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RefundRequest
     *
     * @mbggenerated Wed May 04 11:33:50 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataversion=").append(dataversion);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}