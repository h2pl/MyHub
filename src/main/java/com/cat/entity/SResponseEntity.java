/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * This class is defined the response format for console.
 * 
 * @author jiangzhixiang
 *
 */
public class SResponseEntity implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 6665373303767723885L;
    private int retCode;
    private String retMsg;
    private Map<?, ?> retData;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Map<?, ?> getRetData() {
        return retData;
    }

    public void setRetData(Map<?, ?> retData) {
        this.retData = retData;
    }

}
