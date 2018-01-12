/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * This <code>RequestEntity</code> class is used to store the http request
 * parameters.
 * 
 * @author liangmanman
 * 
 */
public class RequestEntity implements Serializable {

    private static final long serialVersionUID = 7529629173907008963L;

    /* Define the http request type */
    private String requestType;

    /* Define the online http request url */
    private String requestUrl;

    /* Define the http request parameters */
    private Map<Object, Object> requestParams;

    /* Define the http header parameters */
    private Map<Object, Object> headerParams;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Map<Object, Object> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Map<Object, Object> requestParams) {
        this.requestParams = requestParams;
    }

    public Map<Object, Object> getHeaderParams() {
        return headerParams;
    }

    public void setHeaderParams(Map<Object, Object> headerParams) {
        this.headerParams = headerParams;
    }

}
