package com.ymatou.payment.infrastructure.db.model;

public class RefundMiscRequestLogWithBLOBs extends RefundMiscRequestLogPo {
    /**
     * CLOB(2147483647) 必填<br>
     * 
     */
    private String requestData;

    /**
     * CLOB(2147483647)<br>
     * 
     */
    private String responseData;

    /**
     * CLOB(2147483647)<br>
     * 
     */
    private String exceptionDetail;

    /**
     * CLOB(2147483647) 必填<br>
     */
    public String getRequestData() {
        return requestData;
    }

    /**
     * CLOB(2147483647) 必填<br>
     */
    public void setRequestData(String requestData) {
        this.requestData = requestData == null ? null : requestData.trim();
    }

    /**
     * CLOB(2147483647)<br>
     */
    public String getResponseData() {
        return responseData;
    }

    /**
     * CLOB(2147483647)<br>
     */
    public void setResponseData(String responseData) {
        this.responseData = responseData == null ? null : responseData.trim();
    }

    /**
     * CLOB(2147483647)<br>
     */
    public String getExceptionDetail() {
        return exceptionDetail;
    }

    /**
     * CLOB(2147483647)<br>
     */
    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RefundMiscRequestLog
     *
     * @mbggenerated Tue Jan 17 09:37:41 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requestData=").append(requestData);
        sb.append(", responseData=").append(responseData);
        sb.append(", exceptionDetail=").append(exceptionDetail);
        sb.append("]");
        return sb.toString();
    }
}