/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * This <code>ResponseEntity</code> class is used to store the parser results.
 * 
 * @author liangmanman
 * 
 */
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = 7546488801256204761L;

    /*
     * Define the return code for parsing json worker.0 represents correct,1
     * represents error. Please refer to RETCODE_ERROR and RETCODE_CORRECT which
     * are defined in ConstantUtil class.
     */
    private int retCode;

    /* Define the response code for executing the http request. */
    private short responseCode = 0;

    /* Define the return message for parsing json worker. */
    private String retMsg;

    /* Define the response time for executing the http request.unit: second. */
    private double responseTime = -1d;

    /* Define the response headers for executing the http request. */
    private Map<Object, Object> responseHeader = null;

    /*
     * Define the string type of http response content.Please refer to
     * STRING_TYPE_JSON,STRING_TYPE_XML,STRING_TYPE_HTML_TEXT in ConstantUtil
     * class.
     */
    private String onlineResultType;

    /*
     * Define the response content.
     */
    private String responseContent;

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getOnlineResultType() {
        return onlineResultType;
    }

    public void setOnlineResultType(String onlineResultType) {
        this.onlineResultType = onlineResultType;
    }

    public Map<Object, Object> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Map<Object, Object> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public short getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(short responseCode) {
        this.responseCode = responseCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    @Override
    public String toString() {
        return "ResponseEntity [retCode=" + retCode + ", responseCode=" + responseCode
                + ", retMsg=" + retMsg + ", responseTime=" + responseTime + ", responseHeader="
                + responseHeader + ", onlineResultType=" + onlineResultType + ", responseContent="
                + responseContent + "]";
    }

}
